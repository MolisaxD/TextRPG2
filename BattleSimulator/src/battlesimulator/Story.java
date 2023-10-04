
package battlesimulator;

public class Story {
    public static void printIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("PRÓLOGO");
        GameLogic.printSeparator(30);
        System.out.println(" O mundo é dominado por dragões, que formam o topo da hierarquia e são comandados por 5 Emblemas portadores de poderes imensos: Emblema da Entropia,\n"
                + " Emblema da Inércia, Emblema da Energia, Emblema da Origem e Emblema da Polaridade. Nessa situação, a sociedade e os humanos se encontram marginalizados e\n "
                + "procurando qualquer oportunidade de se rebelar. É aí que entra Nigromante, uma pessoa que dedicou sua vida inteira às artes arcanas com o intuito de um dia se juntar à\n "
                + "alta sociedade dos dragões, seja como serva ou renascida como um deles. Foi rejeitada e humilhada, então resolve acudir à sociedade dos artífices, que monta animais mecânicos\n "
                + "artesanais e por meio de um pacto, pretende transferir sua alma ao corpo de um dragão feito com tecnologia humana e energia nuclear. Contudo, é revelado que as intenções de\n "
                + "Nigromante vão além do que era esperado e é necessário que alguém a pare antes que cause uma guerra nuclear e possível genocídio com seu dragão mecânico.\n "
                + "Você é um agente de elite enviado pelos Emblemas para derrotá-la para impedir que pessoas inocentes morram e para prevenir a usurpação de seus líderes dragões.");
        GameLogic.anythingToContinue();
    }
    
    public static void printFirstActIntro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ATO I - Introdução");
        System.out.println(" Saudações, cavaleiro. Você recebeu uma ordem da sociedade de dragões à qual você faz parte. Como agente de elite dos Emblemas,\n "
                + "você deve encontrar Nigromante, uma ex agente da mesma sociedade que pretende usurpar a posição dos seus líderes. Acredita-se que Nigromante buscou refúgio na\n "
                + "Cidade de Jinbú, conhecida por ser uma nação de ordem e progresso. Você deve passar pela floresta Pindorama e as Colinas de Gorjala antes de chegar lá. Boa sorte!");
        GameLogic.anythingToContinue();
    }
    
    public static void printFirstActOutro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ATO I - Completo");
        System.out.println("Você sobreviveu com sucesso à floresta Pindorama e suas criaturas, e está pronto para cruzar as Colinas de Gorjala. Não desanime ainda, sua jornada acabou de começar!\n"
                + "Enquanto isso, rumores estão se espalhando sobre uma possível insurreição do povo de Jinbú, insatisfeitos com suas condições de vida. Por sorte, o objetivo de sua missão já \n"
                + "se encontra lá.");
        GameLogic.anythingToContinue();
    }
    
    public static void printSecondActIntro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ATO II - Introdução");
        System.out.println(" Bem-vindo às Colinas de Gorjala! Dizem que a colina principal foi formada com a queda de um gigante de pedra colossal que viveu séculos atrás.\n"
                + " Infelizmente, os habitantes da região não estão tão felizes com a sua chegada. Além de ar fresco, vista bonita e céu limpo a previsão é de que também teremos\n"
                + " Vermes da Terra, Golens de Pedra e Águias Gigantes para interromper sua aventura.");
        GameLogic.anythingToContinue();
    }
    
    public static void printSecondActOutro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ATO II - Completo");
        System.out.println("Parabéns, você conseguiu passar pelos monstros das Colinas de Gorjala e agora seu objetivo está bem diante de você: A cidade de Jinbú, vista do alto da colina,\n"
                + " se encontra logo em frente. Você sente que já aprendeu bastante em sua aventura e está preparado para o que está por vir.");
        GameLogic.anythingToContinue();
    }
    
    public static void printThirdActIntro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ATO III - Introdução");
        System.out.println(" Cidade de Jinbú, uma nação de ordem e progresso. Ao contrário dos outros territórios colonizados por humanos, essa cidade opera de maneira industrial.\n"
                + "Mecânica, ciência e engenharia são priorizadas acima de outros valores, o que é perceptível pelo porte e design de suas edificações.\n"
                + "Prédios altos com alta densidade de moradores quase bloqueiam a vista do céu. Serviços públicos são impulsionados por mecanismos gigantes, repletos de engrenagens e fiação.\n "
                + "A fumaça espalha um odor tóxico, que contamina os pulmões dos trabalhadores à serviço dos Emblemas. O trabalho forçado e condições insalubres estão causando\n"
                + "revolta nos olhos do povo, mas você sabe que os Emblemas tem o poder de fogo necessário para cessar qualquer protesto.\n"
                + "Sua missão aqui é encontrar o esconderijo de Nigromante, e os locais não parecem estar satisfeitos com sua presença...");
        GameLogic.anythingToContinue();
    }
    
    public static void printThirdActOutro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ATO III Completo");
        System.out.println(" Você decide poupar a vida de seu último inimigo para interrogá-lo sobre a localização de Nigromante. Está claro que a sua presença já causa terror nos locais,\n "
                + "que se trancaram dentro de suas casas, deixando-o sozinho com você. O ser inferior que antes demonstrava hostilidade agora oferece uma proposta:\n"
                + "'Você está certo, não existe chance dessa insurreição acontecer, eu posso convencer meus amigos... Por favor não me mate, eu tenho uma família..'\n"
                + "Com a informação que você precisava em mãos, você não vê motivo para matar este indivíduo, mas o faz do mesmo jeito para desmotivar os insurgentes.\n"
                + "Sua aventura está quase chegando ao fim!");
        GameLogic.anythingToContinue();
    }
    
    public static void printFourthActIntro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ATO IV Introdução");
        System.out.println(" Você se dirige ao local informado no interrogamento. Trata-se de um pátio no centro de uma vila, aberto à luz da Lua. De cara parece apenas um pátio comum,\n"
                + "porém com a informação que você recebeu, você puxa uma alavanca que revela um vão de escadas em espiral no centro. Você sente um cheiro fétido de sangue e\n"
                + "um calafrio subir em sua espinha. Nigromante é conhecida pelas suas artes místicas obscuras, o que a permitem que invoque servos da escuridão para impedi-lo.\n"
                + "Você desce o vão de escadas, chegando a um local mais parecido com um abrigo nuclear do que uma oficina. Os servos de Nigromante se agitam... E mais profundamente\n"
                + "... a própria Nigromante ");
        GameLogic.anythingToContinue();
    }
    
    public static void printFourthActOutro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ATO IV Completo");
        System.out.println("Com seu último suspiro, Nigromante deixa este mundo, porém não sem antes amaldiçoá-lo... Seus servos ainda estão espalhados pelo mundo, "
                + "sua influência alastrando efeitos na população, ainda sem conhecimento do que acaba de se passar.. O futuro parece... brilhante?\n"
                + "A Resistência perde suas esperanças na possibilidade de uma rebelião e as engrenagens da indústria continuarão girando... ");
        GameLogic.anythingToContinue();
    }
    
    public static void printEnd(Player player) {
        GameLogic.clearConsole();
        GameLogic.printHeading("Epílogo");
        System.out.println("Parabéns, " + player + "! Você derrotou as forças do mal e garantiu seu estatuto social junto à elite de dragões! Sua jornada com certeza irá inspirar novos aventureiros a "
                + "continuar a opressão das classes baixas de trabalhadores para defender o sistema opressor criado pelos Emblemas!");
        GameLogic.anythingToContinue();
    }
}
