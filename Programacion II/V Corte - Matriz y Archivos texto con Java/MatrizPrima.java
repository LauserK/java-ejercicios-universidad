import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class MatrizPrima {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese numero de filas: ");
        int n = scanner.nextInt();
        System.out.println("Ingrese numero de columnas: ");
        int m = scanner.nextInt();
        scanner.close();
        
        int matriz[][]       = new int[n][m];
        int matriz_prima[][] = new int[n][m];

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = ThreadLocalRandom.current().nextInt(2, 1500 + 1);
                matriz_prima[i][j] = esPrimo(matriz[i][j]) ? matriz[i][j] : 0;
            }
        }

        System.out.println("Matriz original");
        imprimirMatrizInt(matriz);
        System.out.println("Matriz prima");
        imprimirMatrizInt(matriz_prima);
    }

    public static boolean esPrimo(int numero){
        int c = 0;
        int i = 1;
        while(i <= numero){
            if (numero % i == 0){
                c+=1;
            }
            i++;
        }

        if (c==2)
            return true;
        return false;
    }

    public static void imprimirMatrizInt(int matriz[][]){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                System.out.printf("%6d", matriz[i][j]);
            }
            System.out.println();
        }
    }
}