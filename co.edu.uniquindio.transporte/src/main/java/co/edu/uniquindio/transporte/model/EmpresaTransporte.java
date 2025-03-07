package co.edu.uniquindio.transporte.model;

import co.edu.uniquindio.transporte.services.IEmpresaTransportServices;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte implements IEmpresaTransportServices {

    private String nombre;

    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private List<VehiculoPasajero> listaVehiculosPasajeros = new ArrayList<>();
    private List<Propietario> listaAsociados = new ArrayList<>();

    public EmpresaTransporte() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<VehiculoCarga> getListaVehiculosCarga() {
        return listaVehiculosCarga;
    }

    public void setListaVehiculosCarga(List<VehiculoCarga> listaVehiculosCarga) {
        this.listaVehiculosCarga = listaVehiculosCarga;
    }

    public List<VehiculoPasajero> getListaVehiculosPasajeros() {
        return listaVehiculosPasajeros;
    }

    public void setListaVehiculosPasajeros(List<VehiculoPasajero> listaVehiculosPasajeros) {
        this.listaVehiculosPasajeros = listaVehiculosPasajeros;
    }

    public List<Propietario> getListaPropietarios() {
        return listaAsociados;
    }

    public void setListaAsociados(List<Propietario> listaAsociados) {
        this.listaAsociados = listaAsociados;
    }

    public void mostrarVehiculosCargaMayorEje(int numeroEjes) {
        for (Propietario propietario: getListaPropietarios()) {
            for (VehiculoCarga vehiculo: propietario.getListaVehiculosAsociados()) {
                if(vehiculo.getNumeroEjes() >= numeroEjes){
                    System.out.println(vehiculo.toString());
                }
            }
        }
    }

    public String buscarVehiculoCargaPlaca(String placa) {
        String resultado = "";
        for (VehiculoCarga vehiculo: getListaVehiculosCarga()) {
            if(vehiculo.getPlaca().equalsIgnoreCase(placa)){
                resultado = vehiculo.toString();
                break;
            }
        }

        return resultado;
    }

    public String buscarPropietarioNombre(String nombre) {
        String resultado = "";
        for (Propietario propietario: getListaPropietarios()) {
            if(propietario.getNombre().equalsIgnoreCase(nombre)){
                resultado = propietario.toString();
                break;
            }
        }

        return resultado;
    }

    @Override
    public boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular) {
        Propietario propietario = obtenerPropietario(numeroIdentificacion);
        if(propietario == null){
            propietario = new Propietario();
            propietario.setNombre(nombre);
            propietario.setNumeroIdentificacion(numeroIdentificacion);
            propietario.setEmail(email);
            propietario.setNumeroCelular(numeroCelular);
            getListaPropietarios().add(propietario);

            return true;
        }else{
            return false;
        }
    }

    @Override
    public Propietario obtenerPropietario(String numeroIdentificacion) {
        Propietario propietarioEncontrado = null;
        for (Propietario propietario: getListaPropietarios()) {
            if(propietario.getNumeroIdentificacion().equalsIgnoreCase(numeroIdentificacion)){
                propietarioEncontrado = propietario;
                break;
            }
        }

        return propietarioEncontrado;
    }

    @Override
    public boolean eliminarPropietario(String numeroIdentificacion) {
        Propietario propietario = obtenerPropietario(numeroIdentificacion);
        if(propietario != null){
            getListaPropietarios().remove(propietario);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean actualizarPropietario(String nombre, String numeroIdentificacionActual, String numeroIdentificacion, String email, String numeroCelular) {
        Propietario propietario = obtenerPropietario(numeroIdentificacionActual);
        if(propietario != null){
            propietario.setNombre(nombre);
            propietario.setNumeroIdentificacion(numeroIdentificacion);
            propietario.setEmail(email);
            propietario.setNumeroCelular(numeroCelular);

            return true;
        }else{
            return false;
        }
    }
}












