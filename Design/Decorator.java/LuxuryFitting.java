package Design.Decorator.java;

public class LuxuryFitting extends Decorator{
    IAircraft boeing747;

    public LuxuryFitting(IAircraft a){
        this.boeing747 = a;
    }
    
    @Override
    public void fly(){
        System.out.println("Boeing 747 is flying.")
    }

    @Override
    public void land(){
        System.out.println("Boeing 747 is landing.")
    }
    
    @Override
    public int getWeight(){
        return 30 + this.boeing747.getWeight();
    }
}
