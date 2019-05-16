package com28.strStr;

/**
 * 28. 实现strStr()
 * @author Administrator
 *实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Str {
	//双指针问题，一个指针标记位置，一个指针进行比较；
	public static int strStr(String haystack, String needle){
		if(needle==null || needle.length()==0)
			return 0;
		int pos = -1;
		int start = 0;
		int startSub = 0;
		int lastPos = 0;
		while(start<haystack.length()){
			if(haystack.charAt(start)!=needle.charAt(startSub)){
				lastPos++;
				start=lastPos;
				startSub =0;
			}else if(startSub<needle.length()){
				start++;
				startSub++;
				if(startSub == needle.length()){
					pos = start - needle.length();
					break;
				}
			}
		}
		return pos;
	}
	
	public static void main(String[] args) {
		String str = "mississippi";
		String subString = "issip";
		int ret = strStr(str,subString);
		System.out.println("**"+ret);
	}

}
