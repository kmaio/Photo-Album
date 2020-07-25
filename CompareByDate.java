import java.util.Comparator;

/**
 * Homework 4
 * Kaycie O'Boyle, ko2re
 *
 * Sources: TA office hours, lecture notes, Big Java Book
 */

public class CompareByDate implements Comparator<Photograph> {
	/**
	 * This class compares the dates of two photos. 
	 */
	public int compare(Photograph p1, Photograph p2) {
		String a =  p1.getDateTaken();
		String b = p2.getDateTaken();
	
		try
		{
			int aYear = Integer.parseInt(a.substring(0,4));
			int bYear = Integer.parseInt(b.substring(0,4));
			int aMonth = Integer.parseInt(a.substring(5,7));
			int bMonth = Integer.parseInt(b.substring(5,7));
			int aDay = Integer.parseInt(a.substring(8,10));
			int bDay = Integer.parseInt(b.substring(8,10));
			System.out.println(aYear + " "+aMonth+" "+aDay);
			if(aYear<bYear)
			{
				return -1;
			}
			else if(bYear<aYear)
			{
				return 1;
			}
			else
			{
				if(aMonth<bMonth)
				{
					return -1;
				}
				else if(bMonth<aMonth)
				{
					return 1;
				}
				else
				{
					if(aDay<bDay)
					{
						return -1;
					}
					else if(bDay<aDay)
					{
						return 1;
					}
					else
					{
						return 0;
					}
				}
			}
		}catch(Exception ex) {System.out.print("uh oh");}
		
		return -1;
	}
	

}