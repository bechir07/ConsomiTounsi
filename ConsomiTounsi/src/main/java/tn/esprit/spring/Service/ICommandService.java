package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Command;

public interface ICommandService {


public int addCommand(Command command);
public void affecterCommandABill(int reference, int bill_id);
public List<Command> getAllCommandes();
public Command updateCommande(Command c);
public void affecterPoductACommand(int Id, int reference);
public String getNamePoductByReference(int reference);
public void deleteByReference(int reference);
List<String> getCommandByReferenceJPQL(int reference);


	

}
