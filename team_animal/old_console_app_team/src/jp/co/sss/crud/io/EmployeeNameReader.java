package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.regex.Pattern;

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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = br.readLine();
		
		if(!isValid(inputString)) {
			throw new IllegalArgumentException("1文字以上30文字以下の文字列を入力してください");
		}
		return inputString;
	}

	/**
	 * @param inputString コンソール入力された文字列
	 * @return 文字列が適正な値であった場合true、そうでない場合はfalseを返す
	 */
	public boolean isValid(String inputString) {
		/**
		 * 1文字以上30文字以下の判定
		 */
		if(inputString.length() >= 1 && 30 >= inputString.length()){
			Pattern pattern = Pattern.compile("\\s*");
			/**
			 * 空白かつnull判定
			 */
			if(pattern.matcher(inputString).matches() | Objects.isNull(inputString)){
				return true;
			}
		}
		return false;//文字列が1文字以上30文字以下かどうかを判定
	}

}
