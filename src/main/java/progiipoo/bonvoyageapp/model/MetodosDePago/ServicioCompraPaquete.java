package progiipoo.bonvoyageapp.model.MetodosDePago;

import progiipoo.bonvoyageapp.model.usuarios.Cliente;
import progiipoo.bonvoyageapp.model.viaje.Alojamiento;
import progiipoo.bonvoyageapp.model.viaje.Vuelo;

public class ServicioCompraPaquete {
    private Cliente cliente;
    private Vuelo vuelo;
    private Alojamiento alojamiento;

    //constructor
    public ServicioCompraPaquete(Cliente cliente, Vuelo vuelo, Alojamiento alojamiento) {
        this.cliente = cliente;
        this.vuelo = vuelo;
        this.alojamiento = alojamiento;
    }


    public boolean realizarCompra(MetodoDePago metodoDePago) {
        double montoTotal = vuelo.getPrecio() + alojamiento.getPrecio();

        ServiciosPago servicioDePago = new ServiciosPago(metodoDePago);

        return servicioDePago.procesarPago(montoTotal);
    }
}