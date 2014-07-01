package com.ncr.ATMMonitoring.pojo;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.type.Type;

import com.ncr.ATMMonitoring.utils.Operation;

/**
 * The UPS Query Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "ups_queries")
public class UpsQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /** The comboboxes data for the query designer. */
    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	comboboxes.put("ups", Ups.getComboboxes());
    }

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ups_queries_id_seq")
    @SequenceGenerator(name = "ups_queries_id_seq", sequenceName = "ups_queries_id_seq", allocationSize = 1)
    private Integer id;

    /** The name. */
    @Column(name = "query_name", length = 50, nullable = false)
    private String name = "";

    /** The description. */
    @Column(name = "description", length = 200)
    private String description = "";

    /** The creation date. */
    @Column(name = "creation_date")
    private Date creationDate;

    /** The user. */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /** The locale. */
    @Column(name = "locale", length = 10)
    private String locale;

    /** The UPS combo11 value. */
    @Column(name = "ups_c11", length = 50)
    private String upsCombo11 = "";

    /** The UPS combo12 value. */
    @Column(name = "ups_c12", length = 50)
    private String upsCombo12 = "";

    /** The UPS checkbox1 value. */
    @Column(name = "ups_cb1")
    private Boolean upsCB1 = false;

    /** The UPS field1 value. */
    @Column(name = "ups_f1", length = 150)
    private String upsField1 = "";

    /** The UPS combo21 value. */
    @Column(name = "ups_c21", length = 50)
    private String upsCombo21 = "";

    /** The UPS combo22 value. */
    @Column(name = "ups_c22", length = 50)
    private String upsCombo22 = "";

    /** The UPS checkbox2 value. */
    @Column(name = "ups_cb2")
    private Boolean upsCB2 = false;

    /** The UPS field2 value. */
    @Column(name = "ups_f2", length = 150)
    private String upsField2 = "";

    /** The UPS combo31 value. */
    @Column(name = "ups_c31", length = 50)
    private String upsCombo31 = "";

    /** The UPS combo32 value. */
    @Column(name = "ups_c32", length = 50)
    private String upsCombo32 = "";

    /** The UPS checkbox3 value. */
    @Column(name = "ups_cb3")
    private Boolean upsCB3 = false;

    /** The UPS field3 value. */
    @Column(name = "ups_f3", length = 150)
    private String upsField3 = "";

    /** The UPS combo41 value. */
    @Column(name = "ups_c41", length = 50)
    private String upsCombo41 = "";

    /** The UPS combo42 value. */
    @Column(name = "ups_c42", length = 50)
    private String upsCombo42 = "";

    /** The UPS checkbox4 value. */
    @Column(name = "ups_cb4")
    private Boolean upsCB4 = false;

    /** The UPS field4 value. */
    @Column(name = "ups_f4", length = 150)
    private String upsField4 = "";

    /** The UPS combo51 value. */
    @Column(name = "ups_c51", length = 50)
    private String upsCombo51 = "";

    /** The UPS combo52 value. */
    @Column(name = "ups_c52", length = 50)
    private String upsCombo52 = "";

    /** The UPS checkbox5 value. */
    @Column(name = "ups_cb5")
    private Boolean upsCB5 = false;

    /** The UPS field5 value. */
    @Column(name = "ups_f5", length = 150)
    private String upsField5 = "";

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Gets the user.
     * 
     * @return the user
     */
    public User getUser() {
	return user;
    }

    /**
     * Sets the user.
     * 
     * @param user
     *            the user to set
     */
    public void setUser(User user) {
	this.user = user;
    }

    /**
     * Gets the comboboxes data for the query GUI.
     * 
     * @return the comboboxes data
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
    }

    /**
     * Gets the UPS combo11 value.
     * 
     * @return the upsCombo11
     */
    public String getUpsCombo11() {
	return upsCombo11;
    }

    /**
     * Gets the UPS combo12 value.
     * 
     * @return the upsCombo12
     */
    public String getUpsCombo12() {
	return upsCombo12;
    }

    /**
     * Gets the UPS field1 value.
     * 
     * @return the upsField1
     */
    public String getUpsField1() {
	return upsField1;
    }

    /**
     * Sets the UPS combo11 value.
     * 
     * @param upsCombo11
     *            the upsCombo11 to set
     */
    public void setUpsCombo11(String upsCombo11) {
	this.upsCombo11 = upsCombo11;
    }

    /**
     * Sets the UPS combo12 value.
     * 
     * @param upsCombo12
     *            the upsCombo12 to set
     */
    public void setUpsCombo12(String upsCombo12) {
	this.upsCombo12 = upsCombo12;
    }

    /**
     * Sets the UPS field1 value.
     * 
     * @param upsField1
     *            the upsField1 to set
     */
    public void setUpsField1(String upsField1) {
	this.upsField1 = upsField1;
    }

    /**
     * Gets the UPS combo21 value.
     * 
     * @return the upsCombo21
     */
    public String getUpsCombo21() {
	return upsCombo21;
    }

    /**
     * Gets the UPS combo22 value.
     * 
     * @return the upsCombo22
     */
    public String getUpsCombo22() {
	return upsCombo22;
    }

    /**
     * Gets the UPS field2 value.
     * 
     * @return the upsField2
     */
    public String getUpsField2() {
	return upsField2;
    }

    /**
     * Gets the UPS combo31 value.
     * 
     * @return the upsCombo31
     */
    public String getUpsCombo31() {
	return upsCombo31;
    }

    /**
     * Gets the UPS combo32 value.
     * 
     * @return the upsCombo32
     */
    public String getUpsCombo32() {
	return upsCombo32;
    }

    /**
     * Gets the UPS field3 value.
     * 
     * @return the upsField3
     */
    public String getUpsField3() {
	return upsField3;
    }

    /**
     * Gets the UPS combo41 value.
     * 
     * @return the upsCombo41
     */
    public String getUpsCombo41() {
	return upsCombo41;
    }

    /**
     * Gets the UPS combo42 value.
     * 
     * @return the upsCombo42
     */
    public String getUpsCombo42() {
	return upsCombo42;
    }

    /**
     * Gets the UPS field4 value.
     * 
     * @return the upsField4
     */
    public String getUpsField4() {
	return upsField4;
    }

    /**
     * Gets the UPS combo51 value.
     * 
     * @return the upsCombo51
     */
    public String getUpsCombo51() {
	return upsCombo51;
    }

    /**
     * Gets the UPS combo52 value.
     * 
     * @return the upsCombo52
     */
    public String getUpsCombo52() {
	return upsCombo52;
    }

    /**
     * Gets the UPS field5 value.
     * 
     * @return the upsField5
     */
    public String getUpsField5() {
	return upsField5;
    }

    /**
     * Sets the UPS combo21 value.
     * 
     * @param upsCombo21
     *            the upsCombo21 to set
     */
    public void setUpsCombo21(String upsCombo21) {
	this.upsCombo21 = upsCombo21;
    }

    /**
     * Sets the UPS combo22 value.
     * 
     * @param upsCombo22
     *            the upsCombo22 to set
     */
    public void setUpsCombo22(String upsCombo22) {
	this.upsCombo22 = upsCombo22;
    }

    /**
     * Sets the UPS field2 value.
     * 
     * @param upsField2
     *            the upsField2 to set
     */
    public void setUpsField2(String upsField2) {
	this.upsField2 = upsField2;
    }

    /**
     * Sets the UPS combo31 value.
     * 
     * @param upsCombo31
     *            the upsCombo31 to set
     */
    public void setUpsCombo31(String upsCombo31) {
	this.upsCombo31 = upsCombo31;
    }

    /**
     * Sets the UPS combo32 value.
     * 
     * @param upsCombo32
     *            the upsCombo32 to set
     */
    public void setUpsCombo32(String upsCombo32) {
	this.upsCombo32 = upsCombo32;
    }

    /**
     * Sets the UPS field3 value.
     * 
     * @param upsField3
     *            the upsField3 to set
     */
    public void setUpsField3(String upsField3) {
	this.upsField3 = upsField3;
    }

    /**
     * Sets the UPS combo41 value.
     * 
     * @param upsCombo41
     *            the upsCombo41 to set
     */
    public void setUpsCombo41(String upsCombo41) {
	this.upsCombo41 = upsCombo41;
    }

    /**
     * Sets the UPS combo42 value.
     * 
     * @param upsCombo42
     *            the upsCombo42 to set
     */
    public void setUpsCombo42(String upsCombo42) {
	this.upsCombo42 = upsCombo42;
    }

    /**
     * Sets the UPS field4 value.
     * 
     * @param upsField4
     *            the upsField4 to set
     */
    public void setUpsField4(String upsField4) {
	this.upsField4 = upsField4;
    }

    /**
     * Sets the UPS combo51 value.
     * 
     * @param upsCombo51
     *            the upsCombo51 to set
     */
    public void setUpsCombo51(String upsCombo51) {
	this.upsCombo51 = upsCombo51;
    }

    /**
     * Sets the UPS combo52 value.
     * 
     * @param upsCombo52
     *            the upsCombo52 to set
     */
    public void setUpsCombo52(String upsCombo52) {
	this.upsCombo52 = upsCombo52;
    }

    /**
     * Sets the UPS field5 value.
     * 
     * @param upsField5
     *            the upsField5 to set
     */
    public void setUpsField5(String upsField5) {
	this.upsField5 = upsField5;
    }

    /**
     * Gets the UPS checkbox1 value.
     * 
     * @return the upsCB1
     */
    public Boolean getUpsCB1() {
	return upsCB1;
    }

    /**
     * Gets the UPS checkbox2 value.
     * 
     * @return the upsCB2
     */
    public Boolean getUpsCB2() {
	return upsCB2;
    }

    /**
     * Gets the UPS checkbox3 value.
     * 
     * @return the upsCB3
     */
    public Boolean getUpsCB3() {
	return upsCB3;
    }

    /**
     * Gets the UPS checkbox4 value.
     * 
     * @return the upsCB4
     */
    public Boolean getUpsCB4() {
	return upsCB4;
    }

    /**
     * Gets the UPS checkbox5 value.
     * 
     * @return the upsCB5
     */
    public Boolean getUpsCB5() {
	return upsCB5;
    }

    /**
     * Sets the UPS checkbox1 value.
     * 
     * @param upsCB1
     *            the upsCB1 to set
     */
    public void setUpsCB1(Boolean upsCB1) {
	this.upsCB1 = upsCB1;
    }

    /**
     * Sets the UPS checkbox2 value.
     * 
     * @param upsCB2
     *            the upsCB2 to set
     */
    public void setUpsCB2(Boolean upsCB2) {
	this.upsCB2 = upsCB2;
    }

    /**
     * Sets the UPS checkbox3 value.
     * 
     * @param upsCB3
     *            the upsCB3 to set
     */
    public void setUpsCB3(Boolean upsCB3) {
	this.upsCB3 = upsCB3;
    }

    /**
     * Sets the UPS checkbox4 value.
     * 
     * @param upsCB4
     *            the upsCB4 to set
     */
    public void setUpsCB4(Boolean upsCB4) {
	this.upsCB4 = upsCB4;
    }

    /**
     * Sets the UPS checkbox5 value.
     * 
     * @param upsCB5
     *            the upsCB5 to set
     */
    public void setUpsCB5(Boolean upsCB5) {
	this.upsCB5 = upsCB5;
    }

    /**
     * Gets the UPS HQL constraints.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the UPS HQL constraints
     */
    private String getUpsConstraints(List<Object> values, List<Type> types,
	    Locale locale) {
	String constraints = "";
	constraints += getConstraint("ups." + upsCombo11, upsCombo12,
		upsField1, upsCB1, values, types, locale);
	constraints += getConstraint("ups." + upsCombo21, upsCombo22,
		upsField2, upsCB2, values, types, locale);
	constraints += getConstraint("ups." + upsCombo31, upsCombo32,
		upsField3, upsCB3, values, types, locale);
	constraints += getConstraint("ups." + upsCombo41, upsCombo42,
		upsField4, upsCB4, values, types, locale);
	constraints += getConstraint("ups." + upsCombo51, upsCombo52,
		upsField5, upsCB5, values, types, locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	return constraints;
    }

    /**
     * Gets the HQL constraint for the specified data.
     * 
     * @param column
     *            the DB column
     * @param operation
     *            the operation
     * @param value
     *            the value
     * @param not
     *            whether it's negated or not
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the HQL constraint
     */
    private String getConstraint(String column, String operation, String value,
	    boolean not, List<Object> values, List<Type> types, Locale locale) {
	if (!(column.equals("") || operation.equals("") || (value.equals("") && Operation
		.needsNotVoidValue(operation)))) {
	    String constraint = "("
		    + Operation.getConstraintHQL(column, operation, value,
			    values, types, locale) + ")";
	    if (constraint.length() > 0) {
		if (not) {
		    constraint = "not " + constraint;
		}
		constraint += " and ";
	    }
	    return constraint;
	}
	return "";
    }

    /**
     * Gets the HQL for the stored data, and stores values and types in the
     * passed variables. No duplicated data is shown and upss are ordered by
     * serial number and id.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the resulting HQL
     */
    public String getHQL(List<Object> values, List<Type> types, Locale locale) {
	return getHQL(values, types, locale, true, true);
    }

    /**
     * Gets the HQL for the stored data, and stores values and types in the
     * passed variables. No duplicated data is shown.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @param order
     *            whether we want the upss ordered by serial number and id
     * @return the resulting HQL
     */
    public String getHQL(List<Object> values, List<Type> types, Locale locale,
	    boolean order) {
	return getHQL(values, types, locale, true, order);
    }

    /**
     * Gets the HQL for the stored data, and stores values and types in the
     * passed variables.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @param distinct
     *            whether we want to prevent duplicated data to appear
     * @param order
     *            whether we want the upss ordered by serial number and id
     * @return the resulting HQL
     */
    public String getHQL(List<Object> values, List<Type> types, Locale locale,
	    boolean distinct, boolean order) {
	String hql = "select";
	if (distinct) {
	    hql += " distinct";
	}
	hql += " ups from Ups ups where "
		+ getUpsConstraints(values, types, locale);
	if (order) {
	    hql += " order by ups.seriesNumber, ups.id";
	}
	return hql;
    }

    /**
     * Gets the locale.
     * 
     * @return the locale
     */
    public String getLocale() {
	return locale;
    }

    /**
     * Sets the locale.
     * 
     * @param locale
     *            the new locale
     */
    public void setLocale(String locale) {
	this.locale = locale;
    }

    /**
     * Gets the true locale.
     * 
     * @return the true locale
     */
    public Locale getTrueLocale() {
	if (locale != null) {
	    String[] localeSplit = locale.split("-");
	    if (localeSplit.length >= 2) {
		return new Locale(localeSplit[0], localeSplit[1]);
	    } else {
		if (localeSplit.length == 1) {
		    return new Locale(localeSplit[0]);
		}
	    }
	}
	return null;
    }

    /**
     * Sets the true locale.
     * 
     * @param locale
     *            the new true locale
     */
    public void setTrueLocale(Locale locale) {
	this.locale = locale.getLanguage() + "-" + locale.getCountry();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
	if (o == null) {
	    return false;
	}
	if (o instanceof UpsQuery) {
	    UpsQuery otherQuery = (UpsQuery) o;
	    return ((otherQuery.getName().equals(getName())) && (otherQuery
		    .getUser().equals(getUser())));
	} else {
	    return false;
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	return getName().hashCode() + 27 * getUser().hashCode();
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * Sets the description.
     * 
     * @param description
     *            the new description
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Gets the creation date.
     * 
     * @return the creation date
     */
    public Date getCreationDate() {
	return creationDate;
    }

    /**
     * Sets the creation date.
     * 
     * @param creationDate
     *            the new creation date
     */
    public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
    }

    /**
     * Gets the creation date short.
     * 
     * @return the creation date short
     */
    public String getCreationDateShort() {
	return (creationDate != null) ? DateFormat.getDateInstance(
		DateFormat.SHORT, Locale.getDefault()).format(creationDate)
		: "";
    }

}
