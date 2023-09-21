public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
public class CarritoDeCompras {
    private List<Producto> productos;

    // Constructor
    public CarritoDeCompras() {
        this.productos = new ArrayList<>();
    }
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad: " + producto.getStock());
            System.out.println("Subtotal: " + (producto.getPrecio() * producto.getStock()));
            System.out.println("---------------------------");
        }
    }
    public double calcularTotalCompra() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getStock();
        }
        return total;
    }
}
    public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Camiseta", 20.0, 2);
        Producto producto2 = new Producto("Pantalón", 30.0, 1);
        Producto producto3 = new Producto("Zapatos", 50.0, 1);


        CarritoDeCompras carrito = new CarritoDeCompras();

        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);
        carrito.agregarProducto(producto3);


        carrito.mostrarProductos();


        double totalCompra = carrito.calcularTotalCompra();
        System.out.println("Total de la compra: " + totalCompra);
    }
}
}
