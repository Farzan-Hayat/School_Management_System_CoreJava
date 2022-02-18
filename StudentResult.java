package Farzan;

import java.util.Scanner;

public class StudentResult
{
    private float[] marks = new float[6];
    private float sum = 0, percent;

    public StudentResult()
    {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < marks.length; i++)
        {
            System.out.println("Subject "+(i+1)+": ");
            marks[i] = scan.nextFloat();
            sum += marks[i];
        }
        percent = ((sum / marks.length*100))*100;
        scan.close();
    }

    public float getSum() {
        return sum;
    }

    public float getPercent() {
        return percent;
    }
}
