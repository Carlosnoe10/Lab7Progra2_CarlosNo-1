package lab7prograii_carlosnoe;

import java.io.File;
import java.util.ArrayList;

public class AdminProductos {

    public ArrayList<Producto> Products = new ArrayList();
    private File archivo = null;

    public AdminProductos(String path) {
        archivo = new File(path);
    }

    public ArrayList<Producto> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<Producto> Products) {
        this.Products = Products;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setProductos(Producto p) {
        this.Products.add(p);
    }

}
