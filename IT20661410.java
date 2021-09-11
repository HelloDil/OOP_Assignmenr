// It 20661410
// Perera M.L.D
// Group 4


import java.util.Scanner;
class Hunter {

	//Declare properties
	
    private String name;
    private String colour;
    private int PosX;
    private int PosY;
    
    // Setters and Getters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
     //Overloaded constructor
	
	public Hunter(String name, String colour) {
        this.name= name;
        this.colour = colour;
    }
     //set xPOS method
    public void setxPOS(int PosX) {
        this.PosX = PosX;
        if (PosX >= 250) {
            try {
            	//throw custom exception
                throw new SoundException("Oh oo!!!");
            } catch (SoundException e1) {
                System.out.println(e1.getMessage());//Get message that we send as parameters
            }
        }
    }
    
     // set YPOS method
    public void setYPOS(int PosY) {
        this.PosY = PosY;
        if (PosY >= 360) {
            try {
            	//throw custom exception
                throw new SoundException("Oh oo!!!");
            } catch (SoundException e2) {
                System.out.println(e2.getMessage());//Get message that we send as parameters
            }
        }
    }

    public void move(Hunter myhunter) {
        System.out.print("Hunter is moving,"+" X: " + myhunter.PosX + " Y: ");
        System.out.println(myhunter.PosY);
    }

    public void hunt(Board myboard) {
        String Tdot = myboard.getTdot();
        int Alldots = myboard.getNomaldots() + myboard.getSuperdots();
        if (Alldots !=0) {
            if (Tdot == "superDot") {
                int newSuperdots = myboard.getSuperdots() - 1;
                myboard.setSuperdots(newSuperdots);
                System.out.println("Hunting " + Tdot);
            } else {
                int newDotCount = myboard.getNomaldots() - 1;
                myboard.setSuperdots(newDotCount);
                System.out.println("Hunting " + Tdot);
            }
        } else {
            System.out.println("Game Over");
        }
    }
}


abstract class Soldier {  
    public abstract void hunt();
}
 //custom exception that created
class SoundException extends Exception {
    
	private static final long serialVersionUID = 1L;
    //method that use to pass parameter when we throw exception
	public SoundException(String msg) {
    //invoke exception class constructor
        super(msg);
    }
}

class BlueSoldier extends Soldier { //Soldier is a super class and BlueSoldier is a subclass

    public String Abilities = "gun";
    public String colour = "blue";
    
    // override the method 
    @Override
    public void hunt() {
        System.out.println("Killed Using a " + this.Abilities);
        System.out.println("Game Over");
    }
}

class GreenSoldier extends Soldier { //Soldier is a super class and GreenSoldier is a subclass

    public String Abilities = "knife";
    public String colour = "green";

    @Override
    public void hunt() {
        System.out.println("Killed using a " + this.Abilities);
        System.out.println("Game over");
    }
}

class RedSoldier extends Soldier { //Soldier is a super class and RedSoldier is a subclass

    public String Abilities = "hand";
    public String colour = "red";

    @Override
    public void hunt() {
        System.out.println("Killed using a " + this.Abilities);
        System.out.println("Game over");
    }
}


class Board {
	// attributes of board class
	
    private String Tdot;
    private int Nomaldots = 97;
    private int Superdots = 3;
    private Hunter myhunter;
    private Soldier[] threeSoldiers;
   
    // Board method
    
    public Board(String Tdot, Hunter myhunter, Soldier[] threeSoldiers) {
        this.Tdot = Tdot;
        this.myhunter = myhunter;
        this.threeSoldiers = threeSoldiers;
    }
     // create inite method
    
    public void init() {
 	   System.out.println("Board is ready and three soldiers and the hunter is positioned in the board");
  }
   
    // seters and getters 
    
    public String getTdot() {
        return Tdot;
    }

    public void setTdot(String Tdot) {
        this.Tdot = Tdot;
    }

    public int getNomaldots() {
        return Nomaldots;
    }

    public void setNomaldots(int Nomaldots) {
        this.Nomaldots = Nomaldots;
    }

    public int getSuperdots() {
        return Superdots;
    }

    public void setSuperdots(int Superdots) {
        this.Superdots = Superdots;
    }

    public Hunter getMyhunter() {
        return myhunter;
    }

    public void setMyhunter(Hunter myhunter) {
        this.myhunter = myhunter;
    }

    public Soldier[] getThreeSoldiers() {
        return threeSoldiers;
    }

    public void setThreeSoldiers(Soldier[] threeSoldiers) {
        this.threeSoldiers = threeSoldiers;
    }

  

 }
  // main class
public class MainApp {
    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        Hunter myhunter = new Hunter("Maha Deva", "Brown");
        Soldier threeSoldiers[] = {new RedSoldier(), new RedSoldier(), new GreenSoldier()};
        Board myboard = new Board("Superdot", myhunter, threeSoldiers);
       
        myboard.init();
        System.out.println("Use the keyboard up,down,left,right arrow keys to move the hunter");
        
        myhunter.setxPOS(ab.nextInt());
        myhunter.setYPOS(ab.nextInt());
        myhunter.move(myhunter);
        myhunter.hunt(myboard);
        threeSoldiers[2].hunt();
    }
}
