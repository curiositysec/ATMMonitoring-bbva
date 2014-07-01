<%@tag description="Xfs Component Details" pageEncoding="UTF-8"%>
<%@attribute name="xfsComponent" required="true" type="com.ncr.ATMMonitoring.pojo.XfsComponent"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="main">
    <div id="primary">
<div class="box">
<h1><spring:message code="label.xfsComponentDetails"/></h1>

<div class="margin-box">
<table class="form-disabled-generic">
<c:if test="${xfsComponent.xfsClass != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.xfsClass"/></td>
<td>${xfsComponent.xfsClass}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.deviceName != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.deviceName"/></td>
<td>${xfsComponent.deviceName}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.acceptMedia != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.acceptMedia"/></td>
<td>${xfsComponent.acceptMedia}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.algorithms != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.algorithms"/></td>
<td>${xfsComponent.algorithms}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.autobeep != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.autobeep"/></td>
<td>${xfsComponent.autobeep}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.autodeposit != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.autodeposit"/></td>
<td>${xfsComponent.autodeposit}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.autoretractPeriod != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.autoretractPeriod"/></td>
<td>${xfsComponent.autoretractPeriod}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.auxiliaries != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.auxiliaries"/></td>
<td>${xfsComponent.auxiliaries}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.backImageColorFormat != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.backImageColorFormat"/></td>
<td>${xfsComponent.backImageColorFormat}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.backscanColor != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.backscanColor"/></td>
<td>${xfsComponent.backscanColor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.cameras != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.cameras"/></td>
<td>${xfsComponent.cameras}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.camdata != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.camdata"/></td>
<td>${xfsComponent.camdata}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.cards != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.cards"/></td>
<td>${xfsComponent.cards}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.cashin != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.cashin"/></td>
<td>${xfsComponent.cashin}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.charSupport != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.charSupport"/></td>
<td>${xfsComponent.charSupport}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.chipio != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.chipio"/></td>
<td>${xfsComponent.chipio}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.chipPower != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.chipPower"/></td>
<td>${xfsComponent.chipPower}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.chipProtocol != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.chipProtocol"/></td>
<td>${xfsComponent.chipProtocol}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.codeLineFormat != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.codeLineFormat"/></td>
<td>${xfsComponent.codeLineFormat}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.coins != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.coins"/></td>
<td>${xfsComponent.coins}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.compound != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.compound"/></td>
<td>${xfsComponent.compound}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.comparemagneticstripe != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.comparemagneticstripe"/></td>
<td>${xfsComponent.comparemagneticstripe}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.control != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.control"/></td>
<td>${xfsComponent.control}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.cursor != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.cursor"/></td>
<td>${xfsComponent.cursor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.cylinders != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.cylinders"/></td>
<td>${xfsComponent.cylinders}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.defaultBackscanColor != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.defaultBackscanColor"/></td>
<td>${xfsComponent.defaultBackscanColor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.defaultFrontscanColor != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.defaultFrontscanColor"/></td>
<td>${xfsComponent.defaultFrontscanColor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.deptransport != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.deptransport"/></td>
<td>${xfsComponent.deptransport}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.derivationAlgorithms != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.derivationAlgorithms"/></td>
<td>${xfsComponent.derivationAlgorithms}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isPrepareDispense != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isPrepareDispense"/></td>
<td>${xfsComponent.isPrepareDispense}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.dipMode != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.dipMode"/></td>
<td>${xfsComponent.dipMode}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.dispenseTo != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.dispenseTo"/></td>
<td>${xfsComponent.dispenseTo}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.display != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.display"/></td>
<td>${xfsComponent.display}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.displayLight != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.displayLight"/></td>
<td>${xfsComponent.displayLight}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.doors != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.doors"/></td>
<td>${xfsComponent.doors}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.ejectPosition != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.ejectPosition"/></td>
<td>${xfsComponent.ejectPosition}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.emvHashAlgorithm != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.emvHashAlgorithm"/></td>
<td>${xfsComponent.emvHashAlgorithm}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.emvImportSchemes != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.emvImportSchemes"/></td>
<td>${xfsComponent.emvImportSchemes}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.encioProtocols != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.encioProtocols"/></td>
<td>${xfsComponent.encioProtocols}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.encoder != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.encoder"/></td>
<td>${xfsComponent.encoder}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.encodenames != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.encodenames"/></td>
<td>${xfsComponent.encodenames}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.endorser != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.endorser"/></td>
<td>${xfsComponent.endorser}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.envelopesupply != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.envelopesupply"/></td>
<td>${xfsComponent.envelopesupply}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.exchangeTypes != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.exchangeTypes"/></td>
<td>${xfsComponent.exchangeTypes}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.extents != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.extents"/></td>
<td>${xfsComponent.extents}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.extra != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.extra"/></td>
<td>${xfsComponent.extra}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.fontnames != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.fontnames"/></td>
<td>${xfsComponent.fontnames}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.forms != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.forms"/></td>
<td>${xfsComponent.forms}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.frontImageColorFormat != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.frontImageColorFormat"/></td>
<td>${xfsComponent.frontImageColorFormat}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.frontscanColor != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.frontscanColor"/></td>
<td>${xfsComponent.frontscanColor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.guidlights != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.guidlights"/></td>
<td>${xfsComponent.guidlights}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.hasCashBox != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.hasCashBox"/></td>
<td>${xfsComponent.hasCashBox}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.hasInsertedSensor != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.hasInsertedSensor"/></td>
<td>${xfsComponent.hasInsertedSensor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.hasShutter != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.hasShutter"/></td>
<td>${xfsComponent.hasShutter}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.hasTakenSensor != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.hasTakenSensor"/></td>
<td>${xfsComponent.hasTakenSensor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.hsmVendor != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.hsmVendor"/></td>
<td>${xfsComponent.hsmVendor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.idConnect != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.idConnect"/></td>
<td>${xfsComponent.idConnect}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.idKey != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.idKey"/></td>
<td>${xfsComponent.idKey}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.imagecapture != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.imagecapture"/></td>
<td>${xfsComponent.imagecapture}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.imageSource != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.imageSource"/></td>
<td>${xfsComponent.imageSource}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.imageType != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.imageType"/></td>
<td>${xfsComponent.imageType}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.indicators != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.indicators"/></td>
<td>${xfsComponent.indicators}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.insertOrientation != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.insertOrientation"/></td>
<td>${xfsComponent.insertOrientation}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.intermediateStacker != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.intermediateStacker"/></td>
<td>${xfsComponent.intermediateStacker}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isApplicationRefuse != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isApplicationRefuse"/></td>
<td>${xfsComponent.isApplicationRefuse}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isAutofeed != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isAutofeed"/></td>
<td>${xfsComponent.isAutofeed}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isCardTakenSensor != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isCardTakenSensor"/></td>
<td>${xfsComponent.isCardTakenSensor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isCompareSignatures != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isCompareSignatures"/></td>
<td>${xfsComponent.isCompareSignatures}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isHsmJournaling != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isHsmJournaling"/></td>
<td>${xfsComponent.isHsmJournaling}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isIntermediateStacker != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isIntermediateStacker"/></td>
<td>${xfsComponent.isIntermediateStacker}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isItemsTakenSensor != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isItemsTakenSensor"/></td>
<td>${xfsComponent.isItemsTakenSensor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isKeyImportThroughParts != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isKeyImportThroughParts"/></td>
<td>${xfsComponent.isKeyImportThroughParts}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isMediaPresented != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isMediaPresented"/></td>
<td>${xfsComponent.isMediaPresented}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isPinCanPersistAfterUse != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isPinCanPersistAfterUse"/></td>
<td>${xfsComponent.isPinCanPersistAfterUse}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isPresentControl != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isPresentControl"/></td>
<td>${xfsComponent.isPresentControl}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isRescan != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isRescan"/></td>
<td>${xfsComponent.isRescan}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isRetractCountsItems != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isRetractCountsItems"/></td>
<td>${xfsComponent.isRetractCountsItems}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isRetractToTransport != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isRetractToTransport"/></td>
<td>${xfsComponent.isRetractToTransport}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isSafeDoor != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isSafeDoor"/></td>
<td>${xfsComponent.isSafeDoor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isSetPinBlockDataRequired != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isSetPinBlockDataRequired"/></td>
<td>${xfsComponent.isSetPinBlockDataRequired}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isStamp != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isStamp"/></td>
<td>${xfsComponent.isStamp}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.isTypeCombined != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.isTypeCombined"/></td>
<td>${xfsComponent.isTypeCombined}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.itemInfoTypes != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.itemInfoTypes"/></td>
<td>${xfsComponent.itemInfoTypes}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.keyBlockImportFormats != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.keyBlockImportFormats"/></td>
<td>${xfsComponent.keyBlockImportFormats}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.keyCheckModes != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.keyCheckModes"/></td>
<td>${xfsComponent.keyCheckModes}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.keyLock != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.keyLock"/></td>
<td>${xfsComponent.keyLock}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.keyNum != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.keyNum"/></td>
<td>${xfsComponent.keyNum}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.keys != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.keys"/></td>
<td>${xfsComponent.keys}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.logical != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.logical"/></td>
<td>${xfsComponent.logical}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.magneticstriperead != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.magneticstriperead"/></td>
<td>${xfsComponent.magneticstriperead}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.magneticstripewrite != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.magneticstripewrite"/></td>
<td>${xfsComponent.magneticstripewrite}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxBills != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.maxBills"/></td>
<td>${xfsComponent.maxBills}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxCashInItems != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.maxCashInItems"/></td>
<td>${xfsComponent.maxCashInItems}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxCoins != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.maxCoins"/></td>
<td>${xfsComponent.maxCoins}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxDataLength != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.maxDataLength"/></td>
<td>${xfsComponent.maxDataLength}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxDispenseItems != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.maxDispenseItems"/></td>
<td>${xfsComponent.maxDispenseItems}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxMediaOnStacker != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.maxMediaOnStacker"/></td>
<td>${xfsComponent.maxMediaOnStacker}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxNumChars != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.maxNumChars"/></td>
<td>${xfsComponent.maxNumChars}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxPictures != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.maxPictures"/></td>
<td>${xfsComponent.maxPictures}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxRetract != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.maxRetract"/></td>
<td>${xfsComponent.maxRetract}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.max2Retract != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.max2Retract"/></td>
<td>${xfsComponent.max2Retract}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.mediaTaken != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.mediaTaken"/></td>
<td>${xfsComponent.mediaTaken}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.memoryChipProtocols != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.memoryChipProtocols"/></td>
<td>${xfsComponent.memoryChipProtocols}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.micr != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.micr"/></td>
<td>${xfsComponent.micr}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.moveItems != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.moveItems"/></td>
<td>${xfsComponent.moveItems}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.multiPage != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.multiPage"/></td>
<td>${xfsComponent.multiPage}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.numLeds != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.numLeds"/></td>
<td>${xfsComponent.numLeds}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.ocr != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.ocr"/></td>
<td>${xfsComponent.ocr}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.outputPositions != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.outputPositions"/></td>
<td>${xfsComponent.outputPositions}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.paperSources != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.paperSources"/></td>
<td>${xfsComponent.paperSources}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.pinFormats != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.pinFormats"/></td>
<td>${xfsComponent.pinFormats}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.pockets != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.pockets"/></td>
<td>${xfsComponent.pockets}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.powerOff != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.powerOff"/></td>
<td>${xfsComponent.powerOff}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.powerOn != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.powerOn"/></td>
<td>${xfsComponent.powerOn}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.powerSaveControl != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.powerSaveControl"/></td>
<td>${xfsComponent.powerSaveControl}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.presentationAlgorithms != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.presentationAlgorithms"/></td>
<td>${xfsComponent.presentationAlgorithms}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.printer != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.printer"/></td>
<td>${xfsComponent.printer}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.printOnRetracts != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.printOnRetracts"/></td>
<td>${xfsComponent.printOnRetracts}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.printSize != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.printSize"/></td>
<td>${xfsComponent.printSize}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.programaticallyDeactivate != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.programaticallyDeactivate"/></td>
<td>${xfsComponent.programaticallyDeactivate}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.provider != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.provider"/></td>
<td>${xfsComponent.provider}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.readForm != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.readForm"/></td>
<td>${xfsComponent.readForm}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.readTracks != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.readTracks"/></td>
<td>${xfsComponent.readTracks}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.refill != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.refill"/></td>
<td>${xfsComponent.refill}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.resetControl != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.resetControl"/></td>
<td>${xfsComponent.resetControl}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.resolutions != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.resolutions"/></td>
<td>${xfsComponent.resolutions}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.retract != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.retract"/></td>
<td>${xfsComponent.retract}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractAreas != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.retractAreas"/></td>
<td>${xfsComponent.retractAreas}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractBins != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.retractBins"/></td>
<td>${xfsComponent.retractBins}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractenvelope != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.retractenvelope"/></td>
<td>${xfsComponent.retractenvelope}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractStackerActions != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.retractStackerActions"/></td>
<td>${xfsComponent.retractStackerActions}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractTransportActions != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.retractTransportActions"/></td>
<td>${xfsComponent.retractTransportActions}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractToDeposit != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.retractToDeposit"/></td>
<td>${xfsComponent.retractToDeposit}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.rsaAuthenticationScheme != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.rsaAuthenticationScheme"/></td>
<td>${xfsComponent.rsaAuthenticationScheme}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.rsaCryptAlgorithm != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.rsaCryptAlgorithm"/></td>
<td>${xfsComponent.rsaCryptAlgorithm}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.rsaKeycheckMode != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.rsaKeycheckMode"/></td>
<td>${xfsComponent.rsaKeycheckMode}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.rsaSignatureAlgorithm != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.rsaSignatureAlgorithm"/></td>
<td>${xfsComponent.rsaSignatureAlgorithm}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.securityType != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.securityType"/></td>
<td>${xfsComponent.securityType}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.sensors != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.sensors"/></td>
<td>${xfsComponent.sensors}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.shutterControl != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.shutterControl"/></td>
<td>${xfsComponent.shutterControl}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.signatureScheme != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.signatureScheme"/></td>
<td>${xfsComponent.signatureScheme}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.stamp != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.stamp"/></td>
<td>${xfsComponent.stamp}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.positions != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.positions"/></td>
<td>${xfsComponent.positions}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.symbologies != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.symbologies"/></td>
<td>${xfsComponent.symbologies}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.canFilterSymbologies != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.canFilterSymbologies"/></td>
<td>${xfsComponent.canFilterSymbologies}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.toner != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.toner"/></td>
<td>${xfsComponent.toner}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.type != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.type"/></td>
<td>${xfsComponent.type}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.validationAlgorithms != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.validationAlgorithms"/></td>
<td>${xfsComponent.validationAlgorithms}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.vandalCheck != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.vandalCheck"/></td>
<td>${xfsComponent.vandalCheck}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.windowsPrinter != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.windowsPrinter"/></td>
<td>${xfsComponent.windowsPrinter}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.writeForm != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.writeForm"/></td>
<td>${xfsComponent.writeForm}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.writeMode != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.writeMode"/></td>
<td>${xfsComponent.writeMode}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.writeTracks != null}">
<tr>
<td class="header"><spring:message code="label.xfsComponent.writeTracks"/></td>
<td>${xfsComponent.writeTracks}</td>
</tr>
</c:if>
</table>
</div>
</div>
	
<c:if test="${!empty xfsComponent.logicalCashUnits}">
<div class="box">
<h2><spring:message code="label.logicalCashUnits"/></h2>
<div class="margin-box">
<c:forEach items="${xfsComponent.logicalCashUnits}" var="logicalCashUnit">
	<div class="box">
	<h3><spring:message code="label.lcu"/> ${logicalCashUnit.name}</h3>
	<div class="margin-box">
	<table class="data subform">
		<tr>
			<th style="width: 50px;"><spring:message code="label.logicalCashUnits.type"/></th>
			<th style="width: 35px;"><spring:message code="label.logicalCashUnits.unitId"/></th>
			<th style="width: 55px;"><spring:message code="label.logicalCashUnits.currencyId"/></th>
			<th style="width: 35px;"><spring:message code="label.logicalCashUnits.values"/></th>
			<th style="width: 40px;"><spring:message code="label.logicalCashUnits.minimum"/></th>
			<th style="width: 45px;"><spring:message code="label.logicalCashUnits.maximum"/></th>
		</tr>
		<tr>
	        <td style="width: 50px;">${logicalCashUnit.type}</td>
	        <td style="width: 35px;">${logicalCashUnit.unitId}</td>
	        <td style="width: 55px;">${logicalCashUnit.currencyId}</td>
	        <td style="width: 35px;">
				<c:forEach items="${logicalCashUnit.valuesSplit}" var="split">
			    	${split}<br>
			    </c:forEach>
	    	</td>
	        <td style="width: 40px;">${logicalCashUnit.minimum}</td>
	        <td style="width: 45px;">${logicalCashUnit.maximum}</td>
		</tr>
	</table>
	<c:if test="${!empty logicalCashUnit.physicalCashUnits}">
		<h4><spring:message code="label.physicalCashUnits"/></h4>
		<table class="data subform">
		<tr>
		    <th><spring:message code="label.physicalCashUnit.name"/></th>
		    <th><spring:message code="label.physicalCashUnit.unitId"/></th>
		    <th><spring:message code="label.physicalCashUnit.maximum"/></th>
		    <th><spring:message code="label.physicalCashUnit.hardwareSensor"/></th>
		</tr>
		<c:set var="alt" value="${false}"/>
		<c:forEach items="${logicalCashUnit.physicalCashUnits}" var="physicalCashUnit">
		    <tr <c:if test="${alt}">class="alt"</c:if>>
		        <td>${physicalCashUnit.name}</td>
		        <td>${physicalCashUnit.unitId}</td>
		        <td>${physicalCashUnit.maximum}</td>
		        <td>${physicalCashUnit.hardwareSensor}</td>
		    </tr>
			<c:set var="alt" value="${!alt}"/>
		</c:forEach>
		</table>
	</c:if>
	</div>
	</div>
</c:forEach>
</div>
</div>
</c:if>
</div>
</div>