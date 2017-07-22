package com.test;

class MyThread implements Runnable {
	private int ticket = 10;

	/*
	 * 线程基础
	 */
	/*
	 * @Override public void run() { for (int i = 0; i < 10; i++) { if (ticket >
	 * 0) { System.out.println(Thread.currentThread().getName()+"正在卖票： " +
	 * ticket--); } } }
	 */

	// 线程休眠
	/*
	 * public void run() { for(int i=0;i<3;i++){ try { Thread.sleep(2000); }
	 * catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
	 * System.out.println(Thread.currentThread().getName()+" is sleeping"); } }
	 */
	
	//线程中断
/*	public void run() {
		System.out.println(Thread.currentThread().getName()+" is executing");
		try {
			Thread.sleep(10000);
			System.out.println(Thread.currentThread().getName()+"休眠完成");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("休眠被打断");
			return;
		}
		System.out.println("副线程正常终止");
	}*/
	
	
	/*经典买票系统--同步块
	  synchronized（同步对象）{

	 		//需要同步的代码
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
	                    System.out.println(Thread.currentThread().getName()+ " 剩余 "+ ticket--);
	                }
	            }
	        }
	}*/
	
	/*经典买票系统--同步方法
	 * synchronized 方法返回类型方法名（参数列表）{}
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
            System.out.println(Thread.currentThread().getName()+ " 剩余 "+ ticket--);
        }
    }
	
	

}

public class RunnableDemo {
	public static void main(String[] args) {
		/*
		 * 线程基础
		 */
		/*
		 * MyThread my=new MyThread (); new Thread(my,"1号").start(); new
		 * Thread(my,"2号").start(); new Thread(my,"3号").start();
		 */

		// 线程休眠
		/*
		 * MyThread myThread=new MyThread(); new Thread(myThread,"线程").start();
		 */

		// 线程中断
	/*	MyThread myThread = new MyThread();
		Thread demo=new Thread(myThread, "副线程");
		demo.start();
		try {
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+" have sleep 2s");
		} catch (Exception e) {
			// TODO: handle exception
		}
		demo.interrupt();*/
		
		/*经典买票系统--同步块
		  synchronized（同步对象）{

		 		//需要同步的代码
		   }*/
	/*	
		MyThread myThread=new MyThread();
		new Thread(myThread,"1号").start();
		new Thread(myThread,"2号").start();
		new Thread(myThread,"3号").start();*/
		
		/*经典买票系统--同步方法
		 * synchronized 方法返回类型方法名（参数列表）{}
		 */
		MyThread myThread=new MyThread();
		new Thread(myThread,"1号").start();
		new Thread(myThread,"2号").start();
		new Thread(myThread,"3号").start();
		

		
	}
}