package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;

@Repository
public interface ADDViewRepository extends CrudRepository <ADDView, Integer> {
	@Query("SELECT count(*) FROM ADDView av where (av.add.id =:idadd)")
	public int nbVu(@Param ("idadd") int idadd);

}
