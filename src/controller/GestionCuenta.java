package controller;

import model.Cuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestionCuenta {
    private List<Cuenta> listCuentas;

    public GestionCuenta() {
        this.listCuentas = new ArrayList<Cuenta> ();
    }

    public Cuenta findCuentaById(int id) {
        for (Cuenta cuenta : this.listCuentas) {
            if (cuenta.getIdCuenta() == id) {
                return cuenta;
            }
        }
        return null;
    }

    public Boolean addCuenta(Cuenta cuenta){
        if (Objects.isNull(this.findCuentaById(cuenta.getIdCuenta()))){
            this.listCuentas.add(cuenta);
            System.out.println("Cuenta creada satisfactoriamente!");
            return true;
        }
        System.out.println("Hubo un problema al crear la cuenta");
        return false;
    }

    public Boolean deleteCuenta(Cuenta cuenta){
        if (Objects.nonNull(this.findCuentaById(cuenta.getIdCuenta()))){
            this.listCuentas.remove(cuenta);
            System.out.println("Cuenta eliminada satisfactoriamente");
            return true;
        }
        System.out.println("Ha habido un error al eliminar la cuenta");
        return false;
    }

    public void listCuentas(){
        for (Cuenta c: listCuentas){
            System.out.println(c);
        }
    }

    public boolean consignar(int id, double monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido");
            return false;
        }

        Cuenta cuenta = findCuentaById(id);

        if (cuenta == null) {
            System.out.println("Cuenta no encontrada");
            return false;
        }

        cuenta.consignar(monto);
        System.out.println("Transaccion exitosa. Nuevo saldo: " + cuenta.getSaldo());
        return true;
    }

    public boolean transferir(int idOrigen, int idDestino, double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido");
            return false;
        }

        Cuenta origen = findCuentaById(idOrigen);
        Cuenta destino = findCuentaById(idDestino);

        if (origen == null || destino == null) {
            System.out.println("Una o ambas cuentas no existen");
            return false;
        }

        // Primero intentamos retirar
        boolean retiroExitoso = origen.retirar(monto);

        if (retiroExitoso) {
            // Si el retiro fue exitoso, consignamos
            destino.consignar(monto);
            System.out.println("Transferencia exitosa");
            return true;
        } else {
            System.out.println("No se pudo realizar la transferencia (saldo insuficiente)");
            return false;
        }
    }
}