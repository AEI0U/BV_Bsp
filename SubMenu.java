import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.RadioMenuItemBuilder;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SubMenu extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menus");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250, Color.WHITE);
        
        MenuBar menuBar = new MenuBar();
        
        Menu menu = new Menu("Item");
        
        
        
        Menu saveAs = new Menu("Speichern Unter");
        
        Menu attribut = new Menu("�ndern");
        attribut.getItems().add(new CheckMenuItem("Namen �ndern"));
        attribut.getItems().add(new CheckMenuItem("Kommentar �ndern"));
        saveAs.getItems().add(new CheckMenuItem("Informationen �ndern"));
        
        Menu delete = new Menu ("L�schen");
        delete.getItems().add(new CheckMenuItem("Einzeln L�schen"));
        delete.getItems().add(new CheckMenuItem("�berall L�schen"));
        
        menu.getItems().addAll(saveAs,attribut,delete);
        
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        menuBar.getMenus().add(menu);
        
        root.getChildren().add(menuBar); 
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
