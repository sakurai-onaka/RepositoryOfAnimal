package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 部署IDのコンソール入力をするクラス
 */
public class DeptIdReader {

	/**
	 * @return inputNumber コンソール入力された整数値を返す
	 * @throws IOException 不正な状態の場合にスローされる
	 * @throws IllegalArgumentException 不正な入力の場合にスローされる
	 */
	public Integer input() throws IOException, IllegalArgumentException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = br.readLine();
		
		if(isValid(inputString)) {
			return Integer.parseInt(inputString);
		}else {
			throw new IllegalArgumentException("1以上3以下の整数を入力してください");
		}
	}

	/**
	 * @param inputString コンソール入力された文字列
	 * @return 文字列が適正な値であった場合true、そうでない場合はfalseを返す
	 */
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-3１-３]{1}$");//1-3までの整数かどうかをチェック
	}

}
