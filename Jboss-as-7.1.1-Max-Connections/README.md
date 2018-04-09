# Tips #5
Solution to default connections/threads on Jboss as 7.1.1. Jboss as 7 has a default number of threads/connections by default. To bypass that limit use the max-connections parameter, on standalone.xml, connector tag.

Ex: max-connections="3000"

