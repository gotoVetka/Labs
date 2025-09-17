import java.util.*;
public class Lab1{
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        Task tasks = new Task();
        int userChoice;
        while(true){
            System.out.println("\n1 - Task 1\n2 - Task 2\n3 - Task 3\n4 - Task 4\n5 - Exit Program");
            userChoice = scan.nextInt();
            try{
                switch (userChoice) {
                    case 1:
                        tasks.task1();
                        break;
                    case 2:
                        tasks.task2();
                        break;
                    case 3:
                        tasks.task3();
                        break;
                    case 4:
                        tasks.task4();
                        break;
                    case 5:
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
public class Task{
    Scanner task_scan = new Scanner(System.in);
    public void task1(){
        for(int i=1; i <= 500; i++){
            System.out.printf("\nCase " + i + ": ");
            if(i%5==0){
                System.out.print("fizz");
            }
            if(i%7==0){
                System.out.print("buzz");
                continue;
            }
        }
    }
    public void task2(){
        System.out.println("\nEnter String: ");
        String string = task_scan.nextLine();
        System.out.println("");
        for(int i = string.length()-1; i>=0; --i){
            System.out.print(string.charAt(i));
        }
        System.out.println("");
    }
    public void task3(){
        int prev = 0;
        int cur = 1;
        int fut;
        System.out.println("\nIterations: ");
        int iter = task_scan.nextInt();
        System.out.println("");
        for (int i = 1; i <= iter; i++){
            System.out.print(cur + " ");
            fut = cur + prev;
            prev = cur;
            cur = fut;
        }
        System.out.println("");
    }
    public void task4(){
        int[] numbers = new int[3];
        for(int i = 0; i < numbers.length; i++){
            System.out.print("\n: " );
            numbers[i] = task_scan.nextInt();
        }
        System.out.println("Array: ");
        for(int a : numbers){
            System.out.print(a + " ");
        }
        System.out.println("");
        int arr_min=numbers[0];
        for(int cur_arr : numbers){
            if(arr_min>cur_arr)arr_min=cur_arr;
        }
        System.out.println("Minimun: " + arr_min);
        int max_multiplier = 0;
        arr_min = Math.abs(arr_min);
        for(int i = 1; i <= arr_min; i++){
            if(numbers[0]%i==0 && numbers[1]%i==0 && numbers[2]%i==0)max_multiplier=i;
        }
        System.out.println("Max multiplier: " + max_multiplier);
    }
}
