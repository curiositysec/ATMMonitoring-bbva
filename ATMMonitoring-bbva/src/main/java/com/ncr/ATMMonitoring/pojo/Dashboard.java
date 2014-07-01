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
 * The Dashboard Pojo.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */

@Entity
@Table(name = "dashboard")
public class Dashboard implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -958900960975875923L;

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dashboards_id_seq")
    @SequenceGenerator(name = "dashboards_id_seq", sequenceName = "dashboards_id_seq", allocationSize = 1)
    private Integer id;

    /** The columns. */
    @Column(name = "columns", nullable = false)
    private Integer columns;

    /** The widgets. */
    @OneToMany(mappedBy = "dashboard", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @OrderBy("order")
    private List<Widget> widgets;

    /**
     * Instantiates a new dashboard.
     */
    public Dashboard() {
	this.widgets = new ArrayList<Widget>();
    }

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
     *            the new id
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Gets the columns.
     * 
     * @return the columns
     */
    public Integer getColumns() {
	return columns;
    }

    /**
     * Sets the columns.
     * 
     * @param columns
     *            the new columns
     */
    public void setColumns(Integer columns) {
	this.columns = columns;
    }

    /**
     * Gets the widgets.
     * 
     * @return the widgets
     */
    public List<Widget> getWidgets() {
	return widgets;
    }

    /**
     * Sets the widgets.
     * 
     * @param widgets
     *            the new widgets
     */
    public void setWidgets(List<Widget> widgets) {
	this.widgets = widgets;
    }

    /**
     * Gets the visible widgets.
     * 
     * @return the visible widgets
     */
    public List<Widget> getVisibleWidgets() {
	List<Widget> visibleWidgets = new ArrayList<Widget>();
	for (Widget widget : widgets) {
	    if (widget.isVisible()) {
		visibleWidgets.add(widget);
	    }
	}
	return visibleWidgets;
    }

    /**
     * The Enum ColumnOptions.
     */
    public enum ColumnOptions {

	/** The one column. */
	ONE_COLUMN(1),
	/** The two columns. */
	TWO_COLUMNS(2),
	/** The three columns. */
	THREE_COLUMNS(3),
	/** The four columns. */
	FOUR_COLUMNS(4);

	/** The columns. */
	private int columns;

	/**
	 * Instantiates a new column options.
	 * 
	 * @param columns
	 *            the columns
	 */
	ColumnOptions(int columns) {
	    this.columns = columns;
	}

	/**
	 * Gets the columns.
	 * 
	 * @return the columns
	 */
	public int getColumns() {
	    return this.columns;
	}
    }

}
