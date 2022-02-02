package eTicaretSistemi.business.concretes;

import java.util.ArrayList;

import eTicaretSistemi.business.abstracts.UserService;
import eTicaretSistemi.dataAccess.abstracts.UserDao;
import eTicaretSistemi.entities.concretes.User;
import eTicaretSistemi.exceptions.BusinessException;

public class UserManager implements UserService {
	
	private UserDao userDao;

	public UserManager() {
		super();
	}

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void login(User user) {
		
		try {
			if(checkIfUserMatch(user.geteMail(), user.getPassword())) {
				
				this.userDao.login(user);
				System.out.println("Baþarýlý");
			}

			
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	
		
	}

	@Override
	public void register(User user) {

		try {
			if(checkIfFirstName(user.getFirstName())&&checkIfLastName(user.getLastName()) && checkIfeMailCorrect(user.geteMail()) && checkIfeMailExsists(user.geteMail()) && checkIfPassword(user.getPassword())) {
				this.userDao.register(user);
				System.out.println("Baþarýlý");
			}

			
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}
	
	private boolean checkIfFirstName(String firstName) throws BusinessException {
		if(firstName.length()>2) {
			return true;
		}
		throw new BusinessException("Ýsim 2 harften kýsa olamaz.");
		
	}
	
	private boolean checkIfLastName(String lastName) throws BusinessException {
		if(lastName.length()>2) {
			return true;
		}
		throw new BusinessException("Soyisim 2 harften kýsa olamaz.");
		
	}
	
	private boolean checkIfeMailExsists(String eMail) throws BusinessException {
		ArrayList<User> users = userDao.getUsers();
		for (User user : users) {
			if(user.geteMail().equals(eMail)) {
				throw new BusinessException("E-mail daha önce kullanýlmýþtýr.");
			}
		}
		return true;
		
	}
	
	private boolean checkIfeMailCorrect(String eMail) throws BusinessException {
		if(eMail.contains("@")) {
			return true;
		}
		throw new BusinessException("E-posta @ içermelidir.");
	}
	
	private boolean checkIfPassword(String password) throws BusinessException {
		if(password.length()>=6) {
			return true;
		}
		throw new BusinessException("Parola en az 6 karakterden oluþmalýdýr");
	}
	
	private boolean checkIfUserMatch(String eMail, String password) throws BusinessException {
		ArrayList<User> users = userDao.getUsers();
		for (User user : users) {
			if(user.geteMail().equals(eMail)) {
				if(user.getPassword().equals(password)) {
					return true;
				}
				throw new BusinessException("Password yanlýþ.");
			}
		}
		throw new BusinessException("E-mail yanlýþ veya kullanýcý üye olmamýþ.");
		
	}
	
	

}
