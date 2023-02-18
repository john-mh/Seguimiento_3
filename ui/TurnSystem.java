package ui;
import model.TurnManager;
import java.util.Scanner;

public class TurnSystem {

    private static final Scanner sc = new Scanner(System.in);
    private static final TurnManager turnManager = new TurnManager();

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de turnos \n");
        turnSystem();
    }

    public static void turnSystem() {

        System.out.println("1)  Añadir turno");
        System.out.println("2)  Siguiente turno");
        System.out.println("3)  Saltar turno");
        System.out.println("4)  Mostrar turno");
        System.out.println("0)  Salir");
        System.out.println();

        int op = sc.nextInt();
        System.out.println();
        boolean finish = false;

        switch (op) {
            case 1 -> {
                turnManager.addTurn();
                System.out.println("Turno añadido exitosamente.\n");
            }
            case 2 -> {
                if(turnManager.isNextTurnNull()) {
                    System.out.println("No hay turnos disponibles. \n");
                } else {
                turnManager.nextTurn();
                System.out.println("Desea eliminar el turno actual? (1) Si (2) No");
                int op2 = sc.nextInt();
                while (op2 != 1 && op2 != 2) {
                    System.out.println("Opción no válida. Intente de nuevo");
                    op2 = sc.nextInt();
                }
                if (op2 == 1) {
                    turnManager.deleteTurn();
                    System.out.println("Turno eliminado exitosamente. \n");
                }

                System.out.println("Siguiente turno \n");
                }
            }
            case 3 -> {
                if(turnManager.isNextTurnNull()) {
                    System.out.println("No hay turnos disponibles. \n");
                } else {
                    turnManager.skipTurn();
                    System.out.println("El turno ha sido saltado. \n");
                }
            }
            case 4 -> {
                if(turnManager.isListEmpty()) {
                    System.out.println("No hay turnos disponibles. \n");
                } else {
                    System.out.println("Turno actual: " + turnManager.displayTurn() + "\n");
                }
            }
            case 0 -> {
                System.out.println("Cerrando sistema de turnos...");
                finish = true;
            }
            default -> System.out.println("Opción no válida");
        }

        if (!finish)
            turnSystem();
    }
}
