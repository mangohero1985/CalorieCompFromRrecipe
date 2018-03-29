/**
 * 
 */
package BuildNewDictionary.Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import tools.InfoSeek;
import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time     2015/03/02   15:32:02   
 */
public class GetHtmlFromUrl {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String InputPath = "D:\\Rakuten_calorie\\Crawler\\htmlFiles\\url.txt";
		IOhandle iOhandle = new IOhandle();
		BufferedReader br = iOhandle.FileReader(InputPath);
		String ReadLine = "";
		while((ReadLine = br.readLine())!=null){
			String[] split = ReadLine.split("/");
			String  fileName = split[8]+"-"+split[10];
			String OutputPath ="D:\\Rakuten_calorie\\Crawler\\htmlFiles\\"+fileName+".html" ;
			BufferedWriter bw = iOhandle.FileWriter(OutputPath);
			InfoSeek infoSeek = new InfoSeek();
			
			bw.write(infoSeek.GetHtmlFromUrl(ReadLine));
			bw.newLine();
			bw.flush();
			
		}

	}

}
