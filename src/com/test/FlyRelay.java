package com.test;

//没有达到效果的算法
import java.util.ArrayList;
import java.util.Arrays;

public class FlyRelay {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化飞行的动物列表
		ArrayList<Fly> FlyList = new ArrayList<Fly>();
		Fly f1=new Fly();
		f1.setName("Swift");
		f1.setFlyable(4);	
		FlyList.add(f1);
		Fly f2=new Fly();
		f2.setName("Eagle");
		f2.setFlyable(5);	
		FlyList.add(f2);
		Fly f3=new Fly();
		f3.setName("ButterFly");
		f3.setFlyable(4);	
		FlyList.add(f3);
		
		//在二维空间初始接力点从O到C点，其实可以用二维数组代替
		ArrayList<Point> PointList = new ArrayList<Point>();
		Point p1 = new Point();
		p1.setPointName("O");
		p1.setPointX(2);
		p1.setPointY(2);
		PointList.add(p1);		
		Point p2 = new Point();
		p2.setPointName("A");
		p2.setPointX(3);
		p2.setPointY(4);
		PointList.add(p2);		
		Point p3 = new Point();
		p3.setPointName("B");
		p3.setPointX(5);
		p3.setPointY(5);
		PointList.add(p3);		
		Point p4 = new Point();
		p4.setPointName("C");
		p4.setPointX(7);
		p4.setPointY(8);
		PointList.add(p4);
		
		//O->A->B->C这个渠道有哪些走法		
		int n=0,Pmax=PointList.size(),Fmax=FlyList.size();	
		new FlyRelay().decideFlySeq(n,Pmax,Fmax,PointList,FlyList);		
		
	}
	
	String[] FlySeq = new String[3];
	private void decideFlySeq(int n,int Pmax, int Fmax, ArrayList<Point> PointList, ArrayList<Fly> FlyList) {
		//ArrayList<Fly> FlySeq= new ArrayList<Fly>(Pmax);
		//if(!Arrays.asList(FlySeq).contains(FlyList.get(i).getName())) {					 
		//}
		if(n == Pmax-1) {
			print(FlySeq);
			return;
		}
		else {
			for(int i=0;i<Fmax;i++) {
				//FlySeq.set(n, FlyList.get(i));
				//判断有无该飞行接力动物
				//FlySeq[n]="";
				boolean  ifcontaind=!Arrays.asList(FlySeq).contains(FlyList.get(i).getName());		
				//if(ifcontaind) {
				//	return;
				//}
				//赋予飞行序列值
				FlySeq[n] = FlyList.get(i).getName();
				double FlyDistance = FlyList.get(i).getFlyable();
				if(judge(PointList.get(n),PointList.get(n+1),FlyDistance) & ifcontaind) {
					decideFlySeq(n+1,Pmax,Fmax,PointList,FlyList);
				}
			}		
		}
	}
	

	private void print(String[] FlyN) {
		// TODO Auto-generated method stub
		for(String f1: FlyN) {
			System.out.print(f1 + " ");
		}
		System.out.println();
	}
	
	private boolean judge(Point p1,Point p2,double FlyDistance) {		
		if(getDistance(p1.PointX,p1.PointY,p2.PointX,p2.PointY)>FlyDistance) {
				return false;
		}
		return true;
	}

	private double getDistance(double pointX, double pointY, double pointX2, double pointY2) {
		// TODO Auto-generated method stub
		double distance =Math.sqrt(Math.pow((pointX-pointX2), 2) + Math.pow((pointY-pointY2), 2));
		return distance;
		
	}

	//定义飞行的类，名称和飞行距离
	static public class Fly{
		private String FlyName;
		private double Flyable;
		public void setName(String FlyName) {
			this.FlyName = FlyName;
		}
		public String getName(){
			return FlyName;
		}
		public void setFlyable(int Flyable) {
			this.Flyable = Flyable;
		}
		public double getFlyable() {
			return Flyable;
		}
	}
	
	
	//定义点，X坐标和Y坐标
	static public class Point{
		private String PointName;
		private double PointX;
		private double PointY;
		public void setPointName(String PointName) {
			this.PointName=PointName;
		}
		public String getPointName() {
			return PointName;
		}
		public void setPointX(int PointX) {
			this.PointX = PointX;
		}
		public double getPointX() {
			return PointX;
		}
		public void setPointY(int PointY) {
			this.PointY=PointY;
		}
		public double getPointY() {
			return PointY;
		}
	}

}
