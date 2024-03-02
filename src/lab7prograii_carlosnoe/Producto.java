package lab7prograii_carlosnoe;

public class Producto {
    public String ID;
    public String Nombre;
    public String Category;
    public String Price;       
    public String Aisle;
    public String Bin;

    public Producto(String ID, String Nombre, String Category, String Price, String Aisle, String Bin) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Category = Category;
        this.Price = Price;
        this.Aisle = Aisle;
        this.Bin = Bin;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getAisle() {
        return Aisle;
    }

    public void setAisle(String Aisle) {
        this.Aisle = Aisle;
    }

    public String getBin() {
        return Bin;
    }

    public void setBin(String Bin) {
        this.Bin = Bin;
    }

   

    @Override
    public String toString() {
        return ID + "," + Nombre + "," + Category + "," + Price + "," + Aisle + "," + Bin + '}';
    }
    
    public void ValidacionCategory(int Valor){
        
        
    }
}
