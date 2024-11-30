package by.tms.projectfootdairy.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DAYFACTS")
public class DayFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @NotNull
    public enum mealType {
        BREAKFAST, DINNER, SUPPER, MIDMEAL
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @NotNull
    private Integer productCount;

    @NotNull
    private Integer caloriesCount;

}
