/**
 * @filename SortNum.java
 * @author lg
 * @date 2019年1月26日 下午2:28:02
 * @version 1.0
 * Copyright (C) 2019 
 */

package com.util;

public class SortNum {

	public static void main(String[] args) {
		int a[]={1,2,4,3,6,5,8,7,9,0};
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-1; j++) {
				int temp=0;
				if(a[i]<a[j]){
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
