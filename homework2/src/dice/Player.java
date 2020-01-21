package dice;

public class Player {
    private String name;
    private int dicevalue;
    private int wincnt;    
    public Player(){
        wincnt = 0;
    }
	public void setname(String tempname) {
		this.name=tempname;
	}
    public String getname(){
        return name;
    }    
    public void setDice(){
        int firstdice = (int)(Math.random()*6)+1;
        System.out.print("첫번째 주사위 : "+firstdice);
        int seconddice = (int)(Math.random()*6)+1;
        System.out.print(" 두번째 주사위 : "+seconddice + " ");
        dicevalue = firstdice + seconddice;
    }
    public int getdicevalue(){
        return dicevalue;
    }

    public void win(){
        wincnt +=1;
    }
    public int getwincnt(){
        return wincnt;
    }
	
}
