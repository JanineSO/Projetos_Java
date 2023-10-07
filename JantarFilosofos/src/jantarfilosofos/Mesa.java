package jantarfilosofos;

import java.util.ArrayList;


/**
 *
 * @author Janine
 */
public class Mesa {
     
     //Filosofo[] filosos = {new Filosofo(), new Filosofo(), new Filosofo(), new Filosofo(), new Filosofo()};

    Garfo[] garfos = {new Garfo(),new Garfo(), new Garfo(), new Garfo(), new Garfo()};

    public Mesa() {
    }
       
    public synchronized Garfo pegarGarfo(int index) {
        Garfo garfoTemp = garfos[index];
        garfos[index] = null; 
        return garfoTemp;
    }
    
    public synchronized void soltarGarfo(Garfo garfo, int index){
        garfos[index] = garfo;
    
    }
    
}
