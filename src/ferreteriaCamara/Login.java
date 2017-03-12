/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaCamara;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Miguel Alejandro Cámara Árciga
 */
public class Login extends Application {
  
  @Override
  public void start(Stage primaryStage) {
    Label texto = new Label("Ferreteria Camara");  
    
    Label textoUsuario = new Label("Usuario: ");
    
    Label textoPassword = new Label("Contraseña: ");
    
    TextField entradaUsuario = new TextField();
    entradaUsuario.setText("usuario");
    
    PasswordField entradaPassword = new PasswordField();
    entradaPassword.setText("contraseña");
    
    Button bIngresar = new Button("Ingresar");
    
    bIngresar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        //abrir una nueva ventana
        EscenarioPrincipal vp = new EscenarioPrincipal();
        Scene escena;
        escena = vp.EscenaPrincipal(primaryStage);
        primaryStage.setScene(escena);
        primaryStage.show();
        
      }
    });
    
    GridPane gridPane= new GridPane();
    
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    
    gridPane.add(texto, 0, 0);
    gridPane.add(textoUsuario, 0, 1);
    gridPane.add(entradaUsuario, 1, 1);
    gridPane.add(textoPassword, 0, 2);
    gridPane.add(entradaPassword, 1, 2);
    gridPane.add(bIngresar, 1, 3);
    
    //gridPane.setStyle("-fx-background-color: BEIGE;");
    
    Scene escena1 = new Scene(gridPane);
    
    primaryStage.setTitle("!Bienvenido!");
    primaryStage.setScene(escena1);
    primaryStage.show();
       
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}
