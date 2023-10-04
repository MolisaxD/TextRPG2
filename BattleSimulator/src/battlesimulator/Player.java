
package battlesimulator;

public class Player extends Character {
    
    //Atributos extra
    public int maxStamina, stamina, gold, hpPots, stPots;
    //Inventário
    public int inv;
    //Itens
    public int numAtkUpgrades, numDefUpgrades;
    
    
    public String[] atkUpgrades = {"Boomerang (+1 ATK)", "Trompa de Caça (+2 ATK)", "Vela Santa (+3 ATK)", "Dente de Dragão (+4 ATK)"};
    public String[] defUpgrades = {"Elmo de Ossos (+1 DEF)", "Cota de Malha (+2 DEF)", "Pergaminho Sagrado (+3 DEF)", "União (+4 DEF)"};

    public Player(String name) {
        super(name, 100, 0);
        
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        
        this.maxStamina = 100;
        this.stamina = 100;
        this.gold = 5;
        this.hpPots = 1;
        this.stPots = 1;
        
        chooseItem();
    }

    @Override
    public int attack() {
        int dmgCalc = (int) (Math.random() * 2 + (numAtkUpgrades + 2) + 2);
        if(dmgCalc <= 0) {
            dmgCalc = 1;
        }
        return dmgCalc;
    }

    @Override
    public int defend() {
        return (int) (Math.random() * 2 + (numDefUpgrades + 2) + 1);
    }

    public void chooseItem() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Escolha um item:");
        System.out.println("1)" + atkUpgrades[numAtkUpgrades]);
        System.out.println("2)" + defUpgrades[numDefUpgrades]);
        
        int input = GameLogic.readInt("->", 2);
        GameLogic.clearConsole();
        
        if(input == 1) { 
            GameLogic.printHeading("Você escolheu " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        } else {
            GameLogic.printHeading("Você escolheu " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }
    
}
