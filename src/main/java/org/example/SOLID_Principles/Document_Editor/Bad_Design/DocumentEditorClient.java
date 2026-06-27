package org.example.SOLID_Principles.Document_Editor.Bad_Design;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

class DocumentEditor {
    private List<String> documentElements;
    private String renderedDocument;

    public DocumentEditor(){
        documentElements = new ArrayList<>();
        renderedDocument = "";
    }

    // add text function for documentEditor
    //add text as plain text
    public void addText(String text){
        documentElements.add(text);
    }

    //adds image path to the editor
    public void addImage(String imagePath){
        documentElements.add(imagePath);
    }

    //render the current documents in editor
    public String renderDocument(){
        if(renderedDocument.isEmpty()){
            StringBuilder result = new StringBuilder();
            for(String element  : documentElements){
                if(element.length() > 4 && (element.endsWith(".jpg") || element.endsWith(".png"))){
                    result.append("[Image ").append(element).append("]\n");
                }
                else{
                    result.append(element).append("\n");
                }
            }
            renderedDocument = result.toString();
        }
        return renderedDocument;
    }

    public void saveToFile(){
         try{
             FileWriter writer = new FileWriter("document.txt");
             writer.write(renderDocument());
             writer.close();
             System.out.println("Document saved to document.txt");
         }
         catch (Exception e){
             System.out.println("Error : unable to open file for writing");
         }
    }
}

public class DocumentEditorClient{
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();
        editor.addText("Added text to document");
        editor.addImage("Image.png");
        editor.addText("This is document editor");

        System.out.println(editor.renderDocument());
        editor.saveToFile();
    }
}
