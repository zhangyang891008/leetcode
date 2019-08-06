package com49.wordgroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

 * @author Administrator
 *
 */
public class WordGroup {
	
	//method1
	public static List<List<String>> groupAnagrams(String[] strs) {
		if(strs == null || strs.length == 0) {
			return null;
		}
        Map<Map<Character, Integer>, List<String>> wordsList = new HashMap<>();
		for(String s : strs) {
			Map<Character, Integer> word = new HashMap<>();
			for(int i = 0; i < s.length(); i++) {
				word.put(s.charAt(i), word.getOrDefault(s.charAt(i), 0) + 1);
			}
			List<String> list = wordsList.getOrDefault(word, new ArrayList<>());
			list.add(s);
			wordsList.put(word, list);
		}
		List<List<String>> ret = new ArrayList<>();
		for(List<String> list : wordsList.values()) {
			ret.add(list);
		}
		return ret;
    }
	
	//method2
	public static List<List<String>> groupAnagrams2(String[] strs) {
		if(strs == null || strs.length == 0) {
			return null;
		}
        Map<String, List<String>> wordsList = new HashMap<>();
		for(String s : strs) {
			String sortString = sort(s);
			List<String> list = wordsList.getOrDefault(sortString, new ArrayList<>());
			list.add(s);
			wordsList.put(sortString, list);
		}
		//merges
		List<List<String>> ret = new ArrayList<>();
		for(List<String> list : wordsList.values()) {
			ret.add(list);
		}
		return ret;
    }
	
	private static String sort(String s) {
		StringBuffer stringBuffer = new StringBuffer(s);
		for(int i = 0; i < stringBuffer.length(); i++) {
			for(int j = i+1; j < stringBuffer.length(); j++) {
				if(stringBuffer.charAt(i) > stringBuffer.charAt(j)) {
					char ch = stringBuffer.charAt(i);
					stringBuffer.setCharAt(i, stringBuffer.charAt(j));
					stringBuffer.setCharAt(j, ch);
				}
			}
		}
		return stringBuffer.toString();
	}

	public static void main(String[] args) {
		String[] arrs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> ret = groupAnagrams2(arrs);
		for(List<String> arr : ret) {
			System.out.println("***");
			for(String s : arr) {
				System.out.println(s);
			}
		}
	}
}
