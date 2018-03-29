/**
 * 
 */
package BuildNewDictionary.Control;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Parser.GeneralHtmlParser;

/**
 * @author ar-weichang.chen
 * @create-time 2015/03/02 16:30:47
 */
public class HtmlParse {

	/**
	 * @param args
	 * @throws IOException
	 */
	public Map<String,String> Parse(String InputPath) throws IOException {

		GeneralHtmlParser generalHtmlParser = new GeneralHtmlParser();
		generalHtmlParser.SetPath(InputPath);
		Document doc = generalHtmlParser.Parser();
		Elements tables = doc.select("table");
		ArrayList<String> nameArrayList = new ArrayList<String>();
		ArrayList<String> calorieArrayList = new ArrayList<String>();
		Map<String, String> dicMap = new TreeMap<String, String>();
		if (!tables.isEmpty()) {
			for (Element table : tables) {
				if (table.toString().contains("お店・メーカー")) {
					// Get the ingredient name from html
					Elements divs = table.select("div").select(".thumb40");
					for (Element div : divs) {
						String name = div.select("img").first().attr("alt");
						nameArrayList.add(name);
					}
					// Get the calorie from html
					Elements divs2 = table.select("div").select(".bOn");
					for (Element div : divs2) {
						if (div.toString().contains("amountScale")) {
							String calorie = "";
							String unit = "";
							String rate = "";
							if (div.select("input").get(0).attr("name").toString().contains("amountScale")) {
								calorie = div.select("input").get(0).attr("value");

							}
							if (div.select("input").get(1).attr("name").toString().contains("defaultRate")) {
								rate = div.select("input").get(1).attr("value");

							}
							if (div.select("input").get(2).attr("name").contains("foodUnit")) {
								unit = div.select("input").get(2).attr("value");

							}

							calorieArrayList.add(calorie + "/" + rate + unit);

						}
					}

				}

			}

		}
		for(int i=0;i<nameArrayList.size();i++){
			
			dicMap.put(nameArrayList.get(i), calorieArrayList.get(i));
			
		}
		return dicMap;
	}
}
