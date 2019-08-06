package com118.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],   
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
[
     [1],              0
    [1,1],           0   1  
   [1,2,1],        0   1   2 
  [1,3,3,1],     0   1   2   3
 [1,4,6,4,1]
]
 * @author Administrator
 *
 */
public class Triangle {
	
	public static List<List<Integer>> generate(int numRows) {
		if(numRows==0) {
			return new ArrayList<>();
		}
		
		List<List<Integer>> ret =  new ArrayList<>();
		
		List<Integer> upperLine = new ArrayList<>();
		upperLine.add(1);
		ret.add(upperLine);
		
		for(int i = 2; i <= numRows; i++) {
			
			List<Integer> line = new ArrayList<>();
			line.add(0, 1);
			for(int j = 1; j < i - 1; j++) {
				 line.add(j, upperLine.get(j-1) + upperLine.get(j));
			}
			line.add(i - 1, 1);
			ret.add(line);
			upperLine = line;
		}
		
		return ret; 
    } 
	
	public static void main(String[] args) {
		List<List<Integer>> list = generate(6);
		System.out.println("finish");
	}

}
