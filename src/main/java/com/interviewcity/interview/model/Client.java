package com.interviewcity.interview.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
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
    @ApiModelProperty(notes = "0 Masculino, 1 Feminino, 2 Outros")
    private int sex;
    @ApiModelProperty(notes = "Data de Nascimento")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private Date birth;
    @ApiModelProperty(notes = "Idade do cliente")
    private int age;
    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;
}
