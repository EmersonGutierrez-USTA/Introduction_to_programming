package usta.fis;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        p_show_info_program();
        int v_serie=0;
       Scanner Keyboard = new Scanner(System.in);
	System.out.println("Digite el limite hasta el cual quiere llegar en la serie");
         v_serie = Keyboard.nextInt();
     int fibo_array[] = new int[100];
     fibo_array = serie_fibonacci(v_serie);
     System.out.println("la serie de fibonacci para el número" + v_serie + "es");
     for(int i = 0; i < v_serie; i++) {
         if (fibo_array[i] !=-1){
             System.out.println(fibo_array[i] + ", ");
         }
     }
    }
    private static void p_show_info_program(){
        System.out.println("SEIE FIBONACCI");
        System.out.println("AUTHOR: EMERSON GUTIERREZ");
        System.out.println("DESCRIPTION: THIS PROGRAM SHOWS THE FIBONACCI SEQUENCE");
    }
    public  static int[] serie_fibonacci(int v_limit){
        int fibo_array[]= new int[100];
        fibo_array[0]=0;
        fibo_array[1]=1;
        for (int i=1; (fibo_array[i-1] + fibo_array[i]) < v_limit; i++){
            fibo_array[i+1] = fibo_array[i-1] + fibo_array[i];
            fibo_array[i+2] = -1;
        }return fibo_array;
    }
}
