/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import tools.TextTransHiragana;
import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/14 14:00:50
 */
public class NewRakurenIngresUnigram {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		IOhandle iOhandle = new IOhandle();
		String InputPath = "D:\\Rakuten_calorie\\RakutenIngredientUnigram.txt";
		String OutputPath = "D:\\Rakuten_calorie\\NewRakutenIngredientUnigram.txt";
		String readLine = "";
		BufferedReader br = iOhandle.FileReader(InputPath);
		BufferedWriter bw = iOhandle.FileWriter(OutputPath);
		TextTransHiragana textTransHiragana = new TextTransHiragana();
		String Hiragana = "";
		while ((readLine = br.readLine()) != null) {

			String[] splite = readLine.split(" ");
			Hiragana = textTransHiragana.trans(splite[0]);
			bw.write(splite[0] + "+" + Hiragana);
			bw.newLine();
			bw.flush();

		}
	}

}
