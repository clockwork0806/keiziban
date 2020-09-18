package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Keigiban_bean;

public class Keigiban_dao {
	//①DBアクセスに必要な情報の定数を定義

	//接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
	private static final String url = "jdbc:mysql://localhost:3306/keigiban?serverTimezone=JST";
	//ユーザ
	private static final String user = "root";
	//パスワード
	private static final String pw = "Yuya0806";

	//INSERT文を実行するメソッドのサンプル
	//引数は登録したい情報が格納されたBean
	public static void insert(Keigiban_bean s){
		//②アクセスに必要な変数の初期化
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			//③JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			//④データベースと接続する(コネクションを取ってくる)
			//第1引数→接続先URL
			//第2引数→ユーザ名
			//第3引数→パスワード
			con = DriverManager.getConnection(url, user, pw);

			//⑤SQL文の元を作成する
			//?をプレースホルダと言います。
			//後の手順で?に値を設定します。
			String sql = "INSERT INTO keigiban(name, mail, content,time) VALUES(?,?,?,now())";

			//⑥SQLを実行するための準備(構文解析)
			pstmt = con.prepareStatement(sql);

			//⑦プレースホルダに値を設定
			//第1引数→何番目の?に設定するか(1から数える)
			//第2引数→?に設定する値
			//pstmt.setInt(1, s.getId());
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getMail());
			pstmt.setString(3, s.getContent());
			//pstmt.setString(4, s.getTime());



			//⑧SQLを実行し、DBから結果を受領する
			int result = pstmt.executeUpdate();
			System.out.println(result + "件登録されました。");

			//おまけ：⑥の準備が完了すれば?の値を更新して
			//続けてINSERTすることができる。
//			pstmt.setString(1, "takahashi");
//			pstmt.setInt(2, 20);
//			pstmt.executeUpdate();


		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑨DBとの切断処理
			try {
				//nullかチェックしないとNullPointerExceptionが
				//発生してしまうためチェックしている。
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
	//引数のIDに一致するレコードをemployeeテーブルから1件取得する。
	public static ArrayList<Keigiban_bean> selectAll(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "SELECT id,name,content,time FROM keigiban ;";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Keigiban_bean> list = new ArrayList<Keigiban_bean>();
			while( rs.next() ){
				//int Id = rs.getString("id");
				int Id = ((Integer)(rs.getInt("id"))).intValue();
				String Name = rs.getString("name");
				String Content = rs.getString("content");
				String time = rs.getString("time");

				Keigiban_bean result = new Keigiban_bean(Id,Name,Content,time);
				list.add(result);
			}

			return list;

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}
}
