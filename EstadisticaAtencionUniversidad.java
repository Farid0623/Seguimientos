public class EstadisticaAtencionUniversidad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidadUsuariosAtendidos = 0;
        int cantidadUsuariosLlamadaTelefonica = 0;
        int cantidadUsuariosAsesoriaEstudiante = 0;
        int cantidadUsuariosAsesoriaDirectivo = 0;

        while (true) {
            System.out.println("Ingrese el número de cédula del usuario (0 para salir):");
            int cedula = scanner.nextInt();
            if (cedula == 0) {
                break;
            }

            System.out.println("Ingrese el tipo de atención (1: Llamada telefónica, 2: Asesoría):");
            int tipoAtencion = scanner.nextInt();

            if (tipoAtencion == 1) {
                cantidadUsuariosAtendidos++;
                cantidadUsuariosLlamadaTelefonica++;
            } else if (tipoAtencion == 2) {
                System.out.println("Ingrese el tipo de asesoría (1: Estudiante, 2: Directivo):");
                int tipoAsesoria = scanner.nextInt();
                cantidadUsuariosAtendidos++;

                if (tipoAsesoria == 1) {
                    cantidadUsuariosAsesoriaEstudiante++;
                } else if (tipoAsesoria == 2) {
                    cantidadUsuariosAsesoriaDirectivo++;
                }
            }
        }

        System.out.println("Estadísticas de atención:");
        System.out.println("Cantidad total de usuarios atendidos: " + cantidadUsuariosAtendidos);
        System.out.println("Cantidad de usuarios atendidos por llamada telefónica: " + cantidadUsuariosLlamadaTelefonica);
        System.out.println("Cantidad de usuarios atendidos en asesoría de estudiantes: " + cantidadUsuariosAsesoriaEstudiante);
        System.out.println("Cantidad de usuarios atendidos en asesoría de directivos: " + cantidadUsuariosAsesoriaDirectivo);
    }
}
}
