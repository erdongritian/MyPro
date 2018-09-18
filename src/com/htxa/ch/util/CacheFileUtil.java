package com.htxa.ch.util;

import java.io.*;


/**
 * 
 * 类功能描述：缓存文件工具类
 * @author <a href="mailto:fengling@run.com">冯岭</a> 
 * 创建时间:2014-7-14 上午10:20:15
 */
public class CacheFileUtil {

	/**
	 * 
	 * 方法描述：根据给定的文件名写数据到缓存文件
	 * 创建时间:2014-7-14 
	 * 更新时间:2014-7-14
	 * @param filename
	 * @param data
	 * @throws IOException
	 */
//	public static void writeData(String filename, List<Features> data) throws IOException {
//		PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
//		for (Features features : data) {
//			pw.println(JSON.toJSONString(features));
//		}
//		pw.flush();
//		pw.close();
//	}

	/**
	 * 
	 * 方法描述：根据给定的文件名读取数据
	 * 创建时间:2014-7-14
	 * 更新时间:2014-7-14
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
//	public static List<Features> readData(String filename) throws IOException {
//		List<Features> resultList = new ArrayList<Features>();
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
//		String line = null;
//		Features features = null;
//		while ((line = br.readLine()) != null) {
//			features = JSON.parseObject(line, Features.class);
//			resultList.add(features);
//		}
//		br.close();
//		return resultList;
//	}

	public static void readData(String fileName) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(fileName));
		String line=null;
		while ((line=br.readLine())!=null){
			System.out.println(line);
		}
	}

	/**
	 * 
	 * 方法描述： 写关键词-文件映射数据
	 * 创建时间:2014-7-14 
	 * 更新时间:2014-7-14
	 * @param dataMap
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
//	public static void writeKeywordFileMap(String filename, Map<String, KeywordFileMap> dataMap) throws FileNotFoundException, IOException {
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
//		oos.writeObject(dataMap);
//		oos.flush();
//		oos.close();
//	}

	/**
	 * 
	 * 方法描述：  读取关键词-文件映射数据
	 * 创建时间:2014-7-14 
	 * 更新时间:2014-7-14
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
//	public static Map<String, KeywordFileMap> readKeywordFileMap(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
//		@SuppressWarnings("unchecked")
//        Map<String, KeywordFileMap> dataMap = (Map<String, KeywordFileMap>) ois.readObject();
//		ois.close();
//		return dataMap;
//	}
}
