package jp.co.sss.crud.io;

import java.io.IOException;

/**
 * 社員の生年月日をコンソール入力をするクラス
 */
public class EmployeeBirthdayReader {

	/**
	 * @return inputString コンソール入力された生年月日を返す
	 * @throws IOException 不正な状態の場合にスローされる
	 * @throws IllegalArgumentException 不正な入力の場合にスローされる
	 */
	public String input() throws IOException, IllegalArgumentException {
		return null;
	}

	/**
	 * @param inputString コンソール入力された文字列
	 * @return 文字列が適正な値であった場合true、そうでない場合はfalseを返す
	 */
	public boolean isValid(String inputString) {

		return false;//適正な日付であるかどうかをチェック
	}

}
