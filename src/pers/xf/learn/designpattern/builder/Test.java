package pers.xf.learn.designpattern.builder;

public class Test {
    public static void main(String[] args) {
        /*
        * 因为Builder是内部类，所以要通过Product访问，
        * 所以需要是static。
        * interface默认就是static的。
        *
        * 最后的build返回的是Product，
        * 中间add的过程返回的是Builder，
        * 在Builder中操作的是private的实例Product。
        *
        * add过程中返回的只能是具体的Builder类型，
        * 因为接口只规范了build行为，如果规范add行为，
        * 那么接口就依赖于具体的Product。
        * */
        Product product =
            new Product.Builder()
                .addClass(1)
                .addName("pro")
                .build();
        System.out.println(product);
    }
}
