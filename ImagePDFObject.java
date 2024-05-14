import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class ImagePDFObject extends PDFObject {
	
	private ArrayList<String> ColorByteStringArray;

    public ImagePDFObject(int objnum, String prestreamstr)
    {
         super(objnum, prestreamstr);
		 ColorByteStringArray = new ArrayList<String>();
    }

    public void AddColorByteString(String colorbytestr)
	{
		 ColorByteStringArray.add(colorbytestr);
	}
	
	public int GetTotalColorByteLength()
	{
		int total = 0;
		for (int ii=0; ii < ColorByteStringArray.size(); ii++)
			total += ColorByteStringArray.get(ii).length();
		
		return total;
	}
	
	public void WriteColorBytes(FileWriter mywriter)
	{
		try {
			 for (int ii=0; ii < ColorByteStringArray.size(); ii++)
				 mywriter.write(ColorByteStringArray.get(ii));
			 
			 mywriter.write("\n");
        }
        catch (Exception ex) {
             System.out.println("WriteColorBytes: Exception caught");
             ex.printStackTrace();
        }
	}

}//class


