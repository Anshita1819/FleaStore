package flea.store.dao;

import flea.store.pojos.Login;

public interface LoginDao {
	boolean validUser(Login user);

}
