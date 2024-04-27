package com.abstractfruitdemo;

public class Orange extends Fruit {
	
	public Orange(String color, double weight)
	{
		super("Orange",color,weight);
	}
	
	public String taste()
	{
		return "Taste of orange is sour";
	}
	
	public void juice()
	{
		System.out.println("Name="+getName()+",Weight="+getWeight()+" Extracting juice!!");
	}
	
}
