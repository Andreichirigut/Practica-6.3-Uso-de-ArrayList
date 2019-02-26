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
import java.util.ArrayList;

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
    private ArrayList<Cliente> clientes;
    /* Atributos para controlar el total de vehiculos disponibles en
    alquiler que tiene la empresa y array de almacenamiento para los objetos
    Vehiculo */
    private int totalVehiculos;
    private ArrayList<Vehiculo> vehiculos;
    /* Atributos para controlar el histórico de alquileres: total de
    alquileres realizados y array de almacenamiento para los objetos
    8 VehiculoAlquilado */
    private int totalAlquileres;
    private ArrayList<VehiculoAlquilado> alquileres;

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

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getTotalAlquileres() {
        return totalAlquileres;
    }

    public void setTotalAlquileres(int totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }

    public ArrayList<VehiculoAlquilado> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(ArrayList<VehiculoAlquilado> alquileres) {
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
        this.clientes = new ArrayList<>(50); // apuntan a null
        // Incialmente no hay vehiculos creados en la empresa
        this.totalVehiculos = 0;
        this.vehiculos = new ArrayList<>(50); // apuntan a null
        // Incialmente no hay histórico de alquileres en la empresa
        this.totalAlquileres = 0;
        this.alquileres = new ArrayList<>(100); // apuntan a null

    }

    /*registrarCliente(Cliente nuevo). Añade un nuevo cliente a la lista de
    clientes de la empresa. El método registrarCliente(Cliente cliente)
    almacena un objeto de la clase Cliente en la última posición útil del array
    clientes, dada por la variable totalClientes y a continuación incrementa
    la variable totalClientes.*/
    public void registrarCliente(Cliente nuevo) {
        this.clientes.add(nuevo);

    }

    /*registrarVehiculo(Vehiculo n u e v o ). Añade un vehículo al catálogo
    de vehículos de la empresa. El método registrarVehiculo(Vehiculo vehiculo)
    almacena un objeto de la clase Vehiculo en la última posición del array
    vehiculos, dada por la variable totalVehiculos y a continuación incrementa
    la variable totalVehiculos.*/
    public void registrarVehiculo(Vehiculo nuevo) {
        this.vehiculos.add(nuevo);

    }

    /*imprimirClientes(). Muestra la relación de clientes de la empresa. Este
    método recorre el array clientes y va mostrando los datos de cada
    cliente.*/
    public void imprimirClientes() {
        System.out.println("NIF cliente\tNombre\n");
        for (Cliente c : this.clientes) {
            System.out.println(c.getApellidos());
            System.out.println(c.getNombre());
            System.out.println(c.getNif());
        }
    }


    /*imprimirVehiculos(). Muestra el catálogo de vehículos de la empresa,
    recorriendo el array vehiculos y llamando al método getAtributos() de cada
    uno .*/
    public void imprimirVehiculos() {
        System.out.println("Matricula\tModelo\tColor\tImporte\tDisponible\n ");
        for (Vehiculo v : this.vehiculos) {
            System.out.println(v.getColor());
            System.out.println(v.getMarca());
            System.out.println(v.getMatricula());
            System.out.println(v.getModelo());
            System.out.println(v.getTarifa());
            System.out.println(v.isDisponible());
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
        for (Cliente c : this.clientes) {
            if (c.getNif().equals(nif)) {
                return c;
            }
        }

        return null;
    }

    private Vehiculo getVehiculo(String matricula) {
        for (Vehiculo c : this.vehiculos) {
            if (c.getMatricula().equals(matricula)) {
                return c;
            }
        }

        return null;
    }

    public void alquilarVehiculo(String matricula, String nif,
            int dias) {

        Cliente cliente = getCliente(nif);
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            this.alquileres.add(
                    new VehiculoAlquilado(cliente, vehiculo, diaHoy(), mesHoy(), añoHoy(), dias));

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
        for (int i = 0; i < this.clientes.size() - clientesExistentes; i++) {
            registrarCliente(Cliente.clienteAleatorio());
        }
    }

    public void rellenarVehiculos() {
        int vehiculosExistentes = this.totalVehiculos;
        for (int i = 0; i < this.vehiculos.size() - vehiculosExistentes; i++) {
            registrarVehiculo(Vehiculo.vehiculoAleatorio());
        }
    }

    public ArrayList<Cliente> ordenarCliente() {
        Cliente tmp;
        for (int i = 0; i < clientes.size() - 1; i++) {
            for (int j = i + 1; j < clientes.size(); j++) {
                if (clientes.get(i).getNif().compareTo(clientes.get(j).getNif()) > 0) {
                    tmp = clientes.get(i);
                    clientes.set(i, clientes.get(j));
                    clientes.set(j, tmp);
                }
            }
        }

        return clientes;

    }

    public ArrayList<Vehiculo> ordenarVehiculos() {
        Vehiculo tmp;
        for (int i = 0; i < vehiculos.size() - 1; i++) {
            for (int j = i + 1; j < vehiculos.size(); j++) {
                if (vehiculos.get(i).getMatricula().compareTo(vehiculos.get(j).getMatricula()) > 0) {
                    tmp = vehiculos.get(i);
                    vehiculos.set(i, vehiculos.get(j));
                    vehiculos.set(j, tmp);
                }
            }
        }
        return vehiculos;
    }

    public int buscarCliente(String buscado) {
        int mitad;
        int izquierda = 0;
        int derecha = clientes.size() - 1;
        boolean encontrado = false;
        while ((izquierda <= derecha) && (!encontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (clientes.get(mitad).getNif().compareTo(buscado) == 0) {
                encontrado = true;
                System.out.println("Lo ha encontrado en la posicion: " + mitad);
                return mitad;
            } else if (clientes.get(mitad).getNif().compareTo(buscado) > 0) {
                derecha = mitad - 1;
            } //buscar en el trozo izquierdo
            else if (clientes.get(mitad).getNif().compareTo(buscado) < 0) {
                izquierda = mitad + 1; // buscar en el trozo derecho
            }

        }
        return -1;

    }

    public int buscarVehiculo(String buscado) {
        int mitad;
        int izquierda = 0;
        int derecha = vehiculos.size() - 1;
        boolean encontrado = false;
        while ((izquierda <= derecha) && (!encontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (vehiculos.get(mitad).getMatricula().compareTo(buscado) == 0) {
                encontrado = true;
                System.out.println("Lo ha encontrado en la posicion: " + mitad);
                return mitad;
            } else if (vehiculos.get(mitad).getMatricula().compareTo(buscado) > 0) {
                derecha = mitad - 1;
            } //buscar en el trozo izquierdo
            else if (vehiculos.get(mitad).getMatricula().compareTo(buscado) < 0) {
                izquierda = mitad + 1; // buscar en el trozo derecho
            }

        }
        return -1;

    }
}
