package com.techindicium.desafiotechindicium.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Builder
@Document(collection = "categories")
public class CategoriesMongo {
    @Id
    String id;
    int category_id;
    String category_name;
    String description;
    byte[] picture;
}
