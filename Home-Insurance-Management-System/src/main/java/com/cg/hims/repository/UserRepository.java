package com.cg.hims.repository;

import com.cg.hims.entities.User;

public interface UserRepository {
	public User addNewUser(User user);

	public User signIn(User user);

	public User signOut(User user);
}
