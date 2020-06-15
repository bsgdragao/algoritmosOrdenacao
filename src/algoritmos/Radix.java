package algoritmos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Radix {

    public static void main(String[] args) {

        int array[] = new int[10];
        Random r = new Random();

        for (int x = 0; x < array.length; x++) {
            array[x] = r.nextInt(99) + 1;
        }

        long inicio = System.currentTimeMillis();

        radixSort(array);
        System.out.println("");

        long fim = System.currentTimeMillis();
        double tempo = (fim - inicio);

        tempo = tempo / 1000;
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.println("Tempo decorrido: " + df.format(tempo) + " segundos");

    }

    public static void radixSort(int[] array) {
        final int RADIX = 10;

        // inicializa lista temporária
        List<Integer>[] temp = new ArrayList[RADIX];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = new ArrayList<>();
        }

        // ordena a lista
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;

            // divide o array em listas menores (LSD)
            for (Integer i : array) {
                tmp = i / placement;
                temp[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }

            // descarrega as listas dentro do array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : temp[b]) {
                    array[a++] = i;
                }
                temp[b].clear();
            }

            // muda par o próximo dígito (LSD)
            placement *= RADIX;
        }

        //imprime na terra
        System.out.println("Algoritmo Count Sort:");
        for (int ordem : array) {
            System.out.print(ordem + " ");
        }
    }

}
