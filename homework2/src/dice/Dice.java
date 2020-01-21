package dice;

public class Dice {
	private final int MAX = 6;
    private int faceValue;
   
    public Dice(int i){
        faceValue = i;
     }
     public int roll()
    {
       faceValue = (int)(Math.random()*MAX)+1;
       return faceValue;
    }
    public int set_dice(){
         return faceValue;
    }
}
