package algoritmos;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Arvore {
    public static void main(String[] args) {

        
        int pos = 0;
        //criando o vetor
        int x = 15; //num de pos do vetor
        int[] vetor = new int[x];
        Random r = new Random();
        for(int i = 0; i < x; i++){
            vetor[i] = r.nextInt(50)+1;
        }
        //ordenando o vetor
        Arrays.sort(vetor);
        
        //imprimindo o vetor
        for(int valores : vetor){
            System.out.print(valores + " "); 
        }
        
        //estrutura ta arvore binaria
        int inicio, meio, fim;
        inicio = 0;
        fim = vetor.length -1;
        meio = (inicio + fim) / 2;
        
        Scanner s = new Scanner(System.in);
        System.out.print("\nDigite um número: ");
        int val = s.nextInt();
        

        //iteração da arvore binaria
        int voltas = 1;
        while(inicio <= fim){
         
        System.out.println("\nvolta " + voltas++);    
         
        meio = (inicio + fim) / 2;    
        //meio do vetor
        System.out.print("\nO nº do meio é: " + vetor[meio]);
        
       //decisao da árvore binária
            if(val == vetor[meio]){
                System.out.println("\nencontrou");
                break; 
            }else if(val > vetor[meio]){
                inicio = meio + 1;
                System.out.println("\n" + val + " é maior que o meio"
                 + " ele fica entre " + vetor[inicio] + " e " + vetor[fim]);
                System.out.println("");
            }else{
                fim = meio - 1;
                System.out.println("\n" + val + " é menor que o meio"
                 + " ele fica entre " + vetor[inicio] + " e " + vetor[fim]); 
            }
        }   
        
        System.out.println("");
    }
}
