package progiipoo.bonvoyageapp.controller.sesionCliente;

import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import progiipoo.bonvoyageapp.controller.GestorEscenas;
import progiipoo.bonvoyageapp.model.gestores.GestoraViaje;
import progiipoo.bonvoyageapp.model.usuarios.Cliente;
import progiipoo.bonvoyageapp.model.usuarios.Usuario;
import progiipoo.bonvoyageapp.model.viaje.SeguroViaje;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

public class SeguroController extends SesionClienteController implements Initializable{
    @FXML
    private Button btnAlojamiento;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnComprar;

    @FXML
    private Button btnMiCuenta;

    @FXML
    private Button btnOfertas;

    @FXML
    private Button btnPaquetes;

    @FXML
    private Button btnSeguros;

    @FXML
    private Button btnVuelos;

    @FXML
    private TableColumn<SeguroViaje, String> colAsistenciaMedica;

    @FXML
    private TableColumn<SeguroController, Integer> colCantidadDias;

    @FXML
    private TableColumn<SeguroViaje, String> colEquipaje;

    @FXML
    private TableColumn<SeguroViaje, String> colMedicamentos;

    @FXML
    private TableColumn<SeguroViaje, String> colTipoAsistencia;

    @FXML
    private TableColumn<SeguroViaje, String> colVueloDemorado;

    @FXML
    private TableColumn<SeguroViaje, Double> colPrecio;

    @FXML
    private DatePicker partida;

    @FXML
    private DatePicker regreso;

    @FXML
    private TableView<SeguroViaje> tblSeguros;

    @FXML
    private TextField txtDestino;

    private ObservableList<SeguroViaje> seguros = FXCollections.observableArrayList();

    public SeguroController() {
        super();
    }

    public SeguroController(Cliente usuario) {
        super(usuario);
    }

    @FXML
    void onAlojamientoClick(ActionEvent event) {
        GestorEscenas.abrirEscena(event, "/progiipoo/bonvoyageapp/sesionCliente/alojamiento.fxml", usuario);
    }

    @FXML
    void onBuscarClick(ActionEvent event) {
        String destino = txtDestino.getText();
        Integer cantDias = (int) ChronoUnit.DAYS.between(partida.getValue(), regreso.getValue());

        seguros.clear();

        seguros.addAll(GestoraViaje.getSeguros(destino));

        colCantidadDias.setCellValueFactory(cellData -> {return new SimpleIntegerProperty(cantDias).asObject();});

        tblSeguros.setItems(seguros);
        txtDestino.setText("");
        partida.setValue(null);
        regreso.setValue(null);
    }

    @FXML
    void onCerrarSesionClick(ActionEvent event) {
        GestorEscenas.abrirEscena(event, "/progiipoo/bonvoyageapp/inicio.fxml");
    }

    @FXML
    void onComprarClick(ActionEvent event) {

    }

    @FXML
    void onMiCuentaClick(ActionEvent event) {

    }

    @FXML
    void onOfertasClick(ActionEvent event) {
        GestorEscenas.abrirEscena(event, "/progiipoo/bonvoyageapp/sesionCliente/sesionCliente.fxml", usuario);
    }

    @FXML
    void onPaquetesClick(ActionEvent event) {
        GestorEscenas.abrirEscena(event, "/progiipoo/bonvoyageapp/sesionCliente/paquete.fxml", usuario);
    }

    @FXML
    void onSegurosClick(ActionEvent event) {
        GestorEscenas.abrirEscena(event, "/progiipoo/bonvoyageapp/sesionCliente/seguro.fxml", usuario);
    }

    @FXML
    void onVuelosClick(ActionEvent event) {
        GestorEscenas.abrirEscena(event, "/progiipoo/bonvoyageapp/sesionCliente/vuelos.fxml", usuario);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colTipoAsistencia.setCellValueFactory(new PropertyValueFactory<>("tipoAsistencia"));
        colAsistenciaMedica.setCellValueFactory(new PropertyValueFactory<>("asistenciaMedica"));
        colMedicamentos.setCellValueFactory(new PropertyValueFactory<>("medicamentos"));
        colEquipaje.setCellValueFactory(new PropertyValueFactory<>("perdidaEquipaje"));
        colVueloDemorado.setCellValueFactory(new PropertyValueFactory<>("vueloDemorado"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
    }
}
