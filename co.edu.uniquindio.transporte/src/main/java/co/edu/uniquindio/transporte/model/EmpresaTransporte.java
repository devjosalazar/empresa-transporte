package co.edu.uniquindio.transporte.model;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte {

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
}
