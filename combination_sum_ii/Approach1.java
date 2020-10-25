package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Approach1 {
	
	// List having all the 2^n possible combinations to add the elements of 'candidates'
	private static List<String> combinations;
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) 
	{
		List<List<Integer>> returnList = new ArrayList<List<Integer>>();
		getBinaryCombinations(candidates.length, "");
		for(int i = 0; i < combinations.size(); i++)
		{
			int sum = 0;
			List<Integer> list = new ArrayList<Integer>();
			for(int j = 0; j < combinations.get(i).length(); j++)
			{
				if(combinations.get(i).substring(j, j+1).equals("1"))
				{
					sum += candidates[j];
					list.add(candidates[j]);
				}
			}
			
			// It sorts the list to avoid repeated solutions like [7 1] and [1 7]
			Collections.sort(list);
			if(sum == target && !returnList.contains(list))
				returnList.add(list);
		}
		return returnList;
	}
	
	/**
	 * It fills the static list 'combinations' with Strings having '0's and '1's.
	 * The ith element in the list 'combinations' represents and order to allow or 
	 * not the sum of the ith element of the 'candidates' array.
	 * @param n: Length of the 'candidates' array.
	 * @param l: It starts with an empty String. It will be filled with '0' and '1' and every solution will be of length n. 
	 */
	static void getBinaryCombinations(int n, String l) 
	{ 
		if (n == l.length())  
		{
			combinations.add(l);
			return;
		}
		{
			getBinaryCombinations(n, l + "0"); 
			getBinaryCombinations(n, l + "1"); 
		}
	
	} 

	
	public static void main(String[] args) 
	{
		combinations = new ArrayList<String>();
		List<List<Integer>> lists = combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
		//List<List<Integer>> lists = combinationSum2(new int[] {2, 5, 2, 1}, 5);
		for(int i = 0; i < lists.size(); i++)
		{
			for(int j = 0; j < lists.get(i).size(); j++)
				System.out.print(lists.get(i).get(j) + " ");
			System.out.println();
		}
	}
}
