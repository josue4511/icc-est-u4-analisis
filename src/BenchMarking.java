
import java.util.concurrent.Callable;


import models.Results;

public class BenchMarking {
    
    public static Results medirTiempos(Callable <Void> funcion) {
        try {
            long inicio = System.nanoTime();
            funcion.call();

            long fin=System.nanoTime();
            long duracion = fin - inicio;
            Results results = new Results(duracion);
            return results;
            
        } catch (Exception e) {
            throw new RuntimeException("Error en la funcion");
        //System.out.println("Error en la funcion");
        }
        //return null;
        
    }


}