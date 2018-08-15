--GRANT ALL ORACLE
BEGIN
   FOR aTab IN (SELECT table_name FROM all_tables WHERE owner = 'MY_SCHEMA') LOOP
      execute IMMEDIATE 'GRANT ALL ON MY_SCHEMA.'||aTab.table_name||' TO MyUser_or_Role';
   END LOOP;
END;
/

BEGIN
   FOR aTab IN (SELECT sequence_name FROM all_sequences WHERE sequence_owner = 'MY_SCHEMA') LOOP
      execute IMMEDIATE 'GRANT SELECT ON MY_SCHEMA.'||aTab.sequence_name||' TO MyUser_or_Role';
   END LOOP;
END;
/