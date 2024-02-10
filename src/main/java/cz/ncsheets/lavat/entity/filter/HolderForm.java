package cz.ncsheets.lavat.entity.filter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HolderForm {
    private String name;
    private Double fromDiameter;
    private Double toDiameter;
    private Double fromLength;
    private Double toLength;
    private String size;
}
