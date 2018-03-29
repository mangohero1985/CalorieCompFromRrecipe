/**
 * 
 */
package main;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import tools.KyteaMorph;
import tools.MecabMorph;
import net.sf.json.JSONObject;
import Parser.JsonReaderIntoObj;
import Parser.JsonWriter;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/07 9:48:14
 */
public class TransIngreIntoHiraganaID {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String folderPath = "D:\\Rakuten_calorie\\CalorieModified\\";

		String InputPath = folderPath + "IngredientUnitID.json";
		// 创建KyteaMorphor解析对象
		KyteaMorph kyteaMorph = new KyteaMorph();
		String Hiragana = "";

		// 读取ingredientUnitID.json 到 JSONObj
		JsonReaderIntoObj jsonReaderIntoObj = new JsonReaderIntoObj();
		JSONObject jsonObject = jsonReaderIntoObj.reader(InputPath);

		Iterator it = jsonObject.keys();

		Map<String, Integer> map = new TreeMap<String, Integer>();
		while (it.hasNext()) {

			String Name = it.next().toString();
			Integer ID = (Integer) jsonObject.get(Name);
			// 使用kytea进行分词
			Hiragana = kyteaMorph.GetHiragana(Name);
			map.put(Hiragana, ID);

		}
		JsonWriter jw = new JsonWriter();
		jw.Write(map, folderPath + "MecabIngredientUnitHiraganaID.json");
	}

}
