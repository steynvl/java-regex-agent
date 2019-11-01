package za.ac.sun.cs.regexagent;

public class ConfigInfo {

    private String className;
    private String packageRef;
    private String method;
    private String toLog;

    public ConfigInfo(String className, String packageRef, String method, String toLog) {
        this.className = className;
        this.packageRef = packageRef;
        this.method = method;
        this.toLog = toLog;
    }

    public String getClassName() {
        return className;
    }

    public String getPackageRef() {
        return packageRef;
    }

    public String getMethod() {
        return method;
    }

    public String getToLog() {
        return toLog;
    }
}
