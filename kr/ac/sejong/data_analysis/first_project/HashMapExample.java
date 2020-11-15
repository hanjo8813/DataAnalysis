package kr.ac.sejong.data_analysis.first_project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
	public static void main(String[] args) throws IOException {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "C");
		map.put(5, "D");
		System.out.println(map);
		
		map.remove(5);
		System.out.println(map);
		
		String name = map.get(1);
		System.out.println(name);
		
		System.out.println(map.size());
		System.out.println(map.isEmpty());
		
		System.out.println(map.containsKey(1));
		System.out.println(map.containsKey(5));
		
		System.out.println(map.containsValue("C"));
		System.out.println(map.containsValue("D"));
		
		// 키셋으로 set 만든 후 이터레이터에 넣고 다 출력하기
		Set<Integer> set = map.keySet();
		Iterator<Integer> keyIter = set.iterator();
		while(keyIter.hasNext())
		{
			Integer key = keyIter.next();
			String value = map.get(key);
			System.out.println(key + " -> " + value);
		}
		System.out.println();
		
		// Entry를 이용한 Set 만든 후 이터레이터에 넣고 다 출력
		Set<Entry<Integer,String>> entrySet = map.entrySet();
		Iterator<Entry<Integer,String>> entryIter = entrySet.iterator();
		while(entryIter.hasNext())
		{
			Entry<Integer, String> entry = entryIter.next();
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		
	}

}
