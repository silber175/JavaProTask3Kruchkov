package JavaProTask3Kruchkov;


import java.util.LinkedList;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreadPoolExecutor {
    private int threadCount ;
    private  LinkedList<Runnable> taskList;
    private ExecutorService threadPool;
    public ExecutorService getThreadPool()  {
        return this.threadPool;
    }
    public TreadPoolExecutor(int threadCount, LinkedList<Runnable> taskList) {
        this.threadCount = threadCount;
        this.taskList = taskList;
        threadPool = Executors.newFixedThreadPool(threadCount);

        Runnable task = taskList.poll();
        while (task != null)  {
            threadPool.execute(task);
            task = taskList.poll();
        }
        threadPool.shutdown();
    }
}


