package Design.AbstractFactoryPattern;

public class F16Factory implements IAircraftFactory{
    
    @Override
    public IEngine createEngine(){
        return new F16Engine();
    }
    
}
