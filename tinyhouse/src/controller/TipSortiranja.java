package controller;

public enum TipSortiranja {
    CIJENA_RASTUCE ("Cijena rastuće"),
    CIJENA_OPADAJUCE ("Cijena opadajuće"),
    NAZIV_RASTUCE ("Naziv rastuće"),
    NAZIV_OPADAJUCE ("Naziv opadajuće");

    private final String name;

    private TipSortiranja(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
