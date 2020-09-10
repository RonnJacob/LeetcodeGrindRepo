package Design.BuilderPattern.DocumentBuilder;

public class Director {

    DocumentBuilder builder;
    public Director(DocumentBuilder builder){
        this.builder = builder;
    }

    public IDocument writeNovel(String title, String subtitle, String author, String body){
        builder.addTitle(title);
        builder.addSubtitle(subtitle);
        builder.addAuthor(author);
        builder.addBody(body);
        return builder.printDocument();
    }

    public static void main(String[] args){
        System.out.println("\n Writing my novel");
        String title = "Ronn's Life";
        String subtitle = "A look into Ronn's life";
        String author = "Ronn George Jacob";
        String body = "I have no life, who are we kidding? Stop reading this.";

        Director d = new Director(new PlainDocumentBuilder());
        IDocument doc = d.writeNovel(title, subtitle, author, body);
        doc.printDocument();

    }
    
}
