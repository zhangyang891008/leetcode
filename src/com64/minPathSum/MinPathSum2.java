package com64.minPathSum;

/**
 * Both of the two methods can solve the problem. but dp is faster then the first solution.
 * @author Administrator
 *
 */
public class MinPathSum2 {
	
	public static  int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1;i<m ;i++ ) {
        	dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        
        for(int j = 1;j<n ;j++) {
        	dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        
        for(int i = 1;i<m;i++) {
        	for(int j =1;j<n;j++) {
        		dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
        	}
        }
        return dp[m-1][n-1];
    }
	
	public static void main(String[] args) {
		int [][] grid = {{1,4,1},{1,5,1},{4,2,1}};
		int min = minPathSum(grid);
		System.out.println(min);
	}
}
