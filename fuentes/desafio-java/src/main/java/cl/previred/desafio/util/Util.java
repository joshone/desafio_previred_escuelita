package cl.previred.desafio.util;

import java.util.Random;
import java.util.regex.Pattern;

public class Util {

    public static boolean validarRut(String rut) {
        if (rut == null || rut.isBlank()) {
            return false;
        }

        String cleanRut = rut.replace(".", "").toLowerCase();
        Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]$");
        if (!pattern.matcher(cleanRut).matches()) {
            return false;
        }

        String[] parts = cleanRut.split("-");
        String cuerpo = parts[0];
        String dv = parts[1];

        int m = 0, s = 1;
        for (; Integer.parseInt(cuerpo) != 0; cuerpo = String.valueOf(Integer.parseInt(cuerpo) / 10)) {
            s = (s + (Integer.parseInt(cuerpo) % 10) * (9 - (m++ % 6))) % 11;
        }
        char dvCalculado = (char) (s != 0 ? s + 47 : 75);
        return dv.charAt(0) == dvCalculado;
    }

    public static String generarIdentificadorUnico() {
        //largo al azar entre 1 y 50
        int length = new Random().nextInt(50) + 1;

        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }

        return sb.toString();
    }
}
