package com.htxa.ch.mytest;

import java.io.*;
import java.net.Socket;

/**
 * Created by chenh on 2016/11/24.
 */
public class Client {
    private BufferedReader br;
    private PrintStream ps;


    public static void main(String[] args) {
        new Client().startClient();
    }

    public void startClient(){
        try {
            Socket socket=new Socket("127.0.0.1",8080);
            br=new BufferedReader(new InputStreamReader(System.in));
            ps=new PrintStream(socket.getOutputStream());
            new AcceptData(socket).start();
            while (true){
                String mes=br.readLine();
                if("".equals(mes)||mes==null){
                    continue;
                }
                if("exit".equals(mes)){
                    System.out.printf("客户端退出。。。。。");
                    break;
                }
                ps.println(mes);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}

class AcceptData extends Thread{
    private Socket socket;
//    private PrintStream ps;
    private BufferedReader br;

    public AcceptData(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            ps=new PrintStream(socket.getOutputStream());
            while (true){
                String mes=br.readLine();
                int index=mes.indexOf("/");
                if(index==-1){
                    System.out.println("群聊内容："+mes);
                }
                else{
                    String ipname=mes.split("/")[0];
                    String mesString=mes.split("/")[1];
                    System.out.println(ipname+"对我说："+mesString);
                }

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}