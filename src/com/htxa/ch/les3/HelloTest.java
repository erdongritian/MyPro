package com.htxa.ch.les3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class HelloTest {

	public static void main(String[] args) {
		// HelloService hs = new HelloServiceImpl();
		// System.out.println(hs.sayHello("Mr Wang"));
		// 业务的代理对象 jdk动态代理实现
		HelloService helloService = getProxy(HelloService.class, "127.0.0.1", 8080);
		//helloService.sayHello("Mr Wang");
		System.out.println(helloService.sayHello("Mr Wang"));

	}

	public static <T> T getProxy(Class<T> interfaceClass,final String host,final int port) {
		return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
				new Class<?>[] { interfaceClass }, new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method,
										 Object[] args) throws Throwable {
						Socket socket = new Socket(host,port);
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
						oos.writeUTF(method.getName());
						oos.writeObject(method.getParameterTypes());
						oos.writeObject(args);
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
						return ois.readObject();
					}
				});
	}

}
