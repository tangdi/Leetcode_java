import java.util.ArrayList;
import java.util.List;


public class RestoreIPAddress {
	 List<String> result = new ArrayList<String>();
	 public List<String> restoreIpAddresses(String s) {
		 if(s == null || s.length() == 0){
			 return result;
		 }
		 String ip = "";
		 partitionIP(s, 0, ip, 0);
		 return result;
	 }
	 
	 public void partitionIP(String s, int s_start, String ip, int col){
		 if(s_start >= s.length()){
			 return;
		 }
		 if(s.charAt(s_start) == '0' && col <3){
			 partitionIP(s, s_start+1, ip.length() == 0? "0": ip + ".0", col +1);
			 return;
		 }
		 
		 if(col ==3){
			 String rest = s.substring(s_start);
			 if(rest.length() > 1 && s.charAt(s_start) == '0'){
				 return;
			 }
			 
			 if(Double.valueOf(rest) > 255){
				 return;
			 }
			 
			 result.add(ip + "." + rest);
			 return;
		 }
		 
		 int value = 0;
		 for(int i =s_start; i <= s_start +2 ;i++){
			 if(i >= s.length()){
				 break;
			 }
			 value = value * 10 + s.charAt(i) - '0';
			 if(value <= 255){
				
				 partitionIP(s, i+1, ip.length() ==0 ? s.substring(s_start, i+1):ip + "." + s.substring(s_start, i+1), col+1);
			 }
		 }
		 
	 }
	 public static void main(String[] args) {
		 RestoreIPAddress s1 = new RestoreIPAddress();
		 String s = "0000";
		 System.out.println(s1.restoreIpAddresses(s));
	}
	 
	 
}
