package com.test;

public class EightQueen {
	int max = 4;
	int[] array = new int[max];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EightQueen().check(0);
	}
	
	private void check(int n) {
        //终止条件是最后一行已经摆完，由于每摆一步都会校验是否有冲突，所以只要最后一行摆完，说明已经得到了一个正确解
        if (n == max) {
            print();
            return;
        }
        //从第一列开始放值，然后判断是否和本行本列本斜线有冲突，如果OK，就进入下一行的逻辑
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
