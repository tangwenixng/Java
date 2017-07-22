package com.twx.method;

import java.util.Random;
/**
 * final�ؼ��ֵ��÷�
 * @author twx
 *
 */
public class FinalDemo {
	private static Random rand=new Random();
	private String id;
	
	public  FinalDemo(String id) {
		this.id=id;
	}
	//�����ڳ���
	private final int valueOne=9;
	private static final int VALUE_TWO=99;
	/**
	 * public ���Ա����ڰ�֮��<br>
	 * static ǿ��ֻ��һ��<br>
	 * final ��һ������
	 */
	public static final int VALUE_THREE=39;
	
	private final int i4=rand.nextInt(20);
	static final int INT_5=rand.nextInt(20);
	
	
	
	private Value v1=new Value(11);
	/**
	 * ������Ϊv2��һ������������Ϊ�����ܱ��ı䣻<br>
	 * ��ֻ��һ�����ã�ֻ���޷���ָ����һ���µĶ���
	 */
	private final Value v2=new Value(22);
	private static final Value	VAL_3=new Value(33);
	
	private final int[] a={1,2,3,4,5,6,};
	public String toString() {
		return id+": "+"i4="+i4+" , INT_5="+INT_5;
		
	}
	
	public static void main(String[] args) {
		FinalDemo fd1=new FinalDemo("fd1");
		fd1.v2.i++;
		fd1.v1=new Value(9);
		
		for(int i=0;i<fd1.a.length;i++){
			fd1.a[i]++;
		}
		System.out.println(fd1);
		System.out.println("new line");
		
		FinalDemo fd2=new FinalDemo("fd2");
		System.out.println(fd1);
		System.out.println(fd2);
	}
}

class Value{
	int i;
	public Value(int i){
		this.i=i;
	}
}
