package com.test;

public class BagPack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���屳���ĳ�������
		final int BagW = 10;
		//������Ʒ������
		final int Onum=4;
		//��Ʒ�ļ�ֵ
		int[] Val = new int[Onum];
		Val[0]=5;
		Val[1]=4;
		Val[2]=6;
		Val[3]=4;
		//��Ʒ������
		int[] Weight = new int[Onum];
		Weight[0]=6;
		Weight[1]=4;
		Weight[2]=5;
		Weight[3]=2;
		
		
		int topValue=BestV(BagW,Weight,Val);
		System.out.println(topValue);	
	}
	
	private static int BestV(int totalW, int[] ArrW,int[] ArrV) {
		int num = ArrW.length;
		//d[i][j]��ʾǰi����ʯװ��ʣ�����Ϊj�ı������ܴﵽ������ֵ,��Ϊ�����0��ʼ������������Ҫ������1
		int[][] d = new int[num+1][totalW+1];
		for(int i=1;i<=num;i++)
			for(int j=1;j<=totalW;++j)
			{
				d[i][j] = i == 0? 0 : d[i-1][j];
				if(i>0 & j>=ArrW[i-1]) {
					d[i][j] = max(d[i-1][j-ArrW[i-1]]+ArrV[i-1],d[i-1][j]);							
				}
				System.out.println(i+" " + j +" " +d[i][j]);
			}
		return d[num][totalW];
		
	}

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if(i>j) {
			return i;
		}
		return j;
	}

}
