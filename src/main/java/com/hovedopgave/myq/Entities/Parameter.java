package com.hovedopgave.myq.Entities;

import javax.persistence.*;

@Entity
//@Table(name = "parameter",schema = "public")
//following line is for postgreSql
@Table(name = "parameter",schema = "polygon")
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "element_number")
    private int elementNumber;
    @Column(name = "polygon_calculate_method_id")
    private Long polygonCalculateMethodId;
    @Column(name = "time_resolution_id")
    private long timeResolutionId;
    @Column(name = "base_calculate_method_id")
    private Long baseCalculateMethodId;
    @Column(name = "parameter_type_id")
    private long parameterTypeId;
    @Column(name = "map_type")
    private String mapType;
    @Column(name = "unit_id")
    private Long unitId;
    @Column(name = "map_name")
    private String mapName;

    public Parameter() {
    }

    public Parameter(String name, long time_resolution_id) {
        this.name = name;
        this.timeResolutionId = time_resolution_id;
    }

    public Parameter(String name, int element_number, Long polygonCalculateMethodId, long time_resolution_id,
                     Long baseCalculateMethodId, long parameterTypeId, String mapType, Long unitId,
                     String mapName) {
        this.name = name;
        this.elementNumber = element_number;
        this.polygonCalculateMethodId = polygonCalculateMethodId;
        this.timeResolutionId = time_resolution_id;
        this.baseCalculateMethodId = baseCalculateMethodId;
        this.parameterTypeId = parameterTypeId;
        this.mapType = mapType;
        this.unitId = unitId;
        this.mapName = mapName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getElementNumber() {
        return elementNumber;
    }

    public Long getPolygonCalculateMethodId() {
        return polygonCalculateMethodId;
    }

    public long getTimeResolutionId() {
        return timeResolutionId;
    }

    public Long getBaseCalculateMethodId() {
        return baseCalculateMethodId;
    }

    public long getParameterTypeId() {
        return parameterTypeId;
    }

    public String getMapType() {
        return mapType;
    }

    public Long getUnitId() {
        return unitId;
    }

    public String getMapName() {
        return mapName;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", element_number=" + elementNumber +
                ", polygon_calculate_method_id=" + polygonCalculateMethodId +
                ", time_resolution_id=" + timeResolutionId +
                ", base_calculate_method_id=" + baseCalculateMethodId +
                ", parameter_type_id=" + parameterTypeId +
                ", map_type='" + mapType + '\'' +
                ", unit_id=" + unitId +
                ", map_name='" + mapName + '\'' +
                '}';
    }
}
