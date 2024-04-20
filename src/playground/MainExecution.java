package playground;

public class MainExecution {
    public static void main(String[] args) {
        Task taskA = new TaskAImpl();
        Task taskB = new TaskBImpl();

        taskA.execute();
        taskB.execute();
    }
}
