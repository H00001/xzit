package new1.com.example.sql.data;

public class Account {
    private int id;
    private String name;
    private int math;
    private int english;
    private int _class;

    public Account() {
    }

    public Account(int id, String name, int math, int english, int _class) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.english = english;
        this._class = _class;
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

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int get_class() {
        return _class;
    }

    public void set_class(int _class) {
        this._class = _class;
    }
}
