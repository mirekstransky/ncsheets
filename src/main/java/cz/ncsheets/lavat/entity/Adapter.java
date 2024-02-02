package cz.ncsheets.lavat.entity;
import cz.ncsheets.lavat.constants.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Adapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = Constants.NOT_EMPTY)
    @NotNull(message = Constants.NOT_NULL)
    @NotBlank(message = Constants.NOT_BLANK)
    @Size(min = Constants.SIZE_MIN, max = Constants.SIZE_MAX)
    private String name;

    @NotNull(message = Constants.NOT_NULL)
    @DecimalMin(value = Constants.DECIMAL_MIN, message = Constants.DECIMAL_MIN_MESSAGE)
    private double diameter;

    @NotNull(message = Constants.NOT_NULL)
    @DecimalMin(value = Constants.DECIMAL_MIN, message = Constants.DECIMAL_MIN_MESSAGE)
    private double length;

    public Adapter (Adapter adapter){
        this.name = adapter.getName();
        this.diameter = adapter.getDiameter();
        this.length = adapter.getLength();
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Adapter)) {
            return false;
        }
        Adapter adapter = (Adapter) o;
        return Objects.equals(name, adapter.name) && Objects.equals(diameter, adapter.diameter) && length == adapter.length;
    }

}
