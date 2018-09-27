package ru.tsybikzhapov.hometask.lesson7;

//1. Расширить задачу про котов и тарелки с едой
//2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
//3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
//4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
//5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
//6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Cat {
    private String name;
    private int appetite;
    private boolean fed; //Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны)
    // как мы знаем boolean default false и не будем производить инициализацию

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate plate) {
        fed = plate.decreaseFood(appetite);
    }

    public void info() {
        System.out.println(name + " " + (fed ? " сыт " : " голоден "));
    }
}

class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int appetite) {
        if (food - appetite < 0) {
         //4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
            return false;
        }
        else {
            food -= appetite;
            return true;
        }
    }

    public void info() {
        System.out.println("plate " + food);
    }

    //6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    public void addFood(int food) {
        this.food += food;
    }

}

//Дополнительное домашнее задание
class MainWindow extends JFrame {
    private String firstName;
    private String midleName;
    private String surName;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        jLabel1.setText("Имя: " + firstName);
    }

    public void setMidleName(String midleName) {
        this.midleName = midleName;
        jLabel2.setText("Отчество: " + midleName);
    }

    public void setSurName(String surName) {
        this.surName = surName;
        jLabel3.setText("Фамилия: " + surName);
    }

    public MainWindow() {

        setTitle("MainWindow");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize ( 500, 300 );
        setLocationRelativeTo ( null );

        JPanel panelTop = new JPanel(new GridLayout(3, 1,15,15));
        JPanel panelButton = new JPanel(new GridLayout(1, 2,15,15));

        jLabel1 = new JLabel("Имя: ");
        jLabel2 = new JLabel("Отчество: ");
        jLabel3 = new JLabel("Фамилия: ");

        JButton jbt1 = new JButton("Ввести данные");

        panelTop.add(jLabel1);
        panelTop.add(jLabel2);
        panelTop.add(jLabel3);

        panelButton.add(jbt1);

        add(panelTop, BorderLayout.NORTH);
        add(panelButton, BorderLayout.SOUTH);

        setVisible(true);

        jbt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow mainWindow = (MainWindow)SwingUtilities.getRoot((JButton)e.getSource());
                new EditWindow(mainWindow);
            }
        });
    }
}

class EditWindow extends JFrame {

    public EditWindow(MainWindow mainWindow ) {

        setTitle("EditWindow");
        setSize ( 400, 200 );
        setLocationRelativeTo ( null );

        JPanel panelTop = new JPanel(new GridLayout(6, 1));
        JPanel panelButton = new JPanel(new GridLayout(1, 2,15,15));

        panelTop.add(new JLabel("Введите имя: "));
        JTextField jTextField1 = new JTextField();
        panelTop.add(jTextField1);
        panelTop.add(new JLabel("Введите отчество: "));
        JTextField jTextField2 = new JTextField();
        panelTop.add(jTextField2);
        panelTop.add(new JLabel("Введите фамилию: "));
        JTextField jTextField3 = new JTextField();
        panelTop.add(jTextField3);

        JButton jbtOk = new JButton("Ok");
        JButton jbtCancel = new JButton("Cancel");

        panelButton.add(jbtOk);
        panelButton.add(jbtCancel);

        add(panelTop, BorderLayout.NORTH);
        add(panelButton, BorderLayout.SOUTH);

        setVisible(true);

        jbtOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setFirstName(jTextField1.getText());
                mainWindow.setMidleName(jTextField2.getText());
                mainWindow.setSurName(jTextField3.getText());
                Object o = e.getSource();
                if (o instanceof JComponent) {
                    JComponent component = (JComponent)o;
                    Window win = SwingUtilities.getWindowAncestor(component);
                    win.dispose();
                }
            }
        });
        jbtCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object o = e.getSource();
                if (o instanceof JComponent) {
                    JComponent component = (JComponent)o;
                    Window win = SwingUtilities.getWindowAncestor(component);
                    win.dispose();
                }
            }
        });
    }
}

public class MainClass {
    public static void main(String[] args) {
        //5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
        Cat[] cats = {
                new Cat("Barsik", 70),
                new Cat("Sharik", 25),
                new Cat("Mursik", 18),
        };
        //и тарелку с едой,
        Plate plate = new Plate(100);
        for(Cat itemCat:cats) {
            itemCat.eat(plate);
            itemCat.info();
        }


        //Допольнительное задание
        new MainWindow();
    }
}
