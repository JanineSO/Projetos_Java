package jantarfilosofos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janine
 */

public class Filosofo implements Runnable {

    private String estado;
    private Mesa mesa;
    private int garfoEsq;
    private int garfoDir;

    public Filosofo(Mesa mesa, int garfoEsq, int garfoDir) {
        this.mesa = mesa;
        this.garfoEsq = garfoEsq;
        this.garfoDir = garfoDir;
    }

   
    private Filosofo(int i) {
        
    }
    
    public void pensando() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void comendo() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {//loop infinito -> enquanto for verdadeiro, faça. true = a sempre verdadeiro
            System.out.println("Estar pensando!"+Thread.currentThread().getId());
            pensando();
            System.out.println("Ele está faminto!"+Thread.currentThread().getId());
            Garfo garfoTempE = mesa.pegarGarfo(garfoEsq);
            if (garfoTempE != null) {
                System.out.println("Ele pegou o garfo esquerdo!");
                Garfo garfoTempD = mesa.pegarGarfo(garfoDir);
                if (garfoTempD != null) {
                    System.out.println("Ele pegou o garfo direito!");
                    comendo();
                    mesa.soltarGarfo(garfoTempD, garfoDir);
                    mesa.soltarGarfo(garfoTempE, garfoEsq);
                } else {
                    System.out.println("Ele não pegou o garfo direito!");
                    mesa.soltarGarfo(garfoTempE, garfoEsq);
                    System.out.println("Ele devolveu o garfo esquerdo.");
                    System.out.println("Tentará pegar os garfos novamente mais tarde!");
                }
            } else {
                System.out.println("Ele não pegou o garfo esquerdo!");
                System.out.println("Tentará pegar os garfos novamente mais tarde!");
            }
        }
    }
}
