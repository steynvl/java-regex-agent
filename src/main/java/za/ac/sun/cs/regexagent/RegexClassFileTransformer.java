package za.ac.sun.cs.regexagent;

import java.io.IOException;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.List;

import javassist.NotFoundException;


/**
 *  @author peipei
 *  @author Steyn van Litsenborgh
 */
public class RegexClassFileTransformer implements ClassFileTransformer {

    private final String logName;

    public RegexClassFileTransformer(String logName) {
        this.logName = logName.endsWith(".log") ? logName : String.format("%s.log", logName);
    }

    @Override
    public byte[] transform(ClassLoader classLoader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] bytes) throws IllegalClassFormatException {
        ClassPool cp;
        CtClass cc;

        List<ConfigInfo> configs = Arrays.asList(
                new ConfigInfo("java/util/Pattern", "java.util.regex.Pattern",
                        "matches",
                        "\"\\\"Pattern matches(String regex, CharSequence input)---regex: \\\" + $1+\\\"---input: \\\"+$2+\\\"---#\\\"\""),

                new ConfigInfo("java/util/regex/Matcher", "java.util.regex.Matcher",
                        "matches",
                        "\"Matcher matches()---regex: \"+this.parentPattern+\"---input: \"+this.text+\"---#\""),

                new ConfigInfo("java/util/regex/String", "java.util.regex.String",
                        "matches",
                        "\"------String matches(String regex)---regex: \" + $1+\"---input: \"+this+\"---#\"")
        );

        for (ConfigInfo configInfo : configs) {
            if (className.equals(configInfo.getClassName())) {
                try {
                    cp = ClassPool.getDefault();
                    cc = cp.get(configInfo.getPackageRef());

                    CtMethod m = cc.getDeclaredMethod(configInfo.getMethod());
                    logInfo(m, configInfo.getToLog());

                    byte[] byteCode = cc.toBytecode();
                    cc.detach();
                    return byteCode;
                } catch (NotFoundException | IOException | CannotCompileException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    private void logInfo(CtMethod method, String string) throws CannotCompileException {
        System.out.printf("Logging info of java regex invocation [%s] [%s].\n", method, string);
        StringBuilder sb = new StringBuilder();

        sb.append( "try {" );
        sb.append("   java.io.OutputStreamWriter fw = new java.io.OutputStreamWriter(new java.io.FileOutputStream( \"").append(logName).append("\", true ), java.nio.charset.StandardCharsets.UTF_8);");
        sb.append( "   java.io.PrintWriter out = new java.io.PrintWriter(new java.io.BufferedWriter(fw));");
        sb.append("	java.lang.StackTraceElement[] stackTrace=java.lang.Thread.currentThread().getStackTrace();");
        sb.append("	for(int i=0;i<stackTrace.length;i++){");
        sb.append("		java.lang.StackTraceElement element=stackTrace[i];");
        sb.append("		String msg =\"Stack Trace from: \" + element.getMethodName()+\" in class: \" + element.getClassName() + \"[on line number: \"+ element.getLineNumber() + \" of file: \" + element.getFileName() + \"]\";");
        sb.append("		out.println(msg);");
        sb.append( "	}" );
        sb.append("   out.println(").append(string).append(");");
        sb.append( "   out.flush();" );
        sb.append( "   fw.close();" );
        sb.append( "   out.close();" );
        sb.append( "} catch (java.io.IOException e) {" );
        sb.append( "   e.printStackTrace();" );
        sb.append( "} catch (java.lang.Exception e) {" );
        sb.append( "   e.printStackTrace();throw e;" );
        sb.append( "}" );

        System.out.printf("Inserted: %s\n", sb);
        method.insertAfter(String.format("{%s;}", sb.toString()));
    }
}
