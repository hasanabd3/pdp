package odev;

//import java.net.URL;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipInputStream;

public class git {
	
	 public static void main(String[] args) {
		  String URL_link=kullanicidan_link_al();
		  URL_klonla(URL_link);
	 }
	 
	 public static String  kullanicidan_link_al_deneme() {
		  System.out.println("GitHub depo linkini ( repository URL'sini) girin:");
		  BufferedReader link_oku=new BufferedReader(new InputStreamReader(System.in));
		  String URL_link = null;
		  try {
			   URL_link=link_oku.readLine();
		  }
		  catch ( IOException e) {
			   e.printStackTrace();
		  }
		  return URL_link;
	 }
	 
	 public static String kullanicidan_link_al(){
		    BufferedReader link_oku = new BufferedReader(new InputStreamReader(System.in));
		    String Url_link = null;
		    Pattern pattern = Pattern.compile("https://github.com/[a-zA-Z0-9_-]+/[a-zA-Z0-9_-[.]]+");
		         try
		         {
		            System.out.println("GitHub depo linkini ( repository URL'sini) girin:");
		            Url_link = link_oku.readLine();
		            Matcher matcher = pattern.matcher(Url_link);
		            if (Url_link == null || Url_link.trim().isEmpty()||!matcher.matches())
		            {
			             do 
			             {
			               System.out.println("Gecersiz URL. Lutfen tekrar girin.");
			                     Url_link = link_oku.readLine();
			             } while (Url_link == null || Url_link.trim().isEmpty()||!matcher.matches());
			        }
		            else 
		            {
		            	System.out.println("dogru");
		            }
		         }
		         catch (IOException e)
		         {
		             e.printStackTrace();
		         } 
		         return Url_link;
		}
	 
	 private static void URL_klonla(String URL_link)
	 {
		  try 
		  {
		    ProcessBuilder builder = new ProcessBuilder("git", "clone", URL_link);
		    builder.inheritIO();
		    Process process = builder.start();
		    process.waitFor();
		    System.out.println("URL klonlandi .");
		  }
		  catch (IOException | InterruptedException e) {
			  e.printStackTrace();
		  }
	 }
}