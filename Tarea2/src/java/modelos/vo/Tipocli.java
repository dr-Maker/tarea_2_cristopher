
package modelos.vo;

public class Tipocli {
    private int tipoid;
    private String tipodesc;

    public Tipocli() {
    }

    public Tipocli(int tipoid, String tipodesc) {
        this.tipoid = tipoid;
        this.tipodesc = tipodesc;
    }

    public int getTipoid() {
        return tipoid;
    }

    public void setTipoid(int tipoid) {
        this.tipoid = tipoid;
    }

    public String getTipodesc() {
        return tipodesc;
    }

    public void setTipodesc(String tipodesc) {
        this.tipodesc = tipodesc;
    }
}
