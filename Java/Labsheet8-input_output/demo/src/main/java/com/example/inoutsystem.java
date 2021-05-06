package com.example;
import java.util.Scanner;

public class inoutsystem 
{
    public inoutsystem()
    {

    }   
    
    public void printhello()
    {
        System.out.print("hello");
    } 

    public void printwatitsay()
    {
        Scanner in = new Scanner(System.in);
        String whatitsay = in.nextLine();
        System.out.print(whatitsay);
        System.out.println("Hello");
        System.out.println("Hello1");
        System.out.println("Hello2");
        
        in.close();
    }

    public static void main(String[] args)
    {
        inoutsystem testrun = new inoutsystem();
        testrun.printwatitsay();
    }
}
