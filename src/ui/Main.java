package ui;
import view.*;

public class Main {
    public static void main(String[] args) {
        MenuView mV = new MenuView();
        MenuTransaccion mT = new MenuTransaccion();
        GestionCuentas gC = new GestionCuentas();


        switch (mV.menuPpal()){
            case 1->{
                gC.gestionCuenta();

            }
            case 2->{
                mT.menuTra();
            }
            case 0->{
                System.out.println("Saliendo del sistema...");
                break;
            }
            default ->{
                System.out.println("Ingrese una opcion valida");
            }
        }


    }
}
