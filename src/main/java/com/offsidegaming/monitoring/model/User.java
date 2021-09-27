package com.offsidegaming.monitoring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.offsidegaming.monitoring.dto.UserDto;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String firstName;

    private String middleName;

    private String lastName;

    private String phone;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<GasMeter> gasMeters;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<ColdWaterMeter> coldWaterMeters;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<HotWaterMeter> hotWaterMeters;


    public static User toEntity (UserDto userDto){
        User user = new User();
        user.name = userDto.getName();
        user.firstName = userDto.getFirstName();
        user.middleName = userDto.getMiddleName();
        user.lastName = userDto.getLastName();
        user.phone = userDto.getPhone();
        return user;
    }

    public UserDto toDto() {
        UserDto userDto = new UserDto();
        userDto.setId(this.id);
        userDto.setName(this.name);
        userDto.setFirstName(this.firstName);
        userDto.setMiddleName(this.middleName);
        userDto.setLastName(this.lastName);
        userDto.setPhone(this.phone);
        return userDto;
    }

}
