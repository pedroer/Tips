# Tips #13
Solution to Jboss as 7.1.1 Auto Reconnect when a database connection is Lost.

Ex:
<validation>
	<check-valid-connection-sql>select 1 from dual</check-valid-connection-sql>
	<validate-on-match>false</validate-on-match>
	<background-validation>true</background-validation>
	<background-validation-millis>10000</background-validation-millis>
</validation>
