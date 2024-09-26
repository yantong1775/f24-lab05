package frogger;

/**
 * Refactor Task 1 & 2: Frogger
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22), Duan Liang (F23)
 */
public class Frogger {

    // Field for task 1.
    private final Road road;
    private int position;
    
    // Field for task 2. Anything to add/change?
    private final Records records;
    private FroggerID froggerID;

    public Frogger(Road road, int position, Records records, String firstName, String lastName, String phoneNumber,
    String zipCode, String state, String gender) {
        this.road = road;
        this.position = position;
        this.records = records;
        this.froggerID = new FroggerID(firstName, lastName, phoneNumber, zipCode, state, gender);
    }

    /**
     * Moves Frogger.
     *
     * @param forward true is move forward, else false.
     * @return true if move successful, else false.
     */
    public boolean move(boolean forward) {
        int nextPosition = this.position + (forward ? 1 : -1);
        if (!this.road.isValid(nextPosition) || this.road.isOccupied(nextPosition)) {
            return false;
        }
        this.position = nextPosition;
        return true;
    }

    // TODO: Do you notice any issues here?
    //  Anti Patern: feature envy Here

    // public boolean isOccupied(int position) {
    //     boolean[] occupied = this.road.getOccupied();
    //     return occupied[position];
    // }
    // // feature envy
    // public boolean isValid(int position) {
    //     if (position < 0) return false;
    //     boolean[] occupied = this.road.getOccupied();
    //     return position < occupied.length;
    // }

    /**
     * Records Frogger to the list of records.
     * 
     * @return true if record successful, else false.
     */
    public boolean recordMyself() {
      boolean success = records.addRecord(this.froggerID);
      return success;
    }

}
