package com.twx.composite;

public class Test {
	private final  char[] value;
	public Test(char[] value) {
		this.value = value;
	}
	private int hash;
	
	 public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];//s[0]*31^(n-1)+s[1]*31^(n-2)+...+s[n-1]
            }
            hash = h;
        }
        return h;
    }
	 
	 
	 public static void main(String[] args) {
			/*Composite root = new Composite("root");
			root.add(new Leaf("Leaf A"));
			root.add(new Leaf("Leaf B"));
			
			Composite comp1 = new Composite("Leaf C");
			comp1.add(new Leaf("Leaf C1"));
			comp1.add(new Leaf("Leaf C2"));
			
			root.add(comp1);
			
			Composite comp2 = new Composite("Leaf C3");
			comp2.add(new Leaf("Leaf C3-1"));
			comp2.add(new Leaf("Leaf C3-2"));
			comp1.add(comp2);
			
			root.add(new Leaf("Leaf D"));
			
			Leaf e = new Leaf("Leaf E");
			root.add(e);
			root.remove(e);
			
			root.display(1);
			
			StringBuilder sb = new StringBuilder();
			sb.append("a");
			
			String str = sb.toString();*/
		 char[] vv = {1,2,3};
 		 Test test = new Test(vv);
 		 int num = test.hashCode();//1*31^2+2*31+3
		 System.out.println("num: "+num);
		}
}
