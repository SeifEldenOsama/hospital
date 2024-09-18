package Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.Alert;



public class ManageDataBase {

	private static Alert A1=new Alert(Alert.AlertType.INFORMATION);
	private static Alert A2=new Alert(Alert.AlertType.ERROR);
	public static boolean IsTrue(String User,String Pass)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT * FROM signIn WHERE username=? and pass=?"))
		{
			P.setString(1, User);
			P.setString(2, Pass);
			P.execute();
			ResultSet R1=P.executeQuery();
			R1.next();
			if(R1.getString("username").equals(User)&&R1.getString("pass").equals(Pass))
			    return true;
			else 
				return false;
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return false;
		}
		
		
	}
	
	public static void new_one(String Name,int Age,String Address,String Gender,String Date1,String Date2,String Doctor,int Pay,int id)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("INSERT INTO person VALUES(?,?,?,?,?,?,?,?,?)"))
		{
			P.setString(1, Name);
			P.setInt(2, Age);
			P.setString(3, Address);
			P.setString(4, Gender);
			P.setString(5, Date1);
			P.setString(6, Date2);
			P.setString(7, Doctor);
			P.setInt(8, Pay);
			P.setInt(9, id);
			P.execute();
			A1.setTitle("تم الحجز");
			A1.setContentText("تمت عملية الحجز بنجاح رقم الحجز : "+id);
			A1.getDialogPane().setStyle("-fx-font-size: 15px");
			A1.show();
			
		}
		catch(SQLException E)
		{
			System.out.println(E.getMessage());
			A2.setTitle("خطا");
			A2.setContentText("حدث خطا ما!");
			A2.getDialogPane().setStyle("-fx-font-size: 15px");
			A2.show();
		}
	}
	
	public static int RowId()
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT MAX(id) + 1 AS next_id FROM person"))
		{
			P.execute();
			ResultSet R1=P.executeQuery();
			if(R1.next())
			{
				return R1.getInt("next_id");
			}
		}
		catch(Exception E)
		{
		    System.out.println(E.getMessage());			   
		}
		 return -1;
	}
	
	public static void delete(int Id)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("DELETE FROM person WHERE id=?"))
		{
			P.setInt(1, Id);
			P.execute();	
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
	}
	
	public static person Attends(int Id)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT * FROM person WHERE id=?"))
		{
			P.setInt(1, Id);
			P.execute();
			ResultSet R1=P.executeQuery();
			R1.next();
			return new person(R1.getString("the_name"),R1.getInt("the_age"),R1.getString("the_address"),R1.getString("the_gender"),R1.getString("the_date1"),R1.getString("the_date2"),R1.getString("the_doctor"),R1.getInt("the_pay"));			
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return null;
		}
		
		
	}
    
	public static ArrayList<person> getAll()
	{
		ArrayList<person> List=new ArrayList<>();
		try(Connection Con=DataBaseConnection.Connect(); PreparedStatement P=Con.prepareStatement("SELECT * FROM person"))
		{
			P.execute();
			ResultSet R1=P.executeQuery();
			while(R1.next())
			{
				List.add(new person(R1.getString("the_name"),R1.getInt("the_age"),R1.getString("the_address"),R1.getString("the_gender"),R1.getString("the_date1"),R1.getString("the_date2"),R1.getString("the_doctor"),R1.getInt("the_pay"),R1.getInt("id")));
			}
			return List;
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return null;
		}
		
		
	}
	public static int getNumber()
	{
		int counter=0;
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT * FROM person"))
		{
			P.execute();
			ResultSet R1=P.executeQuery();
			while(R1.next())
			{
				counter++;
			}
			return counter;
		}
		catch(Exception E)
		{
		    System.out.println(E.getMessage());			   
		}
		 return 0;
	}
	
	
	
}
