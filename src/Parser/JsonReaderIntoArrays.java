/**
 * 
 */
package Parser;

import java.io.BufferedReader;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Iohandle.IOhandle;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author ar-weichang.chen
 * @create-time 2015/01/06 11:05:55
 */
public  class JsonReaderIntoArrays {

	private  StringBuffer jsonBuffer = new StringBuffer();

	public  JSONArray reader(String InputPath) {

		JSONArray jsonArray;
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

		jsonArray = JSONArray.fromObject(jsonBuffer.toString());
		//System.out.println(jsonArray);
			
		return jsonArray;
	}
}
