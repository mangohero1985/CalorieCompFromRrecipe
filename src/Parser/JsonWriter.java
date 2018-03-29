/**
 * 
 */
package Parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import net.sf.json.util.JSONBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author ar-weichang.chen
 * @param <E>
 * @create-time 2014/12/29 9:49:44
 */
public class JsonWriter {

	public void Write(Object jsonArr, String FilePath) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String GsonString;
		File file = new File(FilePath);
		FileWriter fw = new FileWriter(file);
	    GsonString =gson.toJson(jsonArr);
	    fw.write(GsonString);
	    fw.close();

	}

}
