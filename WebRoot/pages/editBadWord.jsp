<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>过滤词管理-修改过滤词</title>
<link rel="stylesheet" href="${base}/css/default.css" type="text/css" media="all"/>
<script type="text/javascript" src="${base}/js/prototype.js"></script>
<script type="text/javascript" src="${base}/js/validator.js"></script>
<script type="text/javascript">
	//<![CDATA[	
	window.onload = function(){		
	}
	
	function doEditBadWord(){

		if(!Validator.validate($("badWordForm"),'badWord')){
			return false;
		}

		var pars = Form.serialize($("badWordForm"));
		new Ajax.Request( "${base}/admin/updateBadWord.do", { method:'post', parameters: pars, onComplete:completeEdit } );
		return false;
	}
	
	function completeEdit(originalRequest){
		alert(originalRequest.responseText);
		if( opener != null ){
		   opener.doSearchBadWords();
		}
		window.opener=null;window.close();
	}	
	
	//]]>
</script>
</head>
<body>
   <br/>
  <table cellspacing="0" align="center" class="mtable">
    <form action="" method="post" id="badWordForm" onSubmit="return doEditBadWord();">
      <input type="hidden" name="badWordId" value="${badWord.badWordId}"/>
      <tr>
        <td colspan="2" class="mt">修改过滤词</td>
      </tr>
      <tr>
        <td class="mtdt" style="width:30%;">【原  词】</td>
        <td class="mtdv"><input name="badWord" type="text" value="${badWord.badWord}" class="t"/> </td>
      </tr>
	  <tr>
        <td class="mtdt" style="width:30%;">【替换词】</td>
        <td class="mtdv"><input name="replaceWord" type="text" value="${badWord.replaceWord}" class="t"/></td>
      </tr>
      <tr>
        <td colspan="2" class="mtda"><input type="submit" name="" value="修  改" class="b"/></td>
      </tr>
    </form>
  </table>

</body>
</html>
