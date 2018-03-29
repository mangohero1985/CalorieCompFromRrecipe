/**
 * 
 */
package YasaiCoverage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import tools.KyteaMorph;
import tools.MecabMorph;
import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time     2015/04/08   10:41:33   
 */
public class GetHiraganaForYasaiCoverage {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		IOhandle iOhandle = new IOhandle();
		String InputPath = "D:\\Rakuten_calorie\\CalorieModified\\YasaiCoverage.txt";
		String OutputPath ="D:\\Rakuten_calorie\\CalorieModified\\YasaiCoverageMecabHiragana.txt";
		BufferedReader br = iOhandle.FileReader(InputPath);
		BufferedWriter bw = iOhandle.FileWriter(OutputPath);
		String readLine = "";
		
		MecabMorph mecabMorph = new MecabMorph();
		
		while ((readLine = br.readLine()) != null) {
			String[] split = readLine.split("\\+");
			String hiragana =mecabMorph.GetHiragana(split[0]);
			bw.write(split[0]+"+"+hiragana+"+"+split[2]);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
	}

}
