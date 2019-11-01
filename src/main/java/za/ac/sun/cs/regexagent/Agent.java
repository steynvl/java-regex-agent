package za.ac.sun.cs.regexagent;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("java-regex-agent in premain.");
        if (agentArgs != null) {
            System.out.printf("Will log results to '%s'.\n", agentArgs);
            inst.addTransformer(new RegexClassFileTransformer(agentArgs));
        } else {
            System.err.println("No log file specified, please provide as argument.");
        }
    }
}
