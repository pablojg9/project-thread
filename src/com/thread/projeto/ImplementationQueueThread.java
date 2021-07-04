package com.thread.projeto;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementationQueueThread extends Thread{

    private static final ConcurrentLinkedQueue<RowThreadObject> DAUGHTER_PINE = new ConcurrentLinkedQueue<RowThreadObject>();

    public static void add(RowThreadObject row) {
        DAUGHTER_PINE.add(row);

    }

    @Override
    public void run() {
        System.out.println("Fila Rodando com sucesso!");

        Iterator<RowThreadObject> interator = DAUGHTER_PINE.iterator();

        synchronized (interator) { //Bloquear o acesso a está lista por outro pocessos!
            while(interator.hasNext()) {
                RowThreadObject process = interator.next();

                /** Processa 10 mil notas fiscais
                 * GERAR UMA LISTA ENORME DE PDFS
                 * GERAR UM ENVIO DE EMAIL PARA VARIAS PESSOAS.
                 * */

                System.out.println("--------------------------------------------------");

                System.out.println(process.getName());
                System.out.println(process.getEmail());

                interator.remove();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            Thread.sleep(1000); //Dar um tempo para descarga da memoria
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        super.run();
    }
}
