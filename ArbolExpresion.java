package expresionmatematica;
import java.util.EmptyStackException;
import java.util.Stack;

public class ArbolExpresion {
    private NodoArbol raiz;

    // Constructor que recibe la expresión matemática y construye el árbol de expresión
    public ArbolExpresion(String expresion) {
        this.raiz = construirArbol(expresion);
    }

    // Método privado para construir el árbol de expresión a partir de la expresión ingresada
private NodoArbol construirArbol(String expresion) {
    String[] tokens = expresion.split(" ");
    Stack<NodoArbol> stack = new Stack<>();

    try {
        for (String token : tokens) {
            NodoArbol nodo = new NodoArbol(token);
            if (esOperador(token)) {
                nodo.derecho = stack.pop();
                nodo.izquierdo = stack.pop();
            }
            stack.push(nodo);
        }
    } catch (EmptyStackException e) {
        System.err.println("La expresión matemática no es válida");
        return null;
    }

    if (stack.size() != 1) {
        System.err.println("La expresión matemática no es válida");
        return null;
    }

    return stack.pop();
}
    public void visualizar() {
        if (raiz == null) {
            System.out.println("Árbol vacío");
            return;
        }
        visualizar(raiz, 0);
    }

    private void visualizar(NodoArbol nodo, int nivel) {
        if (nodo != null) {
            for (int i = 0; i < nivel; i++)
                System.out.print("   ");
            System.out.println(nodo.valor);
            visualizar(nodo.izquierdo, nivel + 1);
            visualizar(nodo.derecho, nivel + 1);
        }
    }

    // Método para realizar el recorrido preorden del árbol
    public void recorridoPreorden() {
        recorridoPreorden(raiz);
        System.out.println();
    }

    private void recorridoPreorden(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            recorridoPreorden(nodo.izquierdo);
            recorridoPreorden(nodo.derecho);
        }
    }

    // Método para realizar el recorrido inorden del árbol
    public void recorridoInorden() {
        recorridoInorden(raiz);
        System.out.println();
    }

    private void recorridoInorden(NodoArbol nodo) {
        if (nodo != null) {
            recorridoInorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            recorridoInorden(nodo.derecho);
        }
    }

    // Método para realizar el recorrido postorden del árbol
    public void recorridoPostorden() {
        recorridoPostorden(raiz);
        System.out.println();
    }

    private void recorridoPostorden(NodoArbol nodo) {
        if (nodo != null) {
            recorridoPostorden(nodo.izquierdo);
            recorridoPostorden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    // Método estático para verificar si un token es un operador
    private static boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
    }
}