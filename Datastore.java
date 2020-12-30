import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.IOException;  
public class Datastore  
{ 

	private static FileWriter filewriter;
	public void create()
	{
		
		File file = new File("d:/jsonfile.txt"); 
		boolean result;
		try   
		{  
		result = file.createNewFile();  
		if(result)       
		{  
		System.out.println("file created successfully"); 
		}  
		else  
		{  
		System.out.println("File already exist ");  
		}  
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();     
		}         
	}
	public void read()
	{
		JSONParser parser = new JSONParser();
		Scanner s=new Scanner(System.in);
		System.out.print("Enter key to get a value");
		String a=s.next();
		try {
			s=new Scanner(new FileReader("d:/jsonfile.txt"));
			while(s.hasNext())
			{
				String inline=s.nextLine();
				Object obj=parser.parse(inline);
				JSONObject jsonObject = (JSONObject) obj;
			    String value=(String)jsonObject.get(a);
			    System.out.println(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		
	}
	}
	public void write()
	{
		System.out.println("Enter key and value to be added");
	     Scanner s=new Scanner(System.in);
         String key=s.next();
         String value=s.next();
         JSONObject obj = new JSONObject();
         obj.put(key,value);
         try {
           filewriter = new FileWriter("d:/jsonfile.txt",true);
            filewriter.write(obj.toJSONString());
            filewriter.append('\n');
            System.out.print("Given key-value pair is successfully added in the file");
            
                  } 
         catch (IOException e) {
            e.printStackTrace();
 
        } finally {
 
            try {
                filewriter.flush();
                filewriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
public void delete()
{
	try  
	{         
	File f= new File("d:\\jsonfile.txt");             
	if(f.delete())                      
	{  
	System.out.println("Successfully deleted");   
	}  
	else  
	{  
	System.out.println("Unable to delete");  
	}  
	}  
	catch(Exception e)  
	{  
	e.printStackTrace();  
	}  
	}  

public static void main(String[] args)   
{  
	File file=new File("d://jsonfile.txt");
	long filesize=file.length();
    Main obj=new Main();
    System.out.println("Enter create,write,read or  to delete the file");
	Scanner s=new Scanner(System.in);
	String a=s.next();
	if(a.equals("create"))
		obj.create();
	else if(a.equals("read"))
		obj.read();
	else if(a.equals("write"))
	{
		if(file.length()>=1000)
		{
			System.out.print("File size limit is exceeded");	
		}
		else
			obj.write();	
	}
		
	else if(a.equals("delete"))
		obj.delete();
	else
		System.out.print("You have entered Wrong value");
		
}  
} 