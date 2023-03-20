package com.codegym.case_study.model.facility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer area;

    private Double cost;

    private Integer maxPeople;

    @ManyToOne
    @JoinColumn(name = "facility_type_id",nullable = false,referencedColumnName = "id")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name = "rent_type_id",nullable = false,referencedColumnName = "id")
    private RentType rentType;

    private String standardRoom;

    private String description;

    private Double poolArea;

    private Integer NumberOfFloors;

    private String facilityFree;

    @Column(name = "facility_status")
    private Boolean status;

    public Facility (Long id){
        this.id = id;
    }

    public Facility(String str) {
        this.id = Long.parseLong(str);
    }
}
