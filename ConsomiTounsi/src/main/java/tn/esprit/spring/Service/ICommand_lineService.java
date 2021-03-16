package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Command_line;

public interface ICommand_lineService {

	public int addCommandline(Command_line command_line);

	public List<Command_line> getAllCommandes_line();

	public Command_line updateCommande_line(Command_line c);


	public void deleteById(int id);

	public void affecterPoductACommand_line(int Id, int reference);

	public void affecterCommandACommand_line(int reference, int id);

}
