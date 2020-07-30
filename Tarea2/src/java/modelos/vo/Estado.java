package modelos.vo;

public class Estado {

    private int estadoid;
    private String estadodesc;

    public Estado() {
    }

    public Estado(int estadoid, String estadodesc) {
        this.estadoid = estadoid;
        this.estadodesc = estadodesc;
    }

    public int getEstadoid() {
        return this.estadoid;
    }

    public void setEstadoid(int estadoid) {
        this.estadoid = estadoid;
    }

    public String getEstadodesc() {
        return this.estadodesc;
    }

    public void setEstadodesc(String estadodesc) {
        this.estadodesc = estadodesc;
    }
    
    @Override
    public String toString(){
        return "("+this.estadoid+") "+this.estadodesc;
    }
}
