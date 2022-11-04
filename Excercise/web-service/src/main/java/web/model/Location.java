package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private int id;
    private String name_location;
    private float temperature;
    private String weather;
}