import java.util.Calendar;

public class StringCompare {
	public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s2.intern());
    }
	
	public void calender(){
		Calendar cl = Calendar.getInstance();
	}
}
