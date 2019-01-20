import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class Main extends javafx.application.Application {
	int HOEHE  = 300;
	int BREITE = 600;


@Override
public void start( final javafx.stage.Stage primaryStage ){
	primaryStage.setTitle("Bilderverwaltung");
	primaryStage.setHeight(HOEHE);
	primaryStage.setWidth(BREITE);
	
	Group root = new Group();

	primaryStage.setResizable(true);
	
	HBox menu = new HBox();
	
    //Create Menus
	 Menu menuFile   = new Menu("Datei");
	// Menu menuEdit   = new Menu("Bearbeiten");
	 Menu menuView   = new Menu("Ansicht");
	// Menu menuWindow = new Menu("Fenster");
	 Menu menuHelp   = new Menu("Hilfe");
	 
	 //Create MenuItems
	 MenuItem menuItemOpenFile = new MenuItem("�ffne Datei");
	 MenuItem menuItemNewFile  = new MenuItem("Neue Datei anlegen");
     menuFile.getItems().addAll(menuItemOpenFile, menuItemNewFile);
     
     //MenuItem menuItemDelete = new MenuItem("L�schen");
     //MenuItem menuItemCopy   = new MenuItem("Kopieren");
     //MenuItem menuItemCutOut = new MenuItem("Ausschneiden");
     //menuEdit.getItems().addAll(menuItemDelete, menuItemCopy, menuItemCutOut);
     
     MenuItem menuItemEnlarge  = new MenuItem("Vergr��ern");
     MenuItem menuItemDecrease = new MenuItem("Verkleinern");
     menuView.getItems().addAll(menuItemEnlarge, menuItemDecrease);
     
     
     // Menu Ansicht:0  Dunkel/Hell, Gro�e/Kleine Kacheln oder Liste ??
     MenuBar menuBar = new MenuBar();
     menuBar.getMenus().addAll(menuFile, menuView, menuHelp);
     menu.getChildren().add(menuBar);
     
     
     //Buttons werden erstellt
	 ToolBar toolBar     = new ToolBar();
	 Button buttonImport = new Button("Import");
	 Button buttonPrint  = new Button("Drucken");
	// Button buttonSelect = new Button("Auswahl");
	 Button buttonSearch = new Button("Suchen");
	 //Button buttonEffect = new Button("Effekte");
     toolBar.getItems().addAll(buttonImport, buttonPrint, buttonSearch);
     
     //Es werden Bilder/Graphiken anstelle der Buttons hinzugef�gt
     buttonImport.setGraphic(new ImageView("/pathToButtonImport.png"));
     buttonPrint.setGraphic(new ImageView("/pathToButtonPrint"));
    // buttonSelect.setGraphic(new ImageView("/pathToButtonSelect"));
     buttonSearch.setGraphic(new ImageView("/pathToButtonSearch"));
     //buttonEffect.setGraphic(new ImageView("/pathToButtonEffect"));
     
     //Create Tooltip for buttons
     Tooltip tooltipImport = new Tooltip("Import");
     buttonImport.setTooltip(tooltipImport);
     tooltipImport.setTextAlignment(TextAlignment.RIGHT);
     
     Tooltip tooltipPrint  = new Tooltip("Drucken");
     buttonPrint.setTooltip(tooltipPrint);
     tooltipPrint.setTextAlignment(TextAlignment.RIGHT);
     
     //Tooltip tooltipSelect = new Tooltip("Auswahl");
     //buttonSelect.setTooltip(tooltipSelect);
     //tooltipSelect.setTextAlignment(TextAlignment.RIGHT);
     
     Tooltip tooltipSearch = new Tooltip("Suchen");
     buttonSearch.setTooltip(tooltipSearch);
     tooltipSearch.setTextAlignment(TextAlignment.RIGHT);
     
     //Tooltip tooltipEffect = new Tooltip("Effekte");
     //buttonEffect.setTooltip(tooltipEffect);
     //tooltipEffect.setTextAlignment(TextAlignment.RIGHT);
     
     
     
     SplitPane splitPaneTop = new SplitPane();
     splitPaneTop.setOrientation(Orientation.VERTICAL);
     splitPaneTop.getItems().addAll(menuBar, toolBar);
     
    
     TitledPane firstTitledPane = new TitledPane();
     firstTitledPane.setText("Alben");
     VBox alben = new VBox(); //Hier datei struktur
     alben.getChildren().add(new TextField());
     firstTitledPane.setContent(alben);
      
     TitledPane secondTitledPane = new TitledPane();
     secondTitledPane.setText("Suchen/Filtern");
     VBox suchen_filtern = new VBox();
     suchen_filtern.getChildren().add(new Label("Suche"));
     suchen_filtern.getChildren().add(new Label("Suche"));
     suchen_filtern.getChildren().add(new Label("Suche")); 
     
     secondTitledPane.setContent(suchen_filtern);
     
     TitledPane thirdTitledPane = new TitledPane();
     thirdTitledPane.setText("Informationen");
     VBox infos = new VBox();
     infos.getChildren().add(new TextField());

     thirdTitledPane.setContent(infos);
     
     VBox borderPaneLeft = new VBox();
     //borderPaneLeft.setPadding(new Insets(20, 10, 10, 10));
     //Groes der VBox an Fenstergroesse anpassen. Vielleicht ueber AnchorPane?
     borderPaneLeft.getChildren().addAll(firstTitledPane, secondTitledPane, thirdTitledPane);
     
     FlowPane flow = new FlowPane();
     flow.setVgap(8);
     flow.setHgap(4);
     flow.setPrefWrapLength(400); 
     for (int i = 0; i < 100; i++) {
         flow.getChildren().add(new Button("asdf")); //Hier statt Button dann Fotos
     }
     
     
	BorderPane borderPane = new BorderPane();
 	borderPane.setTop(splitPaneTop);
 	borderPane.setLeft(borderPaneLeft);
 	borderPane.setCenter(flow);
	
 	
 	Scene scene2 = new Scene(borderPane);
 	
 	primaryStage.setScene(scene2);
    primaryStage.show();
}

    public static void main(String[] args) {
    	Application.launch(args);
    }
}