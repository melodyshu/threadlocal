package com.example.thread;

/**
 * Hello world!
 *
 */
public class App2
{
    private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main( String[] args )
    {
        Thread[] threads=new Thread[5];
        for (int i=0;i<5;i++){
            threads[i]=new Thread(()->{
                int num=threadLocal.get();
                threadLocal.set(++num);
                System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
            },"Thread-"+i);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
