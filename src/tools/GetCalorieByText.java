/**
 * 
 */
package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import tools.InfoSeek;
import tools.KyteaMorph;
import net.sf.json.JSONObject;
import Iohandle.IOhandle;
import Parser.JsonReaderIntoObj;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/07 12:22:06
 */
public class GetCalorieByText {

	/**
	 * @param args
	 * @throws IOException
	 */
	public ArrayList<String> Compute(String text, String Hiragana,String folderPath) throws IOException {

		// String text = "梅焼き";
		ArrayList<String> nullArrayList = new ArrayList<String>();
		InfoSeek infoSeek = new InfoSeek();
		GetCalorieByText getCalorieByText = new GetCalorieByText();
		// // 转换text成hiragana
		// String Hiragana = "";
		// KyteaMorph kyteaMorph = new KyteaMorph();
		// String returnString = kyteaMorph.GetHiragana(text);
		// if
		// (returnString.matches("^[\\u30A0-\\u30FF\\u3040-\\u309F\\p{InCjkUnifiedIdeographs}{2}]+$"))
		// {
		// Hiragana = returnString;
		// System.out.println(text + " is transformed into Hiragana as " +
		// Hiragana);
		// }
		// else {
		// String[] splite = returnString.split("\\+");
		// StringBuffer stringBuffer = new StringBuffer();
		// for (int j = 0; j < splite.length; j++) {
		// stringBuffer.append(splite[j] + " ");
		// }
		// Hiragana = stringBuffer.toString();
		// System.out.println(text + " is transformed into Hiragana as " +
		// Hiragana);
		// }

		// 读取成分单元从ingredientUnit.txt
		String InputPathUnit = folderPath+"IngredientUnitsSorted.txt";
		IOhandle iOhandle = new IOhandle();
		BufferedReader br = iOhandle.FileReader(InputPathUnit);
		ArrayList<String> allUnitArrayList = new ArrayList<String>();
		ArrayList<String> unitArrayList = new ArrayList<String>();
		String ReadLine = "";
		while ((ReadLine = br.readLine()) != null) {

			allUnitArrayList.add(ReadLine);
		}
		String temp = Hiragana;
		for (int k = 0; k < allUnitArrayList.size(); k++) {
			if (temp.contains(allUnitArrayList.get(k).toString())) {

				unitArrayList.add(allUnitArrayList.get(k));

			}
		}
		// 如果长的单元包含短的单元，留下长的单元
		 ArrayList<String> tempInstead = new ArrayList<String>();
		 for (int h = 0; h < unitArrayList.size(); h++) {
		 if (h == 0) {
		 if (!tempInstead.contains(unitArrayList.get(h)))
		 tempInstead.add(unitArrayList.get(h));
		 }
		 else {
		 int FlagInstead = 0;
		 for (int hh = 0; hh < tempInstead.size(); hh++) {
		
		 if (tempInstead.get(hh).contains(unitArrayList.get(h)) &&
		 !tempInstead.get(hh).equals(unitArrayList.get(h))) {
		 // if (tempInstead.contains(unitArrayList.get(h))) {
		 // tempInstead.remove(tempInstead.indexOf(unitArrayList.get(h)));
		 FlagInstead++;
		 // }
		 }
		 else if (unitArrayList.get(h).contains(tempInstead.get(hh))&&
		 !tempInstead.get(hh).equals(unitArrayList.get(h))) {
		 //tempInstead.remove(hh);
		 tempInstead.set(hh, "/////////");
		 if (!tempInstead.contains(unitArrayList.get(h)))
		 tempInstead.add(unitArrayList.get(h));
		 FlagInstead++;
		 }
		 // else if(FlagInstead==0){
		 // if (!tempInstead.contains(unitArrayList.get(h)))
		 // tempInstead.add(unitArrayList.get(h));
		 // }
		 }
		 if (FlagInstead == 0) {
		 if (!tempInstead.contains(unitArrayList.get(h)))
		 tempInstead.add(unitArrayList.get(h));
		 }
		 }
		 }
		 unitArrayList = tempInstead;
		// 从ingredientUnitHiragana读取json文件
		String InputPath = folderPath+"IngredientUnitHiraganaID.json";
		String DictionaryPath = folderPath+"IDCalorie.json";
		String IDIngredientJson = folderPath+"IDIngredient.json";
		JsonReaderIntoObj jsonReaderIntoObj = new JsonReaderIntoObj();
		JsonReaderIntoObj jsonReaderIntoObj2 = new JsonReaderIntoObj();
		JsonReaderIntoObj jsonReaderIntoObj3 = new JsonReaderIntoObj();
		JSONObject hiraganaIDObj = jsonReaderIntoObj.reader(InputPath);

		JSONObject dictinaryObj = jsonReaderIntoObj2.reader(DictionaryPath);
		JSONObject IDIngreObj = jsonReaderIntoObj3.reader(IDIngredientJson);

		ArrayList<String> nameArrayList = new ArrayList<String>();
		ArrayList<String> keyArrayList = new ArrayList<String>();
		for (int j = 0; j < unitArrayList.size(); j++) {

			Iterator it = hiraganaIDObj.keys();

			while (it.hasNext()) {
				String key = it.next().toString();
				if (key.contains("+")) {
					String[] SpliteKey = key.split("\\+");

					for (int i = 0; i < SpliteKey.length; i++) {

						if (!SpliteKey[i].equals("UNK") && SpliteKey[i].equals(unitArrayList.get(j))) {

							Integer ID = (Integer) hiraganaIDObj.get(key);
							// System.out.println(dictinaryObj.getString(ID.toString()));
							String Calorie = (String) dictinaryObj.get(ID.toString());
							String Name = (String) IDIngreObj.get(ID.toString());
							keyArrayList.add(key);
							nameArrayList.add(Name + ":" + Calorie);
							// System.out.println("The item related with " +
							// text + " is : " + Name + ":" + Calorie);
							// flag++;
						}
					}

				}

				else {

					if (key.equals(unitArrayList.get(j))) {
						Integer ID = (Integer) hiraganaIDObj.get(key);
						String Calorie = (String) dictinaryObj.get(ID.toString());
						String Name = (String) IDIngreObj.get(ID.toString());
						keyArrayList.add(key);
						nameArrayList.add(Name + ":" + Calorie);
						// System.out.println("The item related with " + text +
						// " is : " + Name + ":" + Calorie);
						// flag++;
					}

				}

			}
			// if (flag == 0) {
			//
			// System.out.println();
			// System.out.println("Please choose a basic unit from input text,");
			// System.out.println("or this is not a correct ingredient.");
			// System.out.println("Please input again!");
			//
			// }
		}
		int flag = 0;
		ArrayList<String> oneUnitArrayList = new ArrayList<String>();
		ArrayList<String> multiUnitArrayList = new ArrayList<String>();
		for (int k = 0; k < keyArrayList.size(); k++) {

			int UnitFlag = 0;
			String[] spliteUnits = keyArrayList.get(k).split("\\+");
			for (int b = 0; b < spliteUnits.length; b++) {
				for (int s = 0; s < unitArrayList.size(); s++) {

					if (spliteUnits[b].equals(unitArrayList.get(s))) {
						UnitFlag++;
					}
				}
			}

			if (UnitFlag > 1) {
				if (!multiUnitArrayList.contains(nameArrayList.get(k))) multiUnitArrayList.add(nameArrayList.get(k));
			}
			else if (UnitFlag == 1) {
				if (!oneUnitArrayList.contains(nameArrayList.get(k))) oneUnitArrayList.add(nameArrayList.get(k));
			}

		}
		// if (multiUnitArrayList.size() > 0) {
		// System.out.println(multiUnitArrayList);
		// }
		// else if (multiUnitArrayList.size() == 0 && oneUnitArrayList.size() !=
		// 0) {
		// System.out.println(oneUnitArrayList);
		// }
		// else {
		// System.out.println();
		// System.out.println("Please choose a basic unit from input text,");
		// System.out.println("or this is not a correct ingredient.");
		// System.out.println("Please input again!");
		// }

		// 输入到infoseek判断最终返回值的概率
		// 使用infoseek获取返回结果
		String ReturnResultOfKeyWord = infoSeek.GoogleResultReturn("\"" + text + "\"");
		// 解析keyword返回的数据流
		int Denominator = getCalorieByText.Result(ReturnResultOfKeyWord);
		if (multiUnitArrayList.size() > 0) {
			// System.out.println(multiUnitArrayList);
			ArrayList<String> ingredient = getCalorieByText.probablity(multiUnitArrayList, infoSeek, getCalorieByText, text, Denominator, Hiragana);
			return ingredient;

		}
		else if (multiUnitArrayList.size() == 0 && oneUnitArrayList.size() != 0) {
			ArrayList<String> ingredient = getCalorieByText.probablity(oneUnitArrayList, infoSeek, getCalorieByText, text, Denominator, Hiragana);
			return ingredient;
		}
		else {
			// System.out.println();
			// System.out.println("Please choose a basic unit from input text,");
			// System.out.println("or this is not a correct ingredient.");
			// System.out.println("Please input again!");
			nullArrayList.add("Please input again!");
			return nullArrayList;
		}

		// Iterator it = hiraganaIDObj.keys();
		// int flag = 0;
		// while (it.hasNext()) {
		// String key = it.next().toString();
		// if (key.contains("+")) {
		// String[] SpliteKey = key.split("\\+");
		//
		// for (int i = 0; i < SpliteKey.length; i++) {
		//
		// if (!SpliteKey[i].equals("UNK") && SpliteKey[i].equals(Hiragana)) {
		//
		// Integer ID = (Integer) hiraganaIDObj.get(key);
		// // System.out.println(dictinaryObj.getString(ID.toString()));
		// String Calorie = (String) dictinaryObj.get(ID.toString());
		// String Name = (String) IDIngreObj.get(ID.toString());
		// System.out.println("The item related with " + text + " is : " + Name
		// + ":" + Calorie);
		// flag++;
		// }
		// }
		//
		// }
		// else {
		//
		// if (key.equals(Hiragana)) {
		// Integer ID = (Integer) hiraganaIDObj.get(key);
		// String Calorie = (String) dictinaryObj.get(ID.toString());
		// String Name = (String) IDIngreObj.get(ID.toString());
		// System.out.println("The item related with " + text + " is : " + Name
		// + ":" + Calorie);
		// flag++;
		// }
		//
		// }
		//
		// }
		// if (flag == 0) {
		//
		// System.out.println();
		// System.out.println("Please choose a basic unit from input text,");
		// System.out.println("or this is not a correct ingredient.");
		// System.out.println("Please input again!");
		//
		// }
	}

	// 将返回的数据流截取成数字
	private int Result(String ReturnResultOfKeyWord) {

		int Number = 0;

		if (!ReturnResultOfKeyWord.contains("約&nbsp;")) {
			return Number;
		}
		else {
			String[] spliteReturnResult1 = ReturnResultOfKeyWord.split("約&nbsp;");
			String[] splitePureNum1 = spliteReturnResult1[1].substring(0, 12).split("&");
			Number = Integer.parseInt(splitePureNum1[0]);
			// System.out.println(NumOfKeyword);

			return Number;
		}

	}

	private ArrayList<String> probablity(ArrayList<String> ar, InfoSeek infoSeek, GetCalorieByText getCalorieByText, String text, int Denominator, String Hiragana) {
		double prob = 0.0;
		// map对象存储值ingredient 和 probability
		Map<String, Double> ingreProbMap = new HashMap<String, Double>();

		for (int i = 0; i < ar.size(); i++) {
			String[] splite = ar.get(i).split("\\:");
			if (splite[0].contains("(")) {
				String[] splite2 = splite[0].split("\\(");
				String IngreCandiate = infoSeek.GoogleResultReturn(text + "+" + "\"" + splite2[0] + "を" + "\"");
				int Numerator = getCalorieByText.Result(IngreCandiate);
				prob = (double) Numerator / (double) Denominator * 1000.0;

				ingreProbMap.put(ar.get(i), prob);
				// System.out.println(ingreProbMap);

			}
			else {
				String IngreCandiate = infoSeek.GoogleResultReturn(text + "+" + "\"" + splite[0] + "を" + "\"");
				int Numerator = getCalorieByText.Result(IngreCandiate);
				prob = (double) Numerator / (double) Denominator * 1000.0;
				ingreProbMap.put(ar.get(i), prob);
				// System.out.println(ingreProbMap);

			}

		}
		// 如果查询结果中绝对匹配text就返回text
		Set<String> set = ingreProbMap.keySet();
		Iterator it = set.iterator();
		ArrayList<String> ingredient = new ArrayList<String>();
		while (it.hasNext()) {

			String unit = (String) it.next();
			String subUnit = unit.substring(0, unit.lastIndexOf(":"));
			if (subUnit.contains("(")) {
				subUnit = subUnit.substring(0, subUnit.lastIndexOf("("));
			}
			if (subUnit.equals(Hiragana)) {
				ingredient.add(unit);
			}

		}
		if (!ingredient.isEmpty()) {
			return ingredient;
		}
		else {
			ingredient = compare(ingreProbMap);
			return ingredient;
		}

	}

	private ArrayList<String> compare(Map<String, Double> keyfreqs) {

		ArrayList<String> ingredient = new ArrayList<String>();

		ArrayList<Entry<String, Double>> l = new ArrayList<Entry<String, Double>>(keyfreqs.entrySet());

		Collections.sort(l, new Comparator<Map.Entry<String, Double>>() {
			public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
				Double v1 = o1.getValue();
				Double v2 = o2.getValue();
				return v1.compareTo(v2);
			}
		});
		Entry<String, Double> maxmium = l.get(l.size() - 1);
		// System.out.println(l);
		for (Entry<String, Double> e : l) {
			if (!(e.getValue() < maxmium.getValue())) {
				ingredient.add(e.getKey().toString());
			}
		}

		return ingredient;
	}

}
