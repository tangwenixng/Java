package entity;

public class Birthday {
	 private String birthday;
	 
	 public Birthday() {
		 
	 }
	 
	 public Birthday(String birthday) {
        this.birthday = birthday;
    }
	 
	 @Override
    public String toString() {
        return this.birthday;
    }
}
