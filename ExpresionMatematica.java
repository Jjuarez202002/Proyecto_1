package expresionmatematica;
import java.util.Scanner;
public class ExpresionMatematica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Paso 1: Ingreso de expresión matemática
        System.out.println("Ingrese la expresión matemática:");
        String expresion = scanner.nextLine();

        // Crear una instancia de la clase ArbolExpresion
        ArbolExpresion arbol = new ArbolExpresion(expresion);

        // Paso 2: Visualización del árbol
        arbol.visualizar();

        // Paso 3: Recorridos del árbol
        System.out.println("Recorrido preorden del árbol:");
        arbol.recorridoPreorden();
        
        System.out.println("Recorrido inorden del árbol:");
        arbol.recorridoInorden();
        
        System.out.println("Recorrido postorden del árbol:");
        arbol.recorridoPostorden();

        // Paso 4: Conversión a notación polaca (postfija)
        String notacionPolaca = NotacionPolaca.convertir(expresion);
        System.out.println("Notación polaca (postfija): " + notacionPolaca);

        // Paso 5: Evaluación de la expresión
        double resultado = Evaluator.evaluar(notacionPolaca);
        System.out.println("Resultado de la expresión: " + resultado);
    }
}