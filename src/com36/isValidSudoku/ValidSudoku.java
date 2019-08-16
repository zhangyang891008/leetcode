package com36.isValidSudoku;

/**
 * 36. 有效的数独
 * 
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


上图是一个部分填充的有效的数独。

数独部分空格内已填入了数字，空白格用 '.' 表示。

示例 1:

输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true
示例 2:

输入:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: false
解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
说明:

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
给定数独序列只包含数字 1-9 和字符 '.' 。
给定数独永远是 9x9 形式的。
 
 * @author Administrator
 *
 */
public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				boolean flag = getSelect(board, i, j);
				if(!flag) 
					return false;
			}
		}
		return true;
	}
	
    private static boolean getSelect(char[][] board, int x, int y) {
    	int[] visit = {1,0,0,0,0,0,0,0,0,0};
		//遍历当前行
		for(int col = 0; col < 9; col++) {
			if(!(board[x][col] == '.')) {
				if(visit[Integer.parseInt(String.valueOf(board[x][col]))] == 1) {
					return false;
				}
				visit[Integer.parseInt(String.valueOf(board[x][col]))] = 1;
			}
		}
		int[] visit2 = {1,0,0,0,0,0,0,0,0,0};
		//遍历当前列
		for(int row = 0; row < 9; row++) {
			if(!(board[row][y] == '.')) {
				if(visit2[Integer.parseInt(String.valueOf(board[row][y]))] == 1) {
					return false;
				}
				visit2[Integer.parseInt(String.valueOf(board[row][y]))] = 1;
			}
		}
		int[] visit3 = {1,0,0,0,0,0,0,0,0,0};
		//遍历当前九个格子
		int x_start = x<3 ? 0 : (x<6 ? 3 : 6);
    	int x_end = x<3 ? 3 : (x<6 ? 6 : 9);
    	int y_start = y<3 ? 0 : (y<6 ? 3 : 6);
    	int y_end = y<3 ? 3 : (y<6 ? 6 : 9);
 
    	for(int i = x_start; i < x_end; i++) {
    		for(int j = y_start; j < y_end; j++) {
    			if(!(board[i][j] == '.')) {
    				if(visit3[Integer.parseInt(String.valueOf(board[i][j]))] == 1) {
    					return false;
    				}
    				visit3[Integer.parseInt(String.valueOf(board[i][j]))] = 1;
    			}
    		}
    	}
    	
    	return true;
 
    }
	
	public static void main(String[] args) {
		char[][] sudoku = { {'5','3','.','.','7','.','.','.','.'},
							 {'6','.','.','1','9','5','.','.','.'},
							 {'.','9','8','.','.','.','.','6','.'},
							 {'8','.','.','.','6','.','.','.','3'},
							 {'4','.','.','8','.','3','.','.','1'},
							 {'7','.','.','.','2','.','.','.','6'},
							 {'.','6','.','.','.','.','2','8','.'},
							 {'.','.','.','4','1','9','.','.','5'},
							 {'.','.','.','.','8','.','.','7','9'}
		};
		
		boolean ret = isValidSudoku(sudoku);
		System.out.println(ret);
	}

}
