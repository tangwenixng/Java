package com.twx.method;

public class PrimeNumber {
	/**
	 * 功能：判断两个数之间--有多少个素数
	 * 判断方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，反之是素数。
	 * 优化：i++改为  i+=2
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
