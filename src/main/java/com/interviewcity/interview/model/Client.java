package com.interviewcity.interview.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@ApiModel(description = "Cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ApiModelProperty(notes = "Nome completo")
    private String name;
    @ApiModelProperty(notes = "M Masculino, F Feminino, O Outros")
    private int sex;
    @ApiModelProperty(notes = "Data de Nascimento")
    @Temporal(TemporalType.DATE)
    private Date birth;
    @ApiModelProperty(notes = "Idade do cliente")
    private int age;
    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city_id;
}
