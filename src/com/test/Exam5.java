package com.test;

/*
 * This is a flying relay race.defining a abstract class flyable and a normal class which extends the flyable.
 * I also set a final variable WholeDistance which means the relay's length.
 * 实现飞翔比赛的一次接力，定义了抽象类flyable、和子类insect继承flyable
 * @author Torrolai
 */

import java.util.ArrayList;

public class Exam5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int WholeDistance = 1000;
		ArrayList<insect> InsectList = new ArrayList<insect>();
		int beeNum=11;
		for (int i=1;i<=beeNum;i++) {
			String beeName="bee"+i;
			insect bee=new insect();
			bee.setName(beeName);
			InsectList.add(bee);
		}
		int FlyDistance=0;
		for(insect bees : InsectList) {
			bees.printFly();
			FlyDistance += bees.distance;
			int remanentDistance= WholeDistance-FlyDistance;
			if(FlyDistance >= WholeDistance) {
				System.out.println("WIN! bees fly to the destination.");
				break;
			}
			else {
				System.out.println("Fight bees! There are still " + 
						remanentDistance + " meters to destination.");
			}
		}

	}
	
}

abstract class flyable {
	protected String name; 
	protected int distance = 100;
	public void setName(String name) {
		this.name = name;
	}
	public void setDistance(int distance) {
		this.distance=distance;
	}
	public void printFly() {
		System.out.println(name + " fly "+distance+" meters.");
	}	
}

class insect extends flyable{
	@Override
	public void printFly() {
		System.out.println("Insect " +name + " fly "+distance+" meters.");
	}
	
}
