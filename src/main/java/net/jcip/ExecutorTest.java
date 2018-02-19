package net.jcip;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by liwanping on 2018-02-09
 */
public class ExecutorTest {
    private static final int NTHREADS = 100;
    private static final Executor exec
            = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("31232123213211321312");
            }
        };
        exec.execute(task);
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
