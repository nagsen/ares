package org.ares.security.dao;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.ares.security.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/ares-neo4j-config.xml" })
public class AuthenticateLogin {

	@Autowired
	IAuthenticationDao authDao;

	@Test
	public void save() {
		User user = new User();
		user.setUserId(1416626);
		user.setFirstName("Deepak");
		user.setLastName("Kelkar");
		authDao.saveUser(user);
		fail();
	}

	@Test
	public void findAllUsers() {
		EndResult<User> users = authDao.findAllUser();
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()){
			User user = iter.next();
			System.out.println(user.getId());
		}
		fail();
	}

}
