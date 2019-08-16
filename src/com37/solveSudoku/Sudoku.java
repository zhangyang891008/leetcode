package com37.solveSudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
 
/**
 * 37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。

一个数独。

答案被标成红色。

Note:

给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。
 
 * @author Administrator
 *
 */
public class Sudoku {
	
	
    public static void solveSudoku(char[][] board) {
    	List<Integer> needToFill = new ArrayList<>();
    	Stack<Integer> stack = new Stack();
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    			if(board[i][j] == '.') {
    				needToFill.add(i * 9 + j);
    			}
    		}
    	}
    	boolean ret = fill(board, needToFill, 0);
    }
    
    private static boolean fill(char[][] board, List<Integer> needToFill, int curPos) {
    	if(needToFill.size() == curPos) {
    		return true;
    	}
    	int index = needToFill.get(curPos);
    	int i = index / 9;
	    int j = index % 9;
	    int[] visit = getSelect(board, i, j);

		boolean fillSuccess = false;
		for(int pos = 1; pos < 10 && !fillSuccess; pos++) {
			// 找到没有被填入的数字
			if(visit[pos] == 0) {
				//board[i][j] = (char) pos;
				board[i][j] = (char) ('0' + pos);
				fillSuccess = fill(board, needToFill, curPos+1);
				if(fillSuccess) 
					return true;
				board[i][j] = '.';
			}
		}
		return false;
    }
    
    private static int[] getSelect(char[][] board, int x, int y) {
		int[] visit = {1,0,0,0,0,0,0,0,0,0};
		//遍历当前行
		for(int col = 0; col < 9; col++) {
			if(!(board[x][col] == '.')) {
				visit[Integer.parseInt(String.valueOf(board[x][col]))] = 1;
			}
		}
		//遍历当前列
		for(int row = 0; row < 9; row++) {
			if(!(board[row][y] == '.')) {
				visit[Integer.parseInt(String.valueOf(board[row][y]))] = 1;
			}
		}
		
		//遍历当前九个格子
		int x_start = x<3 ? 0 : (x<6 ? 3 : 6);
    	int x_end = x<3 ? 3 : (x<6 ? 6 : 9);
    	int y_start = y<3 ? 0 : (y<6 ? 3 : 6);
    	int y_end = y<3 ? 3 : (y<6 ? 6 : 9);
 
    	for(int i = x_start; i < x_end; i++) {
    		for(int j = y_start; j < y_end; j++) {
    			if(!(board[i][j] == '.')) {
    				visit[Integer.parseInt(String.valueOf(board[i][j]))] = 1;
    			}
    		}
    	}
		
		return visit;
    }
    
    
    
    private static boolean validateSub(char[][] board, int x, int y) {
    	/**
    	 *  a00 a01 a02
    	 *  a10 a11 a12
    	 *  a20 a21 a22
    	 * 
    	 */
    	if(x < 0 || y < 0 || x > 9 || y > 9) {
    		return false;
    	}
    	
    	int x_start = x<3 ? 0 : (x<6 ? 3 : 6);
    	int x_end = x<3 ? 3 : (x<6 ? 6 : 9);
    	int y_start = y<3 ? 0 : (y<6 ? 3 : 6);
    	int y_end = y<3 ? 3 : (y<6 ? 6 : 9);
    	
    	int [] visit = {1,0,0,0,0,0,0,0,0,0};
    	System.out.println(visit.length);
    	for(int i = x_start; i < x_end; i++) {
    		for(int j = y_start; j < y_end; j++) {
    			if(!(board[i][j] == '.')) {
    				System.out.println(board[i][j]);
    				int number = Integer.parseInt(String.valueOf(board[i][j]));
    				
    				if(visit[number] == 1) {
    					return false;
    				}else {
    					visit[number] = 1;
    				}
    			}
    		}
    	}
    	
    	return true;
    }

	private static boolean validate(char[][] subBoard) {
    	/**
    	 *  a00 a01 a02
    	 *  a10 a11 a12
    	 *  a20 a21 a22
    	 * 
    	 */
    	if(subBoard == null || subBoard.length != 3 || subBoard[0].length != 3) {
    		return false;
    	}
    	int [] visit = {1,0,0,0,0,0,0,0,0,0};
    	System.out.println(visit.length);
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			if(!(subBoard[i][j] == '.')) {
    				int number = Integer.parseInt(String.valueOf(subBoard[i][j]));
    				
    				if(visit[number] == 1) {
    					return false;
    				}else {
    					visit[number] = 1;
    				}
    			}
    		}
    	}
    	
    	return true;
    }
 
	public static void main(String[] args) {
		char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'},
					       {'6','.','.','1','9','5','.','.','.'},
					       {'.','9','8','.','.','.','.','6','.'},
					       {'8','.','.','.','6','.','.','.','3'},
				          {'4','.','.','8','.','3','.','.','1'},
				          {'7','.','.','.','2','.','.','.','6'},
				          {'.','6','.','.','.','.','2','8','.'},
				          {'.','.','.','4','1','9','.','.','5'},
				          {'.','.','.','.','8','.','.','7','9'}};
		//solveSudoku(sudoku);
		/*
		char[][] testArr = {
							{'.','2','3'},
							{'4','5','6'},
							{'7','8','9'}
							};
		boolean ret = validate(testArr);
		System.out.println(ret);
					*/
		solveSudoku(sudoku);
		System.out.println("finish");
	}

}
