package selection;

import java.text.DecimalFormat;
import java.util.Random;

public class Selection {

      public static void main(String[] args) {
     
        int array[] = new int[9000];
        Random r = new Random();
        
        for(int x=0; x < array.length; x++){
            array[x] = r.nextInt(9999)+1;
        }
        
        long inicio = System.currentTimeMillis();  
          
        selectionSort(array);
        System.out.println("");
        
        long fim  = System.currentTimeMillis();
        double tempo = ( fim - inicio );
        
          tempo = tempo / 1000;
          DecimalFormat df = new DecimalFormat("#0.000");
          System.out.println("Tempo decorrido: " + df.format(tempo) + " segundos");

    }
      public static void selectionSort(int[] array){
                  int i, j, minValue, minIndex, temp = 0;

	for (i = 0; i < array.length; i++) {
		minValue = array[i];
		minIndex = i;
		for (j = i; j < array.length; j++) {
			if (array[j] < minValue) {
				minValue = array[j];
				minIndex = j;
			}
		}
		if (minValue < array[i]) {
			temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

        System.out.println("Algoritmo Selection Sort:");
        for (int ordem : array) {
            System.out.print(ordem + " ");
        }
      }
}