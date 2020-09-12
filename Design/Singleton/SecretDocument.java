package Design.Singleton;

public class SecretDocument {


    private static SecretDocument document;

    private SecretDocument(){
    }

    public static SecretDocument getInstance(){
        if(document == null){
            document = new SecretDocument();
        }
        
        return document;
    }

    public void printDoc() {
        System.out.println("Document is secret.");
    }

    public void main(){
        SecretDocument d = SecretDocument.getInstance();
        d.printDoc();
    }
    
}


