/**
 * @author Moha
 */

public class Dijkstra extends Recorrido {
    protected int dist[]; // con infinito
    private static final int arist = 2000000000; // infinito

    public boolean Recorrido(Grafo g_residual, int origen, int destino, int path[]) {
        int V = g_residual.sizeGrafo();
        boolean[] visitados = new boolean[V];
        Arrays.fill(visitados, false);

        dist = new int[V];
        Arrays.fill(dist, arist);

        dist[origen] = 0;

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(1, new PriorityQueueComparator()); // coste, nodo
        Pair<Integer, Integer> pa = new Pair<Integer, Integer>(0, origen);
        pq.add(pa);
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> p = pq.poll();
            int actual = p.consultarSegundo();
            int size = g_residual.sizeGrafo(actual);
            if (!visitados[actual]) {
                visitados[actual] = true;
                for (int i = 0; i < size; ++i) {
                    int adj = g_residual.consultarSeg(actual, i);
                    int coste = g_residual.consultarPrim(actual, i).ConsultarCoste();
                    int cap = g_residual.consultarPrim(actual, i).ConsultarCapacidad();
                    if ((dist[adj] > dist[actual] + coste) && (cap > 0) && (coste >= 0)) {
                        dist[adj] = dist[actual] + coste;
                        path[adj] = actual;
                        pq.add(new Pair<Integer, Integer>(dist[adj], adj));
                    }
                }
            }
        }
        return (dist[destino] != arist);
    }
}

class PriorityQueueComparator implements Comparator<Pair<Integer, Integer>> {
    public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
        return (int) (p2.consultarPrimero() - p1.consultarPrimero());
    }
}
