package bucket;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Bucket {

    public static void main(String[] args) {
        int array[] = new int[10];
        Random r = new Random();

        for (int x = 0; x < array.length; x++) {
            array[x] = r.nextInt(99) + 1;
        }

        int bucket = array.length;

        long inicio = System.currentTimeMillis();

        bucketSort(array, bucket);
        System.out.println("");

        long fim = System.currentTimeMillis();
        double tempo = (fim - inicio);

        tempo = tempo / 1000;
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.println("Tempo decorrido: " + df.format(tempo) + " segundos");
    }

    private static void bucketSort(int[] array, int bucketSize) {
        
      
        // Cria o bucket array para armazenar as listas
        List<Integer>[] buckets = new List[bucketSize];
        // Lista vinculada com cada índice do bucket array
        // já que pode haver colisão de hash
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new LinkedList<>();
        }
        // calcular hash e atribuir elementos ao bucket referente
        for (int num : array) {
            buckets[hash(num, bucketSize)].add(num);
        }
        // ordena os buckets
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        // Une os buckets para gerar o array ordenado
        for (List<Integer> bucket : buckets) {

            for (int num : bucket) {
                array[index++] = num;
            }
        }
        //imprime na tela
        System.out.println("Algoritmo Bucket Sort:");
        for (int ordem : array) {
            System.out.print(ordem + " ");
        }
    }

    // função hash usada para distribuiçõ dos elementos no bucket 
    public static int hash(int num, int bucketSize) {
        return num / bucketSize;
    }

}
