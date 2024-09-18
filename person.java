package Hospital;

public class person {

	
	private String Name,Address,Gender,Date1,Date2,Doctor;
	private int Age,Pay,id;
	
	
	public person(String Name,int Age,String Address,String Gender,String Date1,String Date2,String Doctor,int Pay)
	{
		this.Name=Name;
		this.Age=Age;
		this.Address=Address;
		this.Gender=Gender;
		this.Date1=Date1;
		this.Date2=Date2;
		this.Doctor=Doctor;
		this.Pay=Pay;
	}
	public person(String Name,int Age,String Address,String Gender,String Date1,String Date2,String Doctor,int Pay,int id)
	{
		this.Name=Name;
		this.Age=Age;
		this.Address=Address;
		this.Gender=Gender;
		this.Date1=Date1;
		this.Date2=Date2;
		this.Doctor=Doctor;
		this.Pay=Pay;
		this.id=id;
	}
	
	public String getName()
	{
		return this.Name;
	}
	public int getAge()
	{
		return this.Age;
	}
	public String getAddress()
	{
		return this.Address;
	}
	public String getGender()
	{
		return this.Gender;
	}
	public String getDate1()
	{
		return this.Date1;
	}
	public String getDate2()
	{
		return this.Date2;
	}
	public String getDoctor()
	{
		return this.Doctor;
	}
	public int getPay()
	{
		return this.Pay;
	}
	public int getId()
	{
		return this.id;
	}
}
