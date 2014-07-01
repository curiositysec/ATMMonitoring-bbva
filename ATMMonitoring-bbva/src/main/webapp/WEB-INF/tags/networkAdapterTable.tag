 <%@tag description="Network Adapter Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3 class="txt content_hide"><spring:message code="label.networkAdapters"/></h3>

<div class="margin-box collapsible hide">

<table class="data subform link">
<tr>
	<th><spring:message code="label.hardwareDevice.name"/></th>
	<th><spring:message code="label.hardwareDevice.manufacturer"/></th>
	<th><spring:message code="label.hardwareDevice.adapterType"/></th>
	<th><spring:message code="label.hardwareDevice.caption"/></th>
	<th><spring:message code="label.hardwareDevice.description"/></th>
	<th><spring:message code="label.hardwareDevice.dhcpEnabled"/></th>
	<th><spring:message code="label.hardwareDevice.dhcpServer"/></th>
	<th><div class="add"><span>Ver más información</span></div></th>
<!--
	<th><spring:message code="label.hardwareDevice.ipAddress"/></th>
	<th><spring:message code="label.hardwareDevice.ipSubnet"/></th>
	<th><spring:message code="label.hardwareDevice.defaultIpGateway"/></th>
	<th><spring:message code="label.hardwareDevice.macAddress"/></th>
	<th><spring:message code="label.hardwareDevice.speed"/></th>
	<th><spring:message code="label.hardwareDevice.netConnectionId"/></th>
	<th><spring:message code="label.hardwareDevice.netConnectionStatus"/></th>
	<th><spring:message code="label.hardwareDevice.interfaceIndex"/></th>
	<th><spring:message code="label.hardwareDevice.status"/></th>
-->
</tr>
<c:forEach items="${hardwareDevices}" var="hardwareDevice">
    <tr class="showdetail open">
    	<c:if test="${hardwareDevice.name != null}">
			<td>${hardwareDevice.name}</td>
		</c:if>
		<c:if test="${hardwareDevice.name == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.manufacturer != null}">
			<td>${hardwareDevice.manufacturer}</td>
		</c:if>
		<c:if test="${hardwareDevice.manufacturer == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.adapterType != null}">
			<td>${hardwareDevice.adapterType}</td>
		</c:if>
		<c:if test="${hardwareDevice.adapterType == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.caption != null}">
			<td>${hardwareDevice.caption}</td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.description != null}">
			<td>${hardwareDevice.description}</td>
		</c:if>
		<c:if test="${hardwareDevice.description == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.dhcpEnabled != null}">
			<td>${hardwareDevice.dhcpEnabled}</td>
		</c:if>
		<c:if test="${hardwareDevice.dhcpEnabled == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.dhcpServer != null}">
			<td>${hardwareDevice.dhcpServer}</td>
		</c:if>
		<c:if test="${hardwareDevice.dhcpServer == null}">
			<td/>
		</c:if>
<%--		
    	<c:if test="${hardwareDevice.ipAddress != null}">
			<td>${hardwareDevice.ipAddress}</td>
		</c:if>
		<c:if test="${hardwareDevice.ipAddress == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.ipSubnet != null}">
			<td>${hardwareDevice.ipSubnet}</td>
		</c:if>
		<c:if test="${hardwareDevice.ipSubnet == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.defaultIpGateway != null}">
			<td>${hardwareDevice.defaultIpGateway}</td>
		</c:if>
		<c:if test="${hardwareDevice.defaultIpGateway == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.macAddress != null}">
			<td>${hardwareDevice.macAddress}</td>
		</c:if>
		<c:if test="${hardwareDevice.macAddress == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.speed != null}">
			<td>${hardwareDevice.speed}</td>
		</c:if>
		<c:if test="${hardwareDevice.speed == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.netConnectionId != null}">
			<td>${hardwareDevice.netConnectionId}</td>
		</c:if>
		<c:if test="${hardwareDevice.netConnectionId == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.netConnectionStatus != null}">
			<td>${hardwareDevice.netConnectionStatus}</td>
		</c:if>
		<c:if test="${hardwareDevice.netConnectionStatus == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.interfaceIndex != null}">
			<td>${hardwareDevice.interfaceIndex}</td>
		</c:if>
		<c:if test="${hardwareDevice.interfaceIndex == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.status != null}">
			<td>${hardwareDevice.status}</td>
		</c:if>
		<c:if test="${hardwareDevice.status == null}">
			<td/>
		</c:if>
		
--%>
	<td><div class="add"><span>Ver más información</span></div></td>
    </tr>
    <tr class="detail">
    	<td colspan="8">
	    	<div>
		    	<ul>
		    	<c:if test="${hardwareDevice.name != null}">
					<li><strong><spring:message code="label.hardwareDevice.name"/>: </strong>${hardwareDevice.name}</li>
				</c:if>
				<c:if test="${hardwareDevice.name == null}">
					<li><strong><spring:message code="label.hardwareDevice.name"/>: </strong></li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.manufacturer != null}">
					<li><strong><spring:message code="label.hardwareDevice.manufacturer"/>:</strong> ${hardwareDevice.manufacturer}</li>
				</c:if>
				<c:if test="${hardwareDevice.manufacturer == null}">
					<li><strong><spring:message code="label.hardwareDevice.manufacturer"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.adapterType != null}">
					<li><strong><spring:message code="label.hardwareDevice.adapterType"/>:</strong> ${hardwareDevice.adapterType}</li>
				</c:if>
				<c:if test="${hardwareDevice.adapterType == null}">
					<li><strong><spring:message code="label.hardwareDevice.adapterType"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.caption != null}">
					<li><strong><spring:message code="label.hardwareDevice.caption"/>:</strong> ${hardwareDevice.caption}</li>
				</c:if>
				<c:if test="${hardwareDevice.caption == null}">
					<li><strong><spring:message code="label.hardwareDevice.caption"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.description != null}">
					<li><strong><spring:message code="label.hardwareDevice.description"/>:</strong> ${hardwareDevice.description}</li>
				</c:if>
				<c:if test="${hardwareDevice.description == null}">
					<li><strong><spring:message code="label.hardwareDevice.description"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.dhcpEnabled != null}">
					<li><strong><spring:message code="label.hardwareDevice.dhcpEnabled"/>:</strong> ${hardwareDevice.dhcpEnabled}</li>
				</c:if>
				<c:if test="${hardwareDevice.dhcpEnabled == null}">
					<li><strong><spring:message code="label.hardwareDevice.dhcpEnabled"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.dhcpServer != null}">
					<li><strong><spring:message code="label.hardwareDevice.dhcpServer"/>:</strong> ${hardwareDevice.dhcpServer}</li>
				</c:if>
				<c:if test="${hardwareDevice.dhcpServer == null}">
					<li><strong><spring:message code="label.hardwareDevice.dhcpServer"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.ipAddress != null}">
					<li><strong><spring:message code="label.hardwareDevice.ipAddress"/>:</strong> ${hardwareDevice.ipAddress}</li>
				</c:if>
				<c:if test="${hardwareDevice.ipAddress == null}">
					<li><strong><spring:message code="label.hardwareDevice.ipAddress"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.ipSubnet != null}">
					<li><strong><spring:message code="label.hardwareDevice.ipSubnet"/>:</strong> ${hardwareDevice.ipSubnet}</li>
				</c:if>
				<c:if test="${hardwareDevice.ipSubnet == null}">
					<li><strong><spring:message code="label.hardwareDevice.ipSubnet"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.defaultIpGateway != null}">
					<li><strong><spring:message code="label.hardwareDevice.defaultIpGateway"/>:</strong> ${hardwareDevice.defaultIpGateway}</li>
				</c:if>
				<c:if test="${hardwareDevice.defaultIpGateway == null}">
					<li><strong><spring:message code="label.hardwareDevice.defaultIpGateway"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.macAddress != null}">
					<li><strong><spring:message code="label.hardwareDevice.macAddress"/>:</strong> ${hardwareDevice.macAddress}</li>
				</c:if>
				<c:if test="${hardwareDevice.macAddress == null}">
					<li><strong><spring:message code="label.hardwareDevice.macAddress"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.speed != null}">
					<li><strong><spring:message code="label.hardwareDevice.speed"/>:</strong> ${hardwareDevice.speed}</li>
				</c:if>
				<c:if test="${hardwareDevice.speed == null}">
					<li><strong><spring:message code="label.hardwareDevice.speed"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.netConnectionId != null}">
					<li><strong><spring:message code="label.hardwareDevice.netConnectionId"/>:</strong> ${hardwareDevice.netConnectionId}</li>
				</c:if>
				<c:if test="${hardwareDevice.netConnectionId == null}">
					<li><strong><spring:message code="label.hardwareDevice.netConnectionId"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.netConnectionStatus != null}">
					<li><strong><spring:message code="label.hardwareDevice.netConnectionStatus"/>:</strong> ${hardwareDevice.netConnectionStatus}</li>
				</c:if>
				<c:if test="${hardwareDevice.netConnectionStatus == null}">
					<li><strong><spring:message code="label.hardwareDevice.netConnectionStatus"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.interfaceIndex != null}">
					<li><strong><spring:message code="label.hardwareDevice.interfaceIndex"/>:</strong> ${hardwareDevice.interfaceIndex}</li>
				</c:if>
				<c:if test="${hardwareDevice.interfaceIndex == null}">
					<li><strong><spring:message code="label.hardwareDevice.interfaceIndex"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.status != null}">
					<li><strong><spring:message code="label.hardwareDevice.status"/>:</strong> ${hardwareDevice.status}</li>
				</c:if>
				<c:if test="${hardwareDevice.status == null}">
					<li><strong><spring:message code="label.hardwareDevice.status"/>:</strong> </li>
				</c:if>
				</ul>
			</div>
		</td>
    </tr>
</c:forEach>
</table>

</div>
