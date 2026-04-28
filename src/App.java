import java.util.Arrays;
import java.util.concurrent.Callable;

import controllers.SortMethods;
import models.Results;

public class App {
    public static void main(String[] args) throws Exception {
        SortMethods metodos = new SortMethods();
        int tamanio = 1000;
        int[] array = generate ( 1000);
        int[] arrayBubble = Arrays.copyOf(array, tamanio);
        int[] arrayBubbleAvz = Arrays.copyOf(array, tamanio);

        Callable<Void> miFuncionBubble = ()->{
            metodos.sortBubble(arrayBubble);
            return null;
        };
        Callable<Void> miFuncionBubbleAvz = ()->{
            metodos.sortBubble(arrayBubbleAvz);
            return null;
        };
        Results resultsBubble = BenchMarking.medirTiempos(miFuncionBubble);
        System.out.println("Burbuja" + resultsBubble.getTimeResults());

        Results resultsBubbleAvz = BenchMarking.medirTiempos(miFuncionBubbleAvz);
        System.out.println("Burbuja" + resultsBubbleAvz.getTimeResults());
    }

    public static int[] generate(int size){
        int[] numeros = new int[size];
        for (int i = 0; i < size; i++){
            numeros[i] = (int) (Math.random()*1000);

        }
        return numeros;
    }

}
