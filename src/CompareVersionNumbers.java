
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        
        if(version1.equals(version2))  
         return 0;  
           
     int fversion1 , fversion2;  
     String sversion1,sversion2;  
     if(version1.contains(".")){  
         int pos = version1.indexOf(".");  
         fversion1 = Integer.valueOf(version1.substring(0,pos));  
         sversion1 = version1.substring(pos+1,version1.length());  
     }  
     else {  
         fversion1 = Integer.valueOf(version1);  
         sversion1 = "0";  
     }  
       
     if(version2.contains(".")){  
         int pos = version2.indexOf(".");  
         fversion2 = Integer.valueOf(version2.substring(0,pos));  
         sversion2 = version2.substring(pos+1,version2.length());  
     }  
     else {  
         fversion2 = Integer.valueOf(version2);  
         sversion2 = "0";  
     }  
       
     if(fversion1 > fversion2)  
         return 1;  
     else if(fversion1 < fversion2)  
         return -1;  
     else return compareVersion(sversion1, sversion2);  
     }
}
