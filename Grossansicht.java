import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler; 
import javafx.geometry.Insets; 
import javafx.scene.Scene;
import javafx.scene.control.Button;import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane; 
import javafx.stage.Stage; 

public class Grossansicht extends Application{
	  Stage stage; 
	@Override
	public void start(final Stage stage) throws Exception {
		
		stage.setResizable(true);
		final Pane leftSpacer = new Pane();
        HBox.setHgrow(
                leftSpacer,
                Priority.SOMETIMES
        );

        final Pane rightSpacer = new Pane();
        HBox.setHgrow(
                rightSpacer,
                Priority.SOMETIMES
        );
        
		ToolBar toolBarTop = new ToolBar(); //gleiche Toolbar wie bei Hauptansicht??
		Button buttonSpeichern = new Button("Speichern");
		Button buttonBearbeiten=new Button("Bearbeiten");
	    toolBarTop.getItems().addAll(buttonSpeichern,buttonBearbeiten);
	     
	    ToolBar toolBarBottom = new ToolBar();
	    //hier Rating, einfuegen, sobald es funktioniert....
	    
	    Button buttonZurueck = new Button("<");
	    buttonZurueck.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                //letztes Bild anzeigen
            }
        });
	    
	    Button buttonVollbild = new Button ("O");
	    
	    buttonVollbild.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	 stage.setFullScreen(true);
                 
            }
        });
	    Button buttonWeiter = new Button (">");
	    Button buttonLoeschen = new Button ("X");
		toolBarBottom.getItems().addAll(leftSpacer,buttonZurueck,buttonVollbild,buttonWeiter,rightSpacer,buttonLoeschen);
	    
		 TilePane ansicht = new TilePane(); 
	    ansicht.setPadding(new Insets(15, 15, 15, 15)); 
	    ansicht.setHgap(15); 

			BorderPane borderPane = new BorderPane();
	 	borderPane.setTop(toolBarTop);
	 	borderPane.setBottom(toolBarBottom);
	 	Scene scene2 = new Scene(borderPane, 500, 600);
	 	
		stage.setScene(scene2);
	    stage.show();
	}
	
	


	
	 public static void main(String[] args) {
	        Application.launch(args);
	    }
}
