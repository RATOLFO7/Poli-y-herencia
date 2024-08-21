/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.y.herencia;

/**
 *
 * @author yursd
 */

// Main.java


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Producto> productos = new ArrayList<>();
    private static List<Proveedor> proveedores = new ArrayList<>();
    private static List<Categoria> categorias = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Agregar Proveedor");
            System.out.println("3. Agregar Categoria");
            System.out.println("4. Calcular Precio Total (Sin Descuento)");
            System.out.println("5. Calcular Precio Total (Con Descuento)");
            System.out.println("6. Calcular Precio Total por Categoria");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de linea

            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
                    break;
                case 2:
                    agregarProveedor(scanner);
                    break;
                case 3:
                    agregarCategoria(scanner);
                    break;
                case 4:
                    calcularPrecioTotalSinDescuento();
                    break;
                case 5:
                    calcularPrecioTotalConDescuento(scanner);
                    break;
                case 6:
                    calcularPrecioTotalPorCategoria(scanner);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    private static void agregarProducto(Scanner scanner) {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();
        
        System.out.print("Cantidad del producto: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de linea residual

        System.out.print("Nombre del proveedor: ");
        String nombreProveedor = scanner.nextLine();
        Proveedor proveedor = proveedores.stream()
                .filter(p -> p.getNombre().equals(nombreProveedor))
                .findFirst()
                .orElseGet(() -> {
                    Proveedor nuevoProveedor = new Proveedor(nombreProveedor);
                    proveedores.add(nuevoProveedor);
                    return nuevoProveedor;
                });

        System.out.print("Nombre de la categoria: ");
        String nombreCategoria = scanner.nextLine();
        Categoria categoria = categorias.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombreCategoria))
                .findFirst()
                .orElse(null);

        if (categoria == null) {
            System.out.println("Categoria no encontrada. Agregue la categoria primero.");
            return;
        }

        System.out.print("Tipo de producto (1 para Electronico, 2 para Alimenticio): ");
        int tipoProducto = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de linea residual despues de nextInt()

        Producto producto;
        if (tipoProducto == 1) {
            System.out.print("Garantia (en anos): ");
            int garantia = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de linea residual

            producto = new ProductoElectronico(nombre, precio, cantidad, proveedor, categoria, garantia);
        } else if (tipoProducto == 2) {
            System.out.print("Fecha de caducidad (AAAA-MM-DD): ");
            String fechaDeCaducidad = scanner.nextLine();

            producto = new ProductoAlimenticio(nombre, precio, cantidad, proveedor, categoria, fechaDeCaducidad);
        } else {
            System.out.println("Tipo de producto no valido. Debe ingresar 1 o 2.");
            return;
        }

        productos.add(producto);
        proveedor.agregarProducto(producto);
        System.out.println("Producto agregado.");
    }

    private static void agregarProveedor(Scanner scanner) {
        System.out.print("Nombre del proveedor: ");
        String nombre = scanner.nextLine();
        Proveedor proveedor = new Proveedor(nombre);
        proveedores.add(proveedor);
        System.out.println("Proveedor agregado.");
    }

    private static void agregarCategoria(Scanner scanner) {
        System.out.print("Nombre de la categoria: ");
        String nombre = scanner.nextLine();
        Categoria categoria = new Categoria(nombre);
        categorias.add(categoria);
        System.out.println("Categoria agregada.");
    }

    private static void calcularPrecioTotalSinDescuento() {
        CalculadorDePrecio calculador = new CalculadorDePrecioSinDescuento();
        GestorDeInventario gestor = new GestorDeInventario(calculador);
        double total = gestor.calcularPrecioTotalInventario(productos);
        System.out.printf("Precio total sin descuento: %.2f%n", total);
    }

    private static void calcularPrecioTotalConDescuento(Scanner scanner) {
        System.out.print("Porcentaje de descuento: ");
        double porcentajeDescuento = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de linea residual

        CalculadorDePrecio calculador = new CalculadorDePrecioConDescuento(porcentajeDescuento);
        GestorDeInventario gestor = new GestorDeInventario(calculador);
        double total = gestor.calcularPrecioTotalInventario(productos);
        System.out.printf("Precio total con descuento: %.2f%n", total);
    }

    private static void calcularPrecioTotalPorCategoria(Scanner scanner) {
        System.out.print("Nombre de la categoria para calcular el precio total: ");
        String nombreCategoria = scanner.nextLine();
        Categoria categoria = categorias.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombreCategoria))
                .findFirst()
                .orElse(null);

        if (categoria == null) {
            System.out.println("Categoria no encontrada.");
            return;
        }

        CalculadorDePrecio calculador = new CalculadorDePrecioPorCategoria(categoria);
        GestorDeInventario gestor = new GestorDeInventario(calculador);
        double total = gestor.calcularPrecioTotalInventario(productos);
        System.out.printf("Precio total para la categoria '%s': %.2f%n", nombreCategoria, total);
    }
}


