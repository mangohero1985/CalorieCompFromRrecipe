/**
 * 
 */


import tools.KyteaMorph;

/**
 * @author ar-weichang.chen
 * @create-time     2015/01/05   10:26:56   
 */
public class TransIntoHira {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//使用kytea把标注ingredient
		String InputPath = "D:\\Rakuten_calorie\\BasicUnitofRakutenRecipe.txt";
		String OutputPath = "D:\\Rakuten_calorie\\RakutenIngredientMorph.txt";
		String tempPath = "D:\\Rakuten_calorie\\RakutenIngredientMorphTemp.txt";
		KyteaMorph kyteaMorph = new KyteaMorph();
		kyteaMorph.KyteaMorph(InputPath,tempPath, OutputPath);
	}

}
