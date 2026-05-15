package TrabajoPractico2.Ejercicio4;

public class CuentaBancaria {

  
    public static class MontoInvalidoException extends Exception {

        public MontoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class SaldoInsuficienteException extends Exception {

        private double saldoActual;
        private double montoSolicitado;

        public SaldoInsuficienteException(double saldoActual,
                                          double montoSolicitado) {

            super("Saldo insuficiente. Saldo actual: "
                    + saldoActual
                    + ", monto solicitado: "
                    + montoSolicitado);

            this.saldoActual = saldoActual;
            this.montoSolicitado = montoSolicitado;
        }

        public double getSaldoActual() {
            return saldoActual;
        }

        public double getMontoSolicitado() {
            return montoSolicitado;
        }
    }

    private String titular;
    private double saldo;
    private int contadorOperaciones;

    public CuentaBancaria(String titular, double saldoInicial)
            throws MontoInvalidoException {

        if (saldoInicial < 0) {
            throw new MontoInvalidoException(
                    "El saldo inicial no puede ser negativo");
        }

        this.titular = titular;
        this.saldo = saldoInicial;
        this.contadorOperaciones = 0;
    }

 
    public void depositar(double monto)
            throws MontoInvalidoException {

        if (monto <= 0) {
            throw new MontoInvalidoException(
                    "El monto a depositar debe ser positivo");
        }

        saldo += monto;
        contadorOperaciones++;
    }

    public void retirar(double monto)
            throws MontoInvalidoException,
                   SaldoInsuficienteException {

        if (monto <= 0) {
            throw new MontoInvalidoException(
                    "El monto a retirar debe ser positivo");
        }

        if (monto > saldo) {
            throw new SaldoInsuficienteException(saldo, monto);
        }

        saldo -= monto;
        contadorOperaciones++;
    }

 
    public double getSaldo() {
        return saldo;
    }

    public int getContadorOperaciones() {
        return contadorOperaciones;
    }


    @Override
    public String toString() {
        return String.format(
                "Cuenta de %s | Saldo: %.2f | Operaciones: %d",
                titular,
                saldo,
                contadorOperaciones
        );
    }

  
    public static void main(String[] args) {

        CuentaBancaria cuenta = null;

        try {

            cuenta = new CuentaBancaria("Mateo", 1000);

            System.out.println("Cuenta creada correctamente");
            System.out.println(cuenta);

          
            cuenta.depositar(500);
            System.out.println("Saldo actual: $" + cuenta.getSaldo());

          
            cuenta.retirar(300);
            System.out.println("Saldo actual: $" + cuenta.getSaldo());

         
            cuenta.retirar(5000);

        } catch (SaldoInsuficienteException e) {

            System.out.println("\nERROR DE SALDO");
            System.out.println("Saldo actual: $" + e.getSaldoActual());
            System.out.println("Monto solicitado: $" + e.getMontoSolicitado());

        } catch (MontoInvalidoException e) {

            System.out.println("\nERROR DE MONTO");
            System.out.println(e.getMessage());

        } finally {

            System.out.println("\n--- ESTADO FINAL DE LA CUENTA ---");

            if (cuenta != null) {
                System.out.println(cuenta);
                System.out.println("Operaciones exitosas: "
                        + cuenta.getContadorOperaciones());
            }
        }

     
        try {

            cuenta.depositar(-100);

        } catch (MontoInvalidoException e) {

            System.out.println("\nERROR AL DEPOSITAR");
            System.out.println(e.getMessage());
        }

        try {

            CuentaBancaria cuenta2 =
                    new CuentaBancaria("Juan", -500);

        } catch (MontoInvalidoException e) {

            System.out.println("\nERROR AL CREAR CUENTA");
            System.out.println(e.getMessage());
        }
    }
}