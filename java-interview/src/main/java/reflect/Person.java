package reflect;

public class Person {
	private String name;
	private int age;
	private String gender;
	
	public Person() {}
	
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "我的名字叫："+name+" 我"+age+"岁了";
	}
	
	public void coding(){
		System.out.println(name+"在编码");
	}
	
	public void runing(int mil){
		System.out.println(name+"跑了"+mil+"公里");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
