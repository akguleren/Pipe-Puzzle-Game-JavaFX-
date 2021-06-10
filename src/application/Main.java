package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
//The purpose of this program is to create a puzzle game. Eren Akgül 150119028, Mehmet Selim Can 150118063.
public class Main extends Application {
	private ImageView[][] imageViewArray = new ImageView[4][4];
	private Image[][] imageArray = new Image[4][4];
	public double[][] originX = new double[4][4];
	public double[][] originY = new double[4][4];
	private String level = "";
	private File file;
	public int MovementCount = 0;
	public ImageView StarterVerticalView = new ImageView("StarterVertical.png");
	public ImageView StarterHorizontalView = new ImageView("StarterHorizontal.png");
	public ImageView EndVerticalView = new ImageView("EndVertical.png");
	public ImageView EndHorizontalView = new ImageView("EndHorizontal.png");
	public ImageView PipeStaticVerticalView = new ImageView("PipeStaticVertical.png");
	public ImageView PipeStaticHorizontalView = new ImageView("PipeStaticHorizontal.png");
	public ImageView StaticPipe00View = new ImageView("StaticPipe00.png");
	public ImageView StaticPipe01View = new ImageView("StaticPipe01.png");
	public ImageView StaticPipe10View = new ImageView("StaticPipe10.png");
	public ImageView StaticPipe11View = new ImageView("StaticPipe11.png");
	public ImageView EmptyNoneView = new ImageView("Emptynone.png");
	public ImageView EmptyfreeView = new ImageView("Emptyfree.png");
	public ImageView Pipe00View = new ImageView("Pipe00.png");
	public ImageView Pipe01View = new ImageView("Pipe01.png");
	public ImageView Pipe10View = new ImageView("Pipe10.png");
	public ImageView Pipe11View = new ImageView("Pipe11.png");
	public ImageView PipeVerticalView = new ImageView("PipeVertical.png");
	public ImageView PipeHorizontalView = new ImageView("PipeHorizontal.png");
	public ImageView WinScreenView = new ImageView("WinScreen.png");
	public ImageView BeginScreenView = new ImageView("BeginScreen.png");
	public ImageView LockScreen1View = new ImageView("LockScreen1.png");
	public ImageView LockScreen2View = new ImageView("LockScreen2.png");
	public ImageView LockScreen3View = new ImageView("LockScreen3.png");
	public ImageView LockScreen4View = new ImageView("LockScreen4.png");
	public ImageView BeginScreen1View = new ImageView("BeginScreen1.png");
	public ImageView BeginScreen2View = new ImageView("BeginScreen2.png");
	public ImageView BeginScreen3View = new ImageView("BeginScreen3.png");
	public ImageView BeginScreen4View = new ImageView("BeginScreen4.png");
	public HBox hBox;
	public boolean answer = false;
	public boolean ExitPlayButtonAdder = true;
	public Circle StartingCircle;
	public Scene scene;
	private String[] levelTitles = new String[5];
	public ObservableList<String> items = FXCollections.observableArrayList(levelTitles);
	private String[] FinishedLevelsArray = {"Level 1","Level 2","Level 3","Level 4","Level 5"};
	public ObservableList<String> FinishedLevels = FXCollections.observableArrayList(FinishedLevelsArray);
	
	public void start(Stage primaryStage) throws FileNotFoundException,RuntimeException {
		
		Image StarterVertical = new Image("StarterVertical.png");
		Image StarterHorizontal = new Image("StarterHorizontal.png");
		Image EndVertical = new Image("EndVertical.png");
		Image EndHorizontal = new Image("EndHorizontal.png");
		Image PipeStaticVertical = new Image("PipeStaticVertical.png");
		Image PipeStaticHorizontal = new Image("PipeStaticHorizontal.png");
		Image Emptyfree = new Image("Emptyfree.png");
		Image Emptynone	 = new Image("Emptynone.png");
		Image PipeVertical = new Image("PipeVertical.png");
		Image PipeHorizontal = new Image("PipeHorizontal.png");
		Image Pipe00 = new Image("Pipe00.png");
		Image Pipe01 = new Image("Pipe01.png");					//Defining all the images.
		Image Pipe10 = new Image("Pipe10.png");
		Image Pipe11 = new Image("Pipe11.png");
		Image StaticPipe00 = new Image("StaticPipe00.png");
		Image StaticPipe01 = new Image("StaticPipe01.png");
		Image StaticPipe10 = new Image("StaticPipe10.png");
		Image StaticPipe11 = new Image("StaticPipe11.png");
		Image LockScreen1 = new Image("LockScreen1.png");
		Image LockScreen2 = new Image("LockScreen2.png");
		Image LockScreen3 = new Image("LockScreen3.png");
		Image LockScreen4 = new Image("LockScreen4.png");
		Image BeginScreen1 = new Image("BeginScreen1.png");
		Image BeginScreen2 = new Image("BeginScreen2.png");
		Image BeginScreen3 = new Image("BeginScreen3.png");
		Image BeginScreen4 = new Image("BeginScreen4.png");

		//Firstly we create empty Grid pane.(400x450)
	GridPane pane = new GridPane();
	scene = new Scene(pane,400,450);
	
	ComboBox<String> cbo = new ComboBox<>(); //We create the combo box for the level selection system.
	BorderPane GamePane = new BorderPane(); //We create the Border pane for the all things to the place.
	HBox PlayHbox = new HBox(170);			//We create the HBox for the Play button.
    HBox PlayExitHBox = new HBox(328);		//We create the HBox for the Play and Exit button at the Winning screen.
	Button playButton = new Button("Play"); //We create the play button.
	Button exitButton = new Button("Exit"); //We create the exit button.
	
	PlayHbox.getChildren().add(playButton); //Add play button to the HBox.
	PlayHbox.setPadding(new Insets(0,0,0,175)); //Centered to the middle.
	pane.getChildren().add(BeginScreenView);   //Adding the welcome image to the screen.
	pane.getChildren().add(PlayHbox);         //Adding the PlayHBox to the screen.
	
    cbo.setStyle("-fx-background-color: lightgray");  //Changing the color of combo box.
	
	
    playButton.setOnAction(h -> {						//If the user press the play button, game will be begin.
			pane.getChildren().remove(PlayHbox);        //Removing the on-screen button.
	cbo.getItems().removeAll(FinishedLevels);		    //If the user presses play button after winning the game, it will clearing combo box.
    pane.getChildren().remove(BeginScreenView);			//When the game starts, it will remove the welcome image.

    levelTitles[0] = "Level 1";
	levelTitles[1] = "(Locked) Level 2";
	levelTitles[2] = "(Locked) Level 3";				//Defining the combo box again.
	levelTitles[3] = "(Locked) Level 4";
	levelTitles[4] = "(Locked) Level 5";
    items = FXCollections.observableArrayList(levelTitles);
    GamePane.setStyle("-fx-background-color: gray");   //Changing the color of background.
    cbo.setValue("Select Level");					   //Setting the combo box's current value to Select Level.
    cbo.getItems().addAll(items);                      //Adding the levels options to the combo box.
    
	if (ExitPlayButtonAdder)						   
    pane.getChildren().add(BeginScreenView);
	
	hBox = new HBox();								   //Defining the HBox for the Welcome Again text.
	hBox.setPadding(new Insets(5, 50, 5, 50));		   
	hBox.setStyle("-fx-background-color: lightgray");
	hBox.getChildren().add(new Text("\t\t\tWelcome to the Game Again !"));	//Adding to the text on the HBox.
	
	cbo.setOnAction(e -> {							//If the user changing the combo box's value.
		pane.getChildren().remove(BeginScreenView); //Removing the welcome screen.
		MovementCount = 0;							//For each level, movement count will be zero.
		hBox.getChildren().remove(0);				//Removing the text from the HBox.
		hBox.setAlignment(Pos.CENTER);				//Centering movement counter.
		hBox.getChildren().add(new Text("Movement --> " + MovementCount)); //Adding the movement counter to the HBox.
		
		try {
		   if (cbo.getValue().equals("(Locked) Level 2")
			|| cbo.getValue().equals("(Locked) Level 3")
			|| cbo.getValue().equals("(Locked) Level 4")		//If the user selects the locked levels,
			|| cbo.getValue().equals("(Locked) Level 5")) {     //user will be Locked Level message.
			   hBox.getChildren().remove(0);
				hBox.setAlignment(Pos.CENTER);
				hBox.getChildren().add(new Text("Locked Level"));
		   												  }
		}
		catch (NullPointerException e2) {}
		   
		GamePane.getChildren().remove(StartingCircle);      //Removing the starting circle, if the level is changed.
		answer = false;
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				originX[i][j]=i*100;				//Creating the common x,y axis.
				originY[i][j]=j*100;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				ImageView EmptyFree = getImageView(Emptyfree,primaryStage);
				pane.add(EmptyFree, j, i);				//Adding Empty tile to the all squares.
				imageViewArray[i][j] = EmptyfreeView;
				imageArray[i][j] = Emptyfree;
				
			}
		}
		
		level = cbo.getValue() + ".txt";				//Getting the level inputs.
		file = new File(level);
		Scanner scan = new Scanner("Select Level.txt"); //Set the default scan value to the Select Level.txt
		try {
		scan = new Scanner(file);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
	
		
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			String LineInput = scan.next();				
			String[] Splitted = LineInput.split(",");   //Taking the informations from the input text.
			String keyword = Splitted[1] + Splitted[2];	
			
				//Checking the input's file.
			
			if (keyword.equals("StarterVertical")) {
				StarterVerticalView = getImageView(StarterVertical,primaryStage);
				pane.add(StarterVerticalView, j, i);
				imageViewArray[j][i] = StarterVerticalView;
				imageArray[j][i] = StarterVertical;
				StartingCircle = new Circle(50,75,11);   //Adding the starting circle for each level.
				StartingCircle.setFill(Color.YELLOW);
				StartingCircle.setRadius(9);
				GamePane.getChildren().add(StartingCircle);
			}
			
			else if (keyword.equals("StarterHorizontal")) {
				StarterHorizontalView = getImageView(StarterHorizontal,primaryStage);
				pane.add(StarterHorizontalView, j, i);
				imageViewArray[j][i] = StarterHorizontalView;
				imageArray[j][i] = StarterHorizontal;
			}
			
			else if (keyword.equals("EndVertical")) {
				EndVerticalView = getImageView(EndVertical,primaryStage);
				pane.add(EndVerticalView, j, i);
				imageViewArray[j][i] = EndVerticalView;
				imageArray[j][i] = EndVertical;
			}
			
			else if (keyword.equals("EndHorizontal")) {
				EndHorizontalView = getImageView(EndHorizontal,primaryStage);
				pane.add(EndHorizontalView, j, i);
				imageViewArray[j][i] = EndHorizontalView;
				imageArray[j][i] = EndHorizontal;
			}
			
			else if (keyword.equals("PipeStaticVertical")) {
				PipeStaticVerticalView = getImageView(PipeStaticVertical,primaryStage);
				pane.add(PipeStaticVerticalView, j, i);
				imageViewArray[j][i] = PipeStaticVerticalView;
				imageArray[j][i] = PipeStaticVertical;
			}
			
			else if (keyword.equals("PipeStaticHorizontal")) {
				PipeStaticHorizontalView = getImageView(PipeStaticHorizontal,primaryStage);
				pane.add(PipeStaticHorizontalView, j, i);
				imageViewArray[j][i] = PipeStaticHorizontalView;
				imageArray[j][i] = PipeStaticHorizontal;
			}
			
			else if (keyword.equals("Emptynone")) {
				EmptyNoneView = getImageView(Emptynone,primaryStage);
				pane.add(EmptyNoneView, j, i);
				imageViewArray[j][i] = EmptyNoneView;
				imageArray[j][i] = Emptynone;
			}
			else if (keyword.equals("PipeVertical")) {
				PipeVerticalView = getImageView(PipeVertical,primaryStage);
				pane.add(PipeVerticalView, j, i);
				imageViewArray[j][i] = PipeVerticalView;
				imageArray[j][i] = PipeVertical;
			}
			
			else if (keyword.equals("PipeHorizontal")) {
				PipeHorizontalView = getImageView(PipeHorizontal,primaryStage);
				pane.add(PipeHorizontalView, j, i);
				imageViewArray[j][i] = PipeHorizontalView;
				imageArray[j][i] = PipeHorizontal;
			}
			
			else if (keyword.equals("Pipe00")) {
				Pipe00View = getImageView(Pipe00,primaryStage);
				pane.add(Pipe00View, j, i);
				imageViewArray[j][i] = Pipe00View;
				imageArray[j][i] = Pipe00;
			}
			
			else if (keyword.equals("Pipe01")) {
				Pipe01View = getImageView(Pipe01,primaryStage);
				pane.add(Pipe01View, j, i);
				imageViewArray[j][i] = Pipe01View;
				imageArray[j][i] = Pipe01;
			}
			
			else if (keyword.equals("Pipe10")) {
				Pipe10View = getImageView(Pipe10,primaryStage);
				pane.add(Pipe10View, j, i);
				imageViewArray[j][i] = Pipe10View;
				imageArray[j][i] = Pipe10;
			}
			
			else if (keyword.equals("Pipe11")) {
				Pipe11View = getImageView(Pipe11,primaryStage);
				pane.add(Pipe11View, j, i);
				imageViewArray[j][i] = Pipe11View;
				imageArray[j][i] = Pipe11;
			}
			else if (keyword.equals("PipeStatic00")) {
				StaticPipe00View = getImageView(StaticPipe00,primaryStage);
				pane.add(StaticPipe00View, j, i);
				imageViewArray[j][i] = StaticPipe00View;
				imageArray[j][i] = StaticPipe00;
			}
			
			else if (keyword.equals("PipeStatic01")) {
				StaticPipe01View = getImageView(StaticPipe01,primaryStage);
				pane.add(StaticPipe01View, j, i);
				imageViewArray[j][i] = StaticPipe01View;
				imageArray[j][i] = StaticPipe01;
			}
			
			else if (keyword.equals("PipeStatic10")) {
				StaticPipe10View = getImageView(StaticPipe10,primaryStage);
				pane.add(StaticPipe10View, j, i);
				imageViewArray[j][i] = StaticPipe10View;
				imageArray[j][i] = StaticPipe10;
			}
			
			else if (keyword.equals("PipeStatic11")) {
				StaticPipe11View = getImageView(StaticPipe11,primaryStage);
				pane.add(StaticPipe11View, j, i);
				imageViewArray[j][i] = StaticPipe11View;
				imageArray[j][i] = StaticPipe11;
			}
			else if (keyword.equals("Kilit1")) {
				LockScreen1View = getImageView(LockScreen1,primaryStage);
				pane.add(LockScreen1View, j, i);
				imageViewArray[j][i] = LockScreen1View;
				imageArray[j][i] = LockScreen1;
			}
			else if (keyword.equals("Kilit2")) {
				LockScreen2View = getImageView(LockScreen2,primaryStage);
				pane.add(LockScreen2View, j, i);
				imageViewArray[j][i] = LockScreen2View;
				imageArray[j][i] = LockScreen2;
			}
			else if (keyword.equals("Kilit3")) {
				LockScreen3View = getImageView(LockScreen3,primaryStage);
				pane.add(LockScreen3View, j, i);
				imageViewArray[j][i] = LockScreen3View;
				imageArray[j][i] = LockScreen3;
			}
			else if (keyword.equals("Kilit4")) {
				LockScreen4View = getImageView(LockScreen4,primaryStage);
				pane.add(LockScreen4View, j, i);
				imageViewArray[j][i] = LockScreen4View;
				imageArray[j][i] = LockScreen4;
			}
			else if (keyword.equals("BeginScreen1")) {
				BeginScreen1View = getImageView(BeginScreen1,primaryStage);
				pane.add(BeginScreen1View, j, i);
				imageViewArray[j][i] = BeginScreen1View;
				imageArray[j][i] = BeginScreen1;
			}
			else if (keyword.equals("BeginScreen2")) {
				BeginScreen2View = getImageView(BeginScreen2,primaryStage);
				pane.add(BeginScreen2View, j, i);
				imageViewArray[j][i] = BeginScreen2View;
				imageArray[j][i] = BeginScreen2;
			}
			else if (keyword.equals("BeginScreen3")) {
				BeginScreen3View = getImageView(BeginScreen3,primaryStage);
				pane.add(BeginScreen3View, j, i);
				imageViewArray[j][i] = BeginScreen3View;
				imageArray[j][i] = BeginScreen3;
			}
			else if (keyword.equals("BeginScreen4")) {
				BeginScreen4View = getImageView(BeginScreen4,primaryStage);
				pane.add(BeginScreen4View, j, i);
				imageViewArray[j][i] = BeginScreen4View;
				imageArray[j][i] = BeginScreen4;
			}
	}
	}
	 });
	
	
	Line line = new Line();			//We created a line to scroll the pictures.

	
	pane.setOnMousePressed(e -> {
	    int imx2=((int)e.getSceneX())/100;
	    int imy2=((int)e.getSceneY()-25)/100;
		line.setStartX(imx2*100+ 50);				//Setting the line's starting points temporarily.
		line.setStartY(imy2*100+ 50);
		pane.setOnMouseReleased(a -> {
			if (!answer) {
			int imx=(((int)a.getSceneX()) / 100);			
			int imy=(((int)a.getSceneY()-25) / 100);
			if (imx <= 3 && imy <= 3 && imx >= 0 && imy >= 0) {	//Checking the coordinates of the cell.
			line.setEndX(imx*100 + 50);   //Setting the line's ending points temporarily.
			line.setEndY(imy*100 + 50);
			double distance = Math.sqrt(Math.pow((line.getEndX() - line.getStartX()), 2) + Math.pow((line.getEndY() - line.getStartY()), 2));
		            if (imageViewArray[imx][imy] == EmptyfreeView
		    		 && imageViewArray[imx2][imy2] != StarterVerticalView
		    		 && imageViewArray[imx2][imy2] != StarterHorizontalView
		    		 && imageViewArray[imx2][imy2] != PipeStaticVerticalView
		    		 && imageViewArray[imx2][imy2] != PipeStaticHorizontalView
		    		 && imageViewArray[imx2][imy2] != StaticPipe00View   //Checking the future square is static or not.
		    		 && imageViewArray[imx2][imy2] != StaticPipe01View
		    		 && imageViewArray[imx2][imy2] != StaticPipe10View
		    		 && imageViewArray[imx2][imy2] != StaticPipe11View
		    		 && imageViewArray[imx2][imy2] != EndVerticalView
		    		 && imageViewArray[imx2][imy2] != EndHorizontalView
		    		 && distance == 100           //Checking the distance between the current and future square.
		    		 ) {
		            	MovementCount++;			//Increasing the movement count.
		        		hBox.getChildren().remove(0); //Removing the Movement counter.
		        		hBox.setAlignment(Pos.CENTER);
		        		hBox.getChildren().add(new Text("Movement --> " + MovementCount)); //Adding the Movement counter again.
		        		
		    	PathTransition pt = new PathTransition();
			    pt.setDuration(Duration.millis(320));
			    
			    line.setStartX((int)(line.getStartX()-originX[imx2][imy2])); //Setting the line's starting points.
			    line.setStartY((int)(line.getStartY()-originY[imx2][imy2]));
			    line.setEndX((int)(line.getEndX()-originX[imx2][imy2])); //Setting the line's ending points.
			    line.setEndY((int)(line.getEndY()-originY[imx2][imy2]));
			    pt.setPath(line);
			    pt.setNode(imageViewArray[imx2][imy2]);
			    pt.play();									//Scrolling the image.
			    

			    double tmpX=originX[imx2][imy2];
			    double tmpY=originY[imx2][imy2];
			    originX[imx2][imy2]=originX[imx][imy];
			    originY[imx2][imy2]=originY[imx][imy];			//Changing the coordinates.
			    originX[imx][imy]=tmpX;
			    originY[imx][imy]=tmpY;
			    
			    
		    imageViewArray[imx][imy] = imageViewArray[imx2][imy2];
		    imageViewArray[imx2][imy2] = EmptyfreeView;
		    
		    imageArray[imx][imy] = imageArray[imx2][imy2];
		    imageArray[imx2][imy2] = Emptyfree;
		    
		    }
		            
		              //CHECKING ANSWERS OF LEVEL
		            
		            Line line123_1 = new Line(200,200,200,450);
		            Arc arc123 = new Arc(250,450,50,50,180,90);		//Path of the level 1,2,3.
		            Line line123_2 = new Line(250,500,500,500);
		            
		            Line line45_1 = new Line(200,200,200,350);
		            Arc arc45_1 = new Arc(250,350,50,50,180,90);
		            Line line45_2 = new Line(250,400,450,400);     //Path of the level 4,5.
		            Arc arc45_2 = new Arc(450,350,50,50,270,90);
		            Line line45_3 = new Line(500,350,500,300);
		            
		            Circle circle_sliding = new Circle(160,200,9);
		            circle_sliding.setFill(Color.YELLOW);
		            PathTransition pathTransition = new PathTransition();		//Creating the Path transition for the circle.
		            pathTransition.setDuration(Duration.millis(1000));
		            
		       if (cbo.getValue().equals("Level 1")) {
		    	   		   if (imageArray[0][0] == StarterVertical
				    		&& imageArray[0][1] == PipeVertical
				    		&& imageArray[0][2] == PipeVertical
				    		&& imageArray[0][3] == Pipe01				//Checking the level 1's path is true or not.
				    		&& imageArray[1][3] == PipeHorizontal
				    		&& imageArray[2][3] == PipeStaticHorizontal
				    		&& imageArray[3][3] == EndHorizontal)
				    	   {
								levelTitles[1] = "Level 2";					//Opening the Level 2.
								cbo.getItems().set(1, levelTitles[1]);		//Adding level 2 to the combo box.
								answer = true;
								GamePane.getChildren().remove(StartingCircle);
								pane.getChildren().add(circle_sliding);
								
								
								pathTransition.setPath(line123_1);
								pathTransition.setNode(circle_sliding);
								pathTransition.play();
								pathTransition.setOnFinished(b -> {
									pathTransition.setPath(arc123);
									pathTransition.setNode(circle_sliding);			//Animation of the circle sliding.
									pathTransition.play();
									pathTransition.setOnFinished(c -> {
										pathTransition.setPath(line123_2);
										pathTransition.setNode(circle_sliding);
										pathTransition.play();	
										pathTransition.setOnFinished(d -> {});
										});
						            });
				    	   }
		    	   }
		       
		       
		       else if (cbo.getValue().equals("Level 2")) {
		    	   		   if (imageArray[0][0] == StarterVertical
				    		&& imageArray[0][1] == PipeVertical
				    		&& imageArray[0][2] == PipeVertical
				    		&& imageArray[0][3] == Pipe01					//Checking the level 2's path is true or not.
				    		&& imageArray[1][3] == PipeHorizontal
				    		&& imageArray[2][3] == PipeStaticHorizontal
				    		&& imageArray[3][3] == EndHorizontal)
				    	   {
		    	   			levelTitles[2] = "Level 3";						//Opening the Level 3.
							cbo.getItems().set(2, levelTitles[2]);			//Adding level 3 to the combo box.
							answer = true;
							GamePane.getChildren().remove(StartingCircle);
							pane.getChildren().add(circle_sliding);
							pathTransition.setPath(line123_1);
							pathTransition.setNode(circle_sliding);
							pathTransition.play();
							pathTransition.setOnFinished(b -> {
								pathTransition.setPath(arc123);					//Animation of the circle sliding.
								pathTransition.setNode(circle_sliding);
								pathTransition.play();
								pathTransition.setOnFinished(c -> {
									pathTransition.setPath(line123_2);
						            pathTransition.setNode(circle_sliding);
						            pathTransition.play();
						            pathTransition.setOnFinished(d -> {});
					            });
						    });
				    	   }
		       }
		       else if (cbo.getValue().equals("Level 3")) {
		    	   		   if (imageArray[0][0] == StarterVertical
				    		&& imageArray[0][1] == PipeVertical
				    		&& imageArray[0][2] == PipeVertical
				    		&& imageArray[0][3] == Pipe01					//Checking the level 3's path is true or not.
				    		&& imageArray[1][3] == PipeHorizontal
				    		&& imageArray[2][3] == PipeStaticHorizontal
				    		&& imageArray[3][3] == EndHorizontal)
				    	   {
								levelTitles[3] = "Level 4";					//Opening the Level 4.
								cbo.getItems().set(3, levelTitles[3]);		//Adding level 4 to the combo box.
								answer = true;
								GamePane.getChildren().remove(StartingCircle);
								pane.getChildren().add(circle_sliding);
								pathTransition.setPath(line123_1);
								pathTransition.setNode(circle_sliding);
								pathTransition.play();
								pathTransition.setOnFinished(b -> {
									pathTransition.setPath(arc123);
									pathTransition.setNode(circle_sliding);
									pathTransition.play();						//Animation of the circle sliding.
									pathTransition.setOnFinished(c -> {
										pathTransition.setPath(line123_2);
										pathTransition.setNode(circle_sliding);
										pathTransition.play();
										pathTransition.setOnFinished(d -> {
											pathTransition.setPath(arc45_2);
							    			pathTransition.setNode(circle_sliding);
							    			pathTransition.play();
										});
										pathTransition.setOnFinished(f -> {});
						            });
							    });
				    	   }
		       }
		       else if (cbo.getValue().equals("Level 4")) {
		    	   		   if (imageArray[0][0] == StarterVertical
				    		&& imageArray[0][1] == PipeStaticVertical
				    		&& imageArray[0][2] == Pipe01
				    		&& imageArray[1][2] == PipeHorizontal				//Checking the level 4's path is true or not.
				    		&& imageArray[2][2] == PipeHorizontal
				    		&& imageArray[3][2] == Pipe00
				    		&& imageArray[3][1] == EndVertical)
				    	   {
								levelTitles[4] = "Level 5";						//Opening the Level 5.
								cbo.getItems().set(4, levelTitles[4]);			//Adding level 5 to the combo box.
								answer = true;
								GamePane.getChildren().remove(StartingCircle);
								pane.getChildren().add(circle_sliding);
								pathTransition.setPath(line45_1);
								pathTransition.setNode(circle_sliding);
								pathTransition.play();
								pathTransition.setOnFinished(b -> {
							    	pathTransition.setPath(arc45_1);
							    	pathTransition.setNode(circle_sliding);
							    	pathTransition.play();
							    	pathTransition.setOnFinished(c -> {
							    		pathTransition.setPath(line45_2);				//Animation of the circle sliding.
							    		pathTransition.setNode(circle_sliding);
							    		pathTransition.play();
							    		pathTransition.setOnFinished(d -> {
							    			pathTransition.setPath(arc45_2);
							    			pathTransition.setNode(circle_sliding);
							    			pathTransition.play();
							    			pathTransition.setOnFinished(f -> {
							    				pathTransition.setPath(line45_3);
								    			pathTransition.setNode(circle_sliding);
								    			pathTransition.play();
							    				pathTransition.setOnFinished(g -> {});
							    			});
							            });
						            });
							    });
				    	   }
		       }
		       else if (cbo.getValue().equals("Level 5")) {
		    	   		   if (imageArray[0][0] == StarterVertical
				    		&& imageArray[0][1] == PipeVertical
				    		&& imageArray[0][2] == StaticPipe01					//Checking the level 5's path is true or not.
				    		&& imageArray[1][2] == PipeHorizontal
				    		&& imageArray[2][2] == PipeHorizontal
				    		&& imageArray[3][2] == Pipe00
				    		&& imageArray[3][1] == EndVertical)
				    	   {
		    	   			answer = true;
		    	   			GamePane.getChildren().remove(StartingCircle);
							pane.getChildren().add(circle_sliding);
							pathTransition.setPath(line45_1);
							pathTransition.setNode(circle_sliding);
							pathTransition.play();
							pathTransition.setOnFinished(b -> {
								pathTransition.setPath(arc45_1);
								pathTransition.setNode(circle_sliding);
								pathTransition.play();
								pathTransition.setOnFinished(c -> {
									pathTransition.setPath(line45_2);
									pathTransition.setNode(circle_sliding);				//Animation of the circle sliding.
									pathTransition.play();
									pathTransition.setOnFinished(d -> {
						            	pathTransition.setPath(arc45_2);
						            	pathTransition.setNode(circle_sliding);
						            	pathTransition.play();
									pathTransition.setOnFinished(f -> {
										pathTransition.setPath(line45_3);
						    			pathTransition.setNode(circle_sliding);
						    			pathTransition.play();
						    			pathTransition.setOnFinished(g -> {
						    				if (ExitPlayButtonAdder) {			//Adding the play and exit button once each game.
						    					ExitPlayButtonAdder = false;
							            		PlayExitHBox.getChildren().add(exitButton);
							            		exitButton.setOnAction(p -> {
												System.exit(0);						//If the press the exit button, system will be exited.
											});
											PlayExitHBox.getChildren().add(playButton);
							            	}
							            	Pane WinScreenPane = new Pane();				//Creating pane for the win screen image.
							            	WinScreenPane.getChildren().add(WinScreenView);	//Adding win screen to the pane.
							            	WinScreenPane.getChildren().add(PlayExitHBox);	//Adding the play and exit button to the pane.
						    				Scene WinScreenScene = new Scene(WinScreenPane,400,450);	//Creating new scene for the win screen.
											primaryStage.setScene(WinScreenScene);
											primaryStage.show();
						    			});
									});
									});
					            });
						    });
				    	   }
		       }
			}
			}
			});
	});
	
	GamePane.setBottom(hBox);			//Adding hBox to the bottom part.
	GamePane.setTop(cbo);				//Adding the combo box to the top part.
	primaryStage.setScene(scene);
	primaryStage.show();
	
		});
		
		GamePane.setCenter(pane);
		GamePane.setAlignment(cbo,Pos.CENTER);
    
	scene = new Scene(GamePane,400,450);
	primaryStage.setResizable(false);		//Setting resizable.
	primaryStage.setTitle("Pipe Game");		//Setting title.
	primaryStage.setScene(scene);
	primaryStage.show();

	
  }
	
  public static void main(String[] args) {
	  	launch(args);
  }
	public ImageView getImageView(Image image_index,Stage primaryStage) {
		ImageView imageView = new ImageView(image_index);				//Function for the getting image view.
		return imageView;
	}
} //Main Class Bracket.