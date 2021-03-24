package tn.esprit.spring.Service;

import java.util.HashMap;
import java.util.List;

import tn.esprit.spring.entities.Command;

public interface ICommandService {


public int addCommand(Command command);
public List<Command> getAllCommandes();
public Command updateCommande(Command c);
public void deleteByReference(int reference);
public List<String> getCommandByReferenceJPQL(int reference);
List<Command> GetComByDate();
public String EnvoiPlanning();
public int updatetotal();
public HashMap<Integer , Integer> stat();
List<?> getafficherC();




	

}
