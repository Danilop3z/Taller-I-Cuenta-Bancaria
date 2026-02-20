package model;

public class Cuenta {
    private int idCuenta;
    private String titular;
    private double saldo;

    public Cuenta(int numeroCuenta, String titular, double saldo) {
        this.idCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int numeroCuenta) {
        this.idCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void consignar(double monto) {
        this.saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido");
            return false;
        }

        if (this.saldo >= monto) {
            this.saldo -= monto;
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "idCuenta=" + idCuenta +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
