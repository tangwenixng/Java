package inherite;

public class BaseActivity {
	protected void  onCreate() {
		System.out.println(getClass().getSimpleName());
	}
	
	public static void main(String[] args) {
		BaseActivity ba = new BaseActivity();
		ba.onCreate();
	}
}
