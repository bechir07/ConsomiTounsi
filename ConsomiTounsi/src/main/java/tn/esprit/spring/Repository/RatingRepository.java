package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;

@Repository
public interface RatingRepository extends CrudRepository <Rating, Integer> {
<Optional> Rating findById(int note);

@Query("SELECT count(*) FROM Rating r where (r.product.id =:idProduct)")
public int nbreviews(@Param ("idProduct") int idProduct);

@Query(nativeQuery = true, value ="select `id`, `date_rating`, `review`, `id_product`, `id_user`, `note` from rating where id order by date_rating desc limit 3")
public List<Rating> listLastReviews(@Param("id") int id);

@Query("select r from Rating r where r.product.id=:id order by r.DateRating desc")
public List<Rating> listReviews(@Param("id") int id);

}
