package com.abstractfruitdemo;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
	
//		Apple a1=new Apple("Red",200,"Kashmiri",true);
//		System.out.println(a1);
//		System.out.println(a1.taste());
//		a1.jam();
//		
//		Orange o1=new Orange("Orange",100,"Nagpur",true);
//		System.out.println(o1);
//		System.out.println(o1.taste());
//		o1.juice();
//		
//		Mango m1=new Mango("Yellow",250,"Kesar",true);
//		System.out.println(m1);
//		System.out.println(m1.taste());
//		m1.pulp();
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter basket size:");
		int basketSize=sc.nextInt();
		Fruit[] basket=new Fruit[basketSize];
		
		while(true) {
			System.out.println("Options:");
			System.out.println("1. Add Mango");
			System.out.println("2. Add Orange");
			System.out.println("3. Add Apple");
			System.out.println("4. Display names of all fruits in basket");
			System.out.println("5. Display name,color,weight,taste of all fresh fruits in the basket");
			System.out.println("6. Mark a fruit as stale");
			System.out.println("7. Mark all sour fruits as stale");
			System.out.println("8. Invoke fruit specific functionality");
			System.out.println("9. Exit");
			System.out.println("Enter your choice:");
		
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				for(int i=0;i<basketSize;i++)
				{
					if(basket[i]==null)
					{
						basket[i]=new Mango("Yellow",300);
						basket[i].setFresh(true);
						break;
					}
				}
				break;
				
			case 2:
				for(int i=0;i<basketSize;i++)
				{
					if(basket[i]==null)
					{
						basket[i]=new Orange("Orange",400);
						basket[i].setFresh(true);
						break;
					}
				}
				break;
			
			case 3:
				for(int i=0;i<basketSize;i++)
				{
					if(basket[i]==null)
					{
						basket[i]=new Apple("Red",200);
						basket[i].setFresh(true);
						break;
					}
				}
				break;
				
			case 4:
				System.out.println("Names of fruits in the basket:");
				for(Fruit fruit:basket)
				{
					if(fruit !=null)
					{
						System.out.println(fruit.getName());
					}
				}
				break;
				
			case 5:
				System.out.println("Names,color,weight and taste of all fresh fruits in the basket:");
				for(Fruit fruit :basket)
				{
					if(fruit !=null && fruit.getFresh())
					{
						System.out.println(fruit.getName()+" , "+fruit.getColor()+" , "+fruit.getWeight()+" , "+fruit.taste());
					}
				}
				break;
				
			case 6:
				System.out.println("Enter index of fruit to mark as stale:");
				int index=sc.nextInt();
				if(index >=0 && index < basketSize)
				{
					if(basket[index]!=null) {
						basket[index].setFresh(false);
						System.out.println("Fruit marked as stale");
					}
					else
					{
						System.out.println("No fruit at the specifiedindex");
					}
				}
				else {
					System.out.println("Invalid index");
				}
				break;
			case 7:
				for(int i=0;i<basketSize;i++)
				{
					if(basket[i] instanceof Orange && basket[i].getFresh())
					{
						basket[i].setFresh(false);
					}
				}
				System.out.println("All sour fruits marked as stale");
				break;
				
			case 8:
				System.out.println("Enter index of fruit to invoke specific functionality:");
				int indexFun=sc.nextInt();
				if(indexFun>=0 && indexFun<basketSize)
				{
					if(basket[indexFun]!=null)
					{
						if(basket[indexFun] instanceof Mango)
						{
							((Mango) basket[indexFun]).pulp();
						}
						else if(basket[indexFun] instanceof Orange)
						{
							((Orange) basket[indexFun]).juice();
						}
						else if(basket[indexFun] instanceof Apple)
							{
								((Apple) basket[indexFun]).jam();
							}
					}
					else {
						System.out.println("No fruit at specified index");
					}
				}
				else {
					System.out.println("Invalid index");
				}
				break;
			
			case 9:
				System.out.println("Exiting...");
				System.exit(0);
			
			default:
				System.out.println("Invalid choice.Please enter a valid option");
					
			}
		}
		
	}

}
