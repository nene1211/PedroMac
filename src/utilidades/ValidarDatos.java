/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pedro
 */
public class ValidarDatos {

    public static boolean validarDocumento(String documento) {
        boolean valido = false;
        String documentoRectificado;
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letraNif = ' ';
        char letraNie = ' ';
        int digitoNif = 0;
        int digitoNie = 0;

        documentoRectificado = documento.toUpperCase();
        //System.out.println(documentoRectificado);
        Pattern patron = Pattern.compile("^[0-9ZYZ]{1}[0-9]{7}[TRWAGMYFPDXBNJZSQVHLCKE]{1}$");
        Matcher mat = patron.matcher(documentoRectificado);
        if (mat.find()) {
            if (documentoRectificado.charAt(0) == 'X' || documentoRectificado.charAt(0) == 'Y' || documentoRectificado.charAt(0) == 'Z') {
                digitoNie = (int) Integer.parseInt(documentoRectificado.substring(1, 8));
                
                letraNie = documentoRectificado.charAt(8);
                
                if (documentoRectificado.charAt(0) == 'Y') {
                    digitoNie += 10000000;

                } else if (documentoRectificado.charAt(0) == 'Z') {
                    digitoNie += 20000000;

                }

            } else {
                digitoNif = (int) Integer.parseInt(documentoRectificado.substring(0, 8));
                
                letraNif = documentoRectificado.charAt(8);
                
            }

            if (letraNif == letras.charAt(digitoNif % 23) || letraNie == letras.charAt(digitoNie % 23)) {
                
                 System.out.println("El dni es correcto");
                 valido = true;

            } else {
                     System.out.println("El dni no es correcto");
                     valido = false;
            }
        }
        return valido;
    }

}
