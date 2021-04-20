package com.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.address.Address;
import com.customer.Customer;

public class Main {

	public static void main(String[] args) throws Exception {
		Set<Customer> customer = new HashSet<Customer>();
		boolean flag =false;
		List<Customer> customerList = new ArrayList<Customer>();
		List<String> list = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("src/data.txt"));
		Map<String, Integer> map = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		String curLine;
		int customerCount = 0;
		while ((curLine = br.readLine()) != null) {
			Customer cust = new Customer();
			Address add = new Address();
			String[] data = curLine.split(",");
			cust.setId(Long.parseLong(data[0]));
			cust.setName(data[1].toLowerCase());
			cust.setGender(data[2].charAt(0));
			cust.setEmail(data[3]);
			cust.setContactNumber(data[4]);
			String sDate1=data[5];
			Date date1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sDate1);
			cust.setCreatedOn(date1);
			add.setStreet(data[6]);
			add.setCity(data[7].toLowerCase());
			add.setState(data[8]);
			add.setCountry(data[9]);
			add.setZipcode(Integer.parseInt(data[10]));
			cust.setAddress(add);
			customer.add(cust);
		}

		System.out.println("enter the input");
		String str = sc.nextLine();
		String[] arr = str.split(",");
		
		if(arr.length!=4)
			System.out.println("invalid input");
		Iterator<Customer> it = customer.iterator();
		int count = 0;
		while (it.hasNext()) {
			try {
				long id = Long.parseLong(arr[0]);
				flag = true;
			}catch(NumberFormatException e)
			{
				System.out.println("invalid input");
				break;
			}
			Customer cust = it.next();
			if (!map.containsKey(cust.getAddress().getCity()))
				map.put(cust.getAddress().getCity(), 1);
			else {
				int val = map.get(cust.getAddress().getCity());
				val += 1;
				map.put(cust.getAddress().getCity(), val);
			}
			if (cust.getId() == Long.parseLong(arr[0])) {
				System.out.println("\n"+cust.toString());
			}

			if (cust.getGender() == arr[2].charAt(0)) {
				count += 1;
			}
			String[] substr = arr[3].split("@");
			list.add(cust.getName());
			if (cust.getEmail().contains(substr[1])) {
				customerCount += 1;
				customerList.add(cust);
			}

		}
		while(flag)
		{
		if (!list.contains(arr[1].toLowerCase())) {
			System.out.println("\n"+ arr[1] + "-Customer name Not found");
		}
		if (arr[2].charAt(0) == 'M')
			System.out.println("\ntotal Number of males in the list:" + count);
		else if (arr[2].charAt(0) == 'F')
			System.out.println("\n total Number of females in the list:" + count);
		System.out.println("\nNumber of customers in the same company are:" + customerCount);
		Collections.sort(customerList, Comparator.comparingLong(Customer::getId));
		Iterator<Customer> iter = customerList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
		System.out.println("\ntotal customer city wise:");
		for(Entry<String,Integer> m:map.entrySet())
		{
			System.out.println(m.getKey()+"-"+m.getValue());
		}
		flag =false;
		}
	}

}
