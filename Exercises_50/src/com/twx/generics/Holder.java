package com.twx.generics;

import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.Pet;

public class Holder<T>{
	private T a;
	public Holder(T a) {
		this.a=a;
	}
	public void set(T a){
		this.a=a;
	}
	public T get(){
		return a;
	}
	public static void main(String[] args) {
		Holder<Pet> pet=new Holder<Pet>(new Cat());
		pet.set(new Dog());
		System.out.println(pet.get().toString());
	}

}
