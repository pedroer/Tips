# Tips #4
Solution to bad request (Error 400) on Jboss As 7.1.1 Requests. The problem here was big HEADERS that exceed the default jboss max size, something about 8kb.
The solution was to increment the header max size for jboss using the file "standalone.conf" and the parameter "-Dorg.apache.coyote.http11.Http11Protocol.MAX_HEADER_SIZE=DESIRED_VALUE" to the JAVA_OPTS.
