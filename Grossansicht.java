import java.awt.Panel;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler; 
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage; 

public class Grossansicht extends Application{
	  int Bewertung =0;
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
        Pane midSpacer = new Pane();
        HBox.setHgrow(
        		midSpacer,
        		Priority.SOMETIMES
        );
        
        
		ToolBar toolBarTop = new ToolBar(); //gleiche Toolbar wie bei Hauptansicht??
		Button buttonSave = new Button("Speichern");
		Button buttonEdit=new Button("Bearbeiten");
	    toolBarTop.getItems().addAll(buttonSave,buttonEdit);
	     
	    ToolBar toolBarBottom = new ToolBar();
	    //Es gibt wohl die Moeglichkeit die RadioButtons als Sterne mit css darzustellen.
	    //Die andere Moeglichkeit hat bei mir nicht funktioniert...
	    
	    HBox rating = new HBox();
	    
	    RadioButton rating1 = new RadioButton();
	    RadioButton rating2 = new RadioButton();
	    RadioButton rating3 = new RadioButton();
	    RadioButton rating4 = new RadioButton();
	    RadioButton rating5 = new RadioButton();
	    Button ratingClear = new Button("0");
	    
	    rating1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	Bewertung =1;
            	rating1.setSelected(true);
            	rating2.setSelected(false);
            	rating3.setSelected(false);
            	rating4.setSelected(false);
            	rating5.setSelected(false);
            }
        });
	    
	    rating2.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	Bewertung =2;
            	rating1.setSelected(true);
            	rating2.setSelected(true);
            	rating3.setSelected(false);
            	rating4.setSelected(false);
            	rating5.setSelected(false);
            }
        });
	    
	    rating3.setOnAction(new EventHandler<ActionEvent>() {
	    public void handle(ActionEvent event) {
        	Bewertung =3;
        	rating1.setSelected(true);
        	rating2.setSelected(true);
        	rating3.setSelected(true);
        	rating4.setSelected(false);
        	rating5.setSelected(false);
        }
    });
	    
	    rating4.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent event) {
	        	Bewertung =4;
	        	rating1.setSelected(true);
	        	rating2.setSelected(true);
	        	rating3.setSelected(true);
	        	rating4.setSelected(true);
	        	rating5.setSelected(false);
	        }
	    });
	    
	    rating5.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent event) {
	        	Bewertung =5;
	        	rating1.setSelected(true);
	        	rating2.setSelected(true);
	        	rating3.setSelected(true);
	        	rating4.setSelected(true);
	        	rating5.setSelected(true);
	        }
	    });
	    
	    ratingClear.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	Bewertung =0;
            	rating1.setSelected(false);
            	rating2.setSelected(false);
            	rating3.setSelected(false);
            	rating4.setSelected(false);
            	rating5.setSelected(false);
            }
        });
	    
	    Tooltip tooltipRating = new Tooltip("Bild Bewertung");
	    rating1.setTooltip(tooltipRating);
	    rating2.setTooltip(tooltipRating);
	    rating3.setTooltip(tooltipRating);
	    rating4.setTooltip(tooltipRating);
	    rating5.setTooltip(tooltipRating);
	    tooltipRating.setTextAlignment(TextAlignment.RIGHT);
	    
	    Tooltip tooltipRatingClear = new Tooltip("Bild Bewertung löschen");
	    ratingClear.setTooltip(tooltipRating);
	    tooltipRating.setTextAlignment(TextAlignment.RIGHT);
	    
	    rating.getChildren().addAll(rating1, rating2, rating3, rating4, rating5,ratingClear);
	    
	        
	    
	    Button buttonBack = new Button("<");
	    buttonBack.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                //letztes Bild anzeigen
            }
        });
	    
	    Tooltip tooltipBack = new Tooltip("Letztes Bild");
	    buttonBack.setTooltip(tooltipBack);
	    tooltipBack.setTextAlignment(TextAlignment.RIGHT);
	    buttonBack.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	 stage.setFullScreen(true);
                 
            }
        });
	    
	    Button buttonFullScreen = new Button ("O");
	    
	    Tooltip tooltipFullScreen = new Tooltip("Vollbild");
	    buttonFullScreen.setTooltip(tooltipFullScreen);
	    tooltipFullScreen.setTextAlignment(TextAlignment.RIGHT);
	    buttonFullScreen.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	 stage.setFullScreen(true);
                 
            }
        });
	    
	    
	    Button buttonNext = new Button (">");
	    Tooltip tooltipNext = new Tooltip("Nächstes Bild");
	    buttonNext.setTooltip(tooltipNext);
	    tooltipNext.setTextAlignment(TextAlignment.RIGHT);
	    
	    Button buttonComment = new Button ("C");
	    Tooltip tooltipComment = new Tooltip("Kommentar einfügen");
	    buttonNext.setTooltip(tooltipComment);
	    tooltipNext.setTextAlignment(TextAlignment.RIGHT);
	    
	    
	    Button buttonDelete = new Button ("X");

	    Tooltip tooltipDelete = new Tooltip("Löschen");
	    buttonDelete.setTooltip(tooltipDelete);
	    tooltipDelete.setTextAlignment(TextAlignment.RIGHT);
	    
		toolBarBottom.getItems().addAll(rating,leftSpacer,buttonBack,buttonFullScreen,buttonNext,midSpacer,buttonComment, rightSpacer, buttonDelete);
	    
		 TilePane view = new TilePane(); 
	    view.setPadding(new Insets(15, 15, 15, 15)); 
	    view.setHgap(15); 

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
