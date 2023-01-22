package hsl.matfox.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
