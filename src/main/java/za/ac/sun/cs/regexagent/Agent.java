package za.ac.sun.cs.regexagent;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String agentArgs, Instrumentation inst) {
        if (agentArgs != null) {
            inst.addTransformer(new RegexClassFileTransformer(agentArgs));
        } else {
            System.err.println("No log file specified, please provide as argument.");
        }
    }
}
