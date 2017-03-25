package io.pello.java.homework.platform.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.pello.java.homework.platform.domain.Role;
import io.pello.java.homework.platform.domain.User;
import io.pello.java.homework.platform.repositories.RoleRepository;
import io.pello.java.homework.platform.repositories.UserRepository;
import io.pello.java.homework.platform.security.LamePasswordEncoder;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private LamePasswordEncoder lamePasswordEncoder;
	
	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public void saveUser(User user) {
		user.setPassword(lamePasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        
        Role userAdminRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userAdminRole)));
        
        System.out.println("USer is ready: " + user);
		userRepository.save(user);
	}

}