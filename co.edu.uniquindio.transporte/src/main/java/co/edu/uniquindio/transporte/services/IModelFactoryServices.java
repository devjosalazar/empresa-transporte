package co.edu.uniquindio.transporte.services;

public interface IModelFactoryServices extends IPropietarioServices{

    String buscarVehiculoCargaPlaca(String placa);
    String buscarPropietarioNombre(String nombre);
}
