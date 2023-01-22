package hsl.matfox.models;

public class Attributes {
    private Integer atk;
    private Integer def;
    private Integer life;
    private Integer SP;
    private Integer anInt;
    private Integer res;
    private Integer dex;
    private Integer luk;
    private Integer Agi;
    private Integer idAdventurer;


    public static final Attributes basicPlayer = new Attributes(5, 5, 10, 5, 5, 5, 5, 5, 5, 0);

    public Attributes(int atk, int def, int life, int sp, int anInt, int res, int dex, int luk, int agi, int IdAdventurer) {
        setAtk(atk);
        setDef(def);
        setLife(life);
        setSP(sp);
        setAnInt(anInt);
        setRes(res);
        setDex(dex);
        setLuk(luk);
        setAgi(agi);
        setIdAdventurer(IdAdventurer);
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
