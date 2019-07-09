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
//暴力方法
public class BracketGenerate2 {
	
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		char[] cur = new char[2*n];
		generate(result, cur ,0);
		return result;
	        
	}
	
	private static void generate(List<String> result, char[] cur, int pos) {
		if(cur.length== pos) {
			if(validate(cur)) {
				result.add(new String(cur));
			}
			return ;
		}
		cur[pos] = '(';
		generate(result, cur, pos+1);
		cur[pos] = ')';
		generate(result, cur, pos+1);
	}

	private static boolean validate(char[] cur) {
		int count = 0;
		for(int i = 0;i<cur.length;i++) {
			if(cur[i]=='(') {
				count++;
			}else {
				count--;
			}
			if(count<0) {
				return false;
			}
		}
		
		return count==0;
	}
	
	public static void main(String[] args) {
		List<String> ret = generateParenthesis(3);
		for(String s:ret) {
			System.out.println(s);
		}
	}

}
