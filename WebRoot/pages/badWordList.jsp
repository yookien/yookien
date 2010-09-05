<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>过滤词管理</title>
<link rel="stylesheet" href="/demo/css/default.css" type="text/css" media="all"/>
<script type="text/javascript" src="/demo/js/prototype.js"></script>
<script type="text/javascript">

	var Util = {
		
		version : "1.0",
	
		show : function(elementId) {
			document.getElementById(elementId).style.display='block';
		},
	
		hidden : function(elementId) {
			document.getElementById(elementId).style.display='none';
		},
	
		openWindow : function(url, width, height) {
			var newWindow = window.open(url, new Date().getTime().toString(), "scrollbars=yes,resizable=yes,titlebar=yes,toolbar=no,menubar=no,status=no,location=no,top=0,left=0,left="+((screen.availWidth)/2-(width/2))+",top="+((screen.availHeight)/2-(height/2))+",width="+width+",height="+height);
			newWindow.focus();
		}
	}

	window.onload = function(){
		doSearchBadWords();
	}


	//　删除过滤词
	function doDelete( badWordId ) {
		if (confirm("确认要删除此过滤词?")){
			pars = "badWordId="+badWordId;
			new Ajax.Request( "${base}/admin/deleteBadWord.do", { method: 'get', parameters: pars, onComplete:completeDelete } );
		}
	}

	// 删除成功后执行
	function completeDelete(originalRequest){
		alert(originalRequest.responseText);
		doSearchBadWords();
	}	
	
	
	

	// 根据关键字查找
	function doSearchBadWords(){
		var pars = Form.serialize($("searchForm"))+"&"+Math.random()*1000;
		new Ajax.Updater('basWordList', "/demo/admin/ajax-badWordList.do" , { method:'post', parameters: pars, onComplete:completeSearch, evalScripts:true } );
		return false;
	}
		
	function completeSearch(originalRequest){
		// alert($("badWords").innerHTML);
		// alert("检索完成");
	}	
	
	// 分页检索
	function doPagination(start){
		//alert("start = " + start);
		// 设定起始页
		$("start").value = start;
		// 检索
		doSearchBadWords();
	}
			
	// 检索内容		
	function isRightPager( totalPage, range ){
		var pager = $F("pager");
		var RegExpNum = /^\d+$/;
		if(!RegExpNum.test(pager)){
			alert("请输入页数.");
			return;
		}
		if( pager < 1 ){
			alert("页数必须大于0");
			return;
		}
		else{
			if( pager > totalPage ){
				alert("您只能输入1~"+totalPage+"的数");
				return;
			}
		}
		doPagination((pager-1)*range);
	}
	
</script>
</head>
<body style="margin: 0px;padding:0px;">
<div id="wrap">
  <table align="center" cellpadding="0" class="ltable" cellspacing="1">
    <tr>
      <td colspan="2" class="lt">过滤词检索</td>
    </tr>
    <tr class="ltrv">
      <td style="text-align:left; padding-left:8px;" colspan="2">
      <form id="searchForm" method="post">
     请输入关键字 ：<input name="keyword" type="text" class="t" value="" style="width:200px;"/> 
        <input name="start" type="hidden" value="0" id="start"/>
        <input type="button" name="" onClick="doSearchBadWords();" class="b" value="检 索"/>
      </form>
      </td>
    </tr>
  </table>
  <div id="basWordList" style="margin-top:16px;margin-bottom:16px;">
  </div>
</div>
</body>
</html>
