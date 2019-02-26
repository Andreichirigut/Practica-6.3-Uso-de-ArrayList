/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*LOS METODOS PARA RELLENAR ARRAYS DE VEHICULOS Y CLIENTES DEBEN RELLENAR LAS 50 POSICIONES */

package empresa;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

/**
 *
 * @author andrei
 */
public class EmpresaAlquiler {
    // Atributos de la empresa

    private String cif;
    private String nombre;
    private String paginaWeb;
    /* Atributos para controlar el total de clientes que tiene la
    empresa y array de almacenamiento para los objetos Cliente */
    private int totalClientes;
    private Cliente[] clientes;
    /* Atributos para controlar el total de vehiculos disponibles en
    alquiler que tiene la empresa y array de almacenamiento para los objetos
    Vehiculo */
    private int totalVehiculos;
    private Vehiculo[] vehiculos;
    /* Atributos para controlar el histórico de alquileres: total de
    alquileres realizados y array de almacenamiento para los objetos
    8 VehiculoAlquilado */
    private int totalAlquileres;
    private VehiculoAlquilado[] alquileres;

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getTotalClientes() {
        return totalClientes;
    }

    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getTotalAlquileres() {
        return totalAlquileres;
    }

    public void setTotalAlquileres(int totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }

    public VehiculoAlquilado[] getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(VehiculoAlquilado[] alquileres) {
        this.alquileres = alquileres;
    }

    // se omiten los métodos ‘get’ y ‘set’ de la clase
    /* Constructor parametrizado donde se establece que el total de clientes
    será 50, igual que el total de vehiculos disponibles. El histórico de
    vehiculos puede contener hasta 100 elementos */
    EmpresaAlquiler(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        // Incialmente no hay clientes creados en la empresa
        this.totalClientes = 0;
        this.clientes = new Cliente[50]; // apuntan a null
        // Incialmente no hay vehiculos creados en la empresa
        this.totalVehiculos = 0;
        this.vehiculos = new Vehiculo[50]; // apuntan a null
        // Incialmente no hay histórico de alquileres en la empresa
        this.totalAlquileres = 0;
        this.alquileres = new VehiculoAlquilado[100]; // apuntan a null

    }

    /*registrarCliente(Cliente nuevo). Añade un nuevo cliente a la lista de
    clientes de la empresa. El método registrarCliente(Cliente cliente)
    almacena un objeto de la clase Cliente en la última posición útil del array
    clientes, dada por la variable totalClientes y a continuación incrementa
    la variable totalClientes.*/
    public void registrarCliente(Cliente nuevo) {
        this.clientes[this.totalClientes] = nuevo;
        this.totalClientes++;
    }

    /*registrarVehiculo(Vehiculo n u e v o ). Añade un vehículo al catálogo
    de vehículos de la empresa. El método registrarVehiculo(Vehiculo vehiculo)
    almacena un objeto de la clase Vehiculo en la última posición del array
    vehiculos, dada por la variable totalVehiculos y a continuación incrementa
    la variable totalVehiculos.*/
    public void registrarVehiculo(Vehiculo nuevo) {
        this.vehiculos[this.totalVehiculos] = nuevo;
        this.totalVehiculos++;
    }

    /*imprimirClientes(). Muestra la relación de clientes de la empresa. Este
    método recorre el array clientes y va mostrando los datos de cada
    cliente.*/
    public void imprimirClientes() {
        System.out.println("NIF cliente\tNombre\n");
        for (int i = 0; i < this.totalClientes; i++) {
            System.out.println(clientes[i].toString());
        }
    }

    /*imprimirVehiculos(). Muestra el catálogo de vehículos de la empresa,
    recorriendo el array vehiculos y llamando al método getAtributos() de cada
    uno .*/
    public void imprimirVehiculos() {
        System.out.println("Matricula\tModelo\tColor\tImporte\tDisponible\n ");
        for (int i = 0; i < this.totalVehiculos; i++) {
            System.out.println(vehiculos[i].toString());
        }
    }

    /*alquilarVehiculo(String matricula,String nif,int dias). Modifica
    la disponibilidad del vehículo para indicar que está alquilado y añade un objeto
    de tipo VehiculoAlquilado al array de vehículos alquilados. Para
    registrar el alquiler de un vehículo por un cliente se usa estel método. El
    método getCliente(String nif) busca la referencia del cliente con el NIF
    dado en el array clientes. De forma similar, el método getVehiculo(String
    matricula) busca la referencia del vehículo con la matrícula dada en el
    array vehiculos. Una vez encontrado el vehículo con la matrícula indicada,
    se verifica si está disponible para alquilar y se modifica su
    disponibilidad. A continuación, almacena un objeto de tipo
    VehiculoAlquilado en el array alquileres.Este objeto relaciona un
    cliente, un vehículo, la fecha actual y los días de alquiler.*/
    private Cliente getCliente(String nif) {
        for (int i = 0; i < this.getTotalClientes(); i++) {
            if (this.clientes[i].getNif().equals(nif)) {
                return this.clientes[i];
            }
        }
        return null;
    }

    private Vehiculo getVehiculo(String matricula) {
        for (int i = 0; i < this.totalVehiculos; i++) {
            if (this.vehiculos[i].getMatricula().equals(matricula)) {
                return this.vehiculos[i];
            }
        }
        return null;
    }

    public void alquilarVehiculo(String matricula, String nif, int dias) {
        Cliente cliente = getCliente(nif);
        Vehiculo vehiculo = getVehiculo(matricula);
        // busca el cliente con el NIF dado en el array
        // clientes y el vehículo con la matrícula dada en el
        // array vehiculos, si el vehículo está disponible se
        // alquila con la fecha actual, que se obtiene
        // ejecutando los métodos diaHoy(), mesHoy() y
        // añoHoy(), cuya declaración no se incluye
        if (vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            this.alquileres[this.totalAlquileres]
                    = new VehiculoAlquilado(cliente, vehiculo,
                            diaHoy(), mesHoy(), añoHoy(), dias);

            this.totalAlquileres++;
        }
    }

    public static int diaHoy() {
        return LocalDate.now().getDayOfMonth();
    }

    public static Month mesHoy() {
        return LocalDate.now().getMonth();
    }

    public static int añoHoy() {
        return LocalDate.now().getYear();
    }

    public void recibirVehiculo(String matricula) {
// busca el vehículo con la matrícula dada en el
// array vehiculos y modifica su disponibilidad
// para que se pueda alquilar de nuevo
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo != null) {
            vehiculo.setDisponible(true);
        }

    }

    @Override
    public String toString() {
        return "EmpresaAlquiler{" + "cif=" + cif + ", nombre=" + nombre + ", paginaWeb=" + paginaWeb + ", totalClientes=" + totalClientes + ", clientes=" + clientes + ", totalVehiculos=" + totalVehiculos + ", vehiculos=" + vehiculos + ", totalAlquileres=" + totalAlquileres + ", alquileres=" + alquileres + '}';
    }

    public void rellenarCLientes() {
        int clientesExistentes = this.totalClientes;
        for (int i = 0; i < this.clientes.length - clientesExistentes; i++) {
            registrarCliente(Cliente.clienteAleatorio());
        }
    }

    public void rellenarVehiculos() {
        int vehiculosExistentes = this.totalVehiculos;
        for (int i = 0; i < this.vehiculos.length - vehiculosExistentes; i++) {
            registrarVehiculo(Vehiculo.vehiculoAleatorio());
        }
    }

    public Cliente[] ordenarCliente() {
        Cliente tmp;
        for (int i = 0; i < clientes.length - 1; i++) {
            for (int j = i + 1; j < clientes.length; j++) {
                if (clientes[i].getNif().compareTo(clientes[j].getNif()) > 0) {
                    tmp = clientes[i];
                    clientes[i] = clientes[j];
                    clientes[j] = tmp;
                }
            }
        }

        return clientes;

    }

    public Vehiculo[] ordenarVehiculos() {
        Vehiculo tmp;
        for (int i = 0; i < vehiculos.length - 1; i++) {
            for (int j = i + 1; j < vehiculos.length; j++) {
                if (vehiculos[i].getMatricula().compareTo(vehiculos[j].getMatricula()) > 0) {
                    tmp = vehiculos[i];
                    vehiculos[i] = vehiculos[j];
                    vehiculos[j] = tmp;
                }
            }
        }
        return vehiculos;
    }

    public int buscarCliente(String buscado) {
        int mitad;
        int izquierda = 0;
        int derecha = clientes.length - 1;
        boolean encontrado = false;
        while ((izquierda <= derecha) && (!encontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (clientes[mitad].getNif().compareTo(buscado) == 0) {
                encontrado = true;
                System.out.println("Lo ha encontrado en la posicion: " + mitad);
                return mitad;
            } else if (clientes[mitad].getNif().compareTo(buscado) > 0) {
                derecha = mitad - 1;
            } //buscar en el trozo izquierdo
            else if (clientes[mitad].getNif().compareTo(buscado) < 0) {
                izquierda = mitad + 1; // buscar en el trozo derecho
            }

        }
        return -1;

    }

    public int buscarVehiculo(String buscado) {
        int mitad;
        int izquierda = 0;
        int derecha = vehiculos.length - 1;
        boolean encontrado = false;
        while ((izquierda <= derecha) && (!encontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (vehiculos[mitad].getMatricula().compareTo(buscado) == 0) {
                encontrado = true;
                System.out.println("Lo ha encontrado en la posicion: " + mitad);
                return mitad;
            } else if (vehiculos[mitad].getMatricula().compareTo(buscado) > 0) {
                derecha = mitad - 1;
            } //buscar en el trozo izquierdo
            else if (vehiculos[mitad].getMatricula().compareTo(buscado) < 0) {
                izquierda = mitad + 1; // buscar en el trozo derecho
            }

        }
        return -1;

    }
}
