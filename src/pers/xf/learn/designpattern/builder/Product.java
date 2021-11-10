package pers.xf.learn.designpattern.builder;

public class Product {
    private String name;
    private int type;

    @Override
    public String toString() {
        return "Product: \n"
                + "\tname: " + name + "\n"
                + "\ttype: " + type + "\n";
    }

    interface IBuilder{
        Product build();
    }

    static class Builder implements IBuilder{
        private final Product product = new Product();

        @Override
        public Product build() {
            return product;
        }

        public Builder addName(String name){
            product.name = name;
            return this;
        }

        public Builder addClass(int type){
            product.type = type;
            return this;
        }
    }
}
