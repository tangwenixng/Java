package com.twx.method;

public class PrimeNumber {
	/**
	 * ���ܣ��ж�������֮��--�ж��ٸ�����
	 * �жϷ�������һ�����ֱ�ȥ��2��sqrt(�����)������ܱ������� ���������������������֮��������
	 * �Ż���i++��Ϊ  i+=2
	 * @param start
	 * @param end
	 */
	public void primeNumberSize(int start,int end) {
		int count=0;
		
		for(int i=start;i<=end;i++){
			boolean flag=false;
			for(int j=2;j<=Math.sqrt(i);j++){
				if(i%j==0){
					flag=false;
					break;
				}else{
					flag=true;
				}
			}
			if(flag){
				count++;
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println(count);
	}
}
