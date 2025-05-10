package playground;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureCompleteDemo {

	public static void main(String[] args) {
		CompletableFuture
				// 1. Step 1: get user ID
				.supplyAsync(CompletableFutureCompleteDemo::fetchUserId)

				// 2. Step 2: fetch profile once ID is known
				.thenCompose(userId ->
						CompletableFuture.supplyAsync(() -> fetchProfile(userId))
				)

				// 3. Step 3: print welcome message
				.thenAccept(profile ->
						System.out.println("Welcome, " + profile.getName() + "!")
				)

				// 4. Error handling
				.exceptionally(ex -> {
					System.err.println("Something went wrong: " + ex.getMessage());
					return null;   // for thenAccept chain you must return null
				})

				// 5. Wait for everything to finish before exiting main
				.join();
	}

	// simulate I/O / blocking calls:
	static String fetchUserId() {
		sleep(300);
		return "user-123";
	}

	static Profile fetchProfile(String userId) {
		sleep(500);
		return new Profile(userId, "Alice");
	}

	static void sleep(int ms) {
		try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
	}

	// simple profile holder
	static class Profile {
		private final String id, name;
		Profile(String id, String name) { this.id = id; this.name = name; }
		String getName() { return name; }
	}
}
