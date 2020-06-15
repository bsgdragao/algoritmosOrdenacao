package algoritmos;

import java.text.DecimalFormat;
import java.util.Random;

public class Quick {

       public static void main(String[] args) {
        int array[] = new int[9000];
        Random r = new Random();
        
        for(int x=0; x < array.length; x++){
            array[x] = r.nextInt(9999)+1;
        }
        long inicio = System.currentTimeMillis();
    
        quickSort(array, 0, array.length);
        
        System.out.println("Algoritmo Quick Sort:");
        for(int ordem : array){
            System.out.print(ordem + " ");
        }
        System.out.println("");
        
        long fim  = System.currentTimeMillis();
        double tempo = ( fim - inicio );
        
        tempo = tempo / 1000;
        DecimalFormat df = new DecimalFormat("#0.000");
          System.out.println("Tempo decorrido: " + df.format(tempo) + " segundos");
    }

    public static void quickSort(int[] valor, int inicio, int fim) {
        int i;
        int j;
        int pivo;
        int aux;
        i = inicio;
        j = fim - 1;
        pivo = valor[(inicio + fim) / 2];
        while (i <= j) {
            while (valor[i] < pivo && i < fim) {
                i++;
            }
            while (valor[j] > pivo && j > inicio) {
                j--;
            }
            if (i <= j) {
                aux = valor[i];
                valor[i] = valor[j];
                valor[j] = aux;
                i++;
                j--;
            }
        }
        if (j > inicio) {
            quickSort(valor, inicio, j + 1);
        }
        if (i < fim) {
            quickSort(valor, i, fim);
        }
    }

}
