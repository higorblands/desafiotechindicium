package com.techindicium.desafiotechindicium.domain;

import com.techindicium.desafiotechindicium.models.CategoriesMongo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesMongoList {
    List<CategoriesMongo> categories;
}
