package com.htxa.ch.faceidentify;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javax.net.ssl.SSLException;

/**
 * Face++
 */
public class FaceTest {

    public static void main(String[] args) throws Exception{

        String url = "https://api-cn.faceplusplus.com/facepp/v3/compare";
        HashMap<String, String> map = new HashMap<>();

        map.put("api_key", "JBAZPtD3aTPjOvLULebhnYihJv53g5OF");
        map.put("api_secret", "oOsO7WN1EupL5djc0QcUbUdKKRAUKiro");

        HashMap<String, byte[]> byteMap1 = new HashMap<>();
        File file1 = new File("F:\\img\\111.png");
        byte[] buff1 = getBytesFromFile(file1);
        byteMap1.put("image_file1", buff1);

        HashMap<String, byte[]> byteMap2 = new HashMap<>();
        File file2 = new File("F:\\img\\33.png");
        byte[] buff2 = getBytesFromFile(file2);
        byteMap2.put("image_file2", buff2);


        try{
            long t1=System.currentTimeMillis();
            byte[] bacd = post(url, map, byteMap1,byteMap2);
            String str = new String(bacd);
            System.out.println(System.currentTimeMillis()-t1);
            System.out.println(str);
        }catch (Exception e) {
            e.printStackTrace();
        }

//        6090
//        {"faces1": [{"face_rectangle": {"width": 298, "top": 300, "left": 206, "height": 298},
//            "face_token": "ef859d44b77c7214987a69faad7a9a05"}], "faces2": [{"face_rectangle":
//            {"width": 466, "top": 289, "left": 135, "height": 466}, "face_token": "e6a0b8504c2675719e071db62f3f35ca"}], "time_used": 805, "thresholds": {"1e-3": 65.3, "1e-5": 76.5, "1e-4": 71.8}, "confidence": 86.682, "image_id2": "SvuCBHXQ21f2sm36jzS1VA==", "image_id1":
//            "nt/pOANkulkqJ1nrf3XE3Q==", "request_id": "1488769557,79d5f0bc-ae51-45fd-9c71-5297c22d02da"}
    }

    private final static int CONNECT_TIME_OUT = 30000;
    private final static int READ_OUT_TIME = 50000;
    private static String boundaryString = getBoundary();
    protected static byte[] post(String url, HashMap<String, String> map, HashMap<String, byte[]> fileMap1, HashMap<String, byte[]> fileMap2) throws Exception {
        HttpURLConnection conne;
        URL url1 = new URL(url);
        conne = (HttpURLConnection) url1.openConnection();
        conne.setDoOutput(true);
        conne.setUseCaches(false);
        conne.setRequestMethod("POST");
        conne.setConnectTimeout(CONNECT_TIME_OUT);
        conne.setReadTimeout(READ_OUT_TIME);
        conne.setRequestProperty("accept", "*/*");
        conne.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundaryString);
        conne.setRequestProperty("connection", "Keep-Alive");
        conne.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
        DataOutputStream obos = new DataOutputStream(conne.getOutputStream());
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry) iter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            obos.writeBytes("--" + boundaryString + "\r\n");
            obos.writeBytes("Content-Disposition: form-data; name=\"" + key
                    + "\"\r\n");
            obos.writeBytes("\r\n");
            obos.writeBytes(value + "\r\n");
        }
        if(fileMap1 != null && fileMap1.size() > 0){
            Iterator fileIter = fileMap1.entrySet().iterator();
            while(fileIter.hasNext()){
                Map.Entry<String, byte[]> fileEntry = (Map.Entry<String, byte[]>) fileIter.next();
                obos.writeBytes("--" + boundaryString + "\r\n");
                obos.writeBytes("Content-Disposition: form-data; name=\"" + fileEntry.getKey()
                        + "\"; filename=\"" + encode(" ") + "\"\r\n");
                obos.writeBytes("\r\n");
                obos.write(fileEntry.getValue());
                obos.writeBytes("\r\n");
            }
        }

        if(fileMap2 != null && fileMap2.size() > 0){
            Iterator fileIter = fileMap2.entrySet().iterator();
            while(fileIter.hasNext()){
                Map.Entry<String, byte[]> fileEntry = (Map.Entry<String, byte[]>) fileIter.next();
                obos.writeBytes("--" + boundaryString + "\r\n");
                obos.writeBytes("Content-Disposition: form-data; name=\"" + fileEntry.getKey()
                        + "\"; filename=\"" + encode(" ") + "\"\r\n");
                obos.writeBytes("\r\n");
                obos.write(fileEntry.getValue());
                obos.writeBytes("\r\n");
            }
        }

        obos.writeBytes("--" + boundaryString + "--" + "\r\n");
        obos.writeBytes("\r\n");
        obos.flush();
        obos.close();
        InputStream ins = null;
        int code = conne.getResponseCode();
        try{
            if(code == 200){
                ins = conne.getInputStream();
            }else{
                ins = conne.getErrorStream();
            }
        }catch (SSLException e){
            e.printStackTrace();
            return new byte[0];
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[4096];
        int len;
        while((len = ins.read(buff)) != -1){
            baos.write(buff, 0, len);
        }
        byte[] bytes = baos.toByteArray();
        ins.close();
        return bytes;
    }
    private static String getBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 32; ++i) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
        }
        return sb.toString();
    }
    private static String encode(String value) throws Exception{
        return URLEncoder.encode(value, "UTF-8");
    }

    public static byte[] getBytesFromFile(File f) {
        if (f == null) {
            return null;
        }
        try {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1)
                out.write(b, 0, n);
            stream.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
        }
        return null;
    }
}
