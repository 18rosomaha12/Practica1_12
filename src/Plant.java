import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;


public class Plant implements Externalizable {

    private String fio;
    private int lepest;
    private int dlin;
    private String cvet;
    private boolean gorsh;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getLepest() {
        return lepest;
    }

    public void setLepest(int lepest) {
        this.lepest = lepest;
    }

    public int getDlin() {
        return dlin;
    }

    public void setDlin(int dlin) {
        this.dlin = dlin;
    }

    public String getCvet() {
        return cvet;
    }

    public void setCvet(String cvet) {
        this.cvet = cvet;
    }

    public boolean isGorsh() {
        return gorsh;
    }

    public void setGorsh(boolean gorsh) {
        this.gorsh = gorsh;
    }

    public Plant(String fio, int lepest, int dlin, String cvet, boolean gorsh) {
        this.fio = fio;
        this.lepest = lepest;
        this.dlin = dlin;
        this.cvet = cvet;
        this.gorsh = gorsh;
    }

    public Plant() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.fio);
        out.writeObject(this.lepest);
        out.writeObject(this.dlin);
        out.writeObject(this.cvet);
        out.writeObject(this.gorsh);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.fio = (String) in.readObject();
        this.lepest = (int) in.readObject();
        this.dlin = (int) in.readObject();
        this.cvet = (String) in.readObject();
        this.gorsh = (boolean) in.readObject();
    }

}

