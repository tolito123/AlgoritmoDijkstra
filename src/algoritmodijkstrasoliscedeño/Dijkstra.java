package algoritmodijkstrasoliscedeño;

import java.util.Arrays;

public class Dijkstra {
    
    private static int getCaminoCorto(int[] distancia, boolean[] visitado) {
        int minDistancia = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distancia.length; i++) {
            if (!visitado[i] && distancia[i] < minDistancia) {
                minDistancia = distancia[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void dijkstra(int[][] grafo, int origen, int destino, String[] ciudades) {
        int numVertices = grafo.length;
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        int[] previous = new int[numVertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);
        distances[origen] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int current = getCaminoCorto(distances, visited);
            if (current == -1) break;
            visited[current] = true;

            for (int neighbor = 0; neighbor < numVertices; neighbor++) {
                if (grafo[current][neighbor] != 0 && !visited[neighbor]) {
                    int newDist = distances[current] + grafo[current][neighbor];
                    if (newDist < distances[neighbor]) {
                        distances[neighbor] = newDist;
                        previous[neighbor] = current;
                    }
                }
            }
        }

        if (distances[destino] == Integer.MAX_VALUE) {
            System.out.println("No hay ruta entre " + ciudades[origen] + " y " + ciudades[destino] + ".");
        } else {
            System.out.println("La distancia más corta de " + ciudades[origen] + " a " + ciudades[destino] + " es: " + distances[destino]);
            System.out.print("Ruta: ");
            Imprimir(previous, destino, ciudades);
            System.out.println();
        }
    }

    private static void Imprimir(int[] caminoPrevio, int caminoActual, String[] ciudades) {
        if (caminoActual == -1) return;
        Imprimir(caminoPrevio, caminoPrevio[caminoActual], ciudades);
        System.out.print(ciudades[caminoActual] + " ");
    }
}


