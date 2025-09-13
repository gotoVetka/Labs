import java.util.*;
public class Lab1{
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int[] numbers = new int[3];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = scan.nextInt();
        }
        printArr(numbers, "Array:");
        int arr_min = findArrMin(numbers);  
        System.out.println("Minimun: " + arr_min);
        int max_multiplier = 0;
        arr_min = Math.abs(arr_min);
        for(int i = 1; i < arr_min+1; i++){
            if(numbers[0]%i==0 && numbers[1]%i==0 && numbers[2]%i==0)max_multiplier=i;
        }
        System.out.println("Max multiplier: " + max_multiplier);
    
    }
    public static void printArr(int[] arr, String toPrint){
        System.out.println(toPrint);
        for(int a : arr){
            System.out.print(a + " ");
        }
        System.out.println("");
    }
    public static int findArrMin(int[] arr){
        int min = arr[0];
        for(int cur_arr : arr){
            if(min>cur_arr)min=cur_arr;
        }
        return min;
    }
}
