/**
 * 
 */
package Parser;

import java.io.BufferedReader;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Iohandle.IOhandle;

/**
 * @author ar-weichang.chen
 * @create-time     2015/01/06   15:03:33   
 */
public class JsonReaderIntoObj {
	
	private  StringBuffer jsonBuffer = new StringBuffer();

	public  JSONObject reader(String InputPath) {

		JSONObject jsonObj;
		IOhandle iOhandle = new IOhandle();
		String ReadLine = "";
		BufferedReader br;
		try {

			br = iOhandle.FileReader(InputPath);
			while ((ReadLine = br.readLine()) != null) {

				jsonBuffer.append(ReadLine);
			}

		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jsonObj = JSONObject.fromObject(jsonBuffer.toString());
		//System.out.println(jsonObj);
			
		return jsonObj;
	}

}
