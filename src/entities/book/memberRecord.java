package entities.book;

public class memberRecord {

    private Long memberId;
    private String type, dateOfMembership, name, address;
    private int noBooksIssued, maxBookLimit, phoneNo;

    public memberRecord(Long memberId, String type, String dateOfMembership, String name, String address, int phoneNo,
            int noBooksIssued, int maxBookLimit) {
        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.noBooksIssued = noBooksIssued;
        this.maxBookLimit = maxBookLimit;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getType() {
        return type;
    }

    public String getDateOfMembership() {
        return dateOfMembership;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public void metMember() {

    }

    public void incBookIssued() {

    }

    public void decBookIssued() {

    }

    public void payBill() {

    }
}
