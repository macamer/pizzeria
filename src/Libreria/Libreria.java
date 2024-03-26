package Libreria;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Libreria {

    public static boolean positivoInt(int num) {
        boolean correcto = true;
        if (num < 0) {
            correcto = false;
        }
        return correcto;
    }

    public static boolean validaFormatoDni(String dni) {
        boolean correcto = true;
        Pattern pat = Pattern.compile("^[0-9]{8}[A-Za-z]{1}$");
        Matcher mat = null;
        try {
            dni.toUpperCase();
            mat = pat.matcher(dni);
            if (!mat.matches()) {
                correcto = false;
            }
        } catch (Exception ex) {
            System.err.println("Ha habido un error");
        }
        return correcto;
    }

    public static boolean validaLetraDni(String valorNif) {
        boolean val = false;
        int indice;
        long num;
        char letra;
        String letras;
        letras = "TRWAGMYFPDXBNJZSQVHLCKET";
        valorNif = valorNif.trim();
        num = Long.parseLong(valorNif.substring(0, (valorNif.length() - 1)));
        valorNif = valorNif.toUpperCase();
        letra = valorNif.charAt(valorNif.length() - 1);
        indice = (int) (num % 23);
        if (letra == letras.charAt(indice)) {
            val = true;
        }
        return val;
    }
}
