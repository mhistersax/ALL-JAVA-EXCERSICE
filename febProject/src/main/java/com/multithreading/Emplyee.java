
package com.multithreading;


public class Emplyee extends Thread{
     void showData()
    {
        System.out.println("This is Employee Data!");
    }
    
    public void Run()
    {
        showData();
    }
}
