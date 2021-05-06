package usta.fis;
//NAME: Emerson Gutierrez
//DATE: 16/04/2021
//DESCRIPTION: This software calculates the addition, subtraction, multiplication, division between two numbers and
// checks if a number is prime also calculates the previous prime numbers of this number.

import java.util.Scanner;

public class Main {
    public  static void main(String[]args){
        int v_number_one = 0;
        int v_number_two = 0;
        int v_operation = 0;
        p_show_info_program();
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Por favor digite 1 para sumar, 2 para restar, 3 para multiplicar, 4 para dividr" +
                    ",5 para verificar si el numero es primo, 6 para calcular los numeros primos anteriores y 0 pra salir");
            v_operation = keyboard.nextInt();
            if (v_operation != 0){
                System.out.println("Por favor digite el numero uno");
                v_number_one = keyboard.nextInt();
                if (v_operation > 0 && v_operation < 5){
                    System.out.println("Por favor digite el numero dos");
                    v_number_two = keyboard.nextInt();
                }
            }
            System.out.println("El resultado es:"+ p_operate_numbers(v_number_one,v_number_two, v_operation));

        }while (v_operation != 0);
    }
    public static String p_operate_numbers(int v_number_one, int v_number_two, int v_operation){
        int v_result=0;
        String v_convert="";
        switch (v_operation){
            case 1:
                v_result=v_number_one+v_number_two;
                break;
            case 2:
                v_result=v_number_one-v_number_two;
                break;
            case 3:
                v_result=v_number_one*v_number_two;
                break;
            case 4:
                v_result=v_number_one/v_number_two;
                break;
            case 5:
                v_convert="No es numero primo";
                if (p_validate_prime(v_number_one)){
                    v_convert="Si es numero primo";
                }
                break;
            case 6:
                v_convert="Los numero primos son:" +p_prime_numbers(v_number_one);
                break;
            default:
                v_convert="Exit";
                System.exit(0);
        }
        if (v_convert.isEmpty()){
            v_convert=String.valueOf(v_result);
        }
        return v_convert;
    }
    public static String p_prime_numbers(int v_limit){
        String prime_numbers="";
        int p_pos_counter=0;
        int []int_prime_numbers=new int[100];
        for (int counter = 1; counter <= v_limit; counter++){
            if (p_validate_prime(counter)){
                prime_numbers=prime_numbers+String.valueOf(counter)+",";
                int_prime_numbers[p_pos_counter]=counter;
                p_pos_counter++;
            }
        }
        return prime_numbers;
    }
    public static boolean p_validate_prime(int v_number){
        int numbers_divide=0;
        for(int i=1;i<=v_number;i++){
            if (v_number%i ==0){
                numbers_divide++;
            }
        }
        if (numbers_divide!=2){
            return false;
        }
        return true;
    }
    public static void p_show_info_program(){
        System.out.println("-----------------------------------------------------");
        System.out.println("DESCRIPTION:Este software calcula la suma, resta, multiplicación, división entre dos números y " +
                           "comprueba si un número es primo también calcula los números primos anteriores de este número.");
        System.out.println("VERSION: 1.0");
        System.out.println("AUTHOR: Emerson Gutierrez");
        System.out.println("------------------------------------------------------");
    }
}






