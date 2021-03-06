package finalir.DataStructure;

import java.util.ArrayList;

public class DocumentTermEntry {
    private String term;
    private Document document;
    private ArrayList<Observation> observation;
    private double tfidf;
    
    public DocumentTermEntry(Document doc,String trm) {
        observation = new ArrayList<>();
        document = doc;
        term = trm;
    }

    public void setTfIDF(double d){
        tfidf = d;
    }
    
    public double getTfIDF(){
        return tfidf;
    }
    
    public int getDocumentMaxTf(){
        return document.getMaxTF();
    }
    
    public int getDocumentSize(){
        return document.getLength();
    }
    
    public String getTerm(){
        return term;
    }
    
    public DocumentTermEntry Add(int position,int exactPosition, TermType t) {        
        //observation.add(getIndexToAddSorted(position), new Observation(position,exactPosition, t)); // add sorted
        observation.add(new Observation(position,exactPosition, t));  // ignore the sorting for now
        document.addDocumentTermEntry(this);
        upadteDocumentMaxTF();
        return this;
    }
    
    private int getIndexToAddSorted(int value){
        int i = 0; 
        while(i < observation.size() && observation.get(i).getPosition() < value)
            i++;
        return i;
    }
    
    private void upadteDocumentMaxTF(){
        if(observation.size() > document.getMaxTF())
            document.setMaxTF(observation.size());
    }
    
    public double getTf(){
        double d = 0.0;
        for (Observation b : observation)
            d += b.getTypeWeight();
        return d;
    }
    
    public double getFrequency(){
        return observation.size() * (1.0 / document.getLength());
    }
    
    public Document getDocument(){
        return document;
    }
    
    public int getDistance(DocumentTermEntry d, int target){

        for (Observation p1 : observation) 
            for (Observation p2 : d.observation) 
                if( Math.abs(p1.getPosition() - p2.getPosition()) <= target)
                    return target;
        return Integer.MAX_VALUE;
    }

    public boolean equals(DocumentTermEntry b){
        return document.getName().equals(b.document.getName());
    }
    
    public boolean checkTermType(TermType t){
        for (Observation o : observation)
            if(o.getType() == t)
                return true;
        return false;
    }
    
    public int getFirstPosition(){
        if(observation == null || observation.get(0) == null)
            return -1;
        
        return observation.get(0).getExactPosition();
    }
}
