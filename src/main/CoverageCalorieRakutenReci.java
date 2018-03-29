/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import tools.GetCalorieByText;
import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/14 11:08:17
 */
public class CoverageCalorieRakutenReci {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String folderPath = "D:\\Rakuten_calorie\\CalorieModified\\";
		IOhandle iOhandle = new IOhandle();
		String InputPath = folderPath + "YasaiRepresentUnit1.txt";
		String OutputPath = folderPath + "YasaiCoverage1.txt";

		String readLine = "";
		BufferedReader br = iOhandle.FileReader(InputPath);
		BufferedWriter bw = iOhandle.FileWriter(OutputPath);
		GetCalorieByText calorieComp = new GetCalorieByText();
		ArrayList<String> ar = new ArrayList<String>();
		while ((readLine = br.readLine()) != null) {
			StringBuffer sb = new StringBuffer();
			String[] splite = readLine.split("\\+");
			for (int i = 1; i < splite.length; i++) {
				sb.append(splite[i]);
			}
			ArrayList<String> dicArrayList = new ArrayList<String>(Arrays.asList("か+に", "が+に", "だ+し", "さ+や", "じゃ+が", "う+に"));
			String newSb = sb.toString();
			for (int i = 0; i < dicArrayList.size(); i++) {

				if (sb.toString().contains(dicArrayList.get(i))) {
					String replaceStr = dicArrayList.get(i).replace("+", "");
					newSb = sb.toString().replaceAll(dicArrayList.get(i), replaceStr);
				}
			}
			ar = calorieComp.Compute(splite[0], newSb, folderPath);
			System.out.println(ar);

			bw.write(splite[0] + "+" + splite[1] + "+" + ar.toString().substring(1, ar.toString().length() - 1));
			bw.newLine();
			bw.flush();

		}

	}

}
