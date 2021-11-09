package pers.xf.learn.designpattern.prototype;

import java.io.*;
import java.util.List;

public class Concrete implements Cloneable, Serializable {
    private int age;
    private String name;
    private List<String> hobbies;

    @Override
    protected Concrete clone() throws CloneNotSupportedException {
        return (Concrete) super.clone();
    }

    public Concrete deepClone() throws Exception{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Concrete) ois.readObject();
    }

    @Override
    public String toString() {
        return "Concrete{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
