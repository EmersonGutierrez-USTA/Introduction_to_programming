package usta.fis;
//AUTHOR: EMERSON GUTIERREZ
//DATE: 23-MARCH-2021
//DESCRIPTION: THIS SOFTWARE CALCULATES TIME (t=d/v) BETWEEN TWO CITIES
import com.sun.source.tree.BindingPatternTree;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
	p_show_info_program();
	float v_time = 0;
	int v_distance = p_user_distance();
	int v_velocity = p_user_velocity();
	v_time = v_distance/v_velocity;
	System.out.println("the time between two cities is"+ v_time +"hours");
    }
    public static void p_show_info_program(){
        //DATE: 23-MARCH-2021
        //DESCRIPTION: THIS METHOD SHOW THE INFO SOFTWARE
        System.out.println("-----------------------------------------------");
        System.out.println("SOFTIMECYCLE VERSION 1.0");
        System.out.println("MAKER:EMERSON GUTIERREZ");
        System.out.println("Description: CALCULATES TIME BETWEEN TWO CITIES");
        System.out.println("--------------------------------------------------");
    }
    public static int p_user_distance(){
        Scanner keyboard = new Scanner(System.in);
        int v_distance;
        System.out.println("input distance between two cities");
        v_distance = keyboard.nextInt();
        while (v_distance<0){
            System.err.println("ERR: the distance should be grater than zero, input distance between two cities");
            v_distance = keyboard.nextInt();
        }
        return v_distance;
    }
    public static int p_user_velocity(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("input the constance velocity (km/h) between two cities");
        int v_velocity = keyboard.nextInt();
        while (v_velocity==0){
            System.err.println("ERR: the velocity cannot be same zero input again the velocity (km/h)");
            v_velocity = keyboard.nextInt();
        }
        return v_velocity;
    }
}
