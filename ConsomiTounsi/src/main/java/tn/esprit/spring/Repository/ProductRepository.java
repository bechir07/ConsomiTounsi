package tn.esprit.spring.Repository;
import java.util.List;


import java.util.List;


import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.*;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select p FROM Product p where p.categorie = :categorie ")
	List<Product> retrieveProductByCategory(@Param("categorie") Category categorie);
	
	@Query("select p from Product p order by p.Price asc ")
    public List<Product> listProductNotExpensive();
	

	@Query("SELECT SUM(r.note) FROM Rating r where r.product.id =:idProduct")  
    public float SommeNote(@Param ("idProduct") Long idProduct);
	

	@Query("select p.rating from Product p where p.id=:id")
	public float getRating(@Param("id") Long id);
	
	@Query("SELECT p FROM Product p WHERE p.Name=: string")
	public Product getProductByName(@Param("string") String msg);
	
}
