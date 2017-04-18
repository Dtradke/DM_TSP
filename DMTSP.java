//David Radke
//GUI for DM_TSP
//March 14, 2017

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import javafx.embed.swing.JFXPanel;
import java.awt.Color;

import java.awt.*;
import java.net.URL;


public class DMTSP extends JFrame implements ActionListener
{
   //declare everything
   JPanel myPanel;
   JButton city1;
   JButton city2;
   JButton city3;
   JButton city4;
   JButton city5;
   JButton city6;
   JButton city7;
   JButton city8;
   JButton city9;
   JButton city10;
   JButton city11;
   JButton city12; 
   JButton exit;
   JTextField myText;
   JTextField myText1;
   JTextArea textArea;
   JTextArea textArea1;
   JTextArea textArea2;
   JTextArea textArea3;
   JTextArea textArea4;
   JLabel start;
   JLabel myLabel;
   JLabel myLabel2;
   JLabel myLabel3;
   JLabel myLabel4;
   JLabel myLabel5;
   JLabel myLabel6;
   JLabel line;
   
   int[][] matrix;
   int[] best;
   int inCost = 0;
   int min = 10000;
   int a, b = 0;
   String aa, bb, cc, dd, ee, ff, gg, hh, ii, jj, kk, ll = "";

   
   public DMTSP()
   {
      setSize(620,450);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      myPanel = new JPanel(); 
      
      start = new JLabel("Welcome traveling salesperson! Please select a city to start at: "); //creates a label
      start.setBounds(10,30,500,20);
      
      city1 = new JButton("San Francisco"); //creates a button
      city1.addActionListener(this); 
      city1.setBounds(10,50,100,40);
      
      city2 = new JButton("New York"); //creates a button
      city2.addActionListener(this); 
      city2.setBounds(110,50,100,40);
      
      city3 = new JButton("Denver"); //creates a button
      city3.addActionListener(this); 
      city3.setBounds(210,50,100,40);
      
      city4 = new JButton("Rio de Janeiro"); //creates a button
      city4.addActionListener(this); 
      city4.setBounds(310,50,100,40);
      
      city5 = new JButton("Dallas"); //creates a button
      city5.addActionListener(this); 
      city5.setBounds(410,50,100,40);
      
      city6 = new JButton("Miami"); //creates a button
      city6.addActionListener(this); 
      city6.setBounds(510,50,100,40);
      
      city7 = new JButton("London"); //creates a button
      city7.addActionListener(this); 
      city7.setBounds(10,90,100,40);
      
      city8 = new JButton("Berlin"); //creates a button
      city8.addActionListener(this); 
      city8.setBounds(110,90,100,40);
      
      city9 = new JButton("Beijing"); //creates a button
      city9.addActionListener(this); 
      city9.setBounds(210,90,100,40);
      
      city10 = new JButton("Sydney"); //creates a button
      city10.addActionListener(this); 
      city10.setBounds(310,90,100,40);
      
      city11 = new JButton("Cape Town"); //creates a button
      city11.addActionListener(this); 
      city11.setBounds(410,90,100,40);
      
      city12 = new JButton("Tel Aviv"); //creates a button
      city12.addActionListener(this); 
      city12.setBounds(510,90,100,40);
      
      exit = new JButton("BOOK TRIP"); //creates a button
      exit.addActionListener(this); 
      exit.setBounds(400,300,150,40);
      
      myLabel5 = new JLabel("Number of Cities: "); //creates a label
      myLabel5.setBounds(20,130,250,20);
      
      textArea3 = new JTextArea();
      textArea3.setBounds(20, 150, 150, 20);
      
      myLabel2 = new JLabel("Path of least cost: "); //creates a label
      myLabel2.setBounds(20,170,450,20);
      
      textArea = new JTextArea();
      textArea.setBounds(20, 190, 150, 210);
      
      textArea1 = new JTextArea();
      textArea1.setBounds(200, 150, 150, 20);
      
      myLabel3 = new JLabel("Cost:"); //creates a label
      myLabel3.setBounds(200,130,250,20);
      
      textArea2 = new JTextArea();
      textArea2.setBounds(200, 190, 150, 20);
      
      myLabel4 = new JLabel("Time Elapsed:"); //creates a label
      myLabel4.setBounds(200,170,250,20);
      
      myLabel6 = new JLabel("Total Possible Routes: "); //creates a label
      myLabel6.setBounds(200,210,250,20);
      
      textArea4 = new JTextArea();
      textArea4.setBounds(200, 230, 150, 20);
      
      myLabel = new JLabel("TRAVELING SALESPERSON PROBLEM - DELTA AIRLINES"); //creates a label
      myLabel.setFont(new Font("Serif", Font.PLAIN, 20));
      myLabel.setBounds(40,10,620,20);
      
      line = new JLabel("____________________________________________________________"); //creates a label
      line.setFont(new Font("Serif", Font.PLAIN, 20));
      line.setBounds(10,13,610,20);

      
      myPanel.setLayout(null); 
      myPanel.add(myLabel); //adds everything to the panel
      myPanel.add(myLabel2);
      myPanel.add(myLabel3);
      myPanel.add(myLabel4);
      myPanel.add(myLabel5);
      myPanel.add(myLabel6);
      myPanel.add(line);
      myPanel.add(start);
      myPanel.add(city1);
      myPanel.add(city2);
      myPanel.add(city3);
      myPanel.add(city4);
      myPanel.add(city5);
      myPanel.add(city6);
      myPanel.add(city7);
      myPanel.add(city8);
      myPanel.add(city9);
      myPanel.add(city10);
      myPanel.add(city11);
      myPanel.add(city12);
      myPanel.add(exit);
      myPanel.add(textArea);
      myPanel.add(textArea1);
      myPanel.add(textArea2);
      myPanel.add(textArea3);
      myPanel.add(textArea4);
      
      myLabel.setForeground(Color.WHITE);
      myLabel2.setForeground(Color.WHITE);
      myLabel3.setForeground(Color.WHITE);
      myLabel4.setForeground(Color.WHITE);
      myLabel5.setForeground(Color.WHITE);
      myLabel6.setForeground(Color.WHITE);
      line.setForeground(Color.WHITE);
      start.setForeground(Color.WHITE);
      myPanel.setBackground(Color.BLUE);
      
      add(myPanel);      //adds panel
      setVisible(true);
   }
   
   public void actionPerformed(ActionEvent evt)
   {
      int p = 0; //initializes counter
      if(evt.getSource() == city1) //if add button is pressed
      {
      
         textArea.setText(null);//clears textfield
         textArea1.setText(null);//clears textfield
         textArea2.setText(null);//clears textfield
         textArea3.setText(null);//clears textfield
         textArea4.setText(null);//clears textfield
         
         aa = "San Francisco ";
         bb = "New York ";
         cc = "Denver ";
         dd = "Rio de Janeiro ";
         ee = "Dallas ";
         ff = "Miami ";
         gg = "London ";
         hh = "Berlin ";
         ii = "Beijing ";
         jj = "Sydney ";
         kk = "Cape Town ";
         ll = "Tel Aviv ";
      
         try
         {
         File input = new File("DMtsp_SF.txt");
         Scanner myScanner = new Scanner(input);
         
         double start = System.nanoTime();//starts timer
         
         int a = myScanner.nextInt();//reads in first number
         
         matrix = new int[a][a];//sets size of 2D array
         
         for(int i = 0; i < a; i++)//fills 2D array
         {
            for(int j = 0; j < a; j++)
            {
               matrix[i][j] = myScanner.nextInt();
            }
         }
         
         int[] arr = new int[a];//sets size of array
         for(int i = 1; i < matrix.length; i++)//fills array
         {
            arr[i] = i;
         }
         best = new int[a];//sets size of array "best"
         
         min = cost(arr);//returns the first minimum (down the left side of the tree)
         
         perm(arr, p);//calls perm
         
         
         String bestPathTrav = bestPath(best);
         textArea.append(bestPathTrav);//prints out best path in cities
         
         String number = String.valueOf(min);//turns min into a String
         textArea1.append("$");
         textArea1.append(number);//prints the string min
         textArea1.append(".00");
         
         int fact = 1;
         for(int i = 1; i < a; i++)//calculates the number of paths possible
            fact = fact * i;
            
         String factorial = String.valueOf(fact);//turns fact into a string
         textArea4.append(factorial);//prints the factorial string
         
         String A = String.valueOf(a);//converts number of cities to a string
         textArea3.append(A);//displays number of cities
         
         double end = System.nanoTime();//ends timer
         double time = (end - start)/1000000000;//calculates in seconds
         String elapsed = String.valueOf(time);//turns time into a string
         textArea2.append(elapsed);//prints the string of seconds
         }
         catch(FileNotFoundException myError)
         {
            textArea.setText("Error");
         }
      }//closes button pressed
      
      
      if(evt.getSource() == city2) //if add button is pressed
      {
         textArea.setText(null);//clears textfield
         textArea1.setText(null);//clears textfield
         textArea2.setText(null);//clears textfield
         textArea3.setText(null);//clears textfield
         textArea4.setText(null);//clears textfield
         
         aa = "New York ";
         bb = "San Francisco ";
         cc = "Denver ";
         dd = "Rio de Janeiro ";
         ee = "Dallas ";
         ff = "Miami ";
         gg = "London ";
         hh = "Berlin ";
         ii = "Beijing ";
         jj = "Sydney ";
         kk = "Cape Town ";
         ll = "Tel Aviv ";
      
         try
         {
         //JFileChooser myChooser = new JFileChooser(); //initializes JFileChooser
         //int input = myChooser.showOpenDialog(null);
         
         File input = new File("DMtsp_NYC.txt");
         Scanner myScanner = new Scanner(input);
         
         //Scanner myScanner = new Scanner(myChooser.getSelectedFile());//initializes scanner
         
         double start = System.nanoTime();//starts timer
         
         int a = myScanner.nextInt();//reads in first number
         
         matrix = new int[a][a];//sets size of 2D array
         
         for(int i = 0; i < a; i++)//fills 2D array
         {
            for(int j = 0; j < a; j++)
            {
               matrix[i][j] = myScanner.nextInt();
            }
         }
         
         int[] arr = new int[a];//sets size of array
         for(int i = 1; i < matrix.length; i++)//fills array
         {
            arr[i] = i;
         }
         best = new int[a];//sets size of array "best"
         
         min = cost(arr);//returns the first minimum (down the left side of the tree)
         
         perm(arr, p);//calls perm
         
         
         String bestPathTrav = bestPath(best);
         textArea.append(bestPathTrav);//prints out best path in cities
         
         String number = String.valueOf(min);//turns min into a String
         textArea1.append("$");
         textArea1.append(number);//prints the string min
         textArea1.append(".00");
         
         int fact = 1;
         for(int i = 1; i < a; i++)//calculates the number of paths possible
            fact = fact * i;
            
         String factorial = String.valueOf(fact);//turns fact into a string
         textArea4.append(factorial);//prints the factorial string
         
         String A = String.valueOf(a);//converts number of cities to a string
         textArea3.append(A);//displays number of cities
         
         double end = System.nanoTime();//ends timer
         double time = (end - start)/1000000000;//calculates in seconds
         String elapsed = String.valueOf(time);//turns time into a string
         textArea2.append(elapsed);//prints the string of seconds
         }
         catch(FileNotFoundException myError)
         {
            textArea.setText("Error");
         }
      }//closes button pressed
      
      if(evt.getSource() == city3) //if add button is pressed
      {
         textArea.setText(null);//clears textfield
         textArea1.setText(null);//clears textfield
         textArea2.setText(null);//clears textfield
         textArea3.setText(null);//clears textfield
         textArea4.setText(null);//clears textfield
         
         aa = "Denver ";
         bb = "New York ";
         cc = "San Francisco ";
         dd = "Rio de Janeiro ";
         ee = "Dallas ";
         ff = "Miami ";
         gg = "London ";
         hh = "Berlin ";
         ii = "Beijing ";
         jj = "Sydney ";
         kk = "Cape Town ";
         ll = "Tel Aviv ";
      
         try
         {
         File input = new File("DMtsp_DEN.txt");
         Scanner myScanner = new Scanner(input);
         
         double start = System.nanoTime();//starts timer
         
         int a = myScanner.nextInt();//reads in first number
         
         matrix = new int[a][a];//sets size of 2D array
         
         for(int i = 0; i < a; i++)//fills 2D array
         {
            for(int j = 0; j < a; j++)
            {
               matrix[i][j] = myScanner.nextInt();
            }
         }
         
         int[] arr = new int[a];//sets size of array
         for(int i = 1; i < matrix.length; i++)//fills array
         {
            arr[i] = i;
         }
         best = new int[a];//sets size of array "best"
         
         min = cost(arr);//returns the first minimum (down the left side of the tree)
         
         perm(arr, p);//calls perm
         
         
         String bestPathTrav = bestPath(best);
         textArea.append(bestPathTrav);//prints out best path in cities
         
         String number = String.valueOf(min);//turns min into a String
         textArea1.append("$");
         textArea1.append(number);//prints the string min
         textArea1.append(".00");
         
         int fact = 1;
         for(int i = 1; i < a; i++)//calculates the number of paths possible
            fact = fact * i;
            
         String factorial = String.valueOf(fact);//turns fact into a string
         textArea4.append(factorial);//prints the factorial string
         
         String A = String.valueOf(a);//converts number of cities to a string
         textArea3.append(A);//displays number of cities
         
         double end = System.nanoTime();//ends timer
         double time = (end - start)/1000000000;//calculates in seconds
         String elapsed = String.valueOf(time);//turns time into a string
         textArea2.append(elapsed);//prints the string of seconds
         }
         catch(FileNotFoundException myError)
         {
            textArea.setText("Error");
         }
      }//closes button pressed
      
      if(evt.getSource() == city4) //if add button is pressed
      {
         textArea.setText(null);//clears textfield
         textArea1.setText(null);//clears textfield
         textArea2.setText(null);//clears textfield
         textArea3.setText(null);//clears textfield
         textArea4.setText(null);//clears textfield
         
         aa = "Rio de Janeiro ";
         bb = "Denver ";
         cc = "New York ";
         dd = "San Francisco ";
         ee = "Dallas ";
         ff = "Miami ";
         gg = "London ";
         hh = "Berlin ";
         ii = "Beijing ";
         jj = "Sydney ";
         kk = "Cape Town ";
         ll = "Tel Aviv ";
      
         try
         {
         File input = new File("DMtsp_RIO.txt");
         Scanner myScanner = new Scanner(input);
         
         double start = System.nanoTime();//starts timer
         
         int a = myScanner.nextInt();//reads in first number
         
         matrix = new int[a][a];//sets size of 2D array
         
         for(int i = 0; i < a; i++)//fills 2D array
         {
            for(int j = 0; j < a; j++)
            {
               matrix[i][j] = myScanner.nextInt();
            }
         }
         
         int[] arr = new int[a];//sets size of array
         for(int i = 1; i < matrix.length; i++)//fills array
         {
            arr[i] = i;
         }
         best = new int[a];//sets size of array "best"
         
         min = cost(arr);//returns the first minimum (down the left side of the tree)
         
         perm(arr, p);//calls perm
         
         
         String bestPathTrav = bestPath(best);
         textArea.append(bestPathTrav);//prints out best path in cities
         
         String number = String.valueOf(min);//turns min into a String
         textArea1.append("$");
         textArea1.append(number);//prints the string min
         textArea1.append(".00");
         
         int fact = 1;
         for(int i = 1; i < a; i++)//calculates the number of paths possible
            fact = fact * i;
            
         String factorial = String.valueOf(fact);//turns fact into a string
         textArea4.append(factorial);//prints the factorial string
         
         String A = String.valueOf(a);//converts number of cities to a string
         textArea3.append(A);//displays number of cities
         
         double end = System.nanoTime();//ends timer
         double time = (end - start)/1000000000;//calculates in seconds
         String elapsed = String.valueOf(time);//turns time into a string
         textArea2.append(elapsed);//prints the string of seconds
         }
         catch(FileNotFoundException myError)
         {
            textArea.setText("Error");
         }
      }//closes button pressed
      
      if(evt.getSource() == city5) //if add button is pressed
      {
         textArea.setText(null);//clears textfield
         textArea1.setText(null);//clears textfield
         textArea2.setText(null);//clears textfield
         textArea3.setText(null);//clears textfield
         textArea4.setText(null);//clears textfield
         
         aa = "Dallas ";
         bb = "Rio de Janeiro ";
         cc = "Denver ";
         dd = "New York ";
         ee = "San Francisco ";
         ff = "Miami ";
         gg = "London ";
         hh = "Berlin ";
         ii = "Beijing ";
         jj = "Sydney ";
         kk = "Cape Town ";
         ll = "Tel Aviv ";
      
         try
         {
         File input = new File("DMtsp_DAL.txt");
         Scanner myScanner = new Scanner(input);
         
         double start = System.nanoTime();//starts timer
         
         int a = myScanner.nextInt();//reads in first number
         
         matrix = new int[a][a];//sets size of 2D array
         
         for(int i = 0; i < a; i++)//fills 2D array
         {
            for(int j = 0; j < a; j++)
            {
               matrix[i][j] = myScanner.nextInt();
            }
         }
         
         int[] arr = new int[a];//sets size of array
         for(int i = 1; i < matrix.length; i++)//fills array
         {
            arr[i] = i;
         }
         best = new int[a];//sets size of array "best"
         
         min = cost(arr);//returns the first minimum (down the left side of the tree)
         
         perm(arr, p);//calls perm
         
         
         String bestPathTrav = bestPath(best);
         textArea.append(bestPathTrav);//prints out best path in cities
         
         String number = String.valueOf(min);//turns min into a String
         textArea1.append("$");
         textArea1.append(number);//prints the string min
         textArea1.append(".00");
         
         int fact = 1;
         for(int i = 1; i < a; i++)//calculates the number of paths possible
            fact = fact * i;
            
         String factorial = String.valueOf(fact);//turns fact into a string
         textArea4.append(factorial);//prints the factorial string
         
         String A = String.valueOf(a);//converts number of cities to a string
         textArea3.append(A);//displays number of cities
         
         double end = System.nanoTime();//ends timer
         double time = (end - start)/1000000000;//calculates in seconds
         String elapsed = String.valueOf(time);//turns time into a string
         textArea2.append(elapsed);//prints the string of seconds
         }
         catch(FileNotFoundException myError)
         {
            textArea.setText("Error");
         }
      }//closes button pressed
      
      if(evt.getSource() == city6) //if add button is pressed
      {
         textArea.setText(null);//clears textfield
         textArea1.setText(null);//clears textfield
         textArea2.setText(null);//clears textfield
         textArea3.setText(null);//clears textfield
         textArea4.setText(null);//clears textfield
         
         aa = "Miami ";
         bb = "Dallas ";
         cc = "Rio de Janeiro ";
         dd = "Denver ";
         ee = "New York ";
         ff = "San Francisco ";
         gg = "London ";
         hh = "Berlin ";
         ii = "Beijing ";
         jj = "Sydney ";
         kk = "Cape Town ";
         ll = "Tel Aviv ";
      
         try
         {
         File input = new File("DMtsp_MIA.txt");
         Scanner myScanner = new Scanner(input);
         
         double start = System.nanoTime();//starts timer
         
         int a = myScanner.nextInt();//reads in first number
         
         matrix = new int[a][a];//sets size of 2D array
         
         for(int i = 0; i < a; i++)//fills 2D array
         {
            for(int j = 0; j < a; j++)
            {
               matrix[i][j] = myScanner.nextInt();
            }
         }
         
         int[] arr = new int[a];//sets size of array
         for(int i = 1; i < matrix.length; i++)//fills array
         {
            arr[i] = i;
         }
         best = new int[a];//sets size of array "best"
         
         min = cost(arr);//returns the first minimum (down the left side of the tree)
         
         perm(arr, p);//calls perm
         
         
         String bestPathTrav = bestPath(best);
         textArea.append(bestPathTrav);//prints out best path in cities
         
         String number = String.valueOf(min);//turns min into a String
         textArea1.append("$");
         textArea1.append(number);//prints the string min
         textArea1.append(".00");
         
         int fact = 1;
         for(int i = 1; i < a; i++)//calculates the number of paths possible
            fact = fact * i;
            
         String factorial = String.valueOf(fact);//turns fact into a string
         textArea4.append(factorial);//prints the factorial string
         
         String A = String.valueOf(a);//converts number of cities to a string
         textArea3.append(A);//displays number of cities
         
         double end = System.nanoTime();//ends timer
         double time = (end - start)/1000000000;//calculates in seconds
         String elapsed = String.valueOf(time);//turns time into a string
         textArea2.append(elapsed);//prints the string of seconds
         }
         catch(FileNotFoundException myError)
         {
            textArea.setText("Error");
         }
      }//closes button pressed
      
      if(evt.getSource() == city7) //if add button is pressed
      {
         textArea.setText(null);//clears textfield
         textArea1.setText(null);//clears textfield
         textArea2.setText(null);//clears textfield
         textArea3.setText(null);//clears textfield
         textArea4.setText(null);//clears textfield
         
         aa = "London ";
         bb = "Miami ";
         cc = "Dallas ";
         dd = "Rio de Janeiro ";
         ee = "Denver ";
         ff = "New York ";
         gg = "San Francisco ";
         hh = "Berlin ";
         ii = "Beijing ";
         jj = "Sydney ";
         kk = "Cape Town ";
         ll = "Tel Aviv ";
      
         try
         {
         File input = new File("DMtsp_LON.txt");
         Scanner myScanner = new Scanner(input);
         
         double start = System.nanoTime();//starts timer
         
         int a = myScanner.nextInt();//reads in first number
         
         matrix = new int[a][a];//sets size of 2D array
         
         for(int i = 0; i < a; i++)//fills 2D array
         {
            for(int j = 0; j < a; j++)
            {
               matrix[i][j] = myScanner.nextInt();
            }
         }
         
         int[] arr = new int[a];//sets size of array
         for(int i = 1; i < matrix.length; i++)//fills array
         {
            arr[i] = i;
         }
         best = new int[a];//sets size of array "best"
         
         min = cost(arr);//returns the first minimum (down the left side of the tree)
         
         perm(arr, p);//calls perm
         
         
         String bestPathTrav = bestPath(best);
         textArea.append(bestPathTrav);//prints out best path in cities
         
         String number = String.valueOf(min);//turns min into a String
         textArea1.append("$");
         textArea1.append(number);//prints the string min
         textArea1.append(".00");
         
         int fact = 1;
         for(int i = 1; i < a; i++)//calculates the number of paths possible
            fact = fact * i;
            
         String factorial = String.valueOf(fact);//turns fact into a string
         textArea4.append(factorial);//prints the factorial string
         
         String A = String.valueOf(a);//converts number of cities to a string
         textArea3.append(A);//displays number of cities
         
         double end = System.nanoTime();//ends timer
         double time = (end - start)/1000000000;//calculates in seconds
         String elapsed = String.valueOf(time);//turns time into a string
         textArea2.append(elapsed);//prints the string of seconds
         }
         catch(FileNotFoundException myError)
         {
            textArea.setText("Error");
         }
      }//closes button pressed
      
      if(evt.getSource() == city8) //if add button is pressed
      {
         textArea.setText(null);//clears textfield
         textArea1.setText(null);//clears textfield
         textArea2.setText(null);//clears textfield
         textArea3.setText(null);//clears textfield
         textArea4.setText(null);//clears textfield
         
         aa = "Berlin ";
         bb = "London ";
         cc = "Miami ";
         dd = "Dallas ";
         ee = "Rio de Janeiro ";
         ff = "Denver ";
         gg = "New York ";
         hh = "San Francisco ";
         ii = "Beijing ";
         jj = "Sydney ";
         kk = "Cape Town ";
         ll = "Tel Aviv ";
      
         try
         {
         File input = new File("DMtsp_BER.txt");
         Scanner myScanner = new Scanner(input);
         
         double start = System.nanoTime();//starts timer
         
         int a = myScanner.nextInt();//reads in first number
         
         matrix = new int[a][a];//sets size of 2D array
         
         for(int i = 0; i < a; i++)//fills 2D array
         {
            for(int j = 0; j < a; j++)
            {
               matrix[i][j] = myScanner.nextInt();
            }
         }
         
         int[] arr = new int[a];//sets size of array
         for(int i = 1; i < matrix.length; i++)//fills array
         {
            arr[i] = i;
         }
         best = new int[a];//sets size of array "best"
         
         min = cost(arr);//returns the first minimum (down the left side of the tree)
         
         perm(arr, p);//calls perm
         
         
         String bestPathTrav = bestPath(best);
         textArea.append(bestPathTrav);//prints out best path in cities
         
         String number = String.valueOf(min);//turns min into a String
         textArea1.append("$");
         textArea1.append(number);//prints the string min
         textArea1.append(".00");
         
         int fact = 1;
         for(int i = 1; i < a; i++)//calculates the number of paths possible
            fact = fact * i;
            
         String factorial = String.valueOf(fact);//turns fact into a string
         textArea4.append(factorial);//prints the factorial string
         
         String A = String.valueOf(a);//converts number of cities to a string
         textArea3.append(A);//displays number of cities
         
         double end = System.nanoTime();//ends timer
         double time = (end - start)/1000000000;//calculates in seconds
         String elapsed = String.valueOf(time);//turns time into a string
         textArea2.append(elapsed);//prints the string of seconds
         }
         catch(FileNotFoundException myError)
         {
            textArea.setText("Error");
         }
      }//closes button pressed
      
      if(evt.getSource() == city9) //if add button is pressed
      {
         textArea.setText(null);//clears textfield
         textArea1.setText(null);//clears textfield
         textArea2.setText(null);//clears textfield
         textArea3.setText(null);//clears textfield
         textArea4.setText(null);//clears textfield
         
         aa = "Beijing ";
         bb = "Berlin ";
         cc = "London ";
         dd = "Miami ";
         ee = "Dallas ";
         ff = "Rio de Janeiro ";
         gg = "Denver ";
         hh = "New York ";
         ii = "San Francisco ";
         jj = "Sydney ";
         kk = "Cape Town ";
         ll = "Tel Aviv ";
      
         try
         {
         File input = new File("DMtsp_BEJ.txt");
         Scanner myScanner = new Scanner(input);
         
         double start = System.nanoTime();//starts timer
         
         int a = myScanner.nextInt();//reads in first number
         
         matrix = new int[a][a];//sets size of 2D array
         
         for(int i = 0; i < a; i++)//fills 2D array
         {
            for(int j = 0; j < a; j++)
            {
               matrix[i][j] = myScanner.nextInt();
            }
         }
         
         int[] arr = new int[a];//sets size of array
         for(int i = 1; i < matrix.length; i++)//fills array
         {
            arr[i] = i;
         }
         best = new int[a];//sets size of array "best"
         
         min = cost(arr);//returns the first minimum (down the left side of the tree)
         
         perm(arr, p);//calls perm
         
         
         String bestPathTrav = bestPath(best);
         textArea.append(bestPathTrav);//prints out best path in cities
         
         String number = String.valueOf(min);//turns min into a String
         textArea1.append("$");
         textArea1.append(number);//prints the string min
         textArea1.append(".00");
         
         int fact = 1;
         for(int i = 1; i < a; i++)//calculates the number of paths possible
            fact = fact * i;
            
         String factorial = String.valueOf(fact);//turns fact into a string
         textArea4.append(factorial);//prints the factorial string
         
         String A = String.valueOf(a);//converts number of cities to a string
         textArea3.append(A);//displays number of cities
         
         double end = System.nanoTime();//ends timer
         double time = (end - start)/1000000000;//calculates in seconds
         String elapsed = String.valueOf(time);//turns time into a string
         textArea2.append(elapsed);//prints the string of seconds
         }
         catch(FileNotFoundException myError)
         {
            textArea.setText("Error");
         }
      }//closes button pressed
      
      if(evt.getSource() == city10) //if add button is pressed
      {
         textArea.setText(null);//clears textfield
         textArea1.setText(null);//clears textfield
         textArea2.setText(null);//clears textfield
         textArea3.setText(null);//clears textfield
         textArea4.setText(null);//clears textfield
         
         aa = "Sydney ";
         bb = "Beijing ";
         cc = "Berlin ";
         dd = "London ";
         ee = "Miami ";
         ff = "Dallas ";
         gg = "Rio de Janeiro ";
         hh = "Denver ";
         ii = "New York ";
         jj = "San Francisco ";
         kk = "Cape Town ";
         ll = "Tel Aviv ";
      
         try
         {
         File input = new File("DMtsp_SYD.txt");
         Scanner myScanner = new Scanner(input);
         
         double start = System.nanoTime();//starts timer
         
         int a = myScanner.nextInt();//reads in first number
         
         matrix = new int[a][a];//sets size of 2D array
         
         for(int i = 0; i < a; i++)//fills 2D array
         {
            for(int j = 0; j < a; j++)
            {
               matrix[i][j] = myScanner.nextInt();
            }
         }
         
         int[] arr = new int[a];//sets size of array
         for(int i = 1; i < matrix.length; i++)//fills array
         {
            arr[i] = i;
         }
         best = new int[a];//sets size of array "best"
         
         min = cost(arr);//returns the first minimum (down the left side of the tree)
         
         perm(arr, p);//calls perm
         
         
         String bestPathTrav = bestPath(best);
         textArea.append(bestPathTrav);//prints out best path in cities
         
         String number = String.valueOf(min);//turns min into a String
         textArea1.append("$");
         textArea1.append(number);//prints the string min
         textArea1.append(".00");
         
         int fact = 1;
         for(int i = 1; i < a; i++)//calculates the number of paths possible
            fact = fact * i;
            
         String factorial = String.valueOf(fact);//turns fact into a string
         textArea4.append(factorial);//prints the factorial string
         
         String A = String.valueOf(a);//converts number of cities to a string
         textArea3.append(A);//displays number of cities
         
         double end = System.nanoTime();//ends timer
         double time = (end - start)/1000000000;//calculates in seconds
         String elapsed = String.valueOf(time);//turns time into a string
         textArea2.append(elapsed);//prints the string of seconds
         }
         catch(FileNotFoundException myError)
         {
            textArea.setText("Error");
         }
      }//closes button pressed
      
      if(evt.getSource() == city11) //if add button is pressed
      {
         textArea.setText(null);//clears textfield
         textArea1.setText(null);//clears textfield
         textArea2.setText(null);//clears textfield
         textArea3.setText(null);//clears textfield
         textArea4.setText(null);//clears textfield
         
         aa = "Cape Town ";
         bb = "Sydney ";
         cc = "Beijing ";
         dd = "Berlin ";
         ee = "London ";
         ff = "Miami ";
         gg = "Dallas ";
         hh = "Rio de Janeiro ";
         ii = "Denver ";
         jj = "New York ";
         kk = "San Francisco ";
         ll = "Tel Aviv ";
      
         try
         {
         File input = new File("DMtsp_CPT.txt");
         Scanner myScanner = new Scanner(input);
         
         double start = System.nanoTime();//starts timer
         
         int a = myScanner.nextInt();//reads in first number
         
         matrix = new int[a][a];//sets size of 2D array
         
         for(int i = 0; i < a; i++)//fills 2D array
         {
            for(int j = 0; j < a; j++)
            {
               matrix[i][j] = myScanner.nextInt();
            }
         }
         
         int[] arr = new int[a];//sets size of array
         for(int i = 1; i < matrix.length; i++)//fills array
         {
            arr[i] = i;
         }
         best = new int[a];//sets size of array "best"
         
         min = cost(arr);//returns the first minimum (down the left side of the tree)
         
         perm(arr, p);//calls perm
         
         
         String bestPathTrav = bestPath(best);
         textArea.append(bestPathTrav);//prints out best path in cities
         
         String number = String.valueOf(min);//turns min into a String
         textArea1.append("$");
         textArea1.append(number);//prints the string min
         textArea1.append(".00");
         
         int fact = 1;
         for(int i = 1; i < a; i++)//calculates the number of paths possible
            fact = fact * i;
            
         String factorial = String.valueOf(fact);//turns fact into a string
         textArea4.append(factorial);//prints the factorial string
         
         String A = String.valueOf(a);//converts number of cities to a string
         textArea3.append(A);//displays number of cities
         
         double end = System.nanoTime();//ends timer
         double time = (end - start)/1000000000;//calculates in seconds
         String elapsed = String.valueOf(time);//turns time into a string
         textArea2.append(elapsed);//prints the string of seconds
         }
         catch(FileNotFoundException myError)
         {
            textArea.setText("Error");
         }
      }//closes button pressed
      
      if(evt.getSource() == city12) //if add button is pressed
      {
         textArea.setText(null);//clears textfield
         textArea1.setText(null);//clears textfield
         textArea2.setText(null);//clears textfield
         textArea3.setText(null);//clears textfield
         textArea4.setText(null);//clears textfield
 
         aa = "Tel Aviv ";
         bb = "Cape Town ";
         cc = "Sydney ";
         dd = "Beijing ";
         ee = "Berlin ";
         ff = "London ";
         gg = "Miami ";
         hh = "Dallas ";
         ii = "Rio de Janeiro ";
         jj = "Denver ";
         kk = "New York ";
         ll = "San Francisco ";
      
         try
         {
         File input = new File("DMtsp_TEL.txt");
         Scanner myScanner = new Scanner(input);
         
         double start = System.nanoTime();//starts timer
         
         int a = myScanner.nextInt();//reads in first number
         
         matrix = new int[a][a];//sets size of 2D array
         
         for(int i = 0; i < a; i++)//fills 2D array
         {
            for(int j = 0; j < a; j++)
            {
               matrix[i][j] = myScanner.nextInt();
            }
         }
         
         int[] arr = new int[a];//sets size of array
         for(int i = 1; i < matrix.length; i++)//fills array
         {
            arr[i] = i;
         }
         best = new int[a];//sets size of array "best"
         
         min = cost(arr);//returns the first minimum (down the left side of the tree)
         
         perm(arr, p);//calls perm
         
         
         String bestPathTrav = bestPath(best);
         textArea.append(bestPathTrav);//prints out best path in cities
         
         String number = String.valueOf(min);//turns min into a String
         textArea1.append("$");
         textArea1.append(number);//prints the string min
         textArea1.append(".00");
         
         int fact = 1;
         for(int i = 1; i < a; i++)//calculates the number of paths possible
            fact = fact * i;
            
         String factorial = String.valueOf(fact);//turns fact into a string
         textArea4.append(factorial);//prints the factorial string
         
         String A = String.valueOf(a);//converts number of cities to a string
         textArea3.append(A);//displays number of cities
         
         double end = System.nanoTime();//ends timer
         double time = (end - start)/1000000000;//calculates in seconds
         String elapsed = String.valueOf(time);//turns time into a string
         textArea2.append(elapsed);//prints the string of seconds
         }
         catch(FileNotFoundException myError)
         {
            textArea.setText("Error");
         }
      }//closes button pressed
      
      if(evt.getSource() == exit) //if add button is pressed
      {
         System.exit(0);
      }
      
   }//closes action performed


public void perm(int[] input, int p)
{
   int x = 0;
   
   if (p == input.length - 1)//breaks recursion
   {
      inCost = cost(input); //finds the cost of the entire path
      
      if(inCost < min)//if the cost is less than the previous minimum
      {
         min = inCost; //sets new minimum
         for(int y = 0; y < input.length; y++)//fills best array with the new path
            best[y] = input[y];
      }
   }
   else
   {
      int n = costBB(input, p);//calculates cost at certain node pointer is pointing at
      if(n < min)//if cost is less than current min
      {
         for(int i = p; i < input.length ; i++)
         {
            
            x = input[i];//switch
            input[i] = input[p];
            input[p] = x;
            
            perm(input, p+1);//calls itself
            
            x = input[i];//switch back
            input[i] = input[p];
            input[p] = x;
         }
      }//closes if statement
   }//closes else
  } //closes action performed
      
public int cost(int[] array)
{
   int inCost1 = 0;
      
      inCost1 = inCost1 + matrix[0][array[0]];//adds from the first city to the second
         
      for(int i = 0; i < array.length - 1; i++)//calculates the cost of the route
      {
         int h = i + 1;
         inCost1 = inCost1 + matrix[array[i]][array[h]];
      }
    
      inCost1 = inCost1 + matrix[array[array.length - 1]][0];//calculates from the end of the route back to the first city
      
      return inCost1;//returns total cost
}

public int costBB(int[] array, int r)
{
   int inCost1 = 0;
      
      inCost1 = inCost1 + matrix[0][array[0]];//adds from the first city to the second
         
      for(int a = 0; a < r-1; a++)//calculates inCost1 until 1 less than pointer
      {
         int j = a + 1;
         inCost1 = inCost1 + matrix[array[a]][array[j]];
      }      
      return inCost1;//returns current cost
}

public String bestPath(int [] best)
{
   String best1 = "";
   for(int i = 0; i < 12; i++)
   {
      if(best[i] == 0)
         best1 = best1 + aa;
      else if (best[i] == 1)
         best1 = best1 + bb;
      else if (best[i] == 2)
         best1 = best1 + cc;
      else if (best[i] == 3)
         best1 = best1 + dd;
      else if (best[i] == 4)
         best1 = best1 + ee;
      else if (best[i] == 5)
         best1 = best1 + ff;
      else if (best[i] == 6)
         best1 = best1 + gg;      
      else if (best[i] == 7)
         best1 = best1 + hh;
      else if (best[i] == 8)
         best1 = best1 + ii;
      else if (best[i] == 9)
         best1 = best1 + jj;
      else if (best[i] == 10)
         best1 = best1 + kk;
      else if (best[i] == 11)
         best1 = best1 + ll;
         
      best1 = best1 + "\n";      
   }
best1 = best1 + aa;
return best1;
}
      
      
}//closes class