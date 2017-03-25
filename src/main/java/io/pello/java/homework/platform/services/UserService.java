package io.pello.java.homework.platform.services;

import io.pello.java.homework.platform.domain.User;

public interface UserService {
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public void saveUser(User user);
}