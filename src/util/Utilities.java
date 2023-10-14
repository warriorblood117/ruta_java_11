package util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
    public static String capturarString(String mensaje) {
        Scanner capturaTeclado = new Scanner(System.in);
        System.out.println(mensaje);
        var texto = capturaTeclado.next()   ;
        return texto;
    }


    public static int capturarInt(String mensaje) {
        Scanner capturaTeclado = new Scanner(System.in);
        System.out.println(mensaje);
        int valor = capturaTeclado.nextInt();

        return valor;
    }
    public static  int verifyEdad(int edad){

        while (!(edad >= 18 && edad < 60)) {
            edad = Utilities.capturarInt("El valor no es correcto, Ingrese nuevamente la edad");
        }

        return edad;

    }

    public static String isValidEmail(String mail){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);

        return  matcher.matches() ?  "Es un mail valido": "No es un mail valido";

    }

    public static String isValidPhoneNumber(String phoneNumber ){
       return  phoneNumber.length() >= 7 && phoneNumber.length() <= 10  ? "Es un número valido" : "No es un número invalido";
    }


}
