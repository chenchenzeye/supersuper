
import java.util.Calendar;
import java.util.List;
 import java.util.ArrayList;
public class TeaShop implements Shop {
	private List<Bubble> bubbles=new ArrayList();
	private List<Coconut> coconuts=new ArrayList();

	@Override
	public void addIngr(Ingredient ingredient) {
		// TODO Auto-generated method stub
		if(ingredient instanceof Bubble){
			bubbles.add((Bubble) ingredient);
		}else{
			coconuts.add((Coconut) ingredient);
		}
	}

	@Override
	public void sale(String milkName, String ingrName) throws SoldOutException {
		// TODO Auto-generated method stub
		Ingredient  ingredient;
		List ingredients;
		Boolean  saleBool=false;
		if(ingrName.equals("Bullble")){
			ingredients=bubbles;
		}else{
			ingredients =coconuts;
		}
		for (int i=0;i<ingredients.size();i++){
			ingredient=(Ingredient) ingredients.remove(i);
			//判断是否过期
			Calendar now=Calendar.getInstance();  //当前
			Calendar productCal=ingredient.getProductDate();
			//计算 now 和 productCal之间的天数
			//TODO
			int day1 = now.get(Calendar.DAY_OF_YEAR);
			int day2 = productCal.get(Calendar.DAY_OF_YEAR);
			int day=day2-day1;
			if (day<=ingredient.getDay()){
				System.out.println("success!");
				saleBool=true;
				break;
			}
		}
		if (!saleBool){
			throw  new SoldOutException();
		}
	}

	public static  void main(String[] args){
		 	TeaShop teaShop=new TeaShop();
		 	//测试进货
		 	Bubble bubble=new Bubble();
		 	teaShop.addIngr(bubble);
		 	Coconut coconut=new Coconut();
		 	teaShop.addIngr(coconut);

		 	//测试出售
		try {
			teaShop.sale("珍珠奶茶", "Bubble");
		}catch (SoldOutException exception){
			System.out.println("配料不足!");
		}
	}

	public List<Bubble> getBubbles() {
		return bubbles;
	}

	public void setBubbles(List<Bubble> bubbles) {
		this.bubbles = bubbles;
	}

	public List<Coconut> getCoconuts() {
		return coconuts;
	}

	public void setCoconuts(List<Coconut> coconuts) {
		this.coconuts = coconuts;
	}
}
