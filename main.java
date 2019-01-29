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

public class Main extends Application {
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
	
	 /*
	  * Menu Verwaltung werden hier angelegt
	  */
	 Menu menuOrganize   		= new Menu("Verwalten");
	 Menu organizeFiles 		= new Menu("Alben Verwalten");
	 MenuItem openFile 	        = new MenuItem("Album Öffnen");
	 MenuItem newFile   		= new MenuItem("Album Anlegen");
	 MenuItem fileLocation 		= new MenuItem("Album Verschieben");
	 MenuItem deleteFile 		= new MenuItem("Album Löschen");
	 organizeFiles.getItems().addAll(openFile, newFile, fileLocation,deleteFile);
	 
	 Menu organizeImages 		= new Menu("Bilder Verwalten");
	 MenuItem showImage  		= new MenuItem("Bild Anzeigen");
	 MenuItem saveAsImage		= new MenuItem("Speichern Unter");
	 MenuItem imageLocation		= new MenuItem("Bild Verschieben");
	 MenuItem deleteImage 		= new MenuItem("Bild Löschen");
	 organizeImages.getItems().addAll(showImage, saveAsImage, imageLocation,deleteImage);
	
	 Menu menuImport 	= new Menu("Importieren");
	 MenuItem importFile 	= new MenuItem("Album Importieren");
	 MenuItem importImage 	= new MenuItem("Bild Importieren");
	 menuImport.getItems().addAll(importFile, importImage);
	 
	 menuOrganize.getItems().addAll(organizeFiles,organizeImages,menuImport);
	 
	 Menu menuHelp   = new Menu("Hilfe");
	 MenuItem getHelpOnline   = new MenuItem("Hilfe Online erhalten");
     MenuItem checkForUpdates = new MenuItem("Auf Updates überprüfen");
     menuHelp.getItems().addAll(getHelpOnline, checkForUpdates);
	 //Create MenuItems
	 
     MenuBar menuBar = new MenuBar();
     menuBar.getMenus().addAll(menuOrganize, menuHelp);
     menu.getChildren().add(menuBar);

     
     //Buttons werden erstellt
	 ToolBar toolBar     = new ToolBar();
	 Button buttonImport = new Button("Import");
	 Button buttonSearch = new Button("Suchen");
	 toolBar.getItems().addAll(buttonImport, buttonSearch);
     
	 /**
     //Es werden Bilder/Graphiken anstelle der Buttons hinzugefügt
     buttonImport.setGraphic(new ImageView("/pathToButtonImport.png"));
     buttonPrint.setGraphic(new ImageView("/pathToButtonPrint"));
    // buttonSelect.setGraphic(new ImageView("/pathToButtonSelect"));
     buttonSearch.setGraphic(new ImageView("/pathToButtonSearch"));
     //buttonEffect.setGraphic(new ImageView("/pathToButtonEffect"));
     */
	 
     //Bennenungen der Buttons anzeigen
     Tooltip tooltipImport = new Tooltip("Import");
     buttonImport.setTooltip(tooltipImport);
     tooltipImport.setTextAlignment(TextAlignment.RIGHT);
     
     Tooltip tooltipSearch = new Tooltip("Suchen");
     buttonSearch.setTooltip(tooltipSearch);
     tooltipSearch.setTextAlignment(TextAlignment.RIGHT);
          
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
     //suchen_filtern.getChildren().add(new Label("Suche"));
     //suchen_filtern.getChildren().add(new Label("Suche"));
     //suchen_filtern.getChildren().add(new Label("Suche")); 
     
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
	
 	
 	Scene scene = new Scene(borderPane);
 	
 	primaryStage.setScene(scene);
    primaryStage.show();
}

    public static void main(String[] args) {
    	Application.launch(args);
    }
}
