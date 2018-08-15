# Tips #9
Solution to default problem with order on Oracle using Jboss as 7.1.1 Datasource. Here the solution is applied when you need to order something like names with accent words like "Lélio".
This will put Lélio in the Order together with Leila for example.

Laila
Leila
Lélio
Luiz

Ex (Put inside Datasource Tag):
<new-connection-sql>
Begin
execute immediate('ALTER SESSION SET NLS_COMP=LINGUISTIC');
execute immediate('ALTER SESSION SET NLS_SORT=BINARY_AI');
end;
</new-connection-sql>

