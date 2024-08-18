package playground;

import java.util.List;
import java.util.stream.IntStream;

public class StreamsLoopsBenchmark {
	public static void main(String[] args) {
		List<Integer> numbers = IntStream.range(0, 1000000).boxed().toList();

		//Using loop
		long start = System.nanoTime();
		int sumLoop = 0;
		for (int num : numbers) {
			if (num % 2 == 0) {
				sumLoop += num;
			}
		}
		long end = System.nanoTime();
		System.out.println("Sum using loop: " + sumLoop + " Time taken: "+ (end - start));

		//Using stream
		start = System.nanoTime();
		int sumStream = numbers.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
		end = System.nanoTime();
		System.out.println("Sum using stream: " + sumStream + " Time taken: "+ (end - start));

	}
}
