package poj;

import java.awt.desktop.AboutHandler;
import java.lang.reflect.AnnotatedArrayType;

/*
 * Description
 * Flip game is played on a rectangular 4x4 field with two-sided pieces placed on each of its 16 squares. 
 * One side of each piece is white and the other one is black and each piece is lying either it's black or white side up. 
 * Each round you flip 3 to 5 pieces, thus changing the color of their upper side from black to white and vice versa.
 * The pieces to be flipped are chosen every round according to the following rules: 
 * 1.Choose any one of the 16 pieces. 
 * 2.Flip the chosen piece and also all adjacent pieces to the left, to the right, to the top, 
 * and to the bottom of the chosen piece (if there are any).
 * 
 * http://www.cnblogs.com/null00/archive/2012/04/27/2474041.html
 */
/*sadasd
 * 1 means black, 0 means white
 */
public class No1753 {
	static int[][] ChangeColor(int[][] ArrayFlip,int axisX,int axisY) {
		int x = ArrayFlip.length;
		int y = ArrayFlip[0].length;
		int Xup = axisX-1, Xdown=axisX+1, Xleft=axisY-1,Xright=axisY+1;
		if(Xup>=0) {
			SwapColor(ArrayFlip,Xup,axisY);
		}
		if(Xdown<x) {
			SwapColor(ArrayFlip, Xdown, axisY);
		}
		if(Xleft>=0) {
			SwapColor(ArrayFlip, axisX, Xleft);
		}
		if(Xright<y) {
			SwapColor(ArrayFlip, axisX, Xright);
		}
		SwapColor(ArrayFlip, axisX, axisY);
		return ArrayFlip;
	}
	
	static void SwapColor(int[][] arrayFlip, int axisX, int axisY) {
		// TODO Auto-generated method stub
		if (arrayFlip[axisX][axisY]==0) 
			arrayFlip[axisX][axisY]=1;
		else
			arrayFlip[axisX][axisY]=0;				
	}

	static boolean CheckColor(int[][] ArrayFlip) {
		for(int i=0;i<ArrayFlip.length;i++){
			for(int j=0;j<ArrayFlip[0].length;j++) {
				if(ArrayFlip[0][0]!=ArrayFlip[i][j])
					return false;
			}
		}
		return true;		
	}
	
	static int[][] CopyOfArray(int[][] array1){
		int RowLen=array1.length;
		int[][] a=new int[RowLen][];
		for(int i=0;i<RowLen;i++) {
			a[i] = array1[i].clone();
		}
		return a;
	}
	
	static int PlayGame(int[][] ArrayFlip,int startx,int starty,int[] resultx,int[] resulty, int count,int num,int last) {
		int RowLen = ArrayFlip.length;
		int ColLen = ArrayFlip[0].length;
		for(int i=startx;i<RowLen;i++) {
			resultx[count-1] = i;
			for(int j=starty;j<ColLen;j++) {
				resulty[count-1] = j;
				if(count-1==0) {
					//1.backup original array
					int[][] ArrayFlipNew = CopyOfArray(ArrayFlip);
					//2.change the array
					int[][] ArrayFlipChange = ChangeColor(ArrayFlip, resultx[count-1] , resulty[count-1]);
					last += 1;
					//3.check the array								
					if(CheckColor(ArrayFlipChange)) {
						return num;
					}
					//4.restored if necessary
					if(last==num) {
						ArrayFlip=ArrayFlipNew;
					}
					/*make the program complicated
					if(i==RowLen-1 & j==ColLen-1) {	
						resultx = new int[num+1];
						resulty = new int[num+1];
						PlayGame(ArrayFlip, startx, starty, resultx, resulty, num+1, num+1, last);
					}
					*/
				}
				else {
					if(j<ColLen-1)
						PlayGame(ArrayFlip, startx, starty+1, resultx, resulty, count-1, num, last);
					else
						PlayGame(ArrayFlip, startx+1, starty, resultx, resulty, count-1, num, last);
				}
			}
			
		}
		/*
		for(int i=0;i<ArrayFlip.length;i++) {
			for(int j=0;j<ArrayFlip[0].length;j++) {
				ArrayFlip=ChangeColor(ArrayFlip, i, j);
				if(CheckColor(ArrayFlip)) {
					return count;}
			}
		}
		*/
		return -1;
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] ArrayFlip= {{1,0},{0,1}};
		int[] resultx;
		int[] resulty;
		int num=1;
		int count=0;
		resultx = new int[num];
		resulty = new int[num];
		count = PlayGame(ArrayFlip,0,0,resultx,resulty,num,num);
		System.out.print(count);
		/*
		ArrayFlip = ChangeColor(ArrayFlip,1,0);
		for(int i=0;i<ArrayFlip.length;i++) {
			for(int j=0;j<ArrayFlip[0].length;j++)
				System.out.print(ArrayFlip[i][j]+" ");
			System.out.print('\n');
		}
		*/
		
	}

}
