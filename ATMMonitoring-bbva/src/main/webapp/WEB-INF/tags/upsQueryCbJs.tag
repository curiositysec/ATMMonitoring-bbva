<%@tag description="Terminal Config Software List" pageEncoding="UTF-8"%>
<%@attribute name="query" required="true" type="com.ncr.ATMMonitoring.pojo.UpsQuery"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${query.upsCombo11 != ''}">
   $('#upsCombo11').change();
</c:if>
<c:if test="${query.upsCombo12 != ''}">
   $('#upsCombo12').val('${query.upsCombo12}');
   $('#upsCombo12').change();
</c:if>
<c:if test="${query.upsCombo21 != ''}">
   $('#upsCombo21').change();
</c:if>
<c:if test="${query.upsCombo22 != ''}">
   $('#upsCombo22').val('${query.upsCombo22}');
   $('#upsCombo22').change();
</c:if>
<c:if test="${query.upsCombo31 != ''}">
   $('#upsCombo31').change();
</c:if>
<c:if test="${query.upsCombo32 != ''}">
   $('#upsCombo32').val('${query.upsCombo32}');
   $('#upsCombo32').change();
</c:if>
<c:if test="${query.upsCombo41 != ''}">
   $('#upsCombo41').change();
</c:if>
<c:if test="${query.upsCombo42 != ''}">
   $('#upsCombo42').val('${query.upsCombo42}');
   $('#upsCombo42').change();
</c:if>
<c:if test="${query.upsCombo51 != ''}">
   $('#upsCombo51').change();
</c:if>
<c:if test="${query.upsCombo52 != ''}">
   $('#upsCombo52').val('${query.upsCombo52}');
   $('#upsCombo52').change();
</c:if>