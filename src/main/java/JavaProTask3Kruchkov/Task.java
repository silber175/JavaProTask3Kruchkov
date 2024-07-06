package JavaProTask3Kruchkov;

class Task implements Runnable {
    private int taskNumber;
    private int num;
    private int denum;
    public boolean busy;

    public Task(int taskNumber, int num, int denum) {
        this.taskNumber = taskNumber;
        this.num = num;
        this.denum = denum;
        busy = false;
    }

    public void run() {
        System.out.println("Task № "+taskNumber+"  Дробь "+this.num+"/"+this.denum+" = "+
                (new Fraction(this.num,this.denum)).doubleValue() );
    }
}