public abstract class Member {
    private final String id;
    private String name;
    private String type;

    public Member(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }

    public String memberDetails() {
        return "Member ID: " + id + ", Name: " + name + ", Type: " + type;
    }
}