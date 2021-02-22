/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;




import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Pedro Toshiba
 * @version 1
 */

public class IO_ES {

    /**
     * *** Metodo para leer un entero
     *
     * @return devuelve un integer
     */
    public static int leerEntero() {
        int d = 0;
        boolean numeroValido = false;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("Introduzca un numero entero: ");

            try {
                d = Integer.parseInt(sc.nextLine());
                numeroValido = true;
            } catch (NumberFormatException e) {
                System.out.println("ERROR:  El numero introducido no es valido");
                numeroValido = false;
            }

        } while (!numeroValido);

        return d;
    }

    /**
     *  ** Metodo para devolver un entero con personalizacion de mensaje
     *
     * @param mensaje mensaje personalizado
     * @return delvuelve un integer
     */
    public static int leerEntero(String mensaje) {
        int d = 0;
        boolean numeroValido = false;
        Scanner sc = new Scanner(System.in);
        do {
        

            System.out.println(mensaje);

            try {
                d = Integer.parseInt(sc.nextLine());
                numeroValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un numero valido");
                numeroValido = false;
            }

        } while (!numeroValido);

        return d;
    }

    /**
     * **Metodo para leer un entero con mensaje personalizado y valor minimo
     * que se debe introducir
     *
     * @param mensaje mensaje personalizado
     * @param min paramatro para establecer un numero minimo que podamos
     * introducir
     * @return devuelve un entero
     */
    public static int leerEntero(String mensaje, int min) {
        int d = 0;
        boolean numeroValido = false;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println(mensaje);
            try {
                d = Integer.parseInt(sc.nextLine());
                if (min < d) {
                    System.out.println("Error: el numero no esta comprendido entre el numero ninimo");

                } else {
                    numeroValido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un numero valido");
                numeroValido = false;
            }
        } while (!numeroValido);

        return d;
    }

    /**
     * **Metodo para leer un entero con mensaje personalizado y valor minimo y
     * maximo que se debe introducir
     *
     * @param mensaje mensaje personalizado
     * @param min valor minimo que se puede introducir
     * @param max valor maximo que se puede introducir
     * @return devuelve un Integer
     */
    public static int leerEntero(String mensaje, int min, int max) {
        int d = 0;
        boolean numeroValido = false;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println(mensaje);

            try {
                d = Integer.parseInt(sc.nextLine());
                if (min <= d && max >= d) {
                    numeroValido = true;
                } else {
                    System.out.println("Error: el numero no esta comprendido entre la opcion minima y la maxima");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un numero valido");
                numeroValido = false;
            }
        } while (!numeroValido);

        return d;
    }

    /**
     * **Metodo para leer un long
     *
     * @return devuelve un lon
     */
    public static long leerLargo() {
        long d = 0;
        boolean numeroValido = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Introduzca un numero del tipo Long");
            try {
                d = Long.parseLong(sc.nextLine());
                numeroValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un numero valido");
                numeroValido = false;
            }
        } while (!numeroValido);

        return d;
    }

    /**
     * **Metodo para leer un long con mensaje personalizado
     *
     * @param mensaje mensaje personalizado
     * @return devuelve un long
     */
    public static long leerLargo(String mensaje) {
        long d = 0;
        boolean numeroValido = false;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println(mensaje);

            try {
                d = Long.parseLong(sc.nextLine());
                numeroValido = true;

            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un numero valido");
                numeroValido = false;
            }
        } while (!numeroValido);

        return d;
    }

    /**
     * Metodo para leer un numero flotante
     *
     * @return devuelve un numero de tipo float
     */
    public static float leerReal() {
        float d = 0;
        boolean numeroValido = false;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Introduce un numero de tipo Float:");
            try {
                d = Float.parseFloat(sc.nextLine());
                numeroValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un numero valido");
                numeroValido = false;
            }
        } while (!numeroValido);

        return d;
    }

    /**
     * Metodo para leer un numero flotante con mensaje personalizado
     *
     * @param mensaje mensaje personalizado
     * @return devuelve un float
     */
    public static float leerReal(String mensaje) {
        float d = 0;
        boolean numeroValido = false;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(mensaje);
            try {
                d = Float.parseFloat(sc.nextLine());
                numeroValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un numero valido");
                numeroValido = false;
            }
        } while (!numeroValido);

        return d;
    }

    /**
     * Metodo para leer un numero flotante con mensaje personalizado y valor
     * minimo predefinido
     *
     * @param mensaje mensaje personalizado
     * @param min parametro que defini el numero minimo que se puede introducir
     * @return devuelve un numero de tipo float
     */
    public static float leerReal(String mensaje, double min) {
        float d = 0;
        boolean numeroValido = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(mensaje);
            try {
                d = Float.parseFloat(sc.nextLine());
                if (min <= d) {
                    System.out.println("Error: El numero es mayor que el valor minimo por defecto");
                } else {
                    System.out.println("numero correcto");
                    numeroValido = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: debes introducir un numero valido.");
                numeroValido = false;
            }
        } while (!numeroValido);
        return d;
    }

    /**
     * Metodo para leer un numero de tipo double
     *
     * @return devuelve un numero de tipo double
     */
    public static double leerRealLargo() {
        double d = 0;
        boolean numeroValido = false;

        Scanner sc = new Scanner(System.in);
        do {
            try {
                d = Double.parseDouble(sc.nextLine());
                numeroValido = true;
            } catch (NullPointerException e) {
                System.out.println("El numero no es correcto");
                numeroValido = false;
            }
        } while (!numeroValido);

        return d;
    }

    /**
     * Metodo para leer un numero double con mensaje personalizado
     *
     * @param mensaje mensaje personalizado
     * @return devuelve un numero de tipo double
     */
    public static double leerRealLargo(String mensaje) {
        double d = 0;
        boolean numeroValido = true;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println(mensaje);
            try {

                d = Double.parseDouble(sc.nextLine());
                numeroValido = true;

            } catch (NullPointerException e) {
                System.out.println("Debes introducir un numero correcto");
                numeroValido = false;
            }

        } while (!numeroValido);

        return d;
    }

    /**
     * ** Metodo para leer una cadena lleva un mensaje pero es generico
     *
     * @return devuelve una cadena
     */
    public static String leerCadena() {
        String d = null;
        System.out.println("Introduce una cadena:");
        Scanner sc = new Scanner(System.in);
        d = sc.nextLine();
        System.out.println(d);

        return d;
    }

    /**
     * ** metodo para leer una cadena de texto y con un mensaje personalizado
     *
     * @param mensaje mensaje personalizado
     * @return devuelve una cadena
     */
    public static String leerCadena(String mensaje) {
        String d = null;
        System.out.println(mensaje);
        Scanner sc = new Scanner(System.in);
        d = sc.nextLine();
        //System.out.println(d);

        return d;
    }

    /**
     * *** metodo para leer una cadena de texto
     *
     * @param mensaje
     * @param longitud longitud es el paremetro que el usuario va a decir cuanto
     * de largo sera la cadena.
     * @return devuelve una cadena
     */
    public static String leerCadena(String mensaje, int longitud) {
        String d = null;
        boolean correcto = false;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(mensaje);
            d = sc.nextLine();
            if (d.length() == longitud) {
                correcto = true;
            } else {
                System.out.println("no es correcto la dimension");
                correcto = false;
            }
        } while (!correcto);

        

        return d;
    }

//**** Metodo para leer un char****
    /**
     *
     * @return char
     */
    public static char leerCaracter() {

        char caracter = 0;
        String cadena = null;
        boolean caracterValido = false;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Debes introducir un caracter");

            cadena = teclado.nextLine();
            caracterValido = true;

            if (cadena.length() != 1 || cadena.length() == 0) {

                System.out.println("Has introducido mas de un caracter o ninguno.");

            } else {

                caracter = cadena.charAt(0);
                caracterValido = true;

            }
        } while (!caracterValido);

        return caracter;

    }

//**** Metodo para leer un char con mensaje para el usuario*********************
    /**
     * Metodo para leer un char
     *
     * @param mensaje mensaje personalizado
     * @return char
     */
    public static char leerCaracter(String mensaje) {
        
        char caracter = 0;
        String cadena;
        boolean caracterValido = false;
        
        Scanner teclado = new Scanner(System.in);

        do {

            System.out.println(mensaje);

            cadena = teclado.nextLine();

            if (cadena.length() != 1 || cadena.length() == 0) {

                System.out.println("Has introducido ninguno o mas de un caracter.");
                //teclado.nextLine();

            } else {

                caracter = cadena.charAt(0);
                caracterValido = true;

            }
        } while (!caracterValido);

        return caracter;

    }

    /**
     *
     * @return
     */
    public static boolean leerBooleano() {

        boolean b = false;
        boolean booleanValido = false;
        String cadena;
        String cadenaRectificada;

        Scanner entrada = new Scanner(System.in);

        do {

            cadena = entrada.nextLine();
            cadenaRectificada = cadena.toLowerCase();
            if (cadenaRectificada.matches("si|s")) {
                System.out.println("El mensaje es si");
                b = true;
                booleanValido = true;

            } else if (cadenaRectificada.matches("no|n")) {

                System.out.println("El mensaje es no");
                b = false;
                booleanValido = true;
            } else {
                System.out.println("Debes escribir si o no");
            }

        } while (!booleanValido);

        return b;

    }

    /**
     * *
     *
     * @param mensaje mensaje personalizado
     * @return devuelve un booleano
     */
    public static boolean leerBooleano(String mensaje) {
        boolean b = false;
        boolean booleanValido = false;
        String cadena;
        String cadenaRectificada;
        Scanner entrada = new Scanner(System.in);

        System.out.println(mensaje);
        do {
            cadena = entrada.nextLine();
            cadenaRectificada = cadena.toLowerCase();
            if (cadenaRectificada.matches("si|s")) {
                b = true;
                booleanValido = true;
                System.out.println("El mensaje es si");

            } else if (cadenaRectificada.matches("no|n")) {

                System.out.println("El mensaje es no");
                b = false;
                booleanValido = true;
            } else {
                System.out.println("Debes escribir si o no");
            }

        } while (!booleanValido);

        return b;

    }

    /**
     *
     * @param mensaje Método que muestra un String por pantalla sin salto de
     * carro
     */
    public static void escribir(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * @param mensaje Método que muestra un String por pantalla con salto de
     * carro
     *
     *
     */
    public static void escribirLN(String mensaje) {
        System.out.println(mensaje);
    }
    
    public static String colorea(String msg) {
        String a = null;
        
        String red = "\033[31m"; // con este atributo cambiamos de color azul en la consola de comandos la frase que vaya seguida de el
        String reset = "\033[0m";//Con este atributo volvemos a cambiar el color a la frase que vaya precedida de el,con lo cual reseteamos a negro
        a =(red+msg+reset);
        
        return a;
    }
    
    //cree la clase BigInteger pesando que la iba a poder usar para trabajar con el CCC  del ejercicio validar cadenas y no ha sido asi, de todos modos la dejo aqui por si me hiciera falta
    /*
        static public BigInteger leerBigInt(String mensaje) {//Creamos este objeto para poder operar con el numero de cuenta, que al ser un numero de mas de 20 digitos necesita este formato
        BigInteger i = null;
        boolean numeroValido = false;

        do {

            Scanner sc = new Scanner(System.in);

            System.out.print(mensaje);
            String s = sc.nextLine();

            if (s != null) {
                try {
                    i = new BigInteger(s);
                    numeroValido = true;
                } catch (NumberFormatException e) {
                    System.out.println("ERROR:  El numero introducido no es válido");
                }
            } else {
                numeroValido = true; // Cancelado
            }
        } while (!numeroValido);

        return (BigInteger) i;
    }

        */
       /**
        * 
        * @param mensaje mensaje para poder personalizar un poco cada vez que se invoque el metodo podemos fijarle un mensaje predefinido
        * @param min numero minimo que vamos a establecer cuando estemos invocando al metodo
        * @param max numero maximo que vamos a establecer cuando estemos invocando al metodo
        * @return  devuelve un numero entero que se encuentre entre el min y el max
        */

 
    
    
}
