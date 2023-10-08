package com.mtbp.db.theaters;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("screens")
@AllArgsConstructor
@NoArgsConstructor
public class Screen {
    @Id
    private String id;
    @Version
    private long version;
    private String name;
    private String showId;
    private SeatsInfo seats;
    @CreatedBy
    private String createdBy;

    @JsonIgnore
    public boolean isAvailable() {
        return showId == null;
    }
}