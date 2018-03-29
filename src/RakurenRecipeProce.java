import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import Iohandle.IOhandle;

/**
 * 
 */

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/06 10:46:08
 */
public class RakurenRecipeProce {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		IOhandle iOhandle = new IOhandle();
		String InputPath = "D:\\Rakuten_calorie\\RakutenIngredientMorph.txt";
		String OutputPath = "D:\\Rakuten_calorie\\RakutenIngredientUnigram.txt";
		String ReadLine = "";

		BufferedReader br = iOhandle.FileReader(InputPath);
		BufferedWriter bw = iOhandle.FileWriter(OutputPath);

		while ((ReadLine = br.readLine()) != null) {

			String[] splite = ReadLine.split(" ");
			if(splite[1].equals("名詞")){
				
				bw.write(ReadLine);
				bw.newLine();
				bw.flush();
			}
		}
		bw.close();
		br.close();
	}

}
