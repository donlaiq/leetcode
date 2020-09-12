package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Approach2 {
	
	private static List<Node> leaves;
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) 
	{
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
		Node root = new Node(0, null);
		for(int i = 0; i < candidates.length; i++)
		{
			leaves = new ArrayList<Node>();
			findLeaves(root);
			for(int j = 0; j < leaves.size(); j++)
			{
				leaves.get(j).setLeft(new Node(0, leaves.get(j)));
				leaves.get(j).setRight(new Node(candidates[i], leaves.get(j)));
			}
		}
		
		leaves = new ArrayList<Node>();
		findLeaves(root);
		for(Node n: leaves)
		{
			List<Integer> l = getSum(n, target);
			if(l != null)
			{
				// It sorts the list to avoid repeated solutions like [7 1] and [1 7]
				Collections.sort(l);
				if(!solutions.contains(l))
					solutions.add(l);
			}	
		}
		
		return solutions;
	}
	
	/**
	 * Structure to represent the Node of a binary tree, having two pointers to its children (left and right) and one to its parent.
	 * It holds the number of an element of candidates or zero.
	 */
	private static class Node
	{
		private Node left;
		private Node right;
		private Node parent;
		private int value;
		
		public Node(int value, Node parent)
		{
			this.value = value;
			this.left = null;
			this.right = null;
			this.parent = parent;
		}
		
		public int getValue()
		{
			return this.value;
		}
		
		public void setLeft(Node n)
		{
			this.left = n;
		}
		
		public void setRight(Node n)
		{
			this.right = n;
		}
		
		public Node getParent()
		{
			return this.parent;
		}
		

	}
	
	/**
	 * Given the root of the tree, it looks for all its leaves and put them in a static list. 
	 * @param node
	 */
	public static void findLeaves(Node root) 
	{
	    if (root.left == null) 
	    {
	    	leaves.add(root);
	    	return;
	    }
	    else
	    {
	    	findLeaves(root.left);
	    	findLeaves(root.right);
	    }  

	}
	
	/**
	 * It sums all the elements from the leaf to the root.
	 * @param leaf: Leaf of the tree.
	 * @param target: Desired result of the sum.
	 * @return
	 */
	public static List<Integer> getSum(Node leaf, int target)
	{
		int sum = 0;
		List<Integer> solution = new ArrayList<Integer>();
		while(leaf != null)
		{
			sum += leaf.getValue();
			// It stops if the sum is bigger than the desired result.
			if(sum > target)
				return null;
			// A zero value is just padding, not a valid element of candidates.
			if(leaf.getValue() != 0)
				solution.add(leaf.getValue());
			leaf = leaf.getParent();
		}
		if(sum == target)
			return solution;
		return null;
	}

	public static void main(String[] args) {
		leaves = new ArrayList<Node>();
		
		List<List<Integer>> lists = combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
		//List<List<Integer>> lists = combinationSum2(new int[] {2, 5, 2, 1, 2}, 5);
		for(int i = 0; i < lists.size(); i++)
		{
			for(int j = 0; j < lists.get(i).size(); j++)
				System.out.print(lists.get(i).get(j) + " ");
			System.out.println();
		}
	}

}
