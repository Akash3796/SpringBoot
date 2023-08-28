package s.b.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import s.b.Entities.EmpEntities;
import s.b.Service.EmpService;

/*@PropertySource(value = "classpath:student.properties")*/
@RestController
public class HomeController {
	
	@Autowired
	EmpService empService;
	
	@Value("${welMessage}")
	private String welmsg;
	
	@Value("${message}")
	private String msg;
	
	
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
		
			/* ---------------------OR--------------------------- */
		
		@PostMapping("/employeeSelect/id/{id}")
		public EmpEntities empGetId(@PathVariable int id) {
			
			System.out.println(welmsg);
			
			return empService.getById(id);
		
		}
		
		/* ----------------Employee  Delete ------------------*/
		
		@DeleteMapping("/employeeDelete/id/{id}")
		public String empDeleteGetId(@PathVariable int id) {
			
			 empService.getDeleteById(id);
		
			return "Employee Deleted Successfully..";
		
		}
		
		
		/* ----------------Employee  SelectAll ------------------*/
				
			
		@GetMapping("/employeeSelectAll")
		public  List<EmpEntities> Allemp(){
				
			List<EmpEntities> list = empService.getAllEmployee();
			
				System.out.println(msg);
				
			return list;
		
		}
		
		
		/* ----------------Employee  Select By Name ------------------*/
		
		@GetMapping("/employeeSelect/name/{name}")
		public List<EmpEntities> empGetName(@PathVariable String name) {
			
			List<EmpEntities> list = empService.getByName(name);
			
			
			return list;
		}
		
}
