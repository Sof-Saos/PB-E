public class Banco {
    private Cuenta cuenta1;
    private Cuenta cuenta2;

    public Banco(Cuenta cuenta1, Cuenta cuenta2){
        this.cuenta1 = cuenta1;
        this.cuenta2 = cuenta2;
    }

    public void transferencias(Cuenta cuentaRetirara, Cuenta cuentaIngresara, double transferencia) {
        if (cuentaRetirara == null || cuentaIngresara == null) {
            System.out.println("Error: Cuentas no válidas.");
        }

        if (transferencia <= 0) {
            System.out.println("Error: La cantidad de transferencia debe ser mayor que cero.");
            return;
        }
        if (cuentaRetirara.getSaldoDeCuenta() >= transferencia) {
            cuentaRetirara.setRetiro(transferencia);
            cuentaIngresara.setIngreso(transferencia);
            System.out.println("Transferencia exitosa: " + transferencia + " unidades transferidas de la cuenta de " +
                    cuentaRetirara.getNombreDelTitular() + " a la cuenta de " + cuentaIngresara.getNombreDelTitular());
        } else {
            System.out.println("Error: Saldo insuficiente en la cuenta de origen.");
        }
    }

    public void imprimirCuentas(){
        System.out.println(cuenta1);
        System.out.println(cuenta2);
    }

}
