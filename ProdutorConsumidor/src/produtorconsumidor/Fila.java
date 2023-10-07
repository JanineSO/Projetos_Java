package produtorconsumidor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janine
 */
public class Fila {

    private double maximo;
    BlockingQueue<Double> fila;

    private final Object semaforoProdutor = new Object();
    private final Object semaforoConsumidor = new Object();

    public Fila(int maximo) {
        this.maximo = maximo;
        fila = new LinkedBlockingDeque<>(maximo);
    }

    public boolean estaCheio() {
        return fila.size() == maximo;
    }

    public boolean estaVazio() {
        return fila.isEmpty();
    }

    //O adicionar deveria está dentro de um while? Não
    public void adicionar(Double p) throws InterruptedException {
        try {
            fila.put(p);
        } catch (InterruptedException e) {
            System.out.println("Não foi possivel adicionar!");
        }
        
        synchronized (semaforoConsumidor) {
            semaforoConsumidor.notifyAll();
        }

    }
//put inserção de dados

    //Retirar deveria está dentro de um while? Não, por que?
    public double retirar() {
        double temp = 0;
//        synchronized (semaforoConsumidor) {
//            if (!estaVazio()) {
//                temp = fila.poll();
//            }
//
//        }
        try {
            if (!estaVazio()) {
            temp = fila.poll();
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel retirar!");
        }
        
        synchronized (semaforoProdutor) {
            semaforoProdutor.notifyAll();
        }

        return temp;
    }

    public void dormir_produtor() {
//        synchronized (semaforoProdutor) {
        try {
            synchronized (semaforoProdutor) {

                semaforoProdutor.wait();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void dormir_consumidor() {
//        synchronized (semaforoConsumidor) {
        try {
            synchronized (semaforoConsumidor) {
                semaforoConsumidor.wait();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
