module com.tugas.messenger {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.tugas.fisika to javafx.fxml;
    exports com.tugas.fisika;
}