/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeMvsM;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author herna
 */
public class Main {

    private static String[][] tableroTicTacToe = new String[3][3];
    private static int contador = 0;//Numero de jugadas, el valor maximoq ue puede tomar es 9
    private static int turno = 0;//1= maquinaUno, 2=MaquinaDos
    private static int profundidad = 1;

    public static boolean buscarGanador(int j, int i) { //turno 1=jugador, 2=maquina; especifica de quien es el turno actual
        int posicionN = numeroBoton(j, i);
        String jugador = jugadorTurno();
        if (jugador.equals("X") || jugador.equals("O")) {
            //System.out.println("S: "+jugador);
            switch (posicionN) {//QUITAR LA VARIABLE 'GANADOR' Y HACER QUE RETORNE YA SEA TRUE O FALSE
                case 1:
                    if (tableroTicTacToe[j + 1][i].equals(jugador)) {
                        if (tableroTicTacToe[j + 2][i].equals(jugador)) {//HORIZONTAL
                            return true;
                        }
                    } else if (tableroTicTacToe[j][i + 1].equals(jugador)) {//VERTICAL
                        if (tableroTicTacToe[j].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j + 1][i + 1].equals(jugador)) {//DIAGONAL1 \
                        if (tableroTicTacToe[j + 2][i + 2].equals(jugador)) {
                            return true;
                        }
                    }
                    break;
                case 2:
                    if (tableroTicTacToe[j + 1][i].equals(jugador)) {//HORIZONTAL
                        if (tableroTicTacToe[j - 1][i].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j][i + 1].equals(jugador)) {//VERTICAL
                        if (tableroTicTacToe[j][i + 2].equals(jugador)) {
                            return true;
                        }
                    }
                    break;
                case 3:
                    if (tableroTicTacToe[j - 1][i].equals(jugador)) {//HORIZONTAL
                        if (tableroTicTacToe[j - 2][i].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j][i + 1].equals(jugador)) {//VERTICAL
                        if (tableroTicTacToe[j][i + 2].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j - 1][i + 1].equals(jugador)) {//DIAGONAL1 /
                        if (tableroTicTacToe[j - 2][i + 2].equals(jugador)) {
                            return true;
                        }
                    }
                    break;
                case 4:
                    if (tableroTicTacToe[j + 1][i].equals(jugador)) {//HORIZONTAL
                        if (tableroTicTacToe[j + 2][i].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j][i + 1].equals(jugador)) {//VERTICAL
                        if (tableroTicTacToe[j][i - 1].equals(jugador)) {
                            return true;
                        }
                    }
                    break;
                case 5:
                    if (tableroTicTacToe[j + 1][i].equals(jugador)) {//HORIZONTAL
                        if (tableroTicTacToe[j - 1][i].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j][i + 1].equals(jugador)) {//VERTICAL
                        if (tableroTicTacToe[j][i - 1].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j + 1][i - 1].equals(jugador)) {//DIAGONAL1 /
                        if (tableroTicTacToe[j - 1][i + 1].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j - 1][i - 1].equals(jugador)) {//DIAGONAL2 \
                        if (tableroTicTacToe[j + 1][i + 1].equals(jugador)) {
                            return true;
                        }
                    }
                    break;
                case 6:
                    if (tableroTicTacToe[j - 1][i].equals(jugador)) {//HORIZONTAL
                        if (tableroTicTacToe[j - 2][i].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j][i + 1].equals(jugador)) {//VERTICAL
                        if (tableroTicTacToe[j][i - 1].equals(jugador)) {
                            return true;
                        }
                    }
                    break;
                case 7:
                    if (tableroTicTacToe[j + 1][i].equals(jugador)) {//HORIZONTAL
                        if (tableroTicTacToe[j + 2][i].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j][i - 1].equals(jugador)) {//VERTICAL
                        System.out.println("x");
                        if (tableroTicTacToe[j][i - 2].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j + 1][i - 1].equals(jugador)) {//DIAGONAL /
                        if (tableroTicTacToe[j + 2][i - 2].equals(jugador)) {
                            return true;
                        }
                    }
                    break;
                case 8:
                    if (tableroTicTacToe[j + 1][i].equals(jugador)) {//HORIZONTAL
                        if (tableroTicTacToe[j - 1][i].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j][i - 1].equals(jugador)) {//VERTICAL
                        if (tableroTicTacToe[j][i - 2].equals(jugador)) {
                            return true;
                        }
                    }
                    break;
                case 9:
                    if (tableroTicTacToe[j - 1][i].equals(jugador)) {//HORIZONTAL
                        if (tableroTicTacToe[j - 2][i].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j][i - 1].equals(jugador)) {//VERTICAL
                        if (tableroTicTacToe[j][i - 2].equals(jugador)) {
                            return true;
                        }
                    } else if (tableroTicTacToe[j - 1][i - 1].equals(jugador)) {//DIAGONAL1 \
                        if (tableroTicTacToe[j - 2][i - 2].equals(jugador)) {
                            return true;
                        }
                    }
                    break;
            }
        }
        return false;
    }

    public static void imprimirTablero(String[][] tablero) {
        String tableroAux = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroAux += tablero[j][i];
            }
            tableroAux += "\n";
        }

        System.out.println(tableroAux);
        System.out.println("__________________________________");
    }

    public static boolean tableroLleno(String[][] tablero) {
        int aux = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String elemento = tablero[j][i];
                if (elemento.equals("X") || elemento.equals("O")) {
                    aux++;
                }
            }
        }
        if (contador == 9) {
            return true;
        } else {
            return false;
        }
    }

    public static void turnoAleatorio(int n) {
        switch (n) {
            case 1:
                turno = 1;
                JOptionPane.showMessageDialog(null, "Turno de la maquina1 'X'");
                //System.out.println("Turno de la maquina1 'X'");
                break;
            case 2:
                turno = 2;
                JOptionPane.showMessageDialog(null, "Turno de la maquina2 'O'");
                //System.out.println("Turno de la maquina2 'O'");
                break;
            case 3:
                turno = ((int) (Math.random() * 3 - 1) + 1);
                //System.out.println("-*Turno aleatorio*-");
                if (turno == 1) {
                    JOptionPane.showMessageDialog(null, "-*Turno aleatorio*-\nTurno de la maquina1 'X'");
                    //System.out.println("Turno de la maquina1 'X'");
                } else {
                    JOptionPane.showMessageDialog(null, "-*Turno aleatorio*-\nTurno de la maquina2 'O'");
                    //System.out.println("Turno de la maquina2 'O'");
                }
                break;
        }
    }

    public static String jugadorTurno() {
        String jugador = "";
        if (turno == 1) {
            jugador = "X";
        } else {
            jugador = "O";
        }
        return jugador;
    }

    public static void marcarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTicTacToe[j][i] = "-";
            }
        }
    }

    public static int numeroBoton(int j, int i) {
        int n = 0;
        if (j == 0 && i == 0) {
            n = 1;
        } else if (j == 1 && i == 0) {
            n = 2;
        } else if (j == 2 && i == 0) {
            n = 3;
        } else if (j == 0 && i == 1) {
            n = 4;
        } else if (j == 1 && i == 1) {
            n = 5;
        } else if (j == 2 && i == 1) {
            n = 6;
        } else if (j == 0 && i == 2) {
            n = 7;
        } else if (j == 1 && i == 2) {
            n = 8;
        } else if (j == 2 && i == 2) {
            n = 9;
        }
        //System.out.println("N: " + n);
        return n;
    }

    public static String[][] copiarArray(String[][] arrayOrigen) {
        String[][] arrayDestino = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrayDestino[j][i] = arrayOrigen[j][i];
            }
        }
        return arrayDestino;
    }

    public static String ganoPartida(String[][] tablero) {
        if (tablero[0][0] != "-" && tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]) {//Diagonal \
            //System.out.println("Gana: "+tablero[0][0]);
            return tablero[0][0];
        }
        if (tablero[0][2] != "-" && tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[0][2]) { //Diagonal /
            //System.out.println("Gana: "+tablero[0][2]);
            return tablero[0][2];
        }
        if (tablero[0][0] != "-" && tablero[0][0] == tablero[1][0] && tablero[0][0] == tablero[2][0]) { //Horizontal 1
            //System.out.println("Gana: "+tablero[0][2]);
            return tablero[0][0];
        }
        if (tablero[1][0] != "-" && tablero[1][0] == tablero[1][1] && tablero[1][0] == tablero[2][1]) { //Horizontal 2
            //System.out.println("Gana: "+tablero[0][2]);
            return tablero[1][0];
        }
        if (tablero[0][2] != "-" && tablero[0][2] == tablero[1][2] && tablero[0][2] == tablero[2][2]) { //Horizontal 3
            //System.out.println("Gana: "+tablero[0][2]);
            return tablero[0][2];
        }
        if (tablero[0][0] != "-" && tablero[0][0] == tablero[0][1] && tablero[0][0] == tablero[0][2]) { //Vertical 1
            //System.out.println("Gana: "+tablero[0][2]);
            return tablero[0][2];
        }
        if (tablero[1][0] != "-" && tablero[1][0] == tablero[1][1] && tablero[1][0] == tablero[1][2]) { //Vertical 2
            //System.out.println("Gana: "+tablero[0][2]);
            return tablero[1][0];
        }
        if (tablero[2][0] != "-" && tablero[2][0] == tablero[2][1] && tablero[2][0] == tablero[2][2]) { //Vertical 3
            //System.out.println("Gana: "+tablero[0][2]);
            return tablero[2][0];
        }

        //System.out.println("Nadie gana");
        return "-";
    }

    public static boolean finPartida(String[][] tablero) {
        if (tableroLleno(tablero) || ganoPartida(tablero) != "-") {
            //System.out.println("-Fin partida-");
            return true;
        } else {

            return false;
        }
    }

    public static int[] movimientoMaquina() {
        ArrayList<int[]> posicionesTablero = new ArrayList<int[]>();
        int datosPosicionTablero[] = new int[2];
        String[][] tablero = copiarArray(tableroTicTacToe);
        String jugador = jugadorTurno();//Retorna 'x' o 'o' 
        int filaJ = -1, columnaI = -1;
        int valor = Integer.MIN_VALUE;
        int auxiliar;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String elemento = tablero[j][i];
                if (elemento.equals("-")) {
                    tablero[j][i] = jugador;
                    auxiliar = minimo(tablero, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    System.out.println("J: " + j + ", I: " + i + ", Max: " + auxiliar + ", Valor: " + valor);
                    
                    if (auxiliar > valor) {
                        posicionesTablero.clear();
                        datosPosicionTablero[0] = j;
                        datosPosicionTablero[1] = i;
                        posicionesTablero.add(datosPosicionTablero);

                        valor = auxiliar;
                        filaJ = j;
                        columnaI = i;
                        System.out.println("Maximo");
                        System.out.println("J: " + j + ", I: " + i + ", Max: " + valor + ", Valor: " + auxiliar);
                    } else {
                        if (auxiliar == valor) {
                            System.out.println("Maximo igual");
                            datosPosicionTablero[0] = j;
                            datosPosicionTablero[1] = i;
                            posicionesTablero.add(datosPosicionTablero);
                        }
                    }
                    imprimirTablero(tablero);
                    tablero[j][i] = "-";
                }
            }
        }
        if (posicionesTablero.size() > 0) {
            int numero = ((int) (Math.random() * posicionesTablero.size() - 1) + 1);
            datosPosicionTablero = posicionesTablero.get(numero-1);
            filaJ = datosPosicionTablero[0];
            columnaI = datosPosicionTablero[1];
        }

        tableroTicTacToe[filaJ][columnaI] = jugador;
        int[] datos = {filaJ, columnaI};
        return datos;
    }

    public static int maximo(String[][] tablero, int prof, int a, int b) {
        String[][] tableroAux = copiarArray(tablero);
        if (finPartida(tableroAux)) {
            if (ganoPartida(tableroAux) != "-") {
                return puntos(tableroAux);
                //return 1;
            }
            return puntos(tableroAux);
            //return 0;
        }
        String jugador = jugadorTurno();//Retorna 'x' o 'o' 
        //int valor = Integer.MIN_VALUE;
        //int auxiliar;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tableroAux[j][i].equals("-")) {
                    tableroAux[j][i] = jugador;
                    a = max(a, minimo(tableroAux, prof + 1, a, b));
                    if (a >= b) {
                        return b;
                    }
                    tableroAux[j][i] = "-";
                }
            }
        }
        return a;
    }

    public static int minimo(String[][] tablero, int prof, int a, int b) {
        String[][] tableroAux = copiarArray(tablero);
        if (finPartida(tableroAux)) {
            if (ganoPartida(tableroAux) != "-") {
                return puntos(tableroAux);
            }
            return puntos(tableroAux);
        }
        String jugador = jugadorTurno();//Retorna 'x' o 'o' 
        String jugadorAux;
        if (jugador.equals("X")) { 
            jugadorAux = "0";
        } else {
            jugadorAux = "X";
        }
        //int valor = Integer.MAX_VALUE;
        //int auxiliar;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tableroAux[j][i].equals("-")) {
                    tableroAux[j][i] = jugadorAux;
                    b = min(b, maximo(tableroAux, prof + 1, a, b));
                    if (b <= a) {
                        return a;
                    }
                    tableroAux[j][i] = "-";
                }
            }
        }
        return b;
    }

    public static int puntos(String[][] tablero) {
        int utilidad = 0;
        if(turno==1){
             utilidad = utilidad(tablero, "X") - utilidad(tablero, "O");
        }else{
            utilidad = utilidad(tablero, "O") - utilidad(tablero, "X");
        }
        
        return utilidad;
    }

    public static int utilidad(String[][] tablero, String jugador) {
        int contadorFilasColumnasDiagonal = 0;
        String enemigo = "";

        if (jugador.equals("X")) {
            enemigo = "O";
        } else {
            enemigo = "X";
        }
        /*System.out.println(tablero[0][0] + " = " + jugador + " || = '-', 0,0");
        System.out.println(tablero[1][0] + " = " + jugador + " || = '-', 1,0");
        System.out.println(tablero[2][0] + " = " + jugador + " || = '-', 2,0");*/
        if (tablero[0][0].equals(jugador) || tablero[0][0].equals("-")) {//Horizontal 0
            if (tablero[1][0].equals(jugador) || tablero[1][0].equals("-")) {
                if (tablero[2][0].equals(jugador) || tablero[2][0].equals("-")) {
                    contadorFilasColumnasDiagonal++;
                }
            }
        }
        /* System.out.println("H0: " + contadorFilasColumnasDiagonal);
        System.out.println(tablero[0][1] + " = " + jugador + " || = '-' 0,1");
        System.out.println(tablero[1][1] + " = " + jugador + " || = '-', 1,1");
        System.out.println(tablero[2][1] + " = " + jugador + " || = '-' 2,1");*/
        if (tablero[0][1].equals(jugador) || tablero[0][1].equals("-")) {///Horizontal 1
            if (tablero[1][1].equals(jugador) || tablero[1][1].equals("-")) {
                if (tablero[2][1].equals(jugador) || tablero[2][1].equals("-")) {
                    contadorFilasColumnasDiagonal++;
                }
            }
        }
        /*System.out.println("H1: " + contadorFilasColumnasDiagonal);
        System.out.println(tablero[0][2] + " = " + jugador + " || = '-' 0,2");
        System.out.println(tablero[1][2] + " = " + jugador + " || = '-' 1,2");
        System.out.println(tablero[2][2] + " = " + jugador + " || = '-' 2,2");*/
        if (tablero[0][2].equals(jugador) || tablero[0][2].equals("-")) {//Horizontal 2
            if (tablero[1][2].equals(jugador) || tablero[1][2].equals("-")) {
                if (tablero[2][2].equals(jugador) || tablero[2][2].equals("-")) {
                    contadorFilasColumnasDiagonal++;
                }
            }
        }
        /*System.out.println("H2: " + contadorFilasColumnasDiagonal);
        System.out.println(tablero[0][0] + " = " + jugador + " || = '-' 0,0");
        System.out.println(tablero[0][1] + " = " + jugador + " || = '-' 0,1");
        System.out.println(tablero[0][2] + " = " + jugador + " || = '-' 2,0");*/
        if (tablero[0][0].equals(jugador) || tablero[0][0].equals("-")) {//Vertical 0
            if (tablero[0][1].equals(jugador) || tablero[0][1].equals("-")) {
                if (tablero[0][2].equals(jugador) || tablero[0][2].equals("-")) {
                    contadorFilasColumnasDiagonal++;
                }
            }
        }
        /*System.out.println("V0: " + contadorFilasColumnasDiagonal);
        System.out.println(tablero[1][0] + " = " + jugador + " || = '-' 1,0");
        System.out.println(tablero[1][1] + " = " + jugador + " || = '-' 1,1");
        System.out.println(tablero[1][2] + " = " + jugador + " || = '-' 2,1");*/
        if (tablero[1][0].equals(jugador) || tablero[1][0].equals("-")) {//Vertical 1
            if (tablero[1][1].equals(jugador) || tablero[1][1].equals("-")) {
                if (tablero[1][2].equals(jugador) || tablero[1][2].equals("-")) {
                    contadorFilasColumnasDiagonal++;
                }
            }
        }
        /*System.out.println("V1: " + contadorFilasColumnasDiagonal);
        System.out.println(tablero[2][0] + " = " + jugador + " || = '-' 2,0");
        System.out.println(tablero[2][1] + " = " + jugador + " || = '-' 2,1");
        System.out.println(tablero[2][2] + " = " + jugador + " || = '-' 2,2");*/
        if (tablero[2][0].equals(jugador) || tablero[2][0].equals("-")) {//Vertical 2     
            if (tablero[2][1].equals(jugador) || tablero[2][1].equals("-")) {
                if (tablero[2][2].equals(jugador) || tablero[2][2].equals("-")) {
                    contadorFilasColumnasDiagonal++;
                }
            }
        }
        /*System.out.println("V2: " + contadorFilasColumnasDiagonal);
        System.out.println(tablero[0][0] + " = " + jugador + " || = '-' 0,0");
        System.out.println(tablero[1][1] + " = " + jugador + " || = '-' 1,1");
        System.out.println(tablero[2][2] + " = " + jugador + " || = '-' 2,2");*/
        if (tablero[0][0].equals(jugador) || tablero[0][0].equals("-")) {//Diagonal \
            if (tablero[1][1].equals(jugador) || tablero[1][1].equals("-")) {
                if (tablero[2][2].equals(jugador) || tablero[2][2].equals("-")) {
                    contadorFilasColumnasDiagonal++;
                }
            }
        }
        /*System.out.println("D\\: " + contadorFilasColumnasDiagonal);
        System.out.println(tablero[1][1] + " = " + jugador + " || = '-'");
        System.out.println(tablero[0][2] + " = " + jugador + " || = '-'");
        System.out.println(tablero[2][0] + " = " + jugador + " || = '-'");*/
        if (tablero[0][2].equals(jugador) || tablero[0][2].equals("-")) {//Diagonal /
            if (tablero[1][1].equals(jugador) || tablero[1][1].equals("-")) {
                if (tablero[2][0].equals(jugador) || tablero[2][0].equals("-")) {
                    contadorFilasColumnasDiagonal++;
                }
            }
        }
        //System.out.println("D/: " + contadorFilasColumnasDiagonal);
        //System.out.println("FCD de "+jugador+": "+contadorFilasColumnasDiagonal);
        return contadorFilasColumnasDiagonal;
    }

    public static int utilidad2(String[][] tablero, String jugador) {
        int auxiliar = 0;
        if (tablero[0][0].equals(jugador) && tablero[1][0].equals(jugador) && tablero[2][0].equals(jugador)) {///Horizontal 1
            return 500;
        }
        if (tablero[0][1].equals(jugador) && tablero[1][1].equals(jugador) && tablero[2][1].equals(jugador)) {///Horizontal 2
            return 500;
        }
        if (tablero[0][2].equals(jugador) && tablero[1][2].equals(jugador) && tablero[2][2].equals(jugador)) {///Horizontal 3
            return 500;
        }
        if (tablero[0][0].equals(jugador) && tablero[0][1].equals(jugador) && tablero[0][2].equals(jugador)) {///Vertical 1
            return 500;
        }
        if (tablero[1][0].equals(jugador) && tablero[1][1].equals(jugador) && tablero[1][2].equals(jugador)) {///Vertical 2
            return 500;
        }
        if (tablero[2][0].equals(jugador) && tablero[2][1].equals(jugador) && tablero[2][2].equals(jugador)) {///Vertical 3
            return 500;
        }
        if (tablero[0][2].equals(jugador) && tablero[1][1].equals(jugador) && tablero[2][0].equals(jugador)) {///Diagonal / 1
            return 500;
        }
        if (tablero[0][0].equals(jugador) && tablero[1][1].equals(jugador) && tablero[2][2].equals(jugador)) {///Diagonal \ 2
            return 500;
        }

        return 0;
    }

    public static void main(String[] args) {
        /*int maximo = Integer.MIN_VALUE;
        int maximo2 = Integer.MAX_VALUE;
        System.out.println(maximo);
        System.out.println(maximo2);*/
        System.out.println("____________________________");
        System.out.println("TicTacToe Maquina vs Maquina");
        System.out.println("____________________________");
        marcarTablero();

        System.out.println("*****************************");
        imprimirTablero(tableroTicTacToe);
        System.out.println("*****************************");
        boolean ganador = false;
        boolean continua = true;
        while (turno == 0) {
            String mensaje = "Seleccione quien iniciara la partida\n1.- Maquina 1\n2.-Maquina 2\n3.-Aleatorio";

            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                if (opcion == 1 || opcion == 2 || opcion == 3) {
                    turnoAleatorio(opcion);
                } else {
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opcion no valida");
            }

        }
        while (continua) {//Tablero lleno o  ganador deja de correr
            int j = -1;
            int i = -1;
            int[] datos;
            switch (turno) {

                case 1:
                    datos = movimientoMaquina();
                    j = datos[0];
                    i = datos[1];
                    //tableroTicTacToe[j][i] = "X";
                    System.out.println("Insertado X: " + j + ", " + i);
                    ganador = buscarGanador(j, i);
                    if (ganador) {
                        JOptionPane.showMessageDialog(null, "Gana la maquina1 'X'");
                    }
                    turno++;
                    break;

                case 2:
                    datos = movimientoMaquina();
                    j = datos[0];
                    i = datos[1];
                    //tableroTicTacToe[j][i] = "O";
                    System.out.println("Insertado O: " + j + ", " + i);
                    ganador = buscarGanador(j, i);
                    if (ganador) {
                        JOptionPane.showMessageDialog(null, "Gana la maquina2 'O'");
                    }
                    turno--;
                    break;

            }
            System.out.println("*****************************");
            imprimirTablero(tableroTicTacToe);
            System.out.println("*****************************");
            contador++;
            if (ganador) {
                continua = false;
            }
            if (tableroLleno(tableroTicTacToe)) {
                JOptionPane.showMessageDialog(null, "Tablero lleno");
                continua = false;
            }
            i = -1;
            j = -1;
        }

    }
}
