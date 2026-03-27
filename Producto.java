public class Producto {
    // Datos del producto
    int id;
    String nombre;

    // Punteros hacia los hijos (izquierdo para menores, derecho para mayores)
    Producto izquierdo;
    Producto derecho;

    // Constructor para inicializar el nodo
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }
}