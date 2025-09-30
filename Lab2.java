import java.util.*;
public class Lab2{
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int userChoice;
        while(true){
            System.out.println("\n1 - Task 1\n2 - Task 2\n3 - Exit Program");
            userChoice = scan.nextInt();
            try{
                switch(userChoice){
                    case 1:
                        Task1.task1_main();
                        break;
                    case 2:
                        Task2.task2_main();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Unknown func");
                        break;
                }
            }
            catch(InputMismatchException ex){
                System.out.println(ex);
            }
        }
    }
}
public class Task1{
    static Scanner scan = new Scanner(System.in);
    public static void task1_main(){
        System.out.println("Enter a number: ");
        long number = scan.nextLong();
        System.out.println("Number " + number + ": " + isUnique(number));
    }
    static boolean isUnique(long number){
        String str_number = intToString(number);
        // System.out.println("Length: " + str_number.length());
        for(int outer_i=0; outer_i < str_number.length(); outer_i++){
            for(int inner_i=outer_i+1; inner_i < str_number.length();inner_i++){
                if(str_number.charAt(outer_i)==str_number.charAt(inner_i)){
                    return false;
                }
            }
        }
        return true;
    }
    static String intToString(long number){
        return "" + number;
    }
}
public class Task2{
    static Scanner scan = new Scanner(System.in);
    static void task2_main(){
        System.out.println("Task 2:\n");
        System.out.println("Enter matrix size(NxN): ");
        int matrix_size = scan.nextInt();
        int[][] matrix = newIntMatrix(matrix_size);
        printMatrix(matrix);
        rotationMatrix(matrix);
        printMatrix(matrix);
    }
    public static void rotationMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] row : matrix){
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int[][] newIntMatrix(int matrix_size){
        int[][] tmp_matrix = new int[matrix_size][matrix_size];
        for(int i = 0; i < matrix_size; i++){
            for(int j = 0; j<matrix_size; j++){
                System.out.printf("\n: ");
                tmp_matrix[i][j] = scan.nextInt();
            }
        }
        return tmp_matrix;
    }
}