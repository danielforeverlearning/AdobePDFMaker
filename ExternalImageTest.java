import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class ExternalImageTest {

     public ExternalImageTest()
     {
		  ListPDFObjects mylist = new ListPDFObjects();

		  //1 Catalog
		  mylist.add(false,
				 "<</Type /Catalog /Pages 2 0 R>>");

		  //2 Page-Tree-Node
		  mylist.add(false,
				 "<</Type /Pages /Kids [3 0 R 7 0 R 8 0 R] /Count 3>>");

		  //3 Page1-leaf-node
		  mylist.add(false,
				 "<</Type /Page /Parent 2 0 R /Resources 4 0 R /MediaBox [0 0 612 792] /Contents 6 0 R>>");

		  //4
		  mylist.add(false,
"<< /ProcSet [ /PDF/Text/ImageC/ImageI/ImageB ] /XObject << /Im1 5 0 R >>>>");

/**************************
16 0 obj% Alternate image
<< /Type /XObject
/Subtype /Image
/Width 1000
/Height 2000
/ColorSpace /DeviceRGB
/BitsPerComponent 8
/Length 0% This is an external stream
/F << /FS /URL
/F ( http : / / www . myserver . mycorp . com / images / exttest . jpg )
>>
/FFilter /DCTDecode
>>
stream
endstream
endobj
*****************************/
//https://media.istockphoto.com/id/612522882/photo/slice-of-cherry-pie-on-a-white-textile-background.jpg?s=612x612&w=0&k=20&c=0scN3g68GkdnMONmKZXfVH1JzmZ_Eq4959EEoRJJk9g=
//https://media.istockphoto.com/id/612522882/photo/slice-of-cherry-pie-on-a-white-textile-background.jpg?s=612x612&w=0&k=20&c=0scN3g68GkdnMONmKZXfVH1JzmZ_Eq4959EEoRJJk9g=
//https://www.w3schools.com/images/lynx_in_space.png
//https://www.w3schools.com/images/lynx_in_space.png
//https://jpeg.org/images/jpeg2000-home.jpg
//https://jpeg.org/images/jpeg2000-home.jpg
 
		  //5
		  PDFObject myobj = mylist.addStreamObjectAndPrestream( 
"<< /Type /XObject /Subtype /Image /Width 800 /Height 400 /ColorSpace /DeviceRGB /BitsPerComponent 8 /Length 0 " +
"/F << /FS /URL /F ( https://jpeg.org/images/jpeg2000-home.jpg )>> " +
"/FFilter /DCTDecode >>");

		  //6
		  mylist.add(true,
				 "q 1 0 0 1 0 0 cm /Im1 Do Q");
				 
	      //7 Page2-tree-node
	      mylist.add(false,
					 "<</Type /Page /Parent 2 0 R /Resources 9 0 R /MediaBox [0 0 612 792] /Contents 11 0 R>>");
				 
	      //8 Page3-tree-node
	      mylist.add(false,
					 "<</Type /Page /Parent 2 0 R /Resources 9 0 R /MediaBox [0 0 612 792] /Contents 12 0 R>>");
				 
	      //9 font
		  mylist.add(false,
				 "<</Font <</F1 10 0 R>>>>");



		  //10
		  mylist.add(false,
"<</Type /Font /Subtype /Type1 /BaseFont /Helvetica-Oblique>>");


		  /*********************
		  Page2 contents
		  11 0 obj
		  <</Length 49>>
		  stream
		  BT /F1 20 Tf 36 756 Td (hi this is page 1)Tj ET
		  *********************/
		  PDFObject page2obj = mylist.add(true, "");
		  String page2str = String.format("BT /F%d %d Tf %d %d Td (%s)Tj ET\n", 1, 20, 36, 756, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLM");
		  page2obj.AppendStr(page2str);
		  
		  //12 page3 contents
		  PDFObject page3obj = mylist.add(true,"");
		  String page3str = String.format("BT /F%d %d Tf %d %d Td (%s)Tj ET\n", 1, 20, 36, 756, "Genghis Khan Famouse people names");
		  page3obj.AppendStr(page3str);
				 

		  mylist.WriteToFile();
     }

}


