package com.spring.controller;
/*
 path attribute – it must correspond to a getter or setter of the model attribute (in this case, the Employee class).
 When the page is loaded, the input fields are populated by Spring, which calls the getter of each field bound to an
 input field. When the form is submitted, the setters are called to save the values of the form to the object.
 Finally – when the form is submitted, the POST handler in the controller is invoked and the form is automatically
  bound to the employee argument that we passed in.
 
Command Object - a JavaBean which will be populated with the data from your forms
Think  Command Object as a POJO/JavaBean that backs the form in your presentation layer. 
Once the form is submitted, all the individual attributes are mapped/bound to this object.
 Command Object properties may be used to pre/populate the form.

An @ModelAttribute on a method argument indicates the argument should be retrieved from the model.
	The argument's fields should be populated from all request parameters that have matching names.
	This is known as data binding in Spring MVC, a very useful mechanism that saves you from having 
	to parse each form field individually.

  
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.spring.bean.Employee;
import com.spring.dao.EmployeeDaoImpl;
@Controller
public class EmployeeController {
	@Autowired
	EmployeeDaoImpl edao;
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
		public ModelAndView employee() {
		return new ModelAndView("employeeForm", "command", new Employee());
			}
	
	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public ModelAndView getAllEmp() {
		
	  List<Employee> elist=new ArrayList<Employee>();   
		elist=edao.getAll();
		 Map<String, Object> model = new HashMap<String, Object>();
		 model.put("emplist", elist);
		 return new ModelAndView("empdetails", "model", model);
		
		 //return new ModelAndView("empdetails", "emplist", elist);
		}
	
	@RequestMapping(value = "/addEmp", method = RequestMethod.GET)
	public String  addEmployee1(Employee emp,ModelMap map) {
		edao.save(emp);
		map.addAttribute("msg", "success");
		//return new ModelAndView("redirect:success.jsp",map);
		return  "redirect:/success";

				}
	}
