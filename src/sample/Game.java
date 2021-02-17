
package sample;
public class Game {
    private String name;
    private double price;
    private int releaseDate;

    public Game(){
        this.name="";
        this.price=0;
        this.releaseDate =0;

    }

    public Game(String name, double price, int releaseDate) {
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }
}
