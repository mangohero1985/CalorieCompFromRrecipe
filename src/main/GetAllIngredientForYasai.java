/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import sortAndCount.TestWord;
import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time     2015/01/20   14:42:53   
 */
public class GetAllIngredientForYasai {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws WriteException 
	 * @throws RowsExceededException 
	 */
	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
		
		//得到所有野菜的ingredients
		IOhandle iOhandle = new IOhandle();
		String InputPath = "D:\\Rakuten_calorie\\YasaiWOMessy.txt";
		String OutputPath ="D:\\Rakuten_calorie\\YasaiAllIngredients.txt";
		String OutputPathConbined ="D:\\Rakuten_calorie\\YasaiAllIngredientsCombined.txt";
		BufferedReader br = iOhandle.FileReader(InputPath);
		BufferedWriter bw = iOhandle.FileWriter(OutputPath);
		
		String ReadLine = "";
		
		while((ReadLine=br.readLine())!=null){
			
			String[] splite = ReadLine.split("\\:");
			System.out.println(ReadLine);
			String IngredientGroup = splite[1].substring(1,splite[1].length()-1);
			String[] spiteUnit = IngredientGroup.split("\\,");
			for(int i=0;i<spiteUnit.length;i++){
				String NormalText =Normalizer.normalize(spiteUnit[i], Normalizer.Form.NFKC);
				if(NormalText.contains("(")&&NormalText.contains(")")){
					String r2 = NormalText.replaceAll("^.*\\)", "");
					String r1 = NormalText.replaceAll("\\(.*", "");
					NormalText=r1+r2;
				}
				if(!NormalText.matches("^[\\u30A0-\\u30FF\\u3040-\\u309F\\p{InCjkUnifiedIdeographs}{2}]+$")){
					String regEx = "[^\\p{InHiragana}\\p{InKatakana}\\p{InCJKUnifiedIdeographs}+]";
			        Pattern p = Pattern.compile(regEx);
			        Matcher m = p.matcher(NormalText);
			        //替换与模式匹配的所有字符（即非数字的字符将被""替换）

					NormalText=m.replaceAll("\n").trim(); 
				}
				NormalText =Normalizer.normalize(spiteUnit[i], Normalizer.Form.NFKC);
				bw.write(NormalText);
				bw.newLine();
				bw.flush();
			}
			
			
		}
		bw.close();
		br.close();
		//合并相同的ingredients
//		TestWord testWord = new TestWord();
//		testWord.sort(OutputPath, OutputPathConbined);

	}

}
