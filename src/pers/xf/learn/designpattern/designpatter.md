# 原则

1. 开闭原则：对拓展开放，对修改关闭
2. 依赖倒置：依赖抽象，降低耦合
3. 单一职责：单一职责、降低耦合
4. 接口隔离：不要使用单一的总接口
5. 迪米特法则：最少知道原则
6. 里氏替换原则：子类父类可以替换，使用方法不变
7. 合成复用原则：使用组合、聚合，避免继承

# 享元模式
当对象数量太多时，将导致运行代价过高，带来性能下降等问题。享元模式正是为解决这一类问题而诞生的。
享元模式（Flyweight Pattern）又叫作轻量级模式，是对象池的一种实现。
其宗旨是共享细粒度对象，将多个对同一对象的访问集中起来，不必为每个访问者都创建一个单独的对象，
以此来降低内存的消耗，属于结构型设计模式。

享元模式把一个对象的状态分成内部状态和外部状态，内部状态是不变的，外部状态是变化的；然后通过共享
不变的部分，达到减少对象数量并节约内存的目的。享元模式的本质是缓存共享对象，降低内存消耗。

享元模式其实是工厂方法模式的一个改进机制，享元模式同样要求创建一个或一组对象，并且就是通过工厂方
法模式生成对象的，只不过享元模式为工厂方法模式增加了缓存这一功能。

优点:
- 减少对象的创建
- 减少资源占用

缺点:
- 线程安全问题
- 区分内外部状态, 内部需要为通用状态

# 建造者模式

- 构建与表示分离：使用接口规定行为，然后由具体的实现类进行构建（抽象工厂接口+具体工厂实现）。
- 创建不同的表示：也就是具备同样的行为，但是却由于构建的行为顺序不同或其他原因可以创建出
不同的表示。

从定义来看，建造者模式和工厂模式是非常相似的，和工厂模式一样，具备创建与表示分离的特性。
建造者模式唯一区别于工厂模式的是针对复杂对象的创建。
也就是说，如果创建简单对象，通常都是使用工厂模式进行创建；而如果创建复杂对象，
就可以考虑使用建造者模式。

优点：
- 封装性好，构建和表示分离
- 拓展性好，建造类独立
- 便于控制细节

缺点：
- 需要一个IBuilder接口定义
- 如果产品发生变化，则Builder也要修改

适用情况：
- 相同的方法，不同的执行顺序，产生不同的结果。
- 多个部件或零件，都可以装配到一个对象中，但是产生的结果又不相同。
- 产品类非常复杂，或者产品类中不同的调用顺序产生不同的作用。
- 初始化一个对象特别复杂，参数多，而且很多参数都具有默认值。

工厂模式只需要把对象创建出来就可以了，而建造者模式不仅要创建出对象，还要知道对象由哪些部件组成。

# 简单工厂模式

简单工厂模式的要点在于：当你需要什么，只需要传入一个正确的参数，就可以获取你所需要的对象，
而无须知道其创建细节。

优点：
- 隐藏创建细节

缺点：
- 工厂类不够灵活，拓展时需要修改原有代码
- 产品较多时，工厂类代码臃肿

适用情况：
- 工厂类负责创建的对象比较少；
- 客户端只知道传入工厂类的参数，对于如何创建对象不关心。

# 工厂方法模式

由具体工厂类来决定初始化哪一个具体产品。
某具体产品由专门的具体工厂创建，它们之间往往一一对应。
- 抽象工厂接口
- 具体工厂
- 抽象产品接口
- 具体产品

优点：
- 隐藏创建细节
- 便于拓展
- 解耦框架。高层模块只需要知道产品的抽象类，无须关心其他实现类，满足迪米特法则、依赖倒置原则和里氏替换原则。

缺点：
- 需要创建更多的类，增加系统复杂性
- 抽象产品只能生产一种产品，此弊端可使用抽象工厂模式解决

适用情况：
- 客户端只知道传入工厂类的参数，对于如何创建对象不关心
- 需要对产品类进行拓展的情况

# 原型模式

不是通过new关键字而是通过对象复制来实现创建对象的模式被称作原型模式。Java中提供了Cloneable接口作为抽象原型接口。

原型模式的核心在于复制原型对象。以系统中已存在的一个对象为原型，直接基于内存二进制流进行复制，不需要再经历耗时的对象初始化过程（不调用构造函数），性能提升许多。

Java提供Cloneable接口，为了在运行时通知Java虚拟机可以安全地在该类上使用clone()方法。而如果该类没有实现 Cloneable接口，则调用clone()方法会抛出 CloneNotSupportedException异常。一般情况下，如果使用clone()方法，则需满足以下条件。
- 对任何对象o，都有o.clone() != o。换言之，克隆对象与原型对象不是同一个对象。
- 对任何对象o，都有o.clone().getClass() == o.getClass()。换言之，克隆对象与原型对象的类型一样。
- 如果对象o的equals()方法定义恰当，则o.clone().equals(o)应当成立。

clone()的方式是浅拷贝。为了使用深拷贝通常使用序列化的方式。

优点：
- 基于二进制流的对象复制比new更快
- 可以保存对象状态

缺点：
- 每个类都要配置一个clone方法
- clone方法位于类的内部，当对已有类进行改造的时候，需要修改代码，违背了开闭原则
- 当实现深克隆时，需要编写较为复杂的代码，而且当对象之间存在多重嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来会比较麻烦

适用情况：
- 创建对象成本较大（例如，初始化时间长，占用CPU太多，或者占用网络资源太多等），需要优化资源
- 创建一个对象需要烦琐的数据准备或访问权限等，需要提高性能或者提高安全性
- 系统中大量使用该类对象，且各个调用者都需要给它的属性重新赋值
