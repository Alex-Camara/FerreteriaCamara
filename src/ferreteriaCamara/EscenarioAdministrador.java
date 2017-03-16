/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaCamara;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Miguel Alejandro Cámara Árciga
 */
public class EscenarioAdministrador {
//radioButtonSeleccionado;
  
  /**---------------------------------------------------------------------------------------------
   * se le pasa el parametro de Escenario para que pueda reemplazar la escena anterior con esta.
   * @param primaryStage
   * @return 
   */
  public Scene EscenaAdministrador(Stage primaryStage){
    
    //Agregar articulo
    TabPane tabPane =  new TabPane();
    Tab tabAgregar = new Tab();
    tabAgregar.setText("Agregar Articulo");
    tabAgregar.setClosable(false);
    
        //agregamo el gridpane del escenario AgregarArticulo
    EscenarioAgregarArticulo escenaAgregarArt = new EscenarioAgregarArticulo();
    GridPane gpAgregarArt = escenaAgregarArt.EscenaAgregarArticulo2(primaryStage);    
    
    tabAgregar.setContent(gpAgregarArt);
    
    //Eliminar Articulo

    Tab tabEliminar = new Tab();
    tabEliminar.setText("Eliminar Articulo");
    tabEliminar.setClosable(false);
    
        //agregamo el gridpane del escenario EliminarArticulo
    EscenarioEliminarArticulo escenaEliminarArt = new EscenarioEliminarArticulo();
    GridPane gpEliminarArt = escenaEliminarArt.EscenaEliminarArticulo(primaryStage); 
    
    tabEliminar.setContent(gpEliminarArt);
    
    //Buscar Articulo

    Tab tabBuscar = new Tab();
    tabBuscar.setText("Buscar Articulo");
    tabBuscar.setClosable(false);
    
        //agregamo el gridpane del escenario EditarArticulo
    EscenarioBuscarArticulo escenaBuscarArt = new EscenarioBuscarArticulo();
    GridPane gpBuscarArt = escenaBuscarArt.EscenaBuscarArticulo(primaryStage);
    
    tabBuscar.setContent(gpBuscarArt);
    
    //Editar Articulo

    Tab tabEditar = new Tab();
    tabEditar.setText("Editar Articulo");
    tabEditar.setClosable(false);
    
        //agregamo el gridpane del escenario EditarArticulo
    EscenarioEditarArticulo escenaEditarArt = new EscenarioEditarArticulo();
    GridPane gpEditarArt = escenaEditarArt.EscenaEditarArticulo(primaryStage);
    
    tabEditar.setContent(gpEditarArt);
    
    //Mostrar Inventario

    Tab tabMostrarInv = new Tab();
    tabMostrarInv.setText("Mostrar Inventario");
    tabMostrarInv.setClosable(false);
    
        //agregamo el gridpane del escenario EditarArticulo
    EscenarioMostrarInventario escenaMostrarInv = new EscenarioMostrarInventario();
    GridPane gpMostrarInv = escenaMostrarInv.EscenaMostrarInventario(primaryStage);
    
    tabMostrarInv.setContent(gpMostrarInv);
    
    //Agregar Venta
    Tab tabAgregarVenta = new Tab();
    tabAgregarVenta.setText("Agregar Venta");
    tabAgregarVenta.setClosable(false);
    
        //agregamo el gridpane del escenario EditarArticulo
    EscenarioAgregarVenta escenaagregarVenta = new EscenarioAgregarVenta();
    GridPane gpAgregarVenta = escenaagregarVenta.EscenaAgregarVenta(primaryStage);
    
    tabAgregarVenta.setContent(gpAgregarVenta);
    
    //Mostrar registros
    Tab tabMostrarReg = new Tab();
    tabMostrarReg.setText("Mostrar Ventas");
    tabMostrarReg.setClosable(false);
    
        //agregamo el gridpane del escenario AgregarArticulo
    EscenarioMostrarVenta escenaMostrarVenta = new EscenarioMostrarVenta();
    GridPane gpMostrarVenta = escenaMostrarVenta.EscenaMostrarVenta(primaryStage);
    
    tabMostrarReg.setContent(gpMostrarVenta);

    
    //Salir
    Tab tabSalir = new Tab();
    tabSalir.setText("Salir");
    tabSalir.setClosable(false);
    
    //agregamos los tabs al tabPane
    tabPane.getTabs().add(tabBuscar);
    tabPane.getTabs().add(tabAgregar);
    tabPane.getTabs().add(tabEliminar);
    tabPane.getTabs().add(tabEditar);
    tabPane.getTabs().add(tabMostrarInv);
    tabPane.getTabs().add(tabAgregarVenta);
    tabPane.getTabs().add(tabMostrarReg);
    
     //Scene escenaInventario = new Scene(tabPane, 300,250);
    
    Scene escenaInventario = new Scene(tabPane, 1000,500);
    return escenaInventario;
    
  } 
  
}
