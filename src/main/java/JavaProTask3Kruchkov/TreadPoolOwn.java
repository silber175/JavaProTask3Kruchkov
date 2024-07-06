package JavaProTask3Kruchkov;


import java.util.ArrayList;
import java.util.LinkedList;

public class TreadPoolOwn {

    private LinkedList<Runnable> taskList = new LinkedList<Runnable>();
    private ArrayList<Thread>   threadList = new ArrayList<>(); // Если пользователю пула понадобится список потоков в пуле
    private boolean aviable = true;
    private int num = 1;
    private boolean threadJoin = false; // Завершение работы threads
    private boolean error_flag = false; // Флаг выбрасить рерывание
    Object monitor = new Object();

    public TreadPoolOwn(int threadCount) {

        for (int i=0; i < threadCount-1; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    synchronized (monitor) {
                        Runnable task = taskList.poll();
                        if (task != null) {
                            task.run();
                        }
                    }
                    if (error_flag && taskList.isEmpty()) {
                        error_flag = false; // чтобы прерывание не вызывалось на каждый поток
                        this.awatTermination();      // Перед прерыванием установим флаг
                        // завершения работы потоков, иначе в main до  вызова этого метода может не дойти
                        throw new  IllegalStateException("Выполнение потоков уже закрылось");
                    }
                    if((threadJoin) && (taskList.isEmpty())){   // Флаг завершения + список задач пустой
                        break;
                    }

                }
            }, "thread_"+num++);
            thread.start();
            threadList.add(thread);
        }
    }

    public void execute(Runnable task){
            // Добавили задачу в список задач
        if (aviable) {
            synchronized (monitor) {
                taskList.add(task);
            }
        }
        else
        {
            error_flag = true;
        }
    }

    public void shutdown() {
        aviable = false;
    }

    public void awatTermination()  {
        threadJoin = true;
    }

}


