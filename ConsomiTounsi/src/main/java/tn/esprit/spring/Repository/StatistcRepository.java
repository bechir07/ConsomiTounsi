package tn.esprit.spring.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.Command_line;
@Repository
public interface StatistcRepository extends JpaRepository<Command, Long> {
	
	@Query("select count (*) , YEAR(u.order_date) from Command u group by YEAR(u.order_date) ")
    public List<?> listUser();

	@Query("select count (u) , YEAR(u.order_date) , MONTH(u.order_date) from Command u group by YEAR(u.order_date), MONTH(u.order_date) ")
    public List<?> listMois1();
	/*
	@Query("select count (*), e.niveau , e.classe , e.jardin.nom from Enfant e group by e.niveau , e.classe , e.jardin.nom order by e.jardin.nom ")  
    public List<?> listEnfantParNiveau();
	
	@Query("select  e.jardin.nom, count (*) from Enfant e group by e.jardin")  
    public List<?> listEnfantParJardin();
	*/
	//@Query("SELECT count(*) FROM Command l where l.Command.reference =:Commandreference ")  
    //public List< LikeUser> listNbLikeParUser();
	//public int bLikeParUser(@Param ("Command") Long reference);
	
	//@Query("SELECT count(*) FROM Command c where c.User.id =:userid ")  
   // public int nbComParUser(@Param ("id") int id);
	/*
	@Query("SELECT count(*) FROM Bill p where p.user.id =:userid ")  
    public int nbPostParUser(@Param ("userid") Long userid);
	
	@Query("SELECT count(*) FROM Participation p where p.etat='participe' and p.user_participation.id=:userid ")  
    public int nbParticipationParUser(@Param ("userid") Long userid);
	*/
	@Query("select Max(u.total_price), u.id from Command u")  
    public List<?> BestUser();
	
	@Query("SELECT u FROM Command u")
	List <Command> getUserList();
	
	//@Query("SELECT count(*) FROM Enfant e where e.jardin.id =:jardinid ")  
	//public int nbEnfantParJardin(@Param ("jardinid") Long jardinid);
	
	/*
	@Query("select count (*) from Command e where YEAR(e.command.order_date)=2020 and e.command.reference =:commandreference")
    public int NbCom2020(@Param ("commandreference") Long commandreference);
	
	//@Query("select count (*) from Command e where YEAR(e.command.order_date)=2019 and e.command.reference =:commandreference")
    //public int NbCom2019(@Param ("commandreference") Long commandreference);
	
	@Query("select count (*) from Command e where YEAR(e.command.order_date)=2018 and e.command.reference =:commandreference")
    public int NbUser2018(@Param ("commandreference") Long commandreference);
	
	@Query("select count (*) from Command e where YEAR(e.command.order_date)=2020 and MONTH(e.command.order_date)=:month")
    public int NbUser2020ByMonth(@Param ("month") int month);
	
	@Query("select count (*) from Command e where YEAR(e.command.order_date)=2019 and MONTH(e.command.order_date)=:month")
    public int NbUser2019ByMonth(@Param ("month") int month);*/
}