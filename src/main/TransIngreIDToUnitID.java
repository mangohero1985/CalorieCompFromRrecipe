/**
 * 
 */
package main;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.jar.Attributes.Name;

import net.moraleboost.mecab.Lattice;
import net.moraleboost.mecab.Node;
import net.moraleboost.mecab.impl.StandardTagger;
import net.sf.json.JSONObject;
import Parser.JsonReaderIntoObj;
import Parser.JsonWriter;

/**
 * @author ar-weichang.chen
 * @create-time     2015/01/06   16:19:09   
 */
public class TransIngreIDToUnitID {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String folderPath = "D:\\Rakuten_calorie\\CalorieModified\\";
		String InputPath =folderPath+"IngredientID.json";
		
		//读取ingredientID.json 到 JSONObj
		JsonReaderIntoObj jsonReaderIntoObj = new JsonReaderIntoObj();
		JSONObject jsonObject =jsonReaderIntoObj.reader(InputPath);
		
		Iterator it = jsonObject.keys();
		
		Map<String, Integer> map = new TreeMap<String, Integer>();
		while(it.hasNext()){
			
			String Name = it.next().toString();
			Integer ID =  (Integer) jsonObject.get(Name);
			if(Name.contains("/")||Name.contains("(")){
				
			  if(Name.startsWith("(")){
				  Name =Name.replaceAll("\\)", ") ");
//				  String[] splte = Name.split(" ");
//				  Name = splte[1];
			  }else if(Name.contains("(")){
				  Name = Name.replaceAll("\\(", " (");
//				  String[] splte = Name.split(" ");
//				  Name = splte[0];
			  }else{
				  Name = Name.replaceAll("\\/", " /");
//				  String[] splte = Name.split(" ");
//				  Name = splte[0];
			  }
			}
			
			map.put(Name, ID);
			
			
		}
		JsonWriter jw = new JsonWriter();
		jw.Write(map, folderPath+"IngredientUnitID.json");

	}

}
