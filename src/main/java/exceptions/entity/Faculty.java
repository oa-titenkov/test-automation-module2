package exceptions.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {

    private int id;
    private String name;
    private List<Group> groups;

    public Faculty(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Faculty(int id, String name, List<Group> groups) {
        this.id = id;
        this.name = name;
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id &&
                Objects.equals(name, faculty.name) &&
                Objects.equals(groups, faculty.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, groups);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}
