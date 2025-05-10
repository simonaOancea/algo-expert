package playground;

import java.util.*;
import java.util.stream.*;

public class LambdaDemo {
	public static void main(String[] args) {
		// 1) Sort a list of words by length
		List<String> words = new ArrayList<>(List.of("apple", "fig", "banana", "kiwi"));
		words.sort((a, b) -> Integer.compare(a.length(), b.length()));
		System.out.println("Sorted by length: " + words);
		// → [fig, kiwi, apple, banana]

		// 2) Filter out odd numbers
		List<Integer> nums = IntStream.rangeClosed(1, 10)
				.boxed()
				.toList();
		List<Integer> evens = nums.stream()
				.filter(n -> n % 2 == 0)
				.toList();
		System.out.println("Evens: " + evens);
		// → [2, 4, 6, 8, 10]

		// 3) Uppercase all names in a roster
		class Person {
			String name; int age;
			Person(String name, int age) { this.name = name; this.age = age; }
			String getName() { return name; }
		}
		List<Person> roster = List.of(
				new Person("Alice", 23),
				new Person("Bob",   31),
				new Person("Carol", 27)
		);
		List<String> upperNames = roster.stream()
				.map(Person::getName)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println("Names uppercased: " + upperNames);
		// → [ALICE, BOB, CAROL]

		// 4) Inline Runnable with no parameters
		new Thread(() -> System.out.println("Hello from a thread!"))
				.start();

		// 5) Combine filter, sort, print in one chain
		List<String> emails = List.of(
				"alice@example.com",
				"bob@gmail.com",
				"carol@example.com",
				"dave@hotmail.com"
		);
		emails.stream()
				.filter(e -> e.endsWith("@example.com"))
				.map(String::toUpperCase)
				.sorted()
				.forEach(System.out::println);
	}
}
