package s.b.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import s.b.Entities.EmpEntities;
import s.b.dao.EmpDao;

@Component
public class EmpService {

		@Autowired
		EmpDao empDao;

		public void add(EmpEntities empEntities) {
			
			empDao.save(empEntities);
			
		}

			public EmpEntities getById(int id) {
				
				Optional<EmpEntities> e =	empDao.findById(id);
				
				if (e.isPresent()) {
					
					return e.get();
				}
				
				return null;
			}

			public EmpEntities getDeleteById(int id) {
				
				empDao.deleteById(id);
				
				return null;
			}
}