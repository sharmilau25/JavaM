package com.abstractfruitdemo;

public abstract class Fruit {
	protected String color;
	protected double weight;
	protected String name;
	protected boolean fresh;
	
	public Fruit()
	{
		color="NA";
		weight=0.0;
		name="NA";
		fresh=false;
	}
	public Fruit(String name, String color, double weight)
	{
		this.name = name;
        this.color = color;
        this.weight = weight;
        this.fresh = true;
	}
	
	//GETTERS
	public String getColor()
	{
		return color;
	}
	public double getWeight()
	{
		return weight;
	}
	public String getName()
	{
		return name;
	}
	public boolean getFresh()
	{
		return fresh;
	}
	
	//SETTERS
	public void setColor(String color)
	{
		this.color=color;
	}
	public void setWeight(double weight)
	{
		this.weight=weight;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setFresh(boolean fresh)
	{
		this.fresh=fresh;
	}
	
	public abstract String taste();
	
	//toString()
	public String toString()
	{
		return  "Fruit[color="+color+",weight="+weight+",name="+name+"]";
	}
}
