import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class AdobePDFMaker {

     public static void main(String[] args)
     {
          System.out.println("Please enter a menu-choice just the number and then enter:");
          System.out.println("0. Exit");
          System.out.println("1. Color-image output.pdf");
		  System.out.println("2. External-image output.pdf");
          System.out.println("3. Courier old-fashioned typewriter output.pdf");

          Scanner scan = new Scanner(System.in);
          String choice = scan.nextLine();
          choice = choice.trim();

          if (choice.compareTo("1") == 0)
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
                     "<</XObject <</Im1 5 0 R>>>>");

              //5
              PDFObject myobj = mylist.addStreamObjectAndPrestream(
"<</Type /XObject /Subtype /Image /Width 16 /Height 16 /ColorSpace /DeviceRGB /BitsPerComponent 8 /Filter /ASCIIHexDecode ");

              String colorbytes = "";
              colorbytes += "0800000C00000F0000000800000C00000F0000000800000C00000F000808000C0C000F0F0808000C0C000800080C000C";
              colorbytes += "1800001C00001F0000001800001C00001F0000001800001C00001F001818001C1C001F1F1818001C1C001800181C001C";
              colorbytes += "2800002C00002F0000002800002C00002F0000002800002C00002F002828002C2C002F2F2828002C2C002800282C002C";
              colorbytes += "3800003C00003F0000003800003C00003F0000003800003C00003F003838003C3C003F3F3838003C3C003800383C003C";
              colorbytes += "4800004C00004F0000004800004C00004F0000004800004C00004F004848004C4C004F4F4848004C4C004800484C004C";
              colorbytes += "5800005C00005F0000005800005C00005F0000005800005C00005F005858005C5C005F5F5858005C5C005800585C005C";
              colorbytes += "6800006C00006F0000006800006C00006F0000006800006C00006F006868006C6C006F6F6868006C6C006800686C006C";
              colorbytes += "7800007C00007F0000007800007C00007F0000007800007C00007F007878007C7C007F7F7878007C7C007800787C007C";
              colorbytes += "8800008C00008F0000008800008C00008F0000008800008C00008F008888008C8C008F8F8888008C8C008800888C008C";
              colorbytes += "9800009C00009F0000009800009C00009F0000009800009C00009F009898009C9C009F9F9898009C9C009800989C009C";
              colorbytes += "A80000AC0000AF000000A80000AC0000AF000000A80000AC0000AF00A8A800ACAC00AFAFA8A800ACAC00A800A8AC00AC";
              colorbytes += "B80000BC0000BF000000B80000BC0000BF000000B80000BC0000BF00B8B800BCBC00BFBFB8B800BCBC00B800B8BC00BC";
              colorbytes += "C80000CC0000CF000000C80000CC0000CF000000C80000CC0000CF00C8C800CCCC00CFCFC8C800CCCC00C800C8CC00CC";
              colorbytes += "D80000DC0000DF000000D80000DC0000DF000000D80000DC0000DF00D8D800DCDC00DFDFD8D800DCDC00D800D8DC00DC";
              colorbytes += "E80000EC0000EF000000E80000EC0000EF000000E80000EC0000EF00E8E800ECEC00EFEFE8E800ECEC00E800E8EC00EC";
              colorbytes += "F80000FC0000FF000000F80000FC0000FF000000F80000FC0000FF00F8F800FCFC00FFFFF8F800FCFC00F800F8FC00FC";

              myobj.AppendStr(colorbytes);

              //6
              mylist.add(true,
                     "q 99 0 0 99 360 72 cm /Im1 Do Q");
					 
	      //7 Page2-tree-node
	      mylist.add(false,
                         "<</Type /Page /Parent 2 0 R /Resources 9 0 R /MediaBox [0 0 612 792] /Contents 11 0 R>>");
					 
	      //8 Page3-tree-node
	      mylist.add(false,
                         "<</Type /Page /Parent 2 0 R /Resources 9 0 R /MediaBox [0 0 612 792] /Contents 12 0 R>>");
					 
	      //9 font
              mylist.add(false,
                     "<</Font <</F1 10 0 R>>>>");


              //Caladea
              //Serif
              //Times-Roman
              



              //Helvetica is a proportional-width font
              //mylist.add(false,
              //          "<</Type /Font /Subtype /Type1 /BaseFont /Helvetica>>");

              //https://ctan.org/topic/font-type1?lang=en

              //Courier is a fixed-width font
              //mylist.add(false,
              //       "<</Type /Font /Subtype /Type1 /BaseFont /Times-Roman>>");
					 
              //mylist.add(false,
              //       "<</Type /Font /Subtype /TrueType /BaseFont /Arial>>");
			  

/*************************************************************************
7 0 obj
<<
/Type /Font
/Subtype /TrueType
/BaseFont /Arial
/FirstChar 32
/LastChar 32
/Widths [500]
/FontDescriptor 8 0 R
/Encoding 9 0 R
>>
endobj
8 0 obj
<<
/Type /FontDescriptor
/FontName /Arial
/FontFamily (Arial)
/Flags 32
/FontBBox [-665.0 -325.0 2000.0 1040.0]
/ItalicAngle 0
/Ascent 1040
/Descent -325
/CapHeight 716
/StemV 88
/XHeight 519
>>
endobj
9 0 obj
<<
/Type /Encoding
/BaseEncoding /WinAnsiEncoding
/Differences [32 /uniAB55]
>>
endobj
********************************************************/

/*****

              //10
			  //SegoeScript worked but said bad bbox
              mylist.add(false,
"<</Type /Font /Subtype /TrueType /BaseFont /Arial /FirstChar 32 /LastChar 32 /Widths [500] /FontDescriptor 11 0 R /Encoding 12 0 R>>");

              //11
			  mylist.add(false,
"<</Type /FontDescriptor /FontName /Arial /FontFamily (Arial) /Flags 32 /FontBBox [-665.0 -325.0 2000.0 1040.0] /ItalicAngle 0 /Ascent 1040 /Descent -325 /CapHeight 716 /StemV 88 /XHeight 519>>");

              //12
			  mylist.add(false,
"<</Type /Encoding /BaseEncoding /WinAnsiEncoding>>");
*****/

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
	          String page2str = String.format("BT /F%d %d Tf %d %d Td (%s)Tj ET\n", 1, 20, 36, 756, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
              page2obj.AppendStr(page2str);
			  
	          //12 page3 contents
	          PDFObject page3obj = mylist.add(true,"");
	          String page3str = String.format("BT /F%d %d Tf %d %d Td (%s)Tj ET\n", 1, 20, 36, 756, "Genghis Khan Famouse people names");
	          page3obj.AppendStr(page3str);
					 

              mylist.WriteToFile();
          }
		  else if (choice.compareTo("2") == 0) {
			  ExternalImageTest test = new ExternalImageTest();
		  }
          else if (choice.compareTo("3") == 0) {
              CourierTypewriter mytypewriter = new CourierTypewriter();
          }

          System.out.println("DONE");
     }

}


