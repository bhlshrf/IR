package finalir.DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Document {
    private Map<String,DocumentTermEntry> docTermEntry;
    private int id;
    private String name;
    private int length;

    public int maxTF = 0;
    
    private static int counter = 0;
    
    public Document(String name, int length) {
        this.id = counter++; 
        this.name = name;
        this.length = length;
        docTermEntry = new HashMap<>();
    }
    
    public Document addDocumentTermEntry(DocumentTermEntry d){
        docTermEntry.put(d.getTerm(),d);
        return this;
    }
    
    public List<DocumentTermEntry> getDocumentTermEntryList(){
        return new ArrayList<>(docTermEntry.values());
    }
    
    public boolean Contains(String t){
        return docTermEntry.containsKey(t);
    }
    
    public DocumentTermEntry getDocTermEntry(String t){
        return docTermEntry.get(t);
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getLength(){
        return length;
    }
    
    public Document setMaxTF(int newTf){
        maxTF = newTf;
        return this;
    }
    
    public int getMaxTF(){
        return maxTF;
    }
    
    
        
    public int compareWith(Document d){
        return Math.abs(id - d.id);
    }
    
    public static List<Document> convert(List<DocumentTermEntry> dte){
        List<Document> doc = new ArrayList<>();
        dte.forEach(d -> doc.add(d.getDocument()));
        return doc;
    }
}