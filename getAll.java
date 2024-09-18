package Hospital;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class getAll extends Attends{

	public static TableView<person> Table;
	private TableColumn<person,String> NameCol=new TableColumn<>("الاسم");
	private TableColumn<person,Integer> AgeCol=new TableColumn<>("السن");
	private TableColumn<person,String> AddressCol=new TableColumn<>("العنوان");
	private TableColumn<person,String> GenderCol=new TableColumn<>("الجنس");
	private TableColumn<person,String> DateCol=new TableColumn<>("تاريخ الحجز");
	private TableColumn<person,String> Date1Col=new TableColumn<>("تاريخ الكشف");
	private TableColumn<person,String> DoctorCol=new TableColumn<>("اسم الطبيب");
	private TableColumn<person,Integer> PayCol=new TableColumn<>("مدفوع");
	private TableColumn<person,Integer> IdCol=new TableColumn<>("رقم الحجز");
	public static Label NumberOfPerson;
	public static Rectangle R1;		
	@Override
	public void start(Stage stage) throws Exception {
		
		createTable();
		
		stage.setTitle("جميع الحجوزات");
		
		
		R1=new Rectangle(440,650,230,50);
		R1.setStroke(Color.BLUE);
		R1.setStrokeWidth(4);
		R1.setFill(Color.RED);
		
		NumberOfPerson=new Label("عدد الحجوزات : "+String.valueOf(ManageDataBase.getNumber()));
		NumberOfPerson.setLayoutX(450);
		NumberOfPerson.setLayoutY(650);
		NumberOfPerson.setStyle("-fx-font-size: 30px;");
		NumberOfPerson.setTextFill(Color.WHITE);
		Root.getChildren().addAll(R1,NumberOfPerson);
		
		
		
	}
	
	public void createTable()
	{
		Table=new TableView<>();
		ArrayList<person> List=ManageDataBase.getAll();
		ObservableList<person> data=FXCollections.observableArrayList();
		for(int i=0;i<List.size();i++)
		{
			data.add(new person(List.get(i).getName(),List.get(i).getAge(),List.get(i).getAddress(),List.get(i).getGender(),List.get(i).getDate1(),List.get(i).getDate2(),List.get(i).getDoctor(),List.get(i).getPay(),List.get(i).getId()));
		}
		NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
		AgeCol.setCellValueFactory(new PropertyValueFactory<>("Age"));
		AddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
		GenderCol.setCellValueFactory(new PropertyValueFactory<>("Gender"));
		DateCol.setCellValueFactory(new PropertyValueFactory<>("Date1"));
		Date1Col.setCellValueFactory(new PropertyValueFactory<>("Date2"));
		DoctorCol.setCellValueFactory(new PropertyValueFactory<>("Doctor"));
		PayCol.setCellValueFactory(new PropertyValueFactory<>("Pay"));
		IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		DateCol.setPrefWidth(150);
		Date1Col.setPrefWidth(150);
		NameCol.setPrefWidth(250);
		AddressCol.setPrefWidth(180);
		
		Table.getColumns().addAll(NameCol,AgeCol,AddressCol,GenderCol,DateCol,Date1Col,DoctorCol,PayCol,IdCol);
		Table.setItems(data);
		Table.setLayoutX(0);
		Table.setLayoutY(0);
		Table.setPrefSize(1135, 600);
		Root.getChildren().addAll(Table);
	}

}
