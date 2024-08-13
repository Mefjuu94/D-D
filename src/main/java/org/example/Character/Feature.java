package org.example.Character;

import java.util.Objects;

public class Feature {

    private String featureName;

    public Feature(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return Objects.equals(featureName, feature.featureName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(featureName);
    }

    @Override
    public String toString() {
        return "Feature{" +
                "featureName='" + featureName + '\'' +
                '}';
    }
}
