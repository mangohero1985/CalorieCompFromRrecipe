/**
 * 
 */
package main;

import java.io.BufferedWriter;
import java.io.IOException;

import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time     2015/02/25   15:25:39   
 */
public class MakeUrlForCrawler {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String categorty = "9818";
		int loop=0 ;
		int threshold=2;
		int id = 10001;
		IOhandle iOhandle = new IOhandle();
		String OutputPath = "D:\\Rakuten_calorie\\Crawler\\"+categorty+".txt";
		BufferedWriter bw = iOhandle.FileWriter(OutputPath);
		while(!(loop>threshold)){
			bw.write("\""+id+"\":"+"\"http://www.eatsmart.jp/do/caloriecheck/list/param/foodCategoryCode/"+categorty+"/offset/"+loop*10+"/paging/YES\",");
			bw.newLine();
			bw.flush();
			loop++;
			id++;
			
		}
		
	}

}
