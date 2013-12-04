package org.ares.security.dao.impl;

import org.ares.security.dao.IAuthenticationDao;
import org.ares.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationDaoImpl implements IAuthenticationDao {

	@Autowired
	Neo4jTemplate neo4jTemplate;

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		neo4jTemplate.save(user);
	}

	@Override
	public EndResult<User> findAllUser() {
		return neo4jTemplate.findAll(User.class);
	}
}
