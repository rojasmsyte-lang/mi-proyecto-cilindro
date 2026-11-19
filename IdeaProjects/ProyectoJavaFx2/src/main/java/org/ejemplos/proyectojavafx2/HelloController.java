package org.ejemplos.proyectojavafx2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

/**
 * controlador de la inferfaz grafica JAVAFX
 */

public class HelloController {

// componentes de la interfaz del archivo FXML
    public TextField TextFielAltura;
    public Button BtnCalcular;
    public Button BtnBorrar;
    public Button BtnSalir;
    public Pane paneDibujo;
    public TextField TextFileRadio;
    public TextField TextFileArea;
    public TextField TextFileResultadoVlmn;

private static  final Pattern PATRON_DECIMAL = Pattern.compile("\\d{0,6}([.]\\d{0,4})?");

    /**
     * El método se ejecuta al dar clic en el botón "calcular"
     * @param actionEvent evento de acción botón
     */

    public void onActionCalcular(ActionEvent actionEvent) {
        double Altura = Double.parseDouble(TextFielAltura.getText());
        double Radio = Double.parseDouble(TextFileRadio.getText());
        Cilindro cil = new Cilindro(Radio,Altura);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultados");
        alert.setHeaderText("");
        alert.setContentText("Area del cilindro: "+ cil.getArea()+
                "Volumen del cilindro"+ cil.getVolumen());
        alert.showAndWait();

        TextFileArea.setText(String.valueOf(cil.getVolumen()));
        TextFileResultadoVlmn.setText(String.valueOf(cil.getVolumen()));

    }
    private TextFormatter<String> crearFormatoDecimal(){
        UnaryOperator<TextFormatter.Change> filtro = cambio->{
            String textoNuevo = cambio.getControlNewText();
            return  PATRON_DECIMAL.matcher(textoNuevo).matches()? cambio: null;
        };
        return new TextFormatter<>(filtro);
    }

    /**
     * El método se ejecuta al dar clic en el botón "borrar"
     * @param actionEvent evento de acción botón
     */
    public void onActionBorrar(ActionEvent actionEvent) {
        TextFielAltura.setText("");
        TextFileRadio.setText("");
        TextFileArea.setText("");
        TextFileResultadoVlmn.setText("");
    }

    /**
     * Método de inicio que se ejecuta a cargar la vista
     */
    public void initialize(){
     Platform.runLater(()->{
         Stage stage = (Stage)BtnSalir.getScene().getWindow();
         stage.setOnCloseRequest(this::cerrarFormulario);
     });
        Cylinder cyl = new Cylinder(50,100);
        PhongMaterial material = new PhongMaterial(Color.CHOCOLATE);
        material.setSpecularColor(Color.GOLD);
        cyl.setMaterial(material);

        cyl.getTransforms().addAll(
                new Rotate(10,Rotate.X_AXIS),
                new Rotate(20,Rotate.Y_AXIS),
                new Rotate(10,Rotate.Z_AXIS)

        );
        Group grp3D = new Group(cyl);

        //Camara de perspectiva alejada para ver el cilindro completo

        PerspectiveCamera camara = new PerspectiveCamera(true);
        camara.setNearClip(0.1);
        camara.setFarClip(0.1);
        camara.setTranslateZ(-400);
        SubScene subScene = new SubScene(grp3D,0,0,true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.TRANSPARENT);
        subScene.setCamera(camara);
        subScene.widthProperty().bind(paneDibujo.widthProperty());
        subScene.heightProperty().bind(paneDibujo.heightProperty());

        paneDibujo.getChildren().add(subScene);
        TextFileRadio.setTextFormatter(crearFormatoDecimal());
        TextFielAltura.setTextFormatter(crearFormatoDecimal());
    }

    /**
     * Cierra la aplicacion al hacer clic en "salir"
     * @param actionEvent evento de acción botón
     */

    public void onActionSalir(ActionEvent actionEvent) {
        if (confirmarSalida())
        Platform.exit();
    }

    /**
     * Cerrar el formulario al hacer clic en "confirmar salida"
     * @param windowEvent evento de acción ventana
     */
    private void cerrarFormulario(WindowEvent windowEvent){
        if(!confirmarSalida())
            windowEvent.consume();
        // Cancela el cierre si el usuario no acepta
    }

    /**
     * Muestra una ventana de alerta para confirmar que el usuario desea salir
     * @return true si el usuario presiona OK, false en caso contrario
     */
    public boolean confirmarSalida(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir");
                alert.setHeaderText("");
                alert.setContentText("¿Salir de la aplicacion?");
                Optional<ButtonType> resp = alert.showAndWait();
                return resp.isPresent() && resp.get() == ButtonType.OK;

    }
}
