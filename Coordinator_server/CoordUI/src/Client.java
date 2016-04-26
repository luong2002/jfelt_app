
public class Client {
	private  String Name; 
	private String Phone; 
	private String ADflag; // using it to test the button to press once 
	
	public  String getName()
	{
		return Name;
	}
	public String getPhone()
	{
		return Phone;
	}
	Client ()
	{
		setName("Tony Candy");
		Phone = "911";
		ADflag = "Not Set";
	}
	public void setName(String name) {
		Name = name;
	}
	public void SetADflag(String state)
	{
		ADflag= state;	
	}
	public String GetADflag()
	{
		return ADflag;
		
	}
}
