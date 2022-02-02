package eTicaretSistemi;

import eTicaretSistemi.business.abstracts.UserService;
import eTicaretSistemi.business.concretes.UserManager;
import eTicaretSistemi.dataAccess.concretes.UserDaoImpl;
import eTicaretSistemi.entities.concretes.User;
import eTicaretSistemi.exceptions.BusinessException;

public class Main {

	public static void main(String[] args) throws BusinessException {

		UserManager manager = new UserManager(new UserDaoImpl());
		User user1 = new User(1, "Hakan", "Kahraman", "hakan@gmail.com", "123456");
		User user2 = new User(1, "Nafiye", "Demiroð", "nafiye@gmail.com", "123456");
		User user3 = new User(1, "Ece", "Derici", "ece@gmail.com", "123456");
		User user4 = new User(1, "Zuhal", "Zuhal", "zuhal@gmail.com", "123456");
		User user5 = new User(1, "Yahya", "Ulutopçu", "yahya@gmail.com", "123456");
		User user6 = new User(1, "Hakan", "Kahraman", "hakan@gmail.com", "126");
		User user7 = new User(1, "Hakan", "K", "hakan@gmail.com", "123456");
		
		manager.register(user1);
		manager.register(user2);
		manager.register(user3);
		manager.register(user4);
		manager.register(user6);
		manager.register(user7);
		
		manager.login(user1);
		manager.login(user2);
		manager.login(user3);
		manager.login(user4);
		manager.login(user5);
		manager.login(user6);
		manager.login(user7);


	}

}
