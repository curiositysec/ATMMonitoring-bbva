package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncr.ATMMonitoring.controller.propertyeditor.BankCompanyPropertyEditor;
import com.ncr.ATMMonitoring.controller.propertyeditor.RolePropertyEditor;
import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Role;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.BankCompanyService;
import com.ncr.ATMMonitoring.service.RoleService;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * The Class UserController.
 * 
 * Controller for handling user related HTTP petitions.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class UserController extends GenericController {

    /** The logger. */
    static private Logger logger = Logger.getLogger(UserController.class
	    .getName());

    /** The Constant DEFAULT_USER_SORT. */
    public static final String DEFAULT_USER_SORT = "username";

    /** The Constant DEFAULT_USER_ORDER. */
    public static final String DEFAULT_USER_ORDER = "asc";

    /** The Constant DEFAULT_ROLE_SORT. */
    public static final String DEFAULT_ROLE_SORT = "name";

    /** The Constant DEFAULT_USER_ORDER. */
    public static final String DEFAULT_ROLE_ORDER = "asc";

    /** The user page size. */
    @Value("${config.usersPageSize}")
    private int userPageSize;

    /** The role page size. */
    @Value("${config.rolesPageSize}")
    private int rolePageSize;

    /** The user service. */
    @Autowired
    private UserService userService;

    /** The role service. */
    @Autowired
    private RoleService roleService;

    /** The bank company service. */
    @Autowired
    private BankCompanyService bankCompanyService;

    /**
     * Binds custom property editors.
     * 
     * @param binder
     *            the binder
     * @throws Exception
     *             the exception
     */
    @InitBinder
    protected void binder(WebDataBinder binder) throws Exception {
	binder.registerCustomEditor(Role.class, new RolePropertyEditor(
		roleService));
	binder.registerCustomEditor(BankCompany.class,
		new BankCompanyPropertyEditor(bankCompanyService));
    }

    /**
     * Redirect to users list URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/users" })
    public String redirectToUsers() {
	return "redirect:/users/list";
    }

    /**
     * List users and roles URL.
     * 
     * @param map
     *            the map
     * @param principal
     *            the principal
     * @param p1
     *            the page number for users
     * @param sort1
     *            the field for sorting users
     * @param order1
     *            the order for sorting users
     * @param p2
     *            the page number for roles
     * @param sort2
     *            the field for sorting roles
     * @param order2
     *            the order for sorting roles
     * @param request
     *            the request
     * @return the petition response
     */
    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    public String listUsersAndRoles(Map<String, Object> map,
	    Principal principal, String p1, String sort1, String order1,
	    String p2, String sort2, String order2, HttpServletRequest request) {
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	String sortValue1 = (sort1 == null) ? DEFAULT_USER_SORT : sort1;
	String orderValue1 = (order1 == null) ? DEFAULT_USER_ORDER : order1;
	PagedListHolder<User> pagedListHolder1 = new PagedListHolder<User>(
		userService.listUsers(sortValue1, orderValue1));
	map.put("userMsg", userMsg);
	map.put("sort1", sortValue1);
	map.put("order1", orderValue1);
	int page1 = 0;
	if (p1 != null) {
	    try {
		page1 = Integer.parseInt(p1);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	pagedListHolder1.setPage(page1);
	pagedListHolder1.setPageSize(userPageSize);
	map.put("pagedListHolder1", pagedListHolder1);

	String sortValue2 = (sort2 == null) ? DEFAULT_ROLE_SORT : sort2;
	String orderValue2 = (order2 == null) ? DEFAULT_ROLE_ORDER : order2;
	PagedListHolder<Role> pagedListHolder2 = new PagedListHolder<Role>(
		roleService.listManageableRoles(sortValue2, orderValue2));
	map.put("sort2", sortValue2);
	map.put("order2", orderValue2);
	int page2 = 0;
	if (p2 != null) {
	    try {
		page2 = Integer.parseInt(p2);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	pagedListHolder2.setPage(page2);
	pagedListHolder2.setPageSize(rolePageSize);
	map.put("pagedListHolder2", pagedListHolder2);
	map.put("role", new Role());

	return "users";
    }

    /**
     * User details URL.
     * 
     * @param userId
     *            the user id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping("/users/details/{userId}")
    public String userDetails(@PathVariable("userId") Integer userId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	User user = userService.getUser(userId);
	if (user == null) {
	    return "redirect:/users/list";
	}
	String userMsg = "";
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	// TODO
	// Actualizar los permisos
	boolean canEdit = true;
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    // TODO
	    // Revisar la gestión de permisos mediante bancos
	    // bankCompanies = loggedUser.getManageableBankCompanies();
	    // if ((user.getBankCompany() != null)
	    // && (!bankCompanies.contains(user.getBankCompany()))) {
	    // return "redirect:/users/list";
	    // }
	}
	map.put("canEdit", canEdit);
	map.put("banksList", bankCompanies);
	map.put("userMsg", userMsg);
	map.put("manageableRolesList", roleService.listManageableRoles());
	map.put("user", user);

	return "userDetails";
    }

    /**
     * Update user URL.
     * 
     * @param user
     *            the user
     * @param result
     *            the result
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/users/update", method = RequestMethod.POST)
    public String updateUser(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	String userMsg = "";
	// TODO
	// Revisar la gestión de permisos mediante bancos
	// Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    // bankCompanies = loggedUser.getManageableBankCompanies();
	}
	// map.put("banksList", bankCompanies);
	map.put("userMsg", userMsg);

	// The role is the only currently editable field
	if ((user.getId() != null) && (user.getRole() != null)) {
	    Role role = user.getRole();
	    user = userService.getUser(user.getId());
	    if (user.getRole().getManageable()) {
		user.setRole(role);
		userService.updateUser(user);
	    }
	}

	map.clear();
	return "redirect:/users/details/" + user.getId().intValue();
    }

    /**
     * Redirect to roles list URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/users/roles" })
    public String redirectToRoles() {
	return "redirect:/users/list";
    }

    /**
     * User details URL.
     * 
     * @param roleId
     *            the user id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping("/users/roles/details/{roleId}")
    public String roleDetails(@PathVariable("roleId") Integer roleId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	Role role = roleService.getRole(roleId);
	if ((role == null) || (!role.getManageable())) {
	    return "redirect:/users/list";
	}
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	map.put("role", role);

	return "roleDetails";
    }

    /**
     * Update role URL.
     * 
     * @param role
     *            the role
     * @param result
     *            the result
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/users/roles/update", method = RequestMethod.POST)
    public String updateRole(@Valid @ModelAttribute("role") Role role,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {

	if (role != null) {
	    Role roleAux = roleService.getRole(role.getId());
	    if ((roleAux != null) && (roleAux.getManageable())) {
		role.setManageable(true);
		roleAux = roleService.getRoleByName(role.getName());
		if ((roleAux != null)
			&& (!roleAux.getId().equals(role.getId()))) {
		    String userMsg = "";
		    // TODO
		    // Actualizar los permisos
		    boolean canEdit = true;
		    if (principal != null) {
			userMsg = this.getUserGreeting(principal, request);
		    }
		    map.put("canEdit", canEdit);
		    map.put("userMsg", userMsg);
		    map.put("role", role);
		    map.put("duplicatedName", true);

		    return "roleDetails";
		}
		roleService.updateRole(role);
	    }
	}

	map.clear();
	return "redirect:/users/roles/details/" + role.getId().intValue();
    }

    /**
     * Add role URL.
     * 
     * @param role
     *            the role
     * @param result
     *            the result
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/users/roles/add", method = RequestMethod.POST)
    public String addRole(@Valid @ModelAttribute("role") Role role,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {

	if (role != null) {
	    role.setManageable(true);
	    Role roleAux = roleService.getRoleByName(role.getName());
	    if ((roleAux != null) && (!roleAux.getId().equals(role.getId()))) {

		String userMsg = "";
		if (principal != null) {
		    userMsg = this.getUserGreeting(principal, request);
		}
		String sortValue1 = DEFAULT_USER_SORT;
		String orderValue1 = DEFAULT_USER_ORDER;
		PagedListHolder<User> pagedListHolder1 = new PagedListHolder<User>(
			userService.listUsers(sortValue1, orderValue1));
		map.put("userMsg", userMsg);
		map.put("sort1", sortValue1);
		map.put("order1", orderValue1);
		pagedListHolder1.setPage(0);
		pagedListHolder1.setPageSize(userPageSize);
		map.put("pagedListHolder1", pagedListHolder1);

		String sortValue2 = DEFAULT_ROLE_SORT;
		String orderValue2 = DEFAULT_ROLE_ORDER;
		PagedListHolder<Role> pagedListHolder2 = new PagedListHolder<Role>(
			roleService
				.listManageableRoles(sortValue2, orderValue2));
		map.put("sort2", sortValue2);
		map.put("order2", orderValue2);
		pagedListHolder2.setPage(0);
		pagedListHolder2.setPageSize(rolePageSize);
		map.put("pagedListHolder2", pagedListHolder2);
		map.put("duplicatedName", true);

		return "users";
	    }
	    roleService.addRole(role);
	}

	map.clear();
	return "redirect:/users/roles/details/" + role.getId().intValue();
    }

    /**
     * Delete role URL.
     * 
     * @param roleId
     *            the role id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/users/roles/delete", method = RequestMethod.GET)
    public String deleteUserQuery(Integer roleId, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {

	if (roleId != null) {
	    Role role = roleService.getRole(roleId);
	    if (role != null) {
		if ((role.getUsers().size() == 0)
			&& (role.getManageable() != null)
			&& (role.getManageable())) {
		    roleService.deleteRole(role);
		}
	    }
	}

	return "redirect:/users/list";

    }

    /**
     * New group URL.
     * 
     * @return the petition response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/newGroup")
    public String newGroup(Map<String, Object> map, Principal principal,
	    HttpServletRequest request) {
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	return "newGroup";
    }

}
