package assignment.q8;

import java.util.Objects;

class Manager {
    private final String name;

    public Manager(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        Manager manager = (Manager) o;
        return name.equals(manager.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
