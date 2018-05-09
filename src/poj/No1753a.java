package poj;

// http://www.cnblogs.com/null00/archive/2012/04/27/2473788.html
/*
1 //arr为原始数组
2 //start为遍历起始位置
3 //result保存结果，为一维数组
4 //count为result数组的索引值，起辅助作用
5 //NUM为要选取的元素个数
6 //arr_len为原始数组的长度，为定值
*/
public class No1753a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,5};
		int num=2;
		int[] result; 
		result = new int[num];
		func(a,0,result,num,num);
	}
	
	static void func(int[] array1,int start,int[] result,int count,int num) {
		int arrayLen = array1.length;
		int i = 0;
		for(i=start;i<arrayLen+1-count;i++) { //选完一个后还剩下的个数
			result[count-1]=i;
			if(count-1==0) {  //count-1==0表示数完了
				int j;
				for(j=num-1;j>=0;j--) {
					System.out.printf("%d ", array1[result[j]]);
				}
				System.out.printf("\n");
			}
			else
				func(array1, i+1, result, count-1, num);
		}
	}

}
