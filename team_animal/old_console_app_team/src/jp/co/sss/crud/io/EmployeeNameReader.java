package jp.co.sss.crud.io;

import java.io.IOException;

/**
 * 社員名のコンソール入力をするクラス
 */
public class EmployeeNameReader {

	/**
	 * @return inputString コンソール入力された社員名を返す
	 * @throws IOException 不正な状態の場合にスローされる
	 * @throws IllegalArgumentException 不正な入力の場合にスローされる
	 */

	public String input() throws IOException, IllegalArgumentException {
		return "";
	}

	/**
	 * @param inputString コンソール入力された文字列
	 * @return 文字列が適正な値であった場合true、そうでない場合はfalseを返す
	 */
	public boolean isValid(String inputString) {
		return false;//文字列が1文字以上30文字以下かどうかを判定
	}

}
