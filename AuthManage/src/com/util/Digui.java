/**
 * @filename Digui.java
 * @author lg
 * @date 2018年1月15日 下午1:48:45
 * @version 1.0
 * Copyright (C) 2018 
 */

package com.util;

public class Digui {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {//行号
			if(i!=0 && i!=1 &&i!=4){
				System.out.print("*");
				for (int k = 0; k < i-1; k++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}else{
				for (int j = 0; j < i+1; j++) {//打印*
					System.out.print("*");
				}
			}
				
			/*if(i==2){//3行
				System.out.print("* *");
			}else if(i==3){//4行
				System.out.print("*  *");
			}else{
				for (int j = 0; j < i+1; j++) {//打印*
					System.out.print("*");
				}
			}*/
			System.out.println();
		}	
		
		}


}