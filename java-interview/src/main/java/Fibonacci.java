/**
 * 计算斐波那契数列(Fibonacci)的第n个值
 * @author twx
 *
 */
public class Fibonacci {
	public int fib(int n){
		if(n==1 || n==2)
			return 1;
		return fib(n-1)+fib(n-2);
	}
	public static void main(String[] args) {
		/*Fibonacci fib = new Fibonacci();
		int num = fib.fib(9);
		System.out.println(num);*/
		
		
		double sum=0;
		double fenmu =1;
		double fenzi =1;
		for(int i=1;;i++){
			double temp =fenzi/fenmu;
			if(Math.abs(temp)<1e-5){
				sum+=temp;
				System.out.println("ending and temp=: "+temp);
				break;
			}
			sum+=temp;
			fenzi*=-1;
			fenmu+=2;
		}
		System.out.println(sum);
	}
}
