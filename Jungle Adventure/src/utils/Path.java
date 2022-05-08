package utils;

import java.util.Objects;

public class Path {

    private String path;

    public Path(String path) {
        this.path = OSDetector.stringPathFormater(path);
    }


    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Path)) {
            return false;
        }
        Path pathObject = (Path) o;
        return Objects.equals(pathObject, path);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(path);
    }
    
}
