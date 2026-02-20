package ui;
import controller.GestionCuenta;
import view.*;

public class Main {
    public static void main(String[] args) {
        GestionCuenta gc = new GestionCuenta();
        MenuView mV = new MenuView();
        MenuTransaccion mT = new MenuTransaccion(gc);
        CuentasView gC = new CuentasView(gc);
        int a;

        do{
            a = mV.menuPpal();
            switch (a) {
                case 1 -> {
                    gC.gestionCuenta();

                }
                case 2 -> {
                    mT.menuTra();
                }
                case 0 -> {
                    System.out.println("Saliendo del sistema...");
                    break;
                }
                default -> {
                    System.out.println("Ingrese una opcion valida");
                }

            }

        } while(a != 0);
    }
}
