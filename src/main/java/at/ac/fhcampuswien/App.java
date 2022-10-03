package at.ac.fhcampuswien;

import java.util.Collections;
import java.util.Scanner;

public class App {

    //todo Task 1
    public void largestNumber(){
        int i = 1;
        double n=0, input=1;
        Scanner sc = new Scanner(System.in);
        while(input>0){
            System.out.printf("Number %d: ", i++);
            input = sc.nextDouble();
            if (input > n) n = input;
        }
        if(n==0) System.out.println("No number entered.");
        else System.out.printf("The largest number is %.2f%n", n);
        sc.close();
    }

    //todo Task 2
    public void stairs(){
        Scanner sc = new Scanner(System.in);
        System.out.print("n: ");
        int rows = sc.nextInt();
        sc.close();
        if (rows<0) {
            System.out.println("Invalid number!");
            return;
        }
        int n = 1;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < i+1; j++){
                System.out.printf("%d ", n++);
            }
            System.out.println();
        }
    }

    //todo Task 3
    public void printPyramid(){
        final int ROWS = 6;
        for (int i = 0; i < ROWS; i++){
            //https://www.geeksforgeeks.org/collections-ncopies-java/
            System.out.print(String.join("", Collections.nCopies(ROWS-1-i, " ")));
            for(int j = 0; j < i*2+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //todo Task 4
    public void printRhombus(){
        int h;
        char c;
        Scanner sc = new Scanner(System.in);
        System.out.print("h: ");
        h = sc.nextInt();
        System.out.print("c: ");
        c = sc.next().charAt(0);
        if(h%2==0) {
            System.out.println("Invalid number!");
            return;
        }
        for(int i = 0; i < h; i++){
            int chars = i<=h/2 ? i*2+1 : (h-i-1)*2+1;
            System.out.print(String.join("", Collections.nCopies((h-chars)/2, " ")));
            for(int j = 0; j < chars; j++){
                char nc = (char) (j<=chars/2 ? c-(chars/2-j) : c-(j-chars/2));
                System.out.print(nc);
            }
            System.out.println();
        }
    }

    //todo Task 5
    public void marks(){
        int num=0, negative=0, i=0;
        double sum = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.printf("Mark %d: ", i+1);
            num = sc.nextInt();
            if(num == 0) break;
            if(num > 5 || num < 0) {
                System.out.println("Invalid mark!");
                continue;
            }
            sum+=num;
            i++;
            if(num == 5) negative++;
        }
        System.out.printf("Average: %.2f%nNegative marks: %d%n", i>0 ? sum/i: sum, negative);
        sc.close();
    }

    //todo Task 6
    public void happyNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.print("n: ");
        int n = sc.nextInt();
        while(n != 1 && n != 4){
            int temp = n;
            int sum = 0;
            while (temp > 0){
                int remainder = temp%10;
                sum+=(remainder*remainder);
                temp /= 10;
            }
            n = sum;
        }
        if(n==1) System.out.println("Happy number!");
        else System.out.println("Sad number!");
        sc.close();
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}