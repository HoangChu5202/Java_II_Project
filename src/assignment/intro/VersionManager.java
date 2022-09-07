package assignment.intro;

import java.util.ArrayList;
import java.util.List;

public class VersionManager {
    private Version currentVersion;
    private List<Version> previousVersions = new ArrayList<>();

    public VersionManager() {
        currentVersion = new Version();
        //previousVersions.add(currentVersion);
    }

    public VersionManager(String version) {
        currentVersion = new Version(version);
    }

    public VersionManager major() {
        previousVersions.add(currentVersion);
        currentVersion = new Version(currentVersion.getMajor() + 1, 0, 0);
        return this;
    }

    public VersionManager minor() {
        previousVersions.add(currentVersion);
        currentVersion = new Version(currentVersion.getMajor(), currentVersion.getMinor() + 1, 0);
        return this;
    }

    public VersionManager patch() {
        previousVersions.add(currentVersion);
        currentVersion = new Version(currentVersion.getMajor(), currentVersion.getMinor(), currentVersion.getPatch() + 1);
        return this;
    }

    public VersionManager rollback() {
        if (previousVersions.size() < 1) {
            throw new IllegalArgumentException("Cannot rollback!");
        } else {
            currentVersion = previousVersions.get(previousVersions.size()-1);
            previousVersions.remove(previousVersions.size()-1);
        }
        return this;
    }

    public String release() {
        return currentVersion.toString();
    }
}
