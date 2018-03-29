/**
 * 
 */
package Parser;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/06 14:50:23
 */
public class SearchNutritionTreeByName {

	public String Search(String InputPath, String Name) {
		String Nutrition = "";
		Map<String, Integer> IngreNameID = new TreeMap<String, Integer>();
		JsonReaderIntoArrays jsonReaderIntoArrays = new JsonReaderIntoArrays();
		JSONArray jsonArray = jsonReaderIntoArrays.reader(InputPath);
		//System.out.println(jsonArray.size());
		for (int i = 0; i < jsonArray.size(); i++) {

			JSONObject jsonUnit = JSONObject.fromObject(jsonArray.getString(i));
			Iterator it = jsonUnit.keys();
			while (it.hasNext()) {

				String key = it.next().toString();
				JSONArray jsonIngreArrays = (JSONArray) jsonUnit.get(key);
				JSONObject jsonIngreObject = JSONObject.fromObject(jsonIngreArrays.get(0));
				
				if(!(jsonIngreObject.get(Name)==null)){
					Nutrition = (String) jsonIngreObject.get(Name);
					break;
				}

			}
		}
		return Nutrition;
	}
}
