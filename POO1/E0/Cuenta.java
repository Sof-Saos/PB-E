
public class Cuenta {
    private String titular;
    private double saldo;
    private long numeroDeCuenta;

    public Cuenta(String titular, double saldo, long numeroDeCuenta){
        this.titular = titular;
        this.saldo = saldo;
        this.numeroDeCuenta = numeroDeCuenta;
    }
    public String getTitular(){
        return this.titular;
    }
    public double getCantidad() {
        return this.saldo;
    }
    public String setTitular(String titular){
        return this.titular = titular;
    }
    public double setCantidad(double saldo){
        return this.saldo = saldo;
    }

    public void mostrar() {
        System.out.println("Señor/a " + titular);
        System.out.println("El saldo actual de su cuenta "+ numeroDeCuenta +" es: " + saldo);
    }

    public void ingresar(double saldoIngresado) {
        this.saldo += saldoIngresado;
    }

    public void retirar(double saldoRetirar) {
        this.saldo -= saldoRetirar;
        if (this.saldo < 0) {
            System.out.println("fondos insuficientes");
            this.saldo += saldoRetirar;
        } else {
            System.out.println("Dinero retirado con exito");
        }
    }
}
