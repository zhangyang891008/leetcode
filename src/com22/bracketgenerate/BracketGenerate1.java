package com22.bracketgenerate;

import java.util.ArrayList;
import java.util.List;

/**22括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zy
 *
 */
//1回溯法
public class BracketGenerate1 {
	
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generate(result,"",0,0,n);
		return result;
	        
	}
	
	private static void generate(List<String> result, String temp, int open, int close, int max) {
		if(temp.length()==2*max) {
			//if(!result.contains(temp))
			result.add(temp);
			return;
		}
		
		if(open<max) {
			generate(result, temp+'(', open+1, close, max);
		}
		if(close<open) {
			generate(result, temp+')', open, close+1, max);
		}
	}
	
	public static void main(String[] args) {
		List<String> ret = generateParenthesis(2);
		for(String s:ret) {
			System.out.println(s);
		}
	}

}
