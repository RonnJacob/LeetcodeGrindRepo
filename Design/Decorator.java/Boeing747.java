package Design.Decorator.java;

public class Boeing747 implements IAircraft{

    int weight = 100;
    
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
        return this.weight;
    }
}
