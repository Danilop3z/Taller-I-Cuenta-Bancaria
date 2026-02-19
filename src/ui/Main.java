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
            default->{
                break;
            }
        }


    }
}
