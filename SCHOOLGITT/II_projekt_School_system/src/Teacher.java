public class Teacher{

    private Name name;
    private Subject subject;

    public Teacher(Name name) {
        this.name = name;

    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return  "" + name
               ;
    }
}
