package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * メニュー番号のコンソール入力をするクラス
 */
public class MenuNoReader {

	/**
	 * メニュー番号のコンソール入力を行う
	 * 
	 * @return inputNumber コンソール入力された整数値を返す
	 * @throws IOException 不正な状態の場合にスローされる
	 * @throws IllegalArgumentException 不正な入力の場合にスローされる
	 */
	public Integer input() throws IOException, IllegalArgumentException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer inputNumber = 0;
		//		br.close();//IOExceptionを発生させたい場合はコメントを外す
		String inputString = br.readLine();

		//入力値が適正な値か判定する
		if (isValid(inputString)) {
			inputNumber = Integer.parseInt(inputString);
		} else {
			//入力値が不正な場合は例外(IllegalArgumentException)を送出する
			throw new IllegalArgumentException("1以上7以下の整数を入力してください");
		}
		return inputNumber;
	}

	/**
	 * 入力値が適正かどうかを判定する
	 * 
	 * @param inputString コンソール入力された文字列
	 * @return 文字列が適正な値であった場合true、そうでない場合はfalseを返す
	 */
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-7１-７]{1}$");//1-7までの整数
	}

}
