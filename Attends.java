package Hospital;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Attends extends new_one {

	public static Label Id;
	public static TextField IdInfo,DateInfo,DateInfo1,GenderInfo,AgeInfo;
	public static Button Finish1;
	private Alert A1=new Alert(Alert.AlertType.INFORMATION);
	private Alert A2=new Alert(Alert.AlertType.ERROR);
	
	@Override
	public void start(Stage stage) throws Exception {
		Group Root=MainFrame.Root;
	    new new_one().start(stage);
		stage.setTitle("تسجيل حضور");
	    
	    NameInfo.setEditable(false);
	    NameInfo.setPromptText("");;
		AddressInfo.setEditable(false);
		AddressInfo.setPromptText("");
		DoctorInfo.setEditable(false);
		DoctorInfo.setPromptText("");
		PayInfo.setEditable(false);
		PayInfo.setPromptText("");
		Root.getChildren().removeAll(Male,Female,Finish,Date,Date1,AgeList);	
		
		AgeInfo=new TextField();
		AgeInfo.setLayoutX(145);
		AgeInfo.setLayoutY(104);
		AgeInfo.setPrefSize(300,30);
		AgeInfo.setStyle("-fx-font-size: 15px;-fx-background-radius: 12px");
		AgeInfo.setEditable(false);
		AgeInfo.setAlignment(Pos.TOP_CENTER);
		
		DateInfo=new TextField();
		DateInfo.setLayoutX(640);  
		DateInfo.setLayoutY(400);
		DateInfo.setPrefSize(300, 30);
		DateInfo.setStyle("-fx-background-radius: 12px;-fx-font-size: 15px");
		DateInfo.setAlignment(Pos.TOP_CENTER);
		DateInfo.setEditable(false);
		
		DateInfo1=new TextField();
		DateInfo1.setLayoutX(145);  
		DateInfo1.setLayoutY(400);
		DateInfo1.setPrefSize(300, 30);
		DateInfo1.setStyle("-fx-background-radius: 12px;-fx-font-size: 15px");
		DateInfo1.setAlignment(Pos.TOP_CENTER);
		DateInfo1.setEditable(false);
		
		
		GenderInfo=new TextField();
		GenderInfo.setLayoutX(150);
		GenderInfo.setLayoutY(254);
		GenderInfo.setPrefSize(300, 30);
		GenderInfo.setStyle("-fx-background-radius: 12px;-fx-font-size: 15px");
		GenderInfo.setAlignment(Pos.TOP_CENTER);
		GenderInfo.setEditable(false);
		
		Id=new Label("رقم الحجز :");
		Id.setLayoutX(760);
		Id.setLayoutY(670);
		Id.setStyle("-fx-font-size: 22px");
        Id.setTextFill(Color.WHITE);
        
        IdInfo=new TextField();
        IdInfo.setLayoutX(420);
        IdInfo.setLayoutY(670);
        IdInfo.setPrefSize(300, 30);
        IdInfo.setStyle("-fx-background-radius: 12px; -fx-font-size: 15px");
        IdInfo.setAlignment(Pos.TOP_CENTER);
        IdInfo.setPromptText("ادخل رقم الحجز");
        
        Finish1=new Button("تأكيد");
        Finish1.setLayoutX(250);
        Finish1.setLayoutY(660);
        Finish1.setPrefSize(150, 50);
        Finish1.setStyle("-fx-background-radius: 12px; -fx-font-size: 25px; -fx-background-color: GREEN");
        Finish1.setTextFill(Color.WHITE);
        Finish1.addEventHandler(MouseEvent.MOUSE_ENTERED, MouseEvent->{
        	S1.setCursor(Cursor.HAND);
        });
        Finish1.addEventHandler(MouseEvent.MOUSE_EXITED, MouseEvent->{
        	S1.setCursor(Cursor.DEFAULT);
        }); 
        Finish1.setOnAction((ActionEvent E)->{
        	try
        	{
        		person P1=ManageDataBase.Attends(Integer.valueOf(IdInfo.getText()));
        		NameInfo.setText(P1.getName());
        		AgeInfo.setText(String.valueOf(P1.getAge()));
        		AddressInfo.setText(P1.getAddress());
        		GenderInfo.setText(P1.getGender());
        		DateInfo.setText(P1.getDate1());
        		DateInfo1.setText(P1.getDate2());
        		DoctorInfo.setText(P1.getDoctor());
        		PayInfo.setText(String.valueOf(P1.getPay()));
        		A1.setTitle("تم الحضور");
        		A1.setContentText("تم حضور المريض");
        		A1.getDialogPane().setStyle("-fx-font-size: 15px");
        		A1.show();
        		ManageDataBase.delete(Integer.valueOf(IdInfo.getText()));
        	}
        	catch(Exception E1)
        	{
        		System.out.println(E1.getMessage());
        		A2.setTitle("خطأ");
        		A2.setContentText("رقم الحجز هذا غير موجود");
        		A2.getDialogPane().setStyle("-fx-font-size: 15px");
        		A2.show();
        	}
            	       	
        });
		
		Root.getChildren().addAll(DateInfo,DateInfo1,GenderInfo,Id,IdInfo,AgeInfo,Finish1);
	}

}
