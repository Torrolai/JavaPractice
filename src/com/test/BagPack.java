package com.test;

public class BagPack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义背包的承受重量
		final int BagW = 10;
		//定义物品的数量
		final int Onum=4;
		//物品的价值
		int[] Val = new int[Onum];
		Val[0]=5;
		Val[1]=4;
		Val[2]=6;
		Val[3]=4;
		//物品的重量
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
		//d[i][j]表示前i个宝石装到剩余体积为j的背包里能达到的最大价值,因为数组从0开始，所以我们需要都加上1
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
