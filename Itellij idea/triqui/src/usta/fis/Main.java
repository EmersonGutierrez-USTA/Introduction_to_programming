package usta.fis;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String str = "1,1";
        str=str.replace(',','.');

        // convert into  Double
        double str1 = Double.valueOf(str);


        int index = 0, row = 0, column = 0; //Datos de matris
        String value = "";
        String optionselect= "";
        boolean IsWon = false;

        int i = 1;


        //Ya que el usuario puede realizar el procesos erroneo validaremos hasta que el valor
        //obtenido sea correcto
        do
        {
            try
            {


                 //Creo un espacio
                index = Integer.parseInt(JOptionPane.showInputDialog(null,"__________TRIKI___________\n" +
                        "Escriba de cuantas casillas quiere la tabla\n"+"De 3 o 5\n"));

                if (index != 3 && index != 5)
                {

                    JOptionPane.showMessageDialog(null,"⚠ Solo puede seleccionar 3 o 5");
                    i = 2;
                    continue; // lo retorno que seleccione
                }

                i = 1;

            }
            catch (RuntimeException e)
            {
                JOptionPane.showMessageDialog(null,"⚠ Solo puede agregar numeros valide ");
                i = 2;
            }

        } while (i == 2); // En caso tal que el proceso se realice mal  reinicia el proceso
       // JOptionPane.showMessageDialog(null,"El valor del index es igual a "+String.valueOf(index));
        String[][] CheckList = new String[index][index];

        //CheckList[0][0] = "x";
        //CheckList[0] [1] = "x";
        //CheckList[0][2] = "x";

        //CheckList[1] [0] = "o";
        //CheckList[1][1] = "o";
        //CheckList[1] [2] = "o";

        double[] cellsDiagonal = new double[index];
        double[] cellsOblicula = new double[index];


			/*Asignamos los valores
			 Iteraremos sobre los valores hasta se agreguen la linea oblicua y diagonal*/
			for (int cell = 0; cell < index; cell++)
			{
				// Selecciono la celda le agrego los valores diagonales
				if (cell == 0)
				{
					cellsDiagonal[cell] = 0.0;
				}
				else
				{   double valorredondeado = (double)Math.round((cellsDiagonal[cell - 1] + 1.1) * 100000d) / 100000d;


					cellsDiagonal[cell] = valorredondeado;
				}
			}

			for (int cell = index - 1; cell >= 0; cell--)
			{
				// Selecciono la celda le agrego los valores diagonales
				if (cell == index - 1)
				{
					cellsOblicula[cell] = cell;
				}
				else
				{
				    // Redondea el numero para que coincida con el indice

				    double valorredondeado = (double)Math.round((cellsOblicula[cell + 1] - 0.9) * 100000d) / 100000d;
					cellsOblicula[cell] = valorredondeado;

				}
			}
			// Validamos si quiere repetir el juegoin
        int repetir=0;
       //   do{// Valiso si el personage quiere volver a jugar

            do {
                try {
                    // concatena el valor y lo muestra en un formato de tabla
                    String strTable = "";
                    String strTableWithValues="";




                    //Mostramos la matrix

                    for (int f = 0; f < index; f++)
                    {
                        for (int c = 0; c < index; c++)
                        {
                            if (StringHelper.isNullOrEmpty(CheckList[f] [c]))
                            {
                                CheckList[f][c] = " ";
                            }
                            String values = String.join(" | ", CheckList[f][c]);

                            strTable = strTable+"| " + values + " |";
                        }
                        strTable = strTable + "\n";
                        for (int ce = 0; ce < index; ce++)
                        {
                            //Valor columna
                            String cellIndex = "";
                            if (ce == 0) cellIndex = String.valueOf(f);
                            else cellIndex = f + "." + ce;

                            String values = String.join(" | ", cellIndex);
                            if (ce == 0)
                                strTableWithValues = strTableWithValues + ("| " + values + "|");
                            else
                                strTableWithValues = strTableWithValues + (" | " + values + "| ");



                        }
                        strTableWithValues = strTableWithValues + "\n";
                    }
                    optionselect=(JOptionPane.showInputDialog(null,"TENGA EN CUENTA LO SIGUIENTE:\n"+
                            "Si el valor no esta en la tabla no pasara nada\n"+"_______________Tablas_________________\n"+strTable+
                            "\n " +strTableWithValues +"\n\n=> Digite la opcion que desea ejemplo(1.1) para comenzar a jugar !"));


                    //Obtengo el valor de la posision
                    optionselect.replace(',','.');


                    double validateValue = Double.parseDouble(optionselect);
                    if (validateValue > index || validateValue < 0)
                    {
                        JOptionPane.showMessageDialog(null,"Opcion no valida ");

                        i = 2;
                    }

                    // Valido que si haiga exixtencia de dato
                    if (StringHelper.isNullOrEmpty(optionselect))
                    {
                        JOptionPane.showMessageDialog(null,"Opcion no valida ");

                        i = 2;
                        continue;
                    }


                    //Valido los valores de la matrix
                    String[] op = optionselect.split("[.]",-1);
                    row = Integer.parseInt(op[0]);
                    if (op.length == 1)
                    {
                        column = 0;
                    }
                    else
                    {
                        column = Integer.parseInt(op[1]);
                    }

                    //Valido que no haya valor en la celda


                    if (!StringHelper.isNullOrEmpty(CheckList[row][column]) && !CheckList[row][column].equals(" "))
                    {
                        JOptionPane.showMessageDialog(null," Esta casilla ya a sido marcada");

                        i = 2;
                        continue;
                    }


                    //Obtengo el valor que  quiere marcar
                    value =JOptionPane.showInputDialog(null,"=> Despues la letra con la que esta jugando solo (x ,o o)");
                    //Valido la el valor seleccionado
                    if (!value.equals("x") && !value.equals("o"))
                    {
                        JOptionPane.showMessageDialog(null,"  Valor no valida");
                        i = 2;
                        continue;

                    }

                    CheckList[row][column] = value;




                    //Valido que halla ganado en fila
                    for (int c = 0; c < index; c++)
                    {

                        //Si todas son true el valor retornado sera que gano
                        if (CheckList[row][c].equals(value))
                        {
                            IsWon = true;
                        }
                        else
                        {
                            IsWon = false;

                            i = 2;
                            break;
                        }
                    }

                    //Ha ganado
                    if (IsWon)
                    {
                        i = 1;
                        JOptionPane.showMessageDialog(null,"Has ganado el jugador con la letra "+value);
                        continue;
                    }

                    //Valido que halla ganado en columna
                    for (int f = 0; f < index; f++)
                    {

                        //Si todas son true el valor retornado sera que gano

                        if (String.valueOf(CheckList[f][column].trim()).equals(value.trim()))
                        {
                            IsWon = true;
                        }
                        else
                        {
                            IsWon = false;
                            i = 2;
                            break;
                        }
                    }

                    //Ha ganado
                    if (IsWon)
                    {
                        JOptionPane.showMessageDialog(null,"Has ganado el jugador con la letra "+value);
                        i = 1;
                        continue;
                    }


                    //Valido que halla ganado en diagonal

                    for (int clsD = 0; clsD < cellsDiagonal.length; clsD++)
                    {
                        String strOp = String.valueOf(cellsDiagonal[clsD]);
                        String[] opction = strOp.split("[.]", -1);
                        row = Integer.parseInt(opction[0]);

                        if (opction.length == 1)
                        {
                            column = 0;
                        }
                        else
                        {
                            column = Integer.parseInt(opction[1]);
                        }

                        //Si todas son true el valor retornado sera que gano
                        if (CheckList[row][column].equals(value))
                        {
                            IsWon = true;
                        }
                        else
                        {
                            IsWon = false;
                            i = 2;
                            break;
                        }

                    }

                    if (IsWon)
                    {
                        JOptionPane.showMessageDialog(null,"Has ganado el jugador con la letra "+value);
                        i = 1;
                        continue;
                    }
                    //Valido que halla ganado en Obicua
                    for (int clsO = 0; clsO < cellsOblicula.length; clsO++)
                    {

                        String strOp = String.valueOf(cellsOblicula[clsO]);
                        String[] opction = strOp.split("[.]", -1);
                        row = Integer.parseInt(opction[0]);
                        if (opction.length == 1)
                        {
                            column = 0;
                        }
                        else
                        {
                            column = Integer.parseInt(opction[1]);
                        }

                        //Si todas son true el valor retornado sera que gano
                        if (CheckList[row][column].equals(value))
                        {
                            IsWon = true;
                        }
                        else
                        {
                            IsWon = false;
                            i = 2;
                            break;
                        }
                    }


                    if (IsWon)
                    {
                        JOptionPane.showMessageDialog(null,"Has ganado el jugador con la letra "+value);
                        i = 1;
                        continue;
                    }else
                    {
                        i=2;
                        continue;}


                }catch (Exception e){
                    i=2;
                    JOptionPane.showMessageDialog(null,"Solo se puede selecionar valores numericos");

                }

            }while (i==2);

       /*     try{
                String salir = JOptionPane.showInputDialog(null,"Si desea repetir el juego precione escriba [repetir]");
                if (salir.equals("repetir"))
                {

                    repetir=0;
                    //repetir triki
                    JOptionPane.showMessageDialog(null,"Repetir ");
                    CheckList= new String[index][index];
                    cellsDiagonal= new double[index];
                    cellsOblicula= new double[index];
                    IsWon=false;
                    continue;

                }


            }
            catch (Exception e)
            {
                repetir=1;
            }
               repetir=1;
        }while(repetir==0);*/






    }



}


final class StringHelper
{
    public static boolean isNullOrEmpty(String string)
    {
        return string == null || string.length() == 0;
    }



}
