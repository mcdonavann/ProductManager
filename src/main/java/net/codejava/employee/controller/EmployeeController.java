package net.codejava.employee.controller;

import net.codejava.employee.model.Employee;
import net.codejava.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employee")
	public String viewHomePage(Model model) {
		List<Employee> employees = service.listAll();
		model.addAttribute("employees", employees);
		return "employee/list";
		
	}
	
	@GetMapping("/employee/new")
	public String showNewProductForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee/new_employee";
		
	}
	
	@PostMapping(value = "/employee/save")
	public String saveProduct(@ModelAttribute("employee") Employee employee) {
		service.save(employee);
		
		return "redirect:/employee";
	}
	
	@GetMapping("/employee/edit/{id}")
	public String showEditProductForm(@PathVariable(name = "id") Long id,Model model) {

		
		Employee employee = service.get(id);
		model.addAttribute("employee", employee);
		
		return "/employee/edit";
	}
	
	@RequestMapping("/employee/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/";
		
	}

	
}
