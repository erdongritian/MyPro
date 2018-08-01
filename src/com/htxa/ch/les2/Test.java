package com.htxa.ch.les2;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserServiceImpl us = new UserServiceImpl();
		EntityContext entityContext = new EntityContext();
		us.setEntityContext(entityContext);
		try {
			User user = us.logon(10001, "123456");
			System.out.println(user);
		} catch (IdPassException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
