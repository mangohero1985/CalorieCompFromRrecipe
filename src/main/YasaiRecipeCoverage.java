/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/21 11:39:55
 */
public class YasaiRecipeCoverage {

	/**
	 * @param args
	 * @throws IOException
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {

		ArrayList<String> rightUnitArrayList = new ArrayList<String>();
		String InputPath = "D:\\Rakuten_calorie\\YasaiAllIngredients.uniq.sort\\YasaiAllIngredients.uniq.sort"; 
		//String InputPath = "D:\\Rakuten_calorie\\Comparing.txt"; 
		String OutputPath ="D:\\Rakuten_calorie\\Comparing.txt";
		IOhandle iOhandle = new IOhandle();
		BufferedReader br = iOhandle.FileReader(InputPath);
		BufferedWriter bw = iOhandle.FileWriter(OutputPath);

		// 创建excel
		String[] title = { "Step-size", "coverage" };

		WritableWorkbook book = Workbook.createWorkbook(new File("D:\\Rakuten_calorie\\Comparing1.csv"));
		WritableSheet sheet = book.createSheet("sheet1", 0);
		sheet.addCell(new Label(0, 0, title[0]));
		sheet.addCell(new Label(1, 0, title[1]));

		String Readline = "";
		ArrayList<String> includeArrayList = new ArrayList<String>();
		while ((Readline = br.readLine()) != null) {
			String[] Splite = Readline.split(" ");
			includeArrayList.add(Splite[Splite.length - 1]);

		}
		int row = 0;
		for (int i = 100; i < includeArrayList.size(); i = i + 100) {
			row++;
			double numerator = 0.0;
			double denominator = 0.0;

			ArrayList<String> previous = new ArrayList<String>();
			ArrayList<String> later = new ArrayList<String>();
			for (int j = 0; j < i; j++) {
				previous.add(includeArrayList.get(j));
			}
			for (int k = includeArrayList.size() - 1; k > i; k--) {
				later.add(includeArrayList.get(k));
			}
			denominator = later.size();
			for (int s = 0; s < previous.size(); s++) {
				for(int m=0;m<later.size();m++){
					if (later.get(m).contains(previous.get(s))) {
						numerator++;
					}
				}
				
			}

			 double prob = numerator / (denominator+numerator);
			 System.out.println(prob);
			 sheet.addCell(new Label(0, row, Integer.toString(i)));
			 sheet.addCell(new Label(1, row, Double.toString(prob)));
			 if(prob>1){
				 break;
			 }
		}
//		for(int i=0;i<rightUnitArrayList.size();i++){
//			bw.write(rightUnitArrayList.get(i));
//			bw.newLine();
//			bw.flush();
//		}
		 book.write();
		 book.close();
	}

}
