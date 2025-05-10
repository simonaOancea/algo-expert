package playground;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

	public static void main(String[] args) {
		// A future that’s already done with a known value:
		CompletableFuture<String> cf = CompletableFuture.completedFuture("foo");

		// Run a Supplier in the common ForkJoinPool (non-blocking):
		CompletableFuture<Integer> cf2 =
				CompletableFuture.supplyAsync(CompletableFutureDemo::performSlowComputation);

		// Fire-and-forget a Runnable
		CompletableFuture<Void> cf3 =
				CompletableFuture.runAsync(CompletableFutureDemo::logSomethingExpensive);
	}

	private static void logSomethingExpensive() {
		System.out.println("Logging something expensive...");
	}

	private static int performSlowComputation() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 42;
	}
}
