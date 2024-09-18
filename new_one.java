package Hospital;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class new_one extends MainFrame{
	protected static Label Name,Age,Address,Gender,TheDate,TheDate1,Doctor,Pay;
	protected static TextField NameInfo,AddressInfo,DoctorInfo,PayInfo;
	protected static Spinner<Integer> AgeList;
	protected static SpinnerValueFactory<Integer> Values;
	protected static RadioButton Male,Female;
	protected static ToggleGroup Group=new ToggleGroup(); 
	protected static DatePicker Date,Date1;
	protected static Button Finish;
	private static Alert A1=new Alert(Alert.AlertType.ERROR);
	@Override
	public void start(Stage stage) throws Exception {
		 Group Root=MainFrame.Root;
		 stage.setTitle("حجز جديد");
		 
		 
		 Name=new Label("اسم المريض :");
		 Name.setLayoutX(950);
		 Name.setLayoutY(100);
		 Name.setStyle("-fx-font-size: 22px");
		 Name.setTextFill(Color.WHITE);
		 
		 
		 NameInfo=new TextField();
		 NameInfo.setLayoutX(640);
		 NameInfo.setLayoutY(104);
		 NameInfo.setPrefSize(300, 30);
		 NameInfo.setStyle("-fx-background-radius: 12px;-fx-font-size: 15px");
		 NameInfo.setAlignment(Pos.TOP_RIGHT);
		 NameInfo.setPromptText("ادخل اسم المريض");
		 
		 
		 Age=new Label("سن المريض :");
		 Age.setLayoutX(450);
		 Age.setLayoutY(100);
		 Age.setStyle("-fx-font-size: 22px");
		 Age.setTextFill(Color.WHITE);
		 
		 
		 Values=new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 120, 1);
		 
		 AgeList=new Spinner<>();
		 AgeList.setLayoutX(200);
		 AgeList.setLayoutY(104);
		 AgeList.setPrefSize(200, 30);
		 AgeList.setStyle("-fx-font-size: 15px");
		 AgeList.setValueFactory(Values);
		 AgeList.setEditable(false);
		 
		 Address=new Label("العنوان :");
		 Address.setLayoutX(1000);
		 Address.setLayoutY(250);
		 Address.setStyle("-fx-font-size: 22px");
		 Address.setTextFill(Color.WHITE);
		 
		 AddressInfo=new TextField();
		 AddressInfo.setLayoutX(640);
		 AddressInfo.setLayoutY(254);
		 AddressInfo.setPrefSize(300, 30);
		 AddressInfo.setStyle("-fx-background-radius: 12px;-fx-font-size: 15px");
		 AddressInfo.setAlignment(Pos.TOP_RIGHT);
		 AddressInfo.setPromptText("ادخل عنوان المريض");
		 
		 
		 Gender=new Label("الجنس :");
		 Gender.setLayoutX(470);
		 Gender.setLayoutY(250);
		 Gender.setStyle("-fx-font-size: 22px");
		 Gender.setTextFill(Color.WHITE);
		 
		 Male=new RadioButton("ذكر");
		 Male.setLayoutX(330);
		 Male.setLayoutY(252);
		 Male.setFont(new Font(20));
		 Male.setToggleGroup(Group);
		 Male.setSelected(true);
		 
		 Female=new RadioButton("انثي");
		 Female.setLayoutX(210);
		 Female.setLayoutY(252);
		 Female.setFont(new Font(20));
		 Female.setToggleGroup(Group);
		 
		 
		 TheDate=new Label("تاريخ الحجز :");
		 TheDate.setLayoutX(970);
		 TheDate.setLayoutY(400);
		 TheDate.setStyle("-fx-font-size: 22px");
		 TheDate.setTextFill(Color.WHITE);
		 
		 
		 Date=new DatePicker();
		 Date.setLayoutX(640);
		 Date.setLayoutY(395);
		 Date.setPrefSize(300, 30);
		 Date.setStyle("-fx-font-size: 20px");
		 Date.setEditable(false);
		 
		 
		 TheDate1=new Label("تاريخ الكشف :");
		 TheDate1.setLayoutX(455);
		 TheDate1.setLayoutY(400);
		 TheDate1.setStyle("-fx-font-size: 22px");
		 TheDate1.setTextFill(Color.WHITE);
		 
		 
		 Date1=new DatePicker();
		 Date1.setLayoutX(140);
		 Date1.setLayoutY(395);
		 Date1.setPrefSize(300, 30);
		 Date1.setStyle("-fx-font-size: 20px");
		 Date1.setEditable(false);
		 
		 
		 Doctor=new Label("اسم الطبيب :");
		 Doctor.setLayoutX(970);
		 Doctor.setLayoutY(550);
		 Doctor.setStyle("-fx-font-size: 22px");
		 Doctor.setTextFill(Color.WHITE);
		 
		 
		 DoctorInfo=new TextField();
		 DoctorInfo.setLayoutX(640);
		 DoctorInfo.setLayoutY(554);
		 DoctorInfo.setPrefSize(300, 30);
		 DoctorInfo.setStyle("-fx-background-radius: 12px;-fx-font-size: 15px");
		 DoctorInfo.setAlignment(Pos.TOP_RIGHT);
		 DoctorInfo.setPromptText("ادخل اسم الطبيب");
		 
		 
		 Pay=new Label("مدفوع :");
		 Pay.setLayoutX(470);
		 Pay.setLayoutY(550);
		 Pay.setStyle("-fx-font-size: 22px");
		 Pay.setTextFill(Color.WHITE);
		 
		 
		 PayInfo=new TextField();
		 PayInfo.setLayoutX(150);
		 PayInfo.setLayoutY(554);
		 PayInfo.setPrefSize(300, 30);
		 PayInfo.setStyle("-fx-background-radius: 12px;-fx-font-size: 15px");
		 PayInfo.setAlignment(Pos.TOP_CENTER);
		 PayInfo.setPromptText("ادخل المبلغ المدفوع");
		 
		 
		 Finish=new Button("انهاء الحجز");
		 Finish.setLayoutX(400);
		 Finish.setLayoutY(670);
		 Finish.setPrefSize(350, 50);
		 Finish.setStyle("-fx-background-color: GREEN;-fx-background-radius: 20px;-fx-font-size: 30px");
		 Finish.setTextFill(Color.WHITE);
		 Finish.addEventHandler(MouseEvent.MOUSE_ENTERED, MouseEvent->{
			 MainFrame.S1.setCursor(Cursor.HAND);			 			 
		 });
		 Finish.addEventHandler(MouseEvent.MOUSE_EXITED, MouseEvent->{
			 MainFrame.S1.setCursor(Cursor.DEFAULT);			 			 
		 });
		 Finish.setOnAction((ActionEvent E)->{
			 try {
			 if(!Date.getValue().equals("")&&!Date1.getValue().equals(""))	 
			 {
			 RadioButton selected=(RadioButton) Group.getSelectedToggle();
			 ManageDataBase.new_one(NameInfo.getText(), Integer.valueOf(AgeList.getValue()), AddressInfo.getText(), String.valueOf(selected.getText()), String.valueOf(Date.getValue()), String.valueOf(Date1.getValue()), DoctorInfo.getText(), Integer.valueOf(PayInfo.getText()),ManageDataBase.RowId());		
			 }
			 else
			 {
				    A1.setTitle("خطا");
					A1.setContentText("حدث خطا ما!");
					A1.getDialogPane().setStyle("-fx-font-size: 15px");
					A1.show();
					return;
			 }
			 }
			 catch(Exception E1)
			 {
				    A1.setTitle("خطا");
					A1.setContentText("حدث خطا ما!");
					A1.getDialogPane().setStyle("-fx-font-size: 15px");
					A1.show();
			 }
		 });
		 
		 Root.getChildren().addAll(Name,NameInfo,Age,AgeList,Address,AddressInfo,Gender,Male,Female,TheDate,Date,TheDate1,Date1,Doctor,DoctorInfo,Pay,PayInfo,Finish);
		 
		
	}
	public static void RemoveAll()
	{
		 Root.getChildren().removeAll(Name,NameInfo,Age,AgeList,Address,AddressInfo,Gender,Male,Female,TheDate,Date,TheDate1,Date1,Doctor,DoctorInfo,Pay,PayInfo,Finish,Attends.DateInfo,Attends.DateInfo1,Attends.GenderInfo,Attends.IdInfo,Attends.Id,Attends.AgeInfo,Attends.Finish1,getAll.Table,getAll.NumberOfPerson,getAll.R1);
	}
	
	
}
