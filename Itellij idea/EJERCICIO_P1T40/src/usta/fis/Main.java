package usta.fis;
//AUTHOR: EMERSON GUTIERREZ
//DATE: 25-MARCH-2021
//DESCRIPTION: THUS SOFTWARE CALCULATE THE TOTAL MONEY SAVED IN YEAR
import  java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	p_show_info_program();
	int v_total_saved = 0;
        for (int i=1;i<=12;i=i+1) {
            System.out.println("----month"+i+"----");
            v_total_saved=v_total_saved+p_user_saved_money();
        }
        System.out.println("the total cave money is $"+v_total_saved);
    }
    public static void p_show_info_program(){
        //DATE: 23-MARCH-2021
        //DESCRIPTION: THIS METHOD SHOW THE INFO SOFTWARE
        System.out.println("---------------------------------------");
        System.out.println("SAVEMONEY VERSION 1.0");
        System.out.println("MAKER:EMERSON GUTIERREZ");
        System.out.println("DATE: 25-MARCH-2021");
        System.out.println("---------------------------------------");
    }
    public static int p_user_saved_money(){
        //Description: this method return the saved money in month
        Scanner keyboard = new Scanner(System.in);
        System.out.println("input teh saved money in the month (CO)$:");
        int v_saved_money = keyboard.nextInt();
        while (v_saved_money<0){
            System.out.println("ERR: YOU SAVED MONEY CANNOT BE LESS THAN ZERO, INPUT AGAIN THE SAVED MONEY (CO)$");
            v_saved_money = keyboard.nextInt();
        }
        return v_saved_money;
    }
}

