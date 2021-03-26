package USTA.FIS;

import java.util.Scanner;

//AUTHOR: EMERSON GUTIERREZ - EDISON RAMIREZ - DANIEL BERNAL
//DATE: 2021-MARCH-26
//DESCRIPTION: THIS PROGRAM CALCULATES THE AVERAGE HEIGHT OF FIVE YEAR OLD CHILDREN
public class Main {

    public static void main(String[] args) {
	System.out.println("----------------------------------------------------------------------");
        System.out.println("Hello teacher");
        System.out.println("SOFT HEIGHT: VERSION 1.0");
        System.out.println("MAKER: EMERSON GUTIERREZ - EDISON RAMIREZ - DANIEL BERNAL");
        System.out.println("THIS PROGRAM CALCULATES THE AVERAGE HEIGHT OF FIVE YEAR OLD CHILDREN");
        System.out.println("-------------------------------------------------------------------");

        Scanner r= new Scanner(System.in);
        float height1;
        float height2;
        float height3;
        float height4;
        float height5;
        float average;
        System.out.println("input the first height");
        height1 = r.nextInt();
        System.out.println("input the second height");
        height2 = r.nextInt();
        System.out.println("input the third height");
        height3 = r.nextInt();
        System.out.println("input the fourth height");
        height4 = r.nextInt();
        System.out.println("input the fifth height");
        height5 = r.nextInt();
        while (height1<50,height1>200,height2<50,height2>200,height3<50,height3>200,height4<50,height4>200,height5<50,height5>200){
            System.err.t.println("ERR: NONE OF THE HEIGHTS CAN BE LESS TAHN 50 OR GREATER THAN 200, INPU AGAIN");
            height1 = r.nextInt();
            height2 = r.nextInt();
            height3 = r.nextInt();
            height4 = r.nextInt();
            height5 = r.nextInt();
        }
        return average;
        average = (height1 + height2 + height3 + height4 + height5);
        System.out.println("te average height is"+" "+average);


    }
}
