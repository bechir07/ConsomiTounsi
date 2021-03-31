package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Rayon;



@Repository
public interface RayonRepository extends CrudRepository <Rayon, Integer> {
	@Query(value="SELECT * FROM rayon  WHERE type_rayon = ? ",nativeQuery=true)
	List<Rayon> findByType(String type);
	
	@Query(value="SELECT * FROM rayon  WHERE category_id = ? ",nativeQuery=true)
	Rayon findByCategory(int id);
	
	@Query(value="SELECT r.id FROM rayon r,product p ,category c  WHERE p.id = ? and p.id_category = c.id and c.id = r.category_id  ",nativeQuery=true)
	int findByrayon(long p);
	
	@Query(value="SELECT p.id FROM product p ,category c,rayon r  WHERE r.id= ? and r.category_id = c.id  and c.id = p.id_category   ",nativeQuery=true)
	List<Long> findAllProductByrayon(int idr);

}