package com.test;

public class Hanota {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseHanota(3,'A','B','C');
		
	}
	
	static void UseHanota(int n ,char a  ,char b,char c)
	{
		if(n==1)
		{
			System.out.println("move "+a+" to "+c);
		}
		else if (n>1)
		{
			UseHanota(n-1,a,c,b );
			System.out.println("move "+a+" to "+c);
			UseHanota(n-1,b,a,c);
		}
	}
	

}
