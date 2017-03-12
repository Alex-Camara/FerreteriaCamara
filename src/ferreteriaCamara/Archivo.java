package ferreteriaCamara;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * 
 * @author Miguel Alejandro Cámara Árciga
 */
public class Archivo {
  //se declara el ArrayList articulo, que tendra presistencia y sera la base de las operaciones.
  public static ArrayList<Articulo> listaArticulo = new ArrayList<Articulo>();

  /**---------------------------------------------------------------------------------------------
   * metodo que guarda los parametros que se le pasan a un objeto y a un arraylist a la vez
   * @param clave
   * @param nombre
   * @param descripcion
   * @param precio_compra
   * @param tipo_unidad
   * @param existencia 
   */
   public void AsignarDatos(int clave, String nombre, String descripcion, float precio_compra,
                                                           String tipo_unidad, int existencia){

    Articulo aux = new Articulo();

    listaArticulo.add(aux); //agregamos el objeto auxiliar al ArrayList.
    //SOLO DESPUES de agregar el objeto al Arraylist asignamos valores a sus atributos.
    aux.setClave(clave);
    aux.setNombre(nombre);
    aux.setDescripcion(descripcion);
    aux.setPrecio_compra(precio_compra);
    aux.setTipo_unidad(tipo_unidad);
    aux.setExistencia(existencia);
    guardarRegistrados();
  }
   
  /**---------------------------------------------------------------------------------------------
  * metodo estandar para seliarizar un objeto.
  * para registrar las entradas al inventario
  */
  public static void guardarRegistrados() {

    try {
      FileOutputStream fos = new FileOutputStream("inventario.ser");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      //escribimos el ArrayList en el archivo
      oos.writeObject(listaArticulo);
      oos.close();
      fos.close();
    } catch (IOException ioe) {

    }
  }
   
   /**-------------------------------------------------------------------------------------------
   * Metodo que solo recupera los objetos del archivo y los regresa en Lista
   * @param art
   * @param nombreArchivo
   * @return articulo 
   */
  public static List recuperarDatos(){
    
    try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("inventario.ser"));
        listaArticulo = (ArrayList<Articulo>) in.readObject(); 
        in.close();
    }
    catch(IOException | ClassNotFoundException e) {}
    return listaArticulo;
     }
  
  /**----------------------------------------------------------------------------------------
  * Metodo que imprime el valor de return de recuperarDatos().
  **/
  public static void imprimirInventario(){
    System.out.println(recuperarDatos());
  }
  
  /**-------------------------------------------------------------------------------------------
   * metodo que busca en el registro de inventario el elemento que coincida con la clave que se le
   * pasa como parametro, regresa null si no encuentra una coincidencia
   * @param clave
   * @return 
   */
  public static Articulo buscarPorClave(int clave){
    //se crea un objeto del tipo Articulo
    Articulo objetoArticulo = null;
    //Articulo articuloReturn = null;
    //int indice = -1;

      for (int i = 0; i < listaArticulo.size(); i++) {
        //asignamos, para cada iteracion, el valor del objeto en el indice i, a objetoArticulo
        //objetoArticulo = listaArticulo.get(i);
                
        if (listaArticulo.get(i).getClave() == clave) {
          objetoArticulo = listaArticulo.get(i);
          //indice = i;
        }
      }
      return objetoArticulo;   
  }
  
  /**-----------------------------------------------------------------------------------------
   * metodo similar al buscar clave pero con un string Nombre como parametro
   * @param nombre
   * @return 
   */
  public static Articulo buscarPorNombre(String nombre){
    //se crea un objeto del tipo Articulo
    Articulo objetoArticulo;
    Articulo articuloReturn = null;
    
      for (int i = 0; i < listaArticulo.size(); i++) {
        //asignamos, para cada iteracion, el valor del objeto en el indice i, a objetoArticulo
        objetoArticulo = listaArticulo.get(i);
                
        if (objetoArticulo.getNombre().equalsIgnoreCase(nombre)) {
          articuloReturn = objetoArticulo;
        }
      }
      return articuloReturn;
  }
  
  /**-----------------------------------------------------------------------------------------
   * Metodo que elimina en base al parametro entero que se le pase
   * @param claveEliminar 
   */
   public static void eliminarDato(int claveEliminar){
    Articulo objetoArticulo;
    boolean estatus = false;
    
    for (int i = 0; i < listaArticulo.size(); i++) {
      objetoArticulo = listaArticulo.get(i);
      
      if (objetoArticulo.getClave() == claveEliminar) {
        System.out.println(listaArticulo.get(i));
        listaArticulo.remove(i); //se remueve
          //Posible no necesario
        for (int j = 0; j < listaArticulo.size(); j++) {
          guardarRegistrados();
        }
        System.out.println("se elimino el objeto");
        estatus = true;
      }
    }
    if (estatus) {
      System.out.println("se elimino objeto");
    } else {
      System.out.println("no se encontro el objeto");
    }
  }
   
   public static void modificarDato(int clave, String nombre, String descripcion, 
                                    float precio_compra,String tipo_unidad, int existencia){
    Articulo objetoArticulo;
       System.out.println("MODIFICANDP...");
      for (int i = 0; i < listaArticulo.size(); i++) {
          if (listaArticulo.get(i).getClave() == clave) {
             
            objetoArticulo = listaArticulo.get(i);
            objetoArticulo.setClave(clave);
            objetoArticulo.setNombre(nombre);
            objetoArticulo.setDescripcion(descripcion);
            objetoArticulo.setPrecio_compra(precio_compra);
            objetoArticulo.setTipo_unidad(tipo_unidad);
            guardarRegistrados();
            
            System.out.println("se modifico el objeto");
          }
      }
   }
}
