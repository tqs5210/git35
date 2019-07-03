/**
 * @filename AuthTest.java
 * @author lg
 * @date 2017年12月22日 下午4:43:12
 * @version 1.0
 * Copyright (C) 2017 
 */

package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Collections;
import java.util.Scanner;

public class AuthTest {

	
public static void main(String[] args) {
	try {
		/*File f=new File("d:/iotest","/test.txt");
		if(!f.getParentFile().exists()){
			 f.getParentFile().mkdirs();	
		}
		if(!f.exists()){
			f.createNewFile();
		}
		FileOutputStream out=new FileOutputStream(f);
		String str="welcome！刘广\n你好！";
		out.write(str.getBytes());
		out.close();

		FileInputStream fin=new FileInputStream(f);
		int d=-1;
		while((d=fin.read())!=-1){
			System.out.print((char)d);
		}
		fin.close();
		
		FileReader fr=new FileReader(f);
		while((d=fr.read())!=-1){
			System.out.print((char)d);
		}
		fr.close();
		System.out.println("-------------------");
		BufferedReader br=new BufferedReader(new FileReader(f));
		String msg="";
		while((msg=br.readLine())!=null){
			System.out.println(msg);
		}
		br.close();*/
		
		
		/*FileWriter fw=new FileWriter(f);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.append("你好，优逸客");
		bw.append("\nwelcome");
		bw.flush();
		bw.close();
		*/
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	/*int i=0;
	Integer in=i;
	i=in;

	Double d=Double.parseDouble(i+"");
	System.out.println(d);*/
	
/*	String str ="123";
	String str1 =new String("");
	str1=str1+"123";
	str=str+"";
	System.out.println(str==str1);
	System.out.println(str.equals(str1));*/
	
	int is[][]=new int[100][100];
	//赋值
	long t1=System.currentTimeMillis();
	for(int i=0;i<100;i++){
	for(int j=0;j<100;j++){
	is[i][j]=i+j;
	}
	}
	
	/*long s1=System.currentTimeMillis();
	for (int j = 0; j < 100; j++) {//控制列
		for (int i = 0; i < 100; i++) {//控制列
			System.out.print(is[i][j]+" ");
		}
		System.out.println();
	}
	long e1=System.currentTimeMillis();
	System.out.println("-------------------"+(e1-s1));*/
	
	
	long s=System.currentTimeMillis();
/*	for (int i = 0; i < is.length; i++) {//控制行
		for (int j = 0; j <is[i].length; j++) {//控制列
			System.out.print(is[i][j]+" ");
		}
		System.out.println();
	}
	long e=System.currentTimeMillis();
	System.out.println("-------------------"+(e-s));
	*/
	
	/*for(int[]i:is){//行
		for(int j :i){//列
			System.out.print(j+" ");
		}
		System.out.println();
	}*/
	
	/*int []a={1,3,5,2,6,9,8,7,4};
	for (int i = 0; i < a.length-1; i++) {//9
		for (int j = 0; j < a.length-1-i; j++) {
			int temp=0;
			if(a[j]<a[j+1]){
				temp=a[j+1];
				a[j+1]=a[j];
				a[j]=temp;
			}
		}
		
	}
	
	for (int i = 0; i < a.length; i++) {
		System.out.println(a[i]);
		
	}*/
/*	while(true){
		Scanner scan=new Scanner(System.in);
		String str=scan.next();
		System.out.println(str);
		if("byte".equals(str)){
			System.out.println("byte...........");
			return;
		}
	}*/
	/*int []a={1,3,5,2,6,9,8,7,4};
	for (int i = 0; i < a.length-1; i++) {
		for (int j = 0; j < a.length-1-i; j++) {
			int temp=0;
			if(a[j]<a[j+1]){
				temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
		}
	}
	for (int i = 0; i < a.length; i++) {
		System.out.println(a[i]);
	}*/
	int i=0;
	/*while(i<100){
	++i;
	System.out.println(i);
	}*/
	int r=0;
	do{
		++i;
		if(i%7==0 && r<5){
			++r;
		System.out.println(i);
		}
	}while(i<100);
}
}
