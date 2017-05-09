package finalir;

import finalir.DataStructure.DocumentResult;
import static finalir.IR.Print;
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class IR {

    public static void PrintR(String str){
        System.out.print(str);
    }
    
    public static void Print(String str) {
        System.out.println(str);
    }
    
    public static void Print(int t) {
        System.out.println(t);
    }

    public static void PrintErr(String str) {
        System.err.println(str);
    }
    
    public static File[] getFiles() {    
        final JFileChooser chooser = new JFileChooser(new File("src\\finalir\\testCases"));
        chooser.setMultiSelectionEnabled(true);
        chooser.setAcceptAllFileFilterUsed(false);

        File[] files = null;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            files = chooser.getSelectedFiles();
        }
        return files;
    }
        
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        //Engine.Pizza();
        Engine g = new Engine().IndexFiles(getFiles()).ComputeTF_IDF();
        
        String query;
        List<DocumentResult> res;
        int top;
        do
        {
            PrintR("google: ");
            res = g.SearchQuery(query = new Scanner(System.in).nextLine());
            
            if(res.size() == 0)
                Print("nothing found");
            
            top = 10;
            for (DocumentResult d : res)
            {
                if(top-- == 0)
                    break;
                Print(d.getDocument().getName() + " -> " + d.getRank());
            }
        } while(!query.toLowerCase().equals("x"));
    }
}
