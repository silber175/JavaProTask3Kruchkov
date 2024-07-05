package JavaProTask3Kruchkov;

import java.util.LinkedList;


public class Task3 {
    public static void main(String[] args) {
        LinkedList<Runnable> taskList = new LinkedList<>();
        for (int ii = 1; ii < 9; ii++) {
            for (int jj = 1; jj < 9; jj++) {
                taskList.add(new Task((ii * jj), ii, jj));
            }
        }
        new TreadPoolExecutor(32, taskList);
    }
}
