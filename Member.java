public abstract class Member {
    private final String id;
    private String name;
    private String type;
    private String mobileNumber;

    public Member(String id, String name, String type, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.mobileNumber = mobileNumber;
    }

    public String getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
    public String getMobileNumber() { 
        return mobileNumber; 
    }

    public String memberDetails() {
        return "Member ID: " + id + ", Name: " + name + ", Type: " + type + ", Mobile: " + mobileNumber;
    }
}