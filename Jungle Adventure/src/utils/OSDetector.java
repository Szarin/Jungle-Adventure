package utils;

/**
 * {@code OSDetector} is a util class to detect which Operating System
 * is used in this session.
 * <p>
 * The only three possibility are Windows, MacOS and Linux.
 * 
 * @author  Guillaume Schneider
 * @version 1.0
 * @since   2021-04-12
 */
public class OSDetector {

    private static String OS = System.getProperty("os.name").toLowerCase();

    private OSDetector() {}

    public static boolean isWindows() {
        return OS.contains("win");
    }
 
    public static boolean isMac() {
        return OS.contains("mac");
    }
 
    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }
 
    public static boolean isSolaris() {
        return OS.contains("sunos");
    }

    public static String getOS(){
        if (isWindows()) {
            return "win";
        } else if (isMac()) {
            return "osx";
        } else if (isUnix()) {
            return "uni";
        } else if (isSolaris()) {
            return "sol";
        } else {
            return "err";
        }
    }

    public static String stringPathFormater(String path) {
        String currentOS = getOS();

        if(currentOS == "osx" || currentOS == "unix") {
            if(path.contains("\\"))
                return path.replace("\\", "/");
            else return path;
        }
        if(currentOS == "win") {
            if (path.contains("/")) 
                return path.replace("/", "\\");
            else return path;
        }
        
        return null;
    }
    
}
