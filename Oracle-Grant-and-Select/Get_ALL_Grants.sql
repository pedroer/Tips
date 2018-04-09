--Get All Grants
SELECT *
FROM
  (SELECT 'GRANT '
    ||privilege
    ||' TO '
    ||grantee
    ||';'
  FROM dba_sys_privs
  WHERE grantee IN ('USER_OR_ROLE')
  UNION ALL
  SELECT 'grant '
    ||privilege
    ||' on '
    ||grantor
    ||'.'
    ||table_name
    ||' to '
    ||grantee
    ||';'
  FROM dba_tab_privs
  WHERE grantee IN ('USER_OR_ROLE')
  UNION ALL
  SELECT 'GRANT '
    ||GRANTED_ROLE
    ||' TO '
    ||grantee
    ||';'
  FROM dba_role_privs
  WHERE grantee IN ('USER_OR_ROLE')
  );