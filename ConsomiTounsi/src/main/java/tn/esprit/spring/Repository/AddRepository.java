package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;

@Repository
public interface AddRepository extends JpaRepository <Add, Long> {
	//<Optional> Add findById(Long id);

	@Query("select a from Add a where a.priceSponsoring>200 ")
    public List<Add> listAdd();
	
	@Query("select a.Image from Add a where a.id=:id")
	public byte[] getImage(@Param("id") int id);
	
	
	@Query("SELECT a FROM Add a WHERE a.name= :msg")
	public Add getAddByName(@Param("msg") String msg);
	
	@Query("SELECT a FROM Add a WHERE a.name LIKE CONCAT('%',:string,'%')")
	public List<Add> searchAdd(@Param("string") String msg);
}
