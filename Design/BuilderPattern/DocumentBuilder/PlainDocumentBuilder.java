package Design.BuilderPattern.DocumentBuilder;

public class PlainDocumentBuilder extends DocumentBuilder{
    IDocument pDocument = new PlainDocument();
    @Override
    public void addTitle(String title){
        pDocument.addTitle(title);
    }

    @Override
    public void addSubtitle(String subtitle){
        pDocument.addSubtitle(subtitle);
    }
    @Override
    public void addAuthor(String author){
        pDocument.addAuthor(author);
    }
    @Override
    public void addBody(String body){
        pDocument.addBody(body);
    }

    @Override
    public IDocument printDocument(){
        return pDocument;
    }
}
