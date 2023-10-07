package produtorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janine
 */
public class Consumidor implements Runnable {

    private Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        Double cont = 0.0;
        while (true) {
            if (!fila.estaVazio()) {
                fila.retirar();
                cont++;
                System.out.println("O consumidor "+Thread.currentThread().getName()+" retirou: "+cont);
                
            } else {
                fila.dormir_consumidor();
            }
            
        }
    }

}


//Thread.sleep(2000);
