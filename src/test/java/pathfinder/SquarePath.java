package pathfinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SquarePath {
    List<Square> path;

    public SquarePath(List<Square> path) {
        this.path = path;
    }
    public SquarePath(String... squareNames) {
        path = new ArrayList<>();
        for (String sqName : squareNames) {
            path.add(Square.initialization(sqName));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquarePath that = (SquarePath) o;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return path.hashCode();
    }

    @Override
    public String toString() {
        return "SquarePath{" +
                "path=" + path +
                '}';
    }
}
