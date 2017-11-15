package com.employee;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.employee.dao.EmployeeDAO;
import com.google.gson.Gson;

@Path("/EmployeeServices")
public class RestServices {

	/**
	 * Get Service Which will call from AngularJS to Fetch 
	 * all employees from the Employee Table.
	 *  
	 * @return
	 */
	@GET
	@Path("/GetEmployees")
	@Produces("application/json")
	public String getEmployee() {
		EmployeeDAO dao = new EmployeeDAO();
		String employees = null;
		List employeeList = dao.getEmployees();
		Gson gson = new Gson();
		System.out.println(gson.toJson(employeeList));
		employees = gson.toJson(employeeList);
		return employees;
	} 
}