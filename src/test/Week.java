package test;

public enum  Week {
    SUNDAY("����һ"), MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    private String data;
    private Week(){
    }
    private Week(String data){
        this.setData(data);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
