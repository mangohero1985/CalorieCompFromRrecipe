/**
 * 
 */
package BuildNewDictionary.Main;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import BuildNewDictionary.Control.HtmlParse;
import Parser.JsonWriter;
import tools.FolderOperator;

/**
 * @author ar-weichang.chen
 * @create-time     2015/03/03   12:44:48   
 */
public class ParseAllHtmlIntoDic {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//The folder path including all html files;
		String folderPath = "D:\\Rakuten_calorie\\Crawler\\htmlFiles\\";
		FolderOperator folderOperator = new FolderOperator();
		File[] files = folderOperator.ReadAllFile(folderPath);
		HtmlParse htmlParse = new HtmlParse();
		Map<String, String> map = new TreeMap<String, String>();
		String OutputPath = "D:\\Rakuten_calorie\\Crawler\\NewCalorie.json";
		
		//Create a object to wirte map into JSON
		JsonWriter jsonWriter = new JsonWriter();
		for(File file :files){
			
			Map Unitmap = htmlParse.Parse(file.getAbsolutePath());
			map.putAll(Unitmap);
		}
		jsonWriter.Write(map, OutputPath);
	}
}
