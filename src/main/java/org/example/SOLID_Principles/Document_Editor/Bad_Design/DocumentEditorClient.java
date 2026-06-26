package org.example.SOLID_Principles.Document_Editor.Bad_Design;

import java.util.ArrayList;
import java.util.List;

public class DocumentEditorClient {
    private List<String> documentElements;
    private String renderedDocument;

    public DocumentEditorClient(){
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

        }
    }
}
