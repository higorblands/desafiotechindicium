package com.techindicium.desafiotechindicium.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categories implements Serializable {
    @Id
    int category_id;
    String category_name;
    String description;
    byte[] picture;

}
