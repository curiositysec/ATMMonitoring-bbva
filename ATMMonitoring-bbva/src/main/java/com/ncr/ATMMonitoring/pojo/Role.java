package com.ncr.ATMMonitoring.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * The Role Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8389177127546888232L;

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "roles_id_seq")
    @SequenceGenerator(name = "roles_id_seq", sequenceName = "roles_id_seq", allocationSize = 1)
    private Integer id;

    /** The name. */
    @Column(name = "name", length = 100, unique = true, nullable = false)
    private String name;

    /** The description. */
    @Column(name = "description", length = 300)
    private String description;

    /** The manageable flag (i.e. can be assigned and modified). */
    @Column(name = "manageable")
    private Boolean manageable;

    /** The flag that tells us whether the users can edit terminal data. */
    @Column(name = "can_edit_terminals", columnDefinition = "boolean default false")
    private Boolean canEditTerminals = false;

    /** The flag that tells us whether the users can view terminal data. */
    @Column(name = "can_view_terminals", columnDefinition = "boolean default false")
    private Boolean canViewTerminals = false;

    /** The flag that tells us whether the users can use queries. */
    @Column(name = "can_use_queries", columnDefinition = "boolean default false")
    private Boolean canUseQueries = false;

    /** The flag that tells us whether the users can request data update. */
    @Column(name = "can_request_update", columnDefinition = "boolean default false")
    private Boolean canRequestUpdate = false;

    /** The flag that tells us whether the users can schedule automatic updates. */
    @Column(name = "can_schedule", columnDefinition = "boolean default false")
    private Boolean canSchedule = false;

    /** The flag that tells us whether the users have access to the reports. */
    @Column(name = "can_access_reports", columnDefinition = "boolean default false")
    private Boolean canAccessReports = false;

    /** The flag that tells us whether the users can view UPS data. */
    @Column(name = "can_view_ups", columnDefinition = "boolean default false")
    private Boolean canViewUps = false;

    /** The flag that tells us whether the users can use UPS queries. */
    @Column(name = "can_use_ups_queries", columnDefinition = "boolean default false")
    private Boolean canUseUpsQueries = false;

    /** The flag that tells us whether the users are user managers. */
    @Column(name = "user_manager", columnDefinition = "boolean default false")
    private Boolean userManager = false;

    /**
     * The flag that tells us whether the users can add a widget to component
     * library
     */
    @Column(name = "can_edit_widgets_library", columnDefinition = "boolean default false")
    private Boolean canEditWidgetsLibrary = false;

    /** The users assigned to this role. */
    @OneToMany(mappedBy = "role")
    private Set<User> users;

    /**
     * Gets all the users who currently have this role.
     * 
     * @return the users
     */
    public Set<User> getUsers() {
	return users;
    }

    /**
     * Sets the users who currently have this role.
     * 
     * @param users
     *            the set of users to set
     */
    public void setUsers(Set<User> users) {
	this.users = users;
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
     * Whether the role is manageable (i.e. can be assigned and modified).
     * 
     * @return the manageable flag
     */
    public Boolean getManageable() {
	return manageable;
    }

    /**
     * Sets the manageable flag.
     * 
     * @param manageable
     *            the manageable flag to set
     */
    public void setManageable(Boolean manageable) {
	this.manageable = manageable;
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
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Whether the users is can edit terminal data.
     * 
     * @return the terminal data edition flag
     */
    public Boolean getCanEditTerminals() {
	return canEditTerminals;
    }

    /**
     * Sets the terminal data edition flag.
     * 
     * @param manageable
     *            the terminal data edition flag to set
     */
    public void setCanEditTerminals(Boolean canEditTerminals) {
	this.canEditTerminals = canEditTerminals;
    }

    /**
     * Gets the terminal data access flag.
     * 
     * @return the canViewTerminals flag
     */
    public Boolean getCanViewTerminals() {
	return canViewTerminals;
    }

    /**
     * Sets the terminal data access flag.
     * 
     * @param canViewTerminals
     *            the canViewTerminals flag to set
     */
    public void setCanViewTerminals(Boolean canViewTerminals) {
	this.canViewTerminals = canViewTerminals;
    }

    /**
     * Gets the query usage flag.
     * 
     * @return the canUseQueries flag
     */
    public Boolean getCanUseQueries() {
	return canUseQueries;
    }

    /**
     * Sets the query usage flag.
     * 
     * @param canUseQueries
     *            the canUseQueries flag to set
     */
    public void setCanUseQueries(Boolean canUseQueries) {
	this.canUseQueries = canUseQueries;
    }

    /**
     * Gets the update request usage flag.
     * 
     * @return the canRequestUpdate flag
     */
    public Boolean getCanRequestUpdate() {
	return canRequestUpdate;
    }

    /**
     * Sets the update request usage flag.
     * 
     * @param canRequestUpdate
     *            the canRequestUpdate flag to set
     */
    public void setCanRequestUpdate(Boolean canRequestUpdate) {
	this.canRequestUpdate = canRequestUpdate;
    }

    /**
     * Gets the schedule usage flag.
     * 
     * @return the canSchedule flag
     */
    public Boolean getCanSchedule() {
	return canSchedule;
    }

    /**
     * Sets the schedule usage flag.
     * 
     * @param canSchedule
     *            the canSchedule flag to set
     */
    public void setCanSchedule(Boolean canSchedule) {
	this.canSchedule = canSchedule;
    }

    /**
     * Gets the reports access flag.
     * 
     * @return the canAccessReports flag
     */
    public Boolean getCanAccessReports() {
	return canAccessReports;
    }

    /**
     * Sets the reports access flag.
     * 
     * @param canAccessReports
     *            the canAccessReports flag to set
     */
    public void setCanAccessReports(Boolean canAccessReports) {
	this.canAccessReports = canAccessReports;
    }

    /**
     * Gets the user management flag.
     * 
     * @return the userManager flag
     */
    public Boolean getUserManager() {
	return userManager;
    }

    /**
     * Sets the user management flag.
     * 
     * @param userManager
     *            the userManager flag to set
     */
    public void setUserManager(Boolean userManager) {
	this.userManager = userManager;
    }

    /**
     * Gets the UPS data access flag.
     * 
     * @return the UPS data access flag
     */
    public Boolean getCanViewUps() {
	return canViewUps;
    }

    /**
     * Sets the UPS data access flag.
     * 
     * @param canViewUps
     *            the UPS data access flag
     */
    public void setCanViewUps(Boolean canViewUps) {
	this.canViewUps = canViewUps;
    }

    /**
     * Gets the UPS queries usage flag.
     * 
     * @return the UPS queries usage flag
     */
    public Boolean getCanUseUpsQueries() {
	return canUseUpsQueries;
    }

    /**
     * Sets the UPS queries usage flag.
     * 
     * @param canUseUpsQueries
     *            the UPS queries usage flag to set
     */
    public void setCanUseUpsQueries(Boolean canUseUpsQueries) {
	this.canUseUpsQueries = canUseUpsQueries;
    }

    /**
     * Gets the widget library edition flag.
     * 
     * @return the widget library edition flag
     */
    public Boolean getCanEditWidgetsLibrary() {
	return canEditWidgetsLibrary;
    }

    /**
     * Sets the widget library edition flag.
     * 
     * @param canEditWidgetsLibrary
     *            the widget library edition flag to set
     */
    public void setCanEditWidgetsLibrary(Boolean canEditWidgetsLibrary) {
	this.canEditWidgetsLibrary = canEditWidgetsLibrary;
    }

    /**
     * Returns the granted authorities for this role.
     * 
     * @return the list of granted authorities
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {
	List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
	authList.add(new SimpleGrantedAuthority("CAN_ACCESS_HELP"));
	if (name != null) {
	    authList.add(new SimpleGrantedAuthority("ROLE_" + name));
	}
	if ((userManager != null) && userManager) {
	    authList.add(new SimpleGrantedAuthority("USER_MANAGER"));
	    return authList;
	}
	authList.add(new SimpleGrantedAuthority("CAN_ACCESS_DASHBOARD"));
	if ((canViewTerminals != null) && canViewTerminals) {
	    authList.add(new SimpleGrantedAuthority("CAN_VIEW_TERMINALS"));
	}
	if ((canEditTerminals != null) && canEditTerminals) {
	    authList.add(new SimpleGrantedAuthority("CAN_EDIT_TERMINALS"));
	}
	if ((canRequestUpdate != null) && canRequestUpdate) {
	    authList.add(new SimpleGrantedAuthority("CAN_REQUEST_UPDATE"));
	}
	if ((canUseQueries != null) && canUseQueries) {
	    authList.add(new SimpleGrantedAuthority("CAN_USE_QUERIES"));
	}
	if ((canSchedule != null) && canSchedule) {
	    authList.add(new SimpleGrantedAuthority("CAN_SCHEDULE"));
	}
	if ((canAccessReports != null) && canAccessReports) {
	    authList.add(new SimpleGrantedAuthority("CAN_ACCESS_REPORTS"));
	}
	if ((canEditWidgetsLibrary != null) && canEditWidgetsLibrary) {
	    authList.add(new SimpleGrantedAuthority("CAN_EDIT_WIDGETS_LIBRARY"));
	}
	if ((canViewUps != null) && canViewUps) {
	    authList.add(new SimpleGrantedAuthority("CAN_VIEW_UPS"));
	}
	if ((canUseUpsQueries != null) && canUseUpsQueries) {
	    authList.add(new SimpleGrantedAuthority("CAN_USE_UPS_QUERIES"));
	}

	return authList;
    }
}