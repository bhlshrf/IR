package finalir;

import edu.stanford.nlp.ling.CoreLabel;
import static java.lang.Math.sqrt;
import java.util.*;

public class Indexer {

    public float[][] frequencyMatrix;
    public float[][] vectors;

    Vector<String> Documents = new Vector<>();
    Vector<String> corpus = new Vector<>();

    float[] query;

    int[] dfi;

    public TreeMap result = new TreeMap();

    public Indexer() {
        this.frequencyMatrix = new float[100][100000];
        this.vectors = new float[100][100000];
    }

    public void indexingQuery(List<CoreLabel> tokens) {
        query = new float[corpus.size()];

        for (CoreLabel coreLabel : tokens)
            if (corpus.contains(coreLabel.lemma().toLowerCase()))
                query[corpus.indexOf(coreLabel.lemma().toLowerCase())] = (float) (1.0 / tokens.size());

        /////////////////////////////////Query: Appling tf-idf /////////////////
        float maxFrequencyInQuery = 0;

        for (int j = 0; j < query.length; j++)
            if (query[j] > maxFrequencyInQuery)
                maxFrequencyInQuery = query[j];

        for (int j = 0; j < query.length; j++)
            query[j] = (float) ((0.5 + 0.5 * (query[j] / maxFrequencyInQuery)) * (Math.log(Documents.size() / dfi[j])));
        ///////////////////////////////////////////////////////
    }

    public void indexingDoc(List<CoreLabel> tokens, String filename) {
        int document_id = addNewDocument(filename);
        
        for (CoreLabel word : tokens) {
            int word_id = insertIntoCorpus(word.lemma());
            frequencyMatrix[document_id][word_id] += (1.0 / tokens.size());
        }
    }

    public int insertIntoCorpus(String lemma) {

        if (!corpus.contains(lemma.toLowerCase())) {
            corpus.add(lemma.toLowerCase());
            //   Collections.sort(corpus);
        }
        return corpus.indexOf(lemma.toLowerCase());
    }

    public int addNewDocument(String filename) {

        if (!Documents.contains(filename)) {
            Documents.add(filename);
            Collections.sort(Documents);
        }

        return Documents.indexOf(filename);
    }

    public void printFrequencyMatrix() {
        // frequencyMatrix=new int[Documents.size()][corpus.size()];
        for (String string : corpus) {
            System.out.print(string);
            int length = 17 - string.length();
            for (int k = 0; k < (length); k++) {
                System.out.print(" ");
            }
        }

        for (int i = 0; i < Documents.size(); i++) {

            for (int j = 0; j < corpus.size(); j++) {
                System.out.print(frequencyMatrix[i][j]);
                int length = 17;
                String s = String.valueOf(frequencyMatrix[i][j]);

                length = 17 - s.length();

                for (int k = 0; k < (length); k++) {
                    System.out.print(" ");
                }
            }
            IR.Print(Documents.get(i) + "  ");
        }

    }

    public void printWightMatrix() {
        for (String string : corpus) {
            System.out.print(string);
            int length = 17 - string.length();
            for (int k = 0; k < (length); k++) {
                System.out.print(" ");
            }
        }

        for (int i = 0; i < Documents.size(); i++) {

            for (int j = 0; j < corpus.size(); j++) {
                System.out.print(vectors[i][j]);
                int length = 17;
                String s = String.valueOf(vectors[i][j]);

                length = 17 - s.length();

                for (int k = 0; k < (length); k++) {
                    System.out.print(" ");
                }
            }
            IR.Print(Documents.get(i) + "  ");
        }

    }

    List<String> match(String similarityFunction) {

        result.clear();
        for (int i = 0; i < Documents.size(); i++) 
        {
            float sim = 0;
            if (similarityFunction == "cos")
                sim = cosine(query, vectors[i]);
            else if (similarityFunction == "inner")
                sim = dot(query, vectors[i]);

            result.put(sim, Documents.get(i));
        }
        
        List<String> l = new Vector<>();

        Map.Entry m = result.lastEntry();
        for (int k = 0; k < result.size(); k++) 
        {
            l.add(m.getValue().toString());
            IR.Print(m.getValue() + " => " + m.getKey());
            m = result.lowerEntry(m.getKey());
        }
        return l;
    }

    public float cosine(float[] vector1, float[] vector2) {
        float t1 = dot(vector1, vector2);
        float t2 = normF(vector1) * normF(vector2);
        float cos;
        if (t2 > 0)
            cos = t1 / t2;
         else
            cos = 0;
        
        return cos;
    }

    public float dot(float[] v1, float[] v2) {
        if (v1 != null && v2 != null) //&& v1.length == v2.length) 
        {
            float score = 0;
            for (int i = 0; i < v1.length; i++)
                score += v1[i] * v2[i];
            
            return score;
        }
        
        IR.Print("vectores doesn't have same length");
        return 0;
    }

    public float normF(float[] vector) {
        float result = 0;
        for (float f : vector)
            result += f * f;
        
        return (float) sqrt(result);
    }

    void printResults() {

        Map.Entry m = result.lastEntry();
        // l.add(m.getValue().toString());

        for (int k = 0; k < result.size(); k++) {
            IR.Print(m.getValue() + " => " + m.getKey());
            m = result.lowerEntry(m.getKey());
        }
    }

    public void applyTf_Idf() {

        float[] maxFrequencyInDoc = new float[frequencyMatrix.length];
        dfi = new int[corpus.size()];

        for (int i = 0; i < frequencyMatrix.length; i++) {

            for (int j = 0; j < corpus.size(); j++) {

                if (frequencyMatrix[i][j] > maxFrequencyInDoc[i]) {
                    maxFrequencyInDoc[i] = frequencyMatrix[i][j];
                }
                if (frequencyMatrix[i][j] > 0) {
                    dfi[j]++;
                }
            }
        }

        //////////////////////////////////////////////////////////
        
        for (int i = 0; i < frequencyMatrix.length; i++) {

            for (int j = 0; j < corpus.size(); j++) {

                vectors[i][j] = (float) ((frequencyMatrix[i][j] / maxFrequencyInDoc[i]) * (Math.log(Documents.size() / dfi[j])));
                // vectors[i][j]=(float) ((1+Math.log(frequencyMatrix[i][j]/maxFrequencyInDoc[i]))*(Math.log10(Documents.size()/dfi[j])));
            }
        }
    }
}