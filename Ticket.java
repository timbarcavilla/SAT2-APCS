public class Ticket implements Comparable<Ticket> {
    private int _priority;
    private String _descrip;
    private String _name;
    private boolean _resolved;
    private String _solution;

    //final bc it should only be set once 
    private final int _id;

    
    public Ticket(int priority, String descrip, String name, boolean _resolved, int id ){
	_priority = priority;
	_descrip = descrip;
	_name = name;
	_resolved = false;
	_id = id;
	_solution = "N/A";
	
    }

    //-------------ACCESSORS-------------

    public int getPriority(){ return _priority; }
    public String getDescrip(){ return _descrip; }
    public String getName(){ return _name; }
    public boolean isResolved(){ return _resolved; }
    public int getID(){ return _id; }
    
    //-----------------------------------

    //-------------MUTATORS--------------

    public void resolve(){ _resolved = true; }
    public void setSolution(String solve){ _solution = solve; }

    //-----------------------------------


    //toString
    public String toString(){
	String retstr = "";
	retstr += "=========================================\n";
	retstr += "Name: " + _name + "\n";
	retstr += "Description: " + _descrip + "\n";
	retstr += "ID#: " + _id + "\n";
	retstr += "Solution: " + _solution + "\n";
	return retstr;
    }

    //compares based on _priority 
    public int compareTo(Ticket t){
	if (this.getPriority() > t.getPriority())
	    return 1;
	
	else if (this.getPriority() < t.getPriority())
	    return -1;

	return 0;
    }
    
}//end class Ticket
