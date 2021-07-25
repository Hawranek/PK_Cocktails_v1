package pl.coderslab.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cocktails")
@Getter
@Setter
@ToString
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private String alcoholic;
    private String glass;
    private String instructions;
    private String drinkThumb;
    @ManyToMany
    private List<Ingredient> ingredients;
    private String imageSource;

}
