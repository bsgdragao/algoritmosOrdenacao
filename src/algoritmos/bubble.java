package algoritmos;

import java.text.DecimalFormat;
import java.util.Random;

class Bubble {

    public static void main(String[] args) {
        
        int array[] = new int[66666];
        Random r = new Random();
        
        for(int x=0; x < array.length; x++){
            array[x] = r.nextInt(9999)+1;
        }
        
        
        long inicio = System.currentTimeMillis();  
          
        bubbleSort(array);
        System.out.println("");
        
        long fim  = System.currentTimeMillis();
        double tempo = ( fim - inicio );
        
        tempo = tempo / 1000;
        DecimalFormat df = new DecimalFormat("#0.000");
          System.out.println("Tempo decorrido: " + df.format(tempo) + " segundos");
        
            

    }
    public static void bubbleSort(int[] array){     

        int aux;
        boolean ordenado;

        for (int i = 0; i < array.length; i++) {
            ordenado = true;
            for (int j = 0; j < (array.length - 1); j++) {

                if (array[j] > array[j + 1]) { 
                    aux = array[j]; 
                    array[j] = array[j + 1]; 
                    array[j + 1] = aux; 
                    ordenado = false;
                }
            }
            if (ordenado) {
                break;
            }

        }
        System.out.println("Algoritmo Bubble Sort:");
        for(int ordem : array){
            System.out.print(ordem + " ");
        }
    }
}
