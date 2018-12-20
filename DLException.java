import java.util.*;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

// DLException class, extracted from one of the Practice Exercises
public class DLException extends Exception
{

   private Exception e;
   private String[] values = null;

   public DLException(Exception _e)
   {
      e = _e;
      this.writeLog();
   }
   
   public DLException(Exception _e, String msg, String... _values)
   {
      super(msg);
      e = _e;
      values = _values;
      this.writeLog();
   }
   
   public void writeLog()
   {
      try
      {
         Logger logger = Logger.getLogger("MyLog");  
         FileHandler fh;  
         fh = new FileHandler("LogFile.log", true);  
         logger.addHandler(fh);
         SimpleFormatter formatter = new SimpleFormatter();  
         fh.setFormatter(formatter);  
         logger.info(e.toString());
         logger.info(super.getMessage());
         for(String value : values)
         {
            logger.info(value);
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
}