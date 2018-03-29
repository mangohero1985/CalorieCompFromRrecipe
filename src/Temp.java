import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import Iohandle.IOhandle;

/**
 * 
 */

/**
 * @author ar-weichang.chen
 * @create-time 2015/04/07 16:19:47
 */
public class Temp {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		IOhandle iOhandle = new IOhandle();
		String inputPath = "D:\\Rakuten_calorie\\CalorieModified\\SampleCalorie.txt";
		BufferedReader br = iOhandle.FileReader(inputPath);

		String readLine = "";
		float neg=0;
		while ((readLine = br.readLine()) != null) {
			if(readLine.contains("no value")){
				neg++;
				
			}
		}
		System.out.println(neg);
		System.out.println((1000.0-neg)/1000.0);
	}
}
