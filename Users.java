import java.sql.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

// Data Layer class to represent a row in the users table - Written by Kevin Voltz
public class Users{

   // User attributes
   private String userID;
   private String password;
   private String name;
   private String title;
   private String interestArea;
   private String office;
   private String phone;
   private String email;
   private String role;
      
   // Default Constructor
   Users()
   {
   }
   
   // Constructor that sets User ID
   Users(String _userID) 
   { 
      userID = _userID;
   }
   
   // Constructor that sets all attributes
   Users(String _userID, String _password, String _name, String _title, String _interestArea, String _office, String _phone, String _email, String _role)
   {
      userID = _userID;
      password = _password;
      name = _name;
      title = _title;
      interestArea = _interestArea;
      office = _office;
      phone = _phone;
      email = _email;
      role = _role;
   }
   
   // User ID Accessor
   public String getUserID()
   {
      return userID;
   }
   
   // Password Accessor
   public String getPassword()
   {
      return password;
   }
   
   // Name Accessor
   public String getName()
   {
      return name;
   }
   
   // Title Accessor
   public String getTitle()
   {
      return title;
   }
   
   // Interest Area Accessor
   public String getInterestArea()
   {
      return interestArea;
   }
   
   // Office Accessor
   public String getOffice()
   {
      return office;
   }
   
   // Phone Accessor
   public String getPhone()
   {
      return phone;
   }
   
   // Email Accessor
   public String getEmail()
   {
      return email;
   }
   
   // Role Accessor
   public String getRole()
   {
      return role;
   }
   
   
   // User ID Mutator
   public void setUserID(String _userID)
   {
      userID = _userID;
   }
   
   // Password Mutator
   public void setPassword(String _password)
   {
      password = _password;
   }
   
   // Name Mutator
   public void setName(String _name)
   {
      name = _name;
   }
   
   // Title Mutator
   public void setTitle(String _title)
   {
      title = _title;
   }
   
   // Interest Area Mutator
   public void setInterestArea(String _interestArea)
   {
      interestArea = _interestArea;
   }
   
   // Office Mutator
   public void setOffice(String _office)
   {
      office = _office;
   }
   
   // Phone Mutator
   public void setPhone(String _phone)
   {
      phone = _phone;
   }
   
   // Email Mutator
   public void setEmail(String _email)
   {
      email = _email;
   }
   
   // Role Mutator
   public void setRole(String _role)
   {
      role = _role;
   }
   
   // Login Method - Hashes given password and compares this hashed password
   // to the one stored in the database, as well as the username, returning
   // true if they match up and false otherwise.
   public boolean login(String _userID, String _password)
   {
      try
      {
         this.fetch();
         MessageDigest md = MessageDigest.getInstance("SHA-256");
         String text = _password;
         md.update(text.getBytes(StandardCharsets.UTF_8));
         byte[] digest = md.digest();
         String hashedPassword = String.format("%064x", new BigInteger(1, digest));
         if(password.equals(hashedPassword) && _userID.equals(userID))
         {
            return true;
         }
         else
         {
            return false;
         }
      }
      catch(NoSuchAlgorithmException nsae)
      {
         try
         {
            String msg = "NoSuchAlgorithmException in Users.login()";
            throw new DLException(nsae, msg);
         }
         catch(DLException dl)
         {
            nsae.printStackTrace();
            return false;
         }
      }
   }
   
   // Fetch method
   public ArrayList<ArrayList<String>> fetch()
   {
      MySQLDatabase sqldb = new MySQLDatabase();
      String sql = "SELECT * FROM users WHERE userID = '" + userID + "';";
            
      ArrayList<ArrayList<String>> result = sqldb.getData(sql);
      try
      {
         for (int i=1; i<=9; i++) {
            String value = result.get(0).get(i-1);
            if(i-1 == 1)
            {
               password = value;
            }
            else if(i-1 == 2)
            {
               name = value;
            }
            else if(i-1 == 3)
            {
               title = value;
            }
            else if(i-1 == 4)
            {
               interestArea = value;            
            }
            else if(i-1 == 5)
            {
               office = value;            
            }
            else if(i-1 == 6)
            {
               phone = value;           
            }
            else if(i-1 == 7)
            {
               email = value;           
            }
            else if(i-1 == 8)
            {
               role = value;      
            }
         }
      }
      catch(IndexOutOfBoundsException ioobe)
      {
         try
         {
            String msg = "IndexOutOfBoundsException in Users.fetch()";
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
      String sql = "UPDATE users SET password = SHA2('" + password + "', 256), name = '" + name + "', title = '" + title + "', interestArea = '" + interestArea + "', office = '" + office + "', phone = '" + phone + "', email = '" + email + "', role = '" + role + "' WHERE equipID = " + userID +";";
      int affectedRows = sqldb.setData(sql);
      return affectedRows;
   }
   
   // Post method
   public int post()
   {
      MySQLDatabase sqldb = new MySQLDatabase();
      String sql = "INSERT INTO users VALUES ('" + userID + "', SHA2('" + password + "', 256), '" + name + "', '" + title + "', '" + interestArea + "', '" + office + "', '" + phone + "', '" + email + "', '" + role + "');";
      int affectedRows = sqldb.setData(sql);
      return affectedRows;
   }
   
   // Delete method
   public int delete()
   {
      MySQLDatabase sqldb = new MySQLDatabase();
      String sql = "DELETE FROM users WHERE userID = '" + userID + "';";
      int affectedRows = sqldb.setData(sql);
      return affectedRows;
   }   
   

}