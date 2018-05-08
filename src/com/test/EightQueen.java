package com.test;

public class EightQueen {
	int max = 4;
	int[] array = new int[max];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EightQueen().check(0);
	}
	
	private void check(int n) {
        //��ֹ���������һ���Ѿ����꣬����ÿ��һ������У���Ƿ��г�ͻ������ֻҪ���һ�а��꣬˵���Ѿ��õ���һ����ȷ��
        if (n == max) {
            print();
            return;
        }
        //�ӵ�һ�п�ʼ��ֵ��Ȼ���ж��Ƿ�ͱ��б��б�б���г�ͻ�����OK���ͽ�����һ�е��߼�
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }
	 private boolean judge(int n) {
	        for (int i = 0; i < n; i++) {
	            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
	                return false;
	            }
	        }
	        return true;
	    }
	 
	  private void print()  {
	        for (int i = 0; i < array.length; i++) {
	            System.out.print(array[i] + 1 + " ");
	        }
	        System.out.println();
	 }
	
	

}
