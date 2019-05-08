// Assignment #: Arizona State University CSE205
//         Name: Your Name
//    StudentID: Your ID
//      Lecture: Your lecture time (e.g., MWF 9:40am)
//  Description
//	Custom pane that displays all objects in array list

import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;	
import javafx.event.EventHandler;	
import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;

public class Test extends VBox{
	private ArrayList<Movie> movieList;
	private ListView<Movie> movieListView;
	//declare all other necessary GUI variables here
	private RadioButton r0;
	private RadioButton r1;
	private RadioButton r2;
	private RadioButton r3;
	private RadioButton r4;
	private RadioButton r5;
	private Button button;
	private Label title;
	private Label reviews;
	private Label rating;
	private Label amountOfReviews;
	private ObservableList<Movie> movieObservables;
 
   public Test(ArrayList<Movie> list) {
		super();
		this.movieList = list;
		
		movieList.add(movie);
		movieList.add(movie2);
		
			r1 = new RadioButton("1 Poor");
			r2 = new RadioButton("2 Fair");
			r3 = new RadioButton("3 Average");
			r4 = new RadioButton("4 Good");
			r5 = new RadioButton("5 Excellent");
			button = new Button("Submit Review");
			title = new Label("Choose a movie to give a review, and select a rating:");
		//observable list listens for changes in specified list
		//like an array list but with listeners
		//interface between arraylist and gui
		Movie movie = new Movie();//
		Movie movie2 = new Movie();//
		movieObservables = FXCollections.observableList(movieList);
		//listview represents objects in an observables list,  scrollable
		ListView<Movie> movieListView = new ListView<Movie>(movieObservables);

		ToggleGroup toggle = new ToggleGroup();
		r1.setToggleGroup(toggle);
		r2.setToggleGroup(toggle);
		r3.setToggleGroup(toggle);
		r4.setToggleGroup(toggle);
		r5.setToggleGroup(toggle);
		
		button.setOnAction(new RatingHandler());

		
		



		this.getChildren().add(title);
		this.getChildren().add(movieListView);
		HBox box = new HBox();
		box.getChildren().addAll(r1,r2,r3,r4,r5);

		this.getChildren().addAll(box,button);
   } 

 //This method refresh the ListView whenever there's new movie added in CreatePane
 //you will need to update the underline ObservableList object in order for ListView
 //object to show the updated movie list
 public void updateMovieList(Movie newMovie){
  
 }

 //Step 2: Create a RatingHandler class
 private class RatingHandler implements EventHandler<ActionEvent>{
        //Override the abstact method handle()
        public void handle(ActionEvent event){

		//movieListView.getSelectionModel()
		//movieListView.getFocusModel()
		//toggle.getSelectedToggle()

		}
    } 
} 
