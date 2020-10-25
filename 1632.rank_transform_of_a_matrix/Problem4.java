package contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem4 {
	
	/**
	 *	Structure containing the value of an element and its coordinates.
	 */
	static class Element implements Comparable<Element>{
		int row;
		int col;
		int value;
		
		Element(int row, int col, int value)
		{
			this.row = row;
			this.col = col;
			this.value = value;
		}

		// Override the method to sort the list of elements by 'value'
		@Override
		public int compareTo(Element e) {
			if(value < e.value)
				return -1;
			else if(value > e.value)
				return 1;
			return 0;
		}
	}
	
	/**
	 * 	Given the solution matrix (in the first iteration all its values are 0), it returns the max value founded
	 * 	in the given row 'r' and the column 'c'.
	 */
	public static int getMax(int[][]sol, int[][] m, int prev, int r, int c)
	{
		int max = 0;
		for(int i = 0; i < sol[0].length; i++)
		{
			// The repeating components in the same row/column have the same rank
			if(i != r && m[r][i] == prev && prev == m[r][c] &&  sol[r][i] != 0)
				return sol[r][i] -1;
			if(sol[r][i] > max)
				max = sol[r][i];
		}
		
		for(int i = 0; i < sol.length; i++)
		{
			// The repeating components in the same row/column have the same rank
			if(i != c && m[i][c] == prev && prev == m[r][c] && sol[i][c] != 0)
				return sol[i][c] -1;
			if(sol[i][c] >  max)
				max = sol[i][c];
		}
		
		return max;
	}
	
	
	public static int[][] matrixRankTransform(int[][] matrix) 
	{
		int sol[][] = new int[matrix.length][matrix[0].length];
		List<Element> list = new ArrayList<Element>();
		
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[0].length; j++)
				list.add(new Element(i, j, matrix[i][j]));
		
		// It should start to fill the solution matrix from the lowest value
		Collections.sort(list);
		
		int max = 0;
		int prev = Integer.MAX_VALUE;
		for(int i = 0; i < list.size(); i++)
		{
			max = getMax(sol, matrix, prev, list.get(i).row, list.get(i).col) + 1;
			sol[list.get(i).row][list.get(i).col] = max;
			prev = list.get(i).value;
		}
	
		return sol;
    }

	public static void main(String[] args) {
		//int sol[][] = matrixRankTransform(new int[][] {{1,2}, {3,4}});
		//int sol[][] = matrixRankTransform(new int[][] {{7,7}, {7, 7}});
		int sol[][] = matrixRankTransform(new int[][] {{20,-21,14}, {-19,19,4}, {22,-47,24}, {-19,4,19}});
		//int sol[][] = matrixRankTransform(new int[][] {{7,3,6}, {1,4,5}, {9,8,2}});
		
		
		for(int i = 0; i < sol.length; i++)
		{
			for(int j = 0; j < sol[0].length; j++)
			{
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}

}
