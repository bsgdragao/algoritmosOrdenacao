package count;

import java.text.DecimalFormat;
import java.util.Random;

class Count {

    public static void main(String[] args) {

        int array[] = new int[50000];
        Random r = new Random();

        for (int x = 0; x < array.length; x++) {
            array[x] = r.nextInt(999999) + 1;
        }
        
        int size = array.length;
        
        long inicio = System.currentTimeMillis();

        countSort(array, size);
        System.out.println("");

        long fim = System.currentTimeMillis();
        double tempo = (fim - inicio);

        tempo = tempo / 1000;
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.println("Tempo decorrido: " + df.format(tempo) + " segundos");

    }


    public static void countSort(int array[], int size) {
        int[] output = new int[size + 1];

        // Encontra o maior elemento do Array
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] count = new int[max + 1];

        // Inicializa o Array com zeros
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        // Armazena o nº de vezes de cada elemento
        for (int i = 0; i < size; i++) {
            count[array[i]]++;
        }

        // Armazena a contagem acumulada de cada array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Encontra o índice de cada elemento da matriz original no array de contagem e
        // coloqua os elementos no array de saída
        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Salva os elementos ordenados dentro do array original
        System.arraycopy(output, 0, array, 0, size);

        System.out.println("Algoritmo Count Sort:");
        for (int ordem : array) {
            System.out.print(ordem + " ");
        }
    }

}
