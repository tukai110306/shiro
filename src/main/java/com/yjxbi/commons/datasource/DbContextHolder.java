package com.yjxbi.commons.datasource;

public class DbContextHolder {
	
	private static final ThreadLocal contextHolder = new ThreadLocal(); 
	
	private static final String SLAVE = "slave";
	
	public static void setDbType(String dbType) {   
        contextHolder.set(dbType);
    }   
  
    public static String getDbType() {   
        return SLAVE+contextHolder.get()+"";  
    }   
  
    public static void clearDbType() {   
        contextHolder.remove();   
    }
}
