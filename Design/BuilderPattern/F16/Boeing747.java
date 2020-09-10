package Design.BuilderPattern;

public class Boeing747 implements IAircraft{

    private boolean wings;
    private boolean bathroom;
    private int engine;
    private boolean cockpit;

    public Boeing747(){
        this.wings = false;
        this.bathroom = false;
        this.engine = 0;
        this.cockpit = false;
    }

    public void attachWings(){
        this.wings = true;
    }

    public void engineBuild(){
        this.engine = 4;
    }
    public void bathroomBuild(){
        this.bathroom = true;
    }

    public void cockpitBuild(){
        this.cockpit = true;
    }

    public boolean getWings(){
        return this.wings;
    }

    public int getEngine(){
        return this.engine;
    }

    public boolean getBathrooms(){
        return this.bathroom;
    }

    public boolean getCockpit(){
        return this.cockpit;
    }


    public void fly(){
        System.out.println("Boeing 747 is flying");
    }
    
}
