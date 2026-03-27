public class ArbolInventario { 
    Producto raiz; // La raíz del árbol 

    public ArbolInventario() {
        this.raiz = null;
    }

    // 1. MÉTODO INSERTAR (Recursivo)
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Producto insertarRecursivo(Producto nodoActual, int id, String nombre) {
        // Si el árbol está vacío o llegamos a una hoja, creamos el nodo
        if (nodoActual == null) {
            return new Producto(id, nombre);
        }
        
        // Si el ID es menor, se va a la izquierda
        if (id < nodoActual.id) {
            nodoActual.izquierdo = insertarRecursivo(nodoActual.izquierdo, id, nombre);
        } 
        // Si el ID es mayor, se va a la derecha
        else if (id > nodoActual.id) {
            nodoActual.derecho = insertarRecursivo(nodoActual.derecho, id, nombre);
        }
        // Retornamos el nodo actual modificado
        return nodoActual;
    }

    // 2. MÉTODO RECORRIDO INORDEN (Izquierda - Raíz - Derecha)
    public void recorridoInorden() {
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(Producto nodoActual) {
        if (nodoActual != null) {
            inordenRecursivo(nodoActual.izquierdo); // Visitar menores
            System.out.println("ID: " + nodoActual.id + " | Nombre: " + nodoActual.nombre); // Imprimir actual
            inordenRecursivo(nodoActual.derecho); // Visitar mayores
        }
    }

    // 3. MÉTODO BUSCAR 
    public boolean buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private boolean buscarRecursivo(Producto nodoActual, int id) {
        // Si llegamos al final y no está, retorna falso
        if (nodoActual == null) {
            return false;
        }
        // Si lo encontramos, retorna verdadero
        if (nodoActual.id == id) {
            return true;
        }
        // Búsqueda binaria: decide si ir a la izquierda o derecha
        if (id < nodoActual.id) {
            return buscarRecursivo(nodoActual.izquierdo, id);
        } else {
            return buscarRecursivo(nodoActual.derecho, id);
        }
    }
}