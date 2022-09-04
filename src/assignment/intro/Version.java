package assignment.intro;

public class Version {
    private int major;
    private int minor;
    private int patch;

    public Version() {
        major = 0;
        minor = 0;
        patch = 1;
    }

    public Version(String version) {
        String[] ver = version.split("\\.");
        if (ver.length == 1 && ver[0] == "") {
            patch = 1;
        } else if (ver.length == 1) {
            setMajor(toNumber(ver[0]));
        } else if (ver.length == 2) {
            setMajor(toNumber(ver[0]));
            setMinor(toNumber(ver[1]));
        } else {
            setMajor(toNumber(ver[0]));
            setMinor(toNumber(ver[1]));
            setPatch(toNumber(ver[2]));
        }
    }

    public Version(int major, int minor, int patch) {
        setMajor(major);
        setMinor(minor);
        setPatch(patch);
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        if (major < 0) {
            throw new IllegalArgumentException("Major can not be a negative number");
        } else {
            this.major = major;
        }
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        if (minor < 0) {
            throw new IllegalArgumentException("Minor can not be a negative number");
        } else {
            this.minor = minor;
        }
    }

    public int getPatch() {
        return patch;
    }

    public void setPatch(int patch) {
        if (patch < 0) {
            throw new IllegalArgumentException("Patch can not be a negative number");
        } else {
            this.patch = patch;
        }
    }

    private int toNumber(String s) {
        int num;
        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Can not convert string to a number!");
        }
        return num;
    }

    @Override
    public String toString() {
        return major + "." + minor + "." + patch;
    }
}
