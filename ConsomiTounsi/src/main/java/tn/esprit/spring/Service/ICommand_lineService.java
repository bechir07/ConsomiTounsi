package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Command_line;

public interface ICommand_lineService {

	public long addCommandline(Command_line command_line);

	public List<Command_line> getAllCommandes_line();

	public Command_line updateCommande_line(Command_line c);

	public int updatetotal() ;
	//public int somme();
	public void affecterPoductACommand_line(long Id, long reference);

	public void affecterCommandACommand_line(long reference, long id);

	public int update_prix();
	//public String CalculPrixPlat();

	void deleteById(long id);

}
