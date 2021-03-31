package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.LikeAdd;


public interface LikeAddRepository extends JpaRepository< LikeAdd , Long> {
	
		<Optional> LikeAdd findAllById(Long id);
	
		@Query("select l  from LikeAdd l  where ( l.user.id=:username and l.add.id=:username1)")
		public LikeAdd likeexist(@Param("username") Long username,@Param("username1") Long username1);
	
		//nb de like par post
		@Query("SELECT count(*) FROM LikeAdd l where (l.add.id =:idadd and l.etat = true)")
	    public int nbLike(@Param ("idadd") Long idadd);
		
		//nb de dislike par post
		@Query("SELECT count(*) FROM LikeAdd l where (l.add.id =:idadd and l.etat = false)")
		public int nbDisLike(@Param ("idadd") Long idadd);
		
		

}
