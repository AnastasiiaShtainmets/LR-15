package com.company;

public class Main {

    public static void main(String[] args) {
        clothes []clothes={
                new Pants(Size.XXS,"черный",15000),
                new Pants(Size.XS,"белый",4000),
                new Skirt(Size.S,"коричневый",8000),
                new Tie(Size.L,"розовый",3000),
                new TeeShirt(Size.M,"жёлтый",7000),

        };
        for (int i = 0; i< clothes.length; i++) {
            System.out.println("Размер: " + clothes[i].size);
            System.out.println("Цвет: " + clothes[i].color);
            System.out.println("Цена: " + clothes[i].price);
            System.out.println(" ");
        }
    }

}
enum Size {
    XXS(28) {
        @Override
        public String getDescription() {
            return "детский";
        }
    },
    XS(38),
    S(36),
    M(34),
    L(32);

    Size(int euroSize) {
        EuroSize = euroSize;
    }

    public String getDescription() {
        return "взрослый";
    }

    @Override
    public String toString() {
        return name() + "(" + EuroSize + ") " + getDescription();
    }

    private int EuroSize;
}
interface mensClothing{
    static void dressMens() {
        System.out.println("Одеваем мужчину");
    }
}
interface womensClothing{
    static void dressWomen(){
        System.out.println("Одеваем женщину");
    }
}
abstract class clothes{
    Size size;
    String color;
    int price;

    public clothes(Size size,String color,int price){
        this.size=size;
        this.color=color;
        this.price=price;
    }
}
class TeeShirt extends clothes implements mensClothing,womensClothing{
    public TeeShirt(Size size, String color,int price) {
        super(size, color,price);
    }
}
class Pants extends clothes implements mensClothing,womensClothing {
    public Pants(Size size, String color, int price) {
        super(size, color, price);
    }
}
class Skirt extends clothes implements  womensClothing {
    public Skirt(Size size, String color, int price) {
        super(size, color, price);
    }
}
class Tie extends clothes implements mensClothing{
    public Tie(Size size, String color,int price) {
        super(size, color,price);
    }
}
class Atelier {
    public void dressMens(clothes[] clothes){
        System.out.println("Мужская одежда в наличии: ");
        for (clothes clothes1:clothes){
            if (clothes1 instanceof mensClothing){
                System.out.println(clothes1);
            }
        }
    }
    public void dressWomen(clothes[]clothes){
        System.out.println("Женская одежда в наличии: ");
        for (clothes clothes1 : clothes){
            if (clothes1 instanceof womensClothing){
                System.out.println(clothes1);
            }
        }
    }
}