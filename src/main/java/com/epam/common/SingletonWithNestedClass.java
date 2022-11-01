package com.epam.common;

public class SingletonWithNestedClass implements Cloneable{

    private static SingletonWithNestedClass singletonWithNestedClass = null;

    public static synchronized SingletonWithNestedClass getInstance(){
        if(singletonWithNestedClass == null){
            return new SingletonWithNestedClass();
        }

        return singletonWithNestedClass;
    }
/*
    public class Child {
        private String childName;

        public Child(String name){
            this.childName = name;
        }

        public String getChildName() {
            return childName;
        }

        public void setChildName(String childName) {
            this.childName = childName;
        }
    }

    public static class Child1 {
        private String childName;

        public Child1(String name){
            this.childName = name;
        }

        public String getChildName() {
            return childName;
        }

        public void setChildName(String childName) {
            this.childName = childName;
        }
    }*/

    public static void main(String[] args) throws CloneNotSupportedException {
        SingletonWithNestedClass ref1 = SingletonWithNestedClass.getInstance();
        System.out.println(ref1);

        SingletonWithNestedClass ref2 = (SingletonWithNestedClass)ref1.clone();
        System.out.println(ref2);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("");
    }
}
