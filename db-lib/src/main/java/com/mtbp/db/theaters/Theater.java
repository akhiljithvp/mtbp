package com.mtbp.db.theaters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Document("theaters")
@AllArgsConstructor
@NoArgsConstructor
public class Theater {
    @Id
    private String id;
    @Version
    private long version;
    private String name;
    private Address address;
    private Set<String> screens;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;

    public void addScreen(String screenId) {
        if (screens == null) screens = new HashSet<>();
        screens.add(screenId);
    }

    public String findCity() {
        if (address != null) return address.getCity();
        else return null;
    }
}
