package org.jogi.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapClass {

	public static void main(String[] args)
	{
		Map hashmap=new HashMap();
		Map linkedmap=new LinkedHashMap();
		SortedMap treemap=new TreeMap(/*new Comparator<String>()
				{
			public int compare(String obj1,String obj2)
			{
				return obj1.compareTo(obj2);
			}
				}*/);
		
		treemap.put(1, "jogendra");
		treemap.put(2, "pawan");
		treemap.put(3, "dheeraj");
		treemap.put(4, "alok");
		treemap.put(5, "arvind");
		
		System.out.println(treemap);
		
		//count character in string
		
		String str="jogender singh shekhawat";
		int i=0;
		int length=str.length();
		
		while(i<length)
		{
			char key=str.charAt(i);
			
			boolean boo=hashmap.containsKey(key);
			if(!boo)
			{
				hashmap.put(str.charAt(i),1);
			}
			if(boo)
			{
				int value=(int)hashmap.get(key);
				value++;
				hashmap.put(str.charAt(i),value);
			}
			i++;
		}
		
		System.out.println(hashmap);
		
	}
}
