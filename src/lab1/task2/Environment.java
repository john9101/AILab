package lab1.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lab1.task1.Environment.LocationState;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action UP = new DynamicAction("UP");
	public static final Action DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
	public static final String LOCATION_D = "D";

	public enum LocationState {
		CLEAN, DIRTY
	}

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState, LocationState locCState,
			LocationState locDState) {
		envState = new EnvironmentState(locAState, locBState, locCState, locDState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		this.agent = agent;
		envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		String currentLocation = envState.getAgentLocation();
		if (action == SUCK_DIRT) {
			envState.setLocationState(envState.getAgentLocation(), LocationState.CLEAN);
		} else if (action == MOVE_LEFT) {
			envState.setAgentLocation(getLeftLocation(currentLocation));
		} else if (action == MOVE_RIGHT) {
			envState.setAgentLocation(getRightLocation(currentLocation));
		} else if (action == UP) {
			envState.setAgentLocation(getUpLocation(currentLocation));
		} else if (action == DOWN) {
			envState.setAgentLocation(getDownLocation(currentLocation));
		}
		return envState;
	}

	private String getLeftLocation(String currentLocation) {
		if (currentLocation == LOCATION_B) {
			return LOCATION_A;
		} else if (currentLocation == LOCATION_C) {
			return LOCATION_D;
		}
		return currentLocation;
	}

	private String getRightLocation(String currentLocation) {
		if (currentLocation == LOCATION_A) {
			return LOCATION_B;
		} else if (currentLocation == LOCATION_D) {
			return LOCATION_C;
		}
		return currentLocation;
	}

	private String getUpLocation(String currentLocation) {
		if (currentLocation == LOCATION_C) {
			return LOCATION_B;
		} else if (currentLocation == LOCATION_D) {
			return LOCATION_A;
		}
		return currentLocation;
	}

	private String getDownLocation(String currentLocation) {
		if (currentLocation == LOCATION_A) {
			return LOCATION_D;
		} else if (currentLocation == LOCATION_B) {
			return LOCATION_C;
		}
		return currentLocation;
	}

	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		return new Percept(envState.getAgentLocation(), envState.getLocationState(envState.getAgentLocation()));
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);

		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_C) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_D) == LocationState.CLEAN))
			isDone = true;// if both squares are clean, then agent do not need to do any action
		es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
}
