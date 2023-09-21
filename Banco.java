public class Banco  {
    private Banco banco;
    private Cliente cliente;

    public CajeroAutomatico(Banco banco) {
        this.banco = banco;
    }

    public void atenderCliente(Cliente cliente) {
        this.cliente = cliente;
        validarIdentidad();

        boolean seguirTransaccionando = true;
        while (seguirTransaccionando) {
            mostrarMenu();
            int opcion = recibirOpcion();

            switch (opcion) {
                case 1:
                    realizarRetiro();
                    break;
                case 2:
                    realizarDeposito();
                    break;
                case 3:
                    realizarTransferencia();
                    break;
                case 4:
                    realizarConsultaSaldo();
                    break;
                case 5:
                    seguirTransaccionando = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    break;
            }
        }
    }

    private void validarIdentidad() {
        int intentos = 0;
        while (intentos < 3) {
            System.out.println("Ingrese su documento de identidad:");
            int documento = recibirDocumento();

            System.out.println("Ingrese su PIN:");
            int pin = recibirPin();

            if (banco.validarIdentidad(documento, pin)) {
                return;
            }

            System.out.println("Documento o PIN incorrectos. Por favor, inténtelo nuevamente.");
            intentos++;
        }

        System.out.println("Ha excedido el número máximo de intentos. La aplicación se cerrará.");
        System.exit(0);
    }

    private void mostrarMenu() {
        System.out.println("\n==== Menú del Cajero Automático ====");
        System.out.println("1. Realizar retiro de efectivo");
        System.out.println("2. Realizar depósito");
        System.out.println("3. Realizar transferencia");
        System.out.println("4. Consultar saldo");
        System.out.println("5. Salir\n");
    }

    // Resto de métodos para realizar las transacciones de retiro, depósito, transferencia y consulta de saldo
    // ...

    // Método main para iniciar la aplicación
    public static void main(String[] args) {
        Banco banco = new Banco(); // Crear una instancia de la clase Banco
        CajeroAutomatico cajero = new CajeroAutomatico(banco); // Crear una instancia de la clase CajeroAutomatico

        Cliente cliente = new Cliente(); // Crear una instancia de la clase Cliente
        cajero.atenderCliente(cliente); // Iniciar la atención al cliente
    }
}
}
