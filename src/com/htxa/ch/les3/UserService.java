package com.htxa.ch.les3;

public interface UserService {
	public User logon(int id, String password)throws IdPassException;
	public void update();
}
