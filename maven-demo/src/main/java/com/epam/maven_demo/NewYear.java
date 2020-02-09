package com.epam.maven_demo;
import java.util.*;
import java.util.Scanner;
public class NewYear {
	static Scanner input=new Scanner(System.in);
	static ArrayList<Chocolate> cs=new ArrayList<Chocolate>();
	static ArrayList<Chocolate> candies=new ArrayList<Chocolate>();
	static ArrayList<Sweet> sweets=new ArrayList<Sweet>();
	static HashMap<String,Integer> Weight=new HashMap<String,Integer>();
	static HashMap<String,Integer> Price=new HashMap<String,Integer>();
	public static void main(String args[])
	{
		Chocolates();
		Sweets();
		System.out.println("Total weight of gift is:"+sum());
		int sByType=input.nextInt();
		if(sByType==1) {
			Comparator<Chocolate> byPrice=new Comparator<Chocolate>() {
				@Override
				public int compare(Chocolate c1,Chocolate c2)
				{
					return((Integer)c1.getPrice()).compareTo(c2.getPrice());
				}
			};
			Collections.sort(cs,byPrice);
		}
		else {
			Comparator<Chocolate> byWeight=new Comparator<Chocolate>() {
				@Override
				public int compare(Chocolate c1,Chocolate c2)
				{
					return((Integer)c1.getWeight()).compareTo(c2.getWeight());}
			};
			Collections.sort(cs,byWeight);
		}
		System.out.println("Sorted list:");
		for(Chocolate chocolate:cs) {
			System.out.println(chocolate.getPrice());
		}
		Range(sByType);
	}
	public static void Chocolates() {
		System.out.println("enter the chocolate number:");
		int nc=input.nextInt();
		for(int i=1;i<=nc;i++) {
			System.out.println("enter the type(enter the number):1.candy 2.wafer 3.chips 4.bar");
			int cType=input.nextInt();
			System.out.println("enter the chocolate weight:");
			int cWeight=input.nextInt();
			System.out.println("enter the chocolate price:");
			int cPrice=input.nextInt();
			if(cType==1) {
				System.out.println("enter candy name:");
				String canName=input.next();
				if(Weight.containsKey(canName)) {
					Weight.put(canName,(int)Weight.get(canName)+cWeight);
				}
				else
					Weight.put(canName,cWeight);
				if(Price.containsKey(canName)) {
					Price.put(canName,(int)Price.get(canName)+cPrice);
				}
				else
					Price.put(canName,cPrice);
			}
			Chocolate c=new Chocolate(cWeight,cPrice);
			cs.add(c);
			if(cType==1) {
				candies.add(c);
			}
		}
	}
	public static void Sweets()
	{
		System.out.println("enter the sweets number:");
		int s=input.nextInt();
		for(int j=1;j<=s;j++) {
			System.out.println("enter the sweet weight:");
			int sWeight=input.nextInt();
			System.out.println("enter the sweet price:");
			int sPrice=input.nextInt();
			Sweet st=new Sweet(sWeight,sPrice);
			sweets.add(st);
		}
	}
	public static int sum() {
		int tot=0;
		for(Chocolate chocolate:cs) {
			tot+=chocolate.getWeight();
		}
		for(Sweet st:sweets) {	
			tot+=st.getWeight();
		}
		return tot;
	}
	public static void Range(int sType) {
		int ll,hl;
		if(sType==1) {
			System.out.println("enter lower limit:");
			ll=input.nextInt();
			System.out.println("enter higher limit:");
			hl=input.nextInt();
			Set<Map.Entry<String,Integer>> cSet=Price.entrySet();
			Iterator<Map.Entry<String,Integer>> cIterator=cSet.iterator();
			while(cIterator.hasNext()) {
				Map.Entry<String,Integer> cElement=(Map.Entry<String,Integer>)cIterator.next();
				int currPrice=(int)cElement.getValue();
				if(currPrice>=ll && currPrice<=hl)
					System.out.println(cElement.getKey());
			}
		}
		else
		{
			System.out.println("enter lower limit:");
			ll=input.nextInt();
			System.out.println("enter higher limit:");
			hl=input.nextInt();
			Set<Map.Entry<String,Integer>> cSet=Weight.entrySet();
			Iterator<Map.Entry<String,Integer>> cIterator=cSet.iterator();
			while(cIterator.hasNext()) {
				Map.Entry<String,Integer> cElement=(Map.Entry<String,Integer>)cIterator.next();
				int currWeight=(int)cElement.getValue();
				if(currWeight>=ll && currWeight<=hl)
					System.out.println(cElement.getKey());
			}
		}
	}
}
