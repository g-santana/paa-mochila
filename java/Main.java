import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        List<Item> itens = new ArrayList<Item>();
        itens.add(new Item(11,4));
        itens.add(new Item(2,2));
        itens.add(new Item(1,1));
        itens.add(new Item(4,10));
        itens.add(new Item(1,2));
        int mochila = 15;
        guloso(itens, mochila);
    }

    private static void guloso(List<Item> itens, int mochila){
        List<Item> ordenados = (List<Item>) itens.stream().sorted(Comparator.comparing(Item::getRazaoVP).reversed()).collect(Collectors.toList());

        int pesoTotal = 0;
        int valorTotal = 0;

        for (Item i : ordenados) {
            if(i.getPeso() <= mochila){
                pesoTotal += i.getPeso();
                valorTotal += i.getValor();
                mochila -= i.getPeso();
            }
        }

        System.out.println("Peso total: " + pesoTotal + "\nValor total: " + valorTotal);
    }

}