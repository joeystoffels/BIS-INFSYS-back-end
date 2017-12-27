package nl.han.duo.gameparadise.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "my_view")
public class TestViewClass implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "my_view_id")
    private Long myViewId;

    @NotNull
    @Column(name = "my_view_name")
    private String myViewName;
}


