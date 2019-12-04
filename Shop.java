
public interface Shop {
	void addIngr(Ingredient ingredient);
	void sale(String milkName, String ingrName) throws SoldOutException;

}
