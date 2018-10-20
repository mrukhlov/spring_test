package demo.model;

public class Seller {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public Seller setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Seller setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "Seller[id=%d, name='%s']",
                id, name
        );
    }
}
