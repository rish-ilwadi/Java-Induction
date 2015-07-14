package Library;
/*
 * package Library
 * imports java.lang package
 * public class Resource
 * 
 * Used for storing details of Resource
 */
public class Resource {
    
    /*
     * Data members
     */
	private String resourceName;
	private int resourceId;
	/*
	 * method: protected synchronized String getResourceName()
	 * takes no argument
	 * returns resourceName as String
	 * is synchronized
	 */
	protected synchronized String getResourceName(){
         
		int resourceId;
		resourceId=this.getResourceId();
		if (resourceId==this.resourceId){
			
			return this.resourceName;
		}
		return "";
	}
	
	/*
	 * method: protected synchronized int getResourceId()
	 * takes no argument
	 * returns resourceId as int
	 * is synchronized
	 */
	protected synchronized int getResourceId(){
		
		Thread.sleep(5000);
	    return this.resourceId;
		
	}
	/*
	 * method: public void setResourceName(String resourceName)
	 * returns nothing
	 * takes resourceName-String as argument
	 * 
	 * Used for setting value of resourceName
	 */
	public void setResourceName(String resourceName){
	
		this.resourceName=resourceName;
	}
	/*
	 * method: public void setResourceId(int resourceId)
	 * returns nothing
	 * takes resourceId-int as argument
	 * 
	 * Used for setting value of resourceId
	 */
	public void setResourceId(int resourceId){
		
		this.resourceId=resourceId;
	}
}
