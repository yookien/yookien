<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath(), basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>过滤词管理-新增过滤词</title>
<link rel="stylesheet" href="/demo/css/default.css" type="text/css" media="all"/>
<script type="text/javascript" src="/demo/js/prototype.js"></script>
<script type="text/javascript" src="/demo/js/validator/validator.js"></script>
<script type="text/javascript">
	//<![CDATA[	
	window.onload = function(){		
	}
	//]]>
</script>
</head>
<body>
   <br/>
  <table cellspacing="0" align="center" class="mtable">
    <form action="/demo/admin/createBadWord.do" method="post" id="badWordForm" onSubmit="return Validator.validate(this,'badWord');">
      <tr>
        <td colspan="2" class="mt">新增过滤词</td>
      </tr>
      <tr>
        <td class="mtdt" style="width:30%;">【原  词】</td>
        <td class="mtdv"><input type="text" name="badWord" value="" style="width:200px;" class="t"/></td>
      </tr>
	  <tr>
        <td class="mtdt" style="width:30%;">【替换词】</td>
        <td class="mtdv"><input type="text" name="replaceWord" value="" style="width:200px;" class="t"/></td>
      </tr>
      <tr>
        <td colspan="2" class="mtda"><input type="submit" name="" value="添 加" class="b"/></td>
      </tr>
    </form>
  </table>

</body>
</html>
