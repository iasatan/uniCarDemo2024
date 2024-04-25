package hu.unimiskolc.java.halado.cardemo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="manufacturers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate founded;
    @OneToMany(mappedBy = "manufacturer")
    private List<Car> cars;

}
