package co.edu.usta.arrays;

import java.util.Random;
import java.util.Scanner;

public class ArraysExample {
    public static void main(String[] args) {

        p_show_info_program();
        Scanner keyboard = new Scanner(System.in);
        float v_total=0;
        float [] v_vector= new float[3];
        float v_tamaño=v_vector.length;
        int v_limit = 0;

        int counter = 0 ;

        for ( counter=0; counter < v_vector.length ; counter++ ) {
            System.out.println("Porfavor dijite su calificacion del corte " + (counter+1));
            v_vector[counter]= keyboard.nextFloat();
            v_total=v_total+v_vector[counter];
        }
        for ( counter = 0; counter < v_limit; counter++){
            System.out.println("Su promedio es:" + counter + "es"+v_vector[counter]);
        }
        v_total=v_total/v_tamaño;
        System.out.println("El promedio de las notas es:" +v_total);


    }

    public static void p_show_info_program(){
        System.out.println("AUTHOR: EMERSON GUTIERREZ");
        System.out.println("DATE: 26/04/2021");
        System.out.println("DESCRIPTION: THIS SOFTWARE AVERAGES OUT N NUMBERS ");
    }
}






