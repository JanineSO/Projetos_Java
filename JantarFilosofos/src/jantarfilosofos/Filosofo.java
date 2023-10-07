package jantarfilosofos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janine
 */
public class Filosofo implements Runnable {//fluxo

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

    //estados dos filosofos como implementar ??? tem um sleep?
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

    //se filosofo estiver faminto -> pegar garfoE;
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
            //algo mais aqui no while????
        }
    }

//    public static void main(String[] args) {
//        //Filosofo[] filosos = {new Filosofo(), new Filosofo(), new Filosofo(), new Filosofo(), new Filosofo()};
//        ArrayList<Filosofo> filosofos = new ArrayList<Filosofo>();
//        Filosofo filosofo1 = new Filosofo(1);
//        filosofos.add(filosofo1);
//        Filosofo filosofo2 = new Filosofo(2);
//        filosofos.add(filosofo2);
//        Filosofo filosofo3 = new Filosofo(3);
//        filosofos.add(filosofo3);
//        Filosofo filosofo4 = new Filosofo(4);
//        filosofos.add(filosofo4);
//        Filosofo filosofo5 = new Filosofo(5);
//        filosofos.add(filosofo5);
//      
//        
//        
//        
//        ArrayList<Thread> threads = new ArrayList<Thread>();
//        Thread thread1 = new Thread(filosofo1);
//        threads.add(thread1);
//        Thread thread2 = new Thread(filosofo2);
//        threads.add(thread2);
//        Thread thread3 = new Thread(filosofo3);
//        threads.add(thread3);
//        Thread thread4 = new Thread(filosofo4);
//        threads.add(thread4);
//        Thread thread5 = new Thread(filosofo5);
//        threads.add(thread5);
//    }
}
