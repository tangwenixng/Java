package com.twx.method;
/**
 * "ˮ�ɻ���"��ָһ����λ�������λ���������͵��ڸ�������
 * ���磺153=1�����η���5�����η���3�����η�
 * @author twx
 *
 */
public class Daffodil {
	public void printDaffodil(){
		for(int i=100;i<=999;i++){
			int bai=i/100;
			int shi=i%100/10;
			int ge=i%10;
			
			int temp=(int) (Math.pow(bai,3)+Math.pow(shi, 3)+Math.pow(ge, 3));
			if(i==temp)
				System.out.println(i);
		}
	}
	
}
