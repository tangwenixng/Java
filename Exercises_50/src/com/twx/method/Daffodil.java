package com.twx.method;
/**
 * "水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153=1的三次方＋5的三次方＋3的三次方
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
