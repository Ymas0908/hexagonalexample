package org.example.domain.model;

public class Articles {
    private Integer id;
    private String libelle;
    private Integer prix;
    private String description;
     private String Type;
     private  String Status;


    private Integer quantitedisponible;
    private String referenceArticle;



    public Articles(Integer id, String libelle, Integer prix, String description, Integer quantitedisponible , String Status, String referenceArticle, String Type) {
        this.id = id;
        this.libelle =libelle;
        this.prix = prix;
        this.description =description;
        this.Type = Type;
        this.Status = Status;
        this.quantitedisponible =quantitedisponible;
        this.referenceArticle =referenceArticle;
    }



    public Articles() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {

        this.description = description;
    }

    public String getReferenceArticle() {
        return referenceArticle;
    }

    public void setReferenceArticle(String referenceArticle) {
        this.referenceArticle = referenceArticle;
    }

    public Integer getQuantitedisponible() {
        return quantitedisponible;
    }
    public void setQuantitedisponible(Integer quantitedisponible) {
        this.quantitedisponible = quantitedisponible;
    }

    public Integer getPrix() {
        return prix;
    }
    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getType() {
        return Type;
    }
    public void setType(String Type) {
        this.Type = Type;
    }

    public String getStatus() {
        return Status;
    }
    public void setStatus(String Status) {
        this.Status = Status;
    }
}
