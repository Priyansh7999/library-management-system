public abstract class Member {
    private final String memberId;
    private String name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { 
        return memberId; 
    }
    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }

    public String memberDetails() {
        return "Member ID: " + memberId + ", Name: " + name;
    }
}