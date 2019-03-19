package test2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class SortResult 
{	
	//按字典输出
	public void Sort(Map<String, Integer> Map){  
		
        Set<Entry<String,Integer>> map = Map.entrySet();    
        LinkedList<Entry<String, Integer>> List = new LinkedList<Entry<String,Integer>>(map);
        
        //排序
        Collections.sort(List, new Comparator<Entry<String,Integer>>() {  
            @Override  
            public int compare(Entry<String, Integer> wk1,  Entry<String, Integer> wk2) {
                return wk1.getKey().compareTo(wk2.getKey());  
            }  
        }); 
        
        Map<String,Integer> MapNew = new LinkedHashMap<String, Integer>();  
        for(Entry<String,Integer> entry: List) {  
            MapNew.put(entry.getKey(), entry.getValue());  
        }  
        
        File file = new File("src/result.txt");
        try {
        	if(file.exists()) {
        		file.createNewFile();
        	}
        	FileWriter ref = new FileWriter(file.getAbsoluteFile());
        	for(Entry<String,Integer> entry : MapNew.entrySet()) {
        		ref.write(entry.getKey()+":"+entry.getValue()+"\n");
        	}
        	ref.close();
        }catch(IOException e) {
        	e.printStackTrace();
        }
	} 
}
