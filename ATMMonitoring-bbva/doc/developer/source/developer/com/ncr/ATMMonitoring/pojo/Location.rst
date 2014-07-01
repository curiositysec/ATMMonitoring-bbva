.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: javax.persistence UniqueConstraint

.. java:import:: org.hibernate.annotations Formula

.. java:import:: org.hibernate.annotations Type

Location
========

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class Location

   The Location Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Fields
------
addressCityAndCountry
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: @Formula public String addressCityAndCountry
   :outertype: Location

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: Location

getAddressCity
^^^^^^^^^^^^^^

.. java:method:: public String getAddressCity()
   :outertype: Location

   Gets the address city.

   :return: the address city

getAddressCountry
^^^^^^^^^^^^^^^^^

.. java:method:: public String getAddressCountry()
   :outertype: Location

   Gets the address country.

   :return: the address country

getAddressNumber
^^^^^^^^^^^^^^^^

.. java:method:: public String getAddressNumber()
   :outertype: Location

   Gets the address number.

   :return: the address number

getAddressPostcode
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getAddressPostcode()
   :outertype: Location

   Gets the address postcode.

   :return: the address postcode

getAddressStreet
^^^^^^^^^^^^^^^^

.. java:method:: public String getAddressStreet()
   :outertype: Location

   Gets the address street.

   :return: the address street

getBank
^^^^^^^

.. java:method:: public String getBank()
   :outertype: Location

   Gets the bank.

   :return: the bank

getBankCompany
^^^^^^^^^^^^^^

.. java:method:: public String getBankCompany()
   :outertype: Location

   Gets the bank company.

   :return: the bank company

getCompleteAddress
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getCompleteAddress()
   :outertype: Location

   Gets the complete address.

   :return: the complete address

getCoordX
^^^^^^^^^

.. java:method:: public Double getCoordX()
   :outertype: Location

   Gets the coord x.

   :return: the coord x

getCoordY
^^^^^^^^^

.. java:method:: public Double getCoordY()
   :outertype: Location

   Gets the coord y.

   :return: the coord y

getDisplaced
^^^^^^^^^^^^

.. java:method:: public Boolean getDisplaced()
   :outertype: Location

   Gets the displaced.

   :return: the displaced

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: Location

   Gets the id.

   :return: the id

getOffice
^^^^^^^^^

.. java:method:: public String getOffice()
   :outertype: Location

   Gets the office.

   :return: the office

getPublicAccess
^^^^^^^^^^^^^^^

.. java:method:: public Boolean getPublicAccess()
   :outertype: Location

   Gets the public access.

   :return: the public access

hasCoordinates
^^^^^^^^^^^^^^

.. java:method:: public boolean hasCoordinates()
   :outertype: Location

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: Location

setAddressCity
^^^^^^^^^^^^^^

.. java:method:: public void setAddressCity(String addressCity)
   :outertype: Location

   Sets the address city.

   :param addressCity: the new address city

setAddressCountry
^^^^^^^^^^^^^^^^^

.. java:method:: public void setAddressCountry(String addressCountry)
   :outertype: Location

   Sets the address country.

   :param addressCountry: the new address country

setAddressNumber
^^^^^^^^^^^^^^^^

.. java:method:: public void setAddressNumber(String addressNumber)
   :outertype: Location

   Sets the address number.

   :param addressNumber: the new address number

setAddressPostcode
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setAddressPostcode(String addressPostcode)
   :outertype: Location

   Sets the address postcode.

   :param addressPostcode: the new address postcode

setAddressStreet
^^^^^^^^^^^^^^^^

.. java:method:: public void setAddressStreet(String addressStreet)
   :outertype: Location

   Sets the address street.

   :param addressStreet: the new address street

setBank
^^^^^^^

.. java:method:: public void setBank(String bank)
   :outertype: Location

   Sets the bank.

   :param bank: the new bank

setBankCompany
^^^^^^^^^^^^^^

.. java:method:: public void setBankCompany(String bankCompany)
   :outertype: Location

   Sets the bank company.

   :param bankCompany: the new bank company

setCoordX
^^^^^^^^^

.. java:method:: public void setCoordX(Double coordX)
   :outertype: Location

   Sets the coord x.

   :param coordX: the new coord x

setCoordY
^^^^^^^^^

.. java:method:: public void setCoordY(Double coordY)
   :outertype: Location

   Sets the coord y.

   :param coordY: the new coord y

setDisplaced
^^^^^^^^^^^^

.. java:method:: public void setDisplaced(Boolean displaced)
   :outertype: Location

   Sets the displaced.

   :param displaced: the new displaced

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: Location

   Sets the id.

   :param id: the id to set

setOffice
^^^^^^^^^

.. java:method:: public void setOffice(String office)
   :outertype: Location

   Sets the office.

   :param office: the new office

setPublicAccess
^^^^^^^^^^^^^^^

.. java:method:: public void setPublicAccess(Boolean publicAccess)
   :outertype: Location

   Sets the public access.

   :param publicAccess: the new public access

