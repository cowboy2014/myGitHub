package com.dwlijx.class1;

public class TestStringMatches {

	public static void main(String[] args) {
		String jobnameStr = "P_ISE_PC_CHA_$LocalCode";
		boolean ret = jobnameStr.matches(".+_\\$LocalCode$");//
		System.out.println(ret);
	}
}
