package com.ncr.ATMMonitoring.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * The widget category POJO
 * 
 * @author jmartin
 * 
 */
@Entity
@Table(name = "widget_category")
public class WidgetCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "widget_categories_id_seq")
    @SequenceGenerator(name = "widget_categories_id_seq", sequenceName = "widget_categories_id_seq", allocationSize = 1)
    private Integer id;

    /** The widgets. */
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @OrderBy("title")
    private List<Widget> widgets;

    /** The name */
    @Column(name = "name")
    private String name;

    /**
     * Default constructor
     */
    public WidgetCategory() {
	this.widgets = new ArrayList<Widget>();
    }

    /**
     * Get the id
     * 
     * @return The id
     */
    public Integer getId() {
	return id;
    }

    /**
     * Set the id
     * 
     * @param id
     *            The id
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Get widgets
     * 
     * @return The widgets
     */
    public List<Widget> getWidgets() {
	return widgets;
    }

    /**
     * Set the widgets
     * 
     * @param widgets
     *            The widgets
     */
    public void setWidgets(List<Widget> widgets) {
	this.widgets = widgets;
    }

    /**
     * Get the name
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Set the name
     * 
     * @param name
     *            The name
     */
    public void setName(String name) {
	this.name = name;
    }
}
