package com.htxa.ch.les2;

public interface UserService {
	public User logon(int id, String password)throws IdPassException;
	public void update();
}
