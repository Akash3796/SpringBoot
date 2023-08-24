package s.b.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import s.b.Entities.EmpEntities;

@Repository
public interface EmpDao extends JpaRepository<EmpEntities, Integer> {
		
		
}
