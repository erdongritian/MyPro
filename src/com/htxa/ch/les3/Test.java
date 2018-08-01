package com.htxa.ch.les3;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//UserServiceImpl us = new UserServiceImpl();
		//EntityContext entityContext = new EntityContext();
		//us.setEntityContext(entityContext);
		UserServiceProxy usProxy = new UserServiceProxy();
		try {
			User user = usProxy.logon(10001, "12345");
			System.out.println(user);
		} catch (IdPassException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
