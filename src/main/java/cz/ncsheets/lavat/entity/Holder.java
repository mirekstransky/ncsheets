package cz.ncsheets.lavat.entity;

import cz.ncsheets.lavat.constants.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Columns;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Holder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = Constants.NOT_EMPTY)
    @NotNull(message = Constants.NOT_NULL)
    @NotBlank(message = Constants.NOT_BLANK)
    private String name;

    @NotNull
    @DecimalMin(value = Constants.DECIMAL_MIN ,message = Constants.DECIMAL_MIN_MESSAGE)
    private double diameter;

    @ManyToOne
    @NotNull(message = Constants.NOT_NULL)
    @JoinColumn(name = "holdersize_id")
    private Holdersize holderSize;

    @NotNull(message = Constants.NOT_NULL)
    @DecimalMin(value = Constants.DECIMAL_MIN,message = Constants.DECIMAL_MIN_MESSAGE)
    private double length;

}
