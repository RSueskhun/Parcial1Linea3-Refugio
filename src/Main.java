import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== REFUGIO DE ANIMALES ===");
            System.out.println("1. AGREGAR PERRO");
            System.out.println("2. BUSCAR PERRO POR ID");
            System.out.println("3. REGISTRAR ADOPCIÓN");
            System.out.println("4. VACUNAR PERRO");
            System.out.println("5. ESTERILIZAR PERRO");
            System.out.println("6. LISTAR PERROS DISPONIBLES");
            System.out.println("7. ELIMINAR PERRO POR ID");
            System.out.println("8. LISTAR TODOS LOS PERROS");
            System.out.println("0. SALIR");
            System.out.print("ELIGE UNA OPCIÓN: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1: {
                    System.out.print("NOMBRE: ");
                    String nombre = sc.nextLine();
                    System.out.print("RAZA: ");
                    String raza = sc.nextLine();
                    System.out.print("EDAD EN MESES: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("TAMAÑO (PEQUENO/MEDIANO/GRANDE): ");
                    String tamano = sc.nextLine();
                    System.out.print("¿VACUNADO? (TRUE/FALSE): ");
                    boolean vacunado = sc.nextBoolean();
                    System.out.print("¿ESTERILIZADO? (TRUE/FALSE): ");
                    boolean esterilizado = sc.nextBoolean();

                    Perro.listaPerros.add(new Perro(nombre, raza, edad, tamano, vacunado, esterilizado));
                    System.out.println("✅ PERRO AGREGADO CORRECTAMENTE");
                    break;
                }

                case 2: {
                    System.out.print("INGRESE ID DEL PERRO QUE BUSCA: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Perro encontrado = null;
                    for (Perro p : Perro.listaPerros) {
                        if (p.getId() == id) {
                            encontrado = p;
                            break;
                        }
                    }
                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("PERRO NO ENCONTRADO EN BD");
                    }
                    break;
                }

                case 3: {
                    System.out.print("INGRESE ID DEL PERRO A ADOPTAR: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Perro adop = null;
                    for (Perro p : Perro.listaPerros) {
                        if (p.getId() == id) {
                            adop = p;
                            break;
                        }
                    }
                    if (adop != null) {
                        System.out.print("INGRESE NOMBRE DEL ADOPTANTE: ");
                        String adoptante = sc.nextLine();
                        if (adop.marcarAdoptado(adoptante)) {
                            System.out.println("REGISTRO EXITOSO - PERRO ADOPTADO");
                        } else {
                            System.out.println("EL PERRO YA FUE ADOPTADO");
                        }
                    } else {
                        System.out.println("PERRO NO ENCONTRADO EN BD");
                    }
                    break;
                }

                case 4: {
                    System.out.print("INGRESE ID DEL PERRO A VACUNAR: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Perro vac = null;
                    for (Perro p : Perro.listaPerros) {
                        if (p.getId() == id) {
                            vac = p;
                            break;
                        }
                    }
                    if (vac != null) {
                        vac.vacunar();
                        System.out.println("REGISTRO EXITOSO - PERRO VACUNADO");
                    } else {
                        System.out.println("PERRO NO ENCONTRADO EN BD");
                    }
                    break;
                }

                case 5: {
                    System.out.print("INGRESE ID DEL PERRO A ESTERILIZAR: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Perro ester = null;
                    for (Perro p : Perro.listaPerros) {
                        if (p.getId() == id) {
                            ester = p;
                            break;
                        }
                    }
                    if (ester != null) {
                        ester.esterilizar();
                        System.out.println("REGISTRO EXITOSO - PERRO ESTERILIZADO");
                    } else {
                        System.out.println("PERRO NO ENCONTRADO EN BD");
                    }
                    break;
                }

                case 6: {
                    System.out.println("=== LISTADO DE PERROS DISPONIBLES ===");
                    boolean disponible = false;
                    for (Perro p : Perro.listaPerros) {
                        if (!p.isAdoptado()) {
                            System.out.println(p);
                            disponible = true;
                        }
                    }
                    if (!disponible) {
                        System.out.println("NO HAY PERROS DISPONIBLES ACTUALMENTE");
                    }
                    break;
                }

                case 7: {
                    System.out.print("INGRESE ID DEL PERRO A ELIMINAR: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    boolean eliminado = false;
                    for (Perro p : Perro.listaPerros) {
                        if (p.getId() == id) {
                            Perro.listaPerros.remove(p);
                            eliminado = true;
                            break;
                        }
                    }
                    if (eliminado) {
                        System.out.println("ID - PERRO ELIMINADO CORRECTAMENTE");
                    } else {
                        System.out.println("PERRO NO ENCONTRADO EN BD");
                    }
                    break;
                }

                case 8: {
                    System.out.println("=== LISTA DE TODOS LOS PERROS ===");
                    if (Perro.listaPerros.isEmpty()) {
                        System.out.println("NO HAY REGISTROS ACTUALES");
                    } else {
                        for (Perro p : Perro.listaPerros) {
                            System.out.println(p);
                        }
                    }
                    break;
                }

                case 0:
                    System.out.println("SALIENDO...");
                    break;

                default:
                    System.out.println("OPCIÓN NO VÁLIDA.");
                    break;
            }
        } while (opcion != 0);
    }
}
