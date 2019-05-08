// Assignment #: Arizona State University CSE205
//         Name:  Jason Ormsby
//    StudentID: 1215293690
//      Lecture: Your lecture time (e.g., MWF 9:40am)
//  Description: CreatePane generates a pane where a user can enter
//  a movie information and create a list of available movies.

//import data structures
import java.util.ArrayList;
//import wrapper
import java.lang.Integer;
 import javafx.scene.text.Text.*;
//import layout
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
//import handler
import javafx.event.ActionEvent;	
import javafx.event.EventHandler;	
//import components	
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;


public class CreatePane extends HBox{
    private ArrayList<Movie> movieList;
    private ReviewPane reviewPane;
	private TextArea textArea;
	private Button button;
	private TextField name;
	private TextField length;
	private TextField year;
	private Label warningLabel;
	private Label nameLabel;
	private Label lengthLabel;
	private Label yearLabel;
	private GridPane pane;

    public CreatePane(ArrayList<Movie> list, ReviewPane rePane){
		super();
        this.movieList = list;
        this.reviewPane = rePane;
		name = new TextField("");
		length = new TextField("");
		year =	new TextField("");
        nameLabel = new Label("Name");
		lengthLabel = new Label("Length");
		yearLabel = new Label("Year");
		warningLabel = new Label("");
		button = new Button("Create A movie");
		pane = new GridPane();
		textArea = new TextArea("No Movies");

        //create a GridPane hold those labels & text fields
        //consider using .setPadding() or setHgap(), setVgap()
        //to control the spacing and gap, etc.
        //----
        //setHgap
		//setVgap
      	//pane.add(button,1,0);
		pane.add(warningLabel,0,0);
		pane.add(nameLabel,0,1);
		pane.add(name,1,1);
		pane.add(lengthLabel,0,2);
		pane.add(length,1,2);
		pane.add(yearLabel,0,3);
		pane.add(year,1,3);
		pane.add(button,1,4);
		pane.setMinWidth(350);
		this.getChildren().addAll(pane,textArea);
		button.setOnAction(new ButtonHandler());
    } 

    private class ButtonHandler implements EventHandler<ActionEvent>
     {
        @Override
        public void handle(ActionEvent event)
         {	
        try{
            //when a text field is empty and the button is pushed
            if ( name.getText().equals("") || length.getText().equals("") || year.getText().equals("") ) {
                    warningLabel.setText("Please Fill All Fields");
             }

            else{
				warningLabel.setText("Movie added ");
				//get next empty spot in list
				//set elements
				String nameTemp = ""+name.getCharacters();
				int lengthTemp = Integer.parseInt(""+length.getCharacters());
				int  yearTemp = Integer.parseInt(""+year.getCharacters());
				Movie movieTemp = new Movie();
				movieTemp.setMovieTitle(nameTemp);
				movieTemp.setLength(lengthTemp);
				movieTemp.setYear(yearTemp);
				movieList.add(movieTemp);
				textArea.setText(textArea.getText()+movieTemp.toString());
				reviewPane.updateMovieList(movieTemp);
         }
		}
		catch(NumberFormatException e){warningLabel.setText("Incorrect Format");
																System.out.println("Number format exception");}
   } 
}
}

