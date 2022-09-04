package assignment.intro;

import java.util.ArrayList;
import java.util.List;

public class VersionManager {
    private Version currentVersion;
    private List<Version> previousVersions = new ArrayList<>();

    public VersionManager() {
        currentVersion = new Version();
        previousVersions.add(currentVersion);
    }

    public VersionManager(String version) {
        currentVersion = new Version(version);
    }
}
