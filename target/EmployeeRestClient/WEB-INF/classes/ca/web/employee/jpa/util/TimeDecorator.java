package ca.web.employee.jpa.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.displaytag.decorator.TableDecorator;

import ca.web.employee.jpa.entity.Employee;

public class TimeDecorator extends TableDecorator 
{
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
	public String getDob()
	{
		String dob = ( (Employee ) ( this.getCurrentRowObject()) ).getDob();
		if ( dob==null )
		{
			return dateFormatter.format( new Date() );
		}
		
		return dob;
	}
	
	public Date dateConvertor(String date) throws ParseException 
	{
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date convertedDate = null;
		convertedDate = formatter.parse(date);
		return convertedDate;
	}
	
	public static String dateToString(Date date) throws ParseException 
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");  
		String strDate = dateFormat.format(date);
		return strDate;  
	}
}
