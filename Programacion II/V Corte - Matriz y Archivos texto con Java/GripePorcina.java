import java.io.File;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class GripePorcina {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new File("fiebre.txt"));
    List<String> sospechosos = new ArrayList<String>();
    Path fileSospechosos = Paths.get("sospechosos.txt");
    List<String> noSospechosos = new ArrayList<String>();
    Path fileNoSospechosos = Paths.get("nosospechosos.txt");

    int cantidadPacientes = 0;
    int cantSospechosos = 0;
    float porcentaje = 0;
    String nombreSospechoso = "";
    String institucionSospechoso = "";
    int mayorGlobulos = 0;

    while(scanner.hasNextLine()){
      String linea = scanner.nextLine();
      String campos[] = linea.split(",");
      cantidadPacientes += 1;

      String nombre = campos[0];
      String institucion = campos[1];
      float temperatura = Float.parseFloat(campos[2]);
      float hemoblogina = Float.parseFloat(campos[3]);
      int globulos = Integer.parseInt(campos[4]);

      if (temperatura > 38 && hemoblogina < 10 && globulos < 4000){
        cantSospechosos += 1;
        sospechosos.add(linea);

        if (globulos > mayorGlobulos){
          nombreSospechoso = nombre;
          institucionSospechoso = institucion;
          mayorGlobulos = globulos;
        }
      } else {
        noSospechosos.add(linea);
      }
    }

    if(cantidadPacientes != 0) {
      porcentaje = (cantSospechosos * 100) / cantidadPacientes;
    }    

    Files.write(fileSospechosos, sospechosos, StandardCharsets.UTF_8);
    Files.write(fileNoSospechosos, noSospechosos, StandardCharsets.UTF_8);

    System.out.printf("Porcentaje de pacientes no sospechosos: %2.2f",porcentaje);
    System.out.println();
    System.out.printf("%s / %s", nombreSospechoso, institucionSospechoso);
  }
}