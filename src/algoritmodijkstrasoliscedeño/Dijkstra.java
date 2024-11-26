package algoritmodijkstrasoliscedeño;

import java.util.Arrays;

public class Dijkstra {
    
    private static int getCaminoCorto(int[] distancia, boolean[] visitado) {
        int minDistancia = Integer.MAX_VALUE;
        int minIndice = -1;

        for (int i = 0; i < distancia.length; i++) {
            if (!visitado[i] && distancia[i] < minDistancia) {
                minDistancia = distancia[i];
                minIndice = i;
            }
        }

        return minIndice;
    }

    public static void dijkstra(int[][] grafo, int origen, int destino, String[] ciudades) {
        int numVertices = grafo.length;
        int[] recorrido = new int[numVertices];
        boolean[] visitado = new boolean[numVertices];
        int[] previo = new int[numVertices];

        Arrays.fill(recorrido, Integer.MAX_VALUE);
        Arrays.fill(previo, -1);
        recorrido[origen] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int actual = getCaminoCorto(recorrido, visitado);
            if (actual == -1) break;
            visitado[actual] = true;

            for (int vecino = 0; vecino < numVertices; vecino++) {
                if (grafo[actual][vecino] != 0 && !visitado[vecino]) {
                    int nuevaDistancia = recorrido[actual] + grafo[actual][vecino];
                    if (nuevaDistancia < recorrido[vecino]) {
                        recorrido[vecino] = nuevaDistancia;
                        previo[vecino] = actual;
                    }
                }
            }
        }

        if (recorrido[destino] == Integer.MAX_VALUE) {
            System.out.println("No hay ruta entre " + ciudades[origen] + " y " + ciudades[destino] + ".");
        } else {
            System.out.println("La distancia más corta de " + ciudades[origen] + " a " + ciudades[destino] + " es: " + recorrido[destino]);
            System.out.print("Ruta: ");
            Imprimir(previo, destino, ciudades);
            System.out.println();
        }
    }

    private static void Imprimir(int[] caminoPrevio, int caminoActual, String[] ciudades) {
        if (caminoActual == -1) return;
        Imprimir(caminoPrevio, caminoPrevio[caminoActual], ciudades);
        System.out.print(ciudades[caminoActual] + " ");
    }
}


