/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tools.InfoSeek;
import tools.KyteaMorph;
import Iohandle.IOhandle;
import Parser.SearchNutritionTreeByName;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/06 14:55:21
 */
public class Test {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
//		String str = "バ(みじんぎり)ジル";
////		String r1 = str.replaceAll("\\[.*", "");
////		String r2 = str.replace("^.*\\]", "");
//		String r2 = str.replaceAll("^.*\\)", "");
//		String r1 = str.replaceAll("\\(.*", "");
//		System.out.println(r1+r2);
		
//		// 只允指定字符
//        String regEx = "[^\\p{InHiragana}\\p{InKatakana}\\p{InCJKUnifiedIdeographs}+]";
//        Pattern p = Pattern.compile(regEx);
//        Matcher m = p.matcher("≪筍の茹で方≫");
//        //替换与模式匹配的所有字符（即非数字的字符将被""替换）
//
//		System.out.println(m.replaceAll("").trim() ); 
		
		
//		KyteaMorph kyteaMorph = new KyteaMorph();
//		String returnString = kyteaMorph.GetHiragana(text);
		
		
		String InputPath = "D:\\Rakuten_calorie\\YasaiAllIngredients.uniq.sort\\YasaiAllIngredients.uniq.sort"; 
		//String InputPath = "D:\\Rakuten_calorie\\Comparing.txt"; 
		String OutputPath ="D:\\Rakuten_calorie\\YasaiRepresentUnit.txt";
		IOhandle iOhandle = new IOhandle();
		BufferedReader br = iOhandle.FileReader(InputPath);
		BufferedWriter bw = iOhandle.FileWriter(OutputPath);
		String ReadLine = "";
		KyteaMorph kyteaMorph = new KyteaMorph();
		ArrayList<String> dicArrayList = new ArrayList<String>(Arrays.asList("か+に", "が+に", "だ+し","さ+や","じゃ+が","う+に"));
		while((ReadLine=br.readLine())!=null){
			
			String[] Splite = ReadLine.split(" ");
			ReadLine= Splite[Splite.length - 1];
			
			String returnString = kyteaMorph.GetHiragana(ReadLine);
			for(int i=0;i<dicArrayList.size();i++){
				
				if (returnString.contains(dicArrayList.get(i))) {
					String replaceStr = dicArrayList.get(i).replace("+", "");
					returnString = returnString.replaceAll(dicArrayList.get(i),replaceStr);
				}
			}
			bw.write(ReadLine+"+"+returnString);
			bw.newLine();
			bw.flush();
		}
	}

}
