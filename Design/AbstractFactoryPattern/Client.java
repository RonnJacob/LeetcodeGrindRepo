package Design.AbstractFactoryPattern;
import java.util.*;

public class Client {

    public static void main(String[] args){
        IAircraftFactory f16Factory = new F16Factory();
        IEngine f16Engine = f16Factory.createEngine();
        List<IEngine> engines = new ArrayList<>();
        engines.add(f16Engine);
        engines.add(f16Engine);
        for(IEngine engine: engines){
            engine.start();
        }
    }

    
}
