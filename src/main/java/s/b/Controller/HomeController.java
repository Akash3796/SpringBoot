package s.b.Controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import s.b.Entities.EmpEntities;
import s.b.Service.EmpService;

@RequestMapping("/employee")
@CrossOrigin("*")
@RestController
public class HomeController {
	
	@Autowired
	EmpService empService;
	
		@PostMapping("/add")
		public String add(@RequestBody EmpEntities empEntities) {
			
			empService.add(empEntities);
			
			return "Success..";
				
		}	
		
		/* ----------------Employee  Select ------------------*/
		
		
		/*@PostMapping("/Select/id/{id}")
		public Optional<EmpEntities> empGetId(@PathVariable int id) {
			
			return empService.getById(id);
		
		}*/
		
			/* ---------------------OR--------------------------- */
		
		@PostMapping("/Select/id/{id}")
		public EmpEntities empGetId(@PathVariable int id) {
			
			return empService.getById(id);
		
		}
		
		/* ----------------Employee  Delete ------------------*/
		
		@DeleteMapping("/Delete/id/{id}")
		
		public String empDeleteGetId(@PathVariable int id) {
			
			 empService.getDeleteById(id);
		
			return "Employee Deleted Successfully..";
		
		}
		
		
		/* ----------------Employee  SelectAll ------------------*/
				
		@GetMapping(produces="application/JSON")
		public  List<EmpEntities> Allemp(){
				
			List<EmpEntities> list = empService.getAllEmployee();
			
			return list;
		
		}
		
		
		/* ----------------Employee  Select By Name ------------------*/
		
		@GetMapping("/Select/name/{name}")
		public List<EmpEntities> empGetName(@PathVariable String name) {
			
			List<EmpEntities> list = empService.getByName(name);
			
			
			return list;
		}
		
}
