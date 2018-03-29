/**
 * 
 */
package Parser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

/**
 * @author ar-weichang.chen
 * @param <E>
 * @create-time 2014/12/24 11:04:36
 */
public class HtmlPaser<E> {

	public org.jsoup.nodes.Document Doc;
	public File inPut;
	ArrayList<Map<String, ArrayList<Map<String, String>>>> classAndValueArrayList = new ArrayList<Map<String, ArrayList<Map<String, String>>>>();
	ArrayList<String> classArrayList = new ArrayList<String>();

	// 存储每一类的map
	ArrayList<Map<String, String>> IngreCalorieArraylist = new ArrayList<Map<String, String>>();

	public void getPath(String Path) {

		inPut = new File(Path);
	}

	public ArrayList<Map<String, ArrayList<Map<String, String>>>> Parser() throws IOException {

		Doc = Jsoup.parse(inPut, "UTF-8", "http://");
		// System.out.println(Doc);
		Elements divs = Doc.select("table");
		if (!divs.isEmpty()) {
			for (Element div : divs) {
				// ingreCalorieMap.clear();
				if (div.toString().contains("食品名")) {
					// 提取类别名称
					String classification = div.select("img[alt]").first().attr("alt");
					classArrayList.add(classification + " " + "/100g");
					// 提取成分列表
					Elements ingredientElements = div.select("tr");
					if (!ingredientElements.isEmpty()) {
						Map<String, String> ingreCalorieMap = new TreeMap<String, String>();
						for (Element div1 : ingredientElements) {

							if (!div1.toString().contains("class") && !div1.toString().contains("colspan")) {
								String Ingredient = div1.select("td").first().text();
								String Calorie = div1.select("td").last().text();
								ingreCalorieMap.put(Ingredient, Calorie);
							}

						}
						IngreCalorieArraylist.add(ingreCalorieMap);
					}

				}

			}
		}
		
		for (int i = 0; i < IngreCalorieArraylist.size(); i++) {
			Map<String, ArrayList<Map<String, String>>> pairMap = new TreeMap<String, ArrayList<Map<String, String>>>();
			ArrayList<Map<String, String>> tempArr = new ArrayList<Map<String, String>>();
			// tempArr.add((E) classArrayList.get(i));
			tempArr.add(IngreCalorieArraylist.get(i));
			// System.out.println(tempArr);

			pairMap.put(classArrayList.get(i), tempArr);
			// System.out.println(pairMap);
			classAndValueArrayList.add(pairMap);
		}
		
		System.out.println(classAndValueArrayList);

		return classAndValueArrayList;

	}

}
