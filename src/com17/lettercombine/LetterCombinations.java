package com17.lettercombine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * @author zy
 *
 */
public class LetterCombinations {

	public static List<String> letterCombinations(String digits) {
        List<String> retList = new ArrayList<>();
		if(digits.length()==0) {
			return retList;
		}
		int[][] nums = {{0},{0},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
				{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
		HashMap<Integer, String> charMap= new HashMap<Integer, String>();
		charMap.put(2, "abc");
		charMap.put(3, "def");
		charMap.put(4, "ghi");
		charMap.put(5, "jkl");
		charMap.put(6, "mno");
		charMap.put(7, "pqrs");
		charMap.put(8, "tuv");
		charMap.put(9, "wxyz");
		int pos = 0;
		combine(retList, new StringBuilder(),digits,charMap,0);
		return retList;
    }
	
	public static void combine(List<String> retList, StringBuilder sBuilder, String digits, HashMap<Integer, String> chars ,int pos) {
		if(sBuilder.length()==digits.length()) {
			retList.add(sBuilder.toString());
			return;
		}
		char chr = digits.charAt(pos);
		int val = Integer.parseInt(""+chr);
		for(int i = 0;i<chars.get(val).length();i++) {
			StringBuilder temp = new StringBuilder(sBuilder);
			temp.append(""+chars.get(val).charAt(i));
			combine(retList, temp, digits, chars, pos+1);
		}
	}
	
	public static void main(String[] args) {
		String string = "";
		List<String> rets = letterCombinations(string);
		System.out.println("finish");
	}
}
