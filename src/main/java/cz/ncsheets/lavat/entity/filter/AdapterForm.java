package cz.ncsheets.lavat.entity.filter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdapterForm {
    private String name;
    private Double fromDiameter;
    private Double toDiameter;
    private Double fromLength;
    private Double toLength;
}
