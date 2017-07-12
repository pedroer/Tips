import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class RequestUtils {


    private RequestUtils(){
        super();
    }
    
    static {
	    //Remember - for testing only
	    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
	    new javax.net.ssl.HostnameVerifier(){

	        public boolean verify(String hostname,
	                javax.net.ssl.SSLSession sslSession) {
	            if (hostname.equals("subdomain.test.com")||hostname.equals("subdomain.otherTeste.com")) {
	                return true;
	            }
	            return false;
	        }
	    });
	} 

    private static String sendPost(String url, String urlParameters, String basicAuth) {
        URL urlURI = null;
        try {
         urlURI = new URL(url);
        } catch (MalformedURLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
         connection = (HttpURLConnection) urlURI.openConnection();
         connection.setRequestMethod("POST");
         if (basicAuth != "") {
               connection.setRequestProperty("Authorization",
                basicAuth);
               connection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded;charset=UTF-8;");
               connection.setRequestProperty("Content-Length", "" +
                Integer.toString(urlParameters.getBytes().length));
               connection.setUseCaches(false);
               connection.setDoInput(true);
               connection.setDoOutput(true);
               connection.setInstanceFollowRedirects(false);
         }
         } catch (IOException e) {
               
               e.printStackTrace();
         }
         DataOutputStream wr;
         try {
               wr = new DataOutputStream(connection.getOutputStream());
               if (urlParameters != "") {
                wr.writeBytes(urlParameters);
                wr.flush();
               }
               BufferedReader rd = new BufferedReader(new

                InputStreamReader(connection.getInputStream()));
               String line;
               StringBuffer result = new StringBuffer();
               while ((line = rd.readLine()) != null) {
                result.append(line);
               }
               wr.close();
               connection.disconnect();
               return result.toString();
         } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
               return "";
         }
        }
    
        public static String sendGet(String url) {
         try {
        	 	               
               URL obj = new URL(url);
               HttpsURLConnection connection = (HttpsURLConnection)
               obj.openConnection();               
               connection.setRequestMethod("GET");
               int responseCode = connection.getResponseCode();
               System.out.println("Response Code : " + responseCode);
               BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
               String inputLine;
               StringBuffer response = new StringBuffer();
               while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
               } in .close();
               //print result
               return response.toString();
         } catch (IOException e) {               
               e.printStackTrace();
         }
         return "";
        }

}


