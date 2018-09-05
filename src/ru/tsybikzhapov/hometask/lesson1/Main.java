package ru.tsybikzhapov.hometask.lesson1;

public class Main {

    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {

        //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte b = 127;
        System.out.println("b = " + b);

        int i = 200;
        System.out.println("i = " + i);

        long l;
        l = 98585846686895584L;
        System.out.println("l = " + l);

        float f = 98585846686.84F;
        System.out.println("f = " + f);

        double d = 98585846686.84;
        System.out.println("d = " + d);

        boolean bool = true;
        System.out.println("bool = " + bool);

        String s = "строка";
        System.out.println("s = " + s);

        char c = 'g';
        System.out.println("c= " + c);

        //Посмотри на результат третьего задания
        System.out.println("calculate = " + calculate(1,2,3,4));

        //Проверим результат четвертого задания
        System.out.println("checkSumFrom10to20 = " + checkSumFrom10to20(6,9));

        //Проверим результат пятого задания
        System.out.println("Проверка пятого задания");
        checkPositiveNimbler(0);

        //Проверим результат шестого задания
        System.out.println("Проверка пятого задания");
        checkNegativeNumber(-19);

        //Проверим результат седьмого задания
        System.out.println("Проверка седьмого задания");
        printHello("Владимир");

        //Проверим результат восьмого задания
        System.out.println("Проверка восьмого задания");
        checkPrintLeapYear(2018);
    }

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – входные параметры этого метода;
    private static double calculate(int a, int b, int c, int d) {
        if(d!=0) return a * (b + (double)(c / d));
        throw new java.lang.Error("деление на ноль");
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в
    //пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    private static boolean checkSumFrom10to20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен
    //напечатать в консоль положительное ли число передали, или отрицательное; Замечание:
    //ноль считаем положительным числом.
    private static void checkPositiveNimbler(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //6. Написать метод, которому в качестве параметра передается целое число, метод должен
    //вернуть true, если число отрицательное;
    private static boolean checkNegativeNumber(int a) {
        return a < 0;
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    //метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    private static void printHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    //8. *Написать метод, который определяет является ли год високосным, и выводит сообщение в
    //консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й –
    //високосный.
    private static void checkPrintLeapYear(int year) {
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            System.out.println("Год " + year + " является високосным");
        else
            System.out.println("Год " + year + " не является високосным");
    }
}
