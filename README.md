# SAT2-APCS
Aryan Bhatt, Sasha Fomina, Tim Wang
# Overall Design

Our HelpDesk is a driver file that uses an ArrayPriorityQueue of unresolved Tickets and an ArrayList of resolved Tickets to find() resolved tickets and track() unresolved tickets by ID numbers. HelpDesk also contains a solution bank from which the HelpDesk randomly chooses to generate() a solution for the next Ticket in line according to priority.

## Interacting With the User

                int setup() – Initial actions available to the user. Returns the number of the choice of action made by the user

                void action(int) – HelpDesk uses option number returned by setup to take appropriate action in interacting with the user

- Option 1: User can declare a problem to the HelpDesk.
  1. The Help desk asks the user to describe the problem
  2. Asks the user for their name
  3. Asks the user how urgent the problem is, which sets the priority of the Ticket
  4. Assigns user an ID number

- Option 2: User  can find an existing ticket and check on its
  1. Asks User for their ID number
  2. Reports back the ticket&#39;s info if it exits, and if it does not exit it alerts the user that it does not exist

- Option 3:  Wait a day to let the HelpDesk process tickets. The HelpDesk process one ticket a day.
  1. HelpDesk processes ticket of highest priority and generates as solution for it
  2. HelpDesk reports, giving the info of the Ticket that has just been processed and places it the ArrayList of resolved Tickets

- Option 4 : Exit

## Design Decisions

- HelpDesk randomly generates solutions from solution bank
- Linear search based on ID number in both track() and find()
- The user chooses when the HelpDesk processes a Ticket
