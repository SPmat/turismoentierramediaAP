package proyecto_tierra_media_DAO;

import model.User;

public interface UserDAO extends GenericDAO<User> {

	public abstract User findByUsername(String username);
	
}
