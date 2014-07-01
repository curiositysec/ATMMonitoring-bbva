#!/bin/bash

# Script for generating developer doc using Sphinx
# from the JavaDoc comments

basepath=$(dirname $0)
cd "$basepath"
javasphinx-apidoc -o temp ../../src
cp -R temp/com source/developer/
rm -Rf temp
make html
echo "Developer doc successfully created."
