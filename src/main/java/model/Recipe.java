package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_recipe")
    private int id_recipe;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "preparetionMode")
    private String preparationMode;

    @Column(name = "notes")
    private String note;

    @Column(name = "category")
    private char category;

    @Column(name = "approved")
    private boolean status;

    @ManyToOne
    private RecipeOwner owner;

    public void setCategory(char category) {
        this.category = category;
    }

    public char getCategory() {
        return category;
    }

    public void setId_recipe(int id_recipe) {
        this.id_recipe = id_recipe;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setPreparationMode(String preparationMode) {
        this.preparationMode = preparationMode;
    }

    public String getPreparationMode() {
        return preparationMode;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setOwner(RecipeOwner owner) {
        this.owner = owner;
    }

    public RecipeOwner getOwner() {
        return owner;
    }

    @Override
    public long getId() {
        return id_recipe;
    }
}