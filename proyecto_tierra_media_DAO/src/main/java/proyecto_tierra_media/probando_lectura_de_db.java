package proyecto_tierra_media;


import proyecto_tierra_media_DAO.DAOFactory;
import proyecto_tierra_media_DAO.UserDAO;
import model.User;

public class App {

	public static void main(String[] args) {
		UserDAO userDAO = DAOFactory.getUserDAO();
		System.out.println(userDAO.findAll());
		System.out.println(userDAO.countAll());
		
		System.out.println("----------------------------");
		
		System.out.println(userDAO.findByUsername("leo"));
		System.out.println(userDAO.findByUsername("leonardo"));
		
		System.out.println("----------------------------");
		User lucas = new User("lucas", "0000");
		userDAO.insert(lucas);
		
		System.out.println(userDAO.findAll());
		System.out.println(userDAO.countAll());
		
		System.out.println("----------------------------");
		userDAO.delete(lucas);
		
		System.out.println(userDAO.findAll());
		System.out.println(userDAO.countAll());
	}
}
