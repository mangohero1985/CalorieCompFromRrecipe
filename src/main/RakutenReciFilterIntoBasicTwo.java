/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @param <E>
 * @create-time 2014/12/29 11:03:33
 */
public class RakutenReciFilterIntoBasicTwo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String InputPath = "D:\\DownloadApplication\\development_tools\\kytea\\NaiveBayesClassification\\IngreWOmessy.txt";
		String OutputPath = "D:\\Rakuten_calorie\\BasicUnitofRakutenRecipe.txt";
		String ReadLine;
		ArrayList<String> arr = new ArrayList<String>();

		IOhandle iOhandle = new IOhandle();
		BufferedReader br = iOhandle.FileReader(InputPath);
		BufferedWriter bw = iOhandle.FileWriter(OutputPath);

		while ((ReadLine = br.readLine()) != null) {

			if (!arr.contains(ReadLine)) {
				arr.add(ReadLine);
			}

		}
		ArrayList<String> basicUnitArr = new ArrayList<String>();
		// ArrayList<E> arrAndFlag = new ArrayList<E>();
		for (int i = 0; i < arr.size(); i++) {
			int k = 0;
			for (int j = 0; j < arr.size(); j++) {

				// System.out.println(i + ":" + j);
				// 存储长度较短的ingredient
				if (arr.get(i).toString().contains(arr.get(j)) && !arr.get(i).toString().equals(arr.get(j)) && arr.get(j).toString().length() > 1) {

					if (arr.get(i).length()-arr.get(j).length()>2) {
						//!arr.get(i).subSequence(arr.get(i).length()-arr.get(j).length(), arr.get(i).length()-1).equals(arr.get(j))&&
						k++;
						if (!basicUnitArr.contains(arr.get(j))) {
							basicUnitArr.add(arr.get(j));

							arr.remove(i);
							break;
						}
					}
				}

			}
			if (!basicUnitArr.contains(arr.get(i)) && k == 0) {
				bw.write(arr.get(i));
				bw.newLine();
				bw.flush();
			}
		}

		System.out.println("合并完成");

	}
}