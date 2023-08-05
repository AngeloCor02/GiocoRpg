import java.util.Scanner;

public class Personaggi {
    
    private String nome;
    
    private int vita;

    private int vitaMassima;

    private int forza;

    private int difesa;



    public Personaggi(String nome,int vita, int forza, int difesa, Armi arma){

        this.nome = nome;

        this.vita = vita;

        this.difesa = difesa;

        this.forza = forza + arma.getDannoFisico();
        
    }

    

    public Personaggi(String nome,int vita, int forza, int difesa, int vitaMassima, Armi arma){

        this.nome = nome;

        this.vita = vita;

        this.difesa = difesa;

        this.vitaMassima = vitaMassima;

        this.forza = forza + arma.getDannoFisico();
        
    }


    public void sceltaNemico(Personaggi protagonista, Personaggi orco, Personaggi scheletro, Personaggi nemico){

        int num = (int)(Math.random()*2+1);

        if(num==1){

            nemico.setVita(orco.getVita());
            nemico.setDifesa(orco.getDifesa());
            nemico.setForza(orco.getForza());
            nemico.setNome(orco.getNome());

        }else if(num == 2) {

            nemico.setVita(scheletro.getVita());
            nemico.setDifesa(scheletro.getDifesa());
            nemico.setForza(scheletro.getForza());
            nemico.setNome(scheletro.getNome());

        }

    }


    public void combatti(Personaggi protagonista, Personaggi orco, Scanner scan, Consumabili pozioneVita, Personaggi scheletro, Personaggi nemico){

        int sceltaStanza = sceltaStanza();

        if (sceltaStanza <= 4){

            System.out.println("\tIL COMBATTIMENTO E' INIZIATO!!!!\n");

            sceltaNemico(protagonista, orco, scheletro, nemico);

            while (protagonista.getVita()>0 && nemico.getVita()>0) {

                statisticheCombattimento(protagonista, nemico);

                System.out.println("1. ATTACCA\n2. DIFENDITI\n3. CURATI\nINSERISCI LA TUA SCELTA: ");
            
                int risp = scan.nextInt();
                
                scan.nextLine();

                    switch (risp) {
            
                            case 1:

                                attacca(protagonista, nemico);
                                
                                break;
            
                            case 2:
            
                                difendi(protagonista, nemico);
                               
                                break;

                            case 3:

                                recuperaVita(protagonista, pozioneVita);

                                break;
                        }

                        if(protagonista.getVita() <= 0){

                            statisticheCombattimento(protagonista, nemico);

                            System.out.println("-->HAI PERSOOOO!!!<--");
                            

                        }else if(nemico.getVita() <= 0){

                            statisticheCombattimento(protagonista, nemico);

                            System.out.println("-->HAI VINTOOOO!!!<--");
                
                        }

            }

        }else if(sceltaStanza>4 && sceltaStanza<7){

            System.out.println("-->GIRAVI PER LA STANZA E HAI TROVATO UNA POZIONE DELLA VITA<--");

            System.out.println("-->QUANTITA' ATTUALE: " + pozioneVita.getQuantita() + "\n");

            pozioneVita.setQuantita((pozioneVita.getQuantita()+1));

        }else if(sceltaStanza == 7){

            System.out.println("-->GIRAVI PER LA STANZA E TI SEI IMBATTUTO IN UNA TRAPPOLA A DARDI<--");

            if((int)(Math.random()*2+1) == 1){

                System.out.println("-->HAI CALPESTATO UNA PEDANA E I DARDI TI HANNO FATTO DEL DANNO<--\n");

                protagonista.setVita(protagonista.getVita()-3);

            }else{

                System.out.println("-->PER FORTUNA NON HAI ATTIVATO NESSUN MARCHINGEGNO E NE ESCI ILLESO<--\n");

            }

        }else{

            System.out.println("-->CHE PECCATO NON HAI TROVATO NULLA IN QUESTA STANZA<--\n");

        }


    }
   

    public void recuperaVita(Personaggi protagonista, Consumabili pozioneVita){
        

        if(pozioneVita.getQuantita()>0){

            protagonista.setVita(protagonista.getVita()+pozioneVita.getPozioneVita());

            System.out.println("-->LA CURA E' ANDATA A BUON FINE<--");

            if(protagonista.getVita() > protagonista.getVitaMassima()){

                protagonista.setVita(protagonista.getVitaMassima());

            }

            pozioneVita.setQuantita(pozioneVita.getQuantita()-1);

            System.out.println("-->RIMANGONO " + pozioneVita.getQuantita() + " POZIONI DELLA VITA<--\n");

        }else{

            System.out.println("-->CERCHI UNA POZIONE DELLA VITA NELLO ZAINO MA TI ACCORGI CHE SONO FINITE.<--\n");

        }


    }

    public void attacca(Personaggi protagonista, Personaggi orco){

        if(sceltaCasuale() == true){

            protagonista.setVita((protagonista.getVita() - orco.getForza()) + (protagonista.getDifesa()/2));

            orco.setVita((orco.getVita() - protagonista.getForza()) + (orco.getDifesa()/2));

            System.out.println("-->IL NEMICO HA ATTACCATO.<--\n");

        }else{

            orco.setVita(orco.getVita() - protagonista.getForza()+ orco.getDifesa());

            System.out.println("-->IL NEMICO SI E' DIFESO.<--\n");

        }

    }

    

    public void difendi(Personaggi protagonista, Personaggi orco){

        if(sceltaCasuale() == true){

            protagonista.setVita(protagonista.getVita() - orco.getForza() + protagonista.getDifesa());

            System.out.println("-->IL NEMICO HA ATTACCATO.<--\n");

        }else{

            System.out.println("-->VI SIETE ENTRAMBI DIFESI.<--\n");

        }

    }


    /*
     * Metodo sceltaStanza
     * 
     * Utilizzo: serve per ritornare un numero int da 1 a 10
     * 
     * E' stato aggiunto per dare una randomicità alla scelta della stanza
     * 
    */
    public int sceltaStanza(){

        return (int)(Math.random()*10+1);

    }


    /*
     * METODO sceltaCasuale();
     * 
     * Ritorna un valore booleano casuale
     * 
     * Ritorna "true" o "false" con una probabilità del 50% 
     * 
     * E' stato usato per la scelta dell'attacco o la difesa del nemico
     * 
     */

    public boolean sceltaCasuale(){

        if ((int)(Math.random()*2+0) == 1){

            return true;

        }else{

            return false;

        }

    }


    /*
     * METODO statisticheCombattimento();
     * 
     * Stampa le statistiche del protagonista e del nemico
     * 
     * Viene stampato dall'inizio di un combattimento ogni azione che compie il protagonista.
     * 
     */

    public static void statisticheCombattimento(Personaggi protagonista, Personaggi nemico){

        if(protagonista.getVita()>=10){

            System.out.println("-----------------------------------------------------------------");

            System.out.println("\t" + protagonista.getNome() + "\t\t\t\t\t" + nemico.getNome() + "\n");

            System.out.print("\tVita: " + protagonista.getVita() + "\t\t\t\tVita: " + nemico.getVita() + 

            "\n\tForza: " + protagonista.getForza() + "\t\t\t\tForza: " + nemico.getForza() + 

            "\n\tDifesa: " + protagonista.getDifesa() + "\t\t\t\tDifesa: " + nemico.getDifesa());

            System.out.println("\n-----------------------------------------------------------------");

        }else{

            System.out.println("-----------------------------------------------------------------");

            System.out.println("\t" + protagonista.getNome() + "\t\t\t\t\t" + nemico.getNome() + "\n");

            System.out.print("\tVita: " + protagonista.getVita() + "\t\t\t\t\tVita: " + nemico.getVita() + 

            "\n\tForza: " + protagonista.getForza() + "\t\t\t\tForza: " + nemico.getForza() + 

            "\n\tDifesa: " + protagonista.getDifesa() + "\t\t\t\tDifesa: " + nemico.getDifesa());

            System.out.println("\n-----------------------------------------------------------------");

        }

        

    }


    public void vaiAvanti(){


        System.out.println("-->" + this.nome + " STA AVANZANDO.");


    } 


    public String toString(){

        String stringa = ("Nome: " + this.getNome() + "\nVita: " +this.getVita() + "\nForza: " +this.getForza() +
        "\nDifesa: " +this.getDifesa());

        return stringa;

    }




    public int getVita() {
        return this.vita;
    }

    public void setVita(int vita) {
        this.vita = vita;        
    }

    public int getVitaMassima() {
        return this.vitaMassima;
    }

    public void setVitaMassima(int vitaMassima) {
        this.vitaMassima = vitaMassima;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForza() {
        return this.forza;
    }

    public void setForza(int forza) {
        this.forza = forza;
    }

    public int getDifesa() {
        return this.difesa;
    }

    public void setDifesa(int difesa) {
        this.difesa = difesa;
    }


    

}
