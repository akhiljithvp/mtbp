package com.mtbp.db.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@Document("partners")
@AllArgsConstructor
@NoArgsConstructor
public class Partner {
    @Id
    private String id;
    @Version
    private long version;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Set<String> bankingInfos;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}