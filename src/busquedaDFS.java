
import java.util.Objects;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author axlku
 */
public class busquedaDFS {
    String[] vertices = {"Salina Cruz", "Huatulco", "Puerto Escondido", "Tehuantepec", "Oaxaca", "Puebla",
             "Orizaba", "Cordoba", "Veracruz", "Ciudad de México", "Juchitán", "Ixtepec", "Tonalá", "Acayucan",
             "Minatitlán", "Veracruz", "Cordoba", "Xalapa", "Poza Rica", "Tuxpan", "Tampico", "Matamoros", "Ciudad Reynosa"};
    // Almacenar información lateral (matriz de adyacencia)
    private int[][] arcs;
    // El número de nodos en el gráfico
    private int vexnum;
    // Registrar si el nodo ha sido atravesado
    private boolean[] visited;
    // Inicializar
    public busquedaDFS(int n) {
        vexnum = n;
        //vertices = new String[n];
        arcs = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < vexnum; i++) {
            for (int j = 0; j < vexnum; j++) {
                arcs[i][j] = 0;
            }
        }
    }
    // Agregar bordes (gráfico no dirigido)
    public void addEdge(int i, int j) {
        // La cabeza y la cola del borde no pueden ser el mismo nodo
        if (i == j) {
            return;
        }
        arcs[i][j] = 1;
        arcs[j][i] = 1;
    }
    // Establecer bandera de acceso al nodo
    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    // imprimir nodos transversales
    public void visit(int i) {
        System.out.print(vertices[i] + "\n");

    }
    
    //busca el indice de la ciudad a buscar nadamas
    public int buscarIndexVertice(String elemento){
        int index=0;
        for (int i = 0; i < vertices.length; i++) {
            if(vertices[i]==elemento){
                index=i;
            }
        }
        return index;
    }
    
    // Recorrido en profundidad del gráfo por medio de pila
    public void DFSTraverse2(int n) {
        // Inicializar la marca transversal del nodo
        /*for (int i = 0; i < vexnum; i++) {
            visited[i] = false;
        }*/
        //pila del ejercicio, vexnum es el número de elementos en total
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < vexnum; i++) {
            if (!visited[i]) { //si un nodo no ha sido visitado lo añade a la pila
                // Nodo inicial del subgrafo conectado
                s.add(i);
                do { //mientras la pila no este vacia, popeamos el tope y marcamos el nodo como visitado
                    int curr = s.pop();
                    if (curr==n) {
                        visit(n);
                        System.exit(0);
                    }
                    // Si no se ha atravesado el nodo, atravesar el nodo y empujar los nodos secundarios a la pila
                    if (visited[curr] == false) {
                        // atravesar e imprimir
                       visit(curr);
                        //System.out.print(vertices[i]);
                        visited[curr] = true;
                        // Los nodos secundarios no cruzados se insertan en la pila, esto es con matriz de adyacencia
                        for (int j = vexnum - 1; j >= 0; j--) {
                            if (arcs[curr][j] == 1 && visited[j] == false) {
                                s.add(j);
                                break;
                            }
                        }
                    }                    
                } while (!s.isEmpty());
            }
        }
    }

    public static void main(String[] args) {
        busquedaDFS g = new busquedaDFS(23);    
        
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 10);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 9);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(10, 11);
        g.addEdge(10, 12);
        g.addEdge(10, 13);
        g.addEdge(13, 14);
        g.addEdge(13, 15);
        g.addEdge(15, 16);
        g.addEdge(15, 17);
        g.addEdge(15, 18);
        g.addEdge(18, 19);
        g.addEdge(19, 20);
        g.addEdge(20, 21);
        g.addEdge(21, 22);

        System.out.println();

        System.out.print("Recorrido en profundidad: \n");
        /*Parametros en DFSTraverse2, dentro del metodo buscar indice
        debe poner el nombre de la ciudad que desea detectar con el algoritmo
        de busqueda en profundudad, asegurese de copiarlo y pegarlo del array 
        "String[] vertices" que se encuentra al principio del programa.
        
        El programa automáticamente se detiene cuando detecta el destino deseado*/
        
        g.DFSTraverse2(g.buscarIndexVertice("Xalapa"));
    }
}
