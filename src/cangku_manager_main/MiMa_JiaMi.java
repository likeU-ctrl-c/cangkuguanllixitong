package cangku_manager_main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MiMa_JiaMi {

	      
	    public String eccrypt(String info){  
	        MessageDigest md5;
	        String MiWen=null;
			try {
				md5 = MessageDigest.getInstance("SHA");
				byte[] srcBytes = info.getBytes();  
		        //ʹ��srcBytes����ժҪ  
		        md5.update(srcBytes);  
		        //��ɹ�ϣ���㣬�õ�result  
		        byte[] resultBytes = md5.digest();  
		       MiWen = new String (resultBytes);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        
	        
	        return MiWen;  
	    }  
	  
	  
	    public static void main(String[] args) throws NoSuchAlgorithmException {  
	        String msg = "6549877";  
	        MiMa_JiaMi mima = new MiMa_JiaMi();
	        String resultBytes = mima.eccrypt(msg);
	        System.out.println("�����ǣ�" + msg);  
	        System.out.println("�����ǣ�" + resultBytes);  
	          
	    }  
	 

}
