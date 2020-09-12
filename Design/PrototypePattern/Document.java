package Design.PrototypePattern;

public class Document implements IDocumentPrototype{
    String body = "";

    @Override
    public void printDocument(){  
        System.out.println(body);
    }

    @Override
    public IDocumentPrototype clone(){
        return new Document();
    }

    @Override
    public void setBody(String body){
        this.body = body;
    }

    @Override
    public String getBody(){
        return this.body;
    }
    
}
