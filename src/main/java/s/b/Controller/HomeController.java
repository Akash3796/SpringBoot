package s.b.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import s.b.Entities.EmpEntities;
import s.b.Service.EmpService;

@RestController
public class HomeController {
	
	@Autowired
	EmpService empService;
	
		@PostMapping("/employee")
		public String add(@RequestBody EmpEntities empEntities) {
			
			empService.add(empEntities);
			
			return "Success..";
				
		}	
		
		/* ----------------Employee  Select ------------------*/
		
		
		/*@PostMapping("/employeeSelect/id/{id}")
		public Optional<EmpEntities> empGetId(@PathVariable int id) {
			
			return empService.getById(id);
		
		}*/
		
		@PostMapping("/employeeSelect/id/{id}")
		public EmpEntities empGetId(@PathVariable int id) {
			
			return empService.getById(id);
		
		}
		
}
