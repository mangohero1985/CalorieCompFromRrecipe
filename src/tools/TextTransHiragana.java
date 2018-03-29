/**
 * 
 */
package tools;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/14 13:58:15
 */
public class TextTransHiragana {

	public String trans(String text) {

		// 转换text成hiragana
		String Hiragana = "";
		KyteaMorph kyteaMorph = new KyteaMorph();
		String returnString = kyteaMorph.GetHiragana(text);
		if (returnString.matches("^[\\u30A0-\\u30FF\\u3040-\\u309F\\p{InCjkUnifiedIdeographs}{2}]+$")) {
			Hiragana = returnString;
			System.out.println(text + " is transformed into Hiragana as " + Hiragana);
		}
		else {
			String[] splite = returnString.split("\\+");
			StringBuffer stringBuffer = new StringBuffer();
			for (int j = 0; j < splite.length; j++) {
				stringBuffer.append(splite[j] + " ");
			}
			Hiragana = stringBuffer.toString();
			System.out.println(text + " is transformed into Hiragana as " + Hiragana);
		}
		return Hiragana;
	}

}
