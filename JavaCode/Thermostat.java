package floor1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Thermostat implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		String url = "jdbc:mysql://localhost:3306/";


		String user = "root";


		String password = "";
		
		int current = 70;
		int desired =0;

		//int currentStatus = door2.getDoorStatus();

		while(true)
		{

			try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection(url, user, password);

				Statement stt = con.createStatement();

				stt.execute("USE sensors");

				PreparedStatement prep = con.prepareStatement("SELECT desired FROM thermostat");


				ResultSet res = prep.executeQuery();

				while (res.next())
				{

					desired = Integer.parseInt(res.getString("desired"));
				}

				/**
				 * Free all opened resources
				 */

				while (desired!=current)
				{
					if (desired<current)
					{
						desired++;						
						Thread.sleep(5000);
						Statement stt2 = con.createStatement();

						stt2.execute("USE sensors");

						PreparedStatement prep1 = con.prepareStatement("UPDATE `thermostat` SET `desired`="+desired+" WHERE id = 1");
						prep1.executeUpdate();
/*
						String query = " update 'thermostat' 'desired'="+desired+"where id =1" ;
						      // create the mysql insert preparedstatement
						      PreparedStatement preparedStmt = con.prepareStatement(query);
						      
						      
						      preparedStmt.execute();*/


						
						
						
						
					}
					
					else {
						desired--;
						Thread.sleep(500);
						Statement stt2 = con.createStatement();

						stt2.execute("USE sensors");

						PreparedStatement prep1 = con.prepareStatement("UPDATE `thermostat` SET `desired`="+desired+" WHERE id = 1");
						prep1.executeUpdate();

					}
					
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

	}}
