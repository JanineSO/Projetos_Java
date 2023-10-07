
package produtorconsumidor;

import java.util.ArrayList;

/**
 *
 * @author Janine
 */
public class ProdutorConsumidor {
    
    public static void main(String[] args) {
        
        Fila fila = new Fila(10);
        
        Produtor p = new Produtor(fila);
        
        Consumidor c = new Consumidor(fila);
        
        for (int i = 0; i < 20; i++) {
            new Thread(p).start();
            new Thread(c).start();
        }
    }
}
