package conf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapExam {
	
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("key1", "value1");
		Iterator<String> it = map.keySet().iterator();
		System.out.println(it.hasNext());
		System.out.println(it.hasNext());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		//map은 인터페이스이다.
		//(map을 hashmap이)구현했을 때, 상속받을 때.
		//hasNext -> 있냐고 물어보기만 하는 것이다. => true / false로 결과값이 나오게 된다.
		
	}

}
