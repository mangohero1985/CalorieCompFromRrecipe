/**
 * 
 */
package main;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.rowset.serial.SerialArray;

import Parser.JsonReaderIntoArrays;
import Parser.JsonReaderIntoObj;
import Parser.JsonWriter;
import Parser.SearchNutritionTreeByName;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/06 15:00:44
 */
public class TransNameJsonIntoIDJason {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		String FolderPath = "D:\\Rakuten_calorie\\CalorieModified\\";
		// 读取IngredientID.json,得到ID的值
		String InputPathIDTree = FolderPath+"IngredientID.json";
		JsonReaderIntoObj jsonReaderIntoObj = new JsonReaderIntoObj();
		JSONObject jsonObject = jsonReaderIntoObj.reader(InputPathIDTree);

		// 读取Calorie.json获取 卡路里数值
		String InputPathCalorie = FolderPath+"Calorie.json";
		SearchNutritionTreeByName searchNutritionTreeByName = new SearchNutritionTreeByName();
		int i = 0;
		Iterator it = jsonObject.keys();

		//map存储所有的ID+calorie对
		Map<Integer, String> IDCalorieMap = new TreeMap<Integer, String>();
		while (it.hasNext()) {
			//i++;
			//System.out.println(i);
			String Name = it.next().toString();
			Integer id = (Integer) jsonObject.get(Name);

			System.out.println(id+":"+Name);
			String Calorie = searchNutritionTreeByName.Search(InputPathCalorie, Name);
			IDCalorieMap.put(id, Calorie);
			
		}
		
		JsonWriter jw = new JsonWriter();
		jw.Write(IDCalorieMap, FolderPath+"IDCalorie.json");

	}

}
