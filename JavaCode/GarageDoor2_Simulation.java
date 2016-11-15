package floor1;


import java.sql.DriverManager;


import java.sql.*;

public class GarageDoor2_Simulation implements Runnable{
	
	GarageDoor door2 = new GarageDoor();
	
	
	@Override
	public void run() {

		

		String url = "jdbc:mysql://localhost:3306/";


		String user = "root";


		String password = "";
		
		int currentStatus = door2.getDoorStatus();
		
		while(true)
		{
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            
            Statement stt = con.createStatement();
            
            stt.execute("USE sensors");
            
            PreparedStatement prep = con.prepareStatement("SELECT door_status FROM garagedoor1");
            
            
            ResultSet res = prep.executeQuery();
            
            while (res.next())
            {
            	
                door2.setDoorStatus(Integer.parseInt(res.getString("door_status")));
            }
            
            /**
             * Free all opened resources
             */
            
            if (currentStatus != door2.getDoorStatus())
            {
            	if (door2.getDoorStatus() == 1)
            		System.out.println("Garage Door 2 Open");
            	else
            		if (door2.getDoorStatus() == 0)
            		System.out.println("Garage Door 2 Closed");
            	
            	currentStatus =door2.getDoorStatus();
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
