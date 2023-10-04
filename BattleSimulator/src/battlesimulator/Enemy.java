
package battlesimulator;

public class Enemy extends Character {
    
    //Variável para armazenar experiência atual do jogador
    int playerXp;

    public Enemy(String name, int playerXp) {
        super(name, (int) (Math.random() * playerXp + playerXp/3 + 5), (int) (Math.random() * (playerXp/4 + 2) + 1));
        this.playerXp = playerXp;
    }

    @Override
    public int attack() {
        return (int) (Math.random() * (playerXp/5 + 8) + xp/5 + 3);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (playerXp/5 + 1) + xp/5 + 3);
    }
    
}
