import java.util.Scanner;

public class MainRpg{

    public static void main(String[] args) {
            
        Consumabili pozioneVita = new Consumabili(7,4);

        Armi spada = new Armi("Spada lunga", 3, 0);
        Armi arco = new Armi("Arco", 2, 0);
    
        Personaggi protagonista = new Personaggi("Cortiz", 25, 4, 2, 25, spada);

        Personaggi orco = new Personaggi("Gondulf", 12, 3, 2, arco);
        Personaggi scheletro = new Personaggi("Randgarz", 10,  4, 2, arco);
        Personaggi nemico = new Personaggi("", 0, 0, 0, arco);

        gioco(protagonista, orco, pozioneVita, spada, scheletro, nemico);  

        System.out.println("IL GIOCO E' FINITO!!!");
    
        }


    public static void gioco(Personaggi protagonista, Personaggi orco, Consumabili pozioneVita, Armi spada, Personaggi scheletro, Personaggi nemico){

        String risposta;

        Scanner scan = new Scanner(System.in);

        System.out.println( ".....................................\r\n" + //
                            "..................|_______...........\r\n" + //
                            ".....()...........|      /....().....\r\n" + //
                            "....(  )..........|______\\...(  )....\r\n" + //
                            "...(____).........|.........(____)...\r\n" + //
                            "...|    |_________|_________|    |...\r\n" + //
                            "...|    |___|___|___|___|___|    |...\r\n" + //
                            "...|    |__|___|___|___|____|    |...\r\n" + //
                            "...|    |___|___|___|___|___|    |...\r\n" + //
                            "...|    |__|___|___|___|____|    |...\r\n" + //
                            "...|    |_|__ _________\t__|_|    |...\r\n" + //
                            "...|    |__|_|    |    |_|__|    |...\r\n" + //
                            "...|    |_|__|    |    |__|_|    |...\r\n" + //
                            "...|    |__|_|\t  |    |_|__|    |...\r\n" + //
                            "...|    |_|__|   O|O   |__|_|    |...\r\n" + //
                            "../______\\___|____|____|___/______\\..\r\n" + //
                            ".....................................\r\n" + //
                            ".....................................");

            while(protagonista.getVita()>0){

            System.out.println("1.MOSTRA LE TUE STATISTICHE\n2.INVENTARIO\n3.VAI A SINISTRA\n4.VAI AVANTI\n5.VAI A DESTRA\n\nINSERISCI LA TUA SCELTA: ");

            int risp = scan.nextInt();

            scan.nextLine();

            switch (risp) {

                case 1:
                
                    System.out.println("----------------------------------------------");
                    
                    System.out.println(protagonista.toString()); 

                    System.out.println("----------------------------------------------");
                    
                    break;

                case 2:

                    System.out.println("-->ARMI");
                    System.out.println(spada.getnomeSpada() + "\nDanno:" + spada.getDannoFisico() + "\n");
                    System.out.println("-->CONSUMABILI");
                    System.out.println("Pozione della vita\nQuantità: " + pozioneVita.getQuantita() + "\nRecupero vita: " + pozioneVita.getPozioneVita() + "\n");
                    System.out.println("SCRIVI 'Q' PER CURARTI");
                    System.out.println("SCRIVI 'W' PER TRONARE INDIETRO");
                    risposta=scan.nextLine();

                    if(risposta.equalsIgnoreCase("q")){

                        protagonista.recuperaVita(protagonista, pozioneVita);

                    }else{

                        continue;

                    }
                    

                    break;

                default :

                    protagonista.vaiAvanti();

                    protagonista.combatti(protagonista, orco, scan, pozioneVita, scheletro, nemico);
    
                    break;


            }

        }

        scan.close();


    }
}

    