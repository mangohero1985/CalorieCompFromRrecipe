/**
 * 
 */
package tools;

import net.moraleboost.mecab.Lattice;
import net.moraleboost.mecab.Node;
import net.moraleboost.mecab.impl.StandardTagger;

/**
 * @author ar-weichang.chen
 * @create-time 2015/03/12 11:11:51
 */
public class MecabMorph {
	public String GetHiragana(String kanji) {

		// Taggerを構築。
		// 引数には、MeCabのcreateTagger()関数に与える引数を与える。
		StandardTagger tagger = new StandardTagger("");

		// バージョン文字列を取得
		// System.out.println("MeCab version " + tagger.version());

		// Lattice（形態素解析に必要な実行時情報が格納されるオブジェクト）を構築
		Lattice lattice = tagger.createLattice();

		// 解析対象文字列をセット
		String text = kanji;
		lattice.setSentence(text);

		// tagger.parse()を呼び出して、文字列を形態素解析する。
		tagger.parse(lattice);

		// 形態素解析結果を出力
		// String[] split = lattice.toString().split(",");
		// String hiragana = split[split.length-2];

		// 一つずつ形態素をたどりながら、表層形と素性を出力
		Node node = lattice.bosNode();
		StringBuffer sb = new StringBuffer();
		while (node != null) {
			String surface = node.surface();
			String feature = node.feature();
			if (!feature.contains("BOS/EOS,*,*,*,*,*,")) {
				String[] split = feature.split(",");
				if(!split[split.length - 2].equals("*")){
					sb.append(split[split.length - 2]);
				}else{
					sb.append(surface);
				}
				
				
			}
			node = node.next();
		}

		// lattice, taggerを破壊
		lattice.destroy();
		tagger.destroy();

		String hiragana = sb.toString();
		return hiragana;

	}
}
