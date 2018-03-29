/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import sortAndCount.TestWord;
import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/13 9:33:38
 */
public class IngredientIntoUnits {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String InputPath = "D:\\Rakuten_calorie\\RakutenIngredientMorph.txt";
		String OutputPath = "D:\\Rakuten_calorie\\IngredientUnits.txt";
		String OutputPathSorted = "D:\\Rakuten_calorie\\IngredientUnitsSorted.txt";
		IOhandle iOhandle = new IOhandle();
		BufferedReader br = iOhandle.FileReader(InputPath);
		BufferedWriter bw = iOhandle.FileWriter(OutputPath);

		String ReadLine = "";
		while ((ReadLine = br.readLine()) != null) {
			
			String[] split = ReadLine.split(" ");
			String[] splite1 = split[1].split("\\+");
			String[] splite2 = split[2].split("\\+");
			for(int i=0;i<splite1.length;i++){
				
				if(splite1[i].equals("名詞")){
					bw.write(splite2[i]);
					bw.flush();
					bw.newLine();
				}
			}

		}
		
		//结果排序
		
		TestWord testWord = new TestWord();
		testWord.sort(OutputPath, OutputPathSorted);
		bw.close();
		br.close();

	}

}
