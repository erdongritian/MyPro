package com.htxa.ch.les2;

import java.util.HashMap;

public class EntityContextTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityContext entityContext = new EntityContext();
		HashMap<Integer,User> usrs = entityContext.getUsers();
		for(Integer key : usrs.keySet()){
			User user = usrs.get(key);
			System.out.println(user);
		}

	}

}
