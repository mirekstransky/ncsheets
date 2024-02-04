package cz.ncsheets.lavat.entity;

import cz.ncsheets.lavat.constants.Constants;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = Constants.NOT_EMPTY)
    @NotNull(message = Constants.NOT_NULL)
    @NotBlank(message = Constants.NOT_BLANK)
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}\\s.+", message = "Need format: 0000-00-00 NAME")
    private String name;

    @NotEmpty(message = Constants.NOT_EMPTY)
    @NotNull(message = Constants.NOT_NULL)
    @NotBlank(message = Constants.NOT_BLANK)
    private String technologist;

    @NotEmpty(message = Constants.NOT_EMPTY)
    @NotNull(message = Constants.NOT_NULL)
    @NotBlank(message = Constants.NOT_BLANK)
    private String itemname;

}
