package playground;

public class TestDeadlockResolved {
	String str1 = "str1";
	String str2 = "str2";

	Thread trd1 = new Thread("My Thread 1") {
		public void run() {
			while (true) {
				synchronized (str1) {
					synchronized (str2) {
						System.out.println(str1 + str2);
					}
				}
			}
		}
	};

	Thread trd2 = new Thread("My Thread 2") {
		public void run() {
			while (true) {
				synchronized (str1) { // acquire lock on str1 first
					synchronized (str2) { // then acquire lock on str2
						System.out.println(str2 + str1);
					}
				}
			}
		}
	};

	public static void main(String a[]) {
		TestDeadlock mdl = new TestDeadlock();
		mdl.trd1.start();
		mdl.trd2.start();
	}
}
