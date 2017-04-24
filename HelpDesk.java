import userInput.Keyboard;
import java.util.ArrayList;

public class HelpDesk{

    private ArrayPriorityQueue<Ticket> _queue;
    private ArrayList<Ticket> _resolvedBin;
    private final String[] bunchOfSolution = {"Check your connection.", "Press that button thingy on your computer", "Reset the setting.", "Restart your computer", "Go to google.com and figure it out yourself.", "Consult the java API", "Consult NetLogo Dictionary", "Press Ctrl+Alt+Delete to open Task Manager.", "I don't know, I'm not that smart!", "Kill it with fire."};
    private int id;
    private static boolean _exit;

    public HelpDesk(){
	_queue = new ArrayPriorityQueue<Ticket>();
	_resolvedBin = new ArrayList<Ticket>();
	id = 10000;
	_exit = false;
    }

    //use to track tickets in the queue
    public Ticket track(int idNum){
	for (int x = 0; x < _queue.size(); x++){
	    if (_queue.get(x).getID() == idNum)
		return _queue.get(x);
	}
	return null;
    }

    //find resolved ticket in the resolved bin
    public Ticket find(int idNum){
	if (_resolvedBin.size() == 0)
	    return null;
	else{
	    for (Ticket each : _resolvedBin){
		if (each.getID() == idNum)
		    return each;
	    }
	    return null;
	}
    }

    //generate a solution
    public String generate(){
	int r = (int)(Math.random() * 9);
	return bunchOfSolution[r];
    }

    public int setup(){

	
	System.out.println("Hi there. This is The H E L P D E S K. How may I help you?");
	String msg = "";
	msg += "\t1) I have a problem.\n";
	msg += "\t2) I would like to find my ticket.\n";
	msg += "\t3) Wait a day.\n";
	msg += "\t4) Exit\n";

	System.out.println(msg);

	int mode = 0;
	while (mode == 0){
	    mode = Keyboard.readInt();
	    if (mode < 1 || mode > 4)
		mode = 0;
	}
	return mode;
    }
    
    public void action(int mode){

	if (mode == 1){
	    System.out.print("Describe your problem: ");
	    String descrip = Keyboard.readString();
	    System.out.print("\nWhat is your name? ");
	    String name = Keyboard.readString();
	    System.out.println("\nHow urgent is the problem, " + name + " ?");
	    String msg = "";
	    msg += "\t1) I AM THE QUEEN OF ENGLAND FIX THIS FOR ME\n";
	    msg += "\t2) Yes very\n";
	    msg += "\t3) A bit\n";
	    msg += "\t4) Take your time\n";
	    msg += "\t5) Don't worry too much I live in a tree anyway.";
	    System.out.println(msg);
	    int priority = Keyboard.readInt()-1;
	    Ticket newTik = new Ticket(priority,name,descrip,false,id);
	    _queue.add(newTik);
	    System.out.println("Submission completed. We will get back to you as soon as possible. Please copy down your ID# in order to track your ticket: " + id + ".");
	    id++;
	}
	
	else if (mode == 2){
	    System.out.println("Is your ticket resolved or still in the queue?");
	    String msg = "";
	    msg += "\t1) Resolved\n";
	    msg += "\t2) In the queue\n";
	    System.out.println(msg);
	    int choice = 0;
	    while (choice == 0){
		choice = Keyboard.readInt();
		if (choice < 1 || choice > 2)
		    choice = 0;
	    }
	    System.out.println("What's your ticket's ID?");
	    int yourID = Keyboard.readInt();
	    Ticket yourTik;
	    if (choice == 1)
		yourTik = find(yourID);
	    else
	        yourTik = track(yourID);
	    if (yourTik == null)
		System.out.println("No ticket with this ID exists!");
	    else
		System.out.println("Voila! Here's your ticket's info:\n" + yourTik);
	}

	else if (mode == 3){
	    System.out.println("A day passed...\nProcessing the next Ticket...100%");
	    if (_queue.isEmpty())
		System.out.println("Queue is Empty");
	    else{
		_queue.peekMin().setSolution(generate());
		System.out.println("\nThis ticket has been processed:\n" + _queue.peekMin());
		_resolvedBin.add(_queue.removeMin());
	    }
	}

	else if (mode == 4)
	    _exit = true;
    }
    

    public static void main(String[] args){

	HelpDesk h = new HelpDesk();
	while (!_exit){
	    int mode = h.setup();
	    h.action(mode);
	}
	System.out.println("Exiting...Have a good day.");
    }//end main
	
}//end class HelpDesk
