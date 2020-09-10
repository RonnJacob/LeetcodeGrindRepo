package Design.BuilderPattern;

public class Boeing747Builder extends Builder{

    Boeing747 flight = new Boeing747();

    @Override
    public void buildEngine(){
         flight.engineBuild();
    }
 
    @Override
    public void buildWings(){
        flight.attachWings();
    }
 
 
    @Override
    public void buildCockpit(){
        flight.cockpitBuild();
        
    }
 
 
    @Override
    public void buildBathrooms(){
         flight.bathroomBuild();
    }

    @Override
   public void finishConstruction() {
        System.out.println("Boeing 747 has been constructed");
   }

    @Override
    public IAircraft getResult(){
        return flight;
    }
    
}
