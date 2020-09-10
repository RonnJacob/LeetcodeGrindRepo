package Design.BuilderPattern.DocumentBuilder;

public interface IDocument {
    void addTitle(String title);
    void addSubtitle(String subtitle);
    void addAuthor(String author);
    void addBody(String body);
    void printDocument();
}
