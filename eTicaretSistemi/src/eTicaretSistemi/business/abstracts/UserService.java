package eTicaretSistemi.business.abstracts;

import java.util.ArrayList;

import eTicaretSistemi.entities.concretes.User;
import eTicaretSistemi.exceptions.BusinessException;

public interface UserService {
	
	void login(User user);
	void register(User user);
    

}
