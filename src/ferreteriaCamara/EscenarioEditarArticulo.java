package ferreteriaCamara;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Miguel Alejandro Cámara Árciga
 */
public class EscenarioEditarArticulo { 
  
  /**-----------------------------------------------------------------------------------------
   * escena principal de la clase en la que se le pide al usuario la clave del articulo
   * que desea modificar
   * @param primaryStage
   * @return 
   */
  public GridPane EscenaEditarArticulo(Stage primaryStage){
    Label lOpcion1 = new Label("Introduce la clave del articulo");
    
    Label lClave = new Label("Clave: ");
    TextField tClave = new TextField();
    
    Button bBuscar = new Button("Buscar");
    
    GridPane gridPane = new GridPane();
              
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    
    gridPane.add(lClave, 0, 0);
    gridPane.add(tClave, 0, 1);
    gridPane.add(bBuscar, 0, 2);
    
    //Scene escenaEditarArticulo = new Scene(gridPane);
    
    bBuscar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        int clave;
        String claveAPresentar;
        Articulo auxiliar;
        if (tClave.getText().trim().isEmpty() == false) {
          clave = Integer.parseInt(tClave.getText().trim());
          
          auxiliar = Archivo.buscarPorClave(clave); 
            
          if (auxiliar != null) {
            EscenarioEditarArticulo escenarioEditarArt = new EscenarioEditarArticulo();
            GridPane gpEditarrArticulo = escenarioEditarArt.EscenaDatosPresentes(primaryStage, auxiliar, clave);
            Scene escena = new Scene(gpEditarrArticulo);

            primaryStage.setScene(escena);
            primaryStage.show();
          }
        }
      }
      
    });
 
    return gridPane;
  } 
  
  /**-----------------------------------------------------------------------------------------
   * Escena que se manda llamar al presionar el boton Aceptar en el metodo pasado, en este 
   * se muestra un plantilla con todos los datos de los objetos que se pueden editar y despues
   * guardar en el inventario.
   * @param primaryStage
   * @param tClave
   * @return 
   */
  public GridPane EscenaDatosPresentes(Stage primaryStage, Articulo auxiliar,int clave){

        String nombre;
        String descripcion;
        float precioCompra;
        String tipoUnidad;
        int cantidad;
        //Scene EscenaDatosPresentes = null;
        
          auxiliar = Archivo.buscarPorClave(clave); 
              nombre = auxiliar.getNombre();
              descripcion = auxiliar.getDescripcion();
              precioCompra = auxiliar.getPrecio_compra();
              tipoUnidad = auxiliar.getTipo_unidad();
              cantidad = auxiliar.getExistencia();
              
              Label lClave = new Label("Clave: ");
              TextField tClaveObtenida = new TextField(String.valueOf(clave));
              
              Label lNombre = new Label("Nombre del articulo: ");
              TextField tNombreObtenida = new TextField(nombre);
    
              Label lDescripcion = new Label("Descripcion: ");
              TextField tDescripcionObtenida = new TextField(descripcion);
    
              Label lPrecioCompra = new Label("Precio de compra: ");
              TextField tPrecioCompraObtenida = new TextField(String.valueOf(precioCompra));
    
              Label lTipoUnidad = new Label("Tipo de unidad: ");
              TextField tTipoUnidadObtenida = new TextField(tipoUnidad);
    
              Label lCantidad = new Label("Cantidad: ");
              TextField tCantidadObtenida = new TextField(String.valueOf(cantidad));    
    
              Button bGuardar = new Button("Guardar");
              Button bSalir = new Button("Salir");
    
    
              GridPane gridPane = new GridPane();
              
              gridPane.setPadding(new Insets(10, 10, 10, 10)); 
              gridPane.setVgap(5);
              gridPane.setHgap(5);
              
              gridPane.add(lClave, 0, 1);
              gridPane.add(tClaveObtenida, 1, 1);
              gridPane.add(lNombre, 0, 2);
              gridPane.add(tNombreObtenida, 1, 2);
              gridPane.add(lDescripcion, 0, 3);
              gridPane.add(tDescripcionObtenida, 1, 3);
              gridPane.add(lPrecioCompra, 0, 4);
              gridPane.add(tPrecioCompraObtenida, 1, 4);
              gridPane.add(lTipoUnidad, 0, 5);
              gridPane.add(tTipoUnidadObtenida, 1, 5);
              gridPane.add(lCantidad, 0, 6);
              gridPane.add(tCantidadObtenida, 1, 6);
              gridPane.add(bGuardar, 0, 7);
              gridPane.add(bSalir, 1, 7);
              
              bGuardar.setOnAction(new EventHandler(){
                @Override
                public void handle(Event event) {

                  /**
                   * una vez accionado este boton se obtienen los datos de los textfields y se 
                   * le pasan al metodo modificarDato
                   */
                  String nombre2 = tNombreObtenida.getText().trim();
                  String descripcion2 = tDescripcionObtenida.getText().trim();
                  float precioCompra2 = Float.parseFloat(tPrecioCompraObtenida.getText().trim());
                  String tipoUnidad2 = tTipoUnidadObtenida.getText().trim();
                  int cantidad2 = Integer.parseInt(tCantidadObtenida.getText().trim());
                  
                  Archivo.modificarDato(clave, nombre2, descripcion2, precioCompra2, tipoUnidad2, cantidad2);
                  
                  Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                  alerta.setTitle("Confirmación");
                  alerta.setHeaderText(null);
                  alerta.setContentText("Los datos han sido guardados tio!");
                  alerta.show();
                }
              
            });
              
    bSalir.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
          Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación");
        alerta.setHeaderText(null);
        alerta.setContentText("¿seguro que desea salir?");
        
        Optional<ButtonType> result = alerta.showAndWait();
        
        if (result.get() == ButtonType.OK) {
          primaryStage.close();
        } else {
          alerta.close();
        }
      }
      
    });          
            
            return gridPane;
  }
}

