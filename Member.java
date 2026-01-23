public class Member {
    protected String memberId;  //<-- Unique identifier for the member (any string)
    protected String name;      //<-- Names of the member (full name)

    public Member(String memberId, String name) { //<-- Constructor
        this.memberId = memberId;
        this.name = name;
    }  
    //getter for attributes
    public String getMemberId() {
        return memberId;
    }   
    public String getName() {
        return name;
    }
}
