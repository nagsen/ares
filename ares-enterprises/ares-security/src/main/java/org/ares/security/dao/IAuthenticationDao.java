package org.ares.security.dao;

import org.ares.security.domain.User;
import org.springframework.data.neo4j.conversion.EndResult;

public interface IAuthenticationDao {

	void saveUser(User user);
	EndResult<User> findAllUser();
}
