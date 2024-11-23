package algoritmodijkstrasoliscedeño;
//import java.util.*;


import static algoritmodijkstrasoliscedeño.Dijkstra.dijkstra;
import java.util.Arrays;
import java.util.Scanner;

public class AlgoritmoDijkstraSolisCedeño {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    

    
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de ciudades (mínimo 5): ");
        int numCiudad;
        do {
            numCiudad = scanner.nextInt();
            if (numCiudad < 5) {
                System.out.println("Debe haber al menos 5 ciudades. Intente de nuevo.");
            }
        } while (numCiudad < 5);
        scanner.nextLine();

        String[] ciudades = new String[numCiudad];
        System.out.println("Ingrese los nombres de las ciudades:");
        for (int i = 0; i < numCiudad; i++) {
            System.out.print("Ciudad " + (i + 1) + ": ");
            ciudades[i] = scanner.nextLine();
        }

        int[][] graph = new int[numCiudad][numCiudad];
        System.out.println("Ingrese la matriz de adyacencia (use 0 si no hay conexión):");
        for (int i = 0; i < numCiudad; i++) {
            for (int j = 0; j < numCiudad; j++) {
                System.out.print("Distancia de " + ciudades[i] + " a " + ciudades[j] + " (use 0 si no hay conexión): ");
                int distancia;
                do {
                    distancia = scanner.nextInt();
                    if (distancia < 0) {
                        System.out.println("La distancia debe ser un número positivo. Intente de nuevo.");
                    }
                } while (distancia < 0);
                graph[i][j] = distancia;
            }
        }

        System.out.print("Ingrese la ciudad de inicio: ");
        String ciudadOrigen = scanner.next();
        System.out.print("Ingrese la ciudad de destino: ");
        String ciudadDestino = scanner.next();

        int start = Arrays.asList(ciudades).indexOf(ciudadOrigen);
        int end = Arrays.asList(ciudades).indexOf(ciudadDestino);

        if (start == -1 || end == -1) {
            System.out.println("Ciudad no válida ingresada.");
        } else {
            dijkstra(graph, start, end, ciudades);
        }

        scanner.close();
    }
}
    
    

