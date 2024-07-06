package JavaProTask3Kruchkov;

import java.util.LinkedList;


public class Task3 {

    public static void main(String[] args) {

        TreadPoolOwn threadPool = new TreadPoolOwn(32); // Собственный пул

        // тестируем постановку задач на исполнение 1 порция
        for (int i = 1; i < 9; i++) {
            for (int n = 1; n < 9; n++) {
                threadPool.execute(new Task((i * n), i, n));
            }
        }

        // 2 порция
        for (int i = 10; i < 12; i++) {
            for (int n = 11; n < 13; n++) {
                threadPool.execute(new Task((i * n), i, n));
            }
        }

        threadPool.shutdown();

        // тестирование, что после shutdown задачи в очередь невозможно поставить
       for (int i = 13; i < 15; i++) {
            for (int n = 16; n < 17; n++) {
                threadPool.execute(new Task((i * n), i, n));
            }
        }

        // если до этого метода дошло, значит не было прерывания, ждем завершения потоков,
        // дойдем сюда, если предущую порцию задач если не грузить ,
        threadPool.awatTermination();

    }
}
