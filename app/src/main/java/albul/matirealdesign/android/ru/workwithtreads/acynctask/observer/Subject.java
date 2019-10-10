package albul.matirealdesign.android.ru.workwithtreads.acynctask.observer;


import java.util.ArrayList;

public class Subject {

    ArrayList<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notify(Object arg){
        for (Observer observer:observers){
            observer.update(this,arg);
        }
    }

}
