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

    private Cuenta findCuentaById(int id) {
        for (Cuenta cuenta : this.listCuentas) {
            if (cuenta.getIdCuenta() == id) {
                return cuenta;
            }
        }
        return null;
    }

    private Boolean addCuenta(Cuenta cuenta){
        if (Objects.isNull(this.findCuentaById(cuenta.getIdCuenta()))){
            this.listCuentas.add(cuenta);
            return true;
        }
        return false;
    }

    private Boolean deleteCuenta(Cuenta cuenta){
        if (Objects.isNull(this.findCuentaById(cuenta.getIdCuenta()))){
            this.listCuentas.remove(cuenta);
            return true;
        }
        return false;
    }

    public boolean consignar(int id, double monto) {
        Cuenta cuenta = findCuentaById(id);

        if (cuenta != null && monto > 0) {
            cuenta.consignar(monto);
            return true;
        }
        return false;
    }


}

