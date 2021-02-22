/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import estructurasDatos.*;
import utilidades.IO_ES;
import java.util.InputMismatchException;
import utilidades.ValidarDatos;

/**
 * 
 * @author Pedro Alberto
 * @version 1
 */
public class Principal {

    static final int MAXIMOCLIENTES = 50;
    static final int MAXIMOPRODUCTOS = 50;
    static Cliente clienteBotica[] = new Cliente[MAXIMOCLIENTES];
    static Producto productosBotica[] = new Producto[MAXIMOPRODUCTOS];
    static int contadorCliente;
    static int contadorProductos;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
/*====================================================================================================
                                     MENU PRINCIPAL
====================================================================================================*/
/**
 * Metodo para listar el menu principal.
 */
        boolean salir = false;
        int opcion = 0;

        do {
            IO_ES.escribirLN("Bienvenidos a la aplicacion de la botica");
            IO_ES.escribirLN("----------------------------------------");
            IO_ES.escribirLN("              LA BOTICA                 ");
            IO_ES.escribirLN("1. Menu clientes");
            IO_ES.escribirLN("2. Menu para productos");
            IO_ES.escribirLN("0. Para salir del Menu");

            opcion = IO_ES.leerEntero("Introduzca el numero de la opcion que deseas realizar:", 0, 2);

            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:// Menu clientes
                    menuCliente(opcion);

                    break;

                case 2:// Menu productos
                    MenuProductos(opcion);
                    break;

            }

        } while (!salir);

    }

/*====================================================================================================
                                     MENU CLIENTES
====================================================================================================*/
/**
 * Metodo para listar el Menu de clientes.
 * @param opcion 
 */
    public static void menuCliente(int opcion) {
        boolean salir = false;

        while (!salir) {
            IO_ES.escribirLN("********SubMenu cliente**********");
            IO_ES.escribirLN("1. Crear cliente");
            IO_ES.escribirLN("2. Borrar cliente");
            IO_ES.escribirLN("3. Editar un cliente existente");
            IO_ES.escribirLN("4. Listar clientes");
            IO_ES.escribirLN("0. Para volver al menu principal");

            opcion = IO_ES.leerEntero("Introduzca el numero de la opcion que deseas realizar", 0, 4);
            switch (opcion) {
                case 0:
                    //Pulsamos 0 para salir del submenu
                    salir = true;
                    break;

                case 1:
                    // opcion 1 crear cliente
                    crearCliente();
                    break;

                case 2:
                    //Opcion 2 borrar cliente
                    bajaCliente();
                    break;

                case 3:
                    //Opcion 3 editar un cliente ya existente
                    modificarCliente();
                    break;
                case 4:
                    listarClientes();

            }
        }

    }
    
/*====================================================================================================
                                     CREAR CLIENTES
====================================================================================================*/

/**
 * Metodo para crear los clientes.
 */
    public static void crearCliente() {
        boolean arrayCompleto = false;
        boolean salir = false;
        String id;
        String nombre;
        String direccion;
        String telefono;
        boolean baja = false;

        id = IO_ES.leerCadena("Introduzca el documento nacional de identidad: ", 9);

        if (ValidarDatos.validarDocumento(id)) {
            if (comprobarCliente(id) == true) {
                IO_ES.escribirLN("El cliente ya existe ");

            } else {
                int contador = 0;

                for (int i = 0; i < MAXIMOCLIENTES && (arrayCompleto == false); i++) {

                    if (clienteBotica[i] == null) {
                        nombre = IO_ES.leerCadena("Introduzca el nombre del cliente");
                        direccion = IO_ES.leerCadena("Introduzca la direccion del cliente");
                        telefono = IO_ES.leerCadena("Introduza el telefono del cliente");
                        clienteBotica[contadorCliente] = new Cliente(id, nombre, direccion, telefono, baja);
                        contadorCliente++;
                        arrayCompleto = true;
                    } else {
                        arrayCompleto = false;
                        contador++;
                    }
                }

                if (contador == MAXIMOCLIENTES) {
                    IO_ES.escribirLN("La base de datos esta completa");
                }

            }
        } else {
            IO_ES.escribirLN("Documento no valido, vuelva a empezar");

        }
    }

    
/*====================================================================================================
                                     DAR BAJA CLIENTES
====================================================================================================*/
    /**
     * Metodo para cambiar el estado del atributo baja a true y asi no listarlo, simular la baja del cliente.
     */
    public static void bajaCliente() {
        Cliente modificarCliente;
        modificarCliente = validarCliente();
        if (modificarCliente != null) {
            IO_ES.escribirLN("El cliente a modificar es: \n" + modificarCliente);
            modificarCliente.setBaja(IO_ES.leerBooleano("¿Quieres dar de baja el cliente? si / no"));
            IO_ES.escribirLN("Los datos nuevos del cliente a modificar son: \n" + modificarCliente);

        }

    }

/*====================================================================================================
                                     MENU PARA MODIFICAR CLIENTES
====================================================================================================*/
/**
 * Metodo para listar el submenu de los clientes.
 */
    public static void modificarCliente() {
        boolean salir = false;

        while (!salir) {

            IO_ES.escribirLN("--------Submenu para modificar los datos de un cliente----------");
            IO_ES.escribirLN("1. Modificar el id del cliente");
            IO_ES.escribirLN("2. Modificar el nombre del cliente");
            IO_ES.escribirLN("3. Modificar la calle del cliente");
            IO_ES.escribirLN("4. Modificar el telefono del cliente");
            IO_ES.escribirLN("0. Salimos al menu principal");

            int opcion = IO_ES.leerEntero("Que opcion deseas seleccionar:", 4);

            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1: // Modificar el id del cliente
                    modificarId();
                    break;

                case 2: // Modificar el nombre del cliente
                    modificarNombre();
                    break;

                case 3://modificar la direccion del cliente
                    modificarDireccion();
                    break;

                case 4://Modificar el telefono
                    modificarTelefono();
                    break;

            }

        }

    }

    
/*====================================================================================================
                                     MODIFICAR EL ID CLIENTES
====================================================================================================*/
    /**
     * Modificar el id de los clientes.
     */
    public static void modificarId() {
        Cliente modificarCliente = null;
        modificarCliente = validarCliente();
        if (modificarCliente != null) {
            String nuevoId = IO_ES.leerCadena("Quieres modificar el cliente con id:  " + modificarCliente.getId() + "\n Introduzca el nuevo documento nacional para modificar el id al cliente", 9);
            ValidarDatos.validarDocumento(nuevoId);
            modificarCliente.setId(nuevoId);
        }

    }
/*====================================================================================================
                                     MODIFICAR EL NOMBRE DE LOS CLIENTES
====================================================================================================*/
/**
 * Metodo para modificar el nombre de los cliente.
 */
    public static void modificarNombre() {
        Cliente modificarCliente = null;
        modificarCliente = validarCliente();
        if (modificarCliente != null) {
            String nuevoNombre = IO_ES.leerCadena("Quieres modificar el cliente con id:  " + modificarCliente.getId() + "\n Introduzca el nuevo nombre");
            modificarCliente.setNombre(nuevoNombre);
            IO_ES.escribirLN("Datos del cliente modificado\n" + modificarCliente);
        }

    }
    
/*====================================================================================================
                        MODIFICAR LA DIRECCION DE LOS CLIENTES
====================================================================================================*/
/**
 * Metodo para modificar la direccion del cliente.
 */
    public static void modificarDireccion() {
        Cliente modificarCliente;
        modificarCliente = validarCliente();
        if (modificarCliente != null) {
            String nuevaDireccion = IO_ES.leerCadena("Quieres modificar el cliente con id:  " + modificarCliente.getId() + "\n Introduzca la nueva direccion para modificarla  al cliente", 9);
            modificarCliente.setDirecion(nuevaDireccion);
        }
    }
    
    
/*====================================================================================================
                        MODIFICAR TELEFONO DE LOS CLIENTES
====================================================================================================*/
/**
 * Metodo para modificar el telfono del cliente.
 */
    public static void modificarTelefono() {
        Cliente modificarCliente;
        modificarCliente = validarCliente();
        if (modificarCliente != null) {
            String nuevoTelefono = IO_ES.leerCadena("Quieres modificar el cliente con id:  " + modificarCliente.getId() + "\n Introduzca el nuevo telefono para modificarlo al cliente", 9);
            modificarCliente.setDirecion(nuevoTelefono);
        }
    }

/*====================================================================================================
                        LISTAR TODOS LOS CLIENTES
====================================================================================================*/
    /**
     * Metodo para listar todos clientes, que no tengan el atributio baja a true.
     */
    public static void listarClientes() {

        if (contadorCliente > 0) {
            for (int i = 0; i < MAXIMOCLIENTES; i++) {

                if (clienteBotica[i] != null && !clienteBotica[i].getBaja()) {

                    System.out.println(clienteBotica[i]);
                }

            }
        }
        System.out.println("no hay clientes en la base de dastos");

    }

    
    
/*====================================================================================================
                    METODO PARA COMPROBAR SI EXISTE EL CLIENTES
====================================================================================================*/
    /**
     * Metedo para comprobar que cliente existente dentro del array.
     * @param id
     * @return
     */
    public static boolean comprobarCliente(String id) {
        boolean clienteEncontrado = false;
        boolean salir = false;

        for (int i = 0; i < MAXIMOCLIENTES && !salir; i++) {
            if (clienteBotica[i] != null) {
                if (id.equalsIgnoreCase(clienteBotica[i].getId())) {
                    clienteEncontrado = true;
                    salir = true;
                }
            }
        }

        return clienteEncontrado;
    }

    
/*====================================================================================================
                    METODO PARA COMPROBAR QUE EL CLIENTE NO EXISTA
====================================================================================================*/
    /**
     * metodo para buscar si existe el cliente que queremos introducir, para que no haya duplicados
     * @param id
     * @return
     */
    public static Cliente buscarCliente(String id) {
        Cliente clienteEncontrado = null;
        boolean salir = false;

        for (int i = 0; i < MAXIMOCLIENTES && !salir; i++) {// recorrer el for con la varible maximo cliente

            if (clienteBotica[i] != null) {

                if (id.equalsIgnoreCase(clienteBotica[i].getId())) {
                    clienteEncontrado = clienteBotica[i];
                    salir = true;
                }
            } else {
                clienteEncontrado = null;
            }
        }

        return clienteEncontrado;
    }

/*===========================================================================================================
                                VALIDAR CLIENTE A MODIFICAR
============================================================================================================*/
    /**
     * Metodo donde validamos a partir de otro metodo que valida el dni y tambien hacemos la llamada al metodo para saber si el cliente existe en el array
     * @return 
     */
    public static Cliente validarCliente() {
        Cliente modificarCliente = null;
        if (contadorCliente > 0) {
            String id = IO_ES.leerCadena("Introduzca el documento nacional para modificar el nombre al cliente", 9);
            ValidarDatos.validarDocumento(id);
            modificarCliente = buscarCliente(id);
        }else{
            IO_ES.escribirLN("No hay clientes aun en la base de datos");
        }
        
        return modificarCliente;
    }

/*===========================================================================================================
                                MENU        PRODUCTOS
============================================================================================================*/
    
/**
 * Metodo para listar el menu  de los productos.
 * @param opcion 
 */
    public static void MenuProductos(int opcion) {
        boolean salir = false;

        do {
            IO_ES.escribirLN("********** Submenu Productos**********");
            IO_ES.escribirLN("1. Añadir productos");
            IO_ES.escribirLN("2. Eliminar productos");
            IO_ES.escribirLN("3. Modificar productos");
            IO_ES.escribirLN("4. Añadir unidades");
            IO_ES.escribirLN("5. Quitar unidades");
            IO_ES.escribirLN("6. Listar productos");
            IO_ES.escribirLN("0. Salir del menu de productos");

            opcion = IO_ES.leerEntero("Elige una de las opciones", 0, 6);

            switch (opcion) {
                case 0: //Pulsamos 0 para salir del submenu de productos
                    salir = true;
                    break;
                case 1:
                    crearProductos();
                    break;

                case 2:
                    bajaProducto();
                    break;
                case 3:
                    menuModificarProducto();
                    break;

                case 4:
                    sumarUnidades();
                    break;

                case 5:
                    restarUnidades();

                case 6:
                    listarProductos();
                    break;
            }

        } while (!salir);

    }

/*===========================================================================================================
                                        CREAR  PRODUCTOS
============================================================================================================*/
/**
 * Metodo para  crear los productos.
 */
    public static void crearProductos() {
        boolean arrayCompleto = false;
        boolean salir = false;
        String codigo;
        String nombre;
        String descripcion;
        float precio;
        int unidades;
        boolean baja = false;

        codigo = IO_ES.leerCadena("Introduzca el codigo del producto");

        if (Producto.comprobarCodigo(codigo)) {
            System.out.println("Codigo correcto");

            if (comprobarProductos(codigo) == true) {
                IO_ES.escribirLN("El cliente ya existe ");

            } else {
                int contador = 0;

                for (int i = 0; i < MAXIMOPRODUCTOS && !arrayCompleto; i++) {

                    if (productosBotica[i] == null) {
                        nombre = IO_ES.leerCadena("Introduzca nombre del producto");
                        descripcion = IO_ES.leerCadena("Introduzca descripcion del producto");
                        precio = IO_ES.leerReal("Introduzca el precio del producto");
                        unidades = IO_ES.leerEntero("Introduzca el numero de unidadess");
                        if (precio > 0 && unidades > 0) {

                            productosBotica[contadorProductos] = new Producto(codigo, nombre, descripcion, precio, unidades, baja);
                            contadorProductos++;
                            arrayCompleto = true;
                        }

                    } else {
                        IO_ES.escribirLN("El precio o las cantidades no pueden ser negativas");
                        arrayCompleto = false;
                        contadorProductos++;
                    }

                }
                if (contador == contadorProductos) {
                    IO_ES.escribirLN("La base de datos esta completa");
                }

            }

        } else {
            System.out.println("El codigo no es correcto");
        }

    }

/*===========================================================================================================
                                SUBMENU  MODIFICAR  PRODUCTOS
============================================================================================================*/
/**
 * Metodo para listar el submenu de los productos.
 */
    public static void menuModificarProducto() {
        boolean salir = false;

        IO_ES.escribirLN("--------- Submenu para modificar los productos--------------");
        IO_ES.escribirLN("1. Modificar codigo");
        IO_ES.escribirLN("2. Modificar nombre del producto");
        IO_ES.escribirLN("3. Modificar descripcion del producto");
        IO_ES.escribirLN("4. Modificar precio del producto");
        IO_ES.escribirLN("5. Modificar cantidad del producto");

        int opcion = IO_ES.leerEntero("Introduzca la opcion que deseas realizar");

        switch (opcion) {
            case 1:
                modificarCodigoProducto();
                break;

            case 2:
                modificarNombreProducto();
                break;

            case 3:
                modificarDescripcionProducto();
                break;

            case 4:
                modificarPrecio();
                break;
        }

    }

/*==========================================================================================
                                    BUSCAR PRODUCTOS
============================================================================================*/
/**
 * Metodo para buscar los productos dentro del array.
 * @param validarCodigo
 * @return 
 */
    public static Producto buscarProducto(String validarCodigo) {
        Producto productoEncontrado = null;
        boolean salir = false;
        System.out.println(validarCodigo);
        for (int i = 0; i < MAXIMOPRODUCTOS && !salir; i++) {

            if (productosBotica[i] != null) {

                if (validarCodigo.equalsIgnoreCase(productosBotica[i].getCodigo())) {
                    productoEncontrado = productosBotica[i];
                    salir = true;
                }

            }
        }
        return productoEncontrado;
    }

/*==========================================================================================
                                    BUSCAR SI PRODUCTO EXISTE
============================================================================================*/
/**
 * Metodo para buscar si el producto existe.
 * @param validarCodigo
 * @return 
 */
    public static boolean comprobarProductos(String validarCodigo) {

        boolean productoEncontrado = false;
        boolean salir = false;

        for (int i = 0; i < MAXIMOPRODUCTOS && !salir; i++) {
            if (productosBotica[i] != null) {
                if (validarCodigo.equalsIgnoreCase(productosBotica[i].getCodigo())) {
                    productoEncontrado = true;
                    salir = true;
                }
            }
        }

        return productoEncontrado;
    }

/*==========================================================================================
                                    LISTAR PRODUCTO 
============================================================================================*/
/**
 * Metodo para listar los productos.
 */
    public static void listarProductos() {

        for (int i = 0; i < MAXIMOPRODUCTOS; i++) {

            if (productosBotica[i] != null && !productosBotica[i].getBaja()) {
                System.out.println(productosBotica[i]);
            }
        }

    }


/*==========================================================================================
                                    BAJA PRODUCTO 
============================================================================================*/
/**
 * Metodo para pasar el atributo baja a true.
 */
    public static void bajaProducto() {
        Producto modificar;
        modificar = validarCodigo();

        if (modificar != null) {
            modificar.setBaja(IO_ES.leerBooleano("¿Quieres dar de baja al producto? Si / No"));
            IO_ES.escribirLN("Los nuevos datos del producto que se ha modificado son: \n" + modificar);
        }

    }

    /*==========================================================================================
                                    MODIFICAR CODIGO DEL PRODUCTO 
============================================================================================*/
/**
 * Metodo para modificar el codigo del producto.
 */
    public static void modificarCodigoProducto() {
        Producto modificar;
        modificar = validarCodigo();

        if (modificar != null) {
            String nuevoCodigo = IO_ES.leerCadena("Quieres modificar el codigo del producto:  " + modificar.getCodigo() + "\n Introduzca el nuevo codigo para el producto", 13);
            Producto.comprobarCodigo(nuevoCodigo);
            modificar.setCodigo(nuevoCodigo);
            IO_ES.escribirLN("Datos del producto modificado \n" + modificar);
        }

    }

    /*==========================================================================================
                                    MODIFICAR NOMBRE DEL PRODUCTO 
============================================================================================*/
/**
 * Metodo para modificar el nombre del producto.
 */
    public static void modificarNombreProducto() {

        Producto modificar;
        modificar = validarCodigo();

        if (modificar != null) {
            String nombre = IO_ES.leerCadena("Introduce el nuevo nombre del producto");
            modificar.setNombre(nombre);
            IO_ES.escribirLN("Los datos del producto modificado son: \n" + modificar);

        }

    }

    
/*====================================================================================================
                    METODO PARA MODIFICAR LA DESCRIPCION DEL PRODUCTO
====================================================================================================*/
/**
 * Metodo para modificar la descripcion del producto.
 */
    public static void modificarDescripcionProducto() {
        Producto modificar;
        modificar = validarCodigo();

        if (modificar != null) {

            String descripcion = IO_ES.leerCadena("Introduce la nueva descripcion del producto");
            modificar.setDescripcion(descripcion);
            IO_ES.escribirLN("Los datos del producto modificado son: \n" + modificar);
        }

    }

    /*==========================================================================================
                                    MODIFICAR PRECIO DEL PRODUCTO 
============================================================================================*/
/**
 * Metodo para modificar el precio del producto.
 */
    public static void modificarPrecio() {
        Producto modificar;
        modificar = validarCodigo();

        if (modificar != null) {
            float precio = IO_ES.leerReal("Introduzca el nuevo precio del producto");
            if (Producto.validarPrecio(precio)) {
                modificar.setPrecio(precio);
                IO_ES.escribirLN("Datos del producto modificado \n" + modificar);
            } else {
                System.out.println("El precio del producto no puede ser inferior a 0");
            }
        }

    }


    /*==========================================================================================
                                    SUMAR PRODUCTOS 
============================================================================================*/
/**
 * Metodo para sumar productos.
 */
    public static void sumarUnidades() {

        Producto modificar;
        modificar = validarCodigo();

        if (modificar != null) {
            int cantidad = IO_ES.leerEntero("Introduce la cantidad de productos a sumar");
            modificar.validarSumarProductos(cantidad);
            IO_ES.escribirLN("Datos del producto modificado \n" + modificar);
        }

    }

    /*==========================================================================================
                                    RESTAR PRODUCTOS 
============================================================================================*/
/**
 * Metodo para restar productos.
 */
    public static void restarUnidades() {
        Producto modificar;
        modificar = validarCodigo();

        if (modificar != null) {
            int cantidad = IO_ES.leerEntero("Introduce la cantidad de productos a restar");
            modificar.validarRestarProductos(cantidad);

            IO_ES.escribirLN(" Datos del producto modificado \n" + modificar);
        }
        IO_ES.escribirLN("La cantidad a restar no puede ser mayor que la cantidad de producto en ");

    }

    /*==========================================================================================
                                    Validar datos
============================================================================================*/
/**
 * Metodo para validar los datos de producto
 * @return 
 */
    public static Producto validarCodigo() {
        Producto modificar = null;
        String codigo;
        if (contadorProductos > 0) {
            codigo = IO_ES.leerCadena("Introduce el codigo del producto a modificar", 13);
            Producto.comprobarCodigo(codigo);
            modificar = buscarProducto(codigo);
        } else {
            IO_ES.escribirLN("Aun no hay productos en la base de datos");
        }

        return modificar;
    }
}
