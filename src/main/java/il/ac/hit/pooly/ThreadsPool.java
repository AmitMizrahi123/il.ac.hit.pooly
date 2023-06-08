package il.ac.hit.pooly;
import java.util.PriorityQueue;
import java.util.concurrent.*;

public class ThreadsPool {
    private final ExecutorService executorService;
    private final PriorityQueue<Task> taskQueue;

    public ThreadsPool(int numThreads) {
        this.executorService = Executors.newFixedThreadPool(numThreads);
        this.taskQueue = new PriorityQueue<>((t1, t2) -> t2.getPriority() - t1.getPriority());
    }

    public void submit(Task task) {
        taskQueue.offer(task);

        executorService.execute(() -> {
            Task nextTask;

            synchronized (taskQueue) {
                nextTask = taskQueue.poll();
            }

            while (nextTask != null) {
                nextTask.perform();

                synchronized (taskQueue) {
                    nextTask = taskQueue.poll();
                }
            }
        });
    }

    public void waitUntilAllTaskAreFinishes() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutDownExecutor() {
        this.executorService.shutdown();
    }
}
