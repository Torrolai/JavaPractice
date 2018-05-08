package poj;
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
/*
 * 1 means black, 0 means white
 */
public class No1753 {
	int[][] ChangeColor(int ArrayFlip[][],int axisX,int axisY) {
		int x = ArrayFlip.length;
		int y = ArrayFlip[0].length;
		int Xup = axisX-1, Xdown=axisX-1, Xleft=axisY-1,Xright=axisY+1;
		if(Xup>=0) {
			SwapColor(ArrayFlip,Xup,axisY);
		}
		return ArrayFlip;
	}
	
	 void SwapColor(int[][] arrayFlip, int axisX, int axisY) {
		// TODO Auto-generated method stub
		if (arrayFlip[axisX][axisY]==0) 
			arrayFlip[axisX][axisY]=1;
		else
			arrayFlip[axisX][axisY]=0;				
	}

	public void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] ArrayFlip= {{1,0},{0,1}};
		ArrayFlip = ChangeColor(ArrayFlip,1,0);
		System.out.print(ArrayFlip);
	}

}
