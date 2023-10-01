package lab1.task2;

import lab1.task2.Environment.LocationState;

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
		Environment env = new Environment(Environment.LocationState.CLEAN, Environment.LocationState.DIRTY,
				Environment.LocationState.CLEAN, Environment.LocationState.DIRTY);
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, Environment.LOCATION_C);

		env.stepUntilDone();
	}
}
