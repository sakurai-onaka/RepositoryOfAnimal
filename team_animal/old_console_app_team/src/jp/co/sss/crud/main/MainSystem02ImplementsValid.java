package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;

/**
 * 社員管理システム実行用クラス
 */
public class MainSystem02ImplementsValid {

	/**
	 * メイン処理02
	 * 
	 * <p>各入力チェック機能から更新対象項目の任意選択までを実装し、このクラスで呼び出す。
	 * 
	 * <p>入力項目ごとのクラスを実装しコンソールから必要な項目を入力する。
	 * 不正な入力値の場合は例外処理し、メニュー番号の入力から再度行う。
	 * 
	 * <p>例外処理は以下の2つのcatchブロックに分ける
	 * <p>(IOException | ClassNotFoundException | SQLException e)
	 * 	"システムエラーが発生しました"と出力し、スタックトレースを出力する。
	 * 	その後、ループを抜けてシステムを終了する。
	 * 
	 * <p>(IllegalArgumentException e)
	 * ブロック内でエラーメッセージを出力する。
	 * {@code System.out.println(e.getMessage());}
	 * その後、continueしてループに戻る。
	 * 
	 *
	 */
	public static void main(String[] args) {

		//エンティティ
		Employee employee = new Employee();
		Department department = new Department();

		//データベースアクセス
		EmployeeDAO employeeDAO = new EmployeeDAO();

		int menuNo = 0;
		do {
			// メニューの表示
			System.out.println("=== 社員管理システム ===");
			System.out.println("1. 全件表示");
			System.out.println("2. 社員名検索");
			System.out.println("3. 部署ID検索");
			System.out.println("4. 登録");
			System.out.println("5. 更新");
			System.out.println("6. 削除");
			System.out.println("7. 終了");
			System.out.print("メニュー番号を入力してください:");

			try {

				//TODO メニュー番号の入力

				// 機能の呼出
				switch (menuNo) {

				case 1: //全件検索
					/*全件検索処理はMainSystem01NonValidと同一である。*/

					System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名");

					break;

				case 2://社員名検索
						//TODO 以下に実装する
					System.out.print("社員名を入力してください:");

					break;

				case 3://部署ID検索
						//TODO 以下に実装する
					System.out.print("部署ID(1：営業部、2：経理部、3：総務部)を入力してください: ");

					break;

				case 4:// 登録機能
						//TODO 以下に実装する

					System.out.print("社員名:");
					System.out.print("性別(0:回答しない, 1:男性, 2:女性, 9:その他):");
					System.out.print("生年月日(西暦年/月/日):");
					System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");

					break;

				case 5:// 更新機能
						//TODO 以下に実装する

					System.out.print("更新する社員の社員IDを入力してください:");
					System.out.print("社員名:");
					System.out.print("性別(0:回答しない, 1:男性, 2:女性, 9:その他):");
					System.out.print("生年月日(西暦年/月/日):");
					System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");

					break;

				case 6://削除機能
						//TODO 以下に実装する

					System.out.print("削除する社員の社員IDを入力してください:");

					break;
				}

			} catch (IOException | ClassNotFoundException | SQLException e) {//case 1 全件検索を実装するとコンパイルエラーは解消する
				//TODO 以下に実装する

			} catch (IllegalArgumentException e) {
				//TODO 以下に実装する

			}
		} while (menuNo != 7);
		System.out.println("システムを終了します。");
	}

}
