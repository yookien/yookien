<%@ taglib prefix="s" uri="/struts-tags"%>
<form onSubmit="return false;">
	<span title="记录总数" style="padding: 0px 4px;">记录总数: <strong>${pagination.totalRecord}</strong></span><span style="padding: 0px 4px;"><strong><s:if test="pagination.start == 0">1</s:if><s:else>${pagination.start/pagination.offset+1}</s:else></strong>/<strong>${pagination.totalPage}</strong>页</span>
    <span style="padding: 0px 4px;"><a href="javascript:doPagination(0);"><img src="/demo/images/first.gif" alt="首页"/></a></span>
    <s:iterator value="pagination.totalPage" id = "i">
    	<a href="javascript:doPagination(<s:if test="pagination.start=(i-1)">0</s:if><s:else>${(i-1)*pagination.offset}</s:else>);" title="第${i}页" style="padding:0px 2px;"><s:if test="pagination.start=((i-1)*pagination.offset)"><strong style="color:red">${i}</strong></s:if><s:else>${i}</s:else></a>
    </s:iterator>
	<span style="padding: 0px 4px;"><a href="javascript:doPagination(${(pagination.totalPage-1)*pagination.offset});" title="尾页"><img src="/demo/images/last.gif" alt="尾页"/></a></span>	    
	<input type="text" id="pager" name="pager" size="1" value="" class="t" />
    <input type="button" value="GO" name="search" class="tb" onClick="isRightPager(${pagination.totalPage},${pagination.offset});"/>
</form>
