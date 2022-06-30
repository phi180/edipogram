package asw.edipogram.enigmi.domain.proxy.enums;

public enum ForwardMethod {

    MESSAGE("MESSAGE"),
    REST("REST"),
    REST_ASYNC("REST_ASYNC");

    ForwardMethod(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
