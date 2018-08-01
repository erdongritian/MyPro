package com.htxa.ch.les1;

import java.util.HashMap;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	//容器存放Socket对象
	private static  HashMap<String,Socket> users =  new HashMap<String,Socket>();
	public static void addClient(String addr,Socket socket){
		users.put(addr, socket);
	}
	public static HashMap<String, Socket> getUsers(){
		return users;
	}
	public static Socket findClient(String addr){
		if(users.containsKey(addr))
			return users.get(addr);
		return null;
	}
	public static void main(String[] args) {
		new Server().startServer();
	}
	public void startServer(){
		try {
			ServerSocket s = new ServerSocket(8080);
			System.out.println("服务已经开启...");
			while(true){
				Socket socket = s.accept();
				String addr = socket.getInetAddress().getHostAddress()
						+UUID.randomUUID().toString();
				System.out.println("接收到"+addr+"的访问");
				Server.addClient(addr, socket);
				new Service(socket,addr);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//接收客户端数据并发送给对应客户端（群、私)
class Service extends Thread{
	private Socket socket;
	private BufferedReader br;
	private String addr;
	private PrintStream ps;//当前客户端连接的
	private PrintStream clientToClient;
	private PrintStream toAll;
	public Service(Socket socket,String addr){
		this.socket = socket;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ps = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.addr = addr;
		this.start();
	}
	@Override
	public void run() {
		try {
			while(true){
				String str = br.readLine();
				if("".equals(str)||str==null)
					continue;
				if("exit".equals(str))
					System.out.println("有客户端退出");
				int index = str.indexOf("/");
				if(index==-1){//群聊
					for(String addr:Server.getUsers().keySet()){
						Socket clientSocket = Server.getUsers().get(addr);
						toAll = new PrintStream(clientSocket.getOutputStream());
						toAll.println(str);

					}
				}else{
					//私聊
					String ip = str.split("/")[0];
					String content = str.split("/")[1];
					Socket clientSocket = Server.findClient(ip);
					if(clientSocket==null){
						ps.println("您需要对话的用户不存在!");
					}else{
						clientToClient = new PrintStream(clientSocket.getOutputStream());
						String message = this.addr+"/"+content;
						clientToClient.println(message);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
