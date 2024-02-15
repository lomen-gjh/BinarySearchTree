package CompositionVSAggregation;
class Engine{
    int cyllinders;
    double volume;
    Engine(){
        cyllinders=4;
        volume=1.5;
    }
    Engine(int c, double v){
        cyllinders=c;
        volume=v;
    }
}
public class Car {
    Engine engine;
    AirCondition air;
    public Car(){
        engine=new Engine(); //Composition
        air=null;
    }
    public Car(int c, double v){
        engine=new Engine(c,v); //Composition
        air=new AirCondition(); //Composition?
    }
    public void EngineDetails(){
        System.out.println("Engine cyllinders:"+engine.cyllinders);
        System.out.println("Engine volume:"+engine.volume);
    }
}
