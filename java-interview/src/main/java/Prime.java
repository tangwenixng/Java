/**
 * 判断是不是质数/素数
 * @author twx
 *
 */
public class Prime {
	public boolean isPrime(int n){
		if(n==1 || n%2==0)
			return false;
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Prime prime = new Prime();
		/*boolean res = prime.isPrime(9);
		System.out.println(res);*/
//		prime.printAdd(14);
		int counter=0;
		for(int i=101;i<200;i++){
			if(prime.isPrime(i)){
				counter++;
				System.out.println(i+" ");
			}
		}
		System.out.println("总共有"+counter+"个素数");
	}
	
	public void printAdd(int n){
		if(n<=6&&n%2!=0)
			return;
		for(int i=3;i<n;i++){
			if(isPrime(i)&&isPrime(n-i)){
				System.out.println(i+"+"+(n-i)+"="+n);
			}
		}
	}
}
