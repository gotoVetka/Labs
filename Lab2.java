import java.util.*;
public class Lab2{
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        
        int userChoice;
        while(true){
            System.out.println("\n1 - Task 1\n2 - Task 2\n3 - Exit Program");
            userChoice = scan.nextInt();
            try{
                switch (userChoice) {
                    case 1:
                        task1_main();
                        break;
                    case 2:
                        task2_main();
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
public class Task1 extends Lab2{
    void task1_main(){
        System.out.println("Task 1:\n");
    }
}
public class Task2 extends Lab2{
    void task2_main(){
        System.out.println("Task 2:\n");
    }

}
