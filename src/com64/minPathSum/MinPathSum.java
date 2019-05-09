package com64.minPathSum;

import java.util.ArrayList;
import java.util.List;
/**64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 * @author Administrator
 *
 */
public class MinPathSum {
	
	public static  int minPathSum(int[][] grid) {
        int minPathValue = Integer.MAX_VALUE;
        List<Integer> visitPath= new ArrayList<Integer>(); 
        int ret = path(grid, 0, 0, 0, minPathValue );
        for(Integer i: visitPath) {
        	System.out.println(i);
        }
        return ret;
    }
	
	private static int path(int[][] grid, int currX, int currY, int currSum, int minPathValue ) {
		if(currX == grid.length-1 && currY == grid[0].length-1) {
			//到达终点
			int end =  grid[currX][currY];
			minPathValue = (currSum + end) < minPathValue? (currSum + end):minPathValue;
			return minPathValue;
		}
		int minValue = Integer.MAX_VALUE;
		
		if(currSum + grid[currX][currY]>minPathValue)
			return Integer.MAX_VALUE;

		int pathX = Integer.MAX_VALUE ,pathY = Integer.MAX_VALUE;
		if(currX<grid.length-1) {
			pathX = path(grid, currX+1, currY, currSum+grid[currX][currY], minPathValue);
		}
		if(currY<grid[0].length-1) {
			pathY = path(grid, currX, currY+1, currSum+grid[currX][currY], minPathValue);
		}
		
		minValue = pathX>pathY ? pathY:pathX;
		return minValue > minPathValue ? minPathValue:minValue;
	}
	
	public static void main(String[] args) {
		int [][] grid = {{1,4,1},{1,5,1},{4,2,1}};
		int min = minPathSum(grid);
		System.out.println(min);
	}
}
