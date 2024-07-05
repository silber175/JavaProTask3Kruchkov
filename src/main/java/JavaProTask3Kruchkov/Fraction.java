package JavaProTask3Kruchkov;

public class Fraction {
    private int num;
    private int denum;
    private double tmp;
    int count = 0;
    int countR = 0;

    public Fraction(int num, int denum)    {
        this.num = num;
        this.denum = denum;
    }
    public void setNum(int num)    {
        this.num = num;
    }

    public void setDenum(int denum)     {
        this.denum = denum;
    }

    public int getDenum(){
        return this.denum ;
    }

    public double doubleValue()    {
        //  System.out.println("выполнение расчета значения");
        count++;
        return (double) this.num/this.denum;
    }

    public double reverseValue()    {
        //   System.out.println("выполнение расчета значения");
        countR++;
        return (double) this.denum/this.num;
    }
}
