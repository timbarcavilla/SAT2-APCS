public class Ticket implements Comparable {
    private final int _priority;
    private String _descrip;
    private String _name;
    private boolean _resolved;
    private final int _id;

    
    public Ticket(int priority, String descrip, String name, boolean _resolved, int id ){
	_priority = priority;
	_description = descrip;
	_name = name;
	_resolved = false;
	_id = id;
	
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

    //-----------------------------------

    
}//end class Ticket
