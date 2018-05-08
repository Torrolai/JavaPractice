package com.test;

import java.util.ArrayList;

public class testException {

	public static double sqrt(String nStr) throws Exception {
		if(nStr==null) {
			throw new Exception("");
		}
		ArrayList a;
		
		double n=0;
		
		try {
			n = Double.parseDouble(nStr);			
		}catch(NumberFormatException e) {
			throw new Exception("������ַ��������ܹ�ת�������֣�", e);
		}
		
		if(n<0) {
			throw new Exception("������ַ���ת���ɵ����ֱ������0��");
		}
		return Math.sqrt(n);
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		try {
			testException.sqrt("-124.56");		
		}catch(Exception e) {
			System.out.println("Got a Exception��" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		
		/*testException.sqrt("-124.56");*/

	}

}
