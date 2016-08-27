package com.dwlijx.mouseClick;

import java.awt.Color;
import java.awt.Robot;

public class ColorInfo {
public static void main(String[] args) throws Exception{
Robot robot = new Robot();
//获取指定坐标点的颜色RGB值
Color color = robot.getPixelColor(1000, 768);
System.out.println("Red = " + color.getRed());
System.out.println("Green = " + color.getGreen());
System.out.println("Blue = " + color.getBlue());
Color myColor = new Color(255,255,255);
//将获取到的颜色和指定颜色对比
System.out.println(myColor.equals(color));
//输出RGB色值转换成的Hex
System.out.println(toHex(color.getRed(), color.getGreen(), color.getBlue()));
}

// 以下是将RGB转换为16进制Hex
public static String toHex(int r, int g, int b) {
return "#" + toBrowserHexValue(r) + toBrowserHexValue(g)
+ toBrowserHexValue(b);
}

//将颜色对应的数值转换为16禁止Hex
private static String toBrowserHexValue(int number) {
		StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
		while (builder.length() < 2) {
			builder.append("0");
		}
		return builder.toString().toUpperCase();
	}
}