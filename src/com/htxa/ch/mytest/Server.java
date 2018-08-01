package com.htxa.ch.mytest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by chenh on 2016/11/24.
 */
public class Server {
    private Map<String,Socket> user=new HashMap<>();
    public static void main(String[] args) {
            new Server().StartServer();
    }

    public void StartServer(){
        try {
            ServerSocket server=new ServerSocket(8080);
            while (true){
                Socket socket= server.accept();
                String name=socket.getInetAddress().getHostName()+ UUID.randomUUID();
                user.put(name,socket);
                System.out.println("客户端已连接："+name);
                new AcceptData(socket,name).start();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    class AcceptData extends Thread{
        private Socket socket;
        private BufferedReader br;
        private PrintStream ps;
        private String name;

        public AcceptData(Socket socket,String name) {
            this.socket=socket;
            this.name=name;
        }

        @Override
        public void run() {
            try {
                br=new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while (true){
                    String mes=br.readLine();

                    int index=mes.indexOf("/");
                    if(index==-1){  //群聊
                        for (String u:user.keySet()){
                            Socket s=user.get(u);
                            ps=new PrintStream(s.getOutputStream());
                            ps.println(mes);
                        }
                    }else {
                        String ipname=mes.split("/")[0];
                        String mesString=mes.split("/")[1];
                        Socket clientSocket=user.get(ipname);
                        ps=new PrintStream(clientSocket.getOutputStream());
                        ps.println(name+"/"+mesString);

                    }

                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }
}

