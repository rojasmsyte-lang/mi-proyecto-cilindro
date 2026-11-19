module org.ejemplos.proyectojavafx2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.ejemplos.proyectojavafx2 to javafx.fxml, org.junit.platform.commons;
    exports org.ejemplos.proyectojavafx2;
}