package cz.ncsheets.lavat.entity;

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

    @NotEmpty
    @NotNull
    @NotBlank(message = "Subject cannot be blank")
    private String name;

    @NotNull
    @DecimalMin(value = "1.0",message = "Subject must be greater than 1")
    private double diameter;

    @ManyToOne
    @JoinColumn(name = "holdersize_id")
    private Holdersize holderSize;

    @NotNull
    @DecimalMin(value = "1.0",message = "Subject must be greater than 1")
    private double length;

}
