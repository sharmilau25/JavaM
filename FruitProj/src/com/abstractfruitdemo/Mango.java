package com.abstractfruitdemo;

public class Mango extends Fruit {

	public Mango(String color, double weight)
	{
		super("Mango",color,weight);
	}
	
	public void pulp()
	{
		System.out.println("Name="+getName()+",Color="+getColor()+" Creating pulp!!!");
	}
	
	@Override
	public String taste() {
		return "Taste of Mango is sweet";
	}
	
}
