
public class Driver {
	private  String Name; 
	private String Clientee ; 
	private String Navigator ;
	
	
	public  String getName()
	{
		return Name;
	}
	Driver ()
	{
		setName("Xbox One");
		
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
	public String getClient(String assignC) {
		return Clientee ;
	}
	public String getNavigator(String assignN) {
		return Navigator ;
	}
	

}
