package com.employees.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ManagerEmployee extends Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<NormalEmployee> normalEmployees;

    public ManagerEmployee(long id,String name,String address, String phone,int grade, int score, Departement departement,Remuneration remuneration,List<NormalEmployee> normalEmployeeList){
        super(id,name,address,phone,grade,score,departement,remuneration);
        this.setSousAdjacents(normalEmployeeList);
    }

    @Override
    public void setSousAdjacents(List<NormalEmployee> normalEmployeeList) {
        this.setSousAdjacents(this.normalEmployees);
    }

    @Override
    public void setManager(ManagerEmployee manager) {

    }


    @Override
    public List<NormalEmployee> getNormalEmployees() {
        return null;
    }

}
