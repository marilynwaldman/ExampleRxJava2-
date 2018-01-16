package com.mdw;
import io.reactivex.schedulers.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            final TestProducer testProducer = new TestProducer(1, 1000);
            final TestConsumer testConsumer = new TestConsumer();
            testProducer
                    .subscribeOn(Schedulers.computation())
                    .observeOn(Schedulers.single())
                    .blockingSubscribe(testConsumer);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
