import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    List<T> box;
    public Box() {
        box = new ArrayList<>();
    }
    public List<T> getBox() {
        return box;
    }
    public void add(T fruit) throws BoxExeption {
       if(box.isEmpty()) {
           box.add(fruit);
       } else if (getBox().get(0).getClass() != fruit.getClass()) {
           throw new BoxExeption("Нельзя складывать в одну коробку разные виды фруктов");
       } else {
           box.add(fruit);
       }
    }

    public float getTotalWeight() {
        float totalWeight = 0;
        for (T fruit: box) {
            totalWeight = totalWeight+fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> anotherBox) {
        return this.getTotalWeight()==anotherBox.getTotalWeight();
    }

    public void pureFromOneToAnother(Box<T> anotherBox) throws BoxExeption {
        if (getBox().isEmpty()) {
            throw new BoxExeption("Вы хотите высыпать что-то из пустой коробки, но это невозможно, ведь там ничего нет");
        }
        else if (anotherBox.getBox().isEmpty() || getBox().get(0).getClass() == anotherBox.getBox().get(0).getClass()) {
            for (T fruit: getBox()) {
                anotherBox.add(fruit);
            } getBox().clear();
        } else {
                throw new BoxExeption("Нельзя мешать яблоки с апельсинами");

            }
        }
    }
