package lab1.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lab1.task2.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		List<Action> possibleActions = new ArrayList<Action>();
		Random rd = new Random();
		if (p.getLocationState() == LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		}

		if (p.getAgentLocation() == Environment.LOCATION_A) {
			possibleActions.add(Environment.MOVE_RIGHT);
			possibleActions.add(Environment.DOWN);
		} else if (p.getAgentLocation() == Environment.LOCATION_B) {
			possibleActions.add(Environment.MOVE_LEFT);
			possibleActions.add(Environment.DOWN);
		} else if (p.getAgentLocation() == Environment.LOCATION_C) {
			possibleActions.add(Environment.MOVE_LEFT);
			possibleActions.add(Environment.UP);
		} else if (p.getAgentLocation() == Environment.LOCATION_D) {
			possibleActions.add(Environment.MOVE_RIGHT);
			possibleActions.add(Environment.UP);
		} else {
			return NoOpAction.NO_OP;
		}
		
		int randomDirected = rd.nextInt(possibleActions.size());
		return possibleActions.get(randomDirected);
	}
}