public class HelpDesk implements Comparable<Ticket>{

    private ArrayPriorityQueue<Ticket> _queue;

    public HelpDesk(){
	_queue = new ArrayPriorityQueue<Ticket>();
    }

    public int compareTo(Ticket t){
	int retint = 0;
	if (this.getPriority() > t.getPriority())
	    return 1;
	else if (this.getPriority() < t.getPriority())
	    return -1;
	return 0;
    }
    
}//end class HelpDesk
