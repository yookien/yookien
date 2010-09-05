 <%@ taglib prefix="s" uri="/struts-tags"%>
 <table align="center" cellpadding="0" class="ltable" cellspacing="1">
 	<tr>
      <td colspan="7" class="lt">过滤词管理</td>
    </tr>
	<tr class="ltrt">
      <td width="40%">原词</td>
      <td width="40%">替换词</td>
      <td width="20%">操作</td>
    </tr>
    <s:iterator value="badWordList" status="status" >
    <tr class="ltrv">
      <td class="tl pl8">${badWord}</td>
      <td>${replaceWord}</td>
      <td>
        <input type="button" name="edit" title="修改" class="tb" value="修改" onClick="Util.openWindow('editBadWord.do?badWordId=${badWordId}',document.body.clientWidth-100,document.body.clientHeight-80);"/>
      	<input type="button" name="delete" title="删除" class="tb" value="删除" onClick="doDelete(${badWordId});"/>
	  </td>
    </tr>
    </s:iterator>
  </table>
  <div class="pagination">
    <div class="pg_right">
      <%@include file="/pages/lib/pagination.jsp"%>
    </div>
  </div>