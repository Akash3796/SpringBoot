package s.b.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import s.b.Entities.EmpEntities;

@Repository
public interface EmpDao extends JpaRepository<EmpEntities, Integer> {

		
			/*------------Normal Way------------*/
	
	//List<EmpEntities> findByName(String name);
		
	/* ------------MySQL Query Way---------------- */
	
	// @Query(value = "select * from datademo where name = ?", nativeQuery = true)
		// List<EmpEntities> abc(@Param("name")String name);
		
		/* ---------------JPQL Query Way--------------------- */
	
	@Query(value = "select e from EmpEntities e where e.name = :n")
	List<EmpEntities> abc(@Param(value = "n") String n);

}
