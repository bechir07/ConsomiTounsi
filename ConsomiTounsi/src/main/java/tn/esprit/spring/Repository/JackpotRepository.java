package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Jackpot;

@Repository
public interface JackpotRepository extends CrudRepository <Jackpot, Integer> {

	@Query("Select max(d.montant) from Donation d join d.jackpot j where j.id=:jackpotId")
	public double getMaxDonationForJackpot(@Param("jackpotId") int jackpotId);
}
