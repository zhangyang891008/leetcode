package unsolved.com301.removeInvalidParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


/**
 * 301. 删除无效的括号
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。

说明: 输入可能包含了除 ( 和 ) 以外的字符。

示例 1:

输入: "()())()"
输出: ["()()()", "(())()"]
示例 2:

输入: "(a)())()" 
输出: ["(a)()()", "(a())()"]
示例 3:

输入: ")("
输出: [""]
 
 * @author Administrator
 *
 */
public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> retList = new ArrayList<>();
        if(s == null){
            return retList;
        }
        
        Map<Integer, List<String>> cacheResult = new HashMap<>();
        removeInvalid(cacheResult, s);
        List<String> tempList = new ArrayList<>();
        for(int length = s.length(); length > 0; length--) {
        	tempList = cacheResult.get(length);
        	if(tempList != null && tempList.size() > 0) {
        		return tempList;
        	}
        }
        
        retList.add("");
    	return retList;
    }
    
    private static void removeInvalid(Map<Integer, List<String>> cacheResult, String curStr) {
    	if(isValid(curStr)) {
    		List<String> list = cacheResult.getOrDefault(curStr.length(), new ArrayList<>());
    		if(!list.contains(curStr)) {
    			list.add(curStr);
    			cacheResult.put(curStr.length(), list);
    		}
    		return;
    	}
 
		//忽略非括号字符
		int startPos = 0;
		for(startPos = 0; startPos < curStr.length(); startPos++) {
			Character c = curStr.charAt(startPos);
			if(!c.equals(')')) {
				break;
			}
		}
		StringBuilder stringBuilder = new StringBuilder(curStr.substring(startPos));
		String ssString = stringBuilder.toString();
		if(isValid(ssString)) {
			List<String> list = cacheResult.getOrDefault(ssString.length(), new ArrayList<>());
    		if(!list.contains(ssString)) {
    			list.add(ssString);
    			cacheResult.put(ssString.length(), list);
    		}
		}else {
			for(int i = 0; i < stringBuilder.length(); i++) {
				String pre = stringBuilder.substring(0, i);
				String post =  stringBuilder.substring(i + 1);
				removeInvalid(cacheResult, pre + post);    				
			}    		
		}
    }
    
    private static boolean isValid(String s) {
		Stack<Character> bracketStack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			char cur = s.charAt(i);
			if(cur=='{' || cur=='[' || cur=='(') {
				bracketStack.push(cur);
			}else if(cur=='}' || cur==']' || cur==')') {
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
		while(!bracketStack.isEmpty()) {
			return false;
		}
		return true;
    }
    
    public static void main(String[] args) {
    	List<String> retList = removeInvalidParentheses(")))))))))))))))))))P()()p");
    	System.out.println("finish");
	}
}
