.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: java.io IOException

.. java:import:: javax.servlet.jsp JspException

.. java:import:: javax.servlet.jsp.tagext SimpleTagSupport

TemplateModelPhotoUrlTag
========================

.. java:package:: com.ncr.ATMMonitoring.tag
   :noindex:

.. java:type:: public class TemplateModelPhotoUrlTag extends SimpleTagSupport

   The Class TemplateModelPhotoUrlTag.

   :author: Rafael Luque (rafael.luque@osoco.es)

Methods
-------
doTag
^^^^^

.. java:method:: public void doTag() throws JspException, IOException
   :outertype: TemplateModelPhotoUrlTag

setAtm
^^^^^^

.. java:method:: public void setAtm(Terminal atm)
   :outertype: TemplateModelPhotoUrlTag

   Sets the atm.

   :param atm: the new atm

setManufacturer
^^^^^^^^^^^^^^^

.. java:method:: public void setManufacturer(String manufacturer)
   :outertype: TemplateModelPhotoUrlTag

   Sets the manufacturer.

   :param manufacturer: the new manufacturer

setWidth
^^^^^^^^

.. java:method:: public void setWidth(Integer width)
   :outertype: TemplateModelPhotoUrlTag

   Sets the width.

   :param width: the new width

