package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.entities.User;

@Repository
public interface JackpotRepository extends CrudRepository <Jackpot, Integer> {

	@Query("Select max(d.montant) from Donation d join d.jackpot j where j.id=:jackpotId")
	public double getMaxDonationForJackpot(@Param("jackpotId") int jackpotId);
	
	@Query("Select sum(d.montant) from Donation d join d.jackpot j where j.id=:jackpotId")
	public double getSumDonationForJackpot(@Param("jackpotId") int jackpotId);
	
	@Query("Select avg(d.montant) from Donation d join d.jackpot j where j.id=:jackpotId")
	public double getAvgDonationForJackpot(@Param("jackpotId") int jackpotId);
	
	public Jackpot findByName(String name);
}
