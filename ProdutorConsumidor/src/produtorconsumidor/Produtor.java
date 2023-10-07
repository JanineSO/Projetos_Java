package produtorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Produtor implements Runnable {

    private Fila fila;
   
    
        public Produtor(Fila fila ) {
        this.fila = fila;
       
    }

    @Override
    public void run() {
        Double cont = 0.0;
        while (true) {
            
            if (!fila.estaCheio()) {
                try {
                    cont++;
                    fila.adicionar(cont);
                    
                    System.out.println("O produtor "+Thread.currentThread().getName()+" adicionou: "+cont);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                fila.dormir_produtor();
            }
        }
    }

}
