package com20.bracket;

import java.util.Stack;

/**20有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zy
 *
 */
public class Bracket {
	
	public static boolean isValid(String s) {
		Stack<Character> bracketStack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			char cur = s.charAt(i);
			if(cur=='{' || cur=='[' || cur=='(') {
				bracketStack.push(cur);
			}else {
				if(!bracketStack.isEmpty()) {
					char topChar = bracketStack.pop();
					if(topChar=='{' && cur=='}') {
						continue;
					}else if(topChar=='(' && cur==')') {
						continue;
					}else if(topChar=='[' && cur==']') {
						continue;
					}else {
						return false;
					}
				}else {
					return false;
				}
				
			}
		}
		
		if(!bracketStack.isEmpty()) {
			return false;
		}
		
		return true;
        
    }
	
	public static void main(String[] args) {
		boolean ret = isValid("");
		System.out.println(ret);
	}
}
