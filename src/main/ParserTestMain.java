/**
 * 
 */
package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import Parser.HtmlPaser;
import Parser.JsonWriter;

/**
 * @author ar-weichang.chen
 * @create-time     2014/12/24   11:13:12   
 */
public class ParserTestMain {

	/**
	 * @param <E>
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String FileName= "calorie";
		HtmlPaser htmlPaser = new HtmlPaser();
		htmlPaser.getPath("D:/Rakuten_calorie/Nutrition_parsing/"+FileName+".html");
		
		ArrayList<Map<String,ArrayList<Map<String,String>>>>  JsonArr= htmlPaser.Parser();
		JsonWriter JsonWriter = new JsonWriter();
		JsonWriter.Write(JsonArr, "C:\\Users\\ar-weichang.chen\\Desktop\\"+FileName+".json");
		
	}

}
