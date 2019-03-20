package com.streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Test {

	public static void main(String[] args) {

		//Load Hobbit as TXT (make sure Hobbit.txt is at the root of your project)
		List<String> hobbit=new ArrayList<>();
		try(BufferedReader in=new BufferedReader(new FileReader("Hobbit.txt"))){
			String line=in.readLine();
			while(line!=null){
				StringTokenizer tokens=new StringTokenizer(line, " ");
				while(tokens.hasMoreTokens()){
					hobbit.add(tokens.nextToken().toLowerCase());
				}
				line=in.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println(hobbit.stream().count());
		//Distinct is like a Set - count without duplicates
		System.out.println(hobbit.stream().distinct().count());
		// Returns how many words length is > 4 and ignore duplicates
		System.out.println(hobbit.stream().distinct().filter(s->s.length()>4).count());
		System.out.println(hobbit.stream().distinct().filter(Test::isLongerThan4).count());

		// Returns true if 'yes' exist
		System.out.println(hobbit.stream().anyMatch(s->s.equals("yes")));
		// Returns true if all the Strings are 'yes'
		System.out.println(hobbit.stream().noneMatch(s->s.equals("yes")));
		// Returns true if none of the Strings are 'yes'
		System.out.println(hobbit.stream().allMatch(s->s.equals("yes")));
		
		// Returns longest word
		System.out.println(hobbit.stream().mapToInt(s->s.length()).max().getAsInt());
		// This is better String::length
		System.out.println(hobbit.stream().mapToInt(String::length).max().getAsInt());

	}


	public static boolean isLongerThan4(String value)
	{
		return value.length()>4;
	}
}
