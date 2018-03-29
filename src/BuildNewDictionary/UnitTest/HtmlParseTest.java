/**
 * 
 */
package BuildNewDictionary.UnitTest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import BuildNewDictionary.Control.HtmlParse;

/**
 * @author ar-weichang.chen
 * @create-time     2015/03/02   16:42:02   
 */
public class HtmlParseTest {

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	private HtmlParse  htmlParse = new HtmlParse();
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link BuildNewDictionary.Control.HtmlParse#Parse(java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	public void testParse() throws IOException {
		htmlParse.Parse("D:\\Rakuten_calorie\\Crawler\\htmlFiles\\9801-0.html");
	}

}
