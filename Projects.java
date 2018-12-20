import java.sql.*;
import java.util.*;

// Data layer class to represent a row in the projects table - Written by Kevin Voltz
public class Projects{

   // Project attributes
   private int projectID;
   private String name;
   private String description;
   private String userID;
      
   // Default Constructor
   Projects()
   {
   }
   
   // SELECT Users method - takes in a value and clause, and selects each entry in the users table where the clause equals the value using prepared statements
   public ArrayList<ArrayList<String>> selectUsers(String value, String clause)
   {
      MySQLDatabase sqldb = new MySQLDatabase();
      String sql = null;
      
      switch (clause)
      {
         case "users.userID" : sql = "SELECT userID, name, email, role FROM users WHERE userID = ?;";
            break;
         case "users.name" : sql = "SELECT userID, name, email, role FROM users WHERE name = ?;";
            break;
         case "users.email" : sql = "SELECT userID, name, email, role FROM users WHERE email = ?;";
            break;
         case "users.role" : sql = "SELECT userID, name, email, role FROM users WHERE role = ?;";
            break;
      }
      ArrayList<ArrayList<String>> result = sqldb.getPreparedData(sql, value);
      result.remove(result.size() - 1);
      return result;
   }

   
   // SELECT method - takes in a value and clause, and selects each entry in the projects table where the clause equals the value using prepared statements
   public ArrayList<ArrayList<String>> select(String value, String clause)
   {
      MySQLDatabase sqldb = new MySQLDatabase();
      String sql = null;
      
      switch (clause)
      {
         case "projects.userID" : sql = "SELECT projectID, projects.name, description, projects.userID, users.name FROM projects JOIN users USING(userID) WHERE projects.userID = ?;";
            break;
         case "projects.name" : sql = "SELECT projectID, projects.name, description, userID, users.name FROM projects JOIN users USING(userID) WHERE projects.name = ?;";
            break;
         case "projects.projectID" : sql = "SELECT projectID, projects.name, description, userID, users.name FROM projects JOIN users USING(userID) WHERE projects.projectID = ?;";
            break;
         case "projects.description" : sql = "SELECT projectID, projects.name, description, userID, users.name FROM projects JOIN users USING(userID) WHERE projects.description = ?;";
            break;
         case "users.name": sql = "SELECT projectID, projects.name, description, userID, users.name FROM projects JOIN users USING(userID) WHERE users.name = ?;";
            break;
      }
      ArrayList<ArrayList<String>> result = sqldb.getPreparedData(sql, value);
      result.remove(result.size() - 1);
      return result;
   }
   
   // INSERT method - takes in a user object to check their authorization, and a name and description to be inserted into the projects table, with the user
   // object providing the user ID and the table auto incrementing the project ID.
   public int insert(Users user, String _name, String _description)
   {
      if(user.getRole().equals("faculty"))
      {
         MySQLDatabase sqldb = new MySQLDatabase();
         String sql = "INSERT INTO projects (name, description, userID) VALUES (?, ?, '" + user.getUserID() + "');";
         int affectedRows = sqldb.setInsertPreparedData(sql, _name, _description);
         return affectedRows;
      }
      else
      {
         return -1;
      }
   }
   
   // UPDATE method - takes in a user object to check their authorization, and four strings.
   // updateValue - the new value to be placed on whatever field is chosen.
   // updateField - the field that the updateValue will be placed into.
   // whereValue - the value that the WHERE clause will check for.
   // whereField - the field that the WHERE clause will check on.
   // 
   // The method will first check to ensure that the user is a faculty member, and it will check each value in the list of projects
   // based on the WHERE clause to ensure that the user is not attempting to modify another user's entries, or else the
   // transaction will be rolled back. If all is well, the method will update 'updateField' to 'updateValue' where 'whereField' equals 'whereValue'
   public int update(Users user, String updateValue, String updateField, String whereValue, String whereField)
   {
      MySQLDatabase sqldb = new MySQLDatabase();
      
      if(user.getRole().equals("faculty"))
      {
         sqldb.startTrans();
         ArrayList<ArrayList<String>> outerList = this.select(whereValue, whereField);
         System.out.println("Outer List: " + outerList);
         for(ArrayList<String> innerList : outerList)
         {
            System.out.println("Value being checked - " + innerList.get(3));
            if(innerList.get(3).equals(user.getUserID()) == false)
            {
               sqldb.rollbackTrans();
               return -1;
            }
         }
         String sql = "UPDATE projects SET " + updateField + " = ? WHERE " + whereField + " = ?;";
         int affectedRows = sqldb.setUpdatePreparedData(sql, updateValue, whereValue);
         sqldb.endTrans();
         return affectedRows;
      }
      else
      {
         sqldb.rollbackTrans();
         return -1;
      }
   }
   
   // DELETE method - takes in a user object to check their authorization, and two strings.
   // deleteValue - the value that is being checked to be deleted on.
   // updateField - the field that is being checked to be deleted on.
   // 
   // The method will first check to ensure that the user is a faculty member, and it will check each value in the list of projects
   // based on the WHERE clause to ensure that the user is not attempting to delete another user's entries, or else the
   // transaction will be rolled back. If all is well, the method will delete all entries where 'deleteField equals 'deleteValue'
   public int delete(Users user, String deleteValue, String deleteField)
   {
      MySQLDatabase sqldb = new MySQLDatabase();
   
      if(user.getRole().equals("faculty"))
      {
         sqldb.startTrans();
         ArrayList<ArrayList<String>> outerList = this.select(deleteValue, deleteField);
         System.out.println("Outer List: " + outerList);
         
         for(ArrayList<String> innerList : outerList)
         {
            System.out.println("Value being checked - " + innerList.get(3));
            if(innerList.get(3).equals(user.getUserID()) == false)
            {
               sqldb.rollbackTrans();
               return -1;
            }
         }
         String sql = "DELETE FROM projects WHERE " + deleteField + " = ?;";
         int affectedRows = sqldb.setDeletePreparedData(sql, deleteValue);
         
         System.out.println("PROJECTS " + affectedRows);
         
         sqldb.endTrans();
         return affectedRows;
      }
      else
      {
         sqldb.rollbackTrans();
         return -1;
      }
   }   
   
   // Select all method
   // Used to select every single individual entry in the projects table, with the full name being grabbed from a JOIN to the users table
   public ArrayList<ArrayList<String>> selectAll()
   {
      MySQLDatabase sqldb = new MySQLDatabase();
      String sql = "SELECT projects.projectID, projects.name,projects.description, projects.userID, users.name FROM projects JOIN users using(userID);";
      ArrayList<ArrayList<String>> result = sqldb.getPreparedData(sql, "Select All");
      result.remove(result.size() - 1);
      return result;
   }
   
   // Select all Users method
   // Used to select every single individual entry in the users table
   public ArrayList<ArrayList<String>> selectAllUsers()
   {
      MySQLDatabase sqldb = new MySQLDatabase();
      String sql = "SELECT userID, name, email, role FROM users;";
      ArrayList<ArrayList<String>> result = sqldb.getPreparedData(sql, "Select All");
      result.remove(result.size() - 1);
      return result;
   }
   
   // Constructor that sets Project ID
   Projects(int _projectID) 
   { 
      projectID = _projectID;
   }
   
   // Constructor that sets all attributes
   Projects(int _projectID, String _name, String _description, String _userID)
   {
      projectID = _projectID;
      name = _name;
      description = _description;
      userID = _userID;
   }
   
   // Project ID Accessor
   public int getProjectID()
   {
      return projectID;
   }
   
   // Name Accessor
   public String getName()
   {
      return name;
   }
   
   // Description Accessor
   public String getDesc()
   {
      return description;
   }
   
   // User ID Accessor
   public String getUserID()
   {
      return userID;
   }
     
   // Project ID Mutator
   public void setProjectID(int _projectID)
   {
      projectID = _projectID;
   }
   
   // Name Mutator
   public void setName(String _name)
   {
      name = _name;
   }
   
   // Description Mutator
   public void setDesc(String _description)
   {
      description = _description;
   }
   
   // User ID Mutator
   public void setUserID(String _userID)
   {
      userID = _userID;
   }
      
   // Fetch method
   public ArrayList<ArrayList<String>> fetch()
   {
      MySQLDatabase sqldb = new MySQLDatabase();
      String sql = "SELECT * FROM projects WHERE projectID = " + projectID + ";";
            
      ArrayList<ArrayList<String>> result = sqldb.getData(sql);
      try
      {
         for (int i=1; i<=4; i++) {
            String value = result.get(0).get(i-1);
            if(i-1 == 1)
            {
               name = value;
            }
            else if(i-1 == 2)
            {
               description = value;
            }
            else if(i-1 == 3)
            {
               userID = value;
            }
         }
      }
      catch(IndexOutOfBoundsException ioobe)
      {
         try
         {
            String msg = "IndexOutOfBoundsException in Projects.fetch()";
            throw new DLException(ioobe, msg, "SQL - " + sql);
         }
         catch(DLException dl)
         {
            ioobe.printStackTrace();
         }
      }
      return result;
   }
   
   // Put method
   public int put()
   {
      MySQLDatabase sqldb = new MySQLDatabase();
      String sql = "UPDATE projects SET name = '" + name + "', description = '" + description + "', userID = '" + userID + "' WHERE projectID = " + projectID + ";";
      int affectedRows = sqldb.setData(sql);
      return affectedRows;
   }
   
   // Post method
   public int post()
   {
      MySQLDatabase sqldb = new MySQLDatabase();
      String sql = "INSERT INTO projects VALUES (" + projectID + ", '" + name + "', '" + description + "', '" + userID + "');";
      int affectedRows = sqldb.setData(sql);
      return affectedRows;
   }
   
   // Delete This method
   public int deleteThis()
   {
      MySQLDatabase sqldb = new MySQLDatabase();
      String sql = "DELETE FROM projects WHERE projectID = " + projectID + ";";
      int affectedRows = sqldb.setData(sql);
      return affectedRows;
   }   
   

}