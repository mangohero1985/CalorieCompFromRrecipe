/**
 * 
 */
package javaBean;

/**
 * @author ar-weichang.chen
 * @create-time 2014/12/02 16:09:03
 */
public class Kytea {

	private String KyteaPath = "D:/DownloadApplication/development_tools/kytea/";
	private String RecipeSamplePath = "D:/DownloadApplication/development_tools/kytea/RecipeNE-sample/";
	private String RecipeSampleBinPath = "D:/DownloadApplication/development_tools/kytea/RecipeNE-sample/bin/";
	private String RawText = "sample_proc.txt";
	private String Tweets = "twitter.txt";
	private String NormarlizePython = "normalizer_sample.py";
	private String Trimming = "jisx0208utf8.txt";
	private String step1 = "step1.txt";
	private String AnotatingKbm = "2014-10-23_model.kbm";
	private String Step2 = "step2.txt";
	private String PreparationPython = "preparation_for_ner_sample.py";
	private String Step4 = "step4.txt";
	private String RecipeKnm = "recipe416.knm";
	private String TempCiob = "temp.Ciob2";
	private String NeSearchPerl = "NESearch.pl";
	private String Step5 = "step5.txt";
	private String DishName ="dishNames.txt";
	private String DishNameSorted ="DishNameSorted.txt";
	private String DishNameSortedWONum ="DishNameSortedWONum.txt";
	//Rakuten Recipe
	private String RakutenPath ="D:\\DownloadApplication\\development_tools\\kytea\\NaiveBayesClassification\\";
	private String RakutenIngredientCombined ="IngredientCombined.txt";
	private String RakutenIngridients ="Ingredient.txt";
	private String RakutenIngridientsWONoise ="RecipteWithoutNoise.txt";
	/**
	 * @return the rakutenIngredientCombined
	 */
	public String getRakutenIngredientCombined() {
		return RakutenIngredientCombined;
	}

	/**
	 * @param rakutenIngredientCombined the rakutenIngredientCombined to set
	 */
	public void setRakutenIngredientCombined(String rakutenIngredientCombined) {
		RakutenIngredientCombined = rakutenIngredientCombined;
	}

	/**
	 * @return the rakutenPath
	 */
	public String getRakutenPath() {
		return RakutenPath;
	}

	/**
	 * @param rakutenPath the rakutenPath to set
	 */
	public void setRakutenPath(String rakutenPath) {
		RakutenPath = rakutenPath;
	}

	/**
	 * @return the rakutenIngridients
	 */
	public String getRakutenIngridients() {
		return RakutenIngridients;
	}

	/**
	 * @param rakutenIngridients the rakutenIngridients to set
	 */
	public void setRakutenIngridients(String rakutenIngridients) {
		RakutenIngridients = rakutenIngridients;
	}

	/**
	 * @return the rakutenIngridientsWONoise
	 */
	public String getRakutenIngridientsWONoise() {
		return RakutenIngridientsWONoise;
	}

	/**
	 * @param rakutenIngridientsWONoise the rakutenIngridientsWONoise to set
	 */
	public void setRakutenIngridientsWONoise(String rakutenIngridientsWONoise) {
		RakutenIngridientsWONoise = rakutenIngridientsWONoise;
	}

	
	/**
	 * @return the dishNameSortedWONum
	 */
	public String getDishNameSortedWONum() {
		return DishNameSortedWONum;
	}

	/**
	 * @param dishNameSortedWONum the dishNameSortedWONum to set
	 */
	public void setDishNameSortedWONum(String dishNameSortedWONum) {
		DishNameSortedWONum = dishNameSortedWONum;
	}

	/**
	 * @return the dishNameSorted
	 */
	public String getDishNameSorted() {
		return DishNameSorted;
	}

	/**
	 * @param dishNameSorted the dishNameSorted to set
	 */
	public void setDishNameSorted(String dishNameSorted) {
		DishNameSorted = dishNameSorted;
	}

	/**
	 * @return the dishName
	 */
	public String getDishName() {
		return DishName;
	}

	/**
	 * @param dishName the dishName to set
	 */
	public void setDishName(String dishName) {
		DishName = dishName;
	}

	/**
	 * @return the tweets
	 */
	public String getTweets() {
		return Tweets;
	}

	/**
	 * @param tweets the tweets to set
	 */
	public void setTweets(String tweets) {
		Tweets = tweets;
	}

	

	public String getKyteaPath() {
		return KyteaPath;
	}

	public void setKyteaPath(String kyteaPath) {
		KyteaPath = kyteaPath;
	}

	public String getRecipeSamplePath() {
		return RecipeSamplePath;
	}

	public void setRecipeSamplePath(String recipeSamplePath) {
		RecipeSamplePath = recipeSamplePath;
	}

	public String getRecipeSampleBinPath() {
		return RecipeSampleBinPath;
	}

	public void setRecipeSampleBinPath(String recipeSampleBinPath) {
		RecipeSampleBinPath = recipeSampleBinPath;
	}

	public String getRawText() {
		return RawText;
	}

	public void setRawText(String rawText) {
		RawText = rawText;
	}

	public String getNormarlizePython() {
		return NormarlizePython;
	}

	public void setNormarlizePython(String normarlizePython) {
		NormarlizePython = normarlizePython;
	}

	public String getTrimming() {
		return Trimming;
	}

	public void setTrimming(String trimming) {
		Trimming = trimming;
	}

	public String getStep1() {
		return step1;
	}

	public void setStep1(String step1) {
		this.step1 = step1;
	}

	public String getAnotatingKbm() {
		return AnotatingKbm;
	}

	public void setAnotatingKbm(String anotatingKbm) {
		AnotatingKbm = anotatingKbm;
	}

	public String getStep2() {
		return Step2;
	}

	public void setStep2(String step2) {
		Step2 = step2;
	}

	public String getPreparationPython() {
		return PreparationPython;
	}

	public void setPreparationPython(String preparationPython) {
		PreparationPython = preparationPython;
	}

	public String getStep4() {
		return Step4;
	}

	public void setStep4(String step4) {
		Step4 = step4;
	}

	public String getRecipeKnm() {
		return RecipeKnm;
	}

	public void setRecipeKnm(String recipeKnm) {
		RecipeKnm = recipeKnm;
	}

	public String getTempCiob() {
		return TempCiob;
	}

	public void setTempCiob(String tempCiob) {
		TempCiob = tempCiob;
	}

	public String getNeSearchPerl() {
		return NeSearchPerl;
	}

	public void setNeSearchPerl(String neSearchPerl) {
		NeSearchPerl = neSearchPerl;
	}

	public String getStep5() {
		return Step5;
	}

	public void setStep5(String step5) {
		Step5 = step5;
	}

	public Kytea() {

	}

}
