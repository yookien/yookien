package com.meikai.core.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meikai.core.util.Pagination;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action公共处理类
 * 
 * @author ntyookien
 * 
 * @version $Revision: 1.9 $ $Date: 2008/04/02 05:48:40 $
 */
public abstract class BasicActionSupport extends ActionSupport  {

	public static Logger logger = Logger.getLogger(sun.reflect.Reflection.getCallerClass(1)); 
	public static String CREATE = "create";
	public static String EDIT = "edit";
	public static String UPDATE = "update";
	public static String DELETE = "delete";
	public static String SELECT = "select";
	public static String INFO = "info";
	public static String WARN = "warn";
	public static String LIST = "list";
	public static String VIEW = "view";

	// 编号
	protected int id;
	public void setId(int id){
		this.id = id;
	}
	
	// 动作
	protected String action;
	public void setAction(String action){
		this.action = action;
	}
	
    /**
     * 取得request中parameter的值
     * @param parameter 参数
     * @return string 参数的值
     */
    protected String getParameter(String parameter) {
    	Object value = getParameters().get(parameter);
    	if(value!=null){
    		return ((String[])value)[0];
    	}
 		return "";
    }
  
	protected HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();  
    }
    
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
    
    /**
     * 取得request中parameter的值
     * @param parameter 参数
     * @return string 参数的值
     */
    protected String[] getParameterValues(String parameter) {
    	String[] values = this.getRequest().getParameterValues(parameter);
    	if(values!=null){
    		return values;
    	}
    	return new String[]{};
    }
    
    /**
     * 取得整型参数的值
     * @param parameter 参数
     * @return int 当前类别
     */
    protected int getIntParameter(String parameter){
    	Object value = getParameters().get(parameter);
    	if(value!=null){
    		try{
    			return Integer.parseInt(((String[])value)[0]);
    		}
    		catch(Exception e){
    			return 0;
    		}
    	}
 		return 0;    	
    }
    
    /**
     * 取得分页的起始页
     * @return
     */
    protected int getPaginationStart(){
    	return getIntParameter("start");
    }

    /**
     * 取得IP
     * @return
     */
    protected String getRemoteAddr() {
    	return getRequest().getRemoteAddr();
    }
    
    /**
     * 
     * @return
     */
    protected Map getParameters(){
        ActionContext actionContext = ActionContext.getContext();
    	Map parameters = (Map)actionContext.getParameters();    
    	return parameters;
    }
    
    /**
     * 取得web发布路径
     * @return 容器路径
     */
    public String getContextPath(){
    	return ServletActionContext.getServletContext().getRealPath("/");
    }
    

	/**
	 * 运用j2ee api将数据发给客户端
	 * 
	 * @param content
	 * @throws IOException
	 */
	protected void sendClient(String content) throws IOException
	{
		PrintWriter out = getResponseWriter();
		out.print(content);
		out.flush();
		out.close();
	}
	protected PrintWriter getResponseWriter() throws IOException
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		return response.getWriter();
	}
       
    /**
     * 返回值的定义
     */
    public String actionMessage;
	public String getActionMessage() {
		return actionMessage;
	}
	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}
	
    public String errorMessage;	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String warnMessage;
	public String getWarnMessage() {
		return warnMessage;
	}
	public void setWarnMessage(String warnMessage) {
		this.warnMessage = warnMessage;
	}	
	
	public String infoMessage;
	public String getInfoMessage() {
		return infoMessage;
	}
	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}	
	
    /**
     * 分页Bean的设置
     */
	private Pagination pagination = null;
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
}
