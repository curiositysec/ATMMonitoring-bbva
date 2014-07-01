#!/bin/bash

# Script for generating user doc as help webpages and copying
# those files in the proper project path

basepath=$(dirname $0)
resources_help=/../../../src/main/webapp/resources/help/
langs=(en)

make html

#move the resources
cp -f -r  "$basepath"/build/html/_images/ "$basepath""$resources_help"
cp -f -r "$basepath"/build/html/_static/ "$basepath""$resources_help"


for lang in ${langs[*]}
do
	# We clean the directory
	rm -f  "$basepath""$resources_help""$lang"/*


	# We copy all 
	cp -f -r "$basepath"/build/html/"$lang"/ "$basepath""$resources_help"/
	

done
# We clean the html just created
	rm -f -r  "$basepath"/build/

echo "Help doc successfully created."
