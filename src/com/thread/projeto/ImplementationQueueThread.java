package com.thread.projeto;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementationQueueThread extends Thread{

    private static ConcurrentLinkedQueue<RowThreadObject> DAUGHTER_PINE =
            new ConcurrentLinkedQueue<RowThreadObject>();

    public static void add(RowThreadObject row) {
        DAUGHTER_PINE.add(row);

    }

    @Override
    public void run() {
        Iterator interator = DAUGHTER_PINE.iterator();
        while(interator.hasNext()) {
            RowThreadObject process = (RowThreadObject) interator.next();



        }

        super.run();
    }
}
