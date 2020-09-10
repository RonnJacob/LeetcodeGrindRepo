package Design.BuilderPattern;

public class Main {

    static Builder flightBuilder;

    public Main(Builder fb){
        flightBuilder = fb;
    }

    public void construct(){
        flightBuilder.buildCockpit();
        flightBuilder.buildEngine();
        flightBuilder.buildWings();
        flightBuilder.buildBathrooms();
        flightBuilder.finishConstruction();
    }
    public static void main(String[] args){
        F16Builder b = new F16Builder();
        Main build = new Main(b);
        build.construct();
    }
    
}
