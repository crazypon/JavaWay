package CollectionsFramework.Basics;

public class StudentMarks implements Comparable<StudentMarks>{
    private Integer math;
    private Integer physics;

    public StudentMarks(Integer math, Integer physics) {
        this.math = math;
        this.physics = physics;
    }

    public Integer getMath() {
        return math;
    }

    public Integer getPhysics() {
        return physics;
    }

    @Override
    public int compareTo(StudentMarks o) {

        if(this.math > o.math) return -1;
        if(this.math < o.math) return 1;
        return 0;

        // you can rewrite it like this, but be careful since sometimes an overflow may occur
        // return this.math - o.math;
    }
}
