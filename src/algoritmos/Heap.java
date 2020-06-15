package algoritmos;

import java.text.DecimalFormat;
import java.util.Random;

public class Heap {

    public static void main(String args[]) {
        int array[] = new int[9000];
        Random r = new Random();
        
        for(int x=0; x < array.length; x++){
            array[x] = r.nextInt(9999)+1;
        }
        
        long inicio = System.currentTimeMillis();  
          
        heapSort(array);
        System.out.println("");
        
        long fim  = System.currentTimeMillis();
        double tempo = ( fim - inicio );
        
          tempo = tempo / 1000;
          DecimalFormat df = new DecimalFormat("#0.000");
          System.out.println("Tempo decorrido: " + df.format(tempo) + " segundos");
    }

    public static void heapify(int[] array, int count) {
    
        int inicio = (count - 2) / 2; 
        while (inicio >= 0) {
            maxHeap(array, inicio, count - 1);
            inicio--;
        }
     
    }
    
    public static void maxHeap(int[] array, int inicio, int fim){
	
	int raiz = inicio;
	while((raiz * 2 + 1) <= fim){      
		int folha = raiz * 2 + 1;           
		
		if(folha + 1 <= fim && array[folha] < array[folha + 1])
			folha = folha + 1;          
		if(array[raiz] < array[folha]){     
			int tmp = array[raiz];
			array[raiz] = array[folha];
			array[folha] = tmp;
			raiz = folha;                
		}else
			return;
        }    
    }
    
    public static void heapSort(int[] array) {
        int count = array.length;
       
        heapify(array, count);
        int fim = count - 1;
        while (fim > 0) {
            int tmp = array[fim];
            array[fim] = array[0];
            array[0] = tmp;
            maxHeap(array, 0, fim - 1);
            fim--; 
        }
        System.out.println("Algoritmo Heap Sort:");
        for(int ordem : array){
            System.out.print(ordem + " ");
        }
    }
}
