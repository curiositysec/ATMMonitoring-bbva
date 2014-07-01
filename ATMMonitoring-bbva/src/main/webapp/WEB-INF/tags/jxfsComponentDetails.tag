<%@tag description="Jxfs Component Details" pageEncoding="UTF-8"%>
<%@attribute name="jxfsComponent" required="true" type="com.ncr.ATMMonitoring.pojo.JxfsComponent"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="main">
    <div id="primary">
<div class="box">
<h1><spring:message code="label.jxfsComponentDetails"/></h1>

<div class="margin-box">
<table class="form-disabled-generic">
<c:if test="${jxfsComponent.jxfsClass != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.jxfsClass"/></td>
<td>${jxfsComponent.jxfsClass}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.acceptLimit != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.acceptLimit"/></td>
<td>${jxfsComponent.acceptLimit}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.autopresent != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.autopresent"/></td>
<td>${jxfsComponent.autopresent}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.auxiliaries != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.auxiliaries"/></td>
<td>${jxfsComponent.auxiliaries}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.availableResolution != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.availableResolution"/></td>
<td>${jxfsComponent.availableResolution}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.baitTrap != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.baitTrap"/></td>
<td>${jxfsComponent.baitTrap}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.barcodeCapabilities != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.barcodeCapabilities"/></td>
<td>${jxfsComponent.barcodeCapabilities}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.beepOnPressSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.beepOnPressSupported"/></td>
<td>${jxfsComponent.beepOnPressSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.beepSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.beepSupported"/></td>
<td>${jxfsComponent.beepSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.billsTakenSensor != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.billsTakenSensor"/></td>
<td>${jxfsComponent.billsTakenSensor}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.cashbox != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.cashbox"/></td>
<td>${jxfsComponent.cashbox}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.category2 != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.category2"/></td>
<td>${jxfsComponent.category2}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.category3 != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.category3"/></td>
<td>${jxfsComponent.category3}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.cdType != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.cdType"/></td>
<td>${jxfsComponent.cdType}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.checkVandalism != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.checkVandalism"/></td>
<td>${jxfsComponent.checkVandalism}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.chequeCapabilities != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.chequeCapabilities"/></td>
<td>${jxfsComponent.chequeCapabilities}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.coins != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.coins"/></td>
<td>${jxfsComponent.coins}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.complex != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.complex"/></td>
<td>${jxfsComponent.complex}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.compound != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.compound"/></td>
<td>${jxfsComponent.compound}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.createSignatureCommandSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.createSignatureCommandSupported"/></td>
<td>${jxfsComponent.createSignatureCommandSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.ctrlTurn != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.ctrlTurn"/></td>
<td>${jxfsComponent.ctrlTurn}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.cursorSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.cursorSupported"/></td>
<td>${jxfsComponent.cursorSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.cylinders != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.cylinders"/></td>
<td>${jxfsComponent.cylinders}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.defaultInputPosition != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.defaultInputPosition"/></td>
<td>${jxfsComponent.defaultInputPosition}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.defaultOutputPosition != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.defaultOutputPosition"/></td>
<td>${jxfsComponent.defaultOutputPosition}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.defaultRollbackPosition != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.defaultRollbackPosition"/></td>
<td>${jxfsComponent.defaultRollbackPosition}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.deposit != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.deposit"/></td>
<td>${jxfsComponent.deposit}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.detector != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.detector"/></td>
<td>${jxfsComponent.detector}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.deviceControlName != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.deviceControlName"/></td>
<td>${jxfsComponent.deviceControlName}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.deviceId != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.deviceId"/></td>
<td>${jxfsComponent.deviceId}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.deviceOrientation != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.deviceOrientation"/></td>
<td>${jxfsComponent.deviceOrientation}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.deviceScanningBothLongSide != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.deviceScanningBothLongSide"/></td>
<td>${jxfsComponent.deviceScanningBothLongSide}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.deviceScanningBothShortSide != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.deviceScanningBothShortSide"/></td>
<td>${jxfsComponent.deviceScanningBothShortSide}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.deviceServiceName != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.deviceServiceName"/></td>
<td>${jxfsComponent.deviceServiceName}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.deviceType != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.deviceType"/></td>
<td>${jxfsComponent.deviceType}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.dispense != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.dispense"/></td>
<td>${jxfsComponent.dispense}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.displayLightSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.displayLightSupported"/></td>
<td>${jxfsComponent.displayLightSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.keyboardLockSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.keyboardLockSupported"/></td>
<td>${jxfsComponent.keyboardLockSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.keyboardSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.keyboardSupported"/></td>
<td>${jxfsComponent.keyboardSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.keysSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.keysSupported"/></td>
<td>${jxfsComponent.keysSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.doors != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.doors"/></td>
<td>${jxfsComponent.doors}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.ejectStatus != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.ejectStatus"/></td>
<td>${jxfsComponent.ejectStatus}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.entry != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.entry"/></td>
<td>${jxfsComponent.entry}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.envSupply != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.envSupply"/></td>
<td>${jxfsComponent.envSupply}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.escrow != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.escrow"/></td>
<td>${jxfsComponent.escrow}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.escrowSize != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.escrowSize"/></td>
<td>${jxfsComponent.escrowSize}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.eventOnStartSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.eventOnStartSupported"/></td>
<td>${jxfsComponent.eventOnStartSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.extent != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.extent"/></td>
<td>${jxfsComponent.extent}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.guidlights != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.guidlights"/></td>
<td>${jxfsComponent.guidlights}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.idKey != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.idKey"/></td>
<td>${jxfsComponent.idKey}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.imageCapabilities != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.imageCapabilities"/></td>
<td>${jxfsComponent.imageCapabilities}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.imageCapture != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.imageCapture"/></td>
<td>${jxfsComponent.imageCapture}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.indicators != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.indicators"/></td>
<td>${jxfsComponent.indicators}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.inputCookSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.inputCookSupported"/></td>
<td>${jxfsComponent.inputCookSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.inputPositions != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.inputPositions"/></td>
<td>${jxfsComponent.inputPositions}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.inputRawSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.inputRawSupported"/></td>
<td>${jxfsComponent.inputRawSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.intermediateStacker != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.intermediateStacker"/></td>
<td>${jxfsComponent.intermediateStacker}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.insertTextSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.insertTextSupported"/></td>
<td>${jxfsComponent.insertTextSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.maxDataLength != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.maxDataLength"/></td>
<td>${jxfsComponent.maxDataLength}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.maxInBills != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.maxInBills"/></td>
<td>${jxfsComponent.maxInBills}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.maxInCoins != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.maxInCoins"/></td>
<td>${jxfsComponent.maxInCoins}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.maxLed != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.maxLed"/></td>
<td>${jxfsComponent.maxLed}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.maxNumOfChars != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.maxNumOfChars"/></td>
<td>${jxfsComponent.maxNumOfChars}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.maxOutBills != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.maxOutBills"/></td>
<td>${jxfsComponent.maxOutBills}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.maxOutCoins != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.maxOutCoins"/></td>
<td>${jxfsComponent.maxOutCoins}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.maxPictures != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.maxPictures"/></td>
<td>${jxfsComponent.maxPictures}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.maxRetract != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.maxRetract"/></td>
<td>${jxfsComponent.maxRetract}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.maxStacker != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.maxStacker"/></td>
<td>${jxfsComponent.maxStacker}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.multipleCurrenciesCashInSupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.multipleCurrenciesCashInSupported"/></td>
<td>${jxfsComponent.multipleCurrenciesCashInSupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.numberOfKeys != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.numberOfKeys"/></td>
<td>${jxfsComponent.numberOfKeys}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.orientationToBeScanned != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.orientationToBeScanned"/></td>
<td>${jxfsComponent.orientationToBeScanned}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.outputPositions != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.outputPositions"/></td>
<td>${jxfsComponent.outputPositions}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.print != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.print"/></td>
<td>${jxfsComponent.print}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.positions != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.positions"/></td>
<td>${jxfsComponent.positions}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.powerOff != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.powerOff"/></td>
<td>${jxfsComponent.powerOff}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.powerOn != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.powerOn"/></td>
<td>${jxfsComponent.powerOn}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.ptrCapabilities != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.ptrCapabilities"/></td>
<td>${jxfsComponent.ptrCapabilities}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.ptrControlMedia != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.ptrControlMedia"/></td>
<td>${jxfsComponent.ptrControlMedia}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.readForm != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.readForm"/></td>
<td>${jxfsComponent.readForm}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.readFonts != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.readFonts"/></td>
<td>${jxfsComponent.readFonts}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.readImage != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.readImage"/></td>
<td>${jxfsComponent.readImage}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.readKeyboardDataWithDefault != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.readKeyboardDataWithDefault"/></td>
<td>${jxfsComponent.readKeyboardDataWithDefault}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.readMicr != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.readMicr"/></td>
<td>${jxfsComponent.readMicr}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.readOcr != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.readOcr"/></td>
<td>${jxfsComponent.readOcr}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.readStatus != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.readStatus"/></td>
<td>${jxfsComponent.readStatus}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.refill != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.refill"/></td>
<td>${jxfsComponent.refill}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.remoteKeyLoad != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.remoteKeyLoad"/></td>
<td>${jxfsComponent.remoteKeyLoad}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.retain != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.retain"/></td>
<td>${jxfsComponent.retain}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.retract != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.retract"/></td>
<td>${jxfsComponent.retract}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.safeDoorCmd != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.safeDoorCmd"/></td>
<td>${jxfsComponent.safeDoorCmd}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.safeDoorSequence != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.safeDoorSequence"/></td>
<td>${jxfsComponent.safeDoorSequence}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.scnCapabilities != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.scnCapabilities"/></td>
<td>${jxfsComponent.scnCapabilities}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.secureKeyDetail != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.secureKeyDetail"/></td>
<td>${jxfsComponent.secureKeyDetail}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.secureKeyEntryState != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.secureKeyEntryState"/></td>
<td>${jxfsComponent.secureKeyEntryState}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.secureKeyEntrySupported != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.secureKeyEntrySupported"/></td>
<td>${jxfsComponent.secureKeyEntrySupported}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.secureModuleType != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.secureModuleType"/></td>
<td>${jxfsComponent.secureModuleType}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.sensors != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.sensors"/></td>
<td>${jxfsComponent.sensors}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.status != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.status"/></td>
<td>${jxfsComponent.status}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.supportedChipPresentationModes != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.supportedChipPresentationModes"/></td>
<td>${jxfsComponent.supportedChipPresentationModes}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.supportedChipProtocols != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.supportedChipProtocols"/></td>
<td>${jxfsComponent.supportedChipProtocols}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.supportedCryptoModes != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.supportedCryptoModes"/></td>
<td>${jxfsComponent.supportedCryptoModes}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.supportedFdKeys != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.supportedFdKeys"/></td>
<td>${jxfsComponent.supportedFdKeys}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.supportedPinFormats != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.supportedPinFormats"/></td>
<td>${jxfsComponent.supportedPinFormats}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.supportedReadTracks != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.supportedReadTracks"/></td>
<td>${jxfsComponent.supportedReadTracks}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.supportedTextAttributes != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.supportedTextAttributes"/></td>
<td>${jxfsComponent.supportedTextAttributes}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.supportedValidationAlgorithms != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.supportedValidationAlgorithms"/></td>
<td>${jxfsComponent.supportedValidationAlgorithms}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.supportedWriteHicoTracks != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.supportedWriteHicoTracks"/></td>
<td>${jxfsComponent.supportedWriteHicoTracks}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.supportedWriteTracks != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.supportedWriteTracks"/></td>
<td>${jxfsComponent.supportedWriteTracks}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.shutterCmd != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.shutterCmd"/></td>
<td>${jxfsComponent.shutterCmd}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.silentAlarm != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.silentAlarm"/></td>
<td>${jxfsComponent.silentAlarm}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.testCashUnit != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.testCashUnit"/></td>
<td>${jxfsComponent.testCashUnit}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.transport != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.transport"/></td>
<td>${jxfsComponent.transport}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.trustedUser != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.trustedUser"/></td>
<td>${jxfsComponent.trustedUser}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.unfit != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.unfit"/></td>
<td>${jxfsComponent.unfit}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.vendorData != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.vendorData"/></td>
<td>${jxfsComponent.vendorData}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.writeForm != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.writeForm"/></td>
<td>${jxfsComponent.writeForm}</td>
</tr>
</c:if>
<c:if test="${jxfsComponent.writeMode != null}">
<tr>
<td class="header"><spring:message code="label.jxfsComponent.writeMode"/></td>
<td>${jxfsComponent.writeMode}</td>
</tr>
</c:if>
</table>
</div>
</div>
</div>
</div>