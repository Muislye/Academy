package interfaces;

import model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceUser extends CrudRepository<User, Integer> {

}
