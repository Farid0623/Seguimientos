public class Hotel {
    private List<Cliente> clientes;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    public Hotel() {
        clientes = new ArrayList<>();
        habitaciones = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void registrarCliente(String nombre, String pais, boolean trajoMascota) {
        Cliente cliente = new Cliente(nombre, pais, trajoMascota);
        clientes.add(cliente);
    }

    public void registrarHabitacion(String tipo, boolean fumadores, int capacidadMaxima) {
        Habitacion habitacion = new Habitacion(tipo, fumadores, capacidadMaxima);
        habitaciones.add(habitacion);
    }

    public void realizarReserva(String nombreCliente, String tipoHabitacion, String periodoEstadia) {
        Cliente cliente = buscarCliente(nombreCliente);
        Habitacion habitacion = buscarHabitacionDisponible(tipoHabitacion, periodoEstadia);

        if (cliente != null && habitacion != null) {
            Reserva reserva = new Reserva(cliente, habitacion, periodoEstadia);
            reservas.add(reserva);
            habitacion.incrementarPersonasOcupando();
        }
    }

    public int verificarCantidadHabitacionesReservadas() {
        return reservas.size();
    }

    private Cliente buscarCliente(String nombreCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                return cliente;
            }
        }
        return null;
    }

    private Habitacion buscarHabitacionDisponible(String tipoHabitacion, String periodoEstadia) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getTipo().equals(tipoHabitacion) && habitacion.estaDisponible(periodoEstadia)) {
                return habitacion;
            }
        }
        return null;
    }

    private class Cliente {
        private String nombre;
        private String pais;
        private boolean trajoMascota;

        public Cliente(String nombre, String pais, boolean trajoMascota) {
            this.nombre = nombre;
            this.pais = pais;
            this.trajoMascota = trajoMascota;
        }

        public String getNombre() {
            return nombre;
        }
    }

    private class Habitacion {
        private String tipo;
        private boolean fumadores;
        private int capacidadMaxima;
        private int personasOcupando;

        public Habitacion(String tipo, boolean fumadores, int capacidadMaxima) {
            this.tipo = tipo;
            this.fumadores = fumadores;
            this.capacidadMaxima = capacidadMaxima;
            this.personasOcupando = 0;
        }

        public String getTipo() {
            return tipo;
        }

        public boolean estaDisponible(String periodoEstadia) {
            // Lógica para verificar disponibilidad en el periodo de estadía
            return true;
        }

        public void incrementarPersonasOcupando() {
            personasOcupando++;
        }
    }

    private class Reserva {
        private Cliente cliente;
        private Habitacion habitacion;
        private String periodoEstadia;

        public Reserva(Cliente cliente, Habitacion habitacion, String periodoEstadia) {
            this.cliente = cliente;
            this.habitacion = habitacion;
            this.periodoEstadia = periodoEstadia;
        }
    }
}
}
