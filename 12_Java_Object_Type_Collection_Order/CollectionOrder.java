List<Object[]> data = whateverObjectListYouHave;

Collections.sort(data, new Comparator<Object[]>() {						
	public int compare(Object[] o1, Object[] o2) 
	{

		String x1 = (String) o1[0];
		String x2 = (String) o2[0];

		return x2.compareTo(x1);
	}
});

/*
whateverObjectListYouHave:
Example:

[
{
0 : "Peter",
1: 26
},
{
0 : "Jon",
1: 25
},
{
0 : "Mark",
1: 27
}
]
*/

/*
Output:
[
{
0 : "Jon",
1: 25
},
{
0 : "Mark",
1: 27
},
{
0 : "Peter",
1: 26
}
]
*/
