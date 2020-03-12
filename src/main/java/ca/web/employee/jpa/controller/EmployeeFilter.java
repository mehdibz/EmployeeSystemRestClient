package ca.web.employee.jpa.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class EmployeeFilter implements Filter 
{
	private static final String COMMANDS_FILE = "/WEB-INF/classes/commands.properties";
	
	// Initial command
	private static final String SERVICE_INIT_ACTION = "service.getEmployees";
	private static Properties commandsProps;
		
	@Override
	public void init(FilterConfig filterConfig ) throws ServletException
	{
		commandsProps = new Properties();
		try 
		{
			commandsProps.load( new FileInputStream(filterConfig.getServletContext().getRealPath( COMMANDS_FILE ) ) );
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	};
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
			ServletException
	{
		
		String action = request.getParameter( "action" );
		Command c;
		try {
			c = getCommand( action );
			c.execute( (HttpServletRequest) request);
		} 
		catch (Exception e) 
		{

		}
		filterChain.doFilter(request, response);
	}
	
	
	@Override
	public void destroy() 
	{
		//TODO close DB connections etc.
	}
	
	
	@SuppressWarnings("deprecation")
	private Command getCommand(String action) throws Exception 
	{
		/* First time in, call initialisation command */
		if ( action == null ) 
		{
			action = SERVICE_INIT_ACTION;
		}
		
		/* Simple factory for the commands */
		String clazz = commandsProps.getProperty( action );
		Command command  = (Command) Class.forName( clazz ).newInstance();
		
		return command;	
	}
}
