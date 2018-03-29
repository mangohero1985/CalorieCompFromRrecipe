/**
 * 
 */
package main;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Parser.JsonReaderIntoArrays;
import Parser.JsonWriter;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/06 11:21:38
 */
public class TransIngreToIDJSon {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String folderPath ="D:\\Rakuten_calorie\\CalorieModified\\";

		String InputPath = folderPath+"Calorie.json";
        Map<String,Integer> IngreNameID = new TreeMap<String,Integer>();
        Map<Integer,String> IDIngreName = new TreeMap<Integer,String>();
		JsonReaderIntoArrays jsonReaderIntoArrays = new JsonReaderIntoArrays();
		JSONArray jsonArray = jsonReaderIntoArrays.reader(InputPath);
		//System.out.println(jsonArray.size());
		int ID =1000001;
		for (int i = 0; i < jsonArray.size(); i++) {

			JSONObject jsonUnit = JSONObject.fromObject(jsonArray.getString(i));
			Iterator it = jsonUnit.keys();
			
			while (it.hasNext()) {

				String key = it.next().toString();
				JSONArray jsonIngreArrays= (JSONArray) jsonUnit.get(key);
				JSONObject jsonIngreObject = JSONObject.fromObject(jsonIngreArrays.get(0));
			//	System.out.println(jsonIngreObject.get("あんぱん"));
				Iterator IngreIt = jsonIngreObject.keys();
				while(IngreIt.hasNext()){
					String Ingredient = IngreIt.next().toString();
					IngreNameID.put(Ingredient,ID);
					IDIngreName.put(ID, Ingredient);
					ID++;
				}
			}
		}
		JsonWriter jw1= new JsonWriter();
		jw1.Write(IngreNameID, folderPath+"IngredientID.json");
		JsonWriter jw2= new JsonWriter();
		jw2.Write(IDIngreName, folderPath+"IDIngredient.json");
	}
}
