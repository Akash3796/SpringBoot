package s.b.Service;

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
}
