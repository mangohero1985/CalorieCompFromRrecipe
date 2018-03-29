/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/20 9:57:45
 */
public class GetRecipeByCategory {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String CategoryId = "12";
		String InputPathCategory = "D:\\Rakuten Recipe\\all_category_20141101\\all_category_20141101.tsv";
		String InputPathMaterial = "D:\\Rakuten Recipe\\all_material_20141101\\all_material_20141101.tsv";
		String OutputPath = "D:\\Rakuten_calorie\\IngredientByCategory.txt";

		String ReadLine = "";

		IOhandle iOhandle = new IOhandle();

		BufferedReader brCategory = iOhandle.FileReader(InputPathCategory);
		BufferedReader brMaterial = iOhandle.FileReader(InputPathMaterial);
		ArrayList<String> recipeIDArrayList = new ArrayList<String>();
		 BufferedWriter bw = iOhandle.FileWriter(OutputPath);

		while ((ReadLine = brCategory.readLine()) != null) {
			String[] splite = ReadLine.split("\t");
			if (splite[1].equals(CategoryId)) {
				recipeIDArrayList.add(splite[0]);
			}

		}

		 String Key = "";
		 int flag=0;
		 ArrayList<String> ingreArrayList = new ArrayList<String>();
		 Map<String, ArrayList<String>> keyAndIngreMap = new HashMap<String, ArrayList<String>>();
		while ((ReadLine = brMaterial.readLine()) != null) {
             
              String[] splite = ReadLine.split("\t");
              if(recipeIDArrayList.contains(splite[0])){
            	  Key=splite[0];
              }
              if(Key.equals(splite[0])){
            	  ingreArrayList.add(splite[1]);
            	  flag++;
              }else if(!ingreArrayList.isEmpty()&&flag!=-1){
            	 // keyAndIngreMap.put(Key, ingreArrayList);
            	  bw.write(Key+":"+ingreArrayList);
            	  bw.newLine();
            	  bw.flush();
            	  ingreArrayList.clear();
            	  flag=-1;
              }
              
		}
		
//		Iterator it = keyAndIngreMap.keySet().iterator();
//		while(it.hasNext()){
//			String key = (String) it.next();
//			bw.write(key+":"+keyAndIngreMap.get(keyAndIngreMap) );
//			bw.newLine();
//			bw.flush();
//		}

		bw.close();
		brCategory.close();
		brMaterial.close();
	}

}
