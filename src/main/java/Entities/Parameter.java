package Entities;

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
    private long polygon_calculate_method_id;
    private long time_resolution_id;
    private long base_calculate_method_id;
    private long parameter_type_id;
    private String map_type;
    private long unit_id;
    private String map_name;

    public Parameter() {
    }

    public Parameter(String name, int element_number, long polygon_calculate_method_id, long time_resolution_id,
                     long base_calculate_method_id, long parameter_type_id, String map_type, long unit_id,
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

    public long getPolygon_calculate_method_id() {
        return polygon_calculate_method_id;
    }

    public long getTime_resolution_id() {
        return time_resolution_id;
    }

    public long getBase_calculate_method_id() {
        return base_calculate_method_id;
    }

    public long getParameter_type_id() {
        return parameter_type_id;
    }

    public String getMap_type() {
        return map_type;
    }

    public long getUnit_id() {
        return unit_id;
    }

    public String getMap_name() {
        return map_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parameter)) return false;
        Parameter parameter = (Parameter) o;
        return getId() == parameter.getId() && getElement_number() == parameter.getElement_number() && getPolygon_calculate_method_id() == parameter.getPolygon_calculate_method_id() && getTime_resolution_id() == parameter.getTime_resolution_id() && getBase_calculate_method_id() == parameter.getBase_calculate_method_id() && getParameter_type_id() == parameter.getParameter_type_id() && getUnit_id() == parameter.getUnit_id() && getName().equals(parameter.getName()) && Objects.equals(getMap_type(), parameter.getMap_type()) && Objects.equals(getMap_name(), parameter.getMap_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getElement_number(), getPolygon_calculate_method_id(), getTime_resolution_id(), getBase_calculate_method_id(), getParameter_type_id(), getMap_type(), getUnit_id(), getMap_name());
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
