package com.hovedopgave.myq.Entities;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "parameter",schema = "polygon")
public class Parameter {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int element_number;
    private Long polygon_calculate_method_id;
    private long time_resolution_id;
    private Long base_calculate_method_id;
    private long parameter_type_id;
    private String map_type;
    private Long unit_id;
    private String map_name;

    public Parameter() {
    }

    public Parameter(String name, int element_number, Long polygon_calculate_method_id, long time_resolution_id,
                     Long base_calculate_method_id, long parameter_type_id, String map_type, Long unit_id,
                     String map_name) {
        this.name = name;
        this.element_number = element_number;
        this.polygon_calculate_method_id = polygon_calculate_method_id;
        this.time_resolution_id = time_resolution_id;
        this.base_calculate_method_id = base_calculate_method_id;
        this.parameter_type_id = parameter_type_id;
        this.map_type = map_type;
        this.unit_id = unit_id;
        this.map_name = map_name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getElement_number() {
        return element_number;
    }

    public Long getPolygon_calculate_method_id() {
        return polygon_calculate_method_id;
    }

    public long getTime_resolution_id() {
        return time_resolution_id;
    }

    public Long getBase_calculate_method_id() {
        return base_calculate_method_id;
    }

    public long getParameter_type_id() {
        return parameter_type_id;
    }

    public String getMap_type() {
        return map_type;
    }

    public Long getUnit_id() {
        return unit_id;
    }

    public String getMap_name() {
        return map_name;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", element_number=" + element_number +
                ", polygon_calculate_method_id=" + polygon_calculate_method_id +
                ", time_resolution_id=" + time_resolution_id +
                ", base_calculate_method_id=" + base_calculate_method_id +
                ", parameter_type_id=" + parameter_type_id +
                ", map_type='" + map_type + '\'' +
                ", unit_id=" + unit_id +
                ", map_name='" + map_name + '\'' +
                '}';
    }
}
