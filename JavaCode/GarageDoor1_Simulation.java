package floor1;


import java.sql.DriverManager;


import java.sql.*;

public class GarageDoor1_Simulation implements Runnable{
	
	GarageDoor door1 = new GarageDoor();
	
	
	@Override
	public void run() {

		

		String url = "jdbc:mysql://localhost:3306/";


		String user = "root";


		String password = "";
		
		int currentStatus = door1.getDoorStatus();
		
		while(true)
		{
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            
            Statement stt = con.createStatement();
            
            stt.execute("USE sensors");
            
            PreparedStatement prep = con.prepareStatement("SELECT door_status FROM garagedoor");
            
            
            ResultSet res = prep.executeQuery();
            
            while (res.next())
            {
            	
                door1.setDoorStatus(Integer.parseInt(res.getString("door_status")));
            }
            
            /**
             * Free all opened resources
             */
            
            if (currentStatus != door1.getDoorStatus())
            {
            	if (door1.getDoorStatus() == 1)
            		System.out.println("Garage Door Open");
            	else
            		if (door1.getDoorStatus() == 0)
            		System.out.println("Garage Door Closed");
            	
            	currentStatus =door1.getDoorStatus();
            }
            
            stt.close();
            prep.close();
            con.close();
            Thread.sleep(1000);
		}
		catch (Exception e)
        {
            e.printStackTrace();
        }
		
		
   }

	}

}
