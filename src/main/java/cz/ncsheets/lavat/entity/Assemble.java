package cz.ncsheets.lavat.entity;

import cz.ncsheets.lavat.constants.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Assemble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = Constants.NOT_EMPTY)
    @NotNull(message = Constants.NOT_NULL)
    @NotBlank(message = Constants.NOT_BLANK)
    private String name;

    @NotNull(message = Constants.NOT_NULL)
    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @NotNull(message = Constants.NOT_NULL)
    @ManyToOne
    @JoinColumn(name = "adapter_id")
    private Adapter adapter;

    @NotNull(message = Constants.NOT_NULL)
    @ManyToOne
    @JoinColumn(name = "holder_id")
    private Holder holder;

    @NotNull(message = Constants.NOT_NULL)
    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool tool;

    @NotNull
    @Min(1)
    private int toolPosition;

    @NotNull(message = Constants.NOT_NULL)
    @DecimalMin(value = Constants.DECIMAL_MIN, message = Constants.DECIMAL_MIN_MESSAGE)
    private double toolLength;

    @NotNull(message = Constants.NOT_NULL)
    @DecimalMin(value = Constants.DECIMAL_MIN, message = Constants.DECIMAL_MIN_MESSAGE)
    private double compensation_x;

    @NotNull(message = Constants.NOT_NULL)
    @DecimalMin(value = Constants.DECIMAL_MIN, message = Constants.DECIMAL_MIN_MESSAGE)
    private double compensation_z;

}
