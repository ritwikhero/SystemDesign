package org.example.SOLID_Principles.Document_Editor.Good_Design;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DocumentEditorClient {
    public static void main(String[] args) {
        Document document = new Document();
        Persistence storage = new FileStorage();

        DocumentEditor editor = new DocumentEditor(document,storage);

        // Simulate a client using the editor with common text formatting features.
        editor.addText("Hello, world!");
        editor.addNewLine();
        editor.addText("This is a real-world document editor example.");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("Indented text after a tab space.");
        editor.addNewLine();
        editor.addImage("picture.jpg");

        // Render and display the final document.
        System.out.println(editor.renderDocument());

        editor.saveDocument();
    }
}
//interface for document element
interface DocumentElement{
    public abstract String render();
}

//concrete class for textElement
class TextElement implements DocumentElement{
    private String text;

    public TextElement(String text){
        this.text = text;
    }
    @Override
    public String render(){
        return text;
    }
}

//concrete class for ImageElement
class ImageElement implements DocumentElement{
    private String imagePath;

    public ImageElement(String imagePath){
        this.imagePath = imagePath;
    }

    @Override
    public String render(){
        return "[Image: " + imagePath + "]";
    }
}

class NewLineElement implements DocumentElement{
    @Override
    public String render(){
        return "\n";
    }
}

class TabSpaceElement implements DocumentElement{
    @Override
    public String render(){
        return "\t";
    }
}

class Document{
   private List<DocumentElement> documentElements = new ArrayList<>();

    public void addElement(DocumentElement element){
        documentElements.add(element);
    }
    public String render(){
        StringBuilder sb = new StringBuilder();

        for(DocumentElement element : documentElements){
            sb.append(element.render());
        }
        return sb.toString();
    }
}

//Persistence interface
interface Persistence{
    void save(String data);
}

class FileStorage implements Persistence{
    @Override
    public void save(String data){
        try{
            FileWriter writer = new FileWriter("document1.txt");
            writer.write(data);
            writer.close();
            System.out.println("Document save successfully");
        }catch(Exception e){
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}

//class DBStorage(String data){
//    @Override
//    public void save(String data){
////        save to db
//        System.out.println("Saved to Db");
//    }
//}

class DocumentEditor{
    private Document document;
    private Persistence storage;
    private String renderedDocument = "";

    public DocumentEditor(Document document, Persistence storage){
        this.document = document;
        this.storage = storage;
    }

    public void addText(String text){
        document.addElement(new TextElement(text));
    }

    public void addImage(String imagePath){
        document.addElement(new ImageElement(imagePath));
    }

    public void addNewLine(){
        document.addElement(new NewLineElement());
    }

    public void addTabSpace(){
        document.addElement(new TabSpaceElement());
    }

    public String renderDocument(){
        if(renderedDocument.isEmpty()){
            renderedDocument = document.render();
        }
        return renderedDocument;
    }

    public void saveDocument(){
        storage.save(renderDocument());
    }
}