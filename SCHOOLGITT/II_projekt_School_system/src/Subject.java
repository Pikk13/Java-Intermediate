public enum Subject {
    GEOGRAPHY("FÖCI", new Teacher(new Name("István", "Raffai"))),
    HISTORY("TÖRI", new Teacher(new Name("Ágota", "Mészáros"))),
    MATH("MATEK", new Teacher(new Name("László", "Domonkos"))),
    BIOLOGY("BIGI", new Teacher(new Name("Tünde", "Ugri"))),
//    NONE(null, null )
    ;

    String name;
    Teacher teacher;

    Subject(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return
                " " + name;
    }
}
