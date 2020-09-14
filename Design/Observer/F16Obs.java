package Design.Observer;

import Design.BuilderPattern.IAircraft;

public class F16Obs implements IObserver, IAircraft{

    ISubject observable;

    public F16Obs(ISubject observable){
        this.observable = observable;
    }


    @Override
    public void addObserver(IObserver observer){
        this.observable.add(observer);
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


    @Override
    public void update(Object newState){
        return;
    }
}
