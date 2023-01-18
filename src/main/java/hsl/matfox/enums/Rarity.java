package hsl.matfox.enums;

public enum Rarity {

    COMMOM("Comum"),
    RARE("Raro"),
    SUPER_RARE("Super Raro"),
    EPIC("Épico"),
    LEGENDARY("Lendário"),
    MYTHIC("Mítico");

    private String valor;

    Rarity(String valor) {
        this.valor = valor;
    }

    public String displayName() {
        return this.valor;
    }

    @Override
    public String toString() {
        return this.valor.toUpperCase();
    }
}
