package view;
import java.util.Scanner;
import controller.GestionCuenta;
import model.Cuenta;

public class CuentasView {
    Scanner sn = new Scanner(System.in);
    GestionCuenta gc;
    public CuentasView(GestionCuenta gc){
        this.gc = gc;
    }

    public void gestionCuenta() {
        int a=5;
        while (a != 0) {
            System.out.println("====GESTION DE CUENTAS====");
            System.out.println("1. CREAR");
            System.out.println("2. BUSCAR");
            System.out.println("3. LISTAR");
            System.out.println("4. ELIMINAR");
            System.out.println("0. ATRAS");
            a = sn.nextInt();

            switch (a) {
                case 1 -> {
                    System.out.println("Ingrese la id de la cuenta que va a crear");
                    int nc = sn.nextInt();
                    System.out.println("Titular de la cuenta");
                    String t = sn.next();
                    System.out.println("Saldo inicial (el monto minimo es de 100.000)");
                    int s = sn.nextInt();

                    Cuenta c = new Cuenta(nc, t, s);
                    gc.addCuenta(c);
                }
                case 2 -> {
                    System.out.println("Ingrese el id de la cuenta que desea buscar");
                    int id = sn.nextInt();
                   if (gc.findCuentaById(id) != null){
                       System.out.println(gc.findCuentaById(id));
                   }else {
                       System.out.println("No se ha encontrado alguna cuenta con ese id");
                   }
                }
                case 3 -> {

                    gc.listCuentas();
                }
                case 4 -> {
                    System.out.println("Ingrese el id de la cuenta que desea eliminar");
                    int id = sn.nextInt();
                    Cuenta c = gc.findCuentaById(id);
                    gc.deleteCuenta(c);
                }
                case 0 -> {
                    break;
                }
                default -> {
                    System.out.println("Ingrese una opcion valida");
                }
            }
        }
    }
}
