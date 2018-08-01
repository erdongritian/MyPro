package com.htxa.ch.les3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
	public static void main(String[] args) throws Exception{
		final ServerSocket server = new ServerSocket(8080);
		final HelloService helloService = new HelloServiceImpl();
		while(true){
			final Socket socket = server.accept();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
						String methodName = ois.readUTF();
						Class<?>[] paramTypes = (Class<?>[])ois.readObject();
						Object[] args = (Object[])ois.readObject();
						
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
						Method method = helloService.getClass().getMethod(methodName, paramTypes);
						Object result = method.invoke(helloService, args);
						
						oos.writeObject(result);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

}
