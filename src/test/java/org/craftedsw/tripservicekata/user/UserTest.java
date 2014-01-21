package org.craftedsw.tripservicekata.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserTest {

	
	@Test
	public void aUserInFriendListIsAFriend () {
		User user = new User();
		User friendOfUser = new User();
		user.addFriend(friendOfUser);
		
		assertTrue(user.isFriendWith(friendOfUser));
	}
	
	@Test
	public void aUserNotInFriendListIsNotAFriend () {
		
	}
	
}
