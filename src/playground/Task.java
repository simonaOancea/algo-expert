package playground;

public abstract class Task {
     void execute() {
        long statingTimeOfExecution = System.currentTimeMillis();
        System.out.println("Starting the execution of execute method at " + statingTimeOfExecution);
         childExecute();
         long endingExecutionTime = System.currentTimeMillis();
         System.out.println("Ending time is: " + endingExecutionTime);
     }

     public void childExecute() {

         // the implementation

     }

     //


}
