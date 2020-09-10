package Design.BuilderPattern.DocumentBuilder;

public class PlainDocument implements IDocument{
    String title;
    String subtitle;
    String author;
    String body;

    public void addTitle(String title){
        this.title = "Title: " + title;
    }

    public void addSubtitle(String subtitle){
        this.subtitle = "Subtitle: " + subtitle;
    }

    public void addAuthor(String author){
        this.author = "Author: " + author;
    }

    public void addBody(String body){
        this.body = "Body: " + body;
    }

    public void printDocument(){
        StringBuilder sb = new StringBuilder("");
        sb.append(title + "\n" + subtitle + "\n" + author + "\n" + body+"\n");
        System.out.println(sb.toString());
    }
    
}
