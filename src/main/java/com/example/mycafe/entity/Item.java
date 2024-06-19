package com.example.mycafe.entity;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
@Document(indexName = "item")
//@Mapping(mappingPath = "static/elastic-mapping.json")
//@Setting(settingPath = "static/elastic-token.json")
public class Item {
    @Id
    @org.springframework.data.annotation.Id
    @Field(name = "id", type = FieldType.Keyword)
    private String itemId;

    @Field(name = "name", type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private String category;

    @Field(type = FieldType.Integer)
    private int price;
}
