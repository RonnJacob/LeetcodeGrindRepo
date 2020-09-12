package Design.PrototypePattern;

public class Client {
    public static void main(String[] args){
        IDocumentPrototype prototype = new Document();

        IDocumentPrototype doc1 = prototype.clone();
        doc1.setBody("Document 1 text");
        System.out.println(doc1.getBody());

        
        IDocumentPrototype doc2 = prototype.clone();
        doc2.setBody("Document 2 text");
        System.out.println(doc2.getBody());

        // This ensures that we don't create a lot of classes ike doc1 or doc2 and just use a prototype of the existing class
        // to save object creation costs.

        
    }
    
}
