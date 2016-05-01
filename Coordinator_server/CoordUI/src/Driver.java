
public class Driver {
	private String Name; 
	private String Clientee ; 
	private String Navigator ;
	private String Phone;
	
	public    String getName()
	{
		return Name;
	}
	Driver ()
	{
		setName("Xbox One");
		Phone="913 93223";
	}
	public void setName(String name) {
		Name = name;
	}
	public void AssignClient(String assignC) {
		Clientee = assignC;
	}
	public void AssignNaviagtor(String assignN) {
		Navigator = assignN;
	}
	public String getClient() {
		return Clientee ;
	}
	public String getNavigator() {
		return Navigator ;
	}
	public String getPhone()
	{
		return Phone;
	}

}
