
public class Armi {
    
    private String nomeSpada;

    private int dannoFisico;

    private int dannoMagico;

    private int perforazione;

    private int critico;

    
    public Armi(String nomeSpada, int dannoFisico, int perforazione){

        this.nomeSpada = nomeSpada;

        this.dannoFisico = dannoFisico;

        this.perforazione = perforazione;


    }


    public String getnomeSpada() {
        return this.nomeSpada;
    }

    public void setnomeSpada(String nomeSpada) {
        this.nomeSpada = nomeSpada;
    }

    public int getDannoFisico() {
        return this.dannoFisico;
    }

    public void setDannoFisico(int dannoFisico) {
        this.dannoFisico = dannoFisico;
    }

    public int getDannoMagico() {
        return this.dannoMagico;
    }

    public void setDannoMagico(int dannoMagico) {
        this.dannoMagico = dannoMagico;
    }

    public int getPerforazione() {
        return this.perforazione;
    }

    public void setPerforazione(int perforazione) {
        this.perforazione = perforazione;
    }

    public int getCritico() {
        return this.critico;
    }

    public void setCritico(int critico) {
        this.critico = critico;
    }




}


