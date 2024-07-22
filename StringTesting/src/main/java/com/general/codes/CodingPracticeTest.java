package com.general.codes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import testNGBasePack.BaseClass;

public class CodingPracticeTest extends BaseClass {

	@Test
	public void StreamPracticeTest() {
		
		String str = "India is my country" ;

		String a =  str.replaceAll(" ","").toLowerCase();
		char[] arr = a.toCharArray();
			
	Map<Character, Integer> map = new HashMap<>();
	
		for(int i =0; i< arr.length; i++)
		{
			if(map.containsKey(arr[i]))
			{
				map.put(arr[i], map.get(arr[i])+1);
			}
			
			else
			{
				map.put(arr[i], 1);
			}
		}
		
		
		
		Collection<Integer> values =  map.values();
		
		int max = Collections.max(values);
		
		for(Map.Entry<Character, Integer> e : map.entrySet())
		{
			if(e.getValue()== max)
			{
				System.out.println("max occurence char is: "+e.getKey()+" whose occurance count is: "+max);
			}
		}
		
		
	}
	
	
	
}
