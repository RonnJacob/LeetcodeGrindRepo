package Design.BuilderPattern;

public class F16Builder extends Builder{

    F16 flight = new F16();

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
        System.out.println("F16 has been constructed");
   }

    @Override
    public IAircraft getResult(){
        return flight;
    }
}
