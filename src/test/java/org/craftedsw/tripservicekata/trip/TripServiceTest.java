package org.craftedsw.tripservicekata.trip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Before;
import org.junit.Test;

public class TripServiceTest {
	
	private User loggedUser = null;
	private TripService tripService = null;
	
	@Before
	public void setUp() {
		tripService = new TestableTripService();
	}
	
	@Test(expected=UserNotLoggedInException.class)
	public void aUserShouldBeLoggedIn() {
		tripService.getTripsByUser(new User());
	}
	
	@Test
	public void aUserIsConnected() {
		loggedUser = new User();
		List<Trip> tripList = tripService.getTripsByUser(new User());
		assertNotNull(tripList);
		assertEquals(0, tripList.size());
	}
	
	@Test
	public void aUserHasFriendWithouttrips() {
		loggedUser = new User();
		User friend = new User();
		friend.addFriend(new User());
		friend.addFriend(loggedUser);
		
		List<Trip> tripList = tripService.getTripsByUser(friend);
		assertNotNull(tripList);
		assertEquals(0, tripList.size());
		
	}
	

	class TestableTripService extends TripService {
		
		@Override
		protected User getLoggedUser() {
			return loggedUser;
		}
			
		@Override
		protected List<Trip> getTripList(User user) {
			return new ArrayList<Trip>();
		}
	}
}

