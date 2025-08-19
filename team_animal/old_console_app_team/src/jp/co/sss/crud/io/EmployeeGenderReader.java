package jp.co.sss.crud.io;

import java.io.IOException;

/**
 * 性別のコンソール入力をするクラス
 */
public class EmployeeGenderReader {

	/**
	 * @return inputNumber コンソール入力された整数値を返す
	 * @throws IOException 不正な状態の場合にスローされる
	 * @throws IllegalArgumentException 不正な入力の場合にスローされる
	 */
	public Integer input() throws IOException, IllegalArgumentException {
		return null;
	}

	/**
	 * @param inputString コンソール入力された文字列
	 * @return 文字列が適正な値であった場合true、そうでない場合はfalseを返す
	 */
	public boolean isValid(String inputString) {
		return false;//0,1,2,9の整数かどうかを判定
	}

}
