package ru.tsybikzhapov.hometask.lesson6;


//1. Создать классы Собака и Кот с наследованием от класса Животное.

//2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
// В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
// или высоту (для прыжков).

//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
// прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).

//4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в
// консоль. (Например, dog1.run(150); -> результат: run: true)

//5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение
// на бег может быть 400 м., у другой 600 м.

abstract class Animal {
    protected int _length;
    protected double _height;

    abstract void run(int length);
    abstract void jump(double height);

    static void showResult(Object obj, boolean result) {
        System.out.println(obj.getClass().getName() + " : " + result);
    }
}

class Cat extends Animal {
    @Override
    void run(int length) {
        boolean result = length <= 200;
        if (result) _length = length;
        showResult(this,result);
    }
    @Override
    void jump(double height) {
        boolean result = height <= 2;
        if (result) _height = height;
        showResult(this,result);
    }

}

class Dog extends Animal {
    private int _lengthSwim;
    private int maxLength;

    Dog() {
        maxLength = Math.random() > 0.5 ?  400 : 600;
    }

    int getMAxLengtx() {
        return maxLength;
    }

    void swim(int length) {
        boolean result = length <= 10;
        if (result) _lengthSwim = length;
        showResult(this,result);
    }
    @Override
    void run(int length) {
        boolean result = length <= maxLength;
        if (result) _length = length;
        showResult(this,result);
    }
    @Override
    void jump(double height) {
        boolean result = height <= 0.5;
        if (result) _height = height;
        showResult(this,result);
    }
}



public class Class6 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal cat = new Cat();

        dog.run(150);
        cat.run(5000);

        dog.jump(10);
        cat.jump(11);

        dog.swim(3);
    }
}


//дополнительное домашнее задание
// задание привести строку к нормальному ввиду


class MainClassString {
    public static void main(String[] args) {

        String str1 = " Предложение один    Теперь предложение два     Предложение три";
        System.out.println(str1);

        String str2 = str1.replaceAll(" +", " ");
        System.out.println(str2);

        StringBuilder stringBuilder = new StringBuilder();
        boolean isHaveCapitalLetter = false;

        for (int i = 1; i < str2.length(); i++) {
            if (str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Я' && i > 1) {
                stringBuilder.setCharAt(stringBuilder.length() - 1, '.');
                stringBuilder.append(' ');
                isHaveCapitalLetter = true;
            }
            stringBuilder.append(str2.charAt(i));
        }
        if (isHaveCapitalLetter) stringBuilder.append('.');


        System.out.println(stringBuilder.toString());

    }
}


