package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Approach3 {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) 
	{
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		
		Set<Node> leaves = new HashSet<Node>();
		
		for(int i = 0; i < candidates.length && candidates[i] <= target; i++)
		{
			Set<Node> newLeaves = new HashSet<Node>();
			for(Node node: leaves)
			{
				Node n = new Node(candidates[i], node.getValue(), node.getPath());
				if(node.getValue() + candidates[i] < target)
				{
					newLeaves.add(n);
					newLeaves.add(node);
				}
				else if(node.getValue() + candidates[i] == target && !solutions.contains(n.getPath()))
					solutions.add(n.getPath()); // it adds a solution to the final list
			}
			
			Node n = new Node(candidates[i], 0, new ArrayList<Integer>());
			if(candidates[i] < target) 
				newLeaves.add(n); // it adds the value of candidates[i] without modification 
			else if(candidates[i] == target && !solutions.contains(Arrays.asList(candidates[i])))
				solutions.add(Arrays.asList(candidates[i])); // it adds a solution to the final list
			
			leaves.addAll(newLeaves); // it will ignore the repetitons
		}
		return solutions;
    }
	
	
	private static class Node
	{
		private List<Integer> path;
		private int value; 
		
		/**
		 * This node will hold the value of a node from the previous time plus the value of the next element in the candidates array.
		 * It will also copy the path from this node and it will add the element from candidates to the path. 
		 * @param candidateValue: element of the array candidates
		 * @param nodeValue: value from another node.
		 * @param p: path from another node.
		 */
		public Node(int candidateValue, int nodeValue, List<Integer> p)
		{
			this.path = new ArrayList<Integer>();
			this.path.addAll(p);
			this.path.add(candidateValue);
			this.value = candidateValue + nodeValue;
		}
		
		public List<Integer> getPath()
		{
			return this.path;
		}
		
		public int getValue()
		{
			return this.value;
		}
		
		
		/**
		 * Overrides these two methods to avoid duplicates in the Node set.
		 */

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((path == null) ? 0 : path.hashCode());
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (path == null) {
				if (other.path != null)
					return false;
			} else if (!path.equals(other.path))
				return false;
			if (value != other.value)
				return false;
			return true;
		}
	}
	
		
	public static void main(String[] args) 
	{

		//List<List<Integer>> lists = combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
		List<List<Integer>> lists = combinationSum2(new int[] {2, 5, 2, 1, 2}, 5);
		//List<List<Integer>> lists = combinationSum2(new int[] {1, 10, 57, 136, 399, 1000}, 122000);
		for(int i = 0; i < lists.size(); i++)
		{
			for(int j = 0; j < lists.get(i).size(); j++)
				System.out.print(lists.get(i).get(j) + " ");
			System.out.println();
		}
	}

}
