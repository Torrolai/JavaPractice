package poj;

// http://www.cnblogs.com/null00/archive/2012/04/27/2473788.html
/*
1 //arrΪԭʼ����
2 //startΪ������ʼλ��
3 //result��������Ϊһά����
4 //countΪresult���������ֵ����������
5 //NUMΪҪѡȡ��Ԫ�ظ���
6 //arr_lenΪԭʼ����ĳ��ȣ�Ϊ��ֵ
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
		for(i=start;i<arrayLen+1-count;i++) { //ѡ��һ����ʣ�µĸ���
			result[count-1]=i;
			if(count-1==0) {  //count-1==0��ʾ������
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
