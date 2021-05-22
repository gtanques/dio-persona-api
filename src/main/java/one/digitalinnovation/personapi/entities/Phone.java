package one.digitalinnovation.personapi.entities;

import lombok.Data;
import one.digitalinnovation.personapi.enums.PhoneTypeEnum;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_phone")
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneTypeEnum type;

    @Column(nullable = false, unique = true)
    private String number;
}
