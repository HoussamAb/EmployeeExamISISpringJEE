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
public class NormalEmployee extends Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne(fetch= FetchType.EAGER)
    private ManagerEmployee managerEmployee;

    public NormalEmployee(long id,String name,String address, String phone,int grade, int score, Departement departement,Remuneration remuneration, ManagerEmployee managerEmployee){
        super(id,name,address,phone,grade,score,departement,remuneration);
        this.managerEmployee = managerEmployee;
    }

    public NormalEmployee(long id) {
        this.id = id;
    }

    @Override
    public void setSousAdjacents(List<NormalEmployee> normalEmployeeList) {}

    @Override
    public void setManager(ManagerEmployee manager) {
        this.setManager(this.managerEmployee);
    }

    @Override
    public List<NormalEmployee> getNormalEmployees() {
        return null;
    }


    public ManagerEmployee getManagers() {
        return this.managerEmployee;
    }
}
