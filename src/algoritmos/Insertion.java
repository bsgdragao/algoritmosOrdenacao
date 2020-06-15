package algoritmos;

import java.text.DecimalFormat;
import java.util.Random;

public class Insertion {

    public static void main(String[] args) {
        
        int array[] = new int[9000];
        
        Random r = new Random();
        
        for(int x=0; x < array.length; x++){
            array[x] = r.nextInt(9999)+1;
        }
        
        long inicio = System.currentTimeMillis();  
          
        insertionSort(array);
        System.out.println("");
        
        long fim  = System.currentTimeMillis();
        double tempo = ( fim - inicio );
        
        tempo = tempo / 1000;
          DecimalFormat df = new DecimalFormat("#0.000");
          System.out.println("Tempo decorrido: " + df.format(tempo) + " segundos");
        
        
    }
    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length ; i++) {
		int key = array[i];
		int j = i - 1;
		while (j >= 0 && key < array[j]) {
			int temp = array[j];
			array[j] = array[j + 1];
			array[j + 1] = temp;
			j--;
		}
	}
        System.out.println("Algoritmo Insertion Sort:");
        for (int ordem : array) {
            System.out.print(ordem + " ");
        }       
    }
 }

