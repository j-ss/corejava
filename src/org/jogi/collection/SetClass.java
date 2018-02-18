package org.jogi.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.*;
import java.util.TreeSet;

public class SetClass {

	public static void main(String[] args) {
		
		Set hashset=new HashSet();
		
		hashset.add("jogendra");
		hashset.add("pawan");
		hashset.add("dheerraj");
		System.out.println(hashset.add("jogendra"));
		hashset.add(1);
		hashset.add(5);
		hashset.add(new TempClass("hello"));
		System.out.println(hashset);
		
		Set linkedset=new LinkedHashSet();
		
		linkedset.add("jogendra");
		linkedset.add("pawan");
		linkedset.add("dheerraj");
		System.out.println(linkedset.add("jogendra"));
		linkedset.add(1);
		linkedset.add(5);
		linkedset.add(new TempClass("hello"));
		System.out.println(linkedset);
		
		Set treeset=new TreeSet();
		
		//treeset.add(null);
		treeset.add("jogendra");
		treeset.add("pawan");
		treeset.add("dheerraj");
		System.out.println(treeset.add("jogendra"));
		//treeset.add(1);
		//treeset.add(5);
		//treeset.add(new TempClass());
		System.out.println(treeset);
		
		
		
		TreeSet set=new TreeSet<>(new Comparator<Temp>()
		{
			public int compare(Temp obj1,Temp obj2)
			{
				return obj1.compare().compareTo(obj2.compare());
			}
		});
		
		set.add(new TempClass1("jogendra"));
		set.add(new TempClass("pawan"));
		set.add(new TempClass1("arvind"));
		set.add(new TempClass("alok"));
		set.add(new TempClass1("dheeraj"));
		
		set.forEach(action->System.out.println(((Temp)action).getName()));

	}

}
