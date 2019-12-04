
import java.util.Calendar;

public abstract class Ingredient {
    protected String name;
    protected Calendar productDate;
    protected int day;

    public String toString() {
        String str = "name";
        str += "productDate=" + productDate;
        str += "day" + day;
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getProductDate() {
        return productDate;
    }

    public void setProductDate(Calendar productDate) {
        this.productDate = productDate;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
