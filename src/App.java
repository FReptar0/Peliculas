import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        ArrayList<Peliculas> listaPeliculas = new ArrayList<Peliculas>();
        ArrayList<Peliculas> listaPeliculasRentadas = new ArrayList<Peliculas>();

        int opc = 0;

        listaPeliculas.add(new Peliculas("P000", "Moustruos en la bahia", 44, "Gore", 5, 0, 0));
        listaPeliculas.add(new Peliculas("P001", "Moustruos en la bahia 2", 45, "Gore", 4, 0, 0));
        listaPeliculas.add(new Peliculas("P002", "Moustruos en la bahia 3", 46, "Gore", 3, 0, 0));
        listaPeliculas.add(new Peliculas("P003", "Moustruos en la bahia 4", 47, "Gore", 2, 0, 0));
        listaPeliculas.add(new Peliculas("P004", "Moustruos en la bahia 5", 48, "Gore", 1, 0, 0));

        Peliculas peliculas = new Peliculas();
        peliculas.setListaPeliculasDisponibles(listaPeliculas);

        while (opc != 3) {
            System.out.println("INGRESE UNA OPCION: \n1.- Tienda 2.- Administracion 3.- Salir");
            opc = sc.nextInt();

            switch (opc) {

                case 1:
                    int opc1 = 0;

                    while (opc1 != 3) {
                        System.out.println("1.- Rentar 2.- Devolver 3.- Atras 4.- Salir");
                        opc1 = sc.nextInt();

                        if (opc1 == 4) {
                            System.out.println("Saliendo...");
                            System.exit(0);
                        }

                        switch (opc1) {
                            case 1:
                                int validacion = 0;

                                System.out.println("Ingrese el codigo de la pelicula a rentar: ");
                                String codigo = sc.next();

                                for (Peliculas pelicula : listaPeliculas) {
                                    if (pelicula.getIdPelicula().equals(codigo)) {
                                        if (pelicula.getCantidad() > 0) {
                                            pelicula.setCantidad(pelicula.getCantidad() - 1);

                                            pelicula.setCantidadDeVecesRentada(
                                                    pelicula.getCantidadDeVecesRentada() + 1);

                                            pelicula.setCantidadRentas(pelicula.getCantidadRentas() + 1);
                                            listaPeliculasRentadas.add(pelicula);

                                            peliculas.setListaPeliculasDisponibles(listaPeliculas);
                                            peliculas.setListaPeliculasEnRenta(listaPeliculasRentadas);
                                            validacion = 1;
                                            break;
                                        }
                                    }
                                }

                                if (validacion == 0) {
                                    System.out.println("No se encontro la pelicula");
                                } else {
                                    System.out.println("Se rento la pelicula exitosamente");
                                }

                                for (Peliculas peli : listaPeliculas) {
                                    if (peli.getIdPelicula().equals(codigo)) {
                                        if (peli.getCantidad() == 0) {
                                            listaPeliculas.remove(peli);
                                            peliculas.setListaPeliculasDisponibles(listaPeliculas);
                                            break;
                                        }
                                    }
                                }

                                break;
                            case 2:
                                int validacionDevolucion = 0;

                                System.out.println("Ingrese el codigo de la pelicula a devolver: ");
                                String codigoDevolucion = sc.next();

                                for (Peliculas pelicula : listaPeliculasRentadas) {
                                    if (pelicula.getIdPelicula().equals(codigoDevolucion)) {
                                        pelicula.setCantidad(pelicula.getCantidad() + 1);
                                        listaPeliculas.add(pelicula);
                                        peliculas.setListaPeliculasDisponibles(listaPeliculas);
                                        peliculas.setListaPeliculasEnRenta(listaPeliculasRentadas);
                                        validacionDevolucion = 1;
                                        System.out.println("Pelicula devuelta exitosamente");
                                        break;
                                    }
                                }

                                if (validacionDevolucion == 0) {
                                    System.out.println("No se encontro la pelicula");
                                } else {
                                    System.out.println("Se devolvio la pelicula exitosamente");
                                }

                                for (Peliculas peli : listaPeliculasRentadas) {
                                    if (peli.getIdPelicula().equals(codigoDevolucion)) {
                                        if (peli.getCantidadRentas() == 0) {
                                            listaPeliculasRentadas.remove(peli);
                                            peliculas.setListaPeliculasEnRenta(listaPeliculasRentadas);
                                            break;
                                        }
                                    }
                                }

                                break;
                            case 3:
                                System.out.println("");
                                break;

                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }
                    }
                    break;

                case 2:
                    int opc2 = 0;

                    while (opc2 != 4) {
                        System.out.println(
                                "1.- Agregar pelicula 2.- Eliminar pelicula 3.- Reporte 4.- Atras 5.- Salir");
                        opc2 = sc.nextInt();

                        if (opc2 == 5) {
                            System.out.println("Saliendo...");
                            System.exit(0);
                        }

                        switch (opc2) {
                            case 1:
                                String idPelicula;
                                String titulo;
                                double duracion;
                                String genero;
                                int cantidad;

                                System.out.println(
                                        "REGISTRO DE PELICULA\nIngrese el identificador de la pelicula (P###)");
                                idPelicula = sc.next();

                                System.out.println("Ingrese el titulo de la pelicula");
                                titulo = sc.next();

                                System.out.println("Ingrese la duracion de: " + titulo);
                                duracion = sc.nextDouble();

                                System.out.println("Ingrese el genero de: " + titulo);
                                genero = sc.next();

                                System.out.println("Ingrese la cantidad disponible para: " + titulo);
                                cantidad = sc.nextInt();

                                Peliculas pelicula = new Peliculas(idPelicula, titulo, duracion, genero, cantidad,
                                        cantidad, 0);
                                peliculas.agregarPelicula(pelicula);

                                break;

                            case 2:
                                System.out.println("Ingrese el codigo de la pelicula a eliminar: ");
                                String codigo = sc.next();

                                peliculas.eliminarPelicula(codigo);
                                break;

                            case 3:
                                System.out.println("Peliculas disponibles: ");
                                peliculas.mostrarPeliculasDisponibles();

                                System.out.println("Peliculas rentadas: ");
                                peliculas.mostrarPeliculasEnRenta();

                                peliculas.mostrarPeliculaMasRentada();

                                peliculas.mostrarPeliculaMenosRentada();
                                break;

                            case 4:
                                System.out.println("");
                                break;

                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
        sc.close();
    }
}
