// Assignment #: Arizona State University CSE205
//         Name:  Jason Ormsby
//    StudentID: 1215293690
//      Lecture: Your lecture time (e.g., MWF 9:40am)
//  Description
//	Custom pane that displays all objects in array list

import javafx.scene.control.ListView;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.scene.control.SelectionModel;


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
import javafx.scene.control.SelectionModel;

public class ReviewPane extends VBox{
	private ArrayList<Movie> movieList;
	public ListView<Movie> movieListView;
	//declare all other necessary GUI variables here
	private RadioButton r0;
	private RadioButton r1;
	private RadioButton r2;
	private RadioButton r3;
	private RadioButton r4;
	private RadioButton r5;
	private ToggleGroup toggle;
	private Button button;
	private Label title;
	private Label reviews;
	private Label rating;
	private Label amountOfReviews;
	private ObservableList<Movie> movieObservables;
	
   public ReviewPane(ArrayList<Movie> list) {
		super();
		this.movieList = list;
		r1 = new RadioButton("1 Poor");
		r2 = new RadioButton("2 Fair");
		r3 = new RadioButton("3 Average");
		r4 = new RadioButton("4 Good");
		r5 = new RadioButton("5 Excellent");
		button = new Button("Submit Review");
		title = new Label("Choose a movie to give a review, and select a rating:");

		movieObservables = FXCollections.observableList(movieList);
		//listview represents objects in an observables list,  scrollable
		movieListView = new ListView<Movie>(movieObservables);
		movieListView.setItems(movieObservables);

		//rating buttons		
		toggle = new ToggleGroup();
		r1.setToggleGroup(toggle);
		r2.setToggleGroup(toggle);
		r3.setToggleGroup(toggle);
		r4.setToggleGroup(toggle);
		r5.setToggleGroup(toggle);
		
		//add buttons to pane and add handlers
		button.setOnAction(new RatingHandler());
		this.getChildren().add(title);
		this.getChildren().add(movieListView);
		HBox box = new HBox();
		box.getChildren().addAll(r1,r2,r3,r4,r5);
		this.getChildren().addAll(box,button);
   } 

 public void updateMovieList(Movie newMovie){
	 System.out.print(""+newMovie.toString());
	movieObservables.set(movieObservables.size()-1,newMovie);
	//movieObservables.addAll(newMovie);
	//movieObservables.remove(movieObservables.size()-1);
 }

 private class RatingHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
			int selected = movieListView.getSelectionModel().getSelectedIndex();
			if(toggle.getSelectedToggle() == r1) {movieObservables.get(selected).addRating(1);}
			if(toggle.getSelectedToggle() == r2) {movieObservables.get(selected).addRating(2);}
			if(toggle.getSelectedToggle() == r3) {movieObservables.get(selected).addRating(3);}
			if(toggle.getSelectedToggle() == r4) {movieObservables.get(selected).addRating(4);}
			if(toggle.getSelectedToggle() == r5) {movieObservables.get(selected).addRating(5);}
			Movie temp = movieListView.getSelectionModel().getSelectedItem();
			movieObservables.remove(selected);
			movieObservables.add(selected,temp);
		}
    } 
} 
