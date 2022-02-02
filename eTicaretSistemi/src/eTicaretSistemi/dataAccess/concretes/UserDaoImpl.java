package eTicaretSistemi.dataAccess.concretes;

import java.util.ArrayList;

import eTicaretSistemi.dataAccess.abstracts.UserDao;
import eTicaretSistemi.entities.concretes.User;

public class UserDaoImpl implements UserDao {

	ArrayList<User> users = new ArrayList<User>();;
	

	@Override
	public void login(User user) {

		this.users.contains(user);
		
	}

	@Override
	public void register(User user) {

		this.users.add(user);
		
	}

	@Override
	public ArrayList<User> getUsers() {
		return this.users;
	}

}
