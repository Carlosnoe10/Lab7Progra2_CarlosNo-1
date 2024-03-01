package lab7prograii_carlosnoe;

public class Producto {
    public int ID;
    public String Nombre;
    public int Category;
    public double Price;       
    public int Aisle;
    public int Bin;

    public Producto(int ID, String Nombre, int Category, double Price, int Aisle, int Bin) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Category = Category;
        this.Price = Price;
        this.Aisle = Aisle;
        this.Bin = Bin;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int Category) {
        this.Category = Category;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getAisle() {
        return Aisle;
    }

    public void setAisle(int Aisle) {
        this.Aisle = Aisle;
    }

    public int getBin() {
        return Bin;
    }

    public void setBin(int Bin) {
        this.Bin = Bin;
    }

    @Override
    public String toString() {
        return ID + "," + Nombre + "," + Category + "," + Price + "," + Aisle + "," + Bin + '}';
    }
    
    
}
