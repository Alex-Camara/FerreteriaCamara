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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
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
public class EscenarioEliminarArticulo {
  
  public Scene EscenaEliminarArticulo(Stage primaryStage){
    
    Label lInstruccion = new Label("Introduce la clave del articulo a eliminar: ");
    TextField tClave = new TextField();
    
    Button bAceptar = new Button("Aceptar");
    Button bRegresar = new Button("Regresar");
    
    GridPane gridPane = new GridPane();
    
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    
    gridPane.add(lInstruccion, 0, 0);
    gridPane.add(tClave, 0, 1);
    gridPane.add(bAceptar, 0, 2);
    gridPane.add(bRegresar, 1, 2);
    
    bAceptar.setOnAction(new EventHandler (){
      @Override
      public void handle(Event event) {
        int clave;
        String nombre;
        String descripcion;
        float precioCompra;
        String tipoUnidad;
        int cantidad;
        Articulo auxiliar;
        
        if (tClave.getText().trim().isEmpty() == false) {
          clave = Integer.parseInt(tClave.getText().trim()); 
            auxiliar = Archivo.buscarPorClave(clave); 
            
            if (auxiliar != null) {
              
              nombre = auxiliar.getNombre();
              descripcion = auxiliar.getDescripcion();
              precioCompra = auxiliar.getPrecio_compra();
              tipoUnidad = auxiliar.getTipo_unidad();
              cantidad = auxiliar.getExistencia();
              
              Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
              
              confirmacion.setTitle("Confirmación");
              confirmacion.setHeaderText(null);
              confirmacion.setContentText("Clave: " + clave
                                          + "\nNombre: " + nombre 
                                          + "\nDescripción: " +descripcion
                                          + "\nPrecio de compra: " + precioCompra
                                          + "\ntipoUnidad: " + tipoUnidad
                                          + "\ncantidad: " + cantidad);
              
              ButtonType btEliminar = new ButtonType("Eliminar");
              ButtonType btCancelar = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
              
              confirmacion.getButtonTypes().setAll(btEliminar,btCancelar);
              
              Optional<ButtonType> eleccion = confirmacion.showAndWait();
              
              //en caso de seleccion el boton Eliminar se manda a llamar al metodo eliminarDato
              //de la clase Archivo
              if (eleccion.get() == btEliminar) {
                Archivo.eliminarDato(clave);
              }
            }
            //si no se encuentra la clave
              else {
                Alert sinCoincidencias = new Alert(Alert.AlertType.WARNING);
                sinCoincidencias.setHeaderText(null);
                sinCoincidencias.setContentText("No se encontro ningun articulo con dicha clave");
                sinCoincidencias.show();
              }
        }
        //si el usuario no introdujo nada
        if (tClave.getText().trim().isEmpty() == true) {
          Alert alerta = new Alert(Alert.AlertType.WARNING);
          alerta.setHeaderText(null);
          alerta.setContentText("debes ingresar la clave del articulo a eliminar");
          alerta.show();
        }
      }
      
    });
    
    bRegresar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        EscenarioInventario escenaInv = new EscenarioInventario();
        Scene escena = escenaInv.EscenaInventario(primaryStage);
        primaryStage.setScene(escena);
        primaryStage.show();
      }
      
    });
    
    Scene escenaEliminarArticulo = new Scene(gridPane);
    
    return escenaEliminarArticulo;
  }
  
    public Alert EscenaEliminarArticulo(int clave){
 
      String nombre;
      String descripcion;
      float precioCompra;
      String tipoUnidad;
      int cantidad;
      Articulo auxiliar;
      Alert confirmacion = null;
           
      auxiliar = Archivo.buscarPorClave(clave); 
           
      if (auxiliar != null) {
              
        nombre = auxiliar.getNombre();
        descripcion = auxiliar.getDescripcion();
        precioCompra = auxiliar.getPrecio_compra();
        tipoUnidad = auxiliar.getTipo_unidad();
        cantidad = auxiliar.getExistencia();
              
        confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
              
        confirmacion.setTitle("Confirmación");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText("Clave: " + clave
                                            + "\nNombre: " + nombre 
                                            + "\nDescripción: " +descripcion
                                            + "\nPrecio de compra: " + precioCompra
                                            + "\ntipoUnidad: " + tipoUnidad
                                            + "\ncantidad: " + cantidad);
              
        ButtonType btEliminar = new ButtonType("Eliminar");
        ButtonType btCancelar = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
              
        confirmacion.getButtonTypes().setAll(btEliminar,btCancelar);
              
        Optional<ButtonType> eleccion = confirmacion.showAndWait();
              
        //en caso de seleccion el boton Eliminar se manda a llamar al metodo eliminarDato
        //de la clase Archivo
        if (eleccion.get() == btEliminar) {
        Archivo.eliminarDato(clave);
        }
        //si no se encuentra la clave
      } else {
          Alert sinCoincidencias = new Alert(Alert.AlertType.WARNING);
          sinCoincidencias.setHeaderText(null);
          sinCoincidencias.setContentText("No se encontro ningun articulo con dicha clave");
          sinCoincidencias.show();
      }    
      return confirmacion;
  }
}
