package merge;

import java.text.DecimalFormat;
import java.util.Random;

class Merge {

  public static void main( String args[] ) {
        int array[] = new int[9000];
        Random r = new Random();
        
        for(int x=0; x < array.length; x++){
            array[x] = r.nextInt(9999)+1;
        }
        long inicio = System.currentTimeMillis(); 
        
        mergeSort(array,array.length);
        
       System.out.println("Algoritmo Heap Sort:");
        for(int ordem : array){
            System.out.print(ordem + " ");
        }
        
        long fim  = System.currentTimeMillis();
        double tempo = ( fim - inicio );
        
          tempo = tempo / 1000;
          DecimalFormat df = new DecimalFormat("#0.000");
          System.out.println("\nTempo decorrido: " + df.format(tempo) + " segundos");
    }
  
    public static void merge(int[] left_arr,int[] right_arr, int[] arr,int left_size, int right_size){
      
      int i=0,l=0,r = 0;
      //The while loops check the conditions for merging
      while(l<left_size && r<right_size){
          
          if(left_arr[l]<right_arr[r]){
              arr[i++] = left_arr[l++];
          }
          else{
              arr[i++] = right_arr[r++];
          }
      }
      while(l<left_size){
          arr[i++] = left_arr[l++];
      }
      while(r<right_size){
        arr[i++] = right_arr[r++];
      }
  }

  public static void mergeSort(int [] arr, int len){
      if (len < 2){return;}
      
      int mid = len / 2;
      int [] left_arr = new int[mid];
      int [] right_arr = new int[len-mid];
      
    //Dividing array into two and copying into two separate arrays
      int k = 0;
      for(int i = 0;i<len;++i){
          if(i<mid){
              left_arr[i] = arr[i];
          }
          else{
              right_arr[k] = arr[i];
              k = k+1;
          }
      }
      //Recursivamente chamando a funçãi para dividir os sub arrays
      mergeSort(left_arr,mid);
      mergeSort(right_arr,len-mid);
      //chamando o metodo de mescla em cada sub divisao
      merge(left_arr,right_arr,arr,mid,len-mid);
  }
}

