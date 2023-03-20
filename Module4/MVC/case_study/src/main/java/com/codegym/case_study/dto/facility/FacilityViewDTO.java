package com.codegym.case_study.dto.facility;

import com.codegym.case_study.model.employee.Division;
import com.codegym.case_study.model.employee.EducationDegree;
import com.codegym.case_study.model.employee.Position;
import com.codegym.case_study.model.facility.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.io.Serializable;


@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FacilityViewDTO implements Serializable {
    private Long id;
    private String nameService;

    public FacilityViewDTO (Facility facility){
        this.id = facility.getId();
        this.nameService = facility.getName();
    }
}
