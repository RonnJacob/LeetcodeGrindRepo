package Design.BuilderPattern;

public abstract class Builder {

    public void buildEngine(){}
    public void buildWings(){}
    public void buildCockpit(){}
    public void buildBathrooms(){}
    public void finishConstruction(){}

    public abstract IAircraft getResult();
}
