package hsl.matfox.models;

public class Attributes {
    public static final Attributes basicPlayer = new Attributes(5,5,10,5,5,5,5,5,5, 0);
    private int idAdventurer;
    private int Atk;
    private int Def;
    private int Life;
    private int SP;
    private int Int;
    private int Res;
    private int Dex;
    private int Luk;
    private int Agi;

    public Attributes(int atk, int def, int life, int SP, int anInt, int res, int dex, int luk, int agi, int IdAdventurer) {
        Atk = atk;
        Def = def;
        Life = life;
        this.SP = SP;
        Int = anInt;
        Res = res;
        Dex = dex;
        Luk = luk;
        Agi = agi;
        idAdventurer = IdAdventurer;
    }

    public int getAtk() {
        return Atk;
    }

    public void setAtk(int atk) {
        Atk = atk;
    }

    public int getDef() {
        return Def;
    }

    public void setDef(int def) {
        Def = def;
    }

    public int getLife() {
        return Life;
    }

    public void setLife(int life) {
        Life = life;
    }

    public int getSP() {
        return SP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    public int getInt() {
        return Int;
    }

    public void setInt(int anInt) {
        Int = anInt;
    }

    public int getRes() {
        return Res;
    }

    public void setRes(int res) {
        Res = res;
    }

    public int getDex() {
        return Dex;
    }

    public void setDex(int dex) {
        Dex = dex;
    }

    public int getLuk() {
        return Luk;
    }

    public void setLuk(int luk) {
        Luk = luk;
    }

    public int getAgi() {
        return Agi;
    }

    public void setAgi(int agi) {
        Agi = agi;
    }

    public int getIdAdventurer() {
        return idAdventurer;
    }

    public void setIdAdventurer(int idAdventurer) {
        this.idAdventurer = idAdventurer;
    }
}
