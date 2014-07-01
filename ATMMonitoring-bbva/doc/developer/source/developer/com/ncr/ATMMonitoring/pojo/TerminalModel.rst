.. java:import:: java.awt Color

.. java:import:: java.awt Image

.. java:import:: java.awt.image BufferedImage

.. java:import:: java.io ByteArrayInputStream

.. java:import:: java.io IOException

.. java:import:: javax.imageio ImageIO

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.apache.log4j Logger

TerminalModel
=============

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class TerminalModel

   The TerminalModel Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
getDepth
^^^^^^^^

.. java:method:: public Integer getDepth()
   :outertype: TerminalModel

   Gets the depth.

   :return: the depth

getHeight
^^^^^^^^^

.. java:method:: public Integer getHeight()
   :outertype: TerminalModel

   Gets the height.

   :return: the height

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: TerminalModel

   Gets the id.

   :return: the id

getManufacturer
^^^^^^^^^^^^^^^

.. java:method:: public String getManufacturer()
   :outertype: TerminalModel

   Gets the manufacturer.

   :return: the manufacturer

getMaxWeight
^^^^^^^^^^^^

.. java:method:: public Double getMaxWeight()
   :outertype: TerminalModel

   Gets the max weight.

   :return: the max weight

getMinWeight
^^^^^^^^^^^^

.. java:method:: public Double getMinWeight()
   :outertype: TerminalModel

   Gets the min weight.

   :return: the min weight

getModel
^^^^^^^^

.. java:method:: public String getModel()
   :outertype: TerminalModel

   Gets the model.

   :return: the model

getNickname
^^^^^^^^^^^

.. java:method:: public String getNickname()
   :outertype: TerminalModel

   Gets the nickname.

   :return: the nickname

getPhoto
^^^^^^^^

.. java:method:: public byte[] getPhoto()
   :outertype: TerminalModel

   Gets the photo.

   :return: the photo

getPhotoAsImage
^^^^^^^^^^^^^^^

.. java:method:: public BufferedImage getPhotoAsImage(int width, int height)
   :outertype: TerminalModel

   Gets the photo as image.

   :param width: the width
   :param height: the height
   :return: the photo as image

getProductClass
^^^^^^^^^^^^^^^

.. java:method:: public String getProductClass()
   :outertype: TerminalModel

   Gets the product class.

   :return: the product class

getWidth
^^^^^^^^

.. java:method:: public Integer getWidth()
   :outertype: TerminalModel

   Gets the width.

   :return: the width

setDepth
^^^^^^^^

.. java:method:: public void setDepth(Integer depth)
   :outertype: TerminalModel

   Sets the depth.

   :param depth: the new depth

setHeight
^^^^^^^^^

.. java:method:: public void setHeight(Integer height)
   :outertype: TerminalModel

   Sets the height.

   :param height: the new height

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: TerminalModel

   Sets the id.

   :param id: the id to set

setManufacturer
^^^^^^^^^^^^^^^

.. java:method:: public void setManufacturer(String manufacturer)
   :outertype: TerminalModel

   Sets the manufacturer.

   :param manufacturer: the new manufacturer

setMaxWeight
^^^^^^^^^^^^

.. java:method:: public void setMaxWeight(Double maxWeight)
   :outertype: TerminalModel

   Sets the max weight.

   :param maxWeight: the new max weight

setMinWeight
^^^^^^^^^^^^

.. java:method:: public void setMinWeight(Double minWeight)
   :outertype: TerminalModel

   Sets the min weight.

   :param minWeight: the new min weight

setModel
^^^^^^^^

.. java:method:: public void setModel(String model)
   :outertype: TerminalModel

   Sets the model.

   :param model: the new model

setNickname
^^^^^^^^^^^

.. java:method:: public void setNickname(String nickname)
   :outertype: TerminalModel

   Sets the nickname.

   :param nickname: the new nickname

setPhoto
^^^^^^^^

.. java:method:: public void setPhoto(byte[] photo)
   :outertype: TerminalModel

   Sets the photo.

   :param photo: the new photo

setProductClass
^^^^^^^^^^^^^^^

.. java:method:: public void setProductClass(String productClass)
   :outertype: TerminalModel

   Sets the product class.

   :param productClass: the new product class

setWidth
^^^^^^^^

.. java:method:: public void setWidth(Integer width)
   :outertype: TerminalModel

   Sets the width.

   :param width: the new width

