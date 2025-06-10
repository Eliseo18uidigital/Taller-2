import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        List<Persona> listaPersonas = new ArrayList<>(); // Usaremos una lista para guardar personas

        String quiereSeguir = "si";

        // Bucle para ingresar personas
        while (quiereSeguir.equalsIgnoreCase("si")) {
            System.out.println("\n--- Ingresar Nueva Persona ---");
            System.out.print("Nombre: ");
            String nombre = lector.nextLine();
            System.out.print("Apellido: ");
            String apellido = lector.nextLine();
            System.out.print("Edad: ");
            int edad = Integer.parseInt(lector.nextLine()); // Convertimos texto a número
            System.out.print("Género (masculino/femenino): ");
            String genero = lector.nextLine();
            System.out.print("Sueldo por Hora: ");
            double sueldoHora = Double.parseDouble(lector.nextLine()); // Convertimos texto a número
            System.out.print("Cargo: ");
            String cargo = lector.nextLine();

            Persona nuevaPersona = new Persona(nombre, apellido, edad, genero, sueldoHora, cargo);
            listaPersonas.add(nuevaPersona);

            System.out.print("¿Desea ingresar otra persona? (si/no): ");
            quiereSeguir = lector.nextLine();
        }

        lector.close(); //

        System.out.println("\n--- Realizando Operaciones con Lambdas ---");

        // a. Cantidad de personas almacenadas
        long cantidadPersonas = listaPersonas.stream().count();
        System.out.println("\nTotal de personas almacenadas: " + cantidadPersonas);

        // b. Promedio de edades de personas
        OptionalDouble promedioEdades = listaPersonas.stream()
                .mapToInt(Persona::getEdad) // Obtiene solo la edad de cada persona
                .average(); // Calcula el promedio de las edades
        if (promedioEdades.isPresent()) {
            System.out.println("Promedio de edades: " + String.format("%.2f", promedioEdades.orElse(0.0)));
        } else {
            System.out.println("No hay personas para calcular el promedio de edades.");
        }

        // c. Cantidad de personas mayores de edad (asumimos >=18)
        long mayoresEdad = listaPersonas.stream()
                .filter(persona -> persona.getEdad() >= 18) // Filtra personas con edad >= 18
                .count();
        System.out.println("Cantidad de personas mayores de edad: " + mayoresEdad);

        // d. Personas cuyos nombres empiezan con “A”
        System.out.println("\nPersonas con nombres que empiezan con 'A':");
        listaPersonas.stream()
                .filter(persona -> persona.getNombre().startsWith("A") || persona.getNombre().startsWith("a")) // Filtra por nombres que empiezan con 'A'
                .forEach(persona -> System.out.println("  - " + persona.getNombre())); // Imprime cada nombre

        // e. Personas cuyos apellidos contengan la letra “M”
        System.out.println("\nPersonas con apellidos que contienen 'M':");
        listaPersonas.stream()
                .filter(persona -> persona.getApellido().contains("M") || persona.getApellido().contains("m")) // Filtra por apellidos que contienen 'M'
                .forEach(persona -> System.out.println("  - " + persona.getApellido())); // Imprime cada apellido

        // --- Operaciones del Ejercicio 3 ---

        System.out.println("\n--- Operaciones Adicionales con Lambdas ---");

        // 3a. Sueldo de 8 horas de directores masculinos
        System.out.println("\nSueldos de 8 horas para Directores Masculinos:");
        listaPersonas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("director") && p.getGenero().equalsIgnoreCase("masculino")) // Filtra Directores Masculinos
                .map(p -> { // Calcula el sueldo por 8 horas
                    double sueldo8Horas = p.getSueldoHora() * 8;
                    System.out.println("Nombre: " + p.getNombre() + " " + p.getApellido() +
                            " Sueldo por 8 horas: $" + String.format("%.2f", sueldo8Horas));
                    return sueldo8Horas; // Retorna el sueldo
                })
                .collect(Collectors.toList()); // Usamos collect para "activar" el stream si peek es la última operación

        // 3b. Primera persona "desarrollador" y "femenino"
        System.out.println("\nPrimera Desarrolladora Femenina:");
        Optional<Persona> primeraDesarrolladora = listaPersonas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador") && p.getGenero().equalsIgnoreCase("femenino")) // Filtra desarrolladoras femeninas
                .findFirst(); // Encuentra la primera
        if (primeraDesarrolladora.isPresent()) {
            System.out.println("  " + primeraDesarrolladora.get());
        } else {
            System.out.println("  No se encontró ninguna desarrolladora femenina.");
        }

        // 3c. Desarrollador que más gana por hora
        System.out.println("\nDesarrollador que más gana por hora:");
        Optional<Persona> masGana = listaPersonas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador")) // Solo desarrolladores
                .max(Comparator.comparingDouble(Persona::getSueldoHora)); // Encuentra el máximo usando el sueldo por hora

        if (masGana.isPresent()) {
            System.out.println("  " + masGana.get());
        } else {
            System.out.println("  No se encontró ningún desarrollador.");
        }

        // 3d. Mujeres ordenadas por nombre
        System.out.println("\nMujeres ordenadas por nombre:");
        listaPersonas.stream()
                .filter(p -> p.getGenero().equalsIgnoreCase("femenino")) // Solo mujeres
                .sorted(Comparator.comparing(Persona::getNombre)) // Ordena por nombre
                .forEach(p -> System.out.println("  - " + p.getNombre() + " " + p.getApellido())); // Muestra el nombre y apellido
    }
}
