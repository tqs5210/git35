/**
 * @filename Test.java
 * @author lg
 * @date 2017年11月28日 下午2:51:07
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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Vector;

import com.auth.entity.User;

public class Test {
	int sum=0;
	public  void sum(int i){
		sum=sum+i;
		i++;
		if(i<=100){
			sum(i);
		}
	}
	
	
	public static int digui(int num){
		return num==1?1:num+digui(num-1);
	}
	
	public static int diguiDESC(int num){
	//	100  1
		if(num>1){
			return num+diguiDESC(num-1);
		}else{
			return num;
		}		
	}
	
	public static int diguiASC(int num){
		
		// 1   100
		if(num<100){
			return num+diguiASC(num+1);
		}else{
			return num;
		}
	}
	static int total=0;
	public static int recursion(int num){
		/*++num;
		total=total+num;
		if(num<100){
			recursion(num);
		}
		return total;*/
		total=total+num;
		num--;
		if(num>=1){
			recursion(num);
		}
		return total;
	}
	
	public static void main(String[] args) {
		/*Test test=new Test();
		test.sum(1);
		System.out.println(test.sum);*/
		/*int sum=0;
	     for (int i = 1; i <=100; i++) {
	    	 sum+=i;
		}
	     System.out.println(sum);*/
	     int res=0;
	     int i=1;
	    // System.out.println(recursion(100));
	     try {
	    		 String str=null;
		    	// str.length();
				//throw new Exception("eee");
			} catch (Exception e) {
			   e.printStackTrace();
			}
		//System.out.println("111111111111");
	  /*  	 
	   DateFormat d=DateFormat.getInstance();
	   DateFormat d1=DateFormat.getDateInstance();
	   DateFormat d2=DateFormat.getDateTimeInstance();
	  System.out.println(d.format(new Date()));
	  System.out.println(d1.format(new Date()));
	  System.out.println(d2.format(new Date()));*/
	  
	   DateFormat d1=DateFormat.getDateInstance(DateFormat.FULL);
	   DateFormat d2=DateFormat.getDateInstance(DateFormat.FULL,Locale.getDefault());
	   DateFormat d3=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
	   DateFormat d4=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
	   DateFormat d5=DateFormat.getDateTimeInstance(DateFormat.DEFAULT,DateFormat.DEFAULT);
		  
	  /*System.out.println(d1.format(new Date()));
	  System.out.println(d2.format(new Date()));
	  System.out.println(d3.format(new Date()));
	  System.out.println(d4.format(new Date()));
	  System.out.println(d5.format(new Date()));*/
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  String sd=sdf.format(new Date());
	 // System.out.println(sd);
	  
	 /* Set set=new HashSet();
	  set.add("1");
	  set.add(2);
	  set.add("lg");
	  List list= new ArrayList();
	  list.add("123");
	  list.add("456");
	  set.add(list);
	  Iterator it=set.iterator();
	  while(it.hasNext()){
		  Object obj=it.next();
		  System.out.println(obj);
		  if(obj instanceof List){
			  System.out.println(obj.toString()+"...........");
		  }
	  }
	  
	  System.out.println("..................");
	  for(Object obj: set){
		  System.out.println(obj);
	  }
 
	  System.out.println("vvvvvvvvvvvvvvvv");
	  Vector v=new Vector();//线程安全，效率低 查询速度快  ArrayList LinkList
	  v.add("1");
	  v.add(2);
	  v.add(3);
	  v.add("lg");
	  for(Object o:v){
		  System.out.println(o);
	  }
	  
	  Iterator ite=v.iterator();
	  while(ite.hasNext()){
		  System.out.println(ite.next());
	  }*/
	  FileReader frd=null;
	  try {
		   File f=new File("d:/a.txt");
		   if(!f.exists()){
			   f.createNewFile();
		   }
		   frd=new FileReader(f);
		   BufferedReader br=new BufferedReader(frd);
		   /*int fdd=-1;
		   while((fdd=frd.read())!=-1){
			   System.out.print((char)fdd);
		   }*/
		   String str= null;
		   /*while((str=br.readLine())!=null){
			   System.out.println(str);
		   }*/
		  /* FileWriter fw=new FileWriter(f);
		   BufferedWriter bw=new BufferedWriter(fw);
		   bw.write("hello world!");
		   bw.write("优逸客");
		   bw.newLine();
		   bw.write("优逸客 wolalila");
		   bw.append("刘广");
		   bw.flush();
		   bw.close();
		   br.close();*/
		 /* FileInputStream in=new FileInputStream(f);
		  File fo=new File("d:/汽车之家123.txt");
		 if(!fo.exists()){
			 fo.createNewFile();
		 }
		  FileOutputStream out=new FileOutputStream(fo);
		  int fd=-1;
		  while((fd=in.read())!=-1){
			  out.write(fd);
		  }
		  out.close();
		  in.close();*/
		 /*  //序列化
		  FileOutputStream fo=new FileOutputStream(new File("d:/1.txt"));
		   ObjectOutputStream oout=new ObjectOutputStream(fo);
		   oout.writeObject(new User("unique","111111"));
		   oout.close();
		   fo.close();
		   
		   //反序列化
		   FileInputStream fin=new FileInputStream(new File("d:/1.txt"));
		    ObjectInputStream  oin=new ObjectInputStream(fin);
		   User user=(User)oin.readObject();
		   System.out.println(user.getUserName());
		   System.out.println(user.getPassword());
		   oin.close();
		   fin.close();*/
		   
		  // ObjectInputStream oin=new ObjectInputStream();
	  }catch (Exception e) {
		e.printStackTrace();
	}
	  
	}

}
