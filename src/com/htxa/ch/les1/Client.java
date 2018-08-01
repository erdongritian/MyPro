package com.htxa.ch.les1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		new Client().startClient();
	}
	//利用主线程，客户端随时从键盘输入数据并发给服务器端
	public void startClient(){
		try {
			Socket socket = new Socket("127.0.0.1",8080);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintStream ps = new PrintStream(socket.getOutputStream());
			new AcceptData(socket);
			while(true){
				String str = br.readLine();
				if("exit".equals(str))break;
				ps.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//随时接受从服务器发送过来的数据 可能是群聊的内容也有可能是私聊的内容
class AcceptData extends Thread{
	private Socket socket;
	private BufferedReader br ;
	public AcceptData(Socket socket){
		this.socket = socket;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.start();//对象一创建线程就已经启动
	}
	public void run() {
		try {
			while(true){
				String str = br.readLine();
				if("exit".equals(str)){
					System.out.println("有客户端退出...");
				}
				if("".equals(str)|| str == null){
					continue;
				}
				//规定私聊必须是ip/内容   群聊没有/
				int index = str.indexOf("/");
				if(index==-1){
					System.out.println("群聊的内容是:"+str);
				}else{
					String ip = str.split("/")[0];
					String content = str.split("/")[1];
					System.out.println(ip+"对我说:"+content);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
