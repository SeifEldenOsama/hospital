package Hospital;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainFrame extends Application{

	private Screen screen=Screen.getPrimary();
	private Rectangle2D bounds=screen.getVisualBounds();
	private double screen_width=bounds.getWidth(),screen_height=bounds.getHeight();
	private Rectangle Menu,R1,R2,R3;
	private ImageView DoctorImage,new_patient_image,attendance_image,CheckAll_image;
	private Button new_patient,attendance,check_All;
	protected static Group Root;
	protected static Scene S1;
	private int Flag;
	@Override
	public void start(Stage stage) throws Exception {
	    Root=new Group();
		S1=new Scene(Root,screen_width,screen_height,Color.BURLYWOOD);
		stage.setTitle("الصفحة الرئيسية");
        stage.setScene(S1);
        
        DoctorImage=new ImageView(new Image(getClass().getResourceAsStream("doctor.png")));
		DoctorImage.setLayoutX(screen_width-270);
		DoctorImage.setLayoutY(15);
        
        Menu=new Rectangle(screen_width-400,0,400,screen_height);
        Menu.setFill(Color.ORANGE);
        
       
        R1=new Rectangle(screen_width-310,213,220,100);
        R1.setStroke(Color.BLUE);
        R1.setFill(Color.TRANSPARENT);
        R1.setStrokeWidth(7);
        
             
        new_patient_image=new ImageView(new Image(getClass().getResourceAsStream("patient.png")));
        
        new_patient=new Button("حجز جديد");
        new_patient.setLayoutX(screen_width-330);
        new_patient.setLayoutY(220);
        new_patient.setTextFill(Color.WHITE);
        new_patient.setStyle("-fx-background-color: ORANGE; -fx-font-size: 40px");
        new_patient.setGraphic(new_patient_image);
        new_patient.setContentDisplay(ContentDisplay.LEFT);
        new_patient.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
        	S1.setCursor(Cursor.HAND);     
        	new_patient.setTextFill(Color.BLUE);
        });
        new_patient.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
        	S1.setCursor(Cursor.DEFAULT);   
        	if(Flag!=1)
        	new_patient.setTextFill(Color.WHITE);
        });
        new_patient.setOnAction((ActionEvent E)->{
        	Flag=1;
        	new_patient.setTextFill(Color.BLUE);
        	attendance.setTextFill(Color.WHITE);
        	check_All.setTextFill(Color.WHITE);
        	new_one.RemoveAll();
        	try {
				new new_one().start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        	       	
        });
        
        R2=new Rectangle(screen_width-345,393,290,100);
        R2.setStroke(Color.BLUE);
        R2.setFill(Color.TRANSPARENT);
        R2.setStrokeWidth(7);
        
        attendance_image=new ImageView(new Image(getClass().getResourceAsStream("attendance.png")));
        
        attendance=new Button("حضور مريض");
        attendance.setLayoutX(screen_width-360);
        attendance.setLayoutY(400);
        attendance.setTextFill(Color.WHITE);
        attendance.setStyle("-fx-background-color: ORANGE; -fx-font-size: 40px");
        attendance.setGraphic(attendance_image);
        attendance.setContentDisplay(ContentDisplay.LEFT);
        attendance.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
        	S1.setCursor(Cursor.HAND);     
        	attendance.setTextFill(Color.BLUE);
        });
        attendance.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
        	S1.setCursor(Cursor.DEFAULT);
        	if(Flag!=2)
        	attendance.setTextFill(Color.WHITE);
        });
        
        attendance.setOnAction((ActionEvent E)->{
        	Flag=2;
        	attendance.setTextFill(Color.BLUE);
        	new_patient.setTextFill(Color.WHITE);
        	check_All.setTextFill(Color.WHITE);
        	new_one.RemoveAll();
        	try {
				new Attends().start(stage);
				Attends.IdInfo.requestFocus();
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        	
        });
        
        
        R3=new Rectangle(screen_width-345,573,290,100);
        R3.setStroke(Color.BLUE);
        R3.setFill(Color.TRANSPARENT);
        R3.setStrokeWidth(7);
        
        CheckAll_image=new ImageView(new Image(getClass().getResourceAsStream("checkAll.png")));
        
        check_All=new Button("جميع الحجوزات");
        check_All.setLayoutX(screen_width-380);
        check_All.setLayoutY(580);
        check_All.setTextFill(Color.WHITE);
        check_All.setStyle("-fx-background-color: ORANGE; -fx-font-size: 40px");
        check_All.setGraphic(CheckAll_image);
        check_All.setContentDisplay(ContentDisplay.LEFT);
        check_All.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
        	S1.setCursor(Cursor.HAND);     
        	check_All.setTextFill(Color.BLUE);
        });
        check_All.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
        	S1.setCursor(Cursor.DEFAULT);
        	if(Flag!=3)
        	check_All.setTextFill(Color.WHITE);
        });
        check_All.setOnAction((ActionEvent E)->{
        	Flag=3;
        	check_All.setTextFill(Color.BLUE);
        	new_patient.setTextFill(Color.WHITE);
        	attendance.setTextFill(Color.WHITE);
        	new_one.RemoveAll();
        	try {
				new getAll().start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        });
        
        
		
		Root.getChildren().addAll(Menu,DoctorImage,R1,new_patient,R2,attendance,R3,check_All);
        stage.show();
	}

}
