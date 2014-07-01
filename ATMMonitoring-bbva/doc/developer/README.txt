In this folder we include all the doc specifically related files.

- DEVELOPER DOCUMENTATION:
Inside the folder 'developer' we include the developer documentation, which
is generated from the Javadoc comments by using javasphinx and sphinx,
resulting in an API style complete web. A script, create_dev_doc.sh, which
contains all the needed steps is included.
Please be aware that for generating the documentation from scratch the
following python modules are needed:
- javasphinx (0.9.8+)
- beautifulsoup (3.2.0, version 4 raises problems)
- javalang (0.9.4+)
- lxml (2.3.2+)

- USER DOCUMENTATION:
Inside the folder 'user' and the corresponding language code folder we include
a series of rst files which contain the user documentation, having the
option of generating it as html pages or a pdf file. A script, create_help.sh,
which contains all the steps needed for generating the help pages and moving
them to the proper folder of the Java project is included as well.
Please note the images must be included inside the language folder and
should be inside folder 'resources/help/<language_code>/images', an unintuituve
path but that acts as a simple hack for having the same relative path as
in the application when deployed.
