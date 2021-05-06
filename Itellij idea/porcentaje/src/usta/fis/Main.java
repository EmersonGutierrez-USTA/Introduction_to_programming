package usta.fis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard= new Scanner(System.in);
        int counter=0;
        double v_sum=0;
        double v_first_percent=0.1;
        double v_second_percent=0.2+0.1;
        double v_third_percent=0.6;

        System.out.println("Digite la cantidad de cortes que cursa:");
        int v_cortes=keyboard.nextInt();
        while (v_cortes<=0){
            System.err.println("El numero de cortes ingresado no es correcto, vuelva a ingresarlo");
            v_cortes=keyboard.nextInt();
        }
        double [] v_array_grades=new double[v_cortes];

        System.out.println("Digite las notas de sus" + v_cortes + "corte");

        for (counter=0;counter<v_array_grades.length;counter++){
            v_array_grades[counter]=keyboard.nextFloat();
            v_sum = v_sum + v_array_grades[counter];
        }
        for (counter=0;counter<v_array_grades.length;counter++);{
            System.out.println("Su calificacion del corte" + (counter+1) + "es" +v_array_grades[counter]);
        }
        System.out.println("El porcentaje del primer corte es: " + v_array_grades[0]*v_first_percent);
        System.out.println("El porcentaje del segundo corte es: " + v_array_grades[1]*v_second_percent);
        System.out.println("El porcentaje del resto de los corteses: " +(v_third_percent/(v_array_grades.length-2)));
        System.out.println("La suma de sus notas es:" +v_sum);
        System.out.println("Y su promedio de notas es:" +p_exersice(v_sum,v_cortes));
        }
    public static double p_exersice(double v_result, int v_cortes){
        v_result=v_result/v_cortes;
        return  v_result;
    }


    }

