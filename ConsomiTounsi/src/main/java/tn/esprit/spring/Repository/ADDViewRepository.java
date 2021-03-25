package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;

@Repository
public interface ADDViewRepository extends JpaRepository <ADDView, Long> {
	@Query("SELECT count(*) FROM ADDView av where (av.add.id =:idadd)")
	public int nbVu(@Param ("idadd") Long idadd);

}
