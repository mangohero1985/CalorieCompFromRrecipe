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
 * @create-time 2015/04/08 9:42:25
 */
public class GetHiraganaForYasaiSample {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		IOhandle iOhandle = new IOhandle();
		String InputPath = "D:\\Rakuten_calorie\\YasaiSample.txt";
		String OutputPath = "D:\\Rakuten_calorie\\YasaiSampleMecabTrans.txt";
		BufferedReader br = iOhandle.FileReader(InputPath);
		BufferedWriter bw = iOhandle.FileWriter(OutputPath);
		String readLine = "";
		MecabMorph mecabMorph = new MecabMorph();
		while ((readLine = br.readLine()) != null) {
			// 创建一个sampleTupleArrayList存储sample的每一个元组
			ArrayList<String> sampleTupleArrayList = new ArrayList<String>();
			String temp = readLine.substring(12, readLine.length() - 1);
			String[] ingreArray = temp.split(",");
			for (int i = 0; i < ingreArray.length; i++) {
				String ingredient = ingreArray[i].toString();

				String hiragana = mecabMorph.GetHiragana(ingredient);
				sampleTupleArrayList.add(hiragana);
			}
			bw.write(readLine + "&&&&&&" + sampleTupleArrayList.toString());
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();

	}

}
