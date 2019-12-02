package com.example.thread;

/**
 * Hello world!
 *
 */
public class App 
{
    private static int num=0;
    public static void main( String[] args )
    {
        Thread[] threads=new Thread[5];
        for (int i=0;i<5;i++){
            threads[i]=new Thread(()->{
                num++;
                System.out.println(Thread.currentThread().getName()+":"+num);
            },"Thread-"+i);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
