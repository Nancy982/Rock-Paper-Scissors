//Name: Nancy Medina
//Date: 03/05/18
//Description: project 2

import java.awt.Color;
import java.awt.Container;
import java.awt.event.*; 
import javax.swing.*;

public class RockPaperScissors {

   // use for statistic
   static int humanWon; 
   static int win=0;
   static int total=0;
   static int tie=0;
   
// main  
   public static void main(String[] args){ 
   
      // launch main game
      gamePanel();
      
      // launch instruction
      introductionPanel(); 
   }
   
   // give the instruction to the game
   private static void introductionPanel(){ 
      String text="Click on rock, paper or scissors to see if you'll win. \nGood luck!";
      JOptionPane.showMessageDialog(null,text, "How to play!",0);
   
   }

   // the main game panel
   private static void gamePanel(){ 
   
      //the main frame of the game
      JFrame frame = new JFrame("Rock, Paper, Scissors");   
   
      // creating a container panel, so we can place buttons where we pleased
      Container panel = frame.getContentPane(); 
      panel.setLayout(null); 
      
   
      String[] iconString= new String[3]; 
      int[] boundInt= new int[3]; 
   
      // creating the condtions
      for(int i=0; i<=2; i++){ 
         iconString[i]=System.getProperty("image"+ i +".jpg");
         boundInt[i]=40+150*i;
      }
   
      JButton b1 = new JButton ("Rock ", new ImageIcon(iconString[0]));
      b1.setBackground(Color.blue);
      b1.setBounds(10,boundInt[0],100,100);
   
   
      JButton b2 = new JButton ("Paper ", new ImageIcon(iconString[1]));
      b2.setBackground(Color.red);
      b2.setBounds(10,boundInt[1],100,100);
   
      JButton b3 = new JButton ("Scissors ", new ImageIcon(iconString[2]));
      b3.setBackground(Color.green);
      b3.setBounds(10,boundInt[2],100,100);//creating three buttons
   
   	
      //quit
      JButton b5 = new JButton("Quit"); 
      b5.setBounds(260, 430, 80, 30);
   
      panel.add(b1);
      panel.add(b2);
      panel.add(b3);
      panel.add(b5); 
      
      //next three button will listen for which play pick and calculate the win in computeWinner
      b1.addActionListener( 
         
            new ActionListener() {
               public void actionPerformed( ActionEvent event ) {
                  computeWinner(1);
               }
            }
         );
   
      b2.addActionListener(
         
            new ActionListener() {
               public void actionPerformed( ActionEvent event ) {
                  computeWinner(2);
               }
            }
         );
   
      b3.addActionListener(
         
            new ActionListener() {
               public void actionPerformed( ActionEvent event ) {
                  computeWinner(3);
               }
            }
         );
            
            //quit the game
      b5.addActionListener( 
            
            new ActionListener() {
               public void actionPerformed( ActionEvent event ) {
                  String text="I hope you had fun playing.";						
                  JOptionPane.showMessageDialog(null,text, "Thank you for playing", 0);
                  System.exit(0);
               }
            }
         );
      
      //set frame size and the game begins!
      frame.setSize(500, 500); 
      frame.setVisible(true); 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		
   }

   // computing the winner
   public static void computeWinner(int x){ 
      int computerChoice=computerRandomChoice();
      int humanChoice=x;
      String text,text1="";
      String winningCombination= ""+Math.min(computerChoice, humanChoice)+Math.max(computerChoice, humanChoice);
   
      switch(Integer.parseInt(winningCombination)){
      
         case 12:
            text = "Paper wins!";
            if(humanChoice==2) humanWon=1;
            break;
         case 13:
            text = "Rock wins!";
            if(humanChoice==1) humanWon=1;
            break;
         case 23:
            text = "Scissors wins!";
            if(humanChoice==3) humanWon=1;
            break;
         default: text="It is a tie!";
            humanWon=2;
            tie=tie+1;
      }
   
      if(humanWon==1){
         text1="Human wins!  ";
         humanWon=0;
         win=win+1;
         total=total+1;
      }else if(humanWon==2){
         text1="It is a tie!  ";
         humanWon=0;		
      }else{
         text1="Computer wins!  ";
         total=total+1;
      
      }
   
   
      JFrame frame = new JFrame("Rock, Paper, Scissors"); 
      Container panel = frame.getContentPane(); 
      panel.setLayout(null); 
   
   
      JLabel l0 = new JLabel(text1+text);
      l0.setBounds(100, 10, 300, 35);
      panel.add(l0);
   
   
   	//show the result in a new splash screen
   	
      JLabel l1 = new JLabel("Human's Choice");
      l1.setBounds(40, 35, 150, 35);
      panel.add(l1);
   
      JLabel l2 = new JLabel("Computer's Choice");
      l2.setBounds(215, 35, 150, 35);
      panel.add(l2);
   
      JLabel l3 = new JLabel(new ImageIcon("image"+(humanChoice-1)+".jpg"));
      l3.setBounds(10, 85, 170, 150);
      panel.add(l3);
   
      JLabel l4 = new JLabel(new ImageIcon("image"+(computerChoice-1)+".jpg"));
      l4.setBounds(200, 85, 170, 150);
      panel.add(l4);
   
      JLabel l5 = new JLabel("Win/Loss rate: " + win+"/"+total);
      l5.setBounds(125, 85, 150, 350);
      panel.add(l5);
   
      JLabel l6 = new JLabel("Tie: "+tie);
      l6.setBounds(125, 95, 125, 370);
      panel.add(l6);
   
      frame.setSize(400, 350); 
      frame.setVisible(true); 		
   
   
   
   }
   
   // creating a random choice of rock paper or scissors by the computer
   public static int computerRandomChoice(){
      int result=(int)(Math.random()*3)+1;		
      return result;
   }

}
