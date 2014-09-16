
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
public class Data {



	  @SuppressWarnings("deprecation")
	public static Vector<String> read_data(String path) {

          Vector<String> lines = new Vector<String>();
          try {
              File fileDir = new File(path);

              BufferedReader in = new BufferedReader(
                      new InputStreamReader(
                              new FileInputStream(fileDir), "UTF8"));

              String str;

              while ((str = in.readLine()) != null) {
                  lines.add(str);
              }

              in.close();
          }
          catch (UnsupportedEncodingException e)
          {
              System.out.println(e.getMessage());
          }
          catch (IOException e)
          {
              System.out.println(e.getMessage());
          }
          catch (Exception e)
          {
              System.out.println(e.getMessage());
          }
          return lines;
      }

	}
