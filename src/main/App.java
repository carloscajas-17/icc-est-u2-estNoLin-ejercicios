package main;

import main.Ejercicio_01_insert.InsertBST;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLeves.ListLevels;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Models.Node;
import utils.StudentValidator;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        
        System.out.println("----------------------------------------");


        System.out.println("\n EJERCICIO N º 01 -  Insertar en un Árbol Binario de Búsqueda (BST) ");
        InsertBST bstt = new InsertBST();
        Node raizBST = null;
        int[] valoresBST = {5, 3, 7, 2, 4, 6, 8}; 

        for (int v : valoresBST) {
            raizBST = bstt.insert(raizBST, v);
        }

        System.out.print(" Árbol BST (InOrder): ");
        bstt.imprimirArbolInOrder(raizBST);
        System.out.println();


        System.out.println("----------------------------------------");
        System.out.println("\n EJERCICIO Nº 02   Invertir el  Árbol Binario");
        InvertBinaryTree invertidor = new InvertBinaryTree();
        Node raizEj2 = construirArbolEjercicio2(); // método auxiliar
        Node raizInvertida = invertidor.invertTree(raizEj2);

        System.out.print("Árbol Invertido (InOrder): ");
        bstt.imprimirArbolInOrder(raizInvertida);
        System.out.println();

        System.out.println("----------------------------------------");


        System.out.println("\n EJERCICIO  Nº 03 - Niveles del Árbol ");
        Node raizEj3 = construirArbolEjercicio3(); 
        ListLevels listador = new ListLevels();
        List<List<Node>> niveles = listador.listLevels(raizEj3);
        int nivel = 1;
        for (List<Node> lista : niveles) {
            System.out.print("Nivel " + nivel++ + ": ");
            for (int i = 0; i < lista.size(); i++) {
                System.out.print(lista.get(i).getValue());
                if (i < lista.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        }

        System.out.println("----------------------------------------"); 

        System.out.println("\n EJERCICIO Nº 04 - Profundidad Max del árbol");
        Node raizEj4 = construirArbolEjercicio4(); 
        Depth profundidad = new Depth();
        int profundidadMaxima = profundidad.maxDepth(raizEj4);
        System.out.println(" Profundidad Max: " + profundidadMaxima);
    }

  
    private static Node construirArbolEjercicio2() {
        Node root = new Node(4);
        root.setLeft(new Node(2));
        root.setRight(new Node(7));
        root.getLeft().setLeft(new Node(1));
        root.getLeft().setRight(new Node(3));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(9));
        return root;
    }


    private static Node construirArbolEjercicio3() {
        return construirArbolEjercicio2();
    }


    private static Node construirArbolEjercicio4() {
        Node root = new Node(4);
        root.setLeft(new Node(2));
        root.setRight(new Node(7));
        root.getLeft().setLeft(new Node(1));
        root.getLeft().setRight(new Node(3));
        root.getLeft().getLeft().setLeft(new Node(8)); 
        return root;
    }
}