/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesimulator;

import java.util.Scanner;

/**
 *
 * @author mborges
 */
public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    
    static Player player;
    
    //Variável para determinar se o jogo já começou
    public static boolean isRunning;
    
    
    //Inimigos
    public static String[] enemies = {"Javali", "Bandido", "Arthropleura"};
    
    //Progressão da história
    public static int place = 0, act = 1;
    public static String[] places = {"Pindorama (Floresta)", "Colinas Gorjala", "Cidade de Jinbú", "Unidade de Contenção TRC-008"};
    
    //Método para ler input do usuário
    public static int readInt(String prompt, int userChoices) {
        int input;
        
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Por favor insira um valor válido.");
            }
        } while(input < 1 || input > userChoices);
        return input;
    }
    
    //Limpar console
    public static void clearConsole() {
        for(int i = 0; i < 100; i++ ) {
                System.out.println();
        }  
    }
    
    //Separador
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
                System.out.print("-");
        }
            System.out.println();
        
    }
    
    //Cabeçalho
    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }
    
    //Pausa para o jogador continuar
    public static void anythingToContinue() {
        System.out.println("\nInsira qualquer valor para continuar...");
        scanner.next();
    }
    
    //Começar o jogo
    public static void startGame() {
        boolean nameSet = false;
        String name;
        
        printSeparator(40);
        printSeparator(30);
        System.out.println("Shid & Fard");
        printSeparator(40);
        printSeparator(30);
        System.out.println("Um jogo feito por...");
        System.out.println("Putz Software");
        printSeparator(30);
        anythingToContinue();
        
        
        
        Story.printIntro();
        do {
            clearConsole();
            printHeading("Digite seu nome: ");
            name = scanner.next();
            nameSet = true;
        } while (!nameSet);
        
        player = new Player(name);
        
        
        clearConsole();
        printHeading("Escolha uma classe: ");
        System.out.println("1) Jurado da Glória: Começa com uma melhoria de ataque extra.");
        System.out.println("2) Jurado da Redenção: Começa com 50 pontos de vida a mais.");
        System.out.println("3) Devoto dos Deuses: Começa com 50 pontos de stamina a mais.");
        System.out.println("4) Perjuro: Começa sem atributos extra.");
        int input = readInt("->", 4);
        
        switch(input) {
            case 1: 
                System.out.println("Você escolheu o caminho da glória e recebeu um " + player.atkUpgrades[0] + "!");
                player.numAtkUpgrades++;
                anythingToContinue();
                break;
            case 2: 
                player.maxHp += 50;
                player.hp = 150;
                System.out.println("Você escolheu o caminho da redenção e recebeu +50 HP!");
                anythingToContinue();
                break;
            case 3:
                player.maxStamina += 50;
                player.stamina = 150;
                System.out.println("Você  escolheu o caminho da devoção e recebeu +50 ST!");
                anythingToContinue();
                break;
            case 4:
                System.out.println("Você decidiu forjar o seu próprio destino, sem o zelo dos deuses. Boa sorte!");
                anythingToContinue();   
                break;
        }
        
        Story.printFirstActIntro();
        
        isRunning = true;
        
        gameLoop();
    }
    
    //Método para checar ato
    public static void checkAct() {
        if(player.xp >= 10 && act == 1) {
            //Incrementar ato e lugar
            act = 2;
            place = 1;
            
            //História
            Story.printFirstActOutro();
            
            //Escolher equipamento novo
            shop();
            
            //Novos inimigos para cada ato
            enemies[0] = "Verme da Terra";
            enemies[1] = "Águia Gigante";
            enemies[2] = "Golem de Pedra";
            
            //Curar o jogador
            player.hp = player.maxHp;
            player.stamina = player.maxStamina;
            
            //História
            Story.printSecondActIntro();
        } else if(player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            
            Story.printSecondActOutro();
            
            shop();
            
            enemies[0] = "Soldado da Resistência";
            enemies[1] = "Agente da Insurreição";
            enemies[2] = "Sparky, o melhor amigo do homem";
            
            player.hp = player.maxHp;
            
            Story.printThirdActIntro();
        } else if(player.xp >= 100 && act == 3) {
            act = 4;
            place = 3;
            
            Story.printThirdActOutro();
            
            shop();
            
            enemies[0] = "Carnotauro Esqueletal";
            enemies[1] = "Hecatônquiro";
            enemies[2] = "Avatar da Escuridão";
            
            player.hp = player.maxHp;
            
            Story.printFourthActIntro();
            
            //Batalha final
            finalBattle();
        } 
    }
    
    //Método para calcular um encontro aleatório (vou adicionar outros encontros no futuro)
    public static void randomEncounter() {
        randomBattle();
    }
    
    //Método para continuar a jornada
    public static void continueJourney() {
        //Checar o ato atual
        checkAct();
        //Checar se é o último ato
        if(act != 4) {
            randomEncounter();
        }
    }
    
    public static void characterInfo() {
        clearConsole();
        printHeading("INFORMAÇÕES DO PERSONAGEM");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp + "\tOuro: " + player.gold);
        printSeparator(20);
        System.out.println("XP: " + player.xp);
        printSeparator(20);
        System.out.println("Stamina: " + player.stamina);
        printSeparator(20);
        System.out.println("# de poções de vida: " + player.hpPots);
        printSeparator(20);
        System.out.println("# de poções de stamina: " + player.stPots);
        printSeparator(20);
        System.out.println("Inventário: " + player.inv + "/10");
        printSeparator(20);
        
        if(player.numAtkUpgrades > 0) {
            System.out.println("Armas: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        } 
        if(player.numDefUpgrades > 0) {
            System.out.println("Defesa: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }
        
        anythingToContinue();
    }
    
    //Mercador depois de cada fase
    public static void shop() {
        clearConsole();
        printHeading("Você dá de cara com um rosto amigável. Um comerciante nômade está disposto a vender-lhe iguarias, pelo preço certo.");
        System.out.println("1) Quem é você?");
        System.out.println("2) Comprar");
        System.out.println("3) Adeus");
        int input = readInt("->", 3);
        
        if(input == 1) {
            //Lore do NPC
            clearConsole();
            System.out.println("什麼？不管那是什麼語言，我都不會說。就買我的東西吧。");
            anythingToContinue();
            shop();
            
        } else if (input == 2) {
            //Loja
            clearConsole();
            //Calcular preços
            int priceAtk = (int) ((8 * player.numAtkUpgrades + 1) + 1);
            int priceDef = (int) ((8 * player.numDefUpgrades + 1) + 1);
            //Menu da loja
            printHeading("Itens disponíveis:");
            System.out.println("Ouro: " + player.gold);
            System.out.println("1) Melhoria de ataque - " + player.atkUpgrades[player.numAtkUpgrades] + ": " + priceAtk + " ouro");
            System.out.println("2) Melhoria de defesa - " + player.defUpgrades[player.numDefUpgrades] + ": " + priceDef + " ouro");
            System.out.println("3) Voltar");
            printSeparator(20);
            input = readInt("->", 3);
            
            if(input == 1) {
                if(priceAtk > player.gold) {
                    System.out.println("Você não possui ouro suficiente para comprar este item.");
                    anythingToContinue();
                    shop();
                } else {
                    player.gold -= priceAtk;
                    System.out.println("Você comprou " + player.atkUpgrades[player.numAtkUpgrades]);
                    anythingToContinue();
                    player.numAtkUpgrades++;
                    shop();
                }
            } else  if (input == 2){
                if(priceDef > player.gold) {
                    System.out.println("Você não possui ouro suficiente para comprar este item.");
                    anythingToContinue();
                    shop();
                } else {
                    player.gold -= priceDef;
                    System.out.println("Você comprou " + player.defUpgrades[player.numDefUpgrades]);
                    anythingToContinue();
                    player.numDefUpgrades++;
                    shop();
                }
            } else { 
                shop();
            }
        } else {
            //Sair
            System.out.println("Você decide continuar a sua jornada.");
            anythingToContinue();
        }
    }
    
    //Método para criar uma batalha aleatória
    public static void randomBattle() {
        clearConsole();
        printHeading("Você foi emboscado por um ser hostil. Você deve lutar!!");
        anythingToContinue();
        
        //Criando inimigo novo
        battle(new Enemy(enemies[(int) (Math.random() * enemies.length)], player.xp));
    }
    
    //O método principal de batalha
    public static void battle(Enemy enemy) {
        while(true) {
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp + "\n"
                    + "ST: " + player.stamina + "/" + player.maxStamina);
            System.out.println("Escolha uma ação:");
            printSeparator(20);
            System.out.println("1) Lutar");
            System.out.println("2) Usar poção");
            System.out.println("3) Correr");
            int input = readInt("->", 3);
            
            //Reagir de acordo com a escolha do jogador
            if(input == 1) {
                //Checar stamina
                if(player.stamina > 0) {
                    
                    //Luta
                    if(player.stamina < 10) {
                        player.stamina = 0;
                    } else {
                        player.stamina -= 4;
                    }
                    
                    //Calcular dano infligido e dano tomado
                    int dmg = player.attack() - enemy.defend();
                    int dmgTook = enemy.attack() - player.defend();
                
                    //Refletir o dano se defender muito bem
                    if(dmgTook < 0) 
                        dmgTook = 0;
                        dmg += dmgTook/2;
                    
                    if(dmg < 0) 
                        dmg = 0;
   
                    //Atualizar dados de ambos
                    player.hp -= dmgTook;
                    enemy.hp -= dmg;

                    //Informação sobre o round atual
                    clearConsole();
                    printHeading("Batalha");
                    System.out.println("Você causou " + dmg + " de dano ao inimigo " + enemy.name + ".");
                    printSeparator(15);
                    System.out.println("O inimigo lhe causou " + dmgTook + " de dano.");
                    anythingToContinue();
                } else {
                    System.out.println("Você não possui stamina suficiente para lutar! Tome uma poção ou corra!");
                    anythingToContinue();
                }
               
                
                //Checar se a batalha terminou (hp = 0)
                if(player.hp <= 0) {
                    playerDied();
                    break;
                } else if(enemy.hp <= 0) {
                    //Jogador venceu
                    clearConsole();
                    printHeading(enemy.name + " foi derrotado!!");
                    player.xp += enemy.xp;
                    System.out.println("Você ganhou " + enemy.xp + " pontos de experiência.");
                    
                    //Drops aleatórios - ouro
                    int goldEarned = (int) (Math.random() * enemy.xp + 1);
                    player.gold += goldEarned;
                    System.out.println("Você coletou " + goldEarned + " moedas do inimigo.");
                    
                    //Drops aleatórios - poções
                    if(player.inv < 10) {
                       if((double) (Math.random()) < 0.3) {
                        player.hpPots++;
                        player.inv++;
                           System.out.println("O seu inimigo deixou cair uma poção de vida! Inventário: " + (player.hpPots + player.stPots) + "/10");
                        }
                        if((double) (Math.random()) < 0.3) {
                        player.stPots++;
                        player.inv++;
                        System.out.println("O seu inimigo deixou cair uma poção de stamina! Inventário: " + (player.hpPots + player.stPots) + "/10");
                        } 
                    }
                    
                    
                    anythingToContinue();
                    break;
                }
                
            } else if(input == 2) {
                //Usar poção
                clearConsole();
                //Escolher entre poção de vida e stamina
                System.out.println("1) Poção de Vida (+100 HP)");
                System.out.println("2) Poção de Stamina (+100 ST)");
                
                input = readInt("->", 2);
                
                //Poção de vida
                if(input == 1) {
                    if(player.hpPots > 0 && player.hp < player.maxHp) {
                    //Jogador pode usar a poção
                    player.hp = player.maxHp;
                    clearConsole();
                    
                    printHeading("Você tomou uma poção mágica. Sua vida foi restaurada para " + player.maxHp + "!");
                    anythingToContinue();
                    } else { 
                    //Jogador não pode usar a poção
                    System.out.println("Você não possui mais poções de vida ou já está de vida cheia.");
                    anythingToContinue();
                    }
                //Poção de stamina
                } else {
                    if(player.stPots > 0 && player.stamina < player.maxStamina) {
                        //Jogador pode usar a poção
                        player.stamina = player.maxStamina;
                        clearConsole();
                        
                        printHeading("Você tomou uma poção mágica. Sua stamina foi restaurada para " + player.maxStamina + "!");
                        anythingToContinue();
                    } else {
                        //Jogador não pode usar a poção
                        System.out.println("Você não possui poções de stamina ou já está de fôlego cheio.");
                        anythingToContinue();
                    }
                
            }
                    
            } else {
                //Correr
                clearConsole();
                //Checar se não é o último ato (não pode correr)
                if (act != 4) {
                    clearConsole();
                    //Chance de escape
                    if(Math.random() * 10 + 1 <= 5.0) {
                        enemy.hp = 0;
                        System.out.println("Você escapou com sucesso!");
                        anythingToContinue();
                        break;
                    } else {
                        printHeading("Você não conseguiu escapar!");
                        int dmgTook = enemy.attack();
                        //Punir o jogador por tentar fugir
                        System.out.println("Você tomou " + dmgTook + " de dano!");
                        anythingToContinue();

                        //Checar se jogador ainda está vivo
                        if(player.hp <= 0) {
                            playerDied();
                        }
                    }
                } else {
                    printHeading("Forças divinas te previnem de fugir dessa batalha!!");
                    anythingToContinue();
                }
            }
        }
    }
    
    //Método para definir o menu
    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Escolha uma ação:");
        printSeparator(20);
        System.out.println("1) Continue sua jornada");
        System.out.println("2) Dados do personagem");
        System.out.println("3) Sair do jogo");
    }
    
    //Método para quando o jogador morre
    public static void playerDied() {
        clearConsole();
        printHeading("Você morreu...");
        printHeading("Você ganhou " + player.xp + " de experiência em sua jornada! Tente novamente!");
        isRunning = false;
    }
    
    //Batalha final
    //TODO fazer uma batalha mais complexa no futuro
    public static void finalBattle() {
        battle(new Enemy("Nigromante", 300));
        //Fim do jogo
        Story.printEnd(player);
        isRunning = false;
    }
    
    //Loop principal
    public static void gameLoop() {
        while(isRunning) {
            printMenu();
            int input = readInt("->", 3);
            if(input == 1) {
                continueJourney();
            } else if (input == 2){
                characterInfo();
            } else {
                isRunning = false;
            }
        }
    }
}
