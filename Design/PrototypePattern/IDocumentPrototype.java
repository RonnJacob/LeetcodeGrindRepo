package Design.PrototypePattern;

import Design.BuilderPattern.IAircraft;

public interface IDocumentPrototype {
    void printDocument();

    IDocumentPrototype clone();

    void setBody(String word);

    String getBody();
    
}
