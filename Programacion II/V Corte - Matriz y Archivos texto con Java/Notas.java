import java.io.File;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class Notas {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new File("NOTAS.txt"));        
    String cedula_mayor = "";
    String nombre_mayor = "";      
    double porcentaje_1 = 0; 
    double porcentaje_2 = 0; 
    double porcentaje_3 = 0; 
    int suma_notas = 0; 
    int lineas = 0; 
    int promedio = 0;
    int nota_mayor = 0;
    int cantidad_1 = 0; 
    int cantidad_2 = 0; 
    int cantidad_3 = 0;
    List<String> lines = new ArrayList<String>();
    Path file = Paths.get("REPORTE.txt");    

    while(scanner.hasNextLine()){
      String campos[] = scanner.nextLine().split(",");
      
      String cedula = campos[0];
      String nombre = campos[1];
      int nota_1 = Integer.parseInt(campos[2]);
      int nota_2 = Integer.parseInt(campos[3]);
      int nota_3 = Integer.parseInt(campos[4]);
      int nota_final = (nota_1 + nota_2 + nota_3) / 3;

      suma_notas += nota_final;
      lineas += 1;

      if (nota_final > nota_mayor){
        nombre_mayor = nombre;
        cedula_mayor = cedula;
        nota_mayor = nota_final;
      }

      if(nota_final >= 10){
        lines.add(String.format("%s,%s,%d", cedula, nombre, nota_final));
      }

      if (nota_1 >= 10){
        cantidad_1 += 1;
      }

      if (nota_2 >= 10){
        cantidad_2 += 1;
      }

      if (nota_3 >= 10){
        cantidad_3 += 1;
      }
    }

    if (lineas != 0){
      promedio = suma_notas / lineas;
      porcentaje_1 = (cantidad_1 * 100) / lineas;
      porcentaje_2 = (cantidad_2 * 100) / lineas;
      porcentaje_3 = (cantidad_3 * 100) / lineas;
    }

    lines.add(String.format("PROMEDIO FINAL SECCION: %d", promedio));
    lines.add(String.format("%s,%s", cedula_mayor, nombre_mayor));
    lines.add(String.format(Locale.ROOT, "%3.2f,%3.2f,%3.2f", porcentaje_1, porcentaje_2, porcentaje_3));    
    Files.write(file, lines, StandardCharsets.UTF_8);
  }
}