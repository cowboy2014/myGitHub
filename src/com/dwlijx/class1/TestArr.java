package com.dwlijx.class1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class TestArr {
	public static void main(String[] args) throws Exception {
		String[] arr = null;
		String str1 = "T01001	TERM	华为	荣耀4x	.*荣耀[\\s]*4[\\s]*x.*";
		String str2 = "T01002	TERM	华为	 荣耀6	.*荣耀[\\s]*6.*";
		arr = str1.split("\\t");
		System.out.println(arr[4]);
		arr = str2.split("\\t");
		System.out.println(arr[4]);
	}
}