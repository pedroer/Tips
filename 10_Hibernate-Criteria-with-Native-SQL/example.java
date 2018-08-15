@Override
public List<Pesquisa> pesquisar(Pesquisa pesquisa) throws Exception {
		try {
			Session session = getEntityManager().unwrap(org.hibernate.Session.class);
			Criteria cr = session.createCriteria(Pesquisa.class);
			if(pesquisa!= null){
				if(pesquisa.getPalavraChave() != null && !"".equals(pesquisa.getPalavraChave())){
					//NATIVA SQL RESTRICTION EXAMPLE
					cr.add(Restrictions.sqlRestriction(" REGEXP_LIKE (UPPER(DS_PALAVRA_CHAVE),UPPER('"+pesquisa.getPalavraChave().replace(',', '|')+"'))"));
				}
				if(pesquisa.getTitulo() != null && !"".equals(pesquisa.getTitulo())){
					cr.add(Restrictions.ilike("titulo", pesquisa.getTitulo(), MatchMode.ANYWHERE));
				}
				if(pesquisa.getDsOrgaoFinanciador() != null && !"".equals(pesquisa.getDsOrgaoFinanciador())){
					cr.add(Restrictions.ilike("dsOrgaoFinanciador", pesquisa.getDsOrgaoFinanciador(), MatchMode.ANYWHERE));
				}
				if(pesquisa.getNmEstagioAtual() != null && !"".equals(pesquisa.getNmEstagioAtual())){
					cr.add(Restrictions.eq("nmEstagioAtual", pesquisa.getNmEstagioAtual()).ignoreCase());
				}
				if((pesquisa.getDtInicio() != null && !"".equals(pesquisa.getDtInicio()))&&(pesquisa.getDtTermino() != null && !"".equals(pesquisa.getDtTermino()))){
			
					cr.add(Restrictions.and(Restrictions.ge("dtInicio", pesquisa.getDtInicio()), Restrictions.le("dtTermino", pesquisa.getDtTermino())));
				}		
				
			}			
			cr.add(Restrictions.disjunction().add(Restrictions.eq("validacao", "V")).add(Restrictions.eq("validacao", "R")));
			cr.addOrder(Order.asc("titulo"));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Pesquisa> listaPesquisa = new ArrayList<Pesquisa>();
			listaPesquisa =  cr.list();
			
			return listaPesquisa;
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw e;
		}
	}