import java.sql.*;
import java.util.*;

// MySQLDatabase class, modified from one of the Practice Exercises - Written by Kevin Voltz
public class MySQLDatabase {

   // Connection object
   Connection conn = null;

   // Definitions for MySQL connection
   private String uri = "jdbc:mysql://localhost/research?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
   private String driver = "com.mysql.cj.jdbc.Driver";
   private String user = "root";
   private String password = "student";
   
   // Default Constructor
   MySQLDatabase()
   {
   }
   
   // Attempt to connect to database
   public boolean connect()
   {
      try
      {
         Class.forName(driver);
         conn = DriverManager.getConnection(uri, user, password);
      }
      catch(ClassNotFoundException cnfe)
      {
         try
         {
            String msg = "ClassNotFoundException in MySQLDatabase.connect()";
            throw new DLException(cnfe, msg, "Driver - " + driver);
         }
         catch(DLException dl)
         {
            return false;
         }
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.connect()";
            throw new DLException(sqle, msg, "Uri - " + uri, "User - " + user, "Password - " + password);
         }
         catch(DLException dl)
         {
            return false;
         }
         
      }
      return true;
   }
   
   // Attempt to close database
   public boolean close()
   {
      try
      {
         conn.close();
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.close()";
            throw new DLException(sqle, msg, "Uri - " + uri, "User - " + user);
         }
         catch(DLException dl)
         {
            return false;
         }
      }
      return true;
   }
   
   // Newest getData method
   public ArrayList<ArrayList<String>> getData(String sql, boolean columns)
   {
      ArrayList<ArrayList<String>> stringArray = new ArrayList<ArrayList<String>>();
      stringArray.add(new ArrayList<String>());
      
      if(columns == true)
      {
         // Grab the output of the original getData method so that the column names can be added to it
         stringArray = this.getData(sql);
         
         // Connect to database
         this.connect();
         
         try
         {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            ArrayList<String> columnNames = new ArrayList<String>();
            
            for (int i=1; i<=numCols; i++)
            {
               columnNames.add(rsmd.getColumnName(i));
            }
            stringArray.add(0, columnNames);
         }
         catch(SQLException sqle)
         {
            try
            {
               String msg = "SQLException in MySQLDatabase.getData()";
               sqle.printStackTrace();
               throw new DLException(sqle, msg, "SQL - " + sql);
            }
            catch(DLException dl)
            {
            }
         }
      
         // Close database
         this.close();
         
         return stringArray;
      }
      
      // If the boolean is not true, the method simply returns the output of the original getData method
      return this.getData(sql);
      
      
   }
   
   public ArrayList<ArrayList<String>> getData(String sql)
   {
      ArrayList<ArrayList<String>> stringArray = new ArrayList<ArrayList<String>>();
      stringArray.add(new ArrayList<String>());
   
      // Connect to database
      try
      {
         if(conn == null || conn.getAutoCommit())
         {
            this.connect();
         }
      
      // Execute query and return 2D ArrayList
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         ResultSetMetaData rsmd = rs.getMetaData();
         int numCols = rsmd.getColumnCount();
         int row = 0;
      
         while (rs.next()) {
            for (int i=1; i<=numCols; i++) {
               stringArray.get(row).add(rs.getString(i));
            }
            stringArray.add(new ArrayList<String>());
            row++;
         }
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.getData()";
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            sqle.printStackTrace();
            this.close();
         }
         return stringArray;
      }
      
      // Close database
      try
      {
         if(conn != null && conn.getAutoCommit())
         {
            this.close();
         }
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.setData()";
            sqle.printStackTrace();
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            this.close();
         }
      }
      
      return stringArray;
   
   }
   
   // Get Data method for queries
   public ArrayList<ArrayList<String>> getData(String sql, int numCols)
   {
      ArrayList<ArrayList<String>> stringArray = new ArrayList<ArrayList<String>>();
      stringArray.add(new ArrayList<String>());
   
      // Connect to database
      this.connect();
   
      // Execute query and return 2D ArrayList
      try{
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         int row = 0;
      
         while (rs.next()) {
            for (int i=1; i<=numCols; i++) {
               stringArray.get(row).add(rs.getString(i));
            }
            stringArray.add(new ArrayList<String>());
            row++;
         }
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.getData()";
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            sqle.printStackTrace();
            this.close();
         }
         return stringArray;
      }
      
      // Close database
      this.close();
      
      return stringArray;
   }
   
   // Set Data method for update, delete, insert
   public int setData(String sql)
   {
      int i;
      
      // Connect to Database
      try
      {
         if(conn == null || conn.getAutoCommit())
         {
            this.connect();
         }
      
      
      // Execute Query
         Statement stmt = conn.createStatement();
         i = stmt.executeUpdate(sql);
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.setData()";
            sqle.printStackTrace();
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            this.close();
            return -1;
         }
      }
      
      // Close database
      try
      {
         if(conn != null && conn.getAutoCommit())
         {
            this.close();
         }
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.setData()";
            sqle.printStackTrace();
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            this.close();
            return -1;
         }
      }
      
      return i;
   }
   
   // Set Prepared Data method for update
   public int setUpdatePreparedData(String sql, String updateValue, String whereValue)
   {
      int i;
      
      // Connect to Database
      try
      {
         if(conn == null || conn.getAutoCommit())
         {
            this.connect();
         }
      
      
      // Execute Query
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setString(1, updateValue);
         stmt.setString(2, whereValue);
         i = stmt.executeUpdate();
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.setData()";
            sqle.printStackTrace();
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            this.close();
            return -1;
         }
      }
      
      // Close database
      try
      {
         if(conn != null && conn.getAutoCommit())
         {
            this.close();
         }
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.setData()";
            sqle.printStackTrace();
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            this.close();
            return -1;
         }
      }
      
      return i;
   }
   
   // Set Prepared Data method for insert
   public int setInsertPreparedData(String sql, String name, String description)
   {
      int i;
      
      // Connect to Database
      try
      {
         if(conn == null || conn.getAutoCommit())
         {
            this.connect();
         }
      
      
      // Execute Query
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setString(1, name);
         stmt.setString(2, description);
         i = stmt.executeUpdate();
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.setData()";
            sqle.printStackTrace();
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            this.close();
            return -1;
         }
      }
      
      // Close database
      try
      {
         if(conn != null && conn.getAutoCommit())
         {
            this.close();
         }
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.setData()";
            sqle.printStackTrace();
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            this.close();
            return -1;
         }
      }
      
      return i;
   }
   
   // Set Prepared Data method for delete
   public int setDeletePreparedData(String sql, String deleteValue)
   {
      int i;
      
      // Connect to Database
      try
      {
         if(conn == null || conn.getAutoCommit())
         {
            this.connect();
         }
      
      
      // Execute Query
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setString(1, deleteValue);
          
         i = stmt.executeUpdate();
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.setData()";
            sqle.printStackTrace();
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            this.close();
            return -1;
         }
      }
      
      // Close database
      try
      {
         if(conn != null && conn.getAutoCommit())
         {
            this.close();
         }
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.setData()";
            sqle.printStackTrace();
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            this.close();
            return -1;
         }
      }
      
      return i;
   }


   
   public void descTable(String sql)
   {
   
      // Connect to database
      this.connect();
   
      // Execute query and print metadata
      try{
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         ResultSetMetaData rsmd = rs.getMetaData();
         int numCols = rsmd.getColumnCount();
         String table = rsmd.getTableName(1);
         System.out.println(numCols + " columns were retrieved from " + table + " table.");
         System.out.printf("%-25s %-25s\n", "..Column Name..", "..Column Type..");
         
         String formattedColumns = "";
         String formattedLine = "+";
                  
         for (int i=1; i<=numCols; i++) {
            
            int type = rsmd.getColumnType(i);
            if (type == Types.VARCHAR) 
            {
               System.out.printf("%-25s %-25s\n", rsmd.getColumnName(i), "VARCHAR(" + rsmd.getColumnDisplaySize(i) + ")");           
            } 
            else if(type == Types.CHAR)
            {
               System.out.printf("%-25s %-25s\n", rsmd.getColumnName(i), "CHAR(" + rsmd.getColumnDisplaySize(i) + ")");  
            }
            else if(type == Types.DATE)
            {
               System.out.printf("%-25s %-25s\n", rsmd.getColumnName(i), "DATE");     
            }
            else if(type == Types.INTEGER)
            {
               System.out.printf("%-25s %-25s\n", rsmd.getColumnName(i), "INT(" + rsmd.getColumnDisplaySize(i) + ")");    
            }
            else 
            {
               System.out.printf("%-25s %-25s\n", rsmd.getColumnName(i), "Column Type not recognized");   
            }
            
            if(i == 1)
            {
               formattedColumns = String.format("%-25s", "| " + rsmd.getColumnName(i));
            }
            else if(i == numCols)
            {
               formattedColumns = String.format("%-25s %-25s", formattedColumns, "| " + rsmd.getColumnName(i)) + " |";
            }
            else if(i > 1)
            {
               formattedColumns = String.format("%-25s %-25s", formattedColumns, "| " + rsmd.getColumnName(i));
            }
            formattedLine = formattedLine + "-------------------------+";
         }
         
         System.out.println();
         System.out.println(formattedLine);
         System.out.println(formattedColumns);
         System.out.println(formattedLine);
         rs.beforeFirst();
         numCols = rsmd.getColumnCount();
         
         while (rs.next()) 
         {
            for (int i = 1; i <= numCols; i++) 
            {
               if(i == 1)
               {
                  formattedColumns = String.format("%-25s", "| " + rs.getString(i));
               }
               else if(i == numCols)
               {
                  formattedColumns = String.format("%-25s %-25s", formattedColumns, "| " + rs.getString(i)) + " |";
               }
               else if(i > 1)
               {
                  formattedColumns = String.format("%-25s %-25s", formattedColumns, "| " + rs.getString(i));
               }
            }
            System.out.println(formattedColumns);
         }
         System.out.println(formattedLine);
      
      
         
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.descTable()";
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            sqle.printStackTrace();
            this.close();
         }
      }
      
      // Close database
      this.close();   
   }
   
   // Start a Transaction
   public void startTrans()
   {
      try
      {
         this.connect();
         conn.setAutoCommit(false);
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.startTrans()";
            throw new DLException(sqle, msg);
         }
         catch(DLException dl)
         {
            sqle.printStackTrace();
            this.close();
         }
      }
   }
   
   // End Transaction
   public void endTrans()
   {
      try
      {
         conn.commit();
         conn.setAutoCommit(true);
         this.close();
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.endTrans()";
            throw new DLException(sqle, msg);
         }
         catch(DLException dl)
         {
            sqle.printStackTrace();
            this.close();
         }
      }
   }
   
   // Rollback Transaction
   public void rollbackTrans()
   {
      try
      {
         conn.rollback();
         conn.setAutoCommit(true);
         this.close();
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.rollbackTrans()";
            throw new DLException(sqle, msg);
         }
         catch(DLException dl)
         {
            sqle.printStackTrace();
            this.close();
         }
      }
   }
   
   // getData using Prepared Statements - used in the SELECT methods for the Projects class
   public ArrayList<ArrayList<String>> getPreparedData(String sql, String filter)
   {
      ArrayList<ArrayList<String>> stringArray = new ArrayList<ArrayList<String>>();
      stringArray.add(new ArrayList<String>());
   
      // Connect to database
      try
      {
         if(conn == null || conn.getAutoCommit())
         {
            this.connect();
         }
      
      // Execute query and return 2D ArrayList
         PreparedStatement stmt = conn.prepareStatement(sql);
         if(filter.equals("Select All") == false)
         {
            stmt.setString(1, filter);
         }
         ResultSet rs = stmt.executeQuery();
         ResultSetMetaData rsmd = rs.getMetaData();
         int numCols = rsmd.getColumnCount();
         int row = 0;
      
         while (rs.next()) {
            for (int i=1; i<=numCols; i++) {
               stringArray.get(row).add(rs.getString(i));
            }
            stringArray.add(new ArrayList<String>());
            row++;
         }
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.getData()";
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            sqle.printStackTrace();
            this.close();
         }
         return stringArray;
      }
   
   // Close database
      try
      {
         if(conn != null && conn.getAutoCommit())
         {
            this.close();
         }
      }
      catch(SQLException sqle)
      {
         try
         {
            String msg = "SQLException in MySQLDatabase.setData()";
            sqle.printStackTrace();
            throw new DLException(sqle, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            this.close();
         }
      }
      
      return stringArray;
   
   }


}