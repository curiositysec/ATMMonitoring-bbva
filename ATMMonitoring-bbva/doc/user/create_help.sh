#!/bin/bash

# Script for generating user doc as help webpages and copying
# those files in the proper project path

basepath=$(dirname $0)

langs=(en)
pages=(user-main users dashboard terminals reports scheduled_updates login-logout)
for lang in ${langs[*]}
do
	for page in ${pages[*]}
	do
		# We generate the html file
		rst2html --template="$basepath"/template.txt -o ISO-8859-1 "$basepath"/"$lang"/"$page".rst "$basepath"/"$lang"/"$page".html
		# We move it to the project folder
		mv -f "$basepath"/"$lang"/"$page".html "$basepath"/../../src/main/webapp/resources/help/"$lang"/
	done

	# We copy all the images
	cp -f "$basepath"/"$lang"/resources/help/"$lang"/images/* "$basepath"/../../src/main/webapp/resources/help/"$lang"/images/
done

echo "Help doc successfully created."
