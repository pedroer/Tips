# Tips #10
Solution to use Native SQL with Hibernate Criteria. In this case was used a Restriction with a Regex.

Ex:
	Session session = getEntityManager().unwrap(org.hibernate.Session.class);
	Criteria cr = session.createCriteria(Pesquisa.class);
	cr.add(Restrictions.sqlRestriction(" REGEXP_LIKE (UPPER(DS_PALAVRA_CHAVE),UPPER('"+pesquisa.getPalavraChave().replace(',', '|')+"'))"));
