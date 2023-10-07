package jantarfilosofos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janine
 */
public class JantarFilosofos {

    public static void main(String[] args) {

        ArrayList<Filosofo> filosofos = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();
        Mesa mesa = new Mesa();

        for (int j = 0; j < 5; j++) {
            if (j < 4) {
                Filosofo filosofo = new Filosofo(mesa, j, j + 1);
                filosofos.add(filosofo);
            } else {
                Filosofo filosofo = new Filosofo(mesa, j, j - 4);
                filosofos.add(filosofo);
            }
        }
        for (Filosofo f : filosofos) {
            Thread th = new Thread(f);
            threads.add(th);
        }
        System.out.println("theads" + threads.toString());

        threads.forEach(th
                -> {
            th.start();
        });

        threads.forEach(th -> {
            try {
                th.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(JantarFilosofos.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
}
