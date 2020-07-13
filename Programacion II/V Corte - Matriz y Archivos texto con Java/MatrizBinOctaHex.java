import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class MatrizBinOctaHex {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese numero de filas: ");
        int n = scanner.nextInt();
        System.out.println("Ingrese numero de columnas: ");
        int m = scanner.nextInt();

        int matriz[][] = new int[n][m];
        String matriz_bin[][] = new String[n][m];
        String matriz_octal[][] = new String[n][m];
        String matriz_hex[][] = new String[n][m];

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = ThreadLocalRandom.current().nextInt(50, 1000);
                matriz_bin[i][j] = convertirNumeroBase(matriz[i][j], 2);
                matriz_octal[i][j] = convertirNumeroBase(matriz[i][j], 8);
                matriz_hex[i][j] = convertirNumeroBase(matriz[i][j], 16);
            }    
        }

        // imprimir 
        System.out.println("Matriz");
        imprimirMatrizInt(matriz);
        System.out.println("Matriz bin");
        imprimirMatriz(matriz_bin);
        System.out.println("Matriz octa");
        imprimirMatriz(matriz_octal);
        System.out.println("Matriz hex");
        imprimirMatriz(matriz_hex);
        scanner.close();
    }

    public static String convertirNumeroBase(int numero, int base){
        /*
        numero - int: es el numero al cual se quiere cambiar de base
        base - int(1 - 16): es la base a la cual se cambiara el @numero

        Convierte un numero a otra base dada 
        */
        // verificamos si la base esta dentro de los parametros
        if (base >= 1 && base <= 16){
            // usamos un string para determinar el valor a agregar
            // usado mas que todo por los valores en base 16 (HEXADECIMAL)
            // el objeto String tiene el metodo .charAt(posicion)
            // el cual retorna el caracter que esta en la posicion indicada
            String elementos = "0123456789ABCDEF";
            String resultado = "";
            // mientras el cociente sea distinto a 0
            while((numero / base) != 0){
                // obtenemos residuo
                Integer op = numero % base;
                // usando un format, ponemos el resultado nuevo a la izquierda
                resultado = String.format("%s%s", elementos.charAt(op), resultado);
                // actualizamos el numero
                numero = numero / base;
            }
            // retornamos resultado
            return String.format("%s%s", numero, resultado);
        }
        return "";
    }

    public static void imprimirMatrizInt(int matriz[][]){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void imprimirMatriz(String matriz[][]){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                System.out.printf("%11s", matriz[i][j]);
            }
            System.out.println();
        }
    }
}