package inherite;

public class FirstActivity extends BaseActivity {
	@Override
	protected void onCreate() {
		
		super.onCreate();
	}
	
	public static void main(String[] args) {
		FirstActivity fa = new FirstActivity();
		fa.onCreate();
	}
}
