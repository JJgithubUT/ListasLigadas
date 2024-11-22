import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestingListaLigada {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        int opcion, dato, posicion;
        ListaLigada lista = new ListaLigada();

        System.out.println("Creación de una lista ligada");
        
        do {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1) Agregar dato al final de la lista");
            System.out.println("2) Insertar dato en una posición específica");
            System.out.println("3) Eliminar dato en una posición específica　デリと");
            System.out.println("4) Mostrar contenido de la lista　コンテナを見せます");
            System.out.println("5) Salir 出ます");
            
            entrada = br.readLine();
            opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 1:
                    // Opción para agregar al final de la lista
                    System.out.println("Escribe el dato a almacenar en la lista:");
                    entrada = br.readLine();
                    dato = Integer.parseInt(entrada);
                    lista.add(dato);
                    System.out.println("Dato agregado al final de la lista.");
                    break;

                case 2:
                    // Opción para insertar en una posición específica
                    System.out.println("Escribe el dato a insertar:");
                    entrada = br.readLine();
                    dato = Integer.parseInt(entrada);
                    
                    System.out.println("Escribe la posición donde insertar el dato:");
                    entrada = br.readLine();
                    posicion = Integer.parseInt(entrada);
                    
                    try {
                        lista.addAt(posicion, dato);
                        System.out.println("Dato insertado en la posición " + posicion);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Opción para eliminar en una posición específica
                    System.out.println("Escribe la posición del dato a eliminar:");
                    entrada = br.readLine();
                    posicion = Integer.parseInt(entrada);
                    
                    try {
                        lista.elimAt(posicion);
                        System.out.println("Dato eliminado en la posición " + posicion);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Opción para mostrar el contenido de la lista
                    System.out.println("Contenido de la lista:");
                    lista.print();
                    break;

                case 5:
                    // Opción para salir del programa
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 5);
    }
}
