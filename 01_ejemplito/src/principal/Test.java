package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");
			Statement st=con.createStatement();
			String sql="select nombre from contactos";
			ResultSet rs=st.executeQuery(sql); 
			while(rs.next()){
				
				System.out.println(rs.getString("nombre"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException ex){
			ex.printStackTrace();
			
		}
		finally{
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){
					ex.printStackTrace();
					
				}
				
		}
		}

	}

}
