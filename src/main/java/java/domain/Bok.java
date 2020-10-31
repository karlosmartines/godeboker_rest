package java.domain;

public class Bok {
    private String tittel;
    private final Integer isbn;
    private Integer pris;

    public Bok(String tittel, Integer isbn, Integer pris) {
        this.tittel = tittel;
        this.isbn = isbn;
        this.pris = pris;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public Integer getPris() {
        return pris;
    }

    public void setPris(Integer pris) {
        this.pris = pris;
    }

    public Integer getAntall() {
        return antall;
    }

    public void setAntall(Integer antall) {
        this.antall = antall;
    }
}