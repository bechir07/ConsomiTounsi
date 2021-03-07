package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Command_line;
@Repository
public interface Command_lineRepository  extends CrudRepository<Command_line, Integer>{
	/*/
	@Query("SELECT count(c.id) FROM Command_line c")
	long getNombreCommand_lineJPQL();
*/

}
