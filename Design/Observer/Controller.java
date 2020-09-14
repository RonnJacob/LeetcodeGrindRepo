package Design.Observer;

import java.util.*;
public class Controller implements ISubject{
    Collection<IObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(IObserver observer){
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer){
        System.out.println("Observer has been removed");
    }

    @Override
    public void notifyObserver(){
        for(IObserver o: observers){
            o.update(null);
        }
    }

    public void run(){
        int i=0;
        while(i<5){
            try{
                Thread.sleep(6000);
                notifyObserver();
                i++;
            }
            catch(Exception e){
                break;
            }
        }
    }
    
}
