/**
 * 
 */
package Parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author ar-weichang.chen
 * @create-time 2015/03/02 16:25:54
 */
public class GeneralHtmlParser {

	public org.jsoup.nodes.Document Doc;
	public File inPut;

	public void SetPath(String Path) {

		inPut = new File(Path);
	}

	public org.jsoup.nodes.Document Parser() throws IOException {

		Doc = Jsoup.parse(inPut, "UTF-8", "http://");

		return Doc;

	}

}
