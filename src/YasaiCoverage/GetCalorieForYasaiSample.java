/**
 * 
 */
package YasaiCoverage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time 2015/04/08 10:52:53
 */
public class GetCalorieForYasaiSample {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 为sample中的单元查找所有可以匹配的结果，结果中最长的作为最优选择
		IOhandle iOhandle = new IOhandle();
		String InputPathSample = "D:\\Rakuten_calorie\\YasaiSampleMecabTrans.txt";
		String InputPathCoverage = "D:\\Rakuten_calorie\\CalorieModified\\YasaiCoverageMecabHiragana.txt";
		String outputPath = "D:\\Rakuten_calorie\\CalorieModified\\SampleCalorie.txt";
		BufferedReader brSample = iOhandle.FileReader(InputPathSample);
		BufferedReader brCoverage = iOhandle.FileReader(InputPathCoverage);
		BufferedWriter bw = iOhandle.FileWriter(outputPath);
		String readLine = "";
		// 将coverage文件读取到字典中
		Map<String, String> dicMap = new HashMap<String, String>();
		while ((readLine = brCoverage.readLine()) != null) {
			String[] split = readLine.split("\\+");
			dicMap.put(split[1], split[2]);
		}
		// 将sample文件按行读取到arraylist中
		
		while ((readLine = brSample.readLine()) != null) {
			ArrayList<String> arrayListCalorie = new ArrayList<String>();
			ArrayList<String> arrayListIngre = new ArrayList<String>();
			String[] split = readLine.split("&&&&&&\\[");
			String hiraganaTuple = split[1].substring(0, split[1].length() - 1);
			String[] hiraganaUnit = hiraganaTuple.split(",");
			for (int i = 0; i < hiraganaUnit.length; i++) {
				arrayListIngre.add(hiraganaUnit[i]);
			}
			// 第一层循环读取每一个recipe中的每一个成分
			for (int j = 0; j < arrayListIngre.size(); j++) {
				// 创建一个临时arraylist存储ingredien对应多卡路里的情况
				ArrayList<String> arrayListTemp = new ArrayList<String>();
				// 第二层循环读取字典中的每一个ingredient
				Iterator it = dicMap.keySet().iterator();
				int flag=0;
				while (it.hasNext()) {

					String key = (String) it.next();
					// 如果能够正好完全匹配就给ingridient获取卡入里值
					
					if (arrayListIngre.get(j).equals(key)) {
						arrayListTemp.clear();
						arrayListCalorie.add("{"+dicMap.get(key)+"}");
						flag++;
						break;
					}
					else if (arrayListIngre.get(j).contains(key)) {
						flag++;
						arrayListTemp.add(key);
					}
					
				}
				if(flag==0) {
					arrayListCalorie.add("{"+"no value"+"}");
				}
				if (!arrayListTemp.isEmpty()) {
					int length = 0;
					int index = 0;
					for (int k = 0; k < arrayListTemp.size(); k++) {
						if (arrayListTemp.get(k).toString().length() > length) {
							length = arrayListTemp.get(k).toString().length();
							index = k;
						}
					}
					arrayListCalorie.add("{"+dicMap.get(arrayListTemp.get(index))+"}");

				}
				

			}
			bw.write(readLine.substring(11, readLine.indexOf("]")+1)+"======="+arrayListCalorie.toString());
			bw.newLine();
			bw.flush();
		}
	}
}
