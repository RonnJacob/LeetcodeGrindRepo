package Design.BuilderPattern.DocumentBuilder;

public abstract class DocumentBuilder {

    public void addTitle(String title){}
    public void addSubtitle(String subtitle){}
    public void addAuthor(String author){}
    public void addBody(String body){}
    
    
    public abstract IDocument printDocument();
    
}
