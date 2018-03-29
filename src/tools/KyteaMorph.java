/**
 * 
 */
package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import com.ibm.icu.text.UnicodeSet.SpanCondition;

import net.java.sen.dictionary.Reading;
import javaBean.Kytea;
import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/05 10:12:32
 */
public class KyteaMorph {

	Kytea kytea = new Kytea();
	private String ReadLine = "";
	public void KyteaMorph(String InputPath, String TempPath, String OutputPath) {

		IOhandle iOhandle = new IOhandle();
		
		

		// 使用kytea标注ingredient
		ExecuteFromTerminal.execute("kytea" + " " + "-model" + " " + kytea.getKyteaPath() + kytea.getAnotatingKbm() + " " + "<" + InputPath + ">" + TempPath);

		// 自定义输出format 词单元 + 词性单元 + hiragana单元 （之间用空格分隔）

		try {
			BufferedReader br = iOhandle.FileReader(TempPath);
			BufferedWriter bw = iOhandle.FileWriter(OutputPath);
			while ((ReadLine = br.readLine()) != null) {

				if (!ReadLine.contains("/補助記号/補助記号-一般+/UNK")) {
					StringBuffer name = new StringBuffer();
					StringBuffer pos = new StringBuffer();
					StringBuffer hiragana = new StringBuffer();
					if (ReadLine.contains(" ") ) {
						String[] splite = ReadLine.split(" ");
						for (int i = 0; i < splite.length; i++) {
							if (splite[i].contains("/")) {
								String[] SpliteUnite = splite[i].split("/");
								name.append(SpliteUnite[0] + "+");
								pos.append(SpliteUnite[1] + "+");
								hiragana.append(SpliteUnite[3] + "+");
							}

						}
						bw.write(name.toString().subSequence(0, name.toString().length() - 1).toString() + " "
								+ pos.toString().subSequence(0, pos.toString().length() - 1).toString() + " "
								+ hiragana.toString().subSequence(0, hiragana.toString().length() - 1).toString());
						bw.newLine();
						bw.flush();
					}
					else {

						continue;

					}
				}
			}

		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("morphor过程中出错");
		}

	}
	public String GetHiragana(String InputText){
		
		String OutputText = "";
		String TempPathWrite ="D:\\Rakuten_calorie\\tempPath\\TempWrite.txt";
		String TempPathRead ="D:\\Rakuten_calorie\\tempPath\\TempRead.txt";
		
		IOhandle iOhandle = new IOhandle();
		try {
			BufferedWriter bw = iOhandle.FileWriter(TempPathWrite);
			bw.write(InputText);
			bw.newLine();
			bw.flush();
			
			// 使用kytea标注ingredient
			ExecuteFromTerminal.execute("kytea" + " " + "<" + TempPathWrite + ">" + " "+TempPathRead);
			BufferedReader br = iOhandle.FileReader(TempPathRead);
			while ((ReadLine = br.readLine()) != null) {

				if (!ReadLine.contains("/補助記号/補助記号-一般+/UNK")) {
					StringBuffer name = new StringBuffer();
					StringBuffer pos = new StringBuffer();
					StringBuffer hiragana = new StringBuffer();
					if (ReadLine.contains(" ") ||ReadLine.matches("^[\\u30A0-\\u30FF\\u3040-\\u309F\\p{InCjkUnifiedIdeographs}{2}]+$")) {
						if(ReadLine.contains(" ")){
							String[] splite = ReadLine.split(" ");
							for (int i = 0; i < splite.length; i++) {
								if (splite[i].contains("/")) {
									String[] SpliteUnite = splite[i].split("/");
									name.append(SpliteUnite[0] + "+");
									pos.append(SpliteUnite[1] + "+");
									hiragana.append(SpliteUnite[2] + "+");
								}

							}
						OutputText = hiragana.toString().subSequence(0, hiragana.toString().length()-1).toString();
							
						}else{
							OutputText=ReadLine;
						}
						
						
					}
					else {

						continue;

					}
				}
			}

		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return OutputText;
		
	}
	
public String GetPOS(String InputText){
		
		String OutputText = "";
		String TempPathWrite ="D:\\Rakuten_calorie\\tempPath\\TempWrite.txt";
		String TempPathRead ="D:\\Rakuten_calorie\\tempPath\\TempRead.txt";
		
		IOhandle iOhandle = new IOhandle();
		try {
			BufferedWriter bw = iOhandle.FileWriter(TempPathWrite);
			bw.write(InputText);
			
			// 使用kytea标注ingredient
			ExecuteFromTerminal.execute("kytea" + " " + "-model" + " " + kytea.getKyteaPath() + kytea.getAnotatingKbm() + " " + "<" + TempPathWrite + ">" + TempPathRead);
			BufferedReader br = iOhandle.FileReader(TempPathRead);
			while ((ReadLine = br.readLine()) != null) {

				if (!ReadLine.contains("/補助記号/補助記号-一般+/UNK")) {
					StringBuffer name = new StringBuffer();
					StringBuffer pos = new StringBuffer();
					StringBuffer hiragana = new StringBuffer();
					if (ReadLine.contains(" ") ) {
						String[] splite = ReadLine.split(" ");
						for (int i = 0; i < splite.length; i++) {
							if (splite[i].contains("/")) {
								String[] SpliteUnite = splite[i].split("/");
								name.append(SpliteUnite[0] + "+");
								pos.append(SpliteUnite[1] + "+");
								hiragana.append(SpliteUnite[3] + "+");
							}

						}
					OutputText = pos.toString().subSequence(0, pos.toString().length() - 1).toString();
					}
					else {

						continue;

					}
				}
			}

		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return OutputText;
		
	}

}
