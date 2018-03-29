/**
 * 
 */
package YasaiCoverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import tools.KyteaMorph;
import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time 2015/04/03 12:09:30
 */
public class ComputeCoverageForYasai {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		IOhandle iOhandle = new IOhandle();
		String InputPath = "D:\\Rakuten_calorie\\YasaiSample.txt";
		BufferedReader br = iOhandle.FileReader(InputPath);
		String readLine = "";
		String inputPathDictionary = "D:\\Rakuten_calorie\\CalorieModified\\YasaiRepresentUnit.txt";
		BufferedReader brDic = iOhandle.FileReader(inputPathDictionary);
		// 创建arraylist存贮所有的representUnit
		ArrayList<String> dicArrayList = new ArrayList<String>();
		int row =0;
		//比率低的菜谱
		ArrayList<Integer> rowArrayList = new ArrayList<Integer>();
		while ((readLine = brDic.readLine()) != null) {
			row++;
			String[] temp = readLine.split("\\+");
			StringBuffer sb = new StringBuffer();
			for (int j = 1; j < temp.length; j++) {
				sb.append(temp[j]);
			}
			dicArrayList.add(sb.toString());

		}
		int five =0;
		int four =0;
		int three =0;
		int two =0;
		int one =0;
		while ((readLine = br.readLine()) != null) {
			// 创建一个sampleTupleArrayList存储sample的每一个元组
			ArrayList<String> sampleTupleArrayList = new ArrayList<String>();
			String temp = readLine.substring(12, readLine.length() - 1);
			String[] ingreArray = temp.split(",");
			KyteaMorph kyteaMorph = new KyteaMorph();
			for (int i = 0; i < ingreArray.length; i++) {
				String ingredient = ingreArray[i].toString();
				String hiragana = kyteaMorph.GetHiragana(ingredient);
				sampleTupleArrayList.add(hiragana);
			}
			int num = 0;
			for (int k = 0; k < sampleTupleArrayList.size(); k++) {

				for (int s = 0; s < dicArrayList.size(); s++) {

					if (sampleTupleArrayList.get(k).contains(dicArrayList.get(s))) {
						num++;
						break;
					}
				}
			}
			float ratio =(float)num /(float) sampleTupleArrayList.size();
			System.out.println(ratio);
			
			if(ratio>0.8&&ratio<=1){
				five++;
			}else if (ratio>0.6&&ratio<=0.8){
				four++;
				rowArrayList.add(row);
			}else if (ratio>0.4&&ratio<=0.6){
				three++;
				rowArrayList.add(row);
			}
			else if (ratio>0.2&&ratio<=0.4){
				two++;
				rowArrayList.add(row);
			}else if (ratio>=0&&ratio<=0.2){
				one++;
				rowArrayList.add(row);
			}

		}
		System.out.println(five);
		System.out.println(four);
		System.out.println(three);
		System.out.println(two);
		System.out.println(one);

	}
}
