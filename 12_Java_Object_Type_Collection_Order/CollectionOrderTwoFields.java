private List<Object[]> orderObjectType(List<Object[]> data, Boolean stOrder) {
		
		if (stOrder) {						
			Collections.sort(data, new Comparator<Object[]>() {
				public int compare(Object[] o1, Object[] o2) {
					
					Date x3 = (Date) o1[3];
					Date x4 = (Date) o2[3];
					int stComp = x3.compareTo(x4);										
					
					if(stComp != 0) {
						return stComp;
					}
					
					String x1 = (String) o1[0];
					String x2 = (String) o2[0];
					
					return x1.compareTo(x2) ;															
					
				}

			});
		} 
		else {
			Collections.sort(data, new Comparator<Object[]>() {
				public int compare(Object[] o1, Object[] o2) {
					
					String x1 = (String) o1[0];
					String x2 = (String) o2[0];
					int stComp = x1.compareTo(x2);
					
					if(stComp != 0) {
						return stComp;
					}
					
					Date x3 = (Date) o1[3];
					Date x4 = (Date) o2[3];

					return x3.compareTo(x4);
				}

			});			
		} 
		
		return data;
		
}