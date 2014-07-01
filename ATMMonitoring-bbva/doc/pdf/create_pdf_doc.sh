#!/bin/bash

# Script for generating pdf doc using Sphinx


basepath=$(dirname $0)
cd "$basepath"
DEVELOPER_FOLDER=../developer/source
STATIC_FOLDER=${DEVELOPER_FOLDER}/_static
IMAGES_INDEX=${DEVELOPER_FOLDER}/images-index
PDF_SOURCES=source
PDF_BUILD_LATEX=build/latex
ARCHITECTURE_FOLDER="architecture"
ENVSETUP_FOLDER="enviroment_setup"
INSTALATION_FOLDER="installation"
USER_FOLDER="user"
INDEXES_FOLDER=indexconf
GENERATED_PDF_FOLDER=build_pdf
FINAL_PDF_BASENAME="ATMInventory"
DATE=`date +%Y%m%d`

#environment creators, copy and remove files

copyIndexConf(){
	cp -f ${INDEXES_FOLDER}/index_$1.rst ${PDF_SOURCES}/index.rst
	cp -f ${INDEXES_FOLDER}/conf_$1.py ${PDF_SOURCES}/conf.py
	cp -f ${DEVELOPER_FOLDER}/latex-styling.tex ${PDF_SOURCES}
}

copyFilesFolders(){
	echo "Coping folder: $1 from  ${DEVELOPER_FOLDER}"
 
	cp -r ${DEVELOPER_FOLDER}/$1 ${PDF_SOURCES}
	copyIndexConf $1

}

createLatex(){
	
	echo "executing make latex"
	make latex
}
createLatexPdf(){
	
	echo "executing make latexpdf"
	make  latexpdf
}
copyQuickInstallGuideFolders(){
	echo "Coping folder: $1 from  ${DEVELOPER_FOLDER}"
	cp -r ${DEVELOPER_FOLDER}/$1 ${PDF_SOURCES}
	echo "Coping index: index_$2.rst"
	cp -f ${INDEXES_FOLDER}/index_$2.rst ${PDF_SOURCES}/index.rst
	echo "Coping conf: conf_$2.py"
	cp -f ${INDEXES_FOLDER}/conf_$2.py ${PDF_SOURCES}/conf.py
	echo "Coping latex styling: latex-styling.tex"
	cp -f ${DEVELOPER_FOLDER}/latex-styling.tex ${PDF_SOURCES}
	echo "removing: install-main.rst"
	rm -f ${PDF_SOURCES}/${INSTALATION_FOLDER}/install-main.rst
	echo "removing: install-deploy.rst"	
	rm -f ${PDF_SOURCES}/${INSTALATION_FOLDER}/install-deploy.rst
}

moveGeneratedPDF(){
	echo "moving generated pdf to: ${GENERATED_PDF_FOLDER}"
	mkdir -p  ${GENERATED_PDF_FOLDER}
	for file in `ls ${PDF_BUILD_LATEX} |grep .pdf`
	do
	  
	  cp -f ${PDF_BUILD_LATEX}/$file ${GENERATED_PDF_FOLDER}/${FINAL_PDF_BASENAME}_$1_${DATE}.pdf
	done
}

#coping needed folders
createNeededFiles(){
	echo "cleaning build folder"

	rm -rf ./build
	
	echo "creating source folder"
	
	mkdir -p  ${PDF_SOURCES}

	echo "Coping Static folder from ${DEVELOPER_FOLDER}"

	cp -r ${STATIC_FOLDER} ${PDF_SOURCES}

	echo "Coping images-index folder from ${IMAGES_INDEX}"

	cp  -r ${IMAGES_INDEX} ${PDF_SOURCES}


	echo "Coping introduction.rst from ${DEVELOPER_FOLDER}"

	cp  ${DEVELOPER_FOLDER}/introduction.rst ${PDF_SOURCES}
}

copyGenerateCollectedInfo(){
	cp ${DEVELOPER_FOLDER}/collected-info.rst ${PDF_SOURCES}

}

#pdf generation functions
generateAllInOne(){

	echo "Generating All docs PDF"
	cp -r ${DEVELOPER_FOLDER} .
	createLatex
	createLatexPdf
	moveGeneratedPDF "Documentation"
	echo "Generating ALL doc DONE"
	cleaning
}

generateArch(){
	echo "Generating Architecture PDF"
	echo ""
	echo ""	
	createNeededFiles 
	echo ""
	echo ""
	copyFilesFolders "${ARCHITECTURE_FOLDER}"
	echo ""
	echo ""		
	createLatex
	echo ""
	echo ""
	createLatexPdf
	echo ""
	echo ""	
	moveGeneratedPDF "Architecture"
	echo ""
	echo ""	
	echo "Generated Architecture PDF DONE"
	cleaning

}

generateEnv(){

	echo "Generating Enviroment-setup guide PDF"
	echo ""
	echo ""	
	createNeededFiles 
	echo ""
	echo ""
	copyFilesFolders "${ENVSETUP_FOLDER}"
	echo ""
	echo ""		
	createLatex
	echo ""
	echo ""
	createLatexPdf
	echo ""
	echo ""	
	moveGeneratedPDF "Environment_Setup"
	echo "Generating Enviroment-setup guide DONE"
	cleaning
}

generateInstallation(){
	echo "Generating Installation guide PDF"
	echo ""
	echo ""	
	createNeededFiles 
	echo ""
	echo ""
	copyFilesFolders "${INSTALATION_FOLDER}"
	echo ""
	echo ""		
	createLatex
	echo ""
	echo ""
	createLatexPdf
	echo ""
	echo ""	
	moveGeneratedPDF "Installation_Guide"
	echo "Generating Installation guide PDF DONE"
	cleaning

}

generateQuickInstall(){

	echo "Generating Quick-Install PDF"
	echo ""
	echo ""	
	createNeededFiles 
	echo ""
	echo ""
	copyQuickInstallGuideFolders "${INSTALATION_FOLDER}" "quickInstall"
	echo ""
	echo ""		
	createLatex
	echo ""
	echo ""
	createLatexPdf
	echo ""
	echo ""	
	moveGeneratedPDF "Quick_Installation_Guide"
	echo "Generating Quick-Install PDF DONE"
	cleaning

}

generateUser(){
	echo "Generating User PDF"
	echo ""
	echo ""	
	createNeededFiles 
	echo ""
	echo ""
	copyFilesFolders "${USER_FOLDER}"
	echo ""
	echo ""		
	createLatex
	echo ""
	echo ""
	createLatexPdf
	echo ""
	echo ""	
	moveGeneratedPDF "User_Guide"
	echo "Generating User PDF DONE"
	cleaning
}

generateCollectedInfo(){
	echo "Generating Collected Info PDF"
	echo ""
	echo ""
	copyGenerateCollectedInfo
	echo ""
	echo ""
	copyIndexConf "collected-info"
	echo ""
	echo ""		
	createLatex
	echo ""
	echo ""
	createLatexPdf
	echo ""
	echo ""	
	moveGeneratedPDF "collected_info"
	echo "Generating Collected Info PDF DONE"
	cleaning		
}

cleaning(){
	#cleaning the house
	echo "removing sources"

	rm -rf ${PDF_SOURCES}

}
if  [ $# != 0 ] ; then
	
	createNeededFiles

	while [ -n "$1" ]
	  do
	    echo "Current option: $1 "
	  	
		if [ "$1" == "-arc" ]; then
			generateArch
		elif [ "$1" == "-env" ] ; then
			generateEnv
		elif [ "$1" == "-ins" ] ; then
	 		generateInstallation
		elif [ "$1" == "-qin" ] ; then
			generateQuickInstall
		elif [ "$1" == "-usr" ] ; then
			generateUser
		elif [ "$1" == "-all" ] ; then	
			generateAllInOne
		elif  [ "$1" == "-cin" ] ; then
		    generateCollectedInfo			
		else
			echo "unrecognized option: $1"
		fi
	    shift

	done
else
	createNeededFiles	
	generateArch
	generateEnv
	generateInstallation
	generateQuickInstall
	generateUser
	generateCollectedInfo
	generateAllInOne
fi




