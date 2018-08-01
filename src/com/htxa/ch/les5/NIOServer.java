package com.htxa.ch.les5;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class NIOServer {
	private int flag;
	private final int BLOCK = 4096;
	private ByteBuffer sendBuffer = ByteBuffer.allocate(BLOCK);
	private ByteBuffer receiveBuffer = ByteBuffer.allocate(BLOCK);
	private Selector selector;
	public NIOServer(int port)throws IOException{
		//打开服务器套接字通道
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		//设置为非阻塞模式
		serverSocketChannel.configureBlocking(false);
		//和该通道想关联的套接字
		ServerSocket serverSocket = serverSocketChannel.socket();
		//进行服务绑定
		serverSocket.bind(new InetSocketAddress(port));
		//通过open方法找到selector
		selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("Server Start...");

	}
	public void listener()throws IOException{
		while(true){
			//选择一组键,并且相应的通道已经打开
			selector.select();
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			while(iterator.hasNext()){
				SelectionKey selectionKey = iterator.next();
				//一个key被处理完成后要移除
				iterator.remove();
				//做自己的处理操作
				handleKey(selectionKey);
			}
		}
	}
	private void handleKey(SelectionKey selectionKey)throws IOException {
		ServerSocketChannel server = null;
		SocketChannel client = null;
		String receiveText ;
		String sendText;
		int count = 0;
		//测试此键通道是否已经准备好接受新的套接字连接
		if(selectionKey.isAcceptable()){
			//返回之前创建的键值通道
			server = (ServerSocketChannel)selectionKey.channel();
			client = server.accept();
			client.configureBlocking(false);
			client.register(selector, SelectionKey.OP_READ);
		}else if(selectionKey.isReadable()){
			client = (SocketChannel)selectionKey.channel();
			receiveBuffer.clear();
			count = client.read(receiveBuffer);
			if(count > 0){
				receiveText = new String(receiveBuffer.array(),0,count);
				System.out.println("服务端接收到客户端的数据:"+receiveText);
				client.register(selector, SelectionKey.OP_WRITE);
			}
		}else if(selectionKey.isWritable()){
			sendBuffer.clear();
			client = (SocketChannel)selectionKey.channel();
			sendText = "message from server:"+flag++;
			sendBuffer.put(sendText.getBytes());
			sendBuffer.flip();
			client.write(sendBuffer);
			System.out.println("服务器端向客户发送数据:"+sendText);
			client.register(selector, SelectionKey.OP_READ);
		}

	}
	public static void main(String[] args)throws IOException {
		int port = 8888;
		NIOServer nioServer = new NIOServer(port);
		nioServer.listener();
	}

}
