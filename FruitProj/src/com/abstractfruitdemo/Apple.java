package com.abstractfruitdemo;

public class Apple extends Fruit {

	public Apple(String color, double weight)
	{
		super("Apple",color,weight);
	}
	
	@Override
	public String taste() {
		return "Taste of apple is sweet and sour";
	}

	public void jam() 
	{
		System.out.println("Name="+name+" Making a jam!!!");
	}
	
}
