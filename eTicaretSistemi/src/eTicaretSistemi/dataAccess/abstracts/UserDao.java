package eTicaretSistemi.dataAccess.abstracts;

import java.util.ArrayList;

import eTicaretSistemi.entities.concretes.User;

public interface UserDao {

	void login(User user);
	void register(User user);
	ArrayList<User> getUsers();
}
