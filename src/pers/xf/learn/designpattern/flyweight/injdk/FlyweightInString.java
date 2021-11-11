package pers.xf.learn.designpattern.flyweight.injdk;

public class FlyweightInString {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "he" + "llo";
        String s4 = "hel" + new String("lo");
        String s5 = new String("hello");
        String s6 = s5.intern();
        String s7 = "h";
        String s8 = "ello";
        String s9 = s7+s8;

        System.out.println(s1==s2); // true     字面量->常量池
        System.out.println(s1==s3); // true     s3编译期优化. 字面量->常量池
        System.out.println(s1==s4); // false    生成了字面量"lo"和new String("lo"). 两个对象相加, 结果在堆中.
        System.out.println(s1==s6); // true     intern使堆中的字符串在运行期间动态的加入常量池.
                                    //              如果字符串常量池中有该对象对应的字面量，则返回该字面量在字符串常量池中的引用；
                                    //              否则，复制一份该字面量到字符串常量池并返回它的引用
        System.out.println(s1==s9); // false    s9使用StringBuilder相加, 得到一个对象
        System.out.println(s4==s5); // false    堆中的两个对象, 内存地址不相等.
    }
}
