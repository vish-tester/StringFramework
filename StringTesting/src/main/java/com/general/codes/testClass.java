package com.general.codes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testClass {

	public static void main(String[] args) {
		
		int arr[] = {0, -1, 2, -3, 1};
		int sum = -2;
		int secondPart = 0;
		List<Integer> firstNum = new ArrayList<>();
		List<Integer> secondNum = new ArrayList<>() ;
		List<Integer> thirdNum = new ArrayList<>();
		
		//int firsPart  = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i< arr.length; i++)
		{
			int firsPart = sum - arr[i];
			for (int j = 0; j< arr.length ; j++)
			{
				 secondPart = firsPart - arr[i];
				
				if(map.containsKey(secondPart))
				{
					firstNum.add(arr[j]);
				}
				
				else {
				map.put(arr[i], i);
				}
				
				
			}
			if(map.containsKey(firsPart-secondPart))
			{
				secondNum.add(arr[i]);
				thirdNum.add(i); 
			}
			
			
		}
		
		List<List<Integer>> fList = new ArrayList<>();
		fList.add(firstNum);
		fList.add(secondNum);
		fList.add(thirdNum);
		
		
		
		System.out.println(fList);

	}
	
	
	
		
		
		
	

}
