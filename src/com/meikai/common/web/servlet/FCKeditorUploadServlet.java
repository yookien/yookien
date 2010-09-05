/*
 * FCKeditor - The text editor for internet
 * Copyright (C) 2003-2005 Frederico Caldeira Knabben
 * 
 * Licensed under the terms of the GNU Lesser General Public License:
 * 		http://www.opensource.org/licenses/lgpl-license.php
 * 
 * For further information visit:
 * 		http://www.fckeditor.net/
 * 
 * File Name: SimpleUploaderServlet.java
 * 	Java File Uploader class.
 * 
 * Version:  2.3
 * Modified: 2005-08-11 16:29:00
 * 
 * File Authors:
 * 		Simone Chiaretta (simo@users.sourceforge.net)
 */ 
 
package com.meikai.common.web.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


import org.apache.commons.fileupload.*;
import org.apache.log4j.Logger;


import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult; 

/**
 * Servlet to upload files.<br>
 *
 * This servlet accepts just file uploads, eventually with a parameter specifying file type
 *
 * @author Simone Chiaretta (simo@users.sourceforge.net)
 */

public class FCKeditorUploadServlet extends HttpServlet {
	
	private final static Logger logger = Logger.getLogger(FCKeditorUploadServlet.class);
	
	private static String baseDir;
	private static boolean debug=false;
	private static boolean enabled=false;
	private static Hashtable allowedExtensions;
	private static Hashtable deniedExtensions;
	
	/**
	 * Initialize the servlet.<br>
	 * Retrieve from the servlet configuration the "baseDir" which is the root of the file repository:<br>
	 * If not specified the value of "/UserFiles/" will be used.<br>
	 * Also it retrieve all allowed and denied extensions to be handled.
	 *
	 */
	 public void init() throws ServletException {
	 	
	 	debug=(new Boolean(getInitParameter("debug"))).booleanValue();
	 	
		baseDir=getInitParameter("baseDir");
		enabled=(new Boolean(getInitParameter("enabled"))).booleanValue();
		if(baseDir==null)
			baseDir="/UserFiles/";
		String realBaseDir=getServletContext().getRealPath(baseDir);
		File baseFile=new File(realBaseDir);
		if(!baseFile.exists()){
			baseFile.mkdir();
		}
		
		allowedExtensions = new Hashtable(3);
		deniedExtensions = new Hashtable(3);
				
		allowedExtensions.put("File",FckeditorUtil.stringToArrayList(getInitParameter("AllowedExtensionsFile")));
		deniedExtensions.put("File",FckeditorUtil.stringToArrayList(getInitParameter("DeniedExtensionsFile")));

		allowedExtensions.put("Image",FckeditorUtil.stringToArrayList(getInitParameter("AllowedExtensionsImage")));
		deniedExtensions.put("Image",FckeditorUtil.stringToArrayList(getInitParameter("DeniedExtensionsImage")));
		
		allowedExtensions.put("Flash",FckeditorUtil.stringToArrayList(getInitParameter("AllowedExtensionsFlash")));
		deniedExtensions.put("Flash",FckeditorUtil.stringToArrayList(getInitParameter("DeniedExtensionsFlash")));
		
	}
	
	 
	/**
	 * Manage the Upload requests.<br>
	 *
	 * The servlet accepts commands sent in the following format:<br>
	 * simpleUploader?Type=ResourceType<br><br>
	 * It store the file (renaming it in case a file with the same name exists) and then return an HTML file
	 * with a javascript command in it.
	 *
	 */	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (debug) System.out.println("--- BEGIN DOPOST ---");

		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control","no-cache");
		
		PrintWriter out = response.getWriter();
		// edit check user uploader file size
		int contextLength = request.getContentLength();
        int fileSize = (int)(((float)contextLength)/((float)(1024)));

		String retVal="0";
		String newName="";
		String fileUrl="";
		String errorMessage="";
		
        if(fileSize<30240){
	
			String typeStr=request.getParameter("Type");
			
			String currentPath = "";
			String currentDirPath=getServletContext().getRealPath(currentPath);
			currentPath=request.getContextPath()+currentPath;
			// edit end ++++++++++++++++	
			if (debug) System.out.println(currentDirPath);
			
			if(enabled) {		
				DiskFileUpload upload = new DiskFileUpload();
				try {
					List items = upload.parseRequest(request);
					
					Map fields=new HashMap();
					
					Iterator iter = items.iterator();
					while (iter.hasNext()) {
					    FileItem item = (FileItem) iter.next();
					    if (item.isFormField())
					    	fields.put(item.getFieldName(),item.getString());
					    else
					    	fields.put(item.getFieldName(),item);
					}
					FileItem uplFile=(FileItem)fields.get("NewFile");
					String fileNameLong=uplFile.getName();
					fileNameLong=fileNameLong.replace('\\','/');
					String[] pathParts=fileNameLong.split("/");
					String fileName=pathParts[pathParts.length-1];
					
					String nameWithoutExt=FckeditorUtil.getNameWithoutExtension(fileName);
					String ext=FckeditorUtil.getExtension(fileName);
					File pathToSave=new File(currentDirPath,fileName);
					fileUrl=currentPath+"/"+fileName;
					if(FckeditorUtil.extIsAllowed(allowedExtensions,deniedExtensions,typeStr,ext)) {
						int counter=1;
						while(pathToSave.exists()){
							newName=nameWithoutExt+"("+counter+")"+"."+ext;
							fileUrl=currentPath+"/"+newName;
							retVal="201";
							pathToSave=new File(currentDirPath,newName);
							counter++;
						}
						uplFile.write(pathToSave);
						
						// 记录上传的信息
						if(logger.isInfoEnabled()){
							logger.info("记录用户上传的文件...");
						}
					}
					else {
						retVal="202";
						errorMessage="";
						if (debug) System.out.println("Invalid file type: " + ext);	
					}
				}catch (Exception ex) {
					if (debug) ex.printStackTrace();
					retVal="203";
				}
			}
			else {
				retVal="1";
				errorMessage="This file uploader is disabled. Please check the WEB-INF/web.xml file";
			}
			
        }
        else{
        	retVal = "204";
        }
		out.println("<script type=\"text/javascript\">");
		out.println("window.parent.OnUploadCompleted("+retVal+",'"+fileUrl+"','"+newName+"','"+errorMessage+"');");
		out.println("</script>");
		out.flush();
		out.close();
	
		if (debug) System.out.println("--- END DOPOST ---");	
		
	}






}

