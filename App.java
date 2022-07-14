/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import javax.swing.*;
import java.awt.event.*;  
import net.sourceforge.tess4j.*;
import java.io.*;
public class App {
 static  String str;
static  JTextField tf1;
static JButton b;
static JTextArea area;
   
   public static void main ( String[] args)
   {
        JFrame frame=new JFrame();
          tf1=new JTextField();  
        tf1.setBounds(50,50,150,20); 
        tf1.setToolTipText("Search here");
        str=tf1.getText();
       b=new JButton("ok");//creating instance of JButton  
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
          b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               action();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }});
          area=new JTextArea();
           area.setBounds(0,200,400,200);  
          
       frame.add(tf1);//adding textfield in JFrame     
    frame.add(b);//adding button in JFrame 
    frame.add(area);//adding textarea in JFrame
    frame.setSize(400,500);//400 width and 500 height  
    
     frame.setLayout(null);//using no layout managers  
    frame.setVisible(true); //making the frame visible
      
       
}

   public static void action()
   {
   
     
      File location=new File("C:\\Users\\user\\Documents\\demo2\\");
              //the folder in your pc is to be given here
      //System.out.println("Enter the name to be searched");
      //the name which you want to search here
     // String str=sc.next();
      int c=0;
      // a counter variable to be used when file is not found
              for(File f:location.listFiles())
              {
                  if(f.exists())
                  {
             String s=getImgText(f.getPath());
             if(s.toLowerCase().contains(str.toLowerCase()))
                 //making the entire text to lower case and checking for the desired one
             {
                   // System.out.println(f.getName());
                    //print the name of the file if found
                    area.setText(f.getName());
                    c++;
                   
                   
              }
           
                  }
                
                  
                }
                System.exit(0);
              if(c==0)
              {
                  area.setText("not found");
               System.exit(0);
              }
             
                  
                  //System.out.println("not found");
              //if no file is found print not found
              
           
   }
   


 public static String getImgText(String imageLocation) {
      ITesseract instance = new Tesseract();
      try 
      {
          instance.setDatapath("E:/Tess4J/tessdata"); 
          
			// the path of your tess data folder 
			// inside the extracted file 
         String imgText = instance.doOCR(new File(imageLocation));
         return imgText;
      } 
      catch (TesseractException e) 
      {
         e.getMessage();
         return "Error while reading image";
      }
     
   }

}


