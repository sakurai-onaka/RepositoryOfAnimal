package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 社員の生年月日をコンソール入力をするクラス
 */
public class EmployeeBirthdayReader {

	/**
	 * @return inputString コンソール入力された生年月日を返す
	 * @throws IOException 不正な状態の場合にスローされる
	 * @throws IllegalArgumentException 不正な入力の場合にスローされる
	 */
	public String input() throws IOException, IllegalArgumentException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = br.readLine();
		
		if(inputString == null || inputString.isBlank()) {
			return null;
		}
		
		if(isValid(inputString)) {
			return inputString;
		}else {
			throw new IllegalArgumentException("正しい形式(西暦年/月/日)で日付を入力してください");
		}
	}

	/**
	 * @param inputString コンソール入力された文字列
	 * @return 文字列が適正な値であった場合true、そうでない場合はfalseを返す
	 */
	public boolean isValid(String inputString){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);
		try {
			sdf.parse(inputString);
			return true;
		}catch(ParseException e) {	
			return false;//適正な日付であるかどうかをチェック
		}
	}

}
