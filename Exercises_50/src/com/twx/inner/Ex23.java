package com.twx.inner;


interface U {
	void f();

	void g();

	String toString();
}

class A {
	U buildU() {
		return new U() {
			public void f() {
				System.out.println("f()");
			}

			public void g() {
				System.out.println("g()");
			}

			public String toString() {
				return "I'm a U";
			}
		};
	}
}

class B {
	private U[] us;

	B(int i) {
		us = new U[i];
	}

	void addU(U u, int i) {
		us[i] = u;
	}

	void eraseU(int i) {
		us[i] = null;
	}

	void testUs() {
		for (U u : us) {
			u.f();
			u.g();
			u.toString();
		}
	}

	void showUs() {
		for (U u : us) {
			if (u != null)
				System.out.println(u.toString());
			else
				System.out.println("I'm null");
		}
	}
}

public class Ex23 {
	public static void main(String[] args) {
		A a0 = new A();
		A a1 = new A();
		A a2 = new A();
		B b = new B(3);
		b.addU(a0.buildU(), 0);
		b.addU(a1.buildU(), 1);
		b.addU(a2.buildU(), 2);
		b.showUs();
		b.testUs();
		b.eraseU(0);
		b.eraseU(1);
		b.showUs();
	}
}