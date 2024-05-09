package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//DANILO MENDOZA MEJIA

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // AnchorPane
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPrefWidth(650);
            anchorPane.setPrefHeight(650);
            anchorPane.setStyle("-fx-background-color: white;");

            // Creación de ListView
            ListView<String> listView = new ListView<>();
            listView.setStyle("-fx-control-inner-background: white;");
            listView.setPrefWidth(390);
            listView.setPadding(new Insets(0));

            // Creación de TextField
            TextField textField = new TextField();
            textField.setPrefWidth(50);
            textField.setPrefHeight(10);
            textField.setPadding(new Insets(10));

            // HBox (Contenedor) para ListView y TextField
            HBox hBox = new HBox(listView);

            // Crear el ScrollPane y agregar el AnchorPane
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(anchorPane);
            scrollPane.setPrefSize(300, 520);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

            // Crear el BorderPane -------- contenedor principal
            BorderPane root = new BorderPane();
            root.setLeft(scrollPane);
            root.setBottom(textField);
            root.setRight(hBox);
            root.setPadding(new Insets(10));
            BorderPane.setMargin(textField, new Insets(5, 0, 0, 310));
            BorderPane.setMargin(scrollPane, new Insets(4, 0, -46, 0));
            BorderPane.setMargin(hBox, new Insets(5, 0, 5, 10));

            // Etiquetas
            Label label1 = new Label("    Bruce Wayne");
            Label label2 = new Label("    Dick Grayson");
            Label label3 = new Label("    Robert Pattinson");
            Label label4 = new Label("    Lara Croft");
            Label label5 = new Label("    Zukko Garel");

            // Vbox que contiene las etiquetas
            VBox labelsVBox = new VBox(label1, label2, label3, label4, label5);
            labelsVBox.setSpacing(25);

            // Agregar el VBox al AnchorPane
            //anchorPane.getChildren().add(labelsVBox);

            // Crear el ScrollPane para las etiquetas
            ScrollPane labelsScrollPane = new ScrollPane(labelsVBox);
            labelsScrollPane.setPrefSize(200, 520);
            //labelsScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            labelsScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

            // Configurar la escena principal
            Scene scene = new Scene(root);

            // Establecer la escena en la etapa principal
            primaryStage.setScene(scene);
            primaryStage.show();

            // Crear ImageViews para cada imagen
            // Crear ImageViews para cada imagen con tamaños personalizados
            ImageView imageView1 = createImageView("bruce.jpeg", 50, 50); // Tamaño personalizado digito, digito
            ImageView imageView2 = createImageView("dick.jpeg", 50, 50); 
            ImageView imageView3 = createImageView("robert.jpeg", 50, 70); 
            ImageView imageView4 = createImageView("lara.jpeg", 50, 50); 
            ImageView imageView5 = createImageView("zukko.jpg", 50, 100); 
            
            // HBox para cada par de etiqueta e imagen
            HBox hbox1 = new HBox(imageView1, label1);
            HBox hbox2 = new HBox(imageView2, label2);
            HBox hbox3 = new HBox(imageView3, label3);
            HBox hbox4 = new HBox(imageView4, label4);
            HBox hbox5 = new HBox(imageView5, label5);

            // VBox para contener todos los HBox
            VBox contentVBox = new VBox(hbox1, hbox2, hbox3, hbox4, hbox5);
            contentVBox.setSpacing(25);

            // Agregar el VBox al AnchorPane
            anchorPane.getChildren().add(contentVBox);

            // Configurar la escena para las imágenes
            Scene imageScene = new Scene(contentVBox, 800, 200);

            // Establecer escena 
            Stage imageStage = new Stage();
            imageStage.setScene(imageScene);
            imageStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Imagen personalizada
    private ImageView createImageView(String imagePath, double width, double height) {
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
        return imageView;
    }

    public static void main(String[] args) {
        launch(args);
    }     
}
