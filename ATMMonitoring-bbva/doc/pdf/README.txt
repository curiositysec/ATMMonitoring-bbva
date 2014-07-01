PDF Generator made by Otto Abreu
Version :1.0

=============
DESCRIPTION :
=============

The script create_pdf_doc.sh can generate all the PDF documentation, 
in order to do so please execute the script in the following way:

==========
FEATURES :
==========

To Generate Only One Document
*****************************

To generate only one document only execute the script with the following additional argument:

* Architecture: -arc
* Environment Setup: -env
* Installation guide: -ins
* Quick Installation guide: -qin
* User Manual: -usr
* Agent Collected Info: -cin
* All in one document -all

To Generate all Documents
*************************
To generate all the documents, execute the script without any argument

Where To Find the PDFs
**********************
Inside the folder named build_pdf. 
The pdf have the date (yyyymmdd) when created, if the date collides, it will overwrite the old file

=====
HELP:
=====

If any error is raised during the latex compilation in a Linux environment,
please make sure you have the following packages installed:

* texlive-latex-recommended
* texlive-latex-extra
* texlive-math-extra
