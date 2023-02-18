package ui;
import java.util.Scanner;
import model.TurnManager;

public class TurnSystem {

    private static Scanner sc = new Scanner(System.in);
    private static TurnManager turnManager = new TurnManager();

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de turnos");
        System.out.println("");
        turnSystem();
    }

    public static void turnSystem() {

        System.out.println("1)  Añadir turno");
        System.out.println("2)  Siguiente turno");
        System.out.println("3)  Saltar turno");
        System.out.println("4)  Mostrar turno");
        System.out.println("");

        int op = sc.nextInt();
        System.out.println("");
        boolean finish = false;

        switch (op) {
            case 1:
                turnManager.addTurn();
                System.out.println("Turno añadido exitosamente.");
                break;
            case 2:
                turnManager.nextTurn();
                System.out.println("Siguiente turno");
                break;
            case 3:
                turnManager.skipTurn();
                System.out.println("El turno ha sido saltado.");
                break;
            case 4:
                System.out.println("Turno actual: " + turnManager.displayTurn());
                break;
            case 0:
                System.out.println("Cerrando sistema de turnos...");
                finish = true;
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        if (finish == false)
            turnSystem();
    }

}
