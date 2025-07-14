package Common;

public class CommonClassLibrary {
    public class Pair<T> {
        T first;
        T second;
        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
        public Pair() {}
    }

    public static class Tuple<T> {
        T first;
        T  second;
        T third;
        public Tuple(T first, T second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public Tuple() {}
    }
}
