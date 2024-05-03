import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class CourierTypewriter {

     private int font_size; //10,12,14,20
	 
	 private int line_char_limit_fontsize10;
	 private int line_char_limit_fontsize12;
	 private int line_char_limit_fontsize14;
	 private int line_char_limit_fontsize20;
	 
	 private int line_YY_space_fontsize10;
	 private int line_YY_space_fontsize12;
	 private int line_YY_space_fontsize14;
	 private int line_YY_space_fontsize20;
	 
	 private int XX;
     private int YY;

     //Unit is 72 == 1 inch, i do not remember how to change the unit-size
     //So if you want 0.5 inch margins at fontsize12 then
     //left-side-x value is 36
     //top-side-y value is 756
     //10 Courier characters at fontsize12 make 1 inch which means
     //width of 1 Courier-character at fontsize12 == 7.2 units
	 
     //Helvetica is a proportional-width font
     //Courier is a fixed-width font

     public CourierTypewriter()
     {
		  font_size                  = 20;
		  
		  line_char_limit_fontsize20 = 45; //51chars per line,    12 units == character-width
		  line_char_limit_fontsize14 = 65; //73chars per line,    8.3835616438356164383561643835616 units == character-width
          line_char_limit_fontsize12 = 75; //80chars per line,    7.2 units == character-width
		  line_char_limit_fontsize10 = 90;
		  
		  line_YY_space_fontsize10   = 10;
		  line_YY_space_fontsize12   = 12;
		  line_YY_space_fontsize14   = 14;
		  line_YY_space_fontsize20   = 20;
		  
		  XX                         = 36;
		  //XX=0;
		  YY                         = 756;
          

          ListPDFObjects mylist = new ListPDFObjects();

          //1
          mylist.add(false,
                     "<</Type /Catalog /Pages 2 0 R>>");

          //2
          mylist.add(false,
                     "<</Type /Pages /Kids [3 0 R] /Count 1>>");

          //3
          mylist.add(false,
                     "<</Type /Page /Parent 2 0 R /Resources 4 0 R /MediaBox [0 0 612 792] /Contents 6 0 R>>");

          //4
          mylist.add(false,
                     "<</Font <</F1 5 0 R>>>>");

          //5
          //Helvetica is a proportional-width font
          //mylist.add(false,
          //          "<</Type /Font /Subtype /Type1 /BaseFont /Helvetica>>");

          //Courier is a fixed-width font
          mylist.add(false,
                     "<</Type /Font /Subtype /Type1 /BaseFont /Courier>>");
         

          //6
          PDFObject myobj = mylist.add(true, "");

          System.out.println("Just start typing anything this acts like an old typewriter, for now only 1 page,");
		  System.out.println("every time you press-ENTER-key it forces a new line and carriage-return,");
		  System.out.println("to stop just make sure on 1 brand new line you press the *-key and then enter,");
		  System.out.println("to change to fontsize20 make sure on 1 brand new line you press the number-1-key and then enter,");
		  System.out.println("to change to fontsize12 make sure on 1 brand new line you press the number-3-key and then enter.");
		  System.out.println("ok please start typing:");

          Scanner scan = new Scanner(System.in);

          while (true)
          {
               String myline = scan.nextLine();
               int mylen = myline.length();
			   //System.out.println(String.format("length=%d\n",mylen));
               if (mylen == 1) {
                    char mychar = myline.charAt(0);
                    if ((int)mychar == 42) //ESC-key is 0x27 for ubuntu-linux, does not work on windows nor does ctrl-keys show up on windows line so using * key which is 0x2A
                         break;
					else if ((int)mychar == 49) { //number-1-key == 0x31
						 System.out.println("changing font_size to 20\n");
						 font_size = 20;
					}
					else if ((int)mychar == 50) { //number-2-key == 0x32
						 System.out.println("changing font_size to 14\n");
						 font_size = 14;
					}
					else if ((int)mychar == 51) { //number-3-key == 0x33
					     System.out.println("changing font_size to 12\n");
						 font_size = 12;
					}
					else if ((int)mychar == 52) { //number-4-key == 0x34
					     System.out.println("changing font_size to 10\n");
						 font_size = 10;
					}
                    else {
						 //System.out.println(String.format("length is 1, int value of mychar is %d\n", (int)mychar));
                         ProcessLine(myline, myobj, 1, font_size);
					}
               }
               else
                    ProcessLine(myline, myobj, 1, font_size);
          }

          mylist.WriteToFile();
     }


     private void ProcessLine(String myline, PDFObject myobj, int fontnum, int fontsize)
     {
          String addstr;
          String tempstr = myline;
		  int line_char_limit = 666;
		  int line_YY_space = 0;
		  
		  if (font_size == 10) {
			  line_char_limit = line_char_limit_fontsize10;
			  line_YY_space = line_YY_space_fontsize10;
		  }
		  else if (font_size == 12) {
			  line_char_limit = line_char_limit_fontsize12;
			  line_YY_space = line_YY_space_fontsize12;
		  }
		  else if (font_size == 14) {
			  line_char_limit = line_char_limit_fontsize14;
			  line_YY_space = line_YY_space_fontsize14;
		  }
		  else if (font_size == 20) {
			  line_char_limit = line_char_limit_fontsize20;
			  line_YY_space = line_YY_space_fontsize20;
		  }
		  
          while (tempstr.length() >= line_char_limit)
          {
               String appendstr = tempstr.substring(0, line_char_limit);
               tempstr = tempstr.substring(line_char_limit);

               addstr = String.format("BT /F%d %d Tf %d %d Td (%s)Tj ET\n", fontnum, fontsize, XX, YY, appendstr);
               YY -= line_YY_space;
          
               myobj.AppendStr(addstr);
          }
          addstr = String.format("BT /F%d %d Tf %d %d Td (%s)Tj ET\n", fontnum, fontsize, XX, YY, tempstr);
          YY -= line_YY_space;
          myobj.AppendStr(addstr);
     }

}//class


