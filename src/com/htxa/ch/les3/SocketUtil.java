package com.htxa.ch.les3;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketUtil {
	public static Response remoteCall(Request request){
		try {
			//1.连接服务器  ip,port将来应该是配置文件读取
			Socket socket = new Socket("127.0.0.1",9000);
			//2.序列化对象，写对象  发送请求
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(request);
			oos.flush();
			//oos.close();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			return (Response)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
