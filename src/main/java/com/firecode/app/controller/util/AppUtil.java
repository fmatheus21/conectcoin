package com.firecode.app.controller.util;

import java.io.File;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.text.WordUtils;

@SuppressWarnings("deprecation")
public class AppUtil {

    /* Converte primeiro caracter em maiusculo */
    public static String convertFirstUppercaseCharacter(String string) {
        return WordUtils.capitalizeFully(string).trim();
    }

    public static String convertsAllUppercaseCharacters(String string) {
        return string.toUpperCase().trim();
    }

    public static String convertAllLowercaseCharacters(String string) {
        return string.toLowerCase().trim();
    }

    public static String removeAllSpaces(String string) {
        return string.replaceAll(" ", "");
    }

    public static String removeDuplicateSpace(String string) {
        return string.replaceAll("\\s+", " ").trim();
    }

    public static String removeSpecialCharacters(String string) {
        return string.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static String removeAccent(String string) {
        String normalize = Normalizer.normalize(string, Normalizer.Form.NFD);
        normalize = normalize.replaceAll("[^\\p{ASCII}]", "");
        return normalize;
    }

    public static String formatar(String valor, String mascara) {
        String dado = "";
        // remove caracteres nao numericos
        for (int i = 0; i < valor.length(); i++) {
            char c = valor.charAt(i);
            if (Character.isDigit(c)) {
                dado += c;
            }
        }
        int indMascara = mascara.length();
        int indCampo = dado.length();

        for (; indCampo > 0 && indMascara > 0;) {
            if (mascara.charAt(--indMascara) == '#') {
                indCampo--;
            }
        }
        String saida = "";
        for (; indMascara < mascara.length(); indMascara++) {
            saida += ((mascara.charAt(indMascara) == '#') ? dado.charAt(indCampo++) : mascara.charAt(indMascara));
        }
        return saida;
    }

    public static boolean validateEmail(String email) {
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkExistenceNumber(String value) {
        Pattern pattern = Pattern.compile("[^\\s A-z]+");
        Matcher match = pattern.matcher(value);
        return match.find(); // Retorna true caso exista numero na string
    }

    /* Listar todos arquivos em um diretorio */
    public static List<String> listFilesDirectory(String directory) {
        File file = new File(directory);
        List<String> list = new ArrayList<>();
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                list.add(f.getName());
            }
        }
        return list;
    }

    public static String replaceCharacters(String string, String value, String replace) {
        return string.replace(value, replace);
    }

    public static String returnFirstWord(String texto) {
        String pattern = "^([a-zA-ZÈ-Úè-ú]+)\\s";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(texto);
        if (m.find()) {
            return m.group(0);
        }
        return null;
    }

    public static String returnCharacter(String value, int position) {
        if (value.length() > position) {
            return value.substring(0, position);
        }
        return value;
    }

    public static String returnLastCharacters(String value, int position) {
        return value.substring(value.length() - position);
        // return value.charAt(value.length() - 1);
    }

    public static int countCharacter(String value) {
        return value.length();
    }

    public static long runtimeStart() {
        return System.currentTimeMillis();
    }

    public static long runtimeEnd() {
        return System.currentTimeMillis();
    }

    /*
	 * Retorna pate de uma string de acordo com o delimitador. Exemplo: API_REST.
	 * Resultado: API
     */
    public static String returnDelimiterString(String value, String delimiter) {
        if (value.contains(" ")) {
            return value.substring(0, value.indexOf(delimiter));
        }
        System.out.println("value: " + value);
        return value;
    }

    /* Gera numeros aleatorios no formato long */
    public static long randomNumber() {
        Random random = new Random();
        return random.nextLong();
    }

    public static String removeExtensionFile(String nameFile) {
        nameFile = nameFile.replace(".png", "");
        return nameFile;
    }

}
