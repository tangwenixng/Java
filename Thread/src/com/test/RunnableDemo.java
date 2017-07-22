package com.test;

class MyThread implements Runnable {
	private int ticket = 10;

	/*
	 * �̻߳���
	 */
	/*
	 * @Override public void run() { for (int i = 0; i < 10; i++) { if (ticket >
	 * 0) { System.out.println(Thread.currentThread().getName()+"������Ʊ�� " +
	 * ticket--); } } }
	 */

	// �߳�����
	/*
	 * public void run() { for(int i=0;i<3;i++){ try { Thread.sleep(2000); }
	 * catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
	 * System.out.println(Thread.currentThread().getName()+" is sleeping"); } }
	 */
	
	//�߳��ж�
/*	public void run() {
		System.out.println(Thread.currentThread().getName()+" is executing");
		try {
			Thread.sleep(10000);
			System.out.println(Thread.currentThread().getName()+"�������");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���߱����");
			return;
		}
		System.out.println("���߳�������ֹ");
	}*/
	
	
	/*������Ʊϵͳ--ͬ����
	  synchronized��ͬ������{

	 		//��Ҫͬ���Ĵ���
	   }*/
	/*public void run(){
		 for(int i=0;i<10;++i){
	            synchronized (this) {
	                if(ticket>0){
	                    try{
	                        Thread.sleep(1000);
	                    }catch(InterruptedException e){
	                        e.printStackTrace();
	                    }
	                    System.out.println(Thread.currentThread().getName()+ " ʣ�� "+ ticket--);
	                }
	            }
	        }
	}*/
	
	/*������Ʊϵͳ--ͬ������
	 * synchronized �����������ͷ������������б�{}
	 */
	public void run(){
		 for(int i=0;i<10;++i){
	            sale();
	        }
	}
	
	public synchronized void sale() {
        if (ticket > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " ʣ�� "+ ticket--);
        }
    }
	
	

}

public class RunnableDemo {
	public static void main(String[] args) {
		/*
		 * �̻߳���
		 */
		/*
		 * MyThread my=new MyThread (); new Thread(my,"1��").start(); new
		 * Thread(my,"2��").start(); new Thread(my,"3��").start();
		 */

		// �߳�����
		/*
		 * MyThread myThread=new MyThread(); new Thread(myThread,"�߳�").start();
		 */

		// �߳��ж�
	/*	MyThread myThread = new MyThread();
		Thread demo=new Thread(myThread, "���߳�");
		demo.start();
		try {
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+" have sleep 2s");
		} catch (Exception e) {
			// TODO: handle exception
		}
		demo.interrupt();*/
		
		/*������Ʊϵͳ--ͬ����
		  synchronized��ͬ������{

		 		//��Ҫͬ���Ĵ���
		   }*/
	/*	
		MyThread myThread=new MyThread();
		new Thread(myThread,"1��").start();
		new Thread(myThread,"2��").start();
		new Thread(myThread,"3��").start();*/
		
		/*������Ʊϵͳ--ͬ������
		 * synchronized �����������ͷ������������б�{}
		 */
		MyThread myThread=new MyThread();
		new Thread(myThread,"1��").start();
		new Thread(myThread,"2��").start();
		new Thread(myThread,"3��").start();
		

		
	}
}