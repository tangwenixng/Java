package com.twx.method;
/**
 * �̳����ʼ�����̣�<br>
 * 1.���ȷ���Beetle.main()��������������ʼ����������Beetle.class�ļ���������ע�⵽��һ������Insect.<br>
 * 2.��ʼ�������е�static��Ա�����������ǵ������static.<br>
 * 3.�������ϣ���������
 * @author twx
 *
 */
public class Beetle extends Insect{
	private int k=printInit("Beetle.k initialized");
	public Beetle(){
		System.out.println("k="+k);
		System.out.println("j="+j);
	}
	private static int x2=printInit("Beetle.x2 initialized");
	public static void main(String[] args) {
		System.out.println("begin...");
		Beetle beetle=new Beetle();
	}
}

class Insect{
	private int i=9;
	protected int j;
	public Insect(){
		System.out.println("i="+i+", j="+j);
		j=39;
	}
	
	private static int x1=printInit("static Insect.x1 initialized");
	
	static int printInit(String s){
		System.out.println(s);
		return 56;
	}
}
