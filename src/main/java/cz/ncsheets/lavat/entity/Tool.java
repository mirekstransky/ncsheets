package cz.ncsheets.lavat.entity;

import cz.ncsheets.lavat.constants.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = Constants.NOT_EMPTY)
    @NotNull(message = Constants.NOT_NULL)
    @NotBlank(message = Constants.NOT_NULL)
    private String name;

    @ManyToOne
    @JoinColumn(name = "tooltype_id")
    private Tooltype tooltype;
}
