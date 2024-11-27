package com.example.demo;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@Autowired
	private DAO d;
	
	@Autowired
	Student s;
	

	@GetMapping("/Home")
	public String showForm() {
		return "Insert";
	}

	/*We can Use Model Attribute Also to get the Details From Html*/
	@PostMapping("/submit")
	public String dataInserting(@RequestParam("id") int id,@RequestParam("name") String name, @RequestParam("salary") double salary) {
		
		s.setId(id);
		s.setName(name);
		s.setSalary(salary);
		d.insert(s);
		return "Success"; // Redirect back to the form after submission - > submit page to Success.html Page
	}
	
	@GetMapping("/onUpdate")
	public String dataUpdate(@ModelAttribute Student s) {
		d.update(s);
		return "success";
	}
	
	@GetMapping("/onDelete")
	public String dataDelete(@ModelAttribute Student s) {
		d.delete(s);
		return "success";
	}
	
	@GetMapping("/onSelect")
	public String select(@ModelAttribute Student s, Model model) {
		List<Student> l=d.getAllDetails(s.getTable());
		model.addAttribute("students", l);
		return "ShowDetails";
	}

}
