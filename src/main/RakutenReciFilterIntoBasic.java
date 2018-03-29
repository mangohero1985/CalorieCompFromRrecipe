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
public class RakutenReciFilterIntoBasic {

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
		arr.add("1");
		RakutenReciFilterIntoBasic rakutenReciFilterIntoBasic = new RakutenReciFilterIntoBasic();

		while (Integer.parseInt(arr.get(arr.size() - 1)) > 0) {
			arr = rakutenReciFilterIntoBasic.Iterator(arr);
			
		}
		if (Integer.parseInt(arr.get(arr.size() - 1)) == 0) {
			for (int i = 0; i < arr.size() - 1; i++) {
				bw.write(arr.get(i));
				bw.newLine();
				bw.flush();
			}
		}

		System.out.println("合并完成");

	}

	public <E> ArrayList<E> Iterator(ArrayList<String> arr) throws IOException {
		Integer Flag = 0;
		ArrayList<String> basicUnitArr = new ArrayList<String>();
		// ArrayList<E> arrAndFlag = new ArrayList<E>();
		for (int i = 0; i < arr.size(); i++) {
			int k = 0;
			for (int j = 0; j < arr.size(); j++) {

				// System.out.println(i + ":" + j);
				// 存储长度较短的ingredient
				if (arr.get(i).toString().contains(arr.get(j)) && !arr.get(i).toString().equals(arr.get(j)) && arr.get(j).toString().length() > 2) {
					Flag++;
					k++;
					if (!basicUnitArr.contains(arr.get(j))) {
						basicUnitArr.add(arr.get(j));

						arr.remove(i);
					}

				}
				else if (arr.get(j).contains(arr.get(i)) && !arr.get(i).toString().equals(arr.get(j)) && arr.get(i).toString().length() > 2) {

					Flag++;
					k++;
					if (!basicUnitArr.contains(arr.get(i))) {
						basicUnitArr.add(arr.get(i));
						// String temp = arr.get(j);
						// arr.set(j, arr.get(i));
						// arr.set(i, temp);

						arr.remove(j);
					}

				}

			}
			if (!basicUnitArr.contains(arr.get(i)) && k == 0) {
				basicUnitArr.add(arr.get(i));
			}
		}
		if (Flag != 0) {
			System.out.println(basicUnitArr.size());
			basicUnitArr.add(Flag.toString());
			return (ArrayList<E>) basicUnitArr;
		}
		else {
			arr.set(arr.size() - 1, Flag.toString());
			return (ArrayList<E>) arr;
		}

	}

}
