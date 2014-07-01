package com.ncr.ATMMonitoring.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The User Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "users")
public class User implements UserDetails {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4609857457555155113L;

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    private Integer id;

    /** The firstname. */
    @Column(name = "firstname", length = 30)
    private String firstname;

    /** The lastname. */
    @Column(name = "lastname", length = 60)
    private String lastname;

    /** The username. */
    @NotEmpty
    @Column(name = "username", unique = true, nullable = false, length = 20)
    private String username;

    /** The password. */
    @NotEmpty
    @Size(min = 5)
    @Column(name = "passw", length = 80)
    private String password;

    /** The last login. */
    @Column(name = "last_login")
    private Date lastLogin;

    /** The role. */
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    /** The bank company. */
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankCompany bankCompany;

    /** The queries. */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("query_name")
    private Set<Query> queries = new HashSet<Query>();

    /** The UPS queries. */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("query_name")
    private Set<UpsQuery> upsQueries = new HashSet<UpsQuery>();

    /** The dashboard. */
    @OneToOne
    private Dashboard dashboard;

    // Code with support for Terminal Config AUTHORS
    //
    // @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    // @Cascade(CascadeType.ALL)
    // @OrderBy("start_date desc")
    // private Set<TerminalConfig> configs;
    //
    // /**
    // * @return the configs
    // */
    // public Set<TerminalConfig> getConfigs() {
    // return configs;
    // }
    //
    // /**
    // * @param configs the configs to set
    // */
    // public void setConfigs(Set<TerminalConfig> configs) {
    // this.configs = configs;
    // }

    /**
     * Instantiates a new user.
     */
    public User() {
    	this.role = new Role();
    };

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

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.core.userdetails.UserDetails#getUsername()
     */
    @Override
    public String getUsername() {
	return username;
    }

    /**
     * Sets the username.
     * 
     * @param username
     *            the new username
     */
    public void setUsername(String username) {
	this.username = username;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.core.userdetails.UserDetails#getPassword()
     */
    @Override
    public String getPassword() {
	return password;
    }

    /**
     * Sets the password.
     * 
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * Gets the firstname.
     * 
     * @return the firstname
     */
    public String getFirstname() {
	return firstname;
    }

    /**
     * Sets the firstname.
     * 
     * @param firstname
     *            the new firstname
     */
    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    /**
     * Gets the lastname.
     * 
     * @return the lastname
     */
    public String getLastname() {
	return lastname;
    }

    /**
     * Sets the lastname.
     * 
     * @param lastname
     *            the new lastname
     */
    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    /**
     * Gets the role.
     * 
     * @return the role
     */
    public Role getRole() {
	return role;
    }

    /**
     * Sets the role.
     * 
     * @param role
     *            the new role
     */
    public void setRole(Role role) {
	this.role = role;
    }

    /**
     * Gets the bank company.
     * 
     * @return the bankCompany
     */
    public BankCompany getBankCompany() {
	return bankCompany;
    }

    /**
     * Sets the bank company.
     * 
     * @param bankCompany
     *            the bankCompany to set
     */
    public void setBankCompany(BankCompany bankCompany) {
	this.bankCompany = bankCompany;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.core.userdetails.UserDetails#getAuthorities
     * ()
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	if (role != null) {
	    return role.getAuthorities();
	} else {
	    return new ArrayList<GrantedAuthority>();
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired
     * ()
     */
    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked
     * ()
     */
    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#
     * isCredentialsNonExpired()
     */
    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.core.userdetails.UserDetails#isEnabled()
     */
    @Override
    public boolean isEnabled() {
	return true;
    }

    /**
     * Gets the queries.
     * 
     * @return the queries
     */
    public Set<Query> getQueries() {
	return queries;
    }

    /**
     * Gets the UPS queries.
     * 
     * @return the UPS queries
     */
    public Set<UpsQuery> getUpsQueries() {
	return upsQueries;
    }

    /**
     * Sets the queries.
     * 
     * @param queries
     *            the queries to set
     */
    public void setQueries(Set<Query> queries) {
	this.queries = queries;
    }

    /**
     * Sets the UPS queries.
     * 
     * @param upsQueries
     *            the UPS queries to set
     */
    public void setUpsQueries(Set<UpsQuery> upsQueries) {
	this.upsQueries = upsQueries;
    }

    /**
     * Gets the last login date.
     * 
     * @return the last login date, or null if there is no previous login info
     */
    public Date getLastLogin() {
	return lastLogin;
    }

    /**
     * Sets the last login date.
     * 
     * @param lastLogin
     *            the last login date to set
     */
    public void setLastLogin(Date lastLogin) {
	this.lastLogin = lastLogin;
    }

    /**
     * Gets the dashboard.
     * 
     * @return the dashboard
     */
    public Dashboard getDashboard() {
	return dashboard;
    }

    /**
     * Sets the dashboard.
     * 
     * @param dashboard
     *            the new dashboard
     */
    public void setDashboard(Dashboard dashboard) {
	this.dashboard = dashboard;
    }

    /**
     * Gets the html welcome message customized with the user data.
     * 
     * @param locale
     *            the locale
     * @return the html welcome message
     */
    public String getHtmlWelcomeMessage(Locale locale) {
	DateFormat timeFormatter = new SimpleDateFormat("H:mm");
	String lastLoginFormatted = "";
	lastLoginFormatted = DateFormat.getDateInstance(DateFormat.SHORT,
		locale).format(lastLogin)
		+ " - " + timeFormatter.format(lastLogin);

	return "<div class=\"welcome\"><spring:message code=\"label.welcomeMessage\"/> "
		+ firstname
		+ " "
		+ lastname
		+ "</div>"
		+ "<div class=\"date\">" + lastLoginFormatted + "</div>";
    }

    /**
     * Gets the manageable bank companies.
     * 
     * @return the manageable bank companies
     */
    public Set<BankCompany> getManageableBankCompanies() {
	return (bankCompany != null) ? bankCompany.getManageableBankCompanies()
		: new HashSet<BankCompany>();
    }

    /**
     * Gets the weekly scheduled updates for the user's queries.
     * 
     * @return the weekly scheduled updates
     */
    public List<ScheduledUpdate> getWeeklyScheduledUpdates() {
	List<ScheduledUpdate> updates = new ArrayList<ScheduledUpdate>();
	for (Query query : queries) {
	    for (ScheduledUpdate update : query.getScheduledUpdates()) {
		if (update.getWeekDay() != null) {
		    updates.add(update);
		}
	    }
	}
	return updates;
    }

    /**
     * Gets the monthly scheduled updates for the user's queries.
     * 
     * @return the monthly scheduled updates
     */
    public List<ScheduledUpdate> getMonthlyScheduledUpdates() {
	List<ScheduledUpdate> updates = new ArrayList<ScheduledUpdate>();
	for (Query query : queries) {
	    for (ScheduledUpdate update : query.getScheduledUpdates()) {
		if (update.getMonthDay() != null) {
		    updates.add(update);
		}
	    }
	}
	return updates;
    }
}
