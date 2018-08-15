import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @author jackson
 * @date 16/06/2015
 */



public class RequestUtils {


    private RequestUtils(){
        super();
    }
    
    static {
	    //Remember - for local testing only
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
	
	//If needs to disable cert check on a server(not localhost) - just call this function after openConnection
	 public static void disableSSLCertificateChecking() 
    {
        TrustManager[] trustAllCerts = new TrustManager[] 
        { 
            new    X509TrustManager() 
            {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                @Override
                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    // Not implemented
                }
                @Override
                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    // Not implemented
                }            
            } 
    
        };
 
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new
            java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (KeyManagementException e) {
                e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
        }    
 
    }   
	
	
	
    private static String sendPost(String url, String urlParameters, String basicAuth) {
        URL urlURI = null;
        try {
         urlURI = new URL(url);
        } catch (MalformedURLException e) {
         
         e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
         connection = (HttpURLConnection) urlURI.openConnection();
		 //disableSSLCertificateChecking();
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
              
               e.printStackTrace();
               return "";
         }
        }
    
        public static String sendGet(String url) {
         try {
        	 	               
               URL obj = new URL(url);
               HttpsURLConnection connection = (HttpsURLConnection)
               obj.openConnection();     
			   //disableSSLCertificateChecking();			   
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


