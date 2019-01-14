package pl.coderslab.model;


import javax.persistence.*;

@Entity
@Table(name = "priorities")
public class Priority {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean activity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }


    @Override
    public String toString() {
        return "Priority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activity=" + activity +
                '}';
    }






}