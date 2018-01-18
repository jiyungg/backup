package conf;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;

public class Exam {
//	static {
//		System.out.println("내가 스테이틱 영역이다!");
//단 한번만 시작된다. static은.
//	}
	public void init() {
		InputStream in = this.getClass().getResourceAsStream("/conf/dbconf.properties");
		Properties prop = new Properties();	
		try {
			prop.load(in);
			Iterator<Object> it = prop.keySet().iterator();
			Class.forName(prop.getProperty("driver"));
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String pwd = prop.getProperty("pwd");
			Connection con = DriverManager.getConnection(url,id,pwd);
			String sql = "select * from customer";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("customerName"));
			}
			System.out.println("연결 성공");
//			while(it.hasNext()) {
//				String key = (String) it.next();
//				//이 윗줄 = 캐스팅하는거.
//				System.out.println(key + "=" + prop.getProperty(key));
//			}
		} catch (IOException e) {
			e.printStackTrace();
	    }catch (ClassNotFoundException e) {
	    	e.printStackTrace();
     	}catch (SQLException e) {
		    e.printStackTrace();
	}
}
//outStream : 쓸 때 사용. out.
//input = 키보드, output = 모니터.
//list, map, set. 집합 이라는 의미. 
	
	public static void main(String[] args) {
//		System.out.println("난 메인 영역이다!! 프로그램의 시작점이지!");
		Exam e = new Exam();
		e.init();
		
//같은 키에 다른 밸류를 넣으면, b가 나온다. 그래서 KeySet인것.
		
		//put을 하려면 key값과 value값이 필요하다.
		//밸류값은 자동으로 빈 문자열에 들어간다.
		//iterator = 리스트. 
		//아이터레이터 함수(iterator())의 리턴타입은 Iterator<Object>이다.
		//resultset이랑 비슷한데 다르다. hasNext라는것을 가지고 있는게 그것인데, ...
		//프로펄티즈에서 가지고있는 키값만큼 while문이 돌아갑니다.
		//
	}

}
