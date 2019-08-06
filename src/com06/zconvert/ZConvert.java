package com06.zconvert;

import javax.naming.directory.DirContext;


/**6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
 
 * @author Administrator
 * 
 * 
 * helloworld
 * 
 * h     o
 * e   w r
 * l o   l
 * l     d
 * 
 * h       l 
 * e     r d
 * l   o
 * l w
 * o
 */
public class ZConvert {
	public static String convert(String s, int numRows) {
		if(s==null || "".equals(s.trim()) || numRows == 1 || s.length()==1) {
			return s;
		}
		StringBuffer[] subStrings = new StringBuffer[numRows];
		int index = 0;
		Dir dir = Dir.DOWN;
		for(int i = 0; i < s.length(); i++) {
			StringBuffer buffer = subStrings[index];
			if(buffer == null) {
				buffer = new StringBuffer();
			}
			subStrings[index] = buffer.append(s.charAt(i));
			if(dir == Dir.DOWN) {
				if(index < numRows - 1) {
					index++;
				}else {
					dir = Dir.UP;
					index--;
				}
			}
			else if(dir == Dir.UP) {
				if(index > 0) {
					index--;
				}else {
					dir = Dir.DOWN;
					index++;
				}
			}
		}
		
		StringBuffer retBuffer = new StringBuffer();
		for(int i = 0; i < subStrings.length; i++) {
			if(subStrings[i]!=null) {
				retBuffer.append(subStrings[i]);
			}
		}
		
		return retBuffer.toString().trim();
        
    }
	enum Dir{
		UP,DOWN;
	}
	public static void main(String[] args) {
		String ret = convert("LEETCODEISHIRING", 3);
		System.out.println(ret);
	}

}
