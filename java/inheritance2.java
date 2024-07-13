/* Declare an interface called Property containing a method computePrice to compute
and return the price. The interface is to be implemented by following two classes i)
Bungalow and ii) Flat.
Both the classes have following data members
- name
- constructionArea
The class Bungalow has an additional data member called landArea. Define
computePrice for both classes for computing total price. Use following rules for
computing total price by summing up sub-costs:
Construction cost(for both classes):Rs.500/- per sq.feet
Additional cost ( for Flat) : Rs. 200000/-
( for Bungalow ): Rs. 200/- per sq.
feet for landArea
Land cost ( only for Bungalow ): Rs. 400/- per sq. feet
Define method main to show usage of method computePrice.
*/
interface Property {
    double computePrice();
}

class Bungalow implements Property {
    String name;
    int constructionArea, landArea, Additional;

    Bungalow(String nm, int ctrA, int lndA) {
        name = nm;
        constructionArea = ctrA;
        landArea = lndA;
        Additional = 200 * landArea;
    }

    public double computePrice() {
        double ConstCost = 500 * constructionArea;
        double LandCost = 400 * landArea;
        return ConstCost + Additional + LandCost;
    }
}

class Flat implements Property {
    String name;
    int constructionArea;
    double Additional = 200000;

    Flat(String nm, int ctrA) {
        name = nm;
        constructionArea = ctrA;
    }

    public double computePrice() {
        double ConstCost = 500 * constructionArea;
        return ConstCost + Additional;
    }

}

public class inheritance2 {

    public static void main(String args[]) {
        Bungalow b1 = new Bungalow("Hari-Darashan", 60000, 30000);
        Flat f1 = new Flat("Raghukul", 80000);
        System.out.println("Total price of Bungalow:" + b1.name + "is" + b1.computePrice());
        System.out.println("Total price of Flat:" + f1.name + "is" + f1.computePrice());
    }

}
