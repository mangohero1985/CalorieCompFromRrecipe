/**
 * 
 */
package BuildNewDictionary.Main;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.JsonObject;

import Parser.JsonReaderIntoObj;

/**
 * @author ar-weichang.chen
 * @create-time 2015/03/02 14:26:48
 */
public class ReadUrlFormJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String InputPath = "D:\\Rakuten_calorie\\Crawler\\CrawlerURL.json";

		JsonReaderIntoObj jsonReaderIntoObj = new JsonReaderIntoObj();
		JSONObject jo = jsonReaderIntoObj.reader(InputPath);
		JSONArray ja = jo.getJSONArray("Category");
		Iterator it = ja.iterator();
		while (it.hasNext()) {
			JSONObject jo1 = (JSONObject) it.next();
			JSONArray ja1 = (JSONArray) jo1.get(jo1.keySet().toArray()[0]);
			JSONObject jo2= (JSONObject) ja1.get(0);
			Iterator it1 = jo2.keySet().iterator();
			while(it1.hasNext()){
				String str = (String) it1.next();
				System.out.println(jo2.get(str));

			}
		}
	}
}
