package io.pello.java.homework.platform.services;

import es.anaya.spring.web.s04.dblogin.domain.User;

public interface UserService {
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public void saveUser(User user);
}