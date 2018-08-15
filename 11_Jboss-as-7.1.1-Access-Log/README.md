# Tips #11
Solution to add access log like apache's to JBOSS AS 7.1.1.

Here i'm printing the headers with the name Authorization, permissoes and PERMISSOES,  Method Called , Request Method and Request URL path, Bytes Sent and HTTP Status code..        

Ex:
##Add on standalone.xml - virtual-server

                <access-log pattern="%{Authorization}i %{permissoes}i %{PERMISSOES}i %{Referer}i %m %U %b %s">
                    <directory path="."/>


	Output LOG:
	- - - https://abcd.com/system/ POST /system/service/proxy 3007 200
	
	
	##Options to add:
		%A– Local IP address
		%b– Bytes sent, excluding HTTP headers, or - if zero
		%B– Bytes sent, excluding HTTP headers
		%h– Remote hostname (or IP address if resolveHostsis false)
		%H– Request protocol
		%l– Remote logical username from identd (always returns -)
		%m– Request method (GET, POST, PUT, DELETE, ...)
		%p– Local port on which this request was received
		%q– Query string (with a before ‘?’ if it exists)
		%r– First line of the request (method and request URI)
		%s– HTTP status code of the response
		%S– User session ID
		%t– Date and time, in Common Log Format
		%u– Remote user that was authenticated (if any), else -
		%U– Requested URL path
		%v– Local server name
		%D– Time is taken to process the request, in MilliSeconds
		%T– Time is taken to process the request, in Seconds
		%I– current request thread name 
		
All credits to: https://geekflare.com/jboss-7-access-log-configuration/.