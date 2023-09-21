public class SistemaGestionTurnos {
    public static void main(String[] args) {
        Queue<Integer> colaEspera = new LinkedList<>();
        int contadorTurnos = 0;

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Tomar un turno");
            System.out.println("2. Llamar a un cliente");
            System.out.println("3. Mostrar la cola de espera");
            System.out.println("4. Mostrar el contador de turnos");
            System.out.println("5. Salir");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    contadorTurnos++;
                    colaEspera.add(contadorTurnos);
                    System.out.println("Se ha tomado el turno " + contadorTurnos);
                    break;
                case 2:
                    if (!colaEspera.isEmpty()) {
                        int turnoLlamado = colaEspera.poll();
                        System.out.println("Se ha llamado al cliente con el turno " + turnoLlamado);
                    } else {
                        System.out.println("No hay clientes en la cola de espera");
                    }
                    break;
                case 3:
                    System.out.println("Cola de espera: " + colaEspera);
                    break;
                case 4:
                    System.out.println("Contador de turnos: " + contadorTurnos);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
}
